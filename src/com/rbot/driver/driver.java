package com.rbot.driver;

import com.rbot.core.directional.Coordinates;
import com.rbot.core.model.Board;
import com.rbot.core.model.CellType;

public class driver {
	public static void main(String[] args) throws Exception{
		Board board = new Board();
		board.printBoard();
		board.move(CellType.BLACK, new Coordinates(5, 3));
	}
}
