package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	List<Card> deck = new ArrayList<>();
	private final int NUM_OF_DECKS = 8;
	private final int CARDS_PER_DECK = 52;
	private final double MIN_DECK = 0.8;

	public Deck() {
		for (int i = 0; i < NUM_OF_DECKS; i++) {
			for (Rank rank : Rank.values()) {
				for (Suit suit : Suit.values()) {
					deck.add(new Card(suit, rank));
				}
			}
		}
	}

	public int checkDeckSize() {
		int deckSize = deck.size();
		return deckSize;
	}

	public int checkNumOfDecks() {
		return NUM_OF_DECKS;
	}

	public int checkMinDeck() {
		int minCards = (int) (NUM_OF_DECKS * CARDS_PER_DECK * MIN_DECK);
		return minCards;
	}

	public Card dealCard() {
		Card removed = deck.remove(0);
		return removed;
	}

	public void shuffle() {
		Collections.shuffle(deck);
	}

	public void showAllCards() {
		for (Card card : deck) {
			System.out.println(card.toString());
		}
	}
}
