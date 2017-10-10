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
		ChatBotDerek chatbot1 = new ChatBotDerek();
		ChatBotMai chatbot2 = new ChatBotMai();
		ChatBotLeon chatbot3 = new ChatBotLeon();
		ChatBotHoiLam chatbot4 = new ChatBotHoiLam();
		
		System.out.println ("Hello there which chatbot would you like to talk to? We have Derek, Mai, Leon, and HoiLam");
		Scanner bot = new Scanner (System.in);
		String select = bot.nextLine();
		
		
		if(select.equals("Derek"))
		{
			System.out.println (chatbot1.getGreeting());
			Scanner in = new Scanner (System.in);
			String statement = in.nextLine();
			
			while (!statement.equals("Bye"))
			{
				
				System.out.println (chatbot1.getResponse(statement));
				statement = in.nextLine();
			}
		}	
		if(select.equals("Mai"))
		{
			System.out.println (chatbot2.startGreeting());
			Scanner in = new Scanner (System.in);
			String statement = in.nextLine();
			
			while (!statement.equals("Bye"))
			{
				
				System.out.println (chatbot2.getResponse(statement));
				statement = in.nextLine();
			}
		}	
		if(select.equals("Leon"))
		{
			System.out.println (chatbot3.getGreeting());
			Scanner in = new Scanner (System.in);
			String statement = in.nextLine();
			
			while (!statement.equals("Bye"))
			{
				
				System.out.println (chatbot3.getResponse(statement));
				statement = in.nextLine();
			}
		}	
		if(select.equals("Hoilam"))
		{
			System.out.println (chatbot4.getGreeting());
			Scanner in = new Scanner (System.in);
			String statement = in.nextLine();
			
			while (!statement.equals("Bye"))
			{
				
				System.out.println (chatbot4.getResponse(statement));
				statement = in.nextLine();
			}
		}		
	}

}