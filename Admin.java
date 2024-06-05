import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.nio.Buffer;
import java.util.Scanner;

public class Admin extends User 
{
    public void studentInfo(String sID, String sName)
    {
        try
        {
<<<<<<< HEAD
            BufferedReader br = new BufferedReader(new FileReader("C:\\IZECUBES\\COLLEGE\\1ST YEAR\\SEM 2\\Comprog 2\\ACTIVITIES\\FINALS PT\\Exam-Attendance-System-Comprog2-PT-FINALS-\\AdminLog.txt"));
=======
            Pattern p = Pattern.compile("(\\d{11}) ([\\w ]+) (\\w+) - (\\w+)");
            BufferedReader br = new BufferedReader(new FileReader("E:\\xampp\\htdocs\\STUDY\\PROJECTS\\Exam-Attendance-System-Comprog2-PT-FINALS-\\StudentInfo.txt"));
>>>>>>> 59cb7bc9fb6c5916d2f8cac7edc7608203f4a8b6
            String line;

            boolean matches = false;


            while((line = br.readLine()) != null)
            {
                Matcher m = p.matcher(line);

                if(m.find())
                {
                    String studentID = m.group(1);
                    String studentName = m.group(2).trim();
                    String studentLName = m.group(3).trim();
                    String isPaid = m.group(4);

                    String fullName = studentName + " " + studentLName;

                    
                    if(studentID.equals(getStudentID()) && fullName.equalsIgnoreCase(getStudentName()))
                    {
                        System.out.println("Student Name: " + fullName);
                        System.out.println("Payment Status: " + isPaid);
                        matches = true;
                        if(isPaid.equalsIgnoreCase("paid"))
                        {
                            System.out.println("Eligible for Exam: Yes");
                        }
                        else
                        {
                            System.out.println("Not eligible for Exam: (" + isPaid + ")");
                        }
                        break;
                    }

                    
                }
            }
            if(!matches)
            {
                System.out.println("The entered student id/full name is incorrect.");
            }
                
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }


    }
    
    
}

