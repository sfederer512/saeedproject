package main;

public class hotel {
    String name;
    String ID;
    String location;
    String cost;
    public hotel(){
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
    
    public void setLocation(String l){
        this.location = l;
    }
    
    public String getLocation(){
        return this.location;
    }
    
    public void setCost(String c){
        this.cost = c;
    }
    
    public String getCost(){
        return this.cost;
    }
}
