import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExamEligibility {

    //private static final String STUDENTINFO_STRING = "C:\\IZECUBES\\COLLEGE\\1ST YEAR\\SEM 2\\Comprog 2\\ACTIVITIES\\FINALS PT\\Exam-Attendance-System-Comprog2-PT-FINALS-\\StudentInfo.txt";
    private static final String STUDENTINFO_STRING = "C:\\Users\\user\\OneDrive\\Documents\\GitHub\\Exam-Attendance-System-Comprog2-PT-FINALS-\\StudentInfo.txt";
     public static boolean eligibility(String sid, String studname) throws IOException{

        boolean elibgible = false;
        BufferedReader br = null;

        try{
            Pattern p = Pattern.compile("(\\d{11}) ([\\w ]+) (\\w+) - (\\w+)");
            br = new BufferedReader(new FileReader(STUDENTINFO_STRING));
            String line;
            while((line = br.readLine()) != null){
                Matcher m = p.matcher(line);
                if(m.find() == true){
                    String studentID = m.group(1);
                    String studFullName = m.group(2).trim() + " " + m.group(3).trim();

                        if(studentID.equalsIgnoreCase(sid) && studFullName.equalsIgnoreCase(studname)){
                            String paid = m.group(4);
                            if(paid.equalsIgnoreCase("paid")){
                                System.out.println("Eligible for Exam: Yes");
                                elibgible = true;
                            }else{
                                System.out.println("Not eligible for Exam: (" + paid+ " PAYMENT)");
                            }
                        }
                }
            }
        }finally{
            if(br != null){
                br.close();
            }
        }

        return elibgible;
     }
}

    