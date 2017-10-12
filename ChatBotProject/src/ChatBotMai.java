import java.util.Scanner;

/*
 * Yiren Mai
 * 10/5/17
 */
public class ChatBotMai {
	public String startGreeting()
	{
		String greeting="Hi there what do you want to talk about in realm of the mad god? Classes? Weapons? ";
		return greeting;
	}
	public String getResponse(String userinput)
	{
		String reply="";
		if(userinput.length()==0)
		{
			reply="Why dont you want to talk to me? Say something so we can talk about it.";
		}
		else if(findKeyword(userinput,"classes",0)>=0)
		{
			System.out.println ("In realm of the mad god there are 14 different classes. The 14 classes are rouge, archer, wizard, priest, warrior, paladin, knight,\\n assassin, necromancer, huntress, trickster, sorcerer, mystic, and ninja. Which one are you interesting in talking about?\\n I only know the knight, warrior, and wizard. Which one do you want to talk about?\";");		
			Scanner pickclass = new Scanner (System.in);
			String classchosen = pickclass.nextLine();
			reply=Classtype(classchosen);
		}
		else if(findKeyword(userinput, "weapons",0)>=0)
		{
			System.out.println("There are 6 different weapons. They consist of the dagger, the bow, the staff, the wand, the sword, and the katana. Which weapon do you like?");
			Scanner weapon = new Scanner (System.in);
			String weaponchosen = weapon.nextLine();
			reply=weapontype(weaponchosen);
		}
		else if(findKeyword(userinput,"yes",0)>=0)
		{
			reply="really? do you want to talk more about it?";
		}
		else if(findKeyword(userinput,"no",0)>=0)
		{
			reply="Aw why not?";
		}
		else
		{
			reply=respond();
		}
		return reply;
	}
	public static String weapontype(String statement)
	{
		if(statement.equals("dagger"))
		{
			return "The dagger is a mid ranged weapon that is used by the rouge, trickster, and the assasin.";
		}
		else if(statement.equals("bow"))
		{
			return "The bow is a long ranged weapon that is used by the archer, and huntress. I like this weapon the best because it is one of the weapon that does the most damage.";
		}
		else if(statement.equals("staff"))
		{
			return "The staff is a long ranged weapon that is used by the wizard, necromancer, and the mystic.";
		}
		if(statement.equals("wand"))
		{
			return "The wand is a long ranged weapon that is used by the priest, and the sorcerer.";
		}
		else if(statement.equals("sword"))
		{
			return "The sword is a short ranged weapon that is used by the warrior, knight, and the paladin.";
		}
		else if(statement.equals("katana"))
		{
			return "The katana is a mid ranged weapon that is used by the ninja and only the ninja.";
		}
		else
		{
			return "I don't really know this weapon is do you want to tell me about it?";
		}
	}
	public static String Classtype(String statement)
	{
		if(statement.equals("wizard"))
		{
			return "The Wizard is a ranged class whom shoots with his staff. His ability is to expolde and area and the effects spread out from the center. Do you like this class?";
		}
		else if(statement.equals("wizard"))
		{
			return "The Warrior is a melee class that prevails due to his ability, which allows him to attack more frequently and run faster. Do you like this class?";
		}
		else if(statement.equals("knight"))
		{
			return "The knight is a melee class that has a high defense and his ability can stun monsters to prevent them from attacking.\\n however some monsters are immune to the stun effect. Do you like this class?";
		}
		else
		{
			return "I don't really know this character do you want to tell me about it?";
		}
	}
	public static String respond()
	{
		String[] responsearray= {"I dont really understand what you are saying","Can you say something I understand?","hmm","I'm not understanding what you are trying to tell me"};
		int random = (int )(Math.random() * 3 + 1);
		String randomresponse=responsearray[random];
		return randomresponse;
	}
	//@author Levin
	private int findKeyword(String statement, String goal,int startPos)
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
}
