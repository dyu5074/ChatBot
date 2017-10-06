import java.util.Scanner;

public class ChatBotRunnerHoi {
		public static void main(String[] args)
		{
			ChatBotHoiLam chatbot1 = new ChatBotHoiLam();
			
			System.out.println (chatbot1.getGreeting());
			Scanner in = new Scanner (System.in);
			String statement = in.nextLine();
			
			while (!statement.equals("Bye"))
			{
				System.out.println (chatbot1.getResponse(statement));
				statement = in.nextLine();
			}
		}
}
