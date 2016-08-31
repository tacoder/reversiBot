package com.rbot.core.directional;

import java.util.Arrays;
import java.util.List;

public enum VelocityMagnitudes {
	ONE(1),
	ZERO(0),
	MINUSONE(-1);
	
	Integer velocity;

	private VelocityMagnitudes(Integer velocity) {
		this.velocity = velocity;
	}

	public Integer getVelocity() {
		return velocity;
	}

	public void setVelocity(Integer velocity) {
		this.velocity = velocity;
	}

	public static VelocityMagnitudes getVelocityMagnitudeByInteger(Integer xVel) throws Exception {
		List<VelocityMagnitudes> magList = getAllVelovityMagnitudes();
		for(VelocityMagnitudes mag : magList){
			if(mag.getVelocity().equals(xVel)){
				return mag;
			}
		}
		throw new Exception("Invalid Magnitude.");
	}

	public static List<VelocityMagnitudes> getAllVelovityMagnitudes() {
		return Arrays.asList(VelocityMagnitudes.values());
	}
	
}
