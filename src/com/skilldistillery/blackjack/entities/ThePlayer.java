package com.skilldistillery.blackjack.entities;

public class ThePlayer extends Player{
	
	public BlackjackHand playerHand = new BlackjackHand();

	public ThePlayer(String name) {
		super(name);
	
	}

}
