package act3;
public class Calculation{
    @SuppressWarnings("unused")
        // System.out.println("Hello world");

        float basic_pay = 0f; //monthly
        /* 
        hour rate = month/4weeks/5days/8hours
        */
        float hour_rate = ((basic_pay / 4f) / 5f / 8f ); // 125.00php
        float day_rate = hour_rate * 8f; // 1000php
        float week_rate = day_rate * 5f; // 5000php
        // System.out.println(basic_pay);
        // System.out.println(hour_rate);
        // System.out.println(day_rate);
        // System.out.println(week_rate);

        public Calculation(float basic_pay){
            this.basic_pay = basic_pay;
        }
}