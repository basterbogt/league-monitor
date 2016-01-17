package org.captains;

import com.google.gson.Gson;

public class Summoner {

	private String name;
	private int id;
	private int profileIconId;
	private int summonerLevel;
	private long revisionDate;

	public Summoner(){
		name = "Unknown";
	}
	

    @Override
    public String toString() {
        return name + " - " + id + " - " + profileIconId + " - " + summonerLevel + " - " + revisionDate;
    }
    
	public String toJSON() {
		Gson g = new Gson();
		return g.toJson(this);
	}


}
