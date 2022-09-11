package com.skilldistillery.blackjack.entities;

public class BlackjackHand extends Hand {

	public boolean isSoft;
	@Override
	public int getHandValue() {         
		int aceCount = 0;
		int value = 0;
		for (Card card : cards) {
			if (card.getValue() == 1){
				aceCount++;
				System.out.println("ace count is: " + aceCount);
			}
			value += card.getValue();
		}
		boolean isSoft = false;
		if (value <= 11 && aceCount >= 1) {
			value += 10;
			this.isSoft = true;
		} 
		return value;
	}
	
	public boolean getIsSoft() {
		return isSoft;
	}
	@Override
	public void addCard(Card card) {
		cards.add(card);

	}

	@Override
	public void showHand() {
		for (Card card : cards) {
			System.out.println(card.toString());
		}

	}

	public Card showSpecificCard(int i) {
		Card card = cards.get(i);
		return card;
	}
}
