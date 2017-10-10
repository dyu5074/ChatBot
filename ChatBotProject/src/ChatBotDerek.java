public class ChatBotDerek {
	public String getGreeting()
	{
		return "Hey, Lets talk about League of Legends. Do you know the characters and the items in the game?";
	}
	public String getResponse(String statement)
	{
		String response = "";
		if(statement.length() == 0 )
		{
			response = "Lets talk";
		}
		else if (findKeyword(statement, "no") >= 0)
		{
			response = "Well, you chose the wrong game.";
		}
		else if (findKeyword(statement, "ye") >= 0)
		{
			response = "Have you ever played this game?";
		}
		else if (findKeyword(statement, "yes") >= 0)
		{
			
		}
		else if (findKeyword(statement, "characters") >= 0)
		{
			response = "There are over 100 characters. Here are all the characters you can choose from. Pick a number between 1 and 138.";
			Characters(38);
		}
		else if (findKeyword(statement, "items") >= 0)
		{
			response = "Buy items to get stronger. ";
		}
			return response;
	}
	private boolean Characters(int x)
	{
		if (x == 1)
		{
			System.out.println("Annie");
		}
		else if (x == 2)
		{
			System.out.println("Ashe");
		}
		else if (x == 3)
		{
			System.out.println("Garen");
		}
		else if (x == 4)
		{
			System.out.println("Alistar");
		}
		else if (x == 5)
		{
			System.out.println("Akali");
		}
		else if (x == 6)
		{
			System.out.println("Katarina");
		}
		else if (x == 7)
		{
			System.out.println("Ornn");
		}
		else if (x == 8)
		{
			System.out.print("Zed");
		}
		else
		{
			return false;
		}
	}
	private int findKeyword(String statement, String goal, int startPos)
	{
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		int psn = phrase.indexOf(goal, startPos);

		while (psn >= 0)
		{
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

			if (((before.compareTo("a") < 0) || (before
					.compareTo("z") > 0)) 
					&& ((after.compareTo("a") < 0) || (after
							.compareTo("z") > 0)))
			{
				return psn;
			}

			psn = phrase.indexOf(goal, psn + 1);

		}

		return -1;
	}
	private int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
	}
}

