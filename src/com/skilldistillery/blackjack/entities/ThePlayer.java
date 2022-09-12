package com.skilldistillery.blackjack.entities;

//The user's player is a player
public class ThePlayer extends Player{
	
	//The user's player has a blackjack hand
	public BlackjackHand playerHand = new BlackjackHand();
	
	//if the player had an account for betting, it would be instantiated here

	//The user's player has a name which is given during construction/instantiation
	public ThePlayer(String name) {
		super(name);
	
	}

}
