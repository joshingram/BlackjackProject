package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Deck;

public class DealingApp {
	
	//THIS A VALIDATION TESTING AP ONLY, NOT FOR USE WITH FINISHED APP
	//PLEASE USE BlackjackApp.java FOR GRADING AND TESTING PURPOSES

	public static void main(String[] args) {
		DealingApp da = new DealingApp();
		da.playGame();
	}
	public void playGame() {
		Deck deck = new Deck();
		deck.shuffle();
		
		Scanner kb = new Scanner(System.in);
		System.out.println("How many cards do you want?");
		int numCardsAsked = kb.nextInt();
		int numCardsInDeck = deck.checkDeckSize();
		if (numCardsAsked > numCardsInDeck) {    
			System.out.println("Not enough cards for that");
			System.exit(0);
		}
		
		
		int total = 0;
		for (int i = 0 ; i < numCardsAsked ; i++) {
			Card dealtCard = deck.dealCard();
			total += dealtCard.getValue();
			System.out.println(dealtCard);
		}
		
		
		
		numCardsInDeck = deck.checkDeckSize();
		System.out.println("There are " + numCardsInDeck + " remaining in the deck.");
		System.out.println("Hand value is: " + total);
		

	}

}
