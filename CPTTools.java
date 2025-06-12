// Arnav Arora
// BlackJack by Arnav
// Last modified June 12, 2025
// Version 1.4
import arc.*;

public class CPTTools{
    Console con = new Console("Blackjack by Arnav", 1280, 720);
    
    public static void ShowHomescreen(Console con){
		
		// Displaying the main menu
		
		con.println("=====================================================");
        con.println("               Welcome to BLACKJACK             ");
        con.println("=====================================================");
		con.println("");
		con.println("  1 ➤ Play");
		con.println("  2 ➤ View Leaderboard");
		con.println("  3 ➤ Quit");
		con.println("  4 ➤ Help Menu");
		con.println("");
		con.print("Enter your choice: ");
    }
    
    public static double ShowPlayscreen(Console con, int intCardnumber[][], double dblBalance){
		
		con.clear();
		// Displays the gameplay screen, and incorporates betting
		
        String strName;
        double dblBet = 0;
        
        // Ask player for their name and bet
        
        con.println("=====================================================");
        con.println("What is your name? ");
        strName = con.readLine();
        con.println("");
        con.println("Hello, " + strName + "! You have $ "+ dblBalance);
        con.println("How much do you want to bet? $");
        dblBet = con.readDouble();
        
        // Prevents invalid bet inputs
        
        if(dblBet > dblBalance || dblBet < 0){
            con.println("You can't bet that");
            con.println("enter your new bet");
            dblBet = con.readDouble();
        }    
        
        // Created a 5x2 array for the dealer and for the player
       			
       	int intDealerCard[][] = new int[5][2];
       	int intPlayerCard[][] = new int[5][2];       	
    	
    	// Deal two cards to the player and one to the dealer
    	
		intPlayerCard[0][0] = intCardnumber[0][0];
		intPlayerCard[0][1] = intCardnumber[0][1];
		intDealerCard[0][0] = intCardnumber[1][0];
		intDealerCard[0][1] = intCardnumber[1][1];
		intPlayerCard[1][0] = intCardnumber[2][0];
		intPlayerCard[1][1] = intCardnumber[2][1];
		
		// Keeping track of the player's cards, the dealer's cards, and the cards in the deck
		
		int intTopCard = 3;
		int NumDealerCards = 1;
		int NumPlayerCards = 2;
		boolean blnBust = false;
		
		con.clear(); 
		
		// Display's the player's starting hand
		
		con.println("------------------------------------");
		con.println("Your Cards:");
		ShowCard(con, intPlayerCard[0][0], intPlayerCard[0][1]);
		ShowCard(con, intPlayerCard[1][0], intPlayerCard[1][1]);
		con.println("------------------------------------");
		
		con.sleep(1500);
		
		// Display the dealer's first card
		
		con.println("------------------------------------");
		con.println("Dealer's card:");
		ShowCard(con, intDealerCard[0][0], intDealerCard[0][1]);
		con.println("------------------------------------");
		
		con.sleep(1500);
		
		// Adding the total of the players cards
		
		con.println("");
		CalculateTotal(intPlayerCard, NumPlayerCards);
		con.println("Your total: " + CalculateTotal(intPlayerCard, NumPlayerCards));
		
		con.sleep(1000);
		
		int intChoice = 1;
		
		// Main game loop

		while((blnBust != true && NumPlayerCards <= 5) && intChoice == 1){
			
			// Ask User what they want: Hit or Stay
			
			con.println("----------------------------------------");
			con.println("What would you like to do?");
			con.println("1 ➤ Hit");
			con.println("2 ➤ Stay");
			con.print("Enter your choice: ");
			intChoice = con.readInt();
					
			// If User wants to hit
			
			if(intChoice == 1){ 
				 // Add new card to player's hand
				con.clear(); 
				intPlayerCard[NumPlayerCards][0] = intCardnumber[intTopCard][0];
				intPlayerCard[NumPlayerCards][1] = intCardnumber[intTopCard][1];
				con.println("");
				con.println("You've drawn a new card: ");
				ShowCard(con, intPlayerCard[NumPlayerCards][0], intPlayerCard[NumPlayerCards][1]);

				NumPlayerCards++;
				intTopCard++;
				con.println("");
				con.println("Your updated total: " + CalculateTotal(intPlayerCard, NumPlayerCards));
				
				con.sleep(1000);
				
				int intDealerTotal = CalculateTotal(intDealerCard, NumDealerCards);
				int intPlayerTotal = CalculateTotal(intPlayerCard, NumPlayerCards); 	
				
				 // Check for bust
				 
				if(intPlayerTotal > 21){
					
					con.println("You busted with a total of " + intPlayerTotal + "!");
					blnBust = true;
					con.sleep(2000);
					break;
			}
		
				
			// If user wants to stay
			
			}else if(intChoice == 2){
				 			
				// Dealer's turn to hit until 17 or higher
					con.clear();
				while(CalculateTotal(intDealerCard, NumDealerCards) < 17 && NumDealerCards <= 5){
					
					con.println("");
					intDealerCard[NumDealerCards][0] = intCardnumber[intTopCard][0];
					intDealerCard[NumDealerCards][1] = intCardnumber[intTopCard][1];
					con.println("It is now the dealer's turn...");
					con.sleep(2000);
					ShowCard(con, intDealerCard[NumDealerCards][0], intDealerCard[NumDealerCards][1]);
					con.sleep(2000);
					NumDealerCards++;
					intTopCard++;
					con.println("Dealer's total: " + CalculateTotal(intDealerCard, NumDealerCards));
					con.sleep(2000);
					con.println("");
				}
				if(CalculateTotal(intDealerCard, NumDealerCards) > 21){
					con.println("Dealer busted!");
					blnBust = true;
					con.sleep(2000);
				}
			}	
		}	
		
		con.clear(); 
			
		// Compare dealer total and player total and print final outputs
		int intDealerTotal = CalculateTotal(intDealerCard, NumDealerCards);
		int intPlayerTotal = CalculateTotal(intPlayerCard, NumPlayerCards);
		
		con.println("=================  Final Results  =================");
		con.println("Player's Total: " + intPlayerTotal);
		con.println("Dealer's Total: " + intDealerTotal);
		con.println("====================================================");
		
		con.sleep(2000);
		
		if(intPlayerTotal == intDealerTotal){
			con.println("It's a tie");
			con.println("Here is your "+dblBet+" back");
			con.println("Your new balance is: $" + dblBalance);
			
		}else if(intPlayerTotal > 21){
			con.println("You lost");
			dblBalance = dblBalance - dblBet;
			con.println("You lost your bet of $" + dblBet);
			con.println("Your new balance is: $" + dblBalance);
			
		}else if(intDealerTotal > 21){
			con.println("YOU WIN!");
			dblBalance = (dblBet * 2) + dblBalance;
			con.println("Your new balance is: $" + dblBalance);
			
		}else if(intPlayerTotal < intDealerTotal){
			con.println("You lost");
			dblBalance = dblBalance - dblBet;
			con.println("You lost your bet of $" + dblBet);
			con.println("Your new balance is: $" + dblBalance);
				
		}else{ 
			con.println("YOU WIN!");
			dblBalance = (dblBet * 2) + dblBalance;
			con.println("Your new balance is: $" + dblBalance);
			}
			
			// Update leaderboard file
		TextOutputFile Leaders = new TextOutputFile("Leaders.txt", true);
		Leaders.println(strName +" - "+ dblBalance);
		Leaders.close();
		
		return dblBalance;
		}
    
    public static void ShowCard(Console con, int intCardNumber, int intCardSuit){
		
		String strCard;
		String strSuit = "";
		
		// Shows a simple string version of a card
		
		if(intCardNumber == 11){
			strCard = "Jack";
	
		}else if(intCardNumber == 12){
			strCard = "Queen";
			
		}else if(intCardNumber == 13){
			strCard = "King";
	
		}else if(intCardNumber == 1){
			strCard = "Ace";
		
		}else{
			strCard = " " + intCardNumber;
		
		// Assigning suits to the cards
		
		}
		
		if(intCardSuit == 1){
			strSuit = "Diamonds";
			
		}else if(intCardSuit == 2){
			strSuit = "Clubs";

		}else if(intCardSuit == 3){
			strSuit = "Hearts";
		
		}else if(intCardSuit == 4){
			strSuit = "Spades";
			
		}
		
		con.println(strCard +" of "+strSuit);
	} 
		
		
	// Displays the leaderboard
    public static void ShowLeaderboardscreen(Console con){
        con.println("Here is the leaderboard");
        String strName;
		TextInputFile Leaders = new TextInputFile("Leaders.txt");
		while(Leaders.eof() != true){
			strName = Leaders.readLine();
			con.println(strName);
		}
		Leaders.close();
    }
    
    // System.exit
    public static void ShowQuitscreen(Console con){
		System.exit(0);
    }
    
    public static int[][] CreateDeck(int intCardnumber[][]){
        int intCountCol;
        int intCountRow;
        int intCol0 = 1;
        int intCol1 = 1;  
        
        // for loop in a for loop that goes through the entire array
        
        for(intCountRow = 0; intCountRow < 52; intCountRow++){
            for(intCountCol = 0; intCountCol < 3; intCountCol++){
				
				// Set card number (Coloumn 0)
                if(intCountCol == 0){
                    intCardnumber[intCountRow][intCountCol] = intCol0;
                    intCol0++;
                    if(intCol0 == 14){   
                        intCol0 = 1;
                    }
                }    
                    
                // Set Card Suit (Coloumn 1)   
                 else if(intCountCol == 1){
                    intCardnumber[intCountRow][intCountCol] = intCol1;
                    intCol1++;
                    if(intCol1 == 5){ 						
						intCol1 = 1;  						   
                    }
                 }
                 else if(intCountCol == 1){
                        intCol1 = 1;
                       }
                    
                // Set a random number for each card in the deck (Coloumn 2)  
                else if(intCountCol == 2){
                    intCardnumber[intCountRow][intCountCol] = (int)((Math.random() * 100) + 1);    
                }
            }
        }    return intCardnumber;  
    }
   
    // Shows top 5 cards in the deck (for testing)
    
    public static void ShowDeck(Console con, int intCardnumber[][]){
	
	for(int i = 0; i < 5; i++){
		con.println(intCardnumber[i][0] + "-" + intCardnumber[i][1] + "-" + intCardnumber[i][2]);
		
		}
	}
	
	// Shuffles the deck based on a random number in column 2 using bubblesort
	
	public static void ShuffleDeck(int intCardnumber[][]){	
		
		int intCount;
		int intCount2;
		int intTemp;
		
		for(intCount = 0; intCount < 52-1; intCount++){
			for(intCount2 = 0; intCount2 < 52-1; intCount2++){
				if(intCardnumber[intCount2][2] > intCardnumber[intCount2+1][2]){
					
					
					intTemp = intCardnumber[intCount2][1];
					intCardnumber[intCount2][1] = intCardnumber[intCount2+1][1];
					intCardnumber[intCount2+1][1] = intTemp;
					
					intTemp = intCardnumber[intCount2][0];
					intCardnumber[intCount2][0] = intCardnumber[intCount2+1][0];
					intCardnumber[intCount2+1][0] = intTemp;
					
					intTemp = intCardnumber[intCount2][2];
					intCardnumber[intCount2][2] = intCardnumber[intCount2+1][2];
					intCardnumber[intCount2+1][2] = intTemp;
					
					}
				}
			}
		}
		// Calculates total value of a hand
		
		public static int CalculateTotal (int intCardnumber[][], int intNumCards){	
		
		int intCount;
		int intCardValue;
		int intTotal = 0;
		int intBonus = 0;
		
		for(intCount = 0; intCount < intNumCards; intCount++){
			if(intCardnumber[intCount][0] == 11 || intCardnumber[intCount][0] == 12 || intCardnumber[intCount][0] == 13){
				intCardValue = 10;
				
			}else if(intCardnumber[intCount][0] == 1)
			{
				if(intTotal <= 10){
					intCardValue = 11;
					intBonus = 10;
				
				}else{
					intCardValue = 1;
				}
			
			}else{
				intCardValue = intCardnumber[intCount][0];

			}
			
			intTotal = intTotal + intCardValue;
			if(intTotal	> 21){
				intTotal = intTotal - intBonus;
				intBonus = 0;
			}			
		}
		return intTotal;
	}
	
		public static void ShowHelpscreen(Console con){
			
			con.println("Face cards (Jack, Queen, King) are worth 10 points");
			con.println("Aces can be 1 or 11");
			con.println("All other cards have their face value");
			con.println("Player is dealt two cards and dealer is delt 1");
			con.println("Players can hit (take more cards) or stand (keep their current hand)");
			con.println("If a player's hand exceeds 21, they bust and lose");
			con.println("The dealer's hand is also determined by hitting or standing according to house rules");
			con.println("A player wins if their hand is closer to 21 than the dealer's, without busting");
			con.println("The dealer's hand must not go over 21");
			con.println("If the player and dealer have hands of equal value, the bet is returned");
		}
	}	
	
	

    
	
