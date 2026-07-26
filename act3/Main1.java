/* package act3;
import misc.*;
import controller.*;


public class Main1{

    static Misc misc = new Misc();
    static Controller controller = new Controller();
    static Work work = new Work();
    static Payslip payslip = new Payslip(null);
    public static void main(String[] args){
        
        boolean option = false;
        String skip = null;
        
        // System.out.println("Hello world");
        Title();

        System.out.printf("Welcome to ABC Tech Solutions!\n\nWe are currently hiring an entry-level back-end developer\nwith a basic salary of [%.0fPHP] per month.\n\nWork starts from monday to friday for 9am - 5pm with a\nbasic pay of [%.0fPHP] per day and [%.0fPHP] per hour.\n", work.basic_pay, work.hour_rate * 8f, work.hour_rate);

        System.out.print("\nWould you like to work in our company? [y/n]: ");

        option = controller.ConfirmEmployment(work);

        if(!option){
            Title();
            System.out.println("Thank you for visiting us.");
            System.exit(0);
        }

        boolean skip_week = false;
        boolean skip_month = false;
        
        while(work.day <= 20){
            if(skip_week){
                Title();
                System.out.println(work.SummarizeWeek());
                work.EndWeek();
                controller.WaitEnter();
                skip_week = false;
                continue;
            }
            else if(skip_month){
                Title();
                System.out.println(work.SummarizeMonth());
                work.EndMonth();
                controller.WaitEnter();
                skip_month = false;
                continue;
            }
            Title();
            work.ShowDay();
            System.out.println(work.DayMessage());
            work.PeekEndDay(); 
            work.FormatCounter();
            System.out.print("What would you like to skip? [day/week/month]: ");
            skip = controller.Skip(work);
            switch(skip){
                case "week" -> skip_week = true;
                case "month" -> skip_month = true;
            }
            work.EndDay();
            continue;
        }
        Title();
        payslip = new Payslip(work);
        
        payslip.Show();
    }

    static void Title(){
        misc.Title("ABC Tech Solutions");
    }
} */