import org.jibble.pircbot.*;
import java.util.Scanner;
import java.io.File;
public class KerBotMain
{
    public static void main(String[] args) throws Exception
    {
        KerBot bot = new KerBot();
        bot.setVerbose(true);
        bot.connect("irc.freenode.net", 6667, "kErbotR0ck$$sCiR0ck$$");
        bot.joinChannel("#gsaul-testing");
        bot.joinChannel("#kerbalspaceprogram");
    }
}

class KerBot extends PircBot
{
    public KerBot()
    {
        this.setName("KerBot");
    }
    
    public void onMessage(String channel, String sender, String login, String hostname, String message)
    {
      String[] wordsplit = message.split(" ");
      String frabody = new String("fra/");
      
      if(message.substring(0,1).equals("!"))
      {
         if(wordsplit[0].equals("!dv"))
         {
            String toSend = new String("");
         }
         
         else if(wordsplit[0].equals("!fra"))
         {
            frabody+=wordsplit[1].toLowerCase()+wordsplit[2].toLowerCase();
            try
            {
               Scanner frascanner = new Scanner(new File(frabody));
               sendMessage("#kerbalspaceprogram", "The " + wordsplit[2] + " information of " + wordsplit[1] + " is " + frascanner.nextLine());
            }catch (Exception e)
            {
               System.out.println("*"+frabody+"*");
            }
         }
         
         else if(wordsplit[0].equals("!shutdown"))
         {
            sendMessage("#kerbalspaceprogram", "Fuck you dumbass");   
         }
      }
    }
}