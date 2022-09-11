# BlackjackProject

## Description: 
This application simulates a game of Black Jack with one player and an opposing dealer.  The app, by calling methods from multiple classes, will build a deck of standard playing cards, shuffle the deck, deal two cards to the player's hand (both showing) and dealer's hand (only the second card showing).  The player can then choose to draw another card (hit) or stay (stand) based on their own game strategy.  If the player exceeds a hand value of 21, the player busts and the game is over.  If the player stands before busting, the dealer then follows prescribed rules (hit on 16 or less, stand on 17 or more).  If the dealer busts, the player wins.  Otherwise, the hand values are compared and a winner declared (or a push in the event of a tie).  The player is then asked if they wish to play again.  If they choose yes, the hands are cleared (used cards are "burned"), new hands are dealt, and play continues.  If the player selects to leave, they given a parting message which is personalized with their chosen name.  

### Game Embellishments:
This game uses an 8 deck shoe.  When the current shoe is below 80% of its original size, the dealer will create a new shoe.  This makes counting cards more difficult.  Aces are soft, meaning that Aces can be valued at 1 or 11 depending on the rest of the hand.  Dealer must hit on soft 17.  Additionally, the app includes some basic advice, e.g., don't hit on 21.  

### Lessons Learned:

### Technologies Used:
Java, Eclipse, git/gitHub, Zoom