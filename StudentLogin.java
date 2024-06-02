//try lang ni-recycle ko lang yung sa pt natin dati

import java.util.Scanner;
import java.io.*;
public class StudentLogin extends User
{
    private static final Scanner sc = new Scanner(System.in);

    static void StudentLogin() throws InterruptedException
    {
            System.out.println("Please enter your username and password");
                System.out.println("Username: ");
                String username = sc.nextLine();
                System.out.println("Password: ");
                String password = sc.nextLine();

        if(validateInput.checkUnamePword(username, password))
        {
            System.out.println("Log in Successful");
            Shortcuts.clearScreen();
    
        }
        else
        {
            System.out.println("Invalid Username OR Password.");
        }
    }
}
