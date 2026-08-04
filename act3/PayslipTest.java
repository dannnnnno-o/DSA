package act3;

import java.math.BigDecimal;
public class PayslipTest{
    public static void main(String[] args){
        Work w1 = new Work();
        String name = "Daniel Baladad";
        w1.hour_rate = new BigDecimal("10000000000000");

        w1.reg_hours = new BigDecimal("100000000000");
        w1.reg_night = new BigDecimal("10000000000");
        w1.ot_hours = new BigDecimal("1000000000000");
        w1.ot_night = new BigDecimal("10");

        Payslip p1 = new Payslip(w1);
        p1.SetGrossPay();
        p1.SetDeductions();
        p1.SetNetPay();

        Work w2 = new Work();
        w2.hour_rate = new BigDecimal("125");

        w2.reg_hours = new BigDecimal("160");
        w2.reg_night = new BigDecimal("10");
        w2.ot_hours = new BigDecimal("3");
        w2.ot_night = new BigDecimal("1");

        Payslip p2 = new Payslip(w2);
        p2.SetGrossPay();
        p2.SetDeductions();
        p2.SetNetPay();

        Work w3 = new Work();
        w3.hour_rate = new BigDecimal("0");

        w3.reg_hours = new BigDecimal("0");
        w3.reg_night = new BigDecimal("0");
        w3.ot_hours = new BigDecimal("0");
        w3.ot_night = new BigDecimal("0");

        Payslip p3 = new Payslip(w3);
        p3.SetGrossPay();
        p3.SetDeductions();
        p3.SetNetPay();

        p1.Show(name);
        p2.Show(name);
        p3.Show(name);
    }
}