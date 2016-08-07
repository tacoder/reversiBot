package com.rbot.core.directional;

public enum Directions {
	NORTH(new Velocity(VelocityMagnitudes.ONE,VelocityMagnitudes.ZERO)),
	NORTHEAST(new Velocity(VelocityMagnitudes.ONE,VelocityMagnitudes.MINUSONE)),
	EAST(new Velocity(VelocityMagnitudes.MINUSONE,VelocityMagnitudes.ZERO)),
	SOUTHEAST(new Velocity(VelocityMagnitudes.MINUSONE,VelocityMagnitudes.MINUSONE)),
	SOUTH(new Velocity(VelocityMagnitudes.ZERO,VelocityMagnitudes.MINUSONE)),
	SOUTHWEST(new Velocity(VelocityMagnitudes.ONE,VelocityMagnitudes.MINUSONE)),
	WEST(new Velocity(VelocityMagnitudes.ZERO,VelocityMagnitudes.ONE)),
	NORTHWEST(new Velocity(VelocityMagnitudes.ONE,VelocityMagnitudes.ONE));
	
	Velocity vel;

	private Directions(Velocity vel) {
		this.vel = vel;
	}

}
