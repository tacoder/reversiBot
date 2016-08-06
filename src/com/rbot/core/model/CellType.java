package com.rbot.core.model;

public enum CellType {
	EMPTY('·'),
	BLACK('█'),
	WHITE('░')
	;
	
	Character charRepresentation;
	
	CellType (Character charRepresentation){
		this.charRepresentation = charRepresentation;
	}
	
	public String toString(){
		return this.charRepresentation.toString();
	}
}
