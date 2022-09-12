package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck = new ArrayList<>();
	private final int NUM_OF_DECKS = 8;
	private final int CARDS_PER_DECK = 52;
	private final double MIN_DECK = 0.8;

	//build a Deck from Cards and a shoe from Decks
	public Deck() {
		//first for loop creates a multiple decks for the shoe using NUM OF DECKS
		for (int i = 0; i < NUM_OF_DECKS; i++) { 
			//build one standard deck
			for (Rank rank : Rank.values()) {
				for (Suit suit : Suit.values()) {
					deck.add(new Card(suit, rank));
				}
			}
		}
	}
	//check how many cards are in the deck (shoe)
	public int checkDeckSize() {
		int deckSize = deck.size();
		return deckSize;
	}
	//how many decks are in a shoe
	public int checkNumOfDecks() {
		return NUM_OF_DECKS;
	}
	//uses "house rules" from final values to determine the min number of cards before a new shoe is implemented
	public int checkMinDeck() {
		int minCards = (int) (NUM_OF_DECKS * CARDS_PER_DECK * MIN_DECK);
		return minCards;
	}
	//deal a card by removing it from the deck (shoe)
	public Card dealCard() {
		Card removed = deck.remove(0);
		return removed;
	}
	//shuffle the deck (shoe)
	public void shuffle() {
		Collections.shuffle(deck);
	}
	//show all cards in the deck (shoe)
	public void showAllCards() {
		for (Card card : deck) {
			System.out.println(card.toString());
		}
	}
}
