package act2;

import misc.*;
import java.util.Scanner;
public class Main {
    static Misc misc = new Misc();
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args){
        // System.out.println("Hello World");
        Item piattos = new Item(1,"Piattos", 14);
        Item chippy_red = new Item(2, "Chippy Red", 10);
        Item chippy_blue = new Item(3, "Chippy Blue", 10);
        Item bread_pan = new Item(4, "Bread Pan", 9);
        Item creamy_white = new Item(5, "Creamy White", 14);
        Item coke = new Item(6, "coke", 20);
        Item[] items = new Item[]{piattos, chippy_red, chippy_blue, bread_pan, creamy_white, coke};

        int option = 0;
        Item selected_item = new Item(0, null, 0);

        misc.Title("Erlinda Store");
        for (Item item : items) {
            item.Format();
        }

        System.out.print("\nWhat would you like to buy? " + misc.OptionRange(items) + ": ");
        option = scanner.nextInt();
        scanner.nextLine();

        for(Item item : items){
            if(option == item.id){
                selected_item = item;
            }
        }

        System.out.println("you chose:");
        selected_item.Format();
    }
}
