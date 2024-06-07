//MAJOR ERROR BUG FIX: AYOS NA YUNG NAG LO-LOOP PAPUNTANG LOGIN PAG TAPOS NA MAGRECORD NG STUDENT.

//MAJOR ERROR: NAG LO LOOP BACK SA ADMIN LOG-IN AT WALANG NUMBER OF ATTEMPTS KUNG ILAN LANG PWEDE MARECORD. (OPTIONAL FEATURE: MAG 
//DAGDAG NG MULTIPLESECTIONS PARA I CHECK ATTENDANCE NILA)

import java.io.*;
import java.util.Scanner;
public class ExamAttendanceSystem {
    final static String attendanceTrackerFile = "C:\\IZECUBES\\COLLEGE\\1ST YEAR\\SEM 2\\Comprog 2\\ACTIVITIES\\FINALS PT\\Exam-Attendance-System-Comprog2-PT-FINALS-//AttendanceTracker.txt";
    final static String adminLog = "C:\\IZECUBES\\COLLEGE\\1ST YEAR\\SEM 2\\Comprog 2\\ACTIVITIES\\FINALS PT\\Exam-Attendance-System-Comprog2-PT-FINALS-\\AdminLog.txt";
    //final static String adminLog = "C:\\Users\\user\\OneDrive\\Documents\\GitHub\\Exam-Attendance-System-Comprog2-PT-FINALS-\\AdminLog.txt";


     public void examAttendanceSystemProgram() throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean loggedIn = Admin.adminLogin(adminLog);

        if (loggedIn) {
            boolean recordMoreStudents;
           
        do { 
            System.out.println("Enter Student ID and Name:");
        System.out.println("Please enter student ID:");
        User.setStudentID(sc.nextLine());
        System.out.println("Enter student name:");
        User.setStudentName(sc.nextLine());

            if(ExamAttendanceChecker.isValidStudentInput(User.getStudentID(), User.getStudentName())){
                if (ExamEligibility.eligibility(User.getStudentID(), User.getStudentName())) {
                    ExamAttendanceChecker.updateAttendance(User.getStudentID(), User.getStudentName());
                    }
            }
            
           
        System.out.println("Record another student? (y/n)");
        recordMoreStudents = sc.nextLine().equalsIgnoreCase("y");
        } while (recordMoreStudents);

        System.out.println("Attendance recording finished.");
        System.out.println("ALL STUDENTS WHO ATTENDED: ");
        ExamAttendanceChecker.displayAllRecordedAttendanceOnConsole(attendanceTrackerFile);
    } else {
        System.out.println("exit banner");
   
    }
    sc.close(); 
    }
    
}


  



            
  