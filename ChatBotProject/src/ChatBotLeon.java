 import java.util.Random;
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
		
		if (statement.length() == 0)
		{
			response = "Say something, please.";
		}
		
		else if (findKeyword(statement, "skins") >= 0)
		{
			response = topicSkins(statement);
		}
		else if (findKeyword(statement, "weapons") >= 0)
		{
			response = topicWeapons(statement);
		}
		else if (findKeyword(statement, "maps") >= 0)
		{
			response = topicMaps(statement);
		}
		else 
		{
			return "I don't know what "+statement+ " is, lets talk about something else.";
		}
		return response;
	}
	private String topicSkins(String statement)
	{
		return "My favorite skin is the AWP Dragonlore, what's yours?";		
		
		if (findKeyword(statement, "skins") >= 0)
		{
			response = topicSkins2(statement);
		}
	}
	private String topicSkins2(String statement)
	{
		
	}
	private String topicWeapons(String statement)
	{
		return "My favorite weapon is the AK-47, what's yours?";
	}
	private String topicMaps(String statement)
	{
		return "My favorite map is Dust 2, what's yours?";
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
	private String [] listSkins = {};
	private String [] listGuns = {"M4A1", "AWP", "AUG", "galil", "FAMAS"};
}
