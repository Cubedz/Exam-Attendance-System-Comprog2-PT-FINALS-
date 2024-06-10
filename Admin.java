import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Admin extends User 
{
  private static final String adminLogsFile = "AdminLog.txt";


  public static boolean adminLogin(String adminLogFile) throws IOException { 

        System.out.println(Font.bText +"---------------------------------------------------");
        System.out.println("|"+ Font.iText + "WELCOME TO ADMIN LOGIN! Enter Username & Password"+ Font.resetText+ "|"); 
        System.out.println(Font.bText +"---------------------------------------------------"+ Font.resetText); 
        
        boolean loggedIn = false;
        int attemptCount = 0;
      
        Scanner sc = new Scanner(System.in);
      
        try (BufferedReader br = new BufferedReader(new FileReader(adminLogFile))) {
          String line;
      
          while (attemptCount < 3 && (line = br.readLine()) != null) {
            
            System.out.print("Username: ");
            String username = sc.nextLine();
            System.out.print("Password: ");
            String password = sc.nextLine();
      
      
            if (checkUnamePword(username, password) == true) {

              System.out.println(Font.iText + "Logged in successfully!"+ Font.resetText); 
              loggedIn = true;
              break;
            } else {
              attemptCount++;
              
              System.out.println("Login failed. Attempts remaining: " +Font.bText + (3 - attemptCount)+ Font.resetText ); 
              System.out.println();
            }
          }
      
          if (!loggedIn && attemptCount == 3) {
            System.out.println("Login failed. Maximum attempts reached. Please try again later."); 
            
            try {
              Thread.sleep(1000);//F
              System.out.println("Exiting Program in 10 seconds..."); 
              Thread.sleep(10000); 
            } catch (InterruptedException e) {
              System.out.println(e);
            }
          }
        } catch (IOException ioe) {
          System.out.println(ioe);
        }
      
        return loggedIn;
      }


    public static boolean checkUnamePword(String username, String password) throws IOException{
      BufferedReader br = null;
      try{
          br = new BufferedReader(new FileReader(adminLogsFile));
          String checkline;
      
          while((checkline = br.readLine())!=null){
              String fileUser = checkline;
              String filePword = br.readLine();
              if(fileUser.equalsIgnoreCase(username) && filePword.equals(password)){
                      return true;
              }
          }
      }catch(IOException ioe){
          System.out.println(ioe.getMessage());
      }finally{
        if(br != null){
          br.close();
        }
      }
      return false;
  }
}
