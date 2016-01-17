package org.captains;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.MessageFormat;
import java.util.stream.Collectors;

import com.google.gson.Gson;

public class FetchSummoners {

	private String version = "v1.4";
	private String key = "993e944b-73ee-4ab4-9481-b3e7f127dd03";
	
	/**
	 * Create a summoner object by using the summoners name and region.
	 * @param name Requested summoners name.
	 * @param region Requested summoners region.
	 * @return Requested summoner.
	 */
	public Summoner ByName(String name, Region region) {
		String url = MessageFormat.format("https://{0}.api.pvp.net/api/lol/{0}/{1}/summoner/by-name/{2}?api_key={3}", region.Name(), version, name, key);
		return ProcessJSON(url);
	}

	/**
	 * Create a summoner object by using the summoners id and region.
	 * @param id Requested summoners id.
	 * @param region Requested summoners region.
	 * @return Requested summoner.
	 */
	public Summoner ByID(int id, Region region) {
		String url = MessageFormat.format("https://{0}.api.pvp.net/api/lol/{0}/{1}/summoner/{2}?api_key={3}", region.Name(), version, id, key);
		return ProcessJSON(url);
	}
	
	/**
	 * Generate a summoner class based on the given url string
	 * @param url String with a request to riots API servers
	 * @return The requested summoners information in a Summoner object.
	 */
	private Summoner ProcessJSON(String url){
		String json;
		try {
			json = GetJSON(new URL(url));
			Gson g = new Gson();
			return g.fromJson(json, Summoner.class);
		} catch (Exception e) {
			//TODO: Throw proper exception
			return new Summoner();
		}
	}

	/**
	 * Get the requested information from Riot's servers
	 * @param url Requested URL.
	 * @return A JSON string containing the requested information
	 * @throws IOException Exception in case there was a failure getting the requested information
	 */
	private String GetJSON(URL url) throws IOException {
		URLConnection conn = url.openConnection();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"))) {
			return reader.lines().collect(Collectors.joining("\n"));
		}
	}

}
