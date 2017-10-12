 import java.util.Random;
import java.util.Scanner;
 /*
  * Leon You 
  * Mr. Levin 
  * Period. 6-7
  * ChatBot 
  */
public class ChatBotLeon {
	public String getGreeting()
	{
		return "So you want to talk about Counter Strike: Global Offensive? What would you like to talk about? Skins? Weapons? Players?";
	}
	public String getResponse(String statement)
	{
		String response = "";
		
		if(findKeyword(statement, "no") >=0)
		{
			System.out.println("No? Well back to the main page you go!");
			ChatBotRunner chatbot1 = new ChatBotRunner();
			String[] args = new String[0] ;
		    chatbot1.main(args);
		}
		if (statement.length() == 0)
		{
			response = "Say something, please.";
		}
		if(findKeyword(statement, "fact") >=0)
		{
			System.out.println("Have a fact!");
			response = getRandomFact();
		}
		else if (findKeyword(statement, "skins") >= 0)
		{
			System.out.println ("My favorite skin is the AWP Dragonlore, How much have you spent on skins?");		
			Scanner a = new Scanner (System.in);
			String skinStatement = a.nextLine();
			response = topicSkins(skinStatement);
		}
		else if (findKeyword(statement, "weapons") >= 0)
		{
			System.out.println ("My favorite rifle is the AK-47, what's yours?");
			Scanner a = new Scanner (System.in);
			String weaponStatement = a.nextLine();
			response = topicWeapons(weaponStatement);
		}
		else if (findKeyword(statement, "maps") >= 0)
		{
			System.out.println ("My favorite map is Dust 2, what's yours?");
			Scanner a = new Scanner (System.in);
			String mapStatement = a.nextLine();
			response = topicMaps(mapStatement);
		}
		else 
		{
			return "I don't know what "+statement+ " is, lets talk about something else.";
		}
		return response;
	}
	private String topicSkins(String statement)
	{
		int money = Integer.parseInt(statement);
		if(money<=100)
		{
			return "Wow, you've spent less than me!";
		}
		else
		{
			return "Wow, you've spent more than me!";
		}
	}
	private String topicWeapons(String statement)
	{
		if(findKeyword(statement, "M4A1")>=0)
		{
			return "M4A1 is a pretty accurate rifle!";
		}
		else if(findKeyword(statement, "Galil Ar")>=0)
		{
			return "That's a pretty rare rifle to like!";
		}
		else if(findKeyword(statement, "M4A4")>=0)
		{
			return "M4A4's a pretty accurate rifle!!";
		}
		else if(findKeyword(statement, "AUG")>=0)
		{
			return "AUG's has a nice scope!";
		}
		else if(findKeyword(statement, "Scout")>=0)
		{
			return "The Scout has nice jump shot accuracy!";
		}
		else if(findKeyword(statement, "Famas")>=0)
		{
			return "Famas is a good budget rifle!";
		}
		else if(findKeyword(statement, "SG")>=0)
		{
			return "The SG has a pretty good scope!";
		}
		else if(findKeyword(statement, "AWP")>=0)
		{
			return "Best gun in the game Amirite!!";
		}
		else if(findKeyword(statement, "Auto")>=0)
		{
			return "I can't be friends with you I'm sorry!";
		}
		else if(findKeyword(statement, "AK47")>=0)
		{
			return "Ayyy, let's go!";
		}
		else
		{
			return "Sorry, I Haven't heard of that rifle.";
		}
	}
	private String topicMaps(String statement)
	{
		if(findKeyword(statement, "inferno")>=0)
		{
			return "Inferno's a pretty cool map!";
		}
		else if(findKeyword(statement, "overpass")>=0)
		{
			return "Overpass' a pretty cool map!";
		}
		else if(findKeyword(statement, "nuke")>=0)
		{
			return "Nuke's a pretty cool map!";
		}
		else if(findKeyword(statement, "cobblestone")>=0)
		{
			return "Cobblestone's a pretty cool map!";
		}
		else if(findKeyword(statement, "train")>=0)
		{
			return "Train's a pretty cool map!";
		}
		else if(findKeyword(statement, "mirage")>=0)
		{
			return "Mirage's a pretty cool map!";
		}
		else if(findKeyword(statement, "cache")>=0)
		{
			return "Cache's a pretty cool map!";
		}
		else if(findKeyword(statement, "Dust 2")>=0)
		{
			return "Thats your favorite map too? That's awesome!!";
		}
		else
		{
			return "Sorry, I Haven't heard of that map.";
		}
	}
	// took from ChatBotLevin
	private int findKeyword(String statement, String goal, int startPos)
	{
		
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		// The only change to incorporate the startPos is in
		// the line below
		int psn = phrase.indexOf(goal, startPos);

		// Refinement--make sure the goal isn't part of a
		// word
		while (psn >= 0)
		{
			// Find the string of length 1 before and after
			// the word
			String before = " ", after = " ";
			if (psn > 0)
			{
				before = phrase.substring(psn - 1, psn);
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(
						psn + goal.length(),
						psn + goal.length() + 1);
			}

			// If before and after aren't letters, we've
			// found the word
			if (((before.compareTo("a") < 0) || (before
					.compareTo("z") > 0)) // before is not a
											// letter
					&& ((after.compareTo("a") < 0) || (after
							.compareTo("z") > 0)))
			{
				return psn;
			}

			// The last position didn't work, so let's find
			// the next, if there is one.
			psn = phrase.indexOf(goal, psn + 1);

		}

		return -1;
	}
	private int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
	}
	private String getRandomFact()
	{
		Random r = new Random ();
		return randomFact [r.nextInt(randomFact.length)];
	}
	private String [] randomFact = 
	{
			"When it first launched, CS:GO didn’t have Competitive Mode and Skins.",
			"You can actually pull out money from ATM beside bank at Overpass.",
			"Chickens follow you if you press \"E\""
	};
}
