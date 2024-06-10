import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExamEligibility {
    private static final String STUDENTINFO_STRING = "StudentInfo.txt";
    //
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
                                System.out.println("Eligible for Exam: " +Font.iText + Font.bText + "Yes"+ Font.resetText);//F
                                elibgible = true;
                            }else{
                                System.out.println("Not eligible for Exam: (" + Font.bText +paid + " PAYMENT)"+ Font.resetText);//F
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

    