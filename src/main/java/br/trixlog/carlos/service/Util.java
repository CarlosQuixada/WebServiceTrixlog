package br.trixlog.carlos.service;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

import br.trixlog.carlos.model.Coordenada;
import br.trixlog.carlos.model.Parada;
import br.trixlog.carlos.model.Rota;
import sun.misc.BASE64Encoder;

@Service
public class Util {

	public Rota gerarRota(Rota rota) {
		rota.setPath(calculaPath(rota.getPath()));
		rota.setStops(gerarParadas(rota.getPath()));
		Date data = new Date(System.currentTimeMillis());
		rota.setRouteDate(data);
		return rota;
	}

	private double getDistancia(Coordenada pontoA, Coordenada pontoB) {
		double deltaX = pontoA.getLat() - pontoB.getLat();
		double deltaY = pontoA.getLng() - pontoB.getLng();

		double distancia = Math.sqrt((deltaX * deltaX) + (deltaY * deltaY));

		return distancia;
	}

	private List<Coordenada> calculaPath(List<Coordenada> path) {
		for (int i = 0; i < path.size() - 1; i++) {
			double menorDistancia = 99999;
			for (int j = i + 1; j < path.size(); j++) {
				double dist = getDistancia(path.get(i), path.get(j));
				if (dist < menorDistancia) {
					menorDistancia = dist;
					Coordenada aux = path.get(i + 1);
					path.set(i + 1, path.get(j));
					path.set(j, aux);
				}
			}
		}
		return path;
	}

	private List<Parada> gerarParadas(List<Coordenada> path) {
		List<Parada> stops = new ArrayList<>();
		GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyBonU0bsivmZyLl-xR8ZmDLwOvHitGeSZ4");

		for (Coordenada coord : path) {
			Parada stop = new Parada();
			LatLng location = new LatLng(coord.getLat(), coord.getLng());
			GeocodingResult[] result;
			try {
				result = GeocodingApi.reverseGeocode(context, location).await();
				
				System.out.println(result[0].formattedAddress);

				stop.setName(result[0].formattedAddress);
				stop.setPosition(coord);

				stops.add(stop);
			} catch (ApiException | InterruptedException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return stops;
	}
	
	public String criptografar(String senha) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(senha.getBytes());
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(md.digest());
		} catch (NoSuchAlgorithmException ns) {
			ns.printStackTrace();
		}
		return senha;
	}
}
