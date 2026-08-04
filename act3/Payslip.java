package act3;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Payslip {
    BigDecimal zero = BigDecimal.ZERO;
    BigDecimal gross_pay = zero;
    BigDecimal deductions = zero; //SSS Philhealth pagibig
    BigDecimal net_pay = zero;
    BigDecimal sss_rate = new BigDecimal("0.05");
    BigDecimal philhealth_rate = new BigDecimal("0.025");
    BigDecimal hdmf_rate = new BigDecimal("0.02");
    BigDecimal sss = zero;
    BigDecimal philhealth = zero;
    BigDecimal hdmf = zero;

    Work work = new Work();    

    public Payslip(Work work){
        this.work = work;
    }

    void SetRegularPay(){
        work.basic_pay = work.hour_rate.multiply(work.reg_hours.subtract(work.reg_night));
        work.night_pay = work.hour_rate.multiply(BigDecimal.ONE.add(work.night_rate)).multiply(work.reg_night);

        work.regular_pay = work.basic_pay.add(work.night_pay);
    }
    
    void SetOvertimePay(){
        work.reg_ot_pay = work.hour_rate.multiply(work.ot_rate).multiply(work.ot_hours.subtract(work.ot_night));
        work.ot_night_pay = work.hour_rate.multiply(work.ot_night_rate).multiply(work.ot_night);

        work.ot_pay = work.reg_ot_pay.add(work.ot_night_pay);
    }

    void SetGrossPay(){
        SetRegularPay();
        SetOvertimePay();
        this.gross_pay = work.regular_pay.add(work.ot_pay);
    }

    void SetDeductions(){
        this.sss = gross_pay.multiply(sss_rate);// this.gross_pay * .05f ; 
        this.philhealth = gross_pay.multiply(philhealth_rate);// this.gross_pay * 0.025f;
        this.hdmf = gross_pay.multiply(hdmf_rate); // this.gross_pay * .02f;
        this.deductions = this.deductions.add(sss).add(philhealth).add(hdmf);// sss + philhealth + hdmf;
    }

    void SetNetPay(){
        this.net_pay = gross_pay.subtract(deductions);       
    }


    
/*
__________________________________________________
|Name: Dan                                       |
|                                                |
|                   |    Hours    |    Amount    |
|Regular              xxx.yy          xxxxxxx    |
|Night Shift                                     |
|Overtime                                        |
|OT Night Shift                                  |
|                                                |
|Gross Pay:                          xxxxx       |
|                                                |
|================================================|
|Less:                                Amount     |
|SSS                                   xxx       |
|PhilHealth                            xxx       |
|HDMF                                  xxx       |
|                                                |
|NET PAY:                            xxxxxxx     |
|________________________________________________|
*/

    void Show(String name){
        Border("top");
        FormatName(name); // row 1
        FormatHourRate(); // row 2
        EmptyLine(); // row 3
        SetColumns(); // row 4

        DataRow("Regular", work.reg_hours.subtract(work.reg_night), work.basic_pay);
        DataRow("Night Shift", work.reg_night, work.night_pay);
        DataRow("Overtime", work.ot_hours.subtract(work.ot_night), work.reg_ot_pay);
        DataRow("OT Night Shift", work.ot_night, work.ot_night_pay);
        EmptyLine();

        RightRow("Gross Pay:", FormatNum(gross_pay));
        EmptyLine();

        Border("middle");
        RightRow("Less:", "Amount");
        RightRow("SSS", FormatNum(sss));
        RightRow("PhilHealth", FormatNum(philhealth));
        RightRow("HDMF", FormatNum(hdmf));
        EmptyLine();

        RightRow("NET PAY:", FormatNum(net_pay));
        Border("bottom");
    }
    String FormatNum(BigDecimal value){
        String s = value.setScale(2, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString();
        int digits = s.replace("-", "").replace(".", "").length();
        if(digits > 6){
            return s.substring(0, 6) + "...";
        }
        return s;
    }
    void DataRow(String label, BigDecimal hours, BigDecimal amount){
        String row = "|" + label;
        while(row.length() < 20) row += " "; // label field
        row += " "; // gap

        String h = FormatNum(hours);
        while(row.length() + h.length() < 34) row += " ";
        row += h; // hours right-aligned under Hours column

        row += " "; // gap

        String a = FormatNum(amount);
        while(row.length() + a.length() < 49) row += " ";
        row += a; // amount right-aligned under Amount column

        row += "|";
        System.out.println(row);
    }
    void RightRow(String label, String value){
        String row = "|" + label;
        while(row.length() + value.length() < 49) row += " ";
        row += value; // value right-aligned flush against the pipe
        row += "|";
        System.out.println(row);
    }
    void Border(String mode){
        int limit = 50;
        if(mode.equals("top")){
            for(int i = 0; i < limit; i++){
                if( i == 0 || i == limit - 1){
                    System.out.print(" ");
                }
                else{
                    System.out.print("_");
                }
            }
            System.out.println();
        }
        else if(mode.equals("bottom")){
            System.out.print("|");
            for(int i = 0; i < limit - 2; i++){
                System.out.print("_");
            }
            System.out.println("|");
        }
        else if(mode.equals("middle")){
            for(int i = 0; i < limit; i++){
                if(i == 0 || i == limit - 1){
                    System.out.print("|");
                }
                else{
                    System.out.print("=");
                }
            }
            System.out.println();
        }
    }

    void FormatName(String name){
        int limit = 50;
        String n = "|Name: ";
        int name_len = name.length();
        int name_row = name_len + n.length();
        int name_limit = limit - name_row;

        System.out.print(n); 
        if(name_row > name_limit){
            System.out.print(name.substring(0, 39));
            System.out.println("...|");
        }
        else if(name_row < name_limit ){
            System.out.print(name);
            for(int i = 0; i < name_limit - 1; i++){
                System.out.print(" ");
            }
            System.out.println("|");
        }
        else if(name_row == name_limit){
            System.out.println(name + "|");
        }
    }

    void FormatHourRate(){
        String row = "|Hour Rate: " + FormatNum(work.hour_rate);
        while(row.length() < 49) row += " ";
        row += "|";
        System.out.println(row);
    }

    void EmptyLine(){
        int limit = 50;
        for(int i = 0; i < limit; i++){
            if(i == 0 || i == limit - 1){
                System.out.print("|");
            }
            else{
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    void SetColumns(){
        int col1 = 19;

        System.out.print("|");
        for(int i = 0; i < col1; i++){ // col1
            System.out.print(" ");
        }
        System.out.print("|");
        System.out.print("    Hours    ");// col2
        System.out.print("|");
        System.out.print("    Amount    ");// col3

        System.out.println("|");
    }

}
