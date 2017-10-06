import java.util.Scanner;

/**
 * A simple class to run our chatbot teams.
 * @author Mr. Levin
 * @version September 2017
 */
public class ChatBotRunner
{

	/**
	 * Create instances of each chatbot, give it user input, and print its replies. Switch chatbot responses based on which chatbot the user is speaking too.
	 */
	public static void main(String[] args)
	{
		ChatBotMai chatbot1 = new ChatBotMai();
		
		System.out.println (chatbot1.startGreeting());
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();
		while (!statement.equals("Bye"))
		{
			System.out.println (chatbot1.getResponse(statement));
			statement = in.nextLine();
		}
	}

}
