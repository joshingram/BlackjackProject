# BlackjackProject

## Description: 
This application simulates a game of Black Jack with one player and an opposing dealer.  The app, by calling methods from multiple classes, will build a deck of standard playing cards, shuffle the deck, deal two cards to the player's hand (both showing) and dealer's hand (only the second card showing).  Natural black jacks are announced immediately.  The player can then choose to draw another card (hit) or stay (stand).  If the player exceeds a hand value of 21, the player busts and the game is over.  If the player stands before busting, the dealer then follows prescribed rules (hit on 16 or less, stand on 17 or more).  If the dealer busts, the player wins.  Otherwise, the hand values are compared and a winner is declared (or a push in the event of a tie).  The player is then asked if they wish to play again.  If they choose yes, the hands are cleared (used cards are "burned"), new hands are dealt, and play continues.  If the player selects to leave, they given a parting message which is personalized with their chosen name.  

### Stretch Goals Implemented:
This game uses an 8 deck shoe.  When the current shoe is below 80% of its original size, the dealer will create a new shoe.  Both of these values are declared/initialized in a final field.  This makes counting cards more difficult.  Aces are soft, meaning that Aces can be valued at 1 or 11 depending on the rest of the hand.  Dealer must hit on soft 17.  Additionally, the app includes some basic advice, e.g., don't hit on 21.  

## Lessons Learned:
Bottom line up front:  I found this to be the most difficult yet most enjoyable project so far.  The length of this ReadME reflects this sentiment.

While this was my first project to use enumerated types and final values, I spent relatively little time on these aspects.  I learned the most about, and was most interested in, the realization of "is a" and "has a" relationships and on troubleshooting logic.  

### A better understanding of what is meant by "is a" and "has a.":  
While the Jets project did focus the fundamentals of object oriented programing and did extend classes/abstract classes (FighterJet extended Jet) and did implement interfaces (FighterJet implemented CombatReady), this project really drove home the ideas of "is a" and "has a."  For example, the user's player "is a" player (ThePlayer extended Player) and the dealer is also a player (Dealer extended Player).  Both the dealer and the user's player "have a" BlackjackHand (they instantiate a new BlackjackHand).  However, the dealer "has a" dealer's deck (which is an "is a" of deck) while the user's player does not.  BlackjackHand "is a" Hand - but this also demonstrates the idea of uncoupled classes.  A Hand is simply a collection (array list in this case) of Card objects.  Hand does not specify the number of cards, nor the value of these cards as these could be different for different card games.  Hand is nearly universal for all types of card games.  BlackjackHand is a Hand, but contains unique fields and methods to the game of blackjack.  It applies the principle of Polymorphism to change the inherited abstract method of getHandValue to apply the scoring logic of blackjack - not poker.  

### Troubleshooting logic:  
This project also required the most complicated logic I have written to date.  The logic employed to determine the dealer's actions and comparing various outcomes was a challenge.  This challenge was further complicated by implementing the stretch goal of soft Aces.  This required a way to identify an Ace, determine if it should be valued at 11 or 1 depending on the other cards present in the hand, allow for that value to change based on drawing additional cards, and made the dealer's hit/stand rules more complex by forcing a hit on soft 17 (which required a way to identify a soft 17 hand and apply different rules when identified).  These were enjoyable challenges, but were difficult enough for me to grow in two ways.  

####
1) I used sysouts as diagnostic tools.  In order to find a breakdown or unexpected behavior, I placed sysouts at every step of a logic progression.  The sysouts printed the value of a variable or something that I wanted to track, but they also printed the code line number and the method/class.  This allowed me to pinpoint exactly where problems were occurring and focus troubleshooting on the appropriate areas.  

####
2) Whether it's the creative power of the subconscious mind or simply approaching an issue from a fresh angle, sometimes taking a break is the best course of action.  This can be difficult with the pressure of a looming deadline - when there is no "time to waste."  Further, for those with bias for action and a results-driven mindset, it's natural to simply try harder, concentrate more, do *something*.  But sometimes, the answer is to do nothing.  Take a break.      

### Technologies Used:
Java, Eclipse, git/gitHub, Zoom

### Java Tools Used:
enumerated types, final values, for loops, for each loops, while loops, breaks, invoking methods, passing arguments to methods, extending classes, abstract classes, abstract methods, @Override, array lists, getters/setters, constructors, && ands, || ors, if, else if, else, Scanner, imports