public class ChatBotDerek {
	public String getGreeting()
	{
		return "Hey, Lets talk about League of Legends. Have you ever played this game? What do you want to talk about in League of Legends, items? characters?, strategies? ";
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
		else if (findKeyword(statement, "yes") >= 0)
		{
			response = "Nice, what do you want to talk about?";
		}
		else if (findKeyword(statement, "strategies") >= 0)
		{
			response = "1) Kill minions to earn gold. 2) Level up to get stronger. 3) Destroy enemy towers to win the game. ";
		}
		else if (findKeyword(statement, "favorite character") >= 0)
		{
			response = "My favorite character is Leona, What is yours?";
		}
		else if (findKeyword(statement, "characters") >= 0)
		{
			response = "There are around 138 characters. All of the characters have different abilities and backgrounds.";
		}
		else if (findKeyword(statement, "items") >= 0)
		{
			response = "Buy items to get stronger. ";
		}
		else
		{
			return "Please say something";
	    }
		return response;
	}
	//
		private String Characters(int x)
		{
		String y = "";
		if (x == 1)
		{
			y = "Annie";
		}
		else if (x == 2)
		{
			y = "Ashe";
		}
		else if (x == 3)
		{
			y = "Garen";
		}
		else if (x == 4)
		{
			y = "Alistar";
		}
		else if (x == 5)
		{
			y = "Akali";
		}
		else if (x == 6)
		{
			y = "Katarina";
		}
		else if (x == 7)
		{
			y = "Diana";
		}
		else if (x == 8)
		{
			y = "Zed";
		}
		else
		{
			y ="";
		}
			return y;
		}
		//
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

