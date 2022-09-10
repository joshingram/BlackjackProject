package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	
	List<Card> cards = new ArrayList<>();
	

	public Hand () {
	}
	
	public abstract void addCard(Card card);
	
	public void clear() {
		cards.removeAll(cards);
	}
	
	public abstract void showHand();
	
	public abstract int getHandValue();

	@Override
	public String toString() {
		return "Hand []";
	}
	
	
	
}
