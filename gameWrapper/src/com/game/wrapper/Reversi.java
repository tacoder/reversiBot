package com.game.wrapper;

import com.game.wrapper.interfaces.GenericGame;
import com.game.wrapper.interfaces.GenericMove;

public class Reversi implements GenericGame{

	Boolean isGameFinished;
	private Integer currentScore;
	Reversi parent;
	private GenericMove bestMove;
	private Player nextPlayer;
	private Integer currentDepth;
	private Object currentConfig;
	
	@Override
	public Boolean isGameFinished() {
		return isGameFinished;
	}

	@Override
	public Object getCurrentConfig() {
		return currentConfig;
	} 

	@Override
	public Integer getCurrentDepth() {
		return currentDepth;
	}

	@Override
	public Player getNextPlayer() {
		return nextPlayer;
	}

	@Override
	public GenericMove getBestMove() {
		return bestMove;
	}

	@Override
	public GenericGame getParent() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Integer getCurrentScore() {
		return currentScore;
	}

	@Override
	public void setParent(GenericGame genericGame) {
		this.parent = (Reversi) genericGame;
	}

	@Override
	public void setCurrentConfig(Object currentConfig) {
		this.currentConfig = currentConfig;
	}

	@Override
	public void setCurrentDepth(Integer currentDepth) {
		this.currentDepth = currentDepth;
	}

	@Override
	public void setNextPlayer(Player nextPlayer) {
		this.nextPlayer = nextPlayer;
	}

	@Override
	public void setBestMove(GenericMove bestMove) {
		this.bestMove = bestMove;
	}
	
}
