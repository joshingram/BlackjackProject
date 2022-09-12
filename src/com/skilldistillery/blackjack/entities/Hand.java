package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	//a "Hand" has a collection of Cards
	List<Card> cards = new ArrayList<>();
	
	//No arg ctor for good practice, however it's unnecessary because there are no "custom" ctors to displace the default ctor
	public Hand () {
	}
	//add a card to the hand
	public  void addCard(Card card) {
	cards.add(card);
	}
	//remove all cards from the hand
	public void clear() {
		cards.removeAll(cards);
	}
	//to be defined in concrete Class, different games may reveal hands differently
	public abstract void showHand();
	
	//hands have different values based on the game being played, to be defined by extending Class
	public abstract int getHandValue();
	
	//Overriden toString
	@Override
	public String toString() {
		return "Hand []";
	}
	
	
	
}
