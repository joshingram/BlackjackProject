package com.skilldistillery.blackjack.entities;

public class Player {
	private String name;
	
	private BlackjackHand playerHand = new BlackjackHand();

	public Player(String name) {
		this.name = name;
	}
	
	
}
