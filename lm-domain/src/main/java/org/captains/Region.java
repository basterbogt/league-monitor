package org.captains;

public enum Region {
	EUW ("euw"), //Europe West
	NA ("na"), // North America
	BR ("br"), // Brazil
	EUNE ("eune"), //Europe Nordic & East
	LAN ("lan"), //Latin America North
	LAS ("las"), //Latin America South
	OCE ("oce"), //Oceania
	RU ("ru"), //Russia
	TR ("tr"), //Turkey
	SEA ("sea"), //South east Asia
	KR ("kr"), //Republic of Korea
	PBE ("pbe"); //Public Beta Environment
	
	private final String name;
	
	private Region(String _name){
		name = _name;
	}
	
	public String Name(){
		return name;
	}
	
}
