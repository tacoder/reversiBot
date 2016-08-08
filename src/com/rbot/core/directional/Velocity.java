package com.rbot.core.directional;

public class Velocity {
	private VelocityMagnitudes xVelocity;
	private VelocityMagnitudes yVelocity;
    
	public Velocity(VelocityMagnitudes xVelocity, VelocityMagnitudes yVelocity) {
		super();
		this.xVelocity = xVelocity;
		this.yVelocity = yVelocity;
	}

	public VelocityMagnitudes getxVelocity() {
		return xVelocity;
	}

	public void setxVelocity(VelocityMagnitudes xVelocity) {
		this.xVelocity = xVelocity;
	}

	public VelocityMagnitudes getyVelocity() {
		return yVelocity;
	}

	public void setyVelocity(VelocityMagnitudes yVelocity) {
		this.yVelocity = yVelocity;
	}
	
	public boolean equals(Velocity v){
		return (v.getxVelocity().equals(xVelocity) && v.getyVelocity().equals(yVelocity));
	}
	
	public String toString(){
		return "[ " + xVelocity + "," + yVelocity + " ]";
	}
}
