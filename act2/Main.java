package act2;

import misc.*;
import controller.*;

public class Main {
    static Misc misc = new Misc();
    static Controller controller = new Controller();
    static int option = 0;
    static int amount = 0;
    static String amount_option = null;
    static int total_price = 0;
    static boolean is_stock_enough = false;
    static boolean confirm_transaction = false;
    
    static Item piattos = new Item(1,"Clover Chips", 10, 56);
    static Item chippy_red = new Item(2, "Chippy Red", 10, 67);
    static Item chippy_blue = new Item(3, "Chippy Blue", 10, 67);
    static Item bread_pan = new Item(4, "Bread Pan", 9, 80);
    static Item royal_mismo = new Item(5, "Royal Mismo", 20, 35);
    static Item coke_mismo = new Item(6, "Coke Mismo", 20, 25);
    static Item sprite_mismo = new Item(7, "Sprite Mismo", 20, 30);
    static Item coke_l = new Item(8, "Coke 1.5L", 75, 18);
    static Item pancit_canton = new Item(9, "Pancit Canton Original", 17, 24);
    static Item nissin_ramen = new Item(10, "Nissin's Ramen Beef", 16, 28);
    static Item lucky_me = new Item(11, "Lucky Me Chicken", 12, 25);
    static Item creamy_white = new Item(12, "Creamy White", 15, 99);
    static Item kopiko_brown = new Item(13, "Kopiko Brown", 15, 99);
    static Item great_taste_choco = new Item(14, "Great Taste Choco", 17, 99);
    static Item marlboro_red = new Item(15, "Marlboro Red", 10, 200);
    static Item gin = new Item(16, "Gin", 65, 40);
    static Item red_horse = new Item(17, "Red Horse 1L", 128, 28);
    static Item tanduay = new Item(18, "Tanduay", 137, 20);

    static Item[] items = new Item[]{piattos, chippy_red, chippy_blue, bread_pan, royal_mismo, coke_mismo, sprite_mismo, coke_l, pancit_canton, nissin_ramen, lucky_me, creamy_white, kopiko_brown, great_taste_choco, marlboro_red, gin, red_horse, tanduay
        };

    static Item selected_item = new Item(0, null, 0, 0);
    public static void main(String[] args){
        // System.out.println("Hello World");
        while (true) {
        misc.Title("Erlinda Store");
        System.out.println("No.  Name                     Price        Stocks");
        for (Item item : items) {
            item.Format();
        }
        System.out.println("\n" + misc.OptionRange(items) + " Select Item   [0] Exit" );
        System.out.print("What would you like to buy?: ");

        selected_item = controller.SelectItem(items);

        if(selected_item.id == 0){
            misc.Title("Exit");
            System.out.println("Thank you for using our program!");
            System.exit(0);
        }

        misc.Title("Erlinda Store");
        System.out.printf("You've selected: [%s]\n", selected_item.name);
        System.out.println("It costs [" + selected_item.price + "PHP] each and we have a stock of [" + selected_item.stock + "] items.");
        amount_option = misc.OptionRange(1, selected_item.stock);
        System.out.printf("\n%s Amount   [0] Back", amount_option);
        System.out.printf("\nHow much would you like to buy?: " );

        amount = controller.GetAmount(selected_item);
        if(amount == -1){
            selected_item = new Item(0,null, 0,0);
            continue;
        }
        total_price = controller.GetTotal(selected_item, amount);
        if(total_price == 0){
            continue;
        }

        misc.Title("Confirm Transaction");
        System.out.printf("Item: [%s]", selected_item.name);
        System.out.printf("\nAmount: [%s]", amount);
        System.out.printf("\nTotal Price: [%sPHP]", total_price);

        System.out.print("\n\nConfirm transaction? [y/n]: ");

        confirm_transaction = controller.ConfirmTransaction(selected_item, amount, total_price);
        if(!confirm_transaction){
            misc.Title("Confirm Transaction");
            controller.WaitEnter("\nTransaction Cancelled.\n\nPress Enter to return.");
            continue;
        }

        misc.Title("Confirm Transaction");
        controller.WaitEnter("Thank you for your purchase!\n\nPress Enter to return.");
    
        selected_item.stock = selected_item.stock - amount;
        selected_item = new Item(0, null, 0, 0);
        
        continue;
        }
    }
}
