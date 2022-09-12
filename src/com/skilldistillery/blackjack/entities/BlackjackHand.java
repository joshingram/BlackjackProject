package com.skilldistillery.blackjack.entities;

//A blackjack hand "is a" type of hand
public class BlackjackHand extends Hand {

	//boolean used to find hands with soft Aces
	public boolean isSoft;
	
	//Overriden to use the scoring values of blackjack (not some other game)
	@Override
	public int getHandValue() { 
		//get the blackjack numerical value and return it
		int aceCount = 0;
		int value = 0;
		for (Card card : cards) {
			if (card.getValue() == 1){
				aceCount++;
			}
			value += card.getValue();
		}
		//determine when an Ace should be soft then add 10 to value and identify hands with soft Aces
		boolean isSoft = false;
		if (value <= 11 && aceCount >= 1) {
			value += 10;
			this.isSoft = true;
		} 
		return value;
	}
	//report if a hand contains a soft Ace
	public boolean getIsSoft() {
		return isSoft;
	}

	@Override
	public void showHand() {
		for (Card card : cards) {
			System.out.println(card.toString());
		}

	}
	//Show a specific card, used to show the dealer's second card - not first card
	public Card showSpecificCard(int i) {
		Card card = cards.get(i);
		return card;
	}
}
