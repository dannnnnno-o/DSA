package controller;

import java.util.Scanner;
import java.util.InputMismatchException;
import act2.*;
import misc.*;

public class Controller {
    Scanner scanner = new Scanner(System.in);
    Misc misc = new Misc();
    int option = 0;
    boolean error = false;
    String error_message;

    public Item SelectItem(Item[] items){
        Item selected_item = new Item(0,null, 0, 0);
        while (true) {
        if(error){
            misc.Title("Erlinda Store");
            System.out.println("       Name       Price      Stocks");
            for (Item item : items) {
                item.Format();
            }
            System.out.println("\nError: " + error_message);
            System.out.println("\n" + misc.OptionRange(items) + " Select Item   [0] Exit" );
            System.out.print("What would you like to buy?: ");
            error = false;
        }

        try{
            option = scanner.nextInt();
        }
        catch(InputMismatchException e){
            scanner.next();
            error_message = "Invalid input.";
            error = true;
            continue;
        }
        if(option < 0 || option > items.length){
            error_message = "Out of range.\nSelect only from " + misc.OptionRange(items);
            error = true;
            continue;
        }
        
        for(Item item : items){
            if(option == item.id){
                selected_item = item;
            }
        }
        
        break;
    }
        return selected_item;
    }

    public int GetAmount(Item item){
        if(item.stock == 0){
            scanner.nextLine();
            misc.Title("Erlinda Store");
            System.out.printf("We have no stocks for [%s] anymore.", item.name);
            WaitEnter("\n\nPress Enter to return.");
            return -1;
        }
        int amount = 0;
        String option = null;
        while (true) {
            if(error){
                misc.Title("Erlinda Store");
                System.out.println("You've selected: " + item.name);
                System.out.println("It costs " + item.price + "PHP each and we have a stock of [" + item.stock + "] items.");
                System.out.println("\nError: " + error_message);
                option = misc.OptionRange(1, item.stock);
                if(item.stock == 1){
                    option = "[1]";
                }
                System.out.printf("\n%s Amount   [0] Back", option);
                System.out.printf("\nHow much would you like to buy?: " );
                error = false;
            }

            try{
                amount = scanner.nextInt();
            }
            catch(InputMismatchException e){
                scanner.next();
                error_message = "Invalid input.";
                error = true;
                continue;
            }

            if(amount < 0){
                error_message = "Invalid input.";
                error = true;
                continue;
            }

            else if(amount > item.stock){
                error_message = "Not enough stocks.";
                error = true;
                continue;
            }
            break;
        }
        return amount;
    }

    public int GetTotal(Item item, int amount){
        int total = item.price * amount;
        return total;
    }

    public void WaitEnter(String message){
        System.out.println(message);
        scanner.nextLine();
    }

    public boolean ConfirmTransaction(Item item, int amount, int total_price){
        String option = null;
        scanner.nextLine();
        while (true) {
            if(error){
                misc.Title("Confirm Transaction");
                System.out.printf("Item: [%s]", item.name);
                System.out.printf("\nAmount: [%s]", amount);
                System.out.printf("\nTotal Price: [%sPHP]\n\n", total_price);

                System.out.println(error_message);
                    
                System.out.print("\nConfirm transaction? [y/n]: ");
                error = false;
            }
        
        option = scanner.nextLine();

        if(option.equalsIgnoreCase("y")){
            return true;
        }

        else if(option.equalsIgnoreCase("n")){
            return false;
        }

        else{
            error_message = "Invalid input.";
            error = true;
            continue;
        }

        }
    }

}
