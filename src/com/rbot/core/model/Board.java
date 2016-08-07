package com.rbot.core.model;

import java.util.List;

import com.rbot.core.directional.Coordinates;

public class Board {

	public static final Integer boardSize = 8;
	
	private Cell grid[][];
	
	public Board(){
		grid = new Cell[boardSize][boardSize];
		resetBoard();
	}
	
	public void resetBoard() {
		for(int i = 0; i<boardSize; i++){
			for(int j = 0; j<boardSize; j++){
				grid[i][j] = new Cell(CellType.EMPTY);
			}
		}
		grid[3][3] = new Cell(CellType.BLACK);
		grid[4][4] = new Cell(CellType.BLACK);
		grid[3][4] = new Cell(CellType.WHITE);
		grid[4][3] = new Cell(CellType.WHITE);
	}

	public void printBoard(){
		for(int i = 0; i<boardSize; i++){
			for(int j = 0; j<boardSize; j++){
				System.out.print(grid[i][j]);
			}
			System.out.print("\n");
		}
	}
	
	
	public void move(CellType toInsert, Coordinates insertAt) throws Exception{
		if (!isValidMove(toInsert,insertAt)){
			throw new Exception("Invalid Move!");
		} else {
			List<Coordinates> movesToMake = getCoordinatesForMoveAt(toInsert,insertAt);
			for(Coordinates coordinates : movesToMake){
				reversi(toInsert,insertAt,coordinates);
			}
		}
	}

	private void reversi(CellType toInsert, Coordinates insertAt, Coordinates coordinates) {
		List<Coordinates> cells = getAllCellCoordinatesBetween(insertAt, coordinates);
		for(Coordinates cell : cells){
			paintCell(cell,toInsert);
		}
	}

	private void paintCell(Coordinates cell, CellType toInsert) {
		grid[cell.getRow()][cell.getColumn()].setContent(toInsert);
	}

	private List<Coordinates> getAllCellCoordinatesBetween(Coordinates insertAt, Coordinates coordinates) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Coordinates> getCoordinatesForMoveAt(CellType toInsert, Coordinates insertAt) {
		// TODO Auto-generated method stub
		return null;
	}

	private Boolean isValidMove(CellType toInsert, Coordinates insertAt) {
		return Boolean.TRUE;
	}
}
