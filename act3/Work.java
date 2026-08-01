
package act3;
// import java.util.Map;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Work{
    public BigDecimal basic_pay;
    public BigDecimal hour_rate;
    public BigDecimal ot_rate = new BigDecimal("1.25");
    public BigDecimal ot_pay;


    public BigInteger reg_hours;
    public BigInteger reg_night;
    public BigInteger ot_hours;
    public BigInteger ot_night;
    public BigInteger total_hours;
    
    // public long weeks = 1;
    // public long day = 1;

/*    public void PeekEndDay(){

    }

     void EndDay(){
        if(this.day == 5){
            this.ot_hours += 2;
        }
        else if(this.day == 7){
            this.ot_hours++;
        }
        this.reg_hours += 8;
        this.total_hours = this.reg_hours + this.ot_hours;
        this.day++;
    } */

/*     float GetDay(){
        return this.day;
    } 
    float GetWeek(){
        float cur_day = this.day;
        return cur_day / 5;
    }
    void EndWeek(){
        if((int)this.weeks == 1 && ot_hours != 2){
            ot_hours += 2;
        }
        else if((int)this.weeks == 2 && ot_hours != 3){
            ot_hours++;
        }
        this.reg_hours = 8f * (this.weeks * 5f);
        this.day = reg_hours / 8f + 1f;
        this.total_hours = this.reg_hours + this.ot_hours;
        // this.day++;
        this.weeks++;
        // this.day = reg_hours/8f;
    }

    void EndMonth(){
        this.weeks = 4f;
        this.reg_hours = 160f;
        this.ot_hours = 3f;
        this.day = 21;
        this.total_hours = 163f;
    }

    String SummarizeWeek(){
        Map<Integer, String> week_messages = Map.of(
            1, "Skipped Week 1\n\nYou did generally well on the first week, except for the\nmistake of pushing a buggy code into production on the fifth day.",
            2, "Skipped Week 2\n\nYou only encountered a problem that caused you to work overtime for an hour on the second day\nthis previous week. As the rest of the days passed by, you ended the week feeling satisfied.",
            3, "Skipped Week 3\n\nYou did not encounter any overtime-inducing problems this week, and you got the\nprivilege to witness how amazing your senior at work on Thursday and you've\ntried your best to apply what you've learned the day after.\n\nYou ended the week feeling proud of your progress.",
            4, "Skipped Week 4\n\nYou've finally completed your first month and has received your first monthly salary."
        );
        return week_messages.get((int)this.weeks);
    }
    
    String SummarizeMonth(){
        return "You've finally completed your first month and has received your first monthly salary.";
    }

    float GetSalary(){
        return ((this.reg_hours * (float) hour_rate) + (this.ot_hours * ot_rate));
    }

    public void ShowDay(){
        System.out.printf("Day: %.0f\n\n", this.day);

    }

    public void FormatCounter(){
        System.out.printf("\nRegular Hours: %.0f\n", this.reg_hours + 8f);
        if(this.day == 5){
            System.out.printf("Overtime Hours: %.0f\n\n", this.ot_hours + 2);
        }
        else if(this.day == 7){
            System.out.printf("Overtime Hours: %.0f\n\n", this.ot_hours + 1f);
        }
        System.out.printf("Overtime Hours: %.0f\n\n", this.ot_hours);
    }

    public String DayMessage(){
        String day_message ;
        // Integer day = (int) this.GetDay();

        Map<Integer, String> days = Map.ofEntries(
            Map.entry(1, "Your first day wasn't all that busy.\n\nYou got introduced to your colleagues, set up your\nwork station, and completed your first task accordingly."),
            Map.entry(2, "It's your second day of work, and you're eager to\ncomplete the tasks assigned to you. You ended the day \nwith a sigh of relief that you did not mess anything up."),
            Map.entry(3, "Third day and you're getting comfortable with your current workspace.\nYou're getting along with your colleagues as well, and is doing generally well on the job."),
            Map.entry(4, "Fourth day and you're doing your tasks as usual.\nNothing much occured and the day ended normally."),
            Map.entry(5, "Fifth day, it's friday and you were doing good\nuntil it was 4pm and you've made a mistake in pushing\na buggy code in the production. You took an overtime\nand managed to get things all together at 7pm."), // 2 hour overtime
            Map.entry(6, "New week, and you're feeling cautious about not repeating the same mistake you did last week.\nLuckily, the day ended fine this time."),
            Map.entry(7, "You woke up feeling good today and went to work feeling good as well.\nNot until you've encountered a problematic bug in the codebase that caused you to work overtime for an hour."), // 1 hour overtime
            Map.entry(8, "Today went pretty normal as there wasn't much problems encountered\nwithin the day. Tasks are completed accordingly and you went home satisfied."),
            Map.entry(9, "You're getting used to the environment and the people around.\nFor better or for worse, nothing particularly happened today."),
            Map.entry(10, "Nothing much happened today as well. Things are pretty normal,\nand there weren't much bugs encountered. You ended the week feeling satisfied."),
            Map.entry(11, "Your third week is just starting  you've already encountered another\nhead-ache-causing bug. Luckily, it was on the afternoon so you had enough time to work on it."),
            Map.entry(12, "\"Uneventful but a day that matters.\" That's what you told yourself as you ended the day normally."),
            Map.entry(13, "\"Uneventful but a day that matters.\" You told yourself once more as you ended the day normally."),
            Map.entry(14, "If there was anything particular to mention today, it's that you've had the\nprivelege to witness the gap betweek you and your senior at work. You recalled the concepts you've observed on your way home."),
            Map.entry(15, "Being eager to apply what you've learned, you locked in and ended the week feeling proud with your progress."),
            Map.entry(16, "It's the last week of the month and you've decided not to think too much about\nwhere to spend your first salary. You managed to focus just fine and ended the day normally."),
            Map.entry(17, "As your payday closes in, you can't help but think of things\nto treat yourself to and couldn't help but get fired up\nwith completing your tasks. You ended the day very well."),
            Map.entry(18, "For some reason, you've got sharp focus today and even after encountering\na head-ache-inducing problem, you've managed to end the day just in time to not work overtime."),
            Map.entry(19, "Today went pretty normal. Excited for your payday, you fantasized about what to do with your first payday."),
            Map.entry(20, "As your salary is going to be sent in your bank account after work hours today,\nyou did your best to hold your excitement and anxiousness for what is there to come and ended your shift with ambivalence inside your chest.")
        );
        day_message = days.get((int)this.day);
        return day_message;
   
    }
*/


    public void SetOvertimeHours(BigInteger hours){
        this.ot_hours = hours;        
        this.ot_pay = hour_rate.multiply(ot_rate);
    }


}