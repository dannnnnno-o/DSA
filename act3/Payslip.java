package act3;

import java.math.BigDecimal;

public class Payslip {
    BigDecimal zero = BigDecimal.ZERO;
    BigDecimal gross_pay = zero;
    BigDecimal deductions = zero; //SSS Philhealth pagibig
    BigDecimal net_pay = zero;
    BigDecimal sss_rate = new BigDecimal("0.05");
    BigDecimal philhealth_rate = new BigDecimal("0.025");
    BigDecimal hdmf_rate = new BigDecimal("0.02");

    Work work = new Work();    

    public Payslip(Work work){
        this.work = work;
    }

    void SetRegularPay(){
        work.basic_pay = work.hour_rate.multiply(work.reg_hours);
        work.night_rate = work.hour_rate.multiply(work.night_rate);
        work.night_pay = work.night_rate.multiply(work.reg_night);
        
        work.regular_pay = work.basic_pay.add(work.night_pay);
    }
    
    void SetOvertimePay(){
        work.ot_rate = work.hour_rate.multiply(work.ot_rate);
        work.reg_ot_pay = work.ot_rate.multiply(work.ot_hours.subtract(work.ot_night));
        work.ot_night_rate = work.hour_rate.multiply(work.ot_night_rate);
        work.ot_night_pay = work.ot_night_rate.multiply(work.ot_night);

        work.ot_pay = work.reg_ot_pay.add(work.ot_night_pay);
    }

    void SetGrossPay(){
        SetRegularPay();
        SetOvertimePay();
        this.gross_pay = work.regular_pay.add(work.ot_pay);
    }

    void SetDeductions(){
        BigDecimal sss = gross_pay.multiply(sss_rate);// this.gross_pay * .05f ; 
        BigDecimal philhealth = gross_pay.multiply(philhealth_rate);// this.gross_pay * 0.025f;
        BigDecimal hdmf = gross_pay.multiply(hdmf_rate); // this.gross_pay * .02f;
        this.deductions = this.deductions.add(sss).add(philhealth).add(hdmf);// sss + philhealth + hdmf;
    }

    void SetNetPay(){
        this.net_pay = gross_pay.subtract(deductions);       
    }

    void Show(){

    }
    



    

    

}
