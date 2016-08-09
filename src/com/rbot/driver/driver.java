package com.rbot.driver;

import java.util.List;

import com.rbot.core.directional.Coordinates;
import com.rbot.core.model.Board;
import com.rbot.core.model.CellType;

public class driver {
	public static void main(String[] args) throws Exception{
		Board board = new Board();
		board.printBoard();
		board.move(CellType.BLACK, new Coordinates(3, 5));
		board.printBoard();
		List<Coordinates> moves = board.getAllPossibleMovesForPlayer(CellType.BLACK);
		for(Coordinates move:moves){
			System.out.println(move);
		}
	}
}
