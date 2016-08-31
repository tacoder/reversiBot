package com.rbot.core.directional;

import java.util.Arrays;
import java.util.List;

public enum Direction {
	NORTH    (new Velocity(VelocityMagnitudes.ZERO,     VelocityMagnitudes.MINUSONE)),
	EAST     (new Velocity(VelocityMagnitudes.ONE,      VelocityMagnitudes.ZERO)),
	WEST     (new Velocity(VelocityMagnitudes.MINUSONE, VelocityMagnitudes.ZERO)),
	SOUTH    (new Velocity(VelocityMagnitudes.ZERO,     VelocityMagnitudes.ONE)),
	SOUTHEAST(new Velocity(VelocityMagnitudes.ONE,      VelocityMagnitudes.ONE)),
	NORTHEAST(new Velocity(VelocityMagnitudes.ONE,      VelocityMagnitudes.MINUSONE)),
	SOUTHWEST(new Velocity(VelocityMagnitudes.MINUSONE, VelocityMagnitudes.ONE)),
	NORTHWEST(new Velocity(VelocityMagnitudes.MINUSONE, VelocityMagnitudes.MINUSONE));
	
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
		throw new Exception("Invalid Velocity." + vel2);
	}

	public static List<Direction> getListOfAllDirections() {
		return Arrays.asList(Direction.values());
	}

}
