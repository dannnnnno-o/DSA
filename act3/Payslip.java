package act3;

import java.math.BigDecimal;

public class Payslip {
    BigDecimal zero = BigDecimal.ZERO;
    BigDecimal gross_pay = zero;
    BigDecimal deductions = zero; //SSS Philhealth pagibig
    BigDecimal net_pay = zero;
    BigDecimal sss_rate = new BigDecimal(0.05);
    BigDecimal philhealth_rate = new BigDecimal(0.025);
    BigDecimal hdmf_rate = new BigDecimal(0.02);

    Work work = new Work();    

    public Payslip(Work work){
        this.work = work;
    }

    void SetOTPay(){
        work.ot_pay = work.hour_rate.multiply(new BigDecimal("1.25"));
    }

    void SetGrossPay(){
        SetOTPay();
        // this.gross_pay = (work.reg_hours * work.hour_rate) + (work.ot_hours * work.ot_rate);
        this.gross_pay = new BigDecimal(work.reg_hours)
                            .multiply(work.hour_rate) // (reg_hours * hour_rate)
                            .add(
                              new BigDecimal(work.ot_hours)
                              .multiply(work.ot_pay)  // (reg_hours * hour_rate) + (ot_hours * ot_pay);
                            );
    }

    void SetDeductions(){
        BigDecimal sss = gross_pay.multiply(sss_rate);// this.gross_pay * .05f ; 
        BigDecimal philhealth = gross_pay.multiply(philhealth_rate);// this.gross_pay * 0.025f;
        BigDecimal hdmf = gross_pay.multiply(hdmf_rate); // this.gross_pay * .02f;
        this.deductions.add(sss).add(philhealth).add(hdmf);// sss + philhealth + hdmf;
    }

    void SetNetPay(){
        this.net_pay = gross_pay.subtract(deductions);       
    }

    void Show(){

    }
    



    

    

}
