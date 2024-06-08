import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Admin extends User 
{
  private static final String adminLogsFile = "C:\\IZECUBES\\COLLEGE\\1ST YEAR\\SEM 2\\Comprog 2\\ACTIVITIES\\FINALS PT\\Exam-Attendance-System-Comprog2-PT-FINALS-\\AdminLog.txt";
  private static final String studentInfoFile = "C:\\IZECUBES\\COLLEGE\\1ST YEAR\\SEM 2\\Comprog 2\\ACTIVITIES\\FINALS PT\\Exam-Attendance-System-Comprog2-PT-FINALS-\\StudentInfo.txt";
  /*private static final String adminLogsFile = "D:\\Downloads\\txt files\\AdminLog.txt";
  private static final String studentInfoFile = "D:\\Downloads\\txt files\\StudentInfo.txt"; */
  public static boolean adminLogin(String adminLogFile) throws IOException { 

        System.out.println(Font.bText +"---------------------------------------------------");//F
        System.out.println("|"+ Font.iText + "WELCOME TO ADMIN LOGIN! Enter Username & Password"+ Font.resetText+ "|"); //F
        System.out.println(Font.bText +"---------------------------------------------------"+ Font.resetText); //F
        
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

              System.out.println(Font.iText + "Logged in successfully!"+ Font.resetText); //F
              loggedIn = true;
              break;
            } else {
              attemptCount++;
              
              System.out.println("Login failed. Attempts remaining: " +Font.bText + (3 - attemptCount)+ Font.resetText ); //F
              System.out.println();
            }
          }
      
          if (!loggedIn && attemptCount == 3) {
            System.out.println("Login failed. Maximum attempts reached. Please try again later."); //red
            
            try {
              Thread.sleep(1000);//F
              System.out.println("Exiting Program in 10 seconds..."); //F
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

    public static void studentInfo(String sID, String sName) throws IOException
    {
        BufferedReader br = null;
        try
        {

            Pattern p = Pattern.compile("(\\d{11}) ([\\w ]+) (\\w+) - (\\w+)");
            br = new BufferedReader(new FileReader(studentInfoFile));

            String line;
            boolean matches = false;

            while((line = br.readLine()) != null)
            {
                Matcher m = p.matcher(line);

                if(m.find()==true)
                {
                    String studentID = m.group(1);
                    String studentName = m.group(2).trim();
                    String studentLName = m.group(3).trim();
                    String isPaid = m.group(4);

                    String fullName = studentName + " " + studentLName;

                    if(studentID.equals(getStudentID()) && fullName.equalsIgnoreCase(getStudentName())){
                        System.out.println("Student Name: " + fullName); 
                        System.out.println("Payment Status: " + isPaid); 
                        matches = true;
                        if(isPaid.equalsIgnoreCase(Font.bText +"paid"+ Font.resetText)){//F
                            System.out.println(Font.iText + Font.bText +"Eligible for Exam: Yes"+ Font.resetText); //F
                        }else{
                            System.out.println(Font.bText +"Not eligible for Exam: (" + Font.bText +isPaid + ")"+ Font.resetText) ; //F
                        }
                        break;
                    }
                }
            }
            if(!matches){
                System.out.println( Font.ulineText+ "The entered student id/full name is incorrect."+ Font.resetText);//F
            }
        }catch(IOException e)
        {
            e.printStackTrace();
        }finally{
            if(br != null){
                br.close();
            }
        }
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
