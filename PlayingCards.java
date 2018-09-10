import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PlayingCards {

	static HashMap<Integer, String> deck = new HashMap<>(); //Used to correlate card suits with an integer value
	private static int suitChoice, cardChoice, clubsSize, spadesSize;
	private static int heartsSize, diamondSize, deckSize, cardsLeft;
	private static String cardSuit, cardValue, choice;
	private static boolean continuePlaying;
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		ArrayList<String> suit = new ArrayList<String>();//Save the types of cards in each suit
		ArrayList<String> clubs = new ArrayList<String>();//Save the cards remaining in Clubs suit
		ArrayList<String> spades = new ArrayList<String>();//Save the cards remaining in Spades suit
		ArrayList<String> hearts = new ArrayList<String>();//Save the cards remaining in Hearts suit
		ArrayList<String> diamonds = new ArrayList<String>();//Save the cards remaining in Diamonds suit
		
		//Add cards to suit
		suit.add("A");
		suit.add("2");
		suit.add("3");
		suit.add("4");
		suit.add("5");
		suit.add("6");
		suit.add("7");
		suit.add("8");
		suit.add("9");
		suit.add("10");
		suit.add("J");
		suit.add("Q");
		suit.add("K");
		
		//Add cards to each suit.
		clubs.addAll(suit);
		spades.addAll(suit);
		hearts.addAll(suit);
		diamonds.addAll(suit);
		
		//Correlate card suits with numbers 1-4 for the random number generator.
		deck.put(1, "Clubs"); 
		deck.put(2, "Spades");
		deck.put(3, "Hearts");
		deck.put(4, "Diamonds");
		
		deckSize = 4; //Number of card suits remaining in the deck.
		do 
		{
			getNextCard(clubs, spades, hearts, diamonds); //Get a random card from the deck.
			if (clubs.isEmpty() && spades.isEmpty() && hearts.isEmpty() && diamonds.isEmpty())//Check if each card suit is empty
			{
				System.out.println("Card Deck is Empty!");
				break;
		    }
			System.out.println(cardValue + " of " + cardSuit);

			System.out.println("Clubs Left in Deck    =" + clubs);
			System.out.println("Spades Left in Deck   =" + spades);
			System.out.println("Hearts Left in Deck   =" + hearts);
			System.out.println("Diamonds Left in Deck =" + diamonds);
			System.out.println();
			System.out.println("Do you want to draw another card. Y/N?");
			choice = input.nextLine().trim();
			if (choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("Yes"))
			{
				continuePlaying = true;
			}
			else
			{
				System.out.println("Have a Great Day!");
				continuePlaying = false;
			}
		}while(continuePlaying);	
		
		input.close();
	}
	
	private static void getNextCard(ArrayList<String> clubs, ArrayList<String> spades, ArrayList<String> hearts, ArrayList<String> diamonds) 
	{
		//Get the number of cards remaining in each suit.
		clubsSize = clubs.size();
		spadesSize = spades.size();
		heartsSize = hearts.size();
		diamondSize = diamonds.size();
		
		suitChoice = (int) Math.ceil(Math.random() * deckSize);//Get a random number to select a card suit.	
		
		cardSuit = deck.get(suitChoice);//Select the card suit from the deck that is correlated with the random number. 
		
		//Assign the number of cards remaining in the selected card suit.
		switch (cardSuit) 
		{
			case "Clubs" : cardsLeft = clubsSize;
			break;
			case "Spades" : cardsLeft = spadesSize;
			break;
			case "Hearts" : cardsLeft = heartsSize; 
			break;
			case "Diamonds" : cardsLeft = diamondSize; 
			break;
		}
		
		cardChoice = (int) Math.floor(Math.random() * cardsLeft);//Select random card from the selected suit.
		
		switch (cardSuit) 
		{
			case "Clubs" : {cardValue = clubs.get(cardChoice); clubs.remove(cardChoice);//remove card from suit once it has been chosen.
			if (clubs.isEmpty()) {
				deck.replace(suitChoice, deck.get(deckSize));//Replace empty suit with one that still have cards.
				deck.replace(deckSize, cardSuit);//Shift empty suit to end on deck.
				deckSize--;}//Decrease # of suits so that random number will not choose an empty deck.
			}break;
			
			case "Spades" : {cardValue = spades.get(cardChoice); spades.remove(cardChoice);
			if (spades.isEmpty()) {
				deck.replace(suitChoice, deck.get(deckSize));
				deck.replace(deckSize, cardSuit);
				deckSize--;}
			}break;
			
			case "Hearts" : {cardValue = hearts.get(cardChoice); hearts.remove(cardChoice);
			if (hearts.isEmpty()) {
				deck.replace(suitChoice, deck.get(deckSize));
				deck.replace(deckSize, cardSuit);
				deckSize--;}
			}break;
			
			case "Diamonds" : {cardValue = diamonds.get(cardChoice); diamonds.remove(cardChoice);
			if (diamonds.isEmpty()) {
				deck.replace(suitChoice, deck.get(deckSize));
				deck.replace(deckSize, cardSuit);
				deckSize--;}
			}break;
		}
	}
}
