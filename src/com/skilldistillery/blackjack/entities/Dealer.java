package com.skilldistillery.blackjack.entities;

import java.util.List;

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
	
	public int checkDealerDeck () {
		int dealerDeckSize = dealersDeck.checkDeckSize();
		return dealerDeckSize;
	}

}
 