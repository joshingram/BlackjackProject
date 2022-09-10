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
	boolean playerBJ = false;
	int cardsRemaining = dealer.dealersDeck.checkDeckSize();

	public static void main(String[] args) {
		BlackjackApp bja = new BlackjackApp();
		bja.letsPlay();
	}

	public void letsPlay() {
		welcomeScreen();
		dealer.dealerShuffle();
		while (true) {
			initialDeal();
			displayInitial();
			int phv = playerTurn();
			dealerTurn(phv);
			againChoice();
		}
	}

	// Prints the welcome screen, the ground rules and asks for player's name
	public void welcomeScreen() {
		System.out.println("Welcome to the Black Jack App");
		System.out.println();
		System.out.println("We're playing with an 8 deck shoe. ");
		System.out.println("The dealer must hit on 16 and stand on 17.");
		System.out.println();
		System.out.print("Please enter your name: ");
		playerName = kb.next();
		player.setName(playerName);
	}

	public void initialDeal() {
		Card card1 = dealer.dealACard();
		player.playerHand.addCard(card1);
		Card card2 = dealer.dealACard();
		dealer.dealerHand.addCard(card2);
		Card card3 = dealer.dealACard();
		player.playerHand.addCard(card3);
		Card card4 = dealer.dealACard();
		dealer.dealerHand.addCard(card4);

	}

	public void displayInitial() {
		displayPlayerHand();
		System.out.println();
		int playerHV = player.playerHand.getHandValue();
		if (playerHV == 21) {
			System.out.println("You have Black Jack, best to Stand and see what the dealer has.");
			playerBJ = true;
		}
		System.out.println("The dealer is showing:");
		Card dealerFace = dealer.dealerHand.showSpecificCard(1);
		System.out.println(dealerFace);
		System.out.println();
	}

	private void displayPlayerHand() {
		System.out.println();
		System.out.println("You have:");
		player.playerHand.showHand();
		int playerHV = player.playerHand.getHandValue();
		System.out.println("Your current hand value is: " + playerHV);
	}

	public int playerTurn() {
		while (true) {
			System.out.print("Would you like to hit or stand?");
			String playerChoice = kb.next(); // TODO try/catch for inputexception?
			if (playerChoice.equalsIgnoreCase("hit")) {
				Card cardX = dealer.dealACard();
				player.playerHand.addCard(cardX);
				int phv = player.playerHand.getHandValue();
				if (phv > 21) {	
					System.out.println("You busted with " + phv + ".  You lose.");
					againChoice();
				}
				displayPlayerHand();
			} else if (playerChoice.equalsIgnoreCase("stand")) {
				break;
			} else {
				System.out.println("Invalid entry, try again");
			}
		}
		return player.playerHand.getHandValue();
	}

	public void dealerTurn(int phv) {
		System.out.println("Dealer reveals the hole card and now shows:");
		dealer.dealerHand.showHand();
		int dealerHV = dealer.dealerHand.getHandValue();
		System.out.println("Dealer's hand value is " + dealerHV);
		if (dealerHV == 21) {
			if (dealerHV == 21 && playerBJ) {
				System.out.println("Dealer has also Black Jack! It's a push");
			} else {
				System.out.println("Dealer has Black Jack! You lose");
			}
		} else if (dealerHV == phv && dealerHV > 16) {
			System.out.println("It's a push");
		} else if (dealerHV > phv  && dealerHV > 16) {
			System.out.println("Dealer wins.");
		} else if (dealerHV <= 16) {
			while (dealerHV < 17 || dealerHV < phv) {
				System.out.println("Dealer hits...");
				Card cardY = dealer.dealACard();
				dealer.dealerHand.addCard(cardY);
				System.out.println("Dealer now has:");
				dealer.dealerHand.showHand();
				dealerHV = dealer.dealerHand.getHandValue();
				System.out.println("Dealer's hand value is now " + dealerHV);
				if (dealerHV > 21) {
					System.out.println("Dealer busts! You win.");
				}
			}
			if (dealerHV == phv) {
				System.out.println("It's a push");
			} else {
				System.out.println("Dealer wins.");
			}
		} else
			System.out.println("You win.");
	}

	private void againChoice() {
		while (true) {
			System.out.println("there are " + cardsRemaining + " cards remaining");
			System.out.println("Would you like to play again? Yes or No:");
			String againChoice = kb.next();
			if (againChoice.equalsIgnoreCase("NO")) {
				System.out.println("Thanks for playing " + player.getName() + ", goodbye!");
				System.exit(0);
			} else if (againChoice.equalsIgnoreCase("yes")) {
				player.playerHand.clear();
				dealer.dealerHand.clear();
				return;
			} else {
				System.out.println("invalid entry, try again");
			}
		}
	}

}