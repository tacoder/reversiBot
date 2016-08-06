package com.rbot.core.model;

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
	
//	public move(CellType toInsert, )
}
