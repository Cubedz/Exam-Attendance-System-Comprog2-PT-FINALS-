import java.io.*;
import java.util.Scanner;
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
            ExamAttendanceChecker.updateAttendance(User.getStudentID(),User.getStudentName());
        } 
       
    }
   
}
