/*
 * Yiren Mai
 * 10/5/17
 */
public class ChatBotMai {
	public String startGreeting()
	{
		String greeting="Hi there what do you want to talk about? Classes? Weapons? ";
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
			reply="In realm of the mad god there are 14 different classes. The 14 classes are rouge, archer, wizard, priest, warrior, paladin, knight,"
					+ " assassin, necromancer, huntress, trickster, sorcerer, mystic, and ninja. Which one are you interesting in talking about?";
		}
		else if(findKeyword(userinput, "weapons",0)>=0)
		{
			reply="There are 6 different weapons. They consist of the dagger, the bow, the staff, the wand, the sword, and the katana";
		}
		else if(findKeyword(userinput,"class",0)>=0)
		{
			reply="What class do you want to talk about? I only know the knight, warrior, and wizard.";
		}
		else
		{
			reply="I'm not sure what you're saying";
		}
		return reply;
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
