package misc;
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
    
    public void Options(String[] x){
        for(int i = 0; i < x.length; i++){
            System.out.println("[" + (i + 1) + "] " + x[i]);
        }
    }
}


