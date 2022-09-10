package com.skilldistillery.blackjack.entities;

public class Dealer extends Player{
	public Deck dealersDeck = new Deck();
	
	public BlackjackHand dealerHand = new BlackjackHand();
	
	public Dealer(String name) {
		super(name);
		
	}
	public void dealerShuffle() {
		dealersDeck.shuffle();
	}
	
	public Card dealACard() {
		Card card = dealersDeck.dealCard();
		return card;
		
	}

}
 