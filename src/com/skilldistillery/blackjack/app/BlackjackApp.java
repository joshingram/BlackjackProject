package com.skilldistillery.blackjack.app;

import java.util.Scanner;
import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.ThePlayer;

public class BlackjackApp {
	Scanner kb = new Scanner(System.in);
	String playerName = ""; 
	Dealer dealer = new Dealer("Dealer");
	ThePlayer player = new ThePlayer(playerName);
	boolean playerBJ;

	public static void main(String[] args) {
		//instantiate the Class and call the first (non main) method
		BlackjackApp bja = new BlackjackApp();
		bja.letsPlay();
	}
	//Invoke the welcome screen, then shuffle, and continue the game with keepPlaying
	public void letsPlay() {
		welcomeScreen();
		dealer.dealerShuffle();
		keepPlaying();
	}
	//Continue the game from letsPlay OR from againChoice - skip welcome, deck is already shuffled
	public void keepPlaying() {
		//while loop to repeat play
		while (true) {
			//clear the previous hand if coming from againChoice
			clearHands();
			//deal first 4 cards
			initialDeal();
			//show the initial table
			displayInitial();
			//allow the player to play return hand value to pass to dealer's turn
			int playerHandValue = playerTurn();
			//dealer's turn, takes player's hand value
			dealerTurn(playerHandValue);
			//allow player to choose to play again or quit
			againChoice();
		}
	}
	//clear both dealer and player hands
	private void clearHands() {
		player.playerClearHand();
		dealer.dealerClearHand();
	}

	// Print the welcome screen, the ground rules and asks for player's name, allow for printing the deck
	public void welcomeScreen() {
		System.out.println("Welcome to the Black Jack App");
		System.out.println();
		int numDecks = dealer.dealerCheckNumOfDecks();
		int minShoe = dealer.dealerCheckMinDeck();
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
			dealer.dealerShowAllCards();
			welcomeScreen();
		} else {
			player.setName(playerName);
		}
	}

	// call dealer methods to deal the first four cards in alternating order
	// place cards into respective hands
	// might be able to reduce the lines used/DRY, but this makes the dealing
	// order very clear
	public void initialDeal() {
		System.out.println("Dealing...");
		Card card1 = dealer.dealACard();
		player.playerAddCard(card1);
		
		Card card2 = dealer.dealACard();
		dealer.dealerAddCard(card2);
		
		Card card3 = dealer.dealACard();
		player.playerAddCard(card3);
		
		Card card4 = dealer.dealACard();
		dealer.dealerAddCard(card4);

	}

	// display player's first look at their cards and dealer's face up card,
	public void displayInitial() {
		// show's the player's current hand
		displayPlayerHand();
		System.out.println();
		int playerHV = player.playerGetHandValue();
		playerBJ = false;
		//immediately ID a natural blackjack and set boolean
		if (playerHV == 21) {
			System.out.println("You have a natural Black Jack!!");
			playerBJ = true;
		}
		System.out.println("The dealer is showing:");
		// Specifically show the second card dealt to the dealer, not the first
		Card dealerFace = dealer.dealerShowSpecCard(1);
		System.out.println(dealerFace);
		System.out.println();
	}

	// Show player's current hand and hand value, called frequently, keeps other methods DRY
	private void displayPlayerHand() {
		System.out.println();
		System.out.println("You have:");
		player.playerShowHand();
		System.out.println("** Your current hand value is: " + player.playerGetHandValue() + " **");
		int playerHV = player.playerGetHandValue();
		//some basic advice
		if (playerHV == 21) {
			System.out.println("You have 21, you'd be a fool to hit again");
		}
	}

	// Allow player to hit or stand, display end game if reached
	public int playerTurn() {
		while (true) {
			System.out.print("Would you like to hit/h or stand/s?");
			String playerChoice = kb.next();
			if (playerChoice.equalsIgnoreCase("hit") || playerChoice.equalsIgnoreCase("h")) {
				Card cardX = dealer.dealACard();
				player.playerAddCard(cardX);
				int phv = player.playerGetHandValue();
				if (player.playerGetHandValue() > 21) {
					displayPlayerHand();
					System.out.println("You busted with " + phv + ".  Dealer wins.");
					againChoice();
				}
				displayPlayerHand();
			} else if (playerChoice.equalsIgnoreCase("stand") || playerChoice.equalsIgnoreCase("s")) {
				break;
			} else {
				System.out.println("Invalid entry, try again");
			}
		}
		return player.playerGetHandValue();
	}

	// rule based dealer hit and stand then print end game results
	public void dealerTurn(int playerHV) {
		System.out.println("Dealer reveals the hole card and now shows:");
		dealer.dealerShowHand();
		int dealerHV = dealer.dealerGetHandValue();
		boolean isSoft = dealer.dealerGetIsSoft();
		System.out.println("** Dealer's hand value is " + dealerHV + " **");
		//if the dealer has a natural blackjack - does the player also have BJ?
		if (dealerHV == 21) {
			if (dealerHV == 21 && playerBJ) {
				System.out.println("Dealer has also Black Jack!! It's a push.");
			} else {
				System.out.println("Dealer has Black Jack!! Dealer wins.");
			}
		//dealer does not have BJ, compare value to player, implement dealer rules and soft hits	
		} else if ((dealerHV == playerHV) && (dealerHV > 16) && (!isSoft)) {
			System.out.println("It's a push.");
		} else if ((dealerHV > playerHV) && (dealerHV > 16) && (!isSoft)) {
			System.out.println("Dealer wins.");
		} else if ((dealerHV <= 16) || ((dealerHV == 17) && (isSoft))) {
			while ((dealerHV < 17) || ((dealerHV == 17) && (isSoft))) {
				System.out.println("Dealer hits...");
				Card cardY = dealer.dealACard();
				dealer.dealerAddCard(cardY);
				System.out.println("Dealer now has:");
				dealer.dealerShowHand();
				dealerHV = dealer.dealerGetHandValue();
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
		} else if (dealerHV < playerHV) {
			System.out.println("You win.");
		} else if (dealerHV > playerHV) {
			System.out.println("Dealer wins.");
		}
	
	}

	// Allow player to play another hand or quit
	private void againChoice() {
		boolean cont = true;
		while (cont) {
			checkDeck();
			System.out.println("Would you like to play again? Yes/Y or No/N:");
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
	//show the number of cards remaining and invoke dealer to make a new shoe when cards remaining are < min deck size
	public void checkDeck() {
		int cardsRemaining = dealer.dealerCheckDeckSize();
		System.out.println("** There are " + cardsRemaining + " cards remaining **");
		int mDS = dealer.dealerCheckMinDeck();
		if (cardsRemaining < mDS) {
			dealer.dealerNewDeck();
		}
	}
}