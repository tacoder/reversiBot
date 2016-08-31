package com.game.wrapper.interfaces;

import com.game.wrapper.Player;

public interface GenericGame {
	// Deterministic functions to get current state
	public Boolean isGameFinished();
	public Integer getCurrentScore();
	
	// Getter setters to manipulate game state and maintain tree
	public Object getCurrentConfig();
	public Integer getCurrentDepth();
	public Player getNextPlayer();
	public GenericMove getBestMove();
	public GenericGame getParent();
	public void setCurrentConfig(Object object);
	public void setCurrentDepth(Integer currentDepth);
	public void setNextPlayer(Player player);
	public void setBestMove(GenericMove bestMove);
	public void setParent(GenericGame parent);
	
		
}
