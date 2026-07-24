package act3;

import controller.*;
import misc.*;

public class Main{
    static Controller controller = new Controller();
    static View view = new View();
    static Misc misc = new Misc();
    Salary salary = new Salary(0f, 0f, 0f, 0f, 0f);
    static boolean option = false;
    static String skip = null;

    static int day = 1;
    static int hours = 0;
    static int week = 0;
    static int overtime = 0;
    
    static String day_message = null;
    static float basic_pay = 20000f;
    static float hour_rate = ((basic_pay / 4f) / 5f / 8f ); // 125.00php
    static float overtime_rate = (hour_rate * 1.25f);
    static float day_rate = hour_rate * 8f; // 1000php
    static float week_rate = day_rate * 5f; // 5000php
    static float total_hours = 8f * 5f * 4f;
    static float night_differential = 0f;
    static float legal_holiday = 0f;
    static float gross_pay = 0f;
    
    static float sss = basic_pay * 0.05f;
    static float philhealth = basic_pay * .025f;
    static float pag_ibig = basic_pay * .02f;
    
    public static void main(String[] args){
        // System.out.println("Hello World");

        misc.Title("ABC Tech Solutions");
        System.out.printf("Welcome to ABC Tech Solutions!\n\nWe are currently hiring an entry-level back-end developer\nwith a basic salary of [%.0fPHP] per month.\n\nWork starts from monday to friday for 9am - 5pm with a\nbasic pay of [%.0fPHP] per day and [%.0fPHP] per hour.\n", basic_pay, day_rate, hour_rate);

        System.out.print("\nWould you like to work in our company? [y/n]: ");

        option = controller.ConfirmEmployment(basic_pay, day_rate, hour_rate);

        if(!option){
            misc.Title("ABC Tech Solutions");
            System.out.println("Thank you for vising us.");
            System.exit(0);
        }
        Work();
    }

    static void Work(){
        if(day >= 20){
            NetPay(hours, overtime);
        }
        misc.Title("ABC Tech Solutions");
        if(day == 1){
            System.out.println("Great! Once again, welcome to ABC Tech Solutions!\nWe're glad to have you here.");
            controller.WaitEnter("\nPress enter to continue.");
        }


        misc.Title("ABC Tech Solutions");
        System.out.printf("Day: %d\n", day);
        System.out.printf("Regular Hours: %d\n", hours);
        System.out.printf("Overtime Hours: %d\n\n", overtime);



        switch(day){
            case 1:
                day_message = "Your first day wasn't all that busy.\n\nYou got introduced to your colleagues, set up your\nwork station, and completed your first task accordingly.";
                break;
            case 2:
                day_message = "It's your second day of work, and you're eager to\ncomplete the tasks assigned to you. You ended the day \nwith a sigh of relief that you did not mess anything up.";
                break;
            case 3:
                day_message = "Third day and you're getting comfortable with your current workspace.\nYou're getting along with your colleagues as well, and is doing generally well on the job.";
                break;
            case 4:
                day_message = "Fourth day and you're doing your tasks as usual.\nNothing much occured and the day ended normally.";
                break;
            case 5:
                day_message = "Fifth day, it's friday and you were doing good\nuntil it was 4pm and you've made a mistake in pushing\na buggy code in the production. You took an overtime\nand managed to get things all together at 7pm.";
                break;            
            case 6:
                day_message = "New week, and you're feeling cautious about not repeating the same mistake you did last week.\nLuckily, the day ended fine this time.";
                break;
            case 7: 
                day_message = "You woke up feeling good today and went to work feeling good as well.\nNot until you've encountered a problematic bug in the codebase that caused you to work overtime for an hour.";
                overtime++;
                break;
            case 8:
                day_message = "Today went pretty normal as there wasn't much problems encountered\nwithin the day. Tasks are completed accordingly and you went home satisfied.";
                break;
            case 9: day_message = "You're getting used to the environment and the people around.\nFor better or for worse, nothing particularly happened today.";
                break;
            case 10:
                day_message = "Nothing much happened today as well. Things are pretty normal,\nand there weren't much bugs encountered. You ended the week feeling satisfied.";

            case 11:
                day_message = "Your third week is just starting  you've already encountered another\nhead-ache-causing bug. Luckily, it was on the afternoon so you had enough time to work on it.";
                break;
            case 12:
                day_message = "\"Uneventful but a day that matters.\" That's what you told yourself as you ended the day normally.";
                break;
            case 13:
                day_message = "\"Uneventful but a day that matters.\" You told yourself once more as you ended the day normally.";
                break;
            case 14: 
                day_message = "If there was anything particular to mention today, it's that you've had the\nprivelege to witness the gap betweek you and your senior at work. You recalled the concepts you've observed on your way home.";
                break;
            case 15: 
                day_message = "Being eager to apply what you've learned, you locked in and ended the week feeling proud with your progress.";
                break;
            case 16:
                day_message = "It's the last week of the month and you've decided not to think too much about\nwhere to spend your first salary. You managed to focus just fine and ended the day normally.";
                break;
            case 17:
                day_message = "As your payday closes in, you can't help but think of things\nto treat yourself to and couldn't help but get fired up\nwith completing your tasks. You ended the day very well.";
                break;
            case 18:
                day_message = "For some reason, you've got sharp focus today and even after encountering\na head-ache-inducing problem, you've managed to end the day just in time to not work overtime.";
                break;
            case 19:
                day_message = "Today went pretty normal. Excited for your payday, you fantasized about what to do with your first payday.";
                break;
            case 20: 
                day_message = "As your salary is going to be sent in your bank account after work hours today,\n you did your best to hold your excitement for what is there to come and ended your shift with ambivalence inside your chest.";
                break;

        }
        System.out.println(day_message);
        System.out.print("\nSkip [day]/[week]/[month]: ");
        skip = controller.Skip(day, day_message);

        switch(skip){
            case "day":
                day++; 
                hours += 8;
                break;
            case "week":
                if(day < 5){
                    day = 6; 
                    hours = 40;
                    overtime = 2;
                    WeekSummary(1);
                }
                else{
                    day += 6 - (day % 5);
                    week = day / 5;
                    WeekSummary(week);
                    switch(week){
                        case 2:
                            overtime++;
                            hours = 80; 
                            break;
                        case 3:
                            hours = 120; 
                            break;
                        case 4:
                            hours = 160; 
                            break;
                    }
                }

                break;
            case "month":
                day = 20;
                overtime = 3;
                hours = 160;
                break;
        }

        Work();
    }

    static void WeekSummary(int week){
        String message = null;
        switch(week){
            case 1 -> message = "You did generally well on the first week, except for the\nmistake of pushing a buggy code into production on the fifth day.";
            case 2 -> message = "You only encountered a problem that caused you to work overtime for an hour on the second day\nthis previous week. As the rest of the days passed by, you ended the week feeling satisfied.";
            case 3 -> message = "You did not encounter any overtime-inducing problems this week, and you got the\nprivilege to witness how amazing your senior at work on Thursday and you've\ntried your best to apply what you've learned the day after.\n\nYou ended the week feeling proud of your progress.";
            case 4 -> message = "You've finally completed your first month and has received your first monthly salary.";
        }
        misc.Title("ABC Tech Solutions");
        System.out.println("Summary of the previous week:\n");
        System.out.println(message);
        controller.WaitEnter("\nPress Enter to continue.");

    }

    static void NetPay(int hours, int overtime){
        misc.Title("ABC Tech Solutions");
        System.out.printf("Regular Hours Rendered: %d  | Amount: %.2f\n", hours, hours * hour_rate);
        System.out.printf("Overtime Hours Rendered: %d   | Amount: %.2f\n", overtime, overtime * overtime_rate);

        System.out.printf("Total Hours: %d             | Amount: %.2f: \n", hours + overtime, ((hours * hour_rate) + (overtime * overtime_rate)));
        controller.WaitEnter("\nPress Enter to continue.");

    }
}