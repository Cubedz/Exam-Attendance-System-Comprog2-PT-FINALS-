import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Admin extends User 
{

    public static boolean adminLogin(String adminLogFile) throws IOException { //UPDATED METHOD

        System.out.println("Welcome to Admin login.\nPlease enter the username and password.");
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
      
            String storedPassword = br.readLine(); 
      
            if (username.equalsIgnoreCase(line) && password.equalsIgnoreCase(storedPassword)) {
              System.out.println("Login successful.");
              loggedIn = true;
              break;
            } else {
              attemptCount++;
              System.out.println("Login failed. Attempts remaining: " + (3 - attemptCount));
            }
          }
      
          if (!loggedIn && attemptCount == 3) {
            System.out.println("Login failed. Maximum attempts reached. Please try again in 10 seconds.");
            try {
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
            br = new BufferedReader(new FileReader("C:\\IZECUBES\\COLLEGE\\1ST YEAR\\SEM 2\\Comprog 2\\ACTIVITIES\\FINALS PT\\Exam-Attendance-System-Comprog2-PT-FINALS-\\StudentInfo.txt"));

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
                        if(isPaid.equalsIgnoreCase("paid")){
                            System.out.println("Eligible for Exam: Yes");
                        }else{
                            System.out.println("Not eligible for Exam: (" + isPaid + ")");
                        }
                        break;
                    }
                }
            }
            if(!matches){
                System.out.println("The entered student id/full name is incorrect.");
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
    

    
    
}
