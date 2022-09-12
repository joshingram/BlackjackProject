package com.skilldistillery.blackjack.entities;

import java.util.Objects;

public class Card {
	//encapsulated fields with enumerated types
	private Suit suit;
	private Rank rank;

	//two arg constructor
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}
	//customized toString
	@Override
	public String toString() {
		return "\t" + rank + " of " + suit;
	}
	
	//getter
	public int getValue() {
		return rank.getValue();
		
	}
	//Overriden hashCode and equals
	@Override
	public int hashCode() {
		return Objects.hash(rank, suit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return rank == other.rank && suit == other.suit;
	}
	
	
}


