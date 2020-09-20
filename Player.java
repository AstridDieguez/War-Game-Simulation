import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

public class Player {
	//public static int battles = 0;
	//public static int wars = 0;
	public static ArrayList<Integer> holder = new ArrayList<Integer>();
	public ArrayList<Integer> deck = new ArrayList<Integer>();
	
	public Player(int ...cards) {
		
		for(int i = 0; i < cards.length - 1; i++)
		{
			deck.add(cards[i]);
		}
	}
	public Player() {
		
	}
	public int getRemaining()
	{
		return deck.size();
	}
    public static void addToPlayer(Player player, ArrayList<Integer> holder)
    {
    	Collections.shuffle(holder);
    	for(int i = 0; i < holder.size(); i++)
    	{
    		player.deck.add(holder.get(i));
    	}
    	holder.clear();
    }
    public static void addToHolder(ArrayList<Integer> player, ArrayList<Integer> holder, int num)
    {
    	for(int i = 0; i <= num; i++)
    	{
    		holder.add(player.get(i));
    	}
    }
    public static void removeFromPlayer(ArrayList<Integer> playerDeck, int num)
    {
    	// Number is 4
    	// ArrayList is {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
    	// Remove 5 (i <= num)
    	// Arraylist is {6, 7, 8, 9, 10}
    	
    	// Number is 8
    	// ArrayList is {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
    	// Remove 9
    	// ArrayList is {10}
    	
    	for(int i = 0; i <= num; i++)
    	{
    		playerDeck.remove(0);
    	}
    }
    public static void printArrayList(ArrayList<Integer> arr)
    {
    	System.out.print("{");
    	for(int i = 0; i < arr.size(); i++)
    	{
    			
    		if(i == arr.size() - 1)
    			System.out.print(arr.get(i));
    		else
       			System.out.print(arr.get(i) + ", ");
    	}
    	System.out.print("}");
    }
    public static void Shuffle(int[] d)
    {
       int rand = (int)(Math.random() * d.length);
        for(int i = 0; i < d.length; i++)
        {
          int temp = d[rand];
          d[rand] = d[i];
          d[i] = temp;
          rand = (int)(Math.random() * d.length);
        }
    }
    public static String IdentifyCard(int card)
    {
        String suit, rank;
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        rank = ranks[card % 13];
        if(card >= 0 && card <= 12)
            suit = "Clubs";
        else if(card >= 13 && card <= 25)
            suit = "Diamonds";
        else if(card >= 26 && card <= 38)
            suit = "Hearts";
        else
            suit = "Spades";
            
       return rank + " of " + suit;
    }

}
