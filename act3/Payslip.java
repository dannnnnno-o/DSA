package act3;

public class Payslip {
    double gross_pay = 0f;
    double deductions = 0f; //SSS Philhealth pagibig
    double net_pay = 0f;

    Work work = new Work();    

    public Payslip(Work work){
        this.work = work;
    }

    void SetGrossPay(){
        this.gross_pay = (work.reg_hours * work.hour_rate) + (work.ot_hours * work.ot_rate);
    }

    void SetDeductions(){
        double sss = this.gross_pay * .05f ;
        double philhealth = this.gross_pay * 0.025f;
        double hdmf = this.gross_pay * .02f;
        this.deductions = sss + philhealth + hdmf;
    }

    void SetNetPay(){
        this.net_pay = this.gross_pay - this.deductions;       
    }

    void Show(){

    }
    



    

    

}
