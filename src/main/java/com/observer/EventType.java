package com.observer;

public enum EventType {

	SHANGKE,STUDY,EATFOOD,PLAY,SLEEP;
	
	@Override
	public String toString() {
	   return this.name().toLowerCase();
	}
	
}
