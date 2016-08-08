package com.rbot.core.directional;

import com.rbot.core.model.Board;

public class Coordinates {
	private Integer row;
	private Integer column;
	public Integer getColumn() {
		return column;
	}
	public void setColumn(Integer column) {
		this.column = column;
	}
	public Integer getRow() {
		return row;
	}
	public void setRow(Integer row) {
		this.row = row;
	}
	public Coordinates(Integer row, Integer column) {
		super();
		this.row = row;
		this.column = column;
	}
	
	public Coordinates(Coordinates a) {
		this.row = a.getRow();
		this.column = a.getColumn();
	}
	public Boolean addUnitInDirection(Direction direction) {
		if(isMoveInDirectionPossible(direction)){
			row += direction.getVel().getxVelocity().getVelocity();
			column += direction.getVel().getyVelocity().getVelocity();
			return true;
		} else {
			return false;
		}
		
		
	}
	private boolean isMoveInDirectionPossible(Direction direction) {
		Integer newX = row + direction.getVel().getxVelocity().getVelocity();
		Integer newY = column + direction.getVel().getyVelocity().getVelocity();
		return (0 <= newX && newX < Board.boardSize) && (0 <= newY && newY < Board.boardSize);
	}
}
