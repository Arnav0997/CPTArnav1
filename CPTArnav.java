import arc.*;

public class CPTArnav{
	public static void main(String[] args){
		Console con = new Console();
		
		int intScreenType;
		
		CPTTools.ShowHomescreen(con);
		intScreenType = con.readInt();
		
		if(intScreenType = 1){
			con.clear(500);
			CPTTools.ShowPlayscreen(con);
		}else if(intScreenType = 2){
			con.clear(500);
			CPTTools.ShowLeaderboardscreen(con);
		}else if(intScreenType = 3){
			con.clear(500);
			CPTTools.ShowQuitscreen(con); 
		}else{
			con.println("That's not an option");
		}
	}
}
