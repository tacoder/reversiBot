package com.rbot.core.directional;

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
}
