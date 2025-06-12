import arc.*;

public class CPTTools{
    Console con = new Console();
    
    public static void ShowHomescreen(Console con){
		
		// Displaying the homescreen
		
        con.println("Welcome to BlackJack");
        con.println("Enter 1 to play");
        con.println("Enter 2 to view leaderboard");
        con.println("Enter 3 to quit");
    }
    
    public static void ShowPlayscreen(Console con, int intCardnumber[][]){
		
		// Created the betting and intro to game
		
        String strName;
        double dblBet = 0;
        double dblBalance = 1000;
        
        con.println("Welcome to BlackJack");
        con.println("What is your name");
        strName = con.readLine();
        con.println("Here is $1000 "+strName+"!");
        con.println("How much do you want to bet?");
        dblBet = con.readDouble();
        
        if(dblBet > dblBalance || dblBet < 0){
            con.println("You can't bet that");
            con.println("enter your new bet");
            dblBet = con.readDouble();
        }    
        
        // Created a 5x2 array for the dealer and for the player
       			
       	int intDealerCard[][] = new int[5][2];
       	int intPlayerCard[][] = new int[5][2];       	
    	
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
		
		// Giving the player 2 cards
		
		con.println("");
		con.println("");
		con.println("");
		con.println("");	
		con.println("Here are your cards ");
		ShowCard(con, intPlayerCard[0][0], intPlayerCard[0][1]);
		ShowCard(con, intPlayerCard[1][0], intPlayerCard[1][1]);
		
		con.println("");
		con.println("");
		con.println("");
		con.println("");
		con.println("Here is the dealer's card");
		ShowCard(con, intDealerCard[0][0], intDealerCard[0][1]);
		
		// Adding the total of the players cards
		
		con.println("");
		con.println("");
		con.println("");
		con.println("");
		CalculateTotal(intPlayerCard, NumPlayerCards);
		con.println("Total for player " + CalculateTotal(intPlayerCard, NumPlayerCards));
		
		int intChoice = 1;
		
		// Created the main game while loop

		while((blnBust != true || NumPlayerCards != 5) && intChoice == 1){
			
			// Ask User what they want: Hit or Stay
			
			con.println("");
			con.println("");
			con.println("");
			con.println("");
			con.println("Enter 1 to hit or 2 to stay");
			intChoice = con.readInt();
					
			// If User wants to hit
			
			if(intChoice == 1){ 
				 
				intPlayerCard[NumPlayerCards][0] = intCardnumber[intTopCard][0];
				intPlayerCard[NumPlayerCards][1] = intCardnumber[intTopCard][1];
				con.println("");
				con.println("");
				con.println("");
				con.println("");
				con.println("Here is your next card");
				ShowCard(con, intPlayerCard[NumPlayerCards][0], intPlayerCard[NumPlayerCards][1]);

				NumPlayerCards++;
				intTopCard++;
				con.println("");
				con.println("");
				con.println("");
				con.println("");
				con.println("Total for player " + CalculateTotal(intPlayerCard, NumPlayerCards));
				
			if(CalculateTotal(intPlayerCard, NumPlayerCards) >= 21){
				con.println("You busted");
			}
		
				
			// If user wants to stay
			
			}else if(intChoice == 2){
				 			
				// Dealers turn
			
				while(CalculateTotal(intDealerCard, NumDealerCards) < 17 || NumDealerCards != 5){
					
					con.println("");
					con.println("");
					con.println("");
					con.println("");
					intDealerCard[NumDealerCards][0] = intCardnumber[intTopCard][0];
					intDealerCard[NumDealerCards][1] = intCardnumber[intTopCard][1];
					con.println("It is now the dealer's turn");
					ShowCard(con, intDealerCard[NumDealerCards][0], intDealerCard[NumDealerCards][1]);
					con.println("Total for CPU " + CalculateTotal(intDealerCard, NumDealerCards));
					NumDealerCards++;
					intTopCard++;
				}
				if(CalculateTotal(intDealerCard, NumDealerCards) >= 21){
				con.println("You busted");
			}	
		}	
			
			// Compare dealer total and player total
			
			if(CalculateTotal(intDealerCard, NumDealerCards)) > (CalculateTotal(intPlayerCard, NumPlayerCards)){
				con.println("You lost");
			}
		}
    
    public static void ShowCard(Console con, int intCardNumber, int intCardSuit){
		
		String strCard;
		String strSuit = "";
		
		// Assigning certain cards their actual value
		
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
		
		
    
    public static void ShowLeaderboardscreen(Console con){
        con.println("Here is the leaderboard");
    }
    
    public static void ShowQuitscreen(Console con){
        con.println("Thanks for playing");
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
    
    public static void ShowDeck(Console con, int intCardnumber[][]){
	
	for(int i = 0; i < 5; i++){
			con.println(intCardnumber[i][0] + "-" + intCardnumber[i][1] + "-" + intCardnumber[i][2]);
		}
	}
	
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
		
		public static int CalculateTotal (int intCardnumber[][], int intNumCards){	
		
		int intCount;
		int intCardValue;
		int intTotal = 0;
		
		
		for(intCount = 0; intCount < intNumCards; intCount++){
			if(intCardnumber[intCount][0] == 11 || intCardnumber[intCount][0] == 12 || intCardnumber[intCount][0] == 13){
				intCardValue = 10;
				
			}else if(intCardnumber[intCount][0] == 1)
			{
				if(intTotal <= 10){
					intCardValue = 11;
				
				}else{
					intCardValue = 1;
				}
			
			}else{
				intCardValue = intCardnumber[intCount][0];

			}
			
			intTotal = intTotal + intCardValue;
									
		}
		return intTotal;
	}
}	
	
	

    
	
