package com.rbot.core.directional;

public enum VelocityMagnitudes {
	ONE(1),
	ZERO(0),
	MINUSONE(-1);
	
	Integer velocity;

	private VelocityMagnitudes(Integer velocity) {
		this.velocity = velocity;
	}
	
}
