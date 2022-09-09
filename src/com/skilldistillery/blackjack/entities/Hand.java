package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	
	List<Card> cards = new ArrayList<>();
	

	public Hand () {
	}
	
	public void addCard(Card card) {
	}
	
	public void clear() {
	}
	
	public abstract int getHandValue();

	@Override
	public String toString() {
		return "Hand []";
	}
	
	
	
}
