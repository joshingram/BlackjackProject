package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	List<Card> deck = new ArrayList<>();
	//private final int numOfDecks = 8;  //TODO 8 is a magic number, fix this with FINAL Value

	public Deck() {
	//	for(int i = 0 ; i <numOfDecks ; i++) {  
		for (Rank rank : Rank.values()) {
			for (Suit suit : Suit.values()) {
				deck.add(new Card(suit, rank));
			}
		}
	//}
	}
	public int checkDeckSize() {
		int deckSize = deck.size();
		return deckSize;
	}
	public Card dealCard() {
		Card removed = deck.remove(0);
		return removed;
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
}
