import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExamAttendanceChecker extends ExamAttendanceSystem{
   private static final String attendanceFile = "C:\\IZECUBES\\COLLEGE\\1ST YEAR\\SEM 2\\Comprog 2\\ACTIVITIES\\FINALS PT\\Exam-Attendance-System-Comprog2-PT-FINALS-//AttendanceTracker.txt";
   //private static final String attendanceFile = "C:\\Users\\user\\OneDrive\\Documents\\GitHub\\Exam-Attendance-System-Comprog2-PT-FINALS-\\AttendanceTracker.txt";

        static void updateAttendance(String studentID, String fullName) throws IOException {
            List<String> attendanceList = readAttendanceData(attendanceFile); 
            if(isValidStudentInput(studentID, fullName)==true){
                if (isStudentPresent(studentID, fullName, attendanceList)) {
                    System.out.println("Student has already been recorded");
                    } else {
                    String newAttendanceData = studentID + " " + fullName + " " + getCurrentDate() + " ATTENDED";
                    attendanceList.add(newAttendanceData); 
                    writeAttendanceData(attendanceList, attendanceFile); 
                    System.out.println("Student has been successfully recorded");
                    }
            }else{
                System.out.println("Please Enter a Valid ID and Name");
            }
        }

        public static boolean isValidStudentInput(String studentID, String fullName) {
            if (studentID.isEmpty() || fullName.isEmpty()) {
                System.out.println("Error: Student ID and full name cannot be empty.");
                return false;
            }
            Pattern pSID = Pattern.compile("^\\d{11}$");  
            Matcher mID = pSID.matcher(studentID);
            Pattern pname = Pattern.compile("^[a-zA-Z ]+$");  
            Matcher mname = pname.matcher(fullName);
    
            if (!mID.matches() || !mname.matches()) {
                System.out.println("Please enter a valid ID and Name");
                return false;
            }
            return true;
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

        static String getCurrentDate() {
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
            return timeStamp;
        }

        static List<String> displayAllRecordedAttendanceOnConsole(String attendanceFile) throws IOException{
            List<String> attendedList = new ArrayList<>();
            BufferedReader r = null;
            String line;
            try{
                r = new BufferedReader(new FileReader(attendanceFile));

                    while((line = r.readLine()) != null){
                        attendedList.add(line);
                        System.out.println(line);
                    }
            }catch(IOException ioe){
                System.out.println(ioe);
            }finally{
                if (r != null){
                    r.close();
                }
            }
            return attendedList;
        }
}
