package DataParser;

public class car {
    String name;
    int ID;
    String color;
    double cost;
    public car(){
    }
    
    public void setName(String n){
        this.name = n;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setID(int id){
        this.ID = id;
    }
    
    public int getID(){
        return this.ID;
    }
    
    public void setColor(String co){
        this.color = co;
    }
    
    public String getColor(){
        return this.color;
    }
    
    public void setCost(double c){
        this.cost = c;
    }
    
    public double getCost(){
        return this.cost;
    }
}
