import java.util.Random;
import java.util.Scanner;

public class mainbot {
	int emotion = 0;
	public String getGreeting()
	{
		return "Hi, what is up?";
	}
	public String getResponse(String statement)
	{	
		String response = "";
		if (statement.length() == 0)
		{
			response = "Hi?";
			emotion--;
		}
		else if (findKeyword(statement, "no") >= 0)
		{
			response = "Why so negative?";
            emotion--;
		}
		else if (findKeyword(statement, "minecraft", 0) >= 0 && findKeyword(statement, "like", 0) >= 0 )
		{
			ChatBotHoiLam chatbot1 = new ChatBotHoiLam();
			
			System.out.println (chatbot1.getGreeting());
			Scanner in = new Scanner (System.in);
			String statement = in.nextLine();
		}	
		return response;
	}
	private int findKeyword(String statement, String goal,
			int startPos)
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