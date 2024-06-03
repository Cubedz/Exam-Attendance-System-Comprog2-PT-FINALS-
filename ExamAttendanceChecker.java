import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class ExamAttendanceChecker {
   private static final String attendanceFile = "C:\\IZECUBES\\COLLEGE\\1ST YEAR\\SEM 2\\Comprog 2\\ACTIVITIES\\FINALS PT\\Exam-Attendance-System-Comprog2-PT-FINALS-//AttendanceTracker.txt";
   

        public static void updateAttendance(String studentID, String studentName) throws IOException {
            List<String> attendanceList = readAttendanceData(attendanceFile); 
                
            if (isStudentPresent(studentID, studentName, attendanceList)) {
            System.out.println("Student has already been recorded");
            } else {
            String newAttendanceData = studentID + " " + studentName + " " + getCurrentDate() + " ATTENDED\n";
            attendanceList.add(newAttendanceData); 
            writeAttendanceData(attendanceList, attendanceFile); 
            System.out.println("Student has been successfuly recorded");
            }
        }

        //store time method

        public static List<String> readAttendanceData(String attendanceFile) throws IOException {
            List<String> attendanceList = new ArrayList<>();
            BufferedReader reader = null;
            try {
            reader = new BufferedReader(new FileReader(attendanceFile));
            String line;
            while ((line = reader.readLine()) != null) {
                attendanceList.add(line);
            }
            } finally {
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
            if (line.startsWith(studentID + " ATTENDED$")) { 
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
