package act3;

public class Worker {
    Work work;

    String name = null;

    float gross_pay = 0f;
    float deductions = 0f;
    float net_pay = 0f;


    public Worker(Work work){
        this.work = work;
    }

    void SetName(String name){
        this.name = name;
    }


}
