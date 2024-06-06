

import java.io.*;
import java.util.Scanner;
public class ExamAttendanceSystem {
    final static String adminLog = "C:\\IZECUBES\\COLLEGE\\1ST YEAR\\SEM 2\\Comprog 2\\ACTIVITIES\\FINALS PT\\Exam-Attendance-System-Comprog2-PT-FINALS-\\AdminLog.txt";
   
     public void examAttendanceSystemProgram() throws IOException {
        Scanner sc = new Scanner(System.in);

        do {

        if (Admin.adminLogin(ExamAttendanceSystem.adminLog)) {
            System.out.println("Admin Login Successful. Enter Student ID and Name:");

            System.out.println("Please enter student ID");
            User.setStudentID(sc.nextLine());
            System.out.println("enter student name: ");
            User.setStudentName(sc.nextLine());

      
            if (ExamEligibility.eligibility(User.getStudentID(), User.getStudentName()) == true) {
            ExamAttendanceChecker.updateAttendance(User.getStudentID(), User.getStudentName());
            }
        }

        System.out.println("Record another student? (y/n)");
        } while (sc.nextLine().equalsIgnoreCase("y"));

        System.out.println("Attendance recording finished.");
    }
}
  



            
  