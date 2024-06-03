import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class ExamAttendanceChecker {
   private static final String attendanceFile = "C:\\IZECUBES\\COLLEGE\\1ST YEAR\\SEM 2\\Comprog 2\\ACTIVITIES\\FINALS PT\\Exam-Attendance-System-Comprog2-PT-FINALS-//AttendanceTracker.txt";
   
    public static void main(String[] args) throws IOException {
        String p = "02000012359";
        String g = "Ava Thomas";
        updateAttendance(p, g);
    }
        public static void updateAttendance(String studentID, String studentName) throws IOException {
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

        /*
        public static List<String> storeDateAttended(String studentID, String attendaceFile){
            List<String> storedAttendance = new ArrayList<>();
            BufferedReader r = null;
            try{
                r = new BufferedReader(new FileReader(attendaceFile));
                String line;
                while ((line = r.readLine()) != null) {
                    if (line.matches())
            }
        } */
    
        public static List<String> readAttendanceData(String attendanceFile) throws IOException {
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

        public static void writeAttendanceData(List<String> attendanceList, String attendanceFile) throws IOException {
            FileWriter writer = null;
            try {
                writer = new FileWriter(attendanceFile);
                for (String line : attendanceList) {
                writer.write(line + "\n");
                }
            } finally {
                if (writer != null) {
                writer.close();
                }
            }
        }

        public static boolean isStudentPresent(String studentID, String studentName, List<String> attendanceList) {
            for (String line : attendanceList) {
            if (line.startsWith(studentID + " ")) { 
                return true; 
            }
            }
            return false; 
        }

        public static String getCurrentDate() {
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
            return timeStamp;
        }

}
