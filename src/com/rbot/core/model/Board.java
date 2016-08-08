package com.rbot.core.model;

import java.util.ArrayList;
import java.util.List;


import com.rbot.core.directional.Coordinates;
import com.rbot.core.directional.Direction;
import com.rbot.core.directional.Velocity;
import com.rbot.core.directional.VelocityMagnitudes;
/**
 * Board representation
 *        ^       
 *        |
 *        |
 *        |
 *        |
 *   <----+----> +ve x axis
 *        |
 *        |
 *        |
 *        |
 *        v
 *        +ve y axis
 *  This is a 2D array.
 *
 */
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

	private void reversi(CellType toInsert, Coordinates insertAt, Coordinates coordinates) throws Exception {
		List<Coordinates> cells = getAllCellCoordinatesBetween(insertAt, coordinates);
		for(Coordinates cell : cells){
			paintCell(cell,toInsert);
		}
	}

	private void paintCell(Coordinates cell, CellType toInsert) {
		grid[cell.getRow()][cell.getColumn()].setContent(toInsert);
	}

	private List<Coordinates> getAllCellCoordinatesBetween(Coordinates a, Coordinates b) throws Exception {
		Direction direction = getDirectionBetween(a,b);
		Coordinates tempCoordinate = new Coordinates(a);
		List<Coordinates> toReturn = new ArrayList<Coordinates>();
		while (!tempCoordinate.equals(b)){
			toReturn.add(tempCoordinate);
			tempCoordinate.addUnitInDirection(direction);
		}
		return toReturn;
		
	}

	private Direction getDirectionBetween(Coordinates a, Coordinates b) throws Exception {
		Integer xVel = (int) Math.signum(a.getRow() - b.getRow());
		Integer yVel = (int) Math.signum(a.getColumn() - b.getColumn());
		VelocityMagnitudes xVelocity = VelocityMagnitudes.getVelocityMagnitudeByInteger(xVel);
		VelocityMagnitudes yVelocity = VelocityMagnitudes.getVelocityMagnitudeByInteger(yVel);;
		Velocity vel = new Velocity(xVelocity, yVelocity);
		return Direction.getDirectionByVelocity(vel);
	}

	private List<Coordinates> getCoordinatesForMoveAt(CellType toInsert, Coordinates insertAt) {
		List<Coordinates> toReturn = new ArrayList<Coordinates>();
		List<Direction> directions = Direction.getListOfAllDirections();
		for(Direction direction:directions){
			Coordinates tempCoordinate = new Coordinates(insertAt);
			while(tempCoordinate.addUnitInDirection(direction)){
				if(grid[tempCoordinate.getRow()][tempCoordinate.getColumn()].getContent().equals(toInsert)){
					toReturn.add(tempCoordinate);
					break;
				}
			}
		}
		return toReturn;
	}

	private Boolean isValidMove(CellType toInsert, Coordinates insertAt) {
		List<Direction> directions = Direction.getListOfAllDirections();
		for(Direction direction:directions){
			Coordinates tempCoordinate = new Coordinates(insertAt);
			if(tempCoordinate.addUnitInDirection(direction) && 
					!getContentAtCoordinate(tempCoordinate).equals(toInsert)){
				while(tempCoordinate.addUnitInDirection(direction)){
					if(getContentAtCoordinate(tempCoordinate).equals(toInsert)){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	CellType getContentAtCoordinate(Coordinates x){
		return grid[x.getRow()][x.getColumn()].getContent();
	}
}
