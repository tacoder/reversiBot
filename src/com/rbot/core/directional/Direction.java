package com.rbot.core.directional;

import java.util.Arrays;
import java.util.List;

public enum Direction {
	NORTH    (new Velocity(VelocityMagnitudes.ONE,     VelocityMagnitudes.ZERO)),
	NORTHEAST(new Velocity(VelocityMagnitudes.ONE,     VelocityMagnitudes.MINUSONE)),
	EAST     (new Velocity(VelocityMagnitudes.MINUSONE,VelocityMagnitudes.ZERO)),
	SOUTHEAST(new Velocity(VelocityMagnitudes.MINUSONE,VelocityMagnitudes.MINUSONE)),
	SOUTH    (new Velocity(VelocityMagnitudes.ZERO,    VelocityMagnitudes.MINUSONE)),
	SOUTHWEST(new Velocity(VelocityMagnitudes.ONE,     VelocityMagnitudes.MINUSONE)),
	WEST     (new Velocity(VelocityMagnitudes.ZERO,    VelocityMagnitudes.ONE)),
	NORTHWEST(new Velocity(VelocityMagnitudes.ONE,     VelocityMagnitudes.ONE));
	
	Velocity vel;

	private Direction(Velocity vel) {
		this.vel = vel;
	}

	public Velocity getVel() {
		return vel;
	}

	public void setVel(Velocity vel) {
		this.vel = vel;
	}

	public static Direction getDirectionByVelocity(Velocity vel2) throws Exception {
		List<Direction> magList = getListOfAllDirections();
		for(Direction mag : magList){
			if(mag.getVel().equals(vel2)){
				return mag;
			}
		}
		throw new Exception("Invalid Velocity.");
	}

	public static List<Direction> getListOfAllDirections() {
		return Arrays.asList(Direction.values());
	}

}
