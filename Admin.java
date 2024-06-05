import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Scanner;

public class Admin 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String user,pass;

        System.out.println("Welcome to Admin login.\nplease enter the username and password.");

            System.out.println("Username: ");
            user = sc.nextLine();
            System.out.println("Password: ");
            pass = sc.nextLine();

        try
        {
            BufferedReader br = new BufferedReader(new FileReader("E:\\xampp\\htdocs\\STUDY\\PROJECTS\\Exam-Attendance-System-Comprog2-PT-FINALS-\\AdminLog.txt"));
            String line;
            boolean loggedIn = false;
            while((line = br.readLine()) != null)
            {
                String password = br.readLine();
                
                if(line.equalsIgnoreCase(user) && password.equalsIgnoreCase(pass))
                {
                    loggedIn = true;
                    break;
                }
    
            }

            if(loggedIn)
            {
                System.out.println("Successfully logged in.");
                System.out.print("\033[H\033[2J");
                System.out.flush();

                System.out.println("Enter your student id: ");
                int sid = sc.nextInt();

                studentInfo(sid);

            }
            else
            {
                System.out.println("Invalid credentials.");
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }


    }

    public static void studentInfo(int sID)
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("E:\\xampp\\htdocs\\STUDY\\PROJECTS\\Exam-Attendance-System-Comprog2-PT-FINALS-\\StudentInfo.txt"));
                String line = br.readLine();
                boolean valid = false;
                
                System.out.println(line);
                
                if(valid)
                {
                    System.out.println("Test");
                }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }


    }
    
    
}

