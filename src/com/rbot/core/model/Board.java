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
		System.out.print("\n");
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
		getCellAtCoordinate(cell).setContent(toInsert);
	}

	private List<Coordinates> getAllCellCoordinatesBetween(Coordinates a, Coordinates b) throws Exception {
		Direction direction = getDirectionBetween(a,b);
		Coordinates tempCoordinate = new Coordinates(a);
		List<Coordinates> toReturn = new ArrayList<Coordinates>();
		while (!tempCoordinate.equals(b)){
			toReturn.add(new Coordinates(tempCoordinate));
			if(!tempCoordinate.addUnitInDirection(direction)) break;
		}
		return toReturn;
		
	}

	private Direction getDirectionBetween(Coordinates a, Coordinates b) throws Exception {
		Integer yVel = (int) Math.signum(b.getY() - a.getY());
		Integer xVel = (int) Math.signum(b.getX() - a.getX());
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
				if(getContentAtCoordinate(tempCoordinate).equals(toInsert)){
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
		return getCellAtCoordinate(x).getContent();
	}

	private Cell getCellAtCoordinate(Coordinates x) {
		return grid[x.getY()][x.getX()];
	}
	
	public List<Coordinates> getAllPossibleMovesForPlayer(CellType cellType){
		List<Coordinates> toReturn = new ArrayList<Coordinates>();
		List<Coordinates> allBorderCells = getAllBorderCells();
		for(Coordinates cell:allBorderCells){
			if(isValidMove(cellType, cell)){
				toReturn.add(new Coordinates(cell));
			}
		}
		return toReturn;
	}

	private List<Coordinates> getAllBorderCells() {
		List<Coordinates> toReturn = new ArrayList<Coordinates>();
		floodFillGetBorderCells(new Coordinates(3, 3),toReturn);
		return toReturn;
	}

	private void floodFillGetBorderCells(Coordinates coordinates, List<Coordinates> toReturn) {
		if(getContentAtCoordinate(coordinates).equals(CellType.EMPTY)){
			toReturn.add(new Coordinates(coordinates));
			return;
		}
		List<Direction> directions = Direction.getListOfAllDirections();
		for(Direction direction:directions){
			Coordinates tempCoord = new Coordinates(coordinates);
			if(tempCoord.addUnitInDirection(direction)){
				floodFillGetBorderCells(tempCoord, toReturn);
			}
		}
		
	}
}
