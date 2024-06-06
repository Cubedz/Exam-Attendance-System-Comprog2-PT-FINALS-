import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;


public class ExamAttendanceChecker extends ExamAttendanceSystem{
   private static final String attendanceFile = "C:\\IZECUBES\\COLLEGE\\1ST YEAR\\SEM 2\\Comprog 2\\ACTIVITIES\\FINALS PT\\Exam-Attendance-System-Comprog2-PT-FINALS-//AttendanceTracker.txt";
   
    public static void main(String[] args) throws IOException {
        displayAllRecordedAttendanceOnConsole(attendanceFile);
        
    }
        static void updateAttendance(String studentID, String studentName) throws IOException { //UPDATE ATTENDANCE
            List<String> attendanceList = readAttendanceData(attendanceFile); 
                
            if (isStudentPresent(studentID, studentName, attendanceList)) {
            System.out.println("Student has already been recorded");
            } else {
            String newAttendanceData = studentID + " " + studentName + " " + getCurrentDate() + " ATTENDED";
            attendanceList.add(newAttendanceData); 
            writeAttendanceData(attendanceList, attendanceFile); 
            System.out.println("Student has been successfuly recorded");
            }
        }

        static boolean isStudentPresent(String studentID, String studentName, List<String> attendanceList) { //checks f student is already recorded
            for (String line : attendanceList) {
            if (line.startsWith(studentID + " ")) { 
                return true; 
                }
            }
            return false; 
        }
    
         static List<String> readAttendanceData(String attendanceFile) throws IOException { //read attendance data to check later if there is adup
            List<String> attendanceList = new ArrayList<>();
            BufferedReader reader = null;
            try {
            reader = new BufferedReader(new FileReader(attendanceFile));
            String line;
            while ((line = reader.readLine()) != null) {
                attendanceList.add(line);
                }
            } catch(Exception e){
            }finally {
            if (reader != null) {
                reader.close();
                }
            }
            return attendanceList;
        }

        static void writeAttendanceData(List<String> attendanceList, String attendanceFile) throws IOException { //writer
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