// Arnav Arora
// BlackJack by Arnav
// Last modified June 12, 2025
// Version 1.4
import arc.*;

public class CPTArnav{
	
	public static void main(String[] args){
		Console con = new Console("Blackjack by Arnav", 1280, 720);
    
		int intCardnumber[][] = new int[52][3];	// Deck of cards
		int intScreenType = 0;
		
		while(intScreenType !=3){			
			CPTTools.ShowHomescreen(con);
			intScreenType = con.readInt();
		
			if(intScreenType == 1){			
				CPTTools.CreateDeck(intCardnumber);
				CPTTools.ShuffleDeck(intCardnumber);
				// CPTTools.ShowDeck(con, intCardnumber);
				CPTTools.ShowPlayscreen(con, intCardnumber);
				
			}else if(intScreenType == 2){
				CPTTools.ShowLeaderboardscreen(con);
				
			}else if(intScreenType == 3){
				CPTTools.ShowQuitscreen(con); 
			}else if(intScreenType == 0){
				CPTTools.ShowDeck(con, intCardnumber);
				CPTTools.ShowCard(con, intCardnumber[0][0], intCardnumber [0][1]);
			}else if (intScreenType == 5){
				con.println("How do robots eat pizza? One byte at a time.");
			}else if (intScreenType ==4){
				CPTTools.ShowHelpscreen(con);
			}else{
				con.println("That's not an option");
			}
			
			

		}
	}
}
