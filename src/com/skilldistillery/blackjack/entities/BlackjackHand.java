package com.skilldistillery.blackjack.entities;

public class BlackjackHand extends Hand{

	@Override
	public int getHandValue() {
		int value = 0;
		for (Card card : cards) {
			value += card.getValue();
		}
		return value;
	}

	@Override
	public void addCard(Card card) {
		cards.add(card);
		
	}

	@Override
	public void clear() {
		//for (int i = 0 ; i < cards.size() ; i++) {
			cards.removeAll(cards);
		//}
		
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
