package controller;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.math.BigDecimal;
import java.math.BigInteger;

import act2.*;
import act3.*;
import misc.*;

public class Controller {
    BigDecimal bd_zero = BigDecimal.ZERO;
    BigInteger bi_zero = BigInteger.ZERO;
    
    public Scanner scanner = new Scanner(System.in);
    Misc misc = new Misc();
    static int option = 0;
    static boolean error = false;
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
            error_message = "Error: Invalid input.";
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

    public void WaitEnter(){
        System.out.println("\nPress enter to continue;");
        scanner.nextLine();
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
    
    //act 3

    public boolean ConfirmEmployment(Work work){
        String option = null;
        while(true){
            if(error){
                misc.Title("ABC Tech Solutions");
                System.out.printf("Welcome to ABC Tech Solutions!\n\nWe are currently hiring an entry-level back-end developer\nwith a basic salary of [%sPHP] per month.\n\nWork starts from monday to friday for 9am - 5pm with a\nbasic pay of [%.0fPHP] per day and [%.0fPHP] per hour.\n", work.basic_pay,work.hour_rate.toString(), work.hour_rate);
        
            System.out.println(error_message);

            System.out.print("\nWould you like to work in our company? [y/n]: ");      
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
            error = true;
            error_message = "\nError: Invalid input.";
            continue;
        }
    }
    }
 
/*    public String Skip(Work work){
        String option = null;
        while(true){
            if(error){
            misc.Title("ABC Tech Solutions");
            work.ShowDay();
            System.out.println(work.DayMessage());
            work.PeekEndDay();
            work.FormatCounter();
            System.out.println(error_message);            
            System.out.print("\nWhat would you like to skip?: ");
            error = false;
            }
            option = scanner.nextLine();
            if(option.equalsIgnoreCase("day")){
                return "day";
            }
            else if(option.equalsIgnoreCase("week")){
                return "week";
            }
            else if(option.equalsIgnoreCase("month")){
                return "month";
            }
            else{
                error = true;
                error_message = "Error: Please only select from [day]/[week]/[month].";
                continue;
            }
        }
    } */

    public boolean ConfirmName(String name){
        String option = null;
        while (true) {
            misc.Title("ABC Tech Solutions");

            if(error){
                misc.Title("ABC Tech Solutions");
                System.out.println("Error: Invalid Input\n");
                error = false;
            }
            System.out.print("Is the name [" + name + "] correct? [y/n]: ");
            option = scanner.nextLine();
            if(option.equalsIgnoreCase("y")){
                return true;
            }
            else if(option.equalsIgnoreCase("n")){
                return false;
            }
            else{
                error = true;
                continue;
            }
        }
        
    }

    public BigDecimal ValidateHourRate(){
        BigDecimal hour_rate;
        while(true){
            misc.Title("Payslip Calculator");
            if(error){
                System.out.printf("\nError: %s\n\n", error_message);
                error = false;
            }
            System.out.print("Input your hour rate: ");
            try{
                hour_rate = scanner.nextBigDecimal();
            }
            catch(InputMismatchException e){
                scanner.next();
                error_message = "Invalid Input.";
                error = true;
                continue;
            }

            if(hour_rate.compareTo(bd_zero) == 0){
                error_message = "Hour Rate cannot be 0"; 
                error = true;
                continue;
            }
            else if(hour_rate.compareTo(bd_zero) == -1){
                error_message = "Hour Rate cannot be negative "; 
                error = true;
                continue;
            }

            // else if(hour_rate == Double.POSITIVE_INFINITY){
            //     error_message = "Hour Rate cannot be that big";
            //     error = true;
            //     continue;
            // }
            break;
        }
        return hour_rate;
    }

    public BigInteger ValidateHours(BigDecimal hour_rate){
        BigInteger hours;
        while(true){
            if(error){
                misc.Title("Payslip Calculator");
                System.out.println("Input your hour rate: " + hour_rate);
                System.out.printf("\nError: %s\n", error_message);                
                error = false;
            }
            System.out.print("Input your hours of regular work: ");
            try{
                hours = scanner.nextBigInteger();
            }
            catch(InputMismatchException e){
                scanner.next();
                error_message = "Invalid Input.";
                error = true;
                continue;
            }

            if(hours.compareTo(bi_zero) == 0){
                error_message = "Hours cannot be zero";
                error = true;
                continue;
            }
            else if(hours.compareTo(bi_zero) == -1){
                error_message = "Hours cannot be negative";
                error = true;
                continue;
            }
        return hours;
        }
    }
    public BigInteger ValidateHours(BigDecimal hour_rate, BigInteger reg_hours){
        BigInteger hours;
        while(true){
            if(error){
                misc.Title("Payslip Calculator");
                System.out.println("Input your hour rate: " + hour_rate);
                System.out.println("Input your hours of regular work: " + reg_hours);
                System.out.printf("\nError: %s\n", error_message);                
                error = false;
            }
            System.out.print("Input your hours of overtime work: ");
            try{
                hours = scanner.nextBigInteger();
            }
            catch(InputMismatchException e){
                scanner.next();
                error_message = "Invalid Input.";
                error = true;
                continue;
            }

            if(hours.compareTo(bi_zero) == 0){
                error_message = "Overtime hours cannot be zero";
                error = true;
                continue;
            }
            if(hours.compareTo(bi_zero) == -1){
                error_message = "Overtime hours cannot be negative";
                error = true;
                continue;
            }
            
        return hours;
        }
    }
}
