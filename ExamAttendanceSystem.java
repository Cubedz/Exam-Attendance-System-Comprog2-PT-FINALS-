import java.io.*;
import java.util.regex.*;
import java.nio.*;
import java.util.Scanner;
import java.util.*;
public class ExamAttendanceSystem 
{
    private final static String adminLog = "C:\\IZECUBES\\COLLEGE\\1ST YEAR\\SEM 2\\Comprog 2\\ACTIVITIES\\FINALS PT\\Exam-Attendance-System-Comprog2-PT-FINALS-\\AdminLog.txt";
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
      
      

        if (Admin.adminLogin(adminLog)) {
          System.out.println("Admin Login Successful. Enter Student ID and Name:");
      
            System.out.println("Please enter student ID");
            User.setStudentID(sc.nextLine());
            System.out.println("enter student name: ");
            User.setStudentName(sc.nextLine());
 
          Admin.studentInfo(User.getStudentID(), User.getStudentName());
        } 
       
    }
   
}

/* KARL VERSION
Scanner sc = new Scanner(System.in);
        Admin admin = new Admin();
        String user,pass;

        System.out.println("Welcome to Admin login.\nplease enter the username and password.");

        boolean loggedIn = false;
        while(!loggedIn)
        {
            try
            {
                BufferedReader br = new BufferedReader(new FileReader("C:\\IZECUBES\\COLLEGE\\1ST YEAR\\SEM 2\\Comprog 2\\ACTIVITIES\\FINALS PT\\Exam-Attendance-System-Comprog2-PT-FINALS-\\AdminLog.txt"));
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
                        admin.setStudentID(sc.nextLine());
                        System.out.print("Enter student name: ");
                        admin.setStudentName(sc.nextLine());


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
        } */