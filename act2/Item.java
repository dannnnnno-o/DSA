package act2;

public class Item{
    public int id;
    public String name;
    public int price;
    public int stock;

    public Item(int id, String name, int price, int stock){
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    int GetPrice(int amount){
        return price * amount;
    }

    void Buy(int amount){
        this.stock = this.stock - amount;
    }

    public void Format(){
        int column1_space = 35;

        int name_space = 25;
        
        String id = "[" + this.id + "] ";
        String name = this.name;
        int name_length = this.name.length();
        int id_length = id.length();

        if(this.id < 10){
            id = "[" + this.id +"]";
            name = "  " + this.name;
        }
        
        if((id_length + name_length) < column1_space){
            System.out.print(id + name);
            for(int i = name_length; i < name_space; i++){
                System.out.print(" ");
            }
        }
        else if(name_length == name_space){
            System.out.println(this.name);
        }
        if(this.price < 10){
            System.out.print(this.price + "  ");
        }
        else if(this.price < 100 && this.price >= 10){
            System.out.print(this.price + " ");
        }
        else{
            System.out.print(this.price +"");
        }
        System.out.print("          ");
        System.out.println(this.stock);

        // System.out.println(this.name + "  " + this.price + "  " + this.stock);
    }

    
}