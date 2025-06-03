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
}
