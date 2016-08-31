package com.rbot.core.directional;

import com.rbot.core.model.Board;

public class Coordinates {
	private Integer y;
	private Integer x;
	public Integer getX() {
		return x;
	}
	public void setX(Integer column) {
		this.x = column;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer row) {
		this.y = row;
	}
	public Coordinates(Integer row, Integer column) {
		super();
		this.y = row;
		this.x = column;
	}
	
	public Coordinates(Coordinates a) {
		this.y = a.getY();
		this.x = a.getX();
	}
	public Boolean addUnitInDirection(Direction direction) {
		if(isMoveInDirectionPossible(direction)){
			x += direction.getVel().getxVelocity().getVelocity();
			y += direction.getVel().getyVelocity().getVelocity();
			return true;
		} else {
			return false;
		}
		
		
	}
	private boolean isMoveInDirectionPossible(Direction direction) {
		Integer newX = x + direction.getVel().getxVelocity().getVelocity();
		Integer newY = y + direction.getVel().getyVelocity().getVelocity();
		return (0 <= newX && newX < Board.boardSize) && (0 <= newY && newY < Board.boardSize);
	}
	
	public boolean equals(Coordinates c){
		return (y.equals(c.getY()) && x.equals(c.getX()));
	}
	
	public String toString(){
		return "(" + x + "," + y + ")";
	}
}
