package com.rbot.driver;

import java.util.List;

import com.rbot.core.directional.Coordinates;
import com.rbot.core.model.Board;
import com.rbot.core.model.TestBoard;
import com.rbot.core.model.CellType;

public class driver {
	public static void main(String[] args) throws Exception{
		Board board = new Board();
		board.printBoard();
		highlightAndPrint( board, board.getAllBorderCells());
		printAllMovesFor(CellType.BLACK,board);
		board.move(CellType.BLACK, new Coordinates(2, 3));
		board.printBoard();
		highlightAndPrint( board, board.getAllBorderCells());
		printAllMovesFor(CellType.WHITE,board);
		
		
//		for(Coordinates move:moves){
//			System.out.println(move);
//		}
	}

	private static void printAllMovesFor(CellType cellType,Board board) {
		List<Coordinates> moves = board.getAllPossibleMovesForPlayer(cellType);
		highlightAndPrint(board, moves);
	}
	
	private static void highlightAndPrint(Board board, List<Coordinates> moves){
		TestBoard testBoard = new TestBoard(board); 
		testBoard.highlightCells(moves);
		testBoard.printBoard();
	}
}
