package act2;

import misc.*;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    static Misc misc = new Misc();
    static Scanner scanner = new Scanner(System.in);
    static int error = 0;
    static int amount = 0;
    static boolean is_stock_enough = false;
    public static void main(String[] args){
        // System.out.println("Hello World");
        Item piattos = new Item(1,"Piattos", 14, 56);
        Item chippy_red = new Item(2, "Chippy Red", 10, 67);
        Item chippy_blue = new Item(3, "Chippy Blue", 10, 67);
        Item bread_pan = new Item(4, "Bread Pan", 9, 80);
        Item creamy_white = new Item(5, "Creamy White", 14, 35);
        Item coke = new Item(6, "coke", 20, 45);
        Item[] items = new Item[]{piattos, chippy_red, chippy_blue, bread_pan, creamy_white, coke};

        int option = 0;
        Item selected_item = new Item(0, null, 0, 0);

        misc.Title("Erlinda Store");
        System.out.println("       Name       Price      Stocks");
        for (Item item : items) {
            item.Format();
        }
        System.out.println("\n" + misc.OptionRange(items) + " Select Item   [0] Exit" );
        System.out.print("What would you like to buy?: ");
        option = scanner.nextInt();
        scanner.nextLine();
        if(option == 0){
            misc.Title("Exit");
            System.out.println("Thank you for using our program!");
            System.exit(0);
        }
        for(Item item : items){
            if(option == item.id){
                selected_item = item;
            }
        }

        while(!is_stock_enough){

            try{
                System.out.print("How much would you like buy?:  ");
                amount = scanner.nextInt();
            }
            catch(InputMismatchException e){
                scanner.next();
                System.out.println(e);
                error = 1; // invalid input
                continue;
            }

            if(amount > selected_item.stock){
                error = 2; // not enough stocks
                continue;
            }

            switch(error){
                case 0:
                    is_stock_enough = true;
                    break;
                case 2: 
                
            }
            break;
        }
        System.out.println("You've selected: " + selected_item.name);
    }

    
}
