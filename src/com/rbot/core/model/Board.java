package com.rbot.core.model;

import java.util.Collections;

public class Board {

	public static final Integer boardSize = 8;
	
	private Integer grid[][];
	
	public Board(){
		grid = new Integer[boardSize][boardSize];
		for(int i = 0; i<boardSize; i++){
			for(int j = 0; j<boardSize; j++){
				grid[i][j] = new Integer(0);
			}
//			System.out.print("\n");
		}
//		new Integer[boardSize][boardSize];
	}
	
	public void printBoard(){
		for(int i = 0; i<boardSize; i++){
			for(int j = 0; j<boardSize; j++){
				System.out.print(grid[i][j]);
			}
			System.out.print("\n");
		}
	}
}
