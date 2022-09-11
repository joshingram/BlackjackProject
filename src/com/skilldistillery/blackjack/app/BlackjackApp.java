package com.skilldistillery.blackjack.app;

import java.util.Scanner;
import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.ThePlayer;

public class BlackjackApp {
	Scanner kb = new Scanner(System.in);
	String playerName = ""; // TODO private?
	Dealer dealer = new Dealer("Dealer");
	ThePlayer player = new ThePlayer(playerName);
	boolean playerBJ;

	public static void main(String[] args) {
		BlackjackApp bja = new BlackjackApp();
		bja.letsPlay();
	}

	public void letsPlay() {
		welcomeScreen();
		dealer.dealerShuffle();
		keepPlaying();
	}

	public void keepPlaying() {
		while (true) {
			clearHands();
			initialDeal();
			displayInitial();
			int playerHandValue = playerTurn();
			dealerTurn(playerHandValue);
			againChoice();
		}
	}

	private void clearHands() {
		player.playerHand.clear();
		dealer.dealerHand.clear();
	}

	// Print the welcome screen, the ground rules and asks for player's name
	public void welcomeScreen() {
		System.out.println("Welcome to the Black Jack App");
		System.out.println();
		int numDecks = dealer.dealersDeck.checkNumOfDecks();
		int minShoe = dealer.dealersDeck.checkMinDeck();
		System.out.println("** House Rules **");
		System.out.println("-We're playing with an " + numDecks + " deck shoe. ");
		System.out.println("-A new shoe will be used when " + minShoe + " cards remain in the shoe"); 
		System.out.println("-The dealer must hit on 16 (and below) and on soft 17");
		System.out.println("-The dealer must and stand on hard 17 (and above).");
		System.out.println("-Administrative notes are shown with \"** notation **\"");
		System.out.println();
		System.out.println("Please enter your NAME or enter \"showcards\" to print the entire deck");
		System.out.println("There are " + numDecks + " decks of cards, think twice about printing them: ");
		playerName = kb.next();
		kb.nextLine();
		if (playerName.equalsIgnoreCase("showcards")) {
			dealer.dealersDeck.showAllCards();
			welcomeScreen();
		} else {
			player.setName(playerName);
		}
	}

	// call dealer methods to deal the first four cards in alternating order
	// place cards into respective hands
	public void initialDeal() {
		System.out.println("Dealing...");
		Card card1 = dealer.dealACard();
		player.playerHand.addCard(card1);
		Card card2 = dealer.dealACard();
		dealer.dealerHand.addCard(card2);
		Card card3 = dealer.dealACard();
		player.playerHand.addCard(card3);
		Card card4 = dealer.dealACard();
		dealer.dealerHand.addCard(card4);

	}

	// display player's first look at their cards and dealer's face up card,
	public void displayInitial() {
		// show's the player's current hand
		displayPlayerHand();
		System.out.println();
		int playerHV = player.playerHand.getHandValue();
		playerBJ = false;
		if (playerHV == 21) {
			System.out.println("You have a natural Black Jack!!");
			playerBJ = true;
		}
		System.out.println("The dealer is showing:");
		// Specifically show the second card dealt to the dealer, not the first
		Card dealerFace = dealer.dealerHand.showSpecificCard(1);
		System.out.println(dealerFace);
		System.out.println();
	}

	// Show player's current hand and hand value
	private void displayPlayerHand() {
		System.out.println();
		System.out.println("You have:");
		player.playerHand.showHand();
		System.out.println("** Your current hand value is: " + player.playerHand.getHandValue() + " **");
		int playerHV = player.playerHand.getHandValue();
		if (playerHV == 21) {
			System.out.println("You have 21, you'd be a fool to hit again");
		}
	}

	// Allow player to hit or stand, display end game if reached
	public int playerTurn() {
		while (true) {
			System.out.print("Would you like to hit or stand?");
			String playerChoice = kb.next(); // TODO try/catch for inputexception?
			if (playerChoice.equalsIgnoreCase("hit") || playerChoice.equalsIgnoreCase("h")) {
				Card cardX = dealer.dealACard();
				player.playerHand.addCard(cardX);
				int phv = player.playerHand.getHandValue();
				if (player.playerHand.getHandValue() > 21) {
					displayPlayerHand();
					System.out.println("You busted with " + phv + ".  You lose.");
					againChoice();
				}
				displayPlayerHand();
			} else if (playerChoice.equalsIgnoreCase("stand") || playerChoice.equalsIgnoreCase("s")) {
				break;
			} else {
				System.out.println("Invalid entry, try again");
			}
		}
		return player.playerHand.getHandValue();
	}

	// rule based dealer hit and stand then print end game results
	public void dealerTurn(int playerHV) {
		System.out.println("Dealer reveals the hole card and now shows:");
		dealer.dealerHand.showHand();
		int dealerHV = dealer.dealerHand.getHandValue();
		boolean isSoft = dealer.dealerHand.getIsSoft();
		System.out.println("** Dealer's hand value is " + dealerHV + " **");
		if (dealerHV == 21) {
			if (dealerHV == 21 && playerBJ) {
				System.out.println("Dealer has also Black Jack!! It's a push.");
			} else {
				System.out.println("Dealer has Black Jack!! You lose.");
			}
		} else if ((dealerHV == playerHV) && (dealerHV > 16) && (!isSoft)) {
			System.out.println("It's a push.");
		} else if ((dealerHV > playerHV) && (dealerHV > 16) && (!isSoft)) {
			System.out.println("Dealer wins.");
		} else if ((dealerHV <= 16) || ((dealerHV == 17) && (isSoft))) {
			while ((dealerHV < 17) || ((dealerHV == 17) && (isSoft))) {
				System.out.println("Dealer hits...");
				Card cardY = dealer.dealACard();
				dealer.dealerHand.addCard(cardY);
				System.out.println("Dealer now has:");
				dealer.dealerHand.showHand();
				dealerHV = dealer.dealerHand.getHandValue();
				System.out.println("** Dealer's hand value is now " + dealerHV + " **");
				if (dealerHV > 21) {
					System.out.println("Dealer busts! You win.");
					againChoice();
				}
			}
			if (dealerHV == playerHV) {
				System.out.println("It's a push.");
			} else if (dealerHV > playerHV) {
				System.out.println("Dealer wins.");
			} else {
				System.out.println("You win.");
			}
		} else
			System.out.println("You win.");
	}

	// Allow player to play another hand or quit
	private void againChoice() {
		boolean cont = true;
		while (cont) {
			checkDeck();
			System.out.println("Would you like to play again? Yes or No:");
			String againChoice = kb.next();
			if (againChoice.equalsIgnoreCase("yes") || againChoice.equalsIgnoreCase("y")) {
				keepPlaying();
			} else if (againChoice.equalsIgnoreCase("NO") || againChoice.equalsIgnoreCase("n")) {
				System.out.println("Thanks for playing " + player.getName() + ", goodbye!");
				System.exit(0);
			} else {
				System.out.println("invalid entry, try again");
			}
		}
	}

	public void checkDeck() {
		int cardsRemaining = dealer.dealersDeck.checkDeckSize();
		System.out.println("** There are " + cardsRemaining + " cards remaining **");
		int mDS = dealer.dealersDeck.checkMinDeck();
		if (cardsRemaining < mDS) {
			dealer.dealerNewDeck();
			
			
		}
	}
}