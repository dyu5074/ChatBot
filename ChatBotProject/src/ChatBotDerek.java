import java.util.Random;
import java.util.Scanner; 
public class ChatBotDerek {
	public String getGreeting()
	{	
		return "Hey, Lets talk about League of Legends. Have you ever played this game?";
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
			ChatBotRunner chatbot1 = new ChatBotRunner();
			String[] args = new String[0] ;
		    chatbot1.main(args);
		}
		else if (findKeyword(statement, "yes") >= 0)
		{
			response = "Nice, what do you want to talk about? characters? favorite character? strategies? items? random fact? ";
		}
		else if (findKeyword(statement, "strategies") >= 0)
		{
			response = "1) Kill minions to earn gold. 2) Level up to get stronger. 3) Destroy enemy towers to win the game. ";
		}
		else if (findKeyword(statement, "favorite character") >= 0)
		{
			System.out.println("My favorite character is Jax, What is yours?");
			Scanner b = new Scanner (System.in);
			String favoritecharacter = b.nextLine();
			response = "Nice, I like " + favoritecharacter + " too";
		}
		else if (findKeyword(statement, "characters") >= 0)
		{
			System.out.println("There are around 138 characters. All of the characters have different abilities and backgrounds."
			+ "Here is a random character");
			Scanner c = new Scanner (System.in);
			String s = getRandomCharacter();
			response = "I love playing" + s +" Do you too?";
		}
		else if (findKeyword(statement, "items") >= 0)
		{
			System.out.println("What is your favorite item? Some items you can choose from include Trinity Force, Infinity Edge, Tear Of The Goddess, SightStone, The Black Cleaver,"
					+ "Rod Of Ages, Iceborn Gauntlet, Rapid FireCannon");
			Scanner a = new Scanner (System.in);
			String itemstatement = a.nextLine();
			response = Items(itemstatement);
		}
		else if (findKeyword(statement, "random fact") >= 0)
		{
			response = getrandomFact();
		}
		else
		{
			response = getrandomResponse();
	    }
		return response;
	}
	//
		private String [] Characters = {"Annie - The Dark Child", "Ashe", "Pantheon", "Zed", "Camille", "Diana", "Katarina", "Vladimir", "Zac", "Jax"}; 
		private String [] Items =  {"Trinity Force", "Infinity Edge", "Tear Of The Goddess" , "Sightstone", "The Black Cleaver", "Rod Of Ages",
				"Iceborn Gauntlet", "Rapid Firecannon"};
		private String [] Randomfact = {"League of Legends was released on October 27, 2009.", 
		"The game was inspired by the Warcraft III: The Frozen Throne mod Defense of the Ancients",
		"As of January 2014, over 67 million people played League of Legends per month, 27 million per day, and over 7.5 million concurrently during peak hours.",
		"Koreans are the best at this game"};
		private String Items(String statement)
		{
			if(findKeyword(statement, "Trinity Force")>=0)
			{
				return "This item is good for every character";
			}
			else if(findKeyword(statement, "Infinity Edge")>=0)
			{
				return "This item is good for attack damage characters";
			}
			else if(findKeyword(statement, "Tear Of The Goddess")>=0)
			{
				return "This item lets you stack up mana to cast spells";
			}
			else if(findKeyword(statement, "Sightstone")>=0)
			{
				return "Wow! You have chosen the most important item!This item allows your team to get vision of the map";
			}
			else if(findKeyword(statement, "The Black Cleaver")>=0)
			{
				return "This item helps you shred armor from tanks";
			}
			else if(findKeyword(statement, "Rod Of Ages")>=0)
			{
				return "This item allows you to build up your health and mana inventory";
			}
			else
			{
				return "Sorry, that item does not exist.";
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
	private String getRandomCharacter()
	{
		Random r = new Random ();
		return Characters [r.nextInt(Characters.length)];
	}
	private String getRandomItem()
	{
		Random r = new Random ();
		return Items [r.nextInt(Items.length)];
	}
	private String getrandomResponse()
	{
		Random r = new Random ();
		return randomResponses [r.nextInt(randomResponses.length)];
	}
	private String getrandomFact()
	{
		Random r = new Random ();
		return Randomfact [r.nextInt(Randomfact.length)];
	}
	private int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
	}
	private String [] randomResponses = {
			"Hmmm.",
			"I can't quite understand you",
			"Sorry, I do not understand.",
			"Could you say that again?",
			"That is quite funny"
	};
}

