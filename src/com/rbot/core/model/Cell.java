package com.rbot.core.model;

public class Cell {
	private CellType content;

	public CellType getContent() {
		return content;
	}

	public void setContent(CellType content) {
		this.content = content;
	}

	public Cell(CellType content) {
		this.content = content;
	}
	
	public String toString(){
		return content.toString();
	}
}
