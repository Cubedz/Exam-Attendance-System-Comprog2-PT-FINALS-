
import java.io.*;
import java.util.Scanner;
public class ExamAttendanceSystem {
    final static String attendanceTrackerFile = "AttendanceTracker.txt";
    final static String adminLog = "AdminLog.txt";
    
    public void examAttendanceSystemProgram() throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean loggedIn = Admin.adminLogin(adminLog);

        if (loggedIn) {
            boolean recordMoreStudents;
           
        do { 
            System.out.println();
            System.out.println(Font.bText + Font.iText +"-------Student ID and Name-------"+ Font.resetText);//F
                System.out.println("Please enter student ID:");
                User.setStudentID(sc.nextLine());
                 System.out.print("Enter student name: ");
                 System.out.println();
                    User.setStudentName(sc.nextLine());

                     if(ExamAttendanceChecker.isValidStudentInput(User.getStudentID(), User.getStudentName())){
                        if (ExamEligibility.eligibility(User.getStudentID(), User.getStudentName())) {
                             ExamAttendanceChecker.updateAttendance(User.getStudentID(), User.getStudentName());
                         }
                     }
            
            System.out.println();  
            System.out.println("Record another student? \nPress 'Y' for YES \nPress 'N' for NO"); //F
            System.out.print("Response: ");//F
            recordMoreStudents = sc.nextLine().equalsIgnoreCase("y");
            try {
                Shortcuts.clearScreen();
                } catch (InterruptedException e) {
                }
        } while (recordMoreStudents);
            try {
            Shortcuts.clearScreen();
                } catch (InterruptedException e) {
                }
        System.out.println("\nAttendance recording finished.");
        System.out.println();
        System.out.println("ALL STUDENTS WHO ATTENDED: ");
        ExamAttendanceChecker.displayAllRecordedAttendanceOnConsole(attendanceTrackerFile);
        System.out.println();
        System.out.println(Font.bText +"Thank you for using our system.\nRun it again!");
    } else {
        System.out.println();
        System.out.println(Font.iText +"Run it again!"+ Font.resetText); // for the admin to record again
            try {
            Thread.sleep(500);
            } catch (InterruptedException e) {
            e.printStackTrace();
            }
        System.out.println(Font.bText +"Exited."); // Finally exited
   
    }
    sc.close(); 
    }
    
}


  



            
  