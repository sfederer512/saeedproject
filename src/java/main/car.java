package main;

public class car {
    String name;
    String ID;
    String color;
    String cost;
    public car(){
    }
    
    public void setName(String n){
        this.name = n;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setID(String id){
        this.ID = id;
    }
    
    public String getID(){
        return this.ID;
    }
    
    public void setColor(String co){
        this.color = co;
    }
    
    public String getColor(){
        return this.color;
    }
    
    public void setCost(String c){
        this.cost = c;
    }
    
    public String getCost(){
        return this.cost;
    }
}
