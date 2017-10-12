import java.util.Random;
import java.util.Scanner;
//Created By Hoi Lam Wong

public class ChatBotHoiLam {
		public String getGreeting()
		{
			Scanner input = new Scanner(System.in);
			System.out.println("Hello, what is your name?");
			String name = input.next();
			System.out.println("Nice to meet you " + name + " ! Do you like Minecraft?");
			String answer = input.next();
			if(answer.length()<1)
			{
				System.out.println("Say something");
			}
			if(findKeyword(answer, "no") >=0)
			{
			//go back to ChatBotRunner
				System.out.println("Okay. Have a nice day !");
				ChatBotRunner chatbot1 = new ChatBotRunner();
				String[] args = new String[0] ;
			    chatbot1.main(args);
			}
			return "I LOVE to play minecraft!";
		}
		String statement;
		public String getResponse(String statement)
		{
			String response = "";
			//Keywords
			if (statement.length() < 1)
			{
				response = "What do you say?";
			}
			else if (findKeyword(statement, "minecraft") >= 0)
			{		
				response = getRandomMinecraftResponse();
			}
			else if(findKeyword(statement, "skin")>=0)
			{
				if(findKeyword(statement, "change")>=0)
				{
					response = "To change your skin in minecraft: \nFirst, download your new skins.\n"
							+ "Then, login to Minecraft.net and upload your skin from the Profile page.";
				}
				else
				{
					response =  getRandomSkinResponse();
				}
			}
			else if(findKeyword(statement, "map")>=0)
			{
					System.out.println ("What map do you like the most?");
					Scanner a = new Scanner (System.in);
					String Mapstatement = a.nextLine();
					response = map(Mapstatement);
			}
			else if(findKeyword(statement, "server")>=0)
			{
				System.out.println ("My favorite server is Keinett.");
				Scanner b = new Scanner (System.in);
				String Serverstatement = b.nextLine();
				response = server(Serverstatement);
			}
			else if(findKeyword(statement, "play")>=0)
			{
				response =" I like to play a lot of games. Minecraft is my favorite game.";
			}
			else if(findKeyword(statement, "no")>=0)
			{
				response ="NO?";
			}
			else if(findKeyword(statement, "yes")>=0)
			{
				response ="Same :)";
			}
			else if(findKeyword(statement, "Hi")>=0)
			{
				response ="Hi";
			}
			else if((findKeyword(statement,"ip")>=0)||(findKeyword(statement,"address")>=0))
			{
				return "Here is the list of some of my favorite servers: \n"
						+ "1. MC.KEINETT.US\n"
						+ "2. terrestria-mc.com\n"
						+ "3. mc.differentcraft.net\n";
			}
			else
			{
				response = getRandomResponse();
			}
			
			return response;
		}
//map
		public String map(String Mapstatement)
		{
			if(findKeyword(Mapstatement, "skyblock")>=0)
			{
				return "I like skyblock the most!";
			}
			else
			{
				return "interesting";
			}
		}
//server
		public String server(String Serverstatement)
		{
			if(findKeyword(Serverstatement, "keinett")>=0)
			{
				return "Keinett offers a multitude of minecraft servers to play on.";
			}
			else if(findKeyword(Serverstatement, "list")>=0)
			{
				System.out.println("Do you want my top 3 server list?");
				Scanner c = new Scanner (System.in);
				String serverlista = c.nextLine();
				if(findKeyword(serverlista, "yes")>=0)
				{
					return "Here is the list of some of my favorite servers: \n"
							+ "		1. MC.KEINETT.US\n"
							+ "		2. terrestria-mc.com\n"
							+ "		3. mc.differentcraft.net\n";
				}
				else if(findKeyword(serverlista, "no")>=0)
				{
					return "...";
				}
				else
				{
					return "hmmm";
				}
			}
			else
			{
				return getResponse(statement);
			}
		}
//findKeyword
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
				if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0)) 
					&& ((after.compareTo("a") < 0) || (after.compareTo("z") > 0)))
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

//Minecraft Response
		private String getRandomMinecraftResponse()
		{
			Random rMinecraft = new Random();
			return randomMinecraftResponse[rMinecraft.nextInt(randomMinecraftResponse.length)];
		}
		private String[]randomMinecraftResponse = {
			"Minecraft is a game about placing blocks and going on adventures."	,
			"Minecraft is a sandbox video game created and designed by Swedish game designer Markus \"Notch\" Persson",
			"One Minecraft block equals 1 meter cubed.",
			"Chickens in minecraft are so big they¡¯re about 3 feet tall!"
		};
		
//Skin Response
		private String getRandomSkinResponse()
		{
			Random rSkin = new Random();
			return randomSkinResponse[rSkin.nextInt(randomSkinResponse.length)];
		}
		private String[]randomSkinResponse = {
			"The default skin in Minecraft is Steve.",
			"You can create your own skin using online free editor.",
			"My skin in Minecraft is a girl wearing a pig hat!"
		};
		
//Normal Response
		private String getRandomResponse ()
		{
			Random r = new Random ();
			return randomNeutralResponses [r.nextInt(randomNeutralResponses.length)];
		}
		
		private String [] randomNeutralResponses = {
				"Hmmm.",
				"Do you really think so?",
				"Sorry, I do not understand.",
				"Could you say that again?",
				"Everyday I'm shoveling"
		};
	}

