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
            work.hour_rate = controller.ValidateHourRate();

            work.reg_hours = controller.ValidateHours(work, "regular");
            work.reg_night = controller.ValidateHours(work, "regular night");
            work.ot_hours = controller.ValidateHours(work, "overtime"); // (125 * 1.25) * this
            work.ot_night = controller.ValidateHours(work, "overtime night"); // (125 * 1.35) * this

            payslip = new Payslip(work);
            payslip.SetGrossPay();
            payslip.SetDeductions();
            payslip.SetNetPay();
            
            // System.out.println("Gross pay: " + payslip.gross_pay);
            // System.out.println("Deductions: " + payslip.deductions);
            // System.out.println("Net Pay: " + payslip.net_pay);
            payslip.Show(name);
            break;

        }

    }

    static void Title(){
        misc.Title("Payslip Calculator");
    }
}