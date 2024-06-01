import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;


public class ExamAttendanceChecker {
   private static final String attendanceFile = "C:\\IZECUBES\\COLLEGE\\1ST YEAR\\SEM 2\\Comprog 2\\ACTIVITIES\\FINALS PT\\Exam-Attendance-System-Comprog2-PT-FINALS-//AttendanceTracker.txt";

   public static void displayIfAttended(String line){
        if (line.matches(".*ATTENDED$")){
            System.out.println("The student Attended on " + getCurrentDate());
        }
        else {
        System.out.println("No Attendance Recorded");
        }
    } 

    public static void updateAttendance(int studentID, String studentName) throws IOException{
        FileWriter writer = null;
        try{
           writer = new FileWriter(attendanceFile, true);
           writer.write(String.format("%s,%s,%s ATTENDED\n",studentID, studentName,getCurrentDate()));

        }catch (Exception e){
            System.out.println(e);
        }finally{
            if (writer != null);
            writer.close();
        }
    }
    
    public static String getCurrentDate(){
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        return timeStamp;
    }
}
