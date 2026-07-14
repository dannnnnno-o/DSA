package act2;

public class Item{
    int id;
    String name;
    int price;
    int stock = 99;

    public Item(int id, String name, int price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    int GetPrice(int amount){
        return price * amount;
    }

    void Buy(int amount){
        this.stock = this.stock - amount;
    }

    void Format(){
        int name_space = 20;
        int name_limit = 15;
        int name_length = this.name.length();

        System.out.print("[" + this.id + "] ");
        if(name_length < name_limit){
            System.out.print(this.name);
            for(int i = name_length; i < name_limit; i++){
                System.out.print(" ");
            }
        }
        else if(name_length == name_limit){
            System.out.println(this.name);
        }
        System.out.println(this.price);
        // System.out.println(this.name + "  " + this.price + "  " + this.stock);
    }

    
}