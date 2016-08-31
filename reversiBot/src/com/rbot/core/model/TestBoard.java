package com.rbot.core.model;

import java.util.List;

import com.rbot.core.directional.Coordinates;

public class TestBoard {
	
	public Integer boardSize ;
	
	private Character grid[][];

	public TestBoard(Board board) {
		boardSize = Board.boardSize;
		grid = new Character[boardSize][boardSize];
		for(int i = 0; i<boardSize; i++){
			for(int j = 0; j<boardSize; j++){
				grid[i][j] = board.getContentAtCoordinate(new Coordinates(i, j)).toString().charAt(0);
			}
		}
	}

	public void printBoard(){
		for(int i = 0; i<boardSize; i++){
			for(int j = 0; j<boardSize; j++){
				System.out.print(grid[i][j]);
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	public void highlightCells(List<Coordinates> moves){
		for (Coordinates move:moves){
			grid[move.getY()][move.getX()] = 'X';
		}
	}
}
