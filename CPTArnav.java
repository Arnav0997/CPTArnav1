import arc.*;

public class CPTArnav{
	public static void main(String[] args){
		Console con = new Console();
		
		int intScreenType = 0;
		

		
		while(intScreenType !=3){			
			CPTTools.ShowHomescreen(con);
			intScreenType = con.readInt();
		
			if(intScreenType == 1){
				CPTTools.ShowPlayscreen(con);
			}else if(intScreenType == 2){
				CPTTools.ShowLeaderboardscreen(con);
			}else if(intScreenType == 3){
				CPTTools.ShowQuitscreen(con); 
			}else{
				con.println("That's not an option");
			}
			CPTTools.ShowDeck(CPTTools.CreateDeck());
		}
	}
}
