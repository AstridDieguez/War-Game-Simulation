import javax.swing.JFrame;
//import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Image;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
//import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.border.Border;
//import java.awt.GridLayout;
//import java.awt.Container;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import javax.swing.SwingUtilities;

public class Client {
	public static JFrame frame = new JFrame("War");
	public static int width = 160;
	public static int height = (int)(width * 1.4);
	public static Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
	public static ImageIcon BACK = new ImageIcon("BACK.jpg");
	public static int battles = 0;
	public static int wars = 0;
	public static boolean battle = true;
	public static boolean war = false;
	public static boolean win = false;
	public static boolean gameWin = false;
	public static int fourCount = 4;
	public static ArrayList<ImageIcon> icons = new ArrayList<ImageIcon>(Arrays.asList
			(new ImageIcon("clubs-2.jpg"), new ImageIcon("clubs-3.jpg"),
					new ImageIcon("clubs-4.jpg"), new ImageIcon("clubs-5.jpg"),
					new ImageIcon("clubs-6.jpg"), new ImageIcon("clubs-7.jpg"),
					new ImageIcon("clubs-8.jpg"), new ImageIcon("clubs-9.jpg"),
					new ImageIcon("clubs-10.jpg"), new ImageIcon("clubs-j.jpg"),
					new ImageIcon("clubs-q.jpg"), new ImageIcon("clubs-k.jpg"),
					new ImageIcon("clubs-a.jpg"), new ImageIcon("diamonds-2.jpg"),
					new ImageIcon("diamonds-3.jpg"), new ImageIcon("diamonds-4.jpg"),
					new ImageIcon("diamonds-5.jpg"), new ImageIcon("diamonds-6.jpg"),
					new ImageIcon("diamonds-7.jpg"), new ImageIcon("diamonds-8.jpg"),
					new ImageIcon("diamonds-9.jpg"), new ImageIcon("diamonds-10.jpg"),
					new ImageIcon("diamonds-j.jpg"), new ImageIcon("diamonds-q.jpg"),
					new ImageIcon("diamonds-k.jpg"), new ImageIcon("diamonds-a.jpg"),
					new ImageIcon("spades-2.jpg"), new ImageIcon("spades-3.jpg"),
					new ImageIcon("spades-4.jpg"), new ImageIcon("spades-5.jpg"),
					new ImageIcon("spades-6.jpg"), new ImageIcon("spades-7.jpg"),
					new ImageIcon("spades-8.jpg"), new ImageIcon("spades-9.jpg"),
					new ImageIcon("spades-10.jpg"), new ImageIcon("spades-j.jpg"),
					new ImageIcon("spades-q.jpg"), new ImageIcon("spades-k.jpg"),
					new ImageIcon("spades-a.jpg"), new ImageIcon("hearts-2.jpg"),
					new ImageIcon("hearts-3.jpg"), new ImageIcon("hearts-4.jpg"),
					new ImageIcon("hearts-5.jpg"), new ImageIcon("hearts-6.jpg"),
					new ImageIcon("hearts-7.jpg"), new ImageIcon("hearts-8.jpg"), 
					new ImageIcon("hearts-9.jpg"), new ImageIcon("hearts-10.jpg"), 
					new ImageIcon("hearts-j.jpg"), new ImageIcon("hearts-q.jpg"), 
					new ImageIcon("hearts-k.jpg"), new ImageIcon("hearts-a.jpg")));
	public static ArrayList<ImageIcon> sizedIcons = new ArrayList<ImageIcon>();
	public static Player player1 = new Player();
	public static Player player2 = new Player();
	public static JLabel player_one_card;
	public static JLabel player_two_card;
	public static JLabel p1_cardsLeft;
	public static JLabel p2_cardsLeft;
	
	public static ArrayList<JLabel> backCards = null;
	public static JLabel fourth_p1 = null;
	public static JLabel fourth_p2 = null;
	
    public static void paintNumbers(Player p1, Player p2)
    {
    	frame.remove(p1_cardsLeft);
    	frame.remove(p2_cardsLeft);
    	
		p1_cardsLeft = new JLabel(Integer.toString(p1.getRemaining()));
		p2_cardsLeft = new JLabel(Integer.toString(p2.getRemaining()));
		
		p1_cardsLeft.setBounds(90, 200, 200, 200);
		p2_cardsLeft.setBounds(1000, 200, 200, 200);
		
		p1_cardsLeft.setFont(new Font("Arial", Font.PLAIN, 80));
		p2_cardsLeft.setFont(new Font("Arial", Font.PLAIN, 80));
		
		frame.add(p1_cardsLeft);
		frame.add(p2_cardsLeft);
    	
    }
    public static void paintBattle(Player p1, Player p2)
    {
    	int cardNumber_p1 = p1.deck.get(0);
    	int cardNumber_p2 = p2.deck.get(0);
    	
    	player_one_card = new JLabel(sizedIcons.get(cardNumber_p1));
    	player_two_card = new JLabel(sizedIcons.get(cardNumber_p2));
		
    	player_one_card.setBounds(380, 338, width, height);
    	player_two_card.setBounds(710, 338, width, height);
    	
    	player_one_card.setBorder(border);
    	player_two_card.setBorder(border);
    	
    	frame.add(player_one_card);
    	frame.add(player_two_card);
    	
    }
    public static void paintWar(Player p1, Player p2, int fourCount) 
    {
    	int hPos = 0;
    	int skipFour = fourCount;
    	int cardNumber_p1 = p1.deck.get(skipFour);
    	int cardNumber_p2 = p2.deck.get(skipFour);
        backCards = new ArrayList<JLabel>(Arrays.asList(new JLabel(BACK),
    			new JLabel(BACK), new JLabel(BACK), new JLabel(BACK), new JLabel(BACK),
    			new JLabel(BACK)));    
    	for(int i = 0; i < 3; i++)
    	{
    		backCards.get(i).setBorder(border);
    		backCards.get(i).setBounds(220 + hPos, 338, width, height);
    		hPos += 50;
    		frame.add(backCards.get(i));
    	}
    	fourth_p1 = new JLabel(sizedIcons.get(cardNumber_p1));
    	fourth_p1.setBorder(border);
    	fourth_p1.setBounds(220 + hPos, 338, width, height);
    	frame.add(fourth_p1);
    	hPos = 0;
    	for(int i = 3; i < 6; i++)
    	{
    		backCards.get(i).setBorder(border);
    		backCards.get(i).setBounds(870 - hPos, 338, width, height);
    		hPos += 50;
    		frame.add(backCards.get(i));
    	}
        fourth_p2 =  new JLabel(sizedIcons.get(cardNumber_p2));
    	fourth_p2.setBorder(border);
    	fourth_p2.setBounds(870 - hPos, 338, width, height);
    	frame.add(fourth_p2);
    	
		frame.getContentPane().setComponentZOrder(fourth_p1, 0);
		frame.getContentPane().setComponentZOrder(fourth_p2, 1);
		frame.getContentPane().setComponentZOrder(backCards.get(2), 2);
		frame.getContentPane().setComponentZOrder(backCards.get(1), 3);
		frame.getContentPane().setComponentZOrder(backCards.get(0), 4);
		frame.getContentPane().setComponentZOrder(backCards.get(5), 5);
		frame.getContentPane().setComponentZOrder(backCards.get(4), 6);
		frame.getContentPane().setComponentZOrder(backCards.get(3), 7);
		
    }
	public static void main(String[] args) {
		for(int i = 0; i < icons.size(); i++)
		{
			Image getImage = icons.get(i).getImage();
			Image scaleImage = getImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			sizedIcons.add(new ImageIcon(scaleImage));
			if(i == icons.size()- 1) {
				getImage = BACK.getImage();
				scaleImage = getImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
				BACK = new ImageIcon(scaleImage);
			}
		}
		
		int[] deck = new int[52];
		for(int i = 0; i < deck.length; i++)
		{
		    deck[i] = i;
		}
		Player.Shuffle(deck);
		for(int i = 0; i < deck.length - 1; i += 2)
		{
			player1.deck.add(deck[i]);
			player2.deck.add(deck[i + 1]);
		}
		int contentWidth = 1250;
		int contentHeight = 900;

		frame.setLayout(null);
		frame.setResizable(false);
		
		frame.getContentPane().setPreferredSize(new Dimension(contentWidth, contentHeight));
		frame.getContentPane().setBackground(new Color(23, 164, 12));
	
		JLabel label = new JLabel(BACK);
		JLabel label2 = new JLabel(BACK);
		
		p1_cardsLeft = new JLabel(Integer.toString(player1.getRemaining()));
		p2_cardsLeft = new JLabel(Integer.toString(player2.getRemaining()));
		p1_cardsLeft.setBounds(10, 10, 100, 50);
		p2_cardsLeft.setBounds(1240, 10, 100, 50);
		frame.add(p1_cardsLeft);
		frame.add(p2_cardsLeft);

		// Player decks
		label.setBounds(10, 338, width, height);
		label2.setBounds(1080, 338, width, height);
		
		label.setBorder(border);
		label2.setBorder(border);
		
		JButton draw = new JButton("DRAW");
		draw.setFont(new Font("Arial", Font.PLAIN, 75));
		draw.setBounds(413, 650, 425, 175);
		draw.setBorder(border);
		
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(battle)
				{
					//remove previous JLabel Cards
					try
					{
						frame.remove(player_one_card);
						frame.remove(player_two_card);
						
						for(int i = 0; i < backCards.size(); i++) {
							frame.remove(backCards.get(i));
						}
						frame.remove(fourth_p1);
						frame.remove(fourth_p2);
						
					}
					catch(Exception e) {
						// DO NOTHING
					}
					paintBattle(player1, player2);
					frame.repaint();
					
					if((player1.deck.get(0) % 13) > (player2.deck.get(0) % 13))
					{
						System.out.print("[" + player1.deck.get(0) + ", " + player2.deck.get(0) + "] ");
						System.out.print((player1.deck.get(0) % 13) + ", " + (player2.deck.get(0) % 13));
						Player.holder.add(player1.deck.get(0));
						Player.holder.add(player2.deck.get(0));
						player1.deck.remove(0);
						player2.deck.remove(0);
						Player.addToPlayer(player1, Player.holder);
						battles++;
						System.out.print(" P1: " + player1.getRemaining() + ", P2: " + player2.getRemaining());
						System.out.println();
						paintNumbers(player1, player2);
						frame.repaint();
					}
					else if((player1.deck.get(0) % 13) < (player2.deck.get(0) % 13))
					{
						System.out.print("[" + player1.deck.get(0) + ", " + player2.deck.get(0) + "] ");
						System.out.print((player1.deck.get(0) % 13) + ", " + (player2.deck.get(0) % 13));
						Player.holder.add(player1.deck.get(0));
						Player.holder.add(player2.deck.get(0));
						player1.deck.remove(0);
						player2.deck.remove(0);
						Player.addToPlayer(player2, Player.holder);
						battles++;
						System.out.print(" P1: " + player1.getRemaining() + ", P2: " + player2.getRemaining());
						System.out.println();
						paintNumbers(player1, player2);
						frame.repaint();
					}
					else
					{
						war = true;
						battle = false;
					}
				}
				else if(war)
				{
					wars++;
					if(fourCount > player1.getRemaining() - 1 || fourCount > player2.getRemaining() - 1) {
						
						if(fourCount > player1.getRemaining() - 1) {
							player1.deck.clear();
							gameWin = true;
							//disable draw button b/c player 2 wins
							
						}
						else if(fourCount > player2.getRemaining() - 1) {
							player2.deck.clear();
							gameWin = true;
						}
					}
					else
					{
						try
						{
							frame.remove(player_one_card);
							frame.remove(player_two_card);
							
							for(int i = 0; i < backCards.size(); i++) {
								frame.remove(backCards.get(i));
							}
							frame.remove(fourth_p1);
							frame.remove(fourth_p2);
						}
						catch(Exception e) {
							// DO NOTHING
						}
						paintWar(player1, player2, fourCount);
						frame.repaint();
						do
						{
							if((player1.deck.get(fourCount) % 13) > (player2.deck.get(fourCount) % 13))
							{
								Player.addToHolder(player1.deck, Player.holder, fourCount);
								Player.addToHolder(player2.deck, Player.holder, fourCount);
								Player.removeFromPlayer(player1.deck, fourCount);
								Player.removeFromPlayer(player2.deck, fourCount);
								Player.addToPlayer(player1, Player.holder);
								paintNumbers(player1, player2);
								frame.repaint();
								
								System.out.println("Player one wins the war");
								System.out.print("P1: " + player1.deck.size() + ", P2: " + player2.deck.size());
								
								win = true;
								war = false;
							}
							else if((player1.deck.get(fourCount) % 13) < (player2.deck.get(fourCount) % 13))
							{
								Player.addToHolder(player1.deck, Player.holder, fourCount);
								Player.addToHolder(player2.deck, Player.holder, fourCount);
								Player.removeFromPlayer(player1.deck, fourCount);
								Player.removeFromPlayer(player2.deck, fourCount);
								Player.addToPlayer(player2, Player.holder);
								paintNumbers(player1, player2);
								frame.repaint();
								
								System.out.println("Player two wins the war");
								System.out.print("P1: " + player1.deck.size() + ", P2: " + player2.deck.size());
								
								win = true;
								war = false;
							}
							else
							{
								fourCount += 4;
							}
						}
						while(!win && !gameWin && !war);	
					}

				}
				if(win)
				{
					battle = true;
					win = false;
					fourCount = 4;
				}
				else if(gameWin)
				{
					if(player1.deck.size() == 0)
						System.out.println("Player 2 wins the game");
					else
						System.out.println("Player 1 wins the game");
					
					draw.setEnabled(false);
				}
				System.out.print("\n3");

			}
		};
		
		draw.addActionListener(action);

		frame.add(label);
		frame.add(label2);
		
		frame.add(draw);

		frame.pack();
		frame.setVisible(true);

	}

}
