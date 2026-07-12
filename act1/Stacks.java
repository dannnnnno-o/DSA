package act1;
import java.util.ArrayList;
import java.util.Scanner;
import misc.*;

public class Stacks{
    public static void main(String[] args){
        // System.out.println("Hello World");
        Misc misc = new Misc();
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int quote_count = 0;
        int parenthesis_count = 0;

        String sample_line = "printf(\"Hello World\");";
        ArrayList<Character> stack = new ArrayList<Character>();

        for (char c : sample_line.toCharArray()) {
            stack.add(c);
        }

        for(int i = stack.size() - 1; i >= 0; i--){
            if(stack.get(i) == '"'){
                quote_count++;
            }
            
            else if(stack.get(i) == '(' || stack.get(i) == ')'){
                parenthesis_count++;
            }
            misc.Clear();
            System.out.println("Double Quotes Count: " + quote_count);
            System.out.println("Parenthesis Count: " + parenthesis_count);

            sb.setLength(0);
            for (char c : stack) {
                sb.append(c);
            }
            
            System.out.println("\nCurrent Stack: " + sb);
            System.out.println("Current Head: " + stack.get(i));
            System.out.print("\nPress enter to continue.");
            stack.remove(stack.size() - 1);
            scanner.nextLine();
        }
        scanner.close();
    }
}