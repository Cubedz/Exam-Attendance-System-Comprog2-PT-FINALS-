//try lang ni-recycle ko lang yung sa pt natin dati

import java.util.*;
import java.io.*;
public class StudentLogin extends User
{
 
    private static final String loginFile = "C:\\IZECUBES\\COLLEGE\\1ST YEAR\\SEM 2\\Comprog 2\\ACTIVITIES\\FINALS PT\\Exam-Attendance-System-Comprog2-PT-FINALS-\\StudentInfo";
    private static final Scanner sc = new Scanner(System.in);

    static void studentLogin() throws IOException, InterruptedException
    {
        boolean loggedin = false;

        while(!loggedin)
        {
            System.out.println("Please Enter Your Full Name and Student ID: ");
            System.out.println("Full Name: ");
            String name = sc.nextLine();
            System.out.println("Student ID (02000xxxxxx): ");
            String sID = sc.nextLine();
        

            if(Shortcuts.isAlphaOnly(name) && Shortcuts.isNumericID(sID) && !Shortcuts.empty(name) && !Shortcuts.empty(sID))
            {
                if (checkNameID(name, sID))
                {
                    System.out.println("Logged in Successfully.");
                    loggedin = true;
                    Shortcuts.clearScreen();
                }
                else
                {
                    System.out.println("Name or ID cannot be found.");
                    Shortcuts.clearScreen();
                    continue;
                }
            }
        //
            else
            {
                System.out.println("Please Refer to the Format.");
            }
        }
    }

    public static boolean checkNameID(String name, String ID) throws IOException
    {
        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new FileReader(loginFile));
            String checkline;

            while((checkline = br.readLine())!=null)
            {
                String fileNAME = checkline;
                String fileID = br.readLine();

                if(fileNAME.equals(name) && fileID.equals(ID))
                {
                    return true;
                }
            }
        }
        catch(IOException ioe)
        {
            System.out.println(ioe.getMessage());
        }finally{
            if(br != null){
                br.close();
            }
        }
        return false;
    }
}
