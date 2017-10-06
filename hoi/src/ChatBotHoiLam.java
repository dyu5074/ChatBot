import java.util.Random;

public class ChatBotHoiLam {
		int emotion = 0;
		public String getGreeting()
		{
			return "Hey, I think minecraft is awesome! How about you?";
		}
		public String getResponse(String statement)
		{
			String response = "";
			
			if (statement.length() == 0)
			{
				response = "What do you say?";
			}

			else if (findKeyword(statement, "no") >= 0)
			{
				response = "Aww, do you want to talk ahout another game?";
            	emotion--;

			}
			else if (findKeyword(statement, "yes")>=0 || findKeyword(statement, "same")>=0 )
			{
				response = ":) Awesome. What is your favorite map in Minecraft?";
			}
			else if (findKeyword(statement, "game") >= 0)
			{		
				response = "I really like to play games";
			}
			else
			{
				response = getRandomResponse();
			}
			
			return response;
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
						.compareTo("z") > 0)) // before is not a
												// letter
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
		private String getRandomResponse ()
		{
			Random r = new Random ();
			if (emotion == 0)
			{	
				return randomNeutralResponses [r.nextInt(randomNeutralResponses.length)];
			}
			if (emotion < 0)
			{	
				return randomAngryResponses [r.nextInt(randomAngryResponses.length)];
			}	
			return randomHappyResponses [r.nextInt(randomHappyResponses.length)];
		}
		
		private String [] randomNeutralResponses = {
				"Interesting, tell me more",
				"Hmmm.",
				"Do you really think so?",
				"Sorry, I do not understand.",
				"Could you say that again?"
		};
		private String [] randomAngryResponses = {"WHAT?!", "NOO",};
		private String [] randomHappyResponses = {"H A P P Y, what's that spell?", "Let's play Minecraft together someday", 
							"Everyday I'm shoveling"};
	}

