//MAJOR ERROR BUG FIX: AYOS NA YUNG NAG LO-LOOP PAPUNTANG LOGIN PAG TAPOS NA MAGRECORD NG STUDENT.

//MAJOR ERROR: NAG LO LOOP BACK SA ADMIN LOG-IN AT WALANG NUMBER OF ATTEMPTS KUNG ILAN LANG PWEDE MARECORD. (OPTIONAL FEATURE: MAG 
//DAGDAG NG MULTIPLESECTIONS PARA I CHECK ATTENDANCE NILA)

import java.io.*;
import java.util.Scanner;
public class ExamAttendanceSystem {
    final static String attendanceTrackerFile = "C:\\IZECUBES\\COLLEGE\\1ST YEAR\\SEM 2\\Comprog 2\\ACTIVITIES\\FINALS PT\\Exam-Attendance-System-Comprog2-PT-FINALS-//AttendanceTracker.txt";
    final static String adminLog = "C:\\IZECUBES\\COLLEGE\\1ST YEAR\\SEM 2\\Comprog 2\\ACTIVITIES\\FINALS PT\\Exam-Attendance-System-Comprog2-PT-FINALS-\\AdminLog.txt";
    /*final static String attendanceTrackerFile = "D:\\Downloads\\txt files//AttendanceTracker.txt";
    final static String adminLog = "D:\\Downloads\\txt files\\AdminLog.txt";*/
    //final static String adminLog = "C:\\Users\\user\\OneDrive\\Documents\\GitHub\\Exam-Attendance-System-Comprog2-PT-FINALS-\\AdminLog.txt";

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
        } while (recordMoreStudents);

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


  



            
  