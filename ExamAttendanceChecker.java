import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;


public class ExamAttendanceChecker {
   private static final String attendanceFile = "C:\\IZECUBES\\COLLEGE\\1ST YEAR\\SEM 2\\Comprog 2\\ACTIVITIES\\FINALS PT\\Exam-Attendance-System-Comprog2-PT-FINALS-//AttendanceTracker.txt";
   
   //test run
    public static void main(String[] args) throws IOException {
        checkAttendance(attendanceFile);
    }
   
        public static void displayIfAttended(String line) {
            if (line.matches("^\\d{11} ([A-Za-z ]+?) \\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2} (ATTENDED)$")) {
            System.out.println("The student Attended on " + getCurrentDate()); // this prints out current computer date, not what is recorded in the txt file
            } else {
            System.out.println("No Attendance Recorded");
            }
        } 
  
        public static void updateAttendance(int studentID, String studentName) throws IOException {
             FileWriter writer = null;
            try {
            writer = new FileWriter(attendanceFile, true);
            writer.write(String.format("%s,%s,%s ATTENDED\n", studentID, studentName, getCurrentDate()));
            } catch (Exception e) {
            System.out.println(e);
            } finally {
            writer.close();
            }
        }
  
        public static String getCurrentDate() {
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
            return timeStamp;
        }
  
        public static void checkAttendance(String attendanceFile) throws IOException {
            BufferedReader reader = null;
            try {
             reader = new BufferedReader(new FileReader(attendanceFile));
            String line;
            while ((line = reader.readLine()) != null) {
                displayIfAttended(line);
            }
            } finally {
                if (reader != null) { 
                reader.close();
                }
            }
        }
  
}