package misc;
import act2.*;
public class Misc {
    public void Clear(){
        System.out.print("\033[H\033[2J");
    }

    public void Title(String x){
        Clear();
        for(int i = -6; i < x.length(); i++){
            System.out.print("-");
        }

        System.out.println("\n|  " + x + "  |");

        for(int i = -6; i < x.length(); i++){
            System.out.print("-");
        }

        System.out.println();
    }

    public String OptionRange(int floor, int ceiling){
        String option = "["+ Integer.toString(floor) +" - " + Integer.toString(ceiling) +"]";
        return option;        
    }

    public String OptionRange(String[] x, boolean isIndex){
        String option;
        if(isIndex){
            option = "[0]";
            if(x.length > 1){option = "[0 - " + (x.length - 1) + "]";}
        }
        else{
            option = "[1]";
            if(x.length > 1){option = "[1 - " + x.length + "]";}
        }
        return option;
    }
    
    public String OptionRange(Item[] items){
        int item_count = items.length;
        String range;
        if(item_count == 0){
            range = "[0]";
        }
        else if(item_count == 1){
            range = "[1]";
        }
        else{
            range = "[1 - " + Integer.toString(item_count) + "]";
        }

        return range;
    }
    public void Options(String[] x){
        for(int i = 0; i < x.length; i++){
            System.out.println("[" + (i + 1) + "] " + x[i]);
        }
    }
}


