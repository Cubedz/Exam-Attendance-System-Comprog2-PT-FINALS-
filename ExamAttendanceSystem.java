import java.io.*;
import java.util.regex.*;
import java.nio.*;
import java.util.Scanner;
import java.util.*;
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

<<<<<<< HEAD
    
    System.out.println("Succesfully loggged in");
=======
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
                        admin.setStudentID(sc.nextLine());
                        System.out.print("Enter student name: ");
                        admin.setStudentName(sc.nextLine());
>>>>>>> 59cb7bc9fb6c5916d2f8cac7edc7608203f4a8b6

                        if(Shortcuts.empty(admin.getStudentID()) || Shortcuts.empty(admin.getStudentName()))
                        {
                            System.out.println("Student id and Student name cannot be null/empty, please try again.");
                            Shortcuts.clearScreen();
                        }
                        else
                        {
                            admin.studentInfo(admin.getStudentID(), admin.getStudentName());
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
