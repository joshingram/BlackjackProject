package com.skilldistillery.blackjack.entities;

public class Player {
	//encapsulated field
	private String name;
	
	//player's "have a" hand  - perhaps this could have been a "Hand" rather than a "BlackjackHand"
	//to further uncouple this class and make it more universal
	private BlackjackHand playerHand = new BlackjackHand();

	//one arg ctor
	public Player(String name) {
		this.name = name;
	}
	//getter and setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
