import java.io.*;
import java.util.regex.*;
import java.nio.*;
import java.util.Scanner;

/*Admin Log-in
 * Once logged in, get student info
 * display if student is eligible for exam
 * if eligible, record their attendance
 * then ask the next student for their ID and Name
 * continue the program once all students have been recorded
 */


public class ExamAttendanceSystem 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Admin admin = new Admin();
        String user,pass;

        System.out.println("Welcome to Admin login.\nplease enter the username and password.");

        boolean loggedIn = false;
        while(!loggedIn)
        {
            try
            {
                BufferedReader br = new BufferedReader(new FileReader("E:\\xampp\\htdocs\\STUDY\\PROJECTS\\Exam-Attendance-System-Comprog2-PT-FINALS-\\AdminLog.txt"));
                String line;

                System.out.print("Username: ");
                admin.setUsername(sc.nextLine());
                System.out.print("Password: ");
                admin.setPassword(sc.nextLine());
                
                while((line = br.readLine()) != null)
                {
                    String password = br.readLine();
                    
                    if(line.equalsIgnoreCase(admin.getUsername()) && password.equalsIgnoreCase(admin.getPassword()))
                    {
                        System.out.println("Log-in successful.");
                        loggedIn = true;
                        Shortcuts.clearScreen();
                        break;
                    }
        
                }
                boolean loop = false;
    
                if(loggedIn)
                {
                    while(!loop)
                    {
                        System.out.print("Enter your student id: ");
                        String sid = sc.nextLine();
                        System.out.print("Enter student name: ");
                        String sName = sc.nextLine();

                        if(Shortcuts.empty(sid) || Shortcuts.empty(sName))
                        {
                            System.out.println("Student id and Student name cannot be null/empty, please try again.");
                            Shortcuts.clearScreen();
                        }
                        else
                        {
                            admin.studentInfo(sid, sName);
                            loop = true;
                        }
                    }
                }
                else
                {
                    System.out.println("Invalid credentials. please try again.");
                    Shortcuts.clearScreen();
                }

                }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        
    }


}
