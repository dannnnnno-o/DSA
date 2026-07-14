package act1;
import misc.*;

import java.util.Scanner;

import java.util.Arrays;
import java.util.ArrayList;


public class Act1 {
    static Misc misc = new Misc();
    static Scanner scanner = new Scanner(System.in);        
    static StringBuilder sb = new StringBuilder();
    static int option = 0;
    
    public static void main(String[] args){
        // System.out.println("Hello World");
        // Task: Simple program that shows illustrates array, linked lists, stack, queue, etc.

        misc.Title("Data Structures and Algorithms");

        String[] sample_array = new String[]{"First String", "Second String", "Third String", "Fourth String"};
        String line = "printf(\"Hello World\");";
        System.out.println("Hello! Welcome to our small program that\nshowcases the following data structures:\n");
        misc.Options(new String[]{"Array", "Stack", "Exit"});
        System.out.print("\nWhat would you like to showcase? [1 - 3]: ");
        option = scanner.nextInt();
        switch (option) {
            case 1 -> Arrays(sample_array); 
            case 2 -> Stacks(line);
            case 3 -> misc.Title("Exit"); 
            default -> main(new String[]{});
        }//
        System.out.println("Thank you for using our program!");
        System.exit(0);
    }

    public static void Arrays(String[] sample_array){
        misc.Title("Arrays");
        System.out.println("An array contains a multiple element of a single data type stored \nin a contiguous memory that can be accessed using their respective indeces.");
        System.out.print("\nHere we have an example array of data type <String>: ");
        System.out.println(Arrays.toString(sample_array));
        System.out.println();
        String[] array_option = new String[]{"View Element", "Edit Element", "Add Element", "Delete Element", "Back"};
        misc.Options(array_option);
        System.out.printf("\nWhat would you like to do? %s: ", misc.OptionRange(array_option, false));
        option = scanner.nextInt();
        switch (option) {
            case 1:
                misc.Title("View Array Element");
                System.out.println("Elements in an array can be accessed through their respective indeces.");
                System.out.println("Index count starts at zero and goes so on and so forth.");
                System.out.println("So to access the first element, you must select 0.\n");

                System.out.printf("Which element would you like to view? %s: ", misc.OptionRange(sample_array, true));
                option = scanner.nextInt();

                misc.Title("View Array Element");
                System.out.println("Element at index " + option + ": " + sample_array[option]);
                System.out.println("\nPress enter to continue.");

                scanner.nextLine();
                scanner.nextLine();
                break; // end View Array Element

            case 2: // Edit Element
                misc.Title("Edit Element");
                System.out.printf("Which element would you like to edit? %s: ", misc.OptionRange(sample_array, true));
                option = scanner.nextInt();
                misc.Title("Edit Element");
                System.out.println("The element you selected is: [" + sample_array[option] + "]");
                System.out.print("What would you like to change it to?: ");
                scanner.nextLine();
                sample_array[option] = scanner.nextLine();

                System.out.println(Arrays.toString(sample_array));
                break;

            case 3: //Add Element
                String toAdd;
                misc.Title("Add Element");
                System.out.println("The current array is: " + Arrays.toString(sample_array));
                System.out.print("What would you like to add?: ");
                scanner.nextLine();
                toAdd = scanner.nextLine();
                String[] expanded_array = Arrays.copyOf(sample_array, sample_array.length + 1);
                expanded_array[expanded_array.length - 1] = toAdd;
                sample_array = expanded_array;
                misc.Title("Add Element");
                System.out.println("New array: " + Arrays.toString(sample_array));
                break;
            case 4: // Delete Element
                misc.Title("Delete Element");
                System.out.println("This is the current array: " + Arrays.toString(sample_array));
                System.out.printf("Which index would you like to delete?: %s: ", misc.OptionRange(sample_array, true));
                int toDelete = scanner.nextInt();
                if(toDelete == sample_array.length - 1){
                    sample_array = Arrays.copyOf(sample_array, sample_array.length - 1);
                }
                else{
                    for(int i = toDelete; i < sample_array.length - 1; i++){
                    sample_array[i] = sample_array[i + 1];
                    }
                    sample_array = Arrays.copyOf(sample_array, sample_array.length - 1);
                }
                System.out.println(Arrays.toString(sample_array));
                break;

            case 5:
                main(new String[]{});
        }
        Arrays(sample_array);
    }

    public static void Stacks(String line){
        int quote_count = 0;
        int parenthesis_count = 0;
        ArrayList<Character> stack = new ArrayList<Character>();
        String[] stack_option = new String[]{"Validate Stack", "Replace Stack", "Back"};
        for(char c: line.toCharArray()){
            stack.add(c);
        }
        sb.setLength(0);
        for(char c : line.toCharArray()){
            sb.append(c);
        }

        misc.Title("Stacks");
        System.out.println("A stack is a collection of elements that \"stacks\" on top of each other.");
        System.out.println("For this reason, it follows a LIFO (Last-in First-out) logic.");
        System.out.println("\nThis section showcases the use of stacks by imitating a compiler's behavior.");
        System.out.println("By matching the number of quotes and parenthesis, we can determine whether a line of code is valid or not.\n");
        System.out.println("Here is our current stack: " + sb);
        System.out.println();
        misc.Options(stack_option);
        System.out.print("\nWhat would you like to do? "+ misc.OptionRange(stack_option, false) +": ");
        option = scanner.nextInt();
        scanner.nextLine();
        
        switch (option) {
            case 1:
                int valid = 0;
                String conclusion;
                for(int i = stack.size() - 1; i >= 0; i--){
                    sb.setLength(0);
                    for(char c : stack){
                        sb.append(c);
                    }

                    if(stack.get(i) == '"'){
                        quote_count++;
                    }

                    else if(stack.get(i) == '(' || stack.get(i) == ')'){
                        parenthesis_count++;
                    }

                    misc.Title("Validate Stack");
                    System.out.println("Parenthesis Count: " + parenthesis_count);
                    System.out.println("Qoute Count: " + quote_count);

                    System.out.println("\nCurrent Stack: " + sb);
                    System.out.println("Current Head: " + stack.get(i));

                    System.out.print("\nPress enter to continue.");
                    scanner.nextLine();

                    stack.remove(stack.size() - 1);
                }
                if(parenthesis_count == 0 || quote_count == 0){
                    valid = -1;
                    conclusion = "";
                }
                else if(parenthesis_count % 2 != 0 || quote_count % 2 != 0){
                    valid = 0;
                }
                else{
                    valid = 1;
                }

                misc.Title("Validate Stack");
                switch(valid){
                    case 1 -> conclusion = "The parenthesis and quote count matches.";
                    case 0 -> conclusion = "The parenthesis and quote does not match.";
                    case -1 -> conclusion = "There are no parenthesis or quote.";
                    default -> conclusion = "Invalid case";
                }
                System.out.println(conclusion);
                System.out.print("The line: \"" + line + "\" is ");
                if(valid == 1){
                    System.out.println("valid code.");
                }
                else{System.out.println("invalid code.");}
                System.out.println("\nPress enter to continue.");
                scanner.nextLine();
                
                break;
            case 2:
                misc.Title("Replace Stack");
                System.out.println("The current stack is: " + sb); 
                System.out.print("Replace it with: ");
                Stacks(scanner.nextLine());
                break;

            case 3:
                main(new String[]{""});
            default:
                break;
        }

    Stacks(line);
    }
}