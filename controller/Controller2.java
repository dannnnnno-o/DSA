package controller;

import misc.*;

import java.io.Console;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller2 {
    public Scanner scanner = new Scanner(System.in);
    Misc misc = new Misc();

    int choice = 0;
    boolean error = false;
    String error_message = null;
    
    public int GetChoice(String message, String[] options, int ceiling){
        while(true){
            System.out.print(message);
            if(error){
                misc.Title("Record Keeping (201-File)");
                misc.Options(options);
                System.out.printf("\nError: %s", error_message);
                System.out.print(message);
                error = false;
            }
            try{
                choice = scanner.nextInt();
            }
            catch(InputMismatchException e){
                scanner.next();
                error = true;
                error_message = "Invalid input.";
                continue;
            }
            
            if(choice <= 0 || choice > ceiling){
                error = true;
                error_message = "Out of range. Select only from " + misc.OptionRange(1, ceiling);
                continue;
            }
            break;

        }
        scanner.nextLine();
        return choice;
    }

    public String GetUsername(int error, String username){
        if(error == 1 && username != null){
            System.out.printf("Error: Username %s already exist.\n\n", username);
        }
        if(error == 2){
            System.out.printf("Error: Username can't be empty.\n\n", username);
        }

        if(error == 3 && username != null){
            System.out.printf("Error: An account with a username of [%s] does not exist.\n\n", username);
        }
        
        System.out.print("Enter username: ");
        return scanner.nextLine();
    }

    public String GetPassword(boolean confirm){
        Console console = System.console();
        char[] password= {}; 
        if(!confirm){
            password = console.readPassword("Enter password: ");
        }

        else{
            password = console.readPassword("Confirm Password: ");
        }
        return String.valueOf(password);
    }


}
