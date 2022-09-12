package com.skilldistillery.blackjack.entities;

import java.util.List;

//A dealer "Is a" player
public class Dealer extends Player{
	
	//A dealer "has a" deck
	public Deck dealersDeck = new Deck();
	
	//A dealer "has a" hand
	public BlackjackHand dealerHand = new BlackjackHand();
	
	public Dealer(String name) {  //feature is not used, but is available
		super(name);
		
	}
	//The dealer can shuffle, deal, check the deck size, and get a new deck, 
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
	
	public void dealerNewDeck() {
		dealersDeck= new Deck();
		dealerShuffle();
		System.out.println("According to house rules, new shoe in use");
	}

}
 