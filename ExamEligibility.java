<<<<<<< HEAD
=======
/*
 *  THIS IS THE JASPER VERSION

>>>>>>> a26f56ef48ea816adcd8aa8f386450b5809414f7
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExamEligibility {

    private static final String STUDENTINFO_STRING = "C:\\IZECUBES\\COLLEGE\\1ST YEAR\\SEM 2\\Comprog 2\\ACTIVITIES\\FINALS PT\\Exam-Attendance-System-Comprog2-PT-FINALS-\\StudentInfo.txt";
    public static void main(String[] args) {
        List<StdInfoMod> users = loadUsers(STUDENTINFO_STRING);
        for (StdInfoMod student : users) {
            if (student.isEligible()) {
                System.out.println("Student " + student.getName() + " (" + student.getstudentId() + ") is eligible to take the exam.");
            } else {
                System.out.println("Student " + student.getName() + " (" + student.getstudentId() + ") is not eligible to take the exam. Payment is required.");
            }
        }
    }
    private static List<StdInfoMod> loadUsers(String filePath) {
        List<StdInfoMod> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" - ");
                if (parts.length == 2) {
                    String[] studentsInfo = parts[0].split(" ");
                    String studentsId = studentsInfo[0];
                    String name = studentsInfo[1] + " " + studentsInfo[2];
                    boolean isPaid = parts[1].equalsIgnoreCase("PAID");
                    students.add(new StdInfoMod(studentsId, name, isPaid));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return students;
     }

     
    }

    
 */