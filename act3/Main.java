package act3;

import misc.*;
import controller.*;

public class Main{
    static Work work = new Work();
    static Payslip payslip = new Payslip(null);
    static Misc misc = new Misc();
    static Controller controller = new Controller();

    public static void main(String[] args){
        // System.out.println("Hello World");
        String name = null;
        
        
        while(true){
            Title();
            System.out.print("What's your name?: ");
            name = controller.scanner.nextLine();
            if(!controller.ConfirmName(name)){
                continue;
            }
            break;
        }
        System.out.println("Name: " + name);
        while(true){
            Title();
            work.SetRate(controller.ValidateHourRate());
            work.SetRegularHours(controller.ValidateHours(work.hour_rate));
            work.SetOvertimeHours(controller.ValidateHours(work.hour_rate, work.reg_hours));
            
            payslip = new Payslip(work);
            payslip.SetGrossPay();
            System.out.println(payslip.gross_pay);
            break;

        }

    }

    static void Title(){
        misc.Title("Payslip Calculator");
    }
}