import arc.*;

public class CPTTools{
    Console con = new Console();
    
    public static void ShowHomescreen(Console con){
        con.println("Welcome to BlackJack");
        con.println("Enter 1 to play");
        con.println("Enter 2 to view leaderboard");
        con.println("Enter 3 to quit");
    }
    
    public static void ShowPlayscreen(Console con){
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
	
	for(int i = 0; i < 52; i++){
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
}

    
	
