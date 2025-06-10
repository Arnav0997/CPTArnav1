import arc.*;

public class CPTArnav{
	
	public static void main(String[] args){
		Console con = new Console();
    
		int intCardnumber[][] = new int[52][3];
		int intScreenType = 0;
	
		while(intScreenType !=3){			
			CPTTools.ShowHomescreen(con);
			intScreenType = con.readInt();
		
			if(intScreenType == 1){
				CPTTools.ShowPlayscreen(con, intCardnumber);
			}else if(intScreenType == 2){
				CPTTools.ShowLeaderboardscreen(con);
			}else if(intScreenType == 3){
				CPTTools.ShowQuitscreen(con); 
			}else if(intScreenType == 0){
				CPTTools.CreateDeck(intCardnumber);
				CPTTools.ShowDeck(con, intCardnumber);
				CPTTools.ShuffleDeck(intCardnumber);
				CPTTools.ShowDeck(con, intCardnumber);
			}else{
				con.println("That's not an option");
			}
			
			

		}
	}
}
