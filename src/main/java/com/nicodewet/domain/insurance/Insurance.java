package com.nicodewet.domain.insurance;

public class Insurance {

	private DestinationType destinationType = DestinationType.AUSTRALIA_PACIFIC_ISLANDS;

	public Insurance() {
		super();
	}

	public DestinationType getDestinationType() {
		return destinationType;
	}

	public void setDestinationType(DestinationType destinationType) {
		this.destinationType = destinationType;
	}

	@Override
	public String toString() {
		return "Insurance [destinationType=" + destinationType + "]";
	}
}
