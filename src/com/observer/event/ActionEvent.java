package com.observer.event;

public enum ActionEvent {
	WAKEUP,FEED,PLAY,SLEEP;
	
	 @Override
	  public String toString() {
	    return this.name().toLowerCase();
	  }
}
