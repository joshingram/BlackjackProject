package com.skilldistillery.blackjack.entities;

//The user's player is a player
public class ThePlayer extends Player {

	// The user's player has a blackjack hand
	private BlackjackHand playerHand = new BlackjackHand();

	// if the player had an account for betting, it would be instantiated here

	// The user's player has a name which is given during construction/instantiation
	public ThePlayer(String name) {
		super(name);
	}

	public void playerClearHand() { 
		playerHand.clear();
	}

	public void playerAddCard(Card card) { 
		playerHand.addCard(card);
	}

	public int playerGetHandValue() { 
		int phv = playerHand.getHandValue();
		return phv;
	}

	public void playerShowHand() { 
		playerHand.showHand();
	}
}
