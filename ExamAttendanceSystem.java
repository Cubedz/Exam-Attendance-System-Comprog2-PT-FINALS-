
import java.io.*;
import java.util.Scanner;
public class ExamAttendanceSystem {
    final static String attendanceTrackerFile = "AttendanceTracker.txt";
    final static String adminLog = "AdminLog.txt";
    
    public void examAttendanceSystemProgram() throws IOException, InterruptedException {
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
                     while(true){
                        System.out.println("Record another student? \nPress 'Y' for YES \nPress 'N' for NO"); //F
                        System.out.print("Response: ");//F
                        String input = sc.nextLine().trim().toLowerCase();
                        if(input.equals("y")){
                            recordMoreStudents = true;
                            break;
                        }else if (input.equals("n")){
                            recordMoreStudents=false;
                            break;
                        }else{
                            Shortcuts.clearScreen();
                            System.out.println(Font.bText + "Please only enter 'Y' or 'N'" +Font.resetText);
                            System.out.println();
                        }
                     }
           
           
         
                     
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
        ExamAttendanceChecker.displayAllRecordedAttendanceOnConsole(attendanceTrackerFile);
        System.out.println();
        System.out.println(Font.bText +"Thank you for using our system."+Font.resetText);
        Thread.sleep(1500);
        System.out.println(Font.iText +"Exiting Program in 5 seconds..."+Font.resetText); 
        Thread.sleep(5000);
        Shortcuts.clearScreen();
    } else {
        System.out.println();
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
