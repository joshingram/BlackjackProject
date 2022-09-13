package com.skilldistillery.blackjack.entities;

//A dealer "Is a" player
public class Dealer extends Player {

	// A dealer "has a" deck
	private Deck dealersDeck = new Deck();

	// A dealer "has a" hand
	private BlackjackHand dealerHand = new BlackjackHand();

	public Dealer(String name) { // feature is not used, but is available
		super(name);
	}

	// The dealer can shuffle, deal, check the deck size, and get a new deck,
	public void dealerShuffle() {
		dealersDeck.shuffle();
	}

	public Card dealACard() {
		Card card = dealersDeck.dealCard();
		return card;
	}

	public void dealerNewDeck() {
		dealersDeck = new Deck();
		dealerShuffle();
		System.out.println("According to house rules, new shoe in use");
	}

	public void dealerClearHand() {
		dealerHand.clear();
	}

	public int dealerCheckNumOfDecks() {
		int num = dealersDeck.checkNumOfDecks();
		return num;
	}

	public void dealerShowAllCards() { 
		for (Card card : dealersDeck.getDeck()) {
			System.out.println(card.toString());
		}
	}

	public int dealerCheckMinDeck() { 
		int md = dealersDeck.checkMinDeck();
		return md;
	}

	public void dealerAddCard(Card card) { 
		dealerHand.addCard(card);
	}

	public Card dealerShowSpecCard(int i) { 
		Card c = dealerHand.showSpecificCard(i);
		return c;
	}

	public void dealerShowHand() { 
		dealerHand.showHand();
	}

	public int dealerGetHandValue() { 
		int dhv = dealerHand.getHandValue();
		return dhv;
	}

	public boolean dealerGetIsSoft() { 
		boolean gis = dealerHand.getIsSoft();
		return gis;
	}

	public int dealerCheckDeckSize() { 
		int ds = dealersDeck.checkDeckSize();
		return ds;
	}
}