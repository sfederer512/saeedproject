package DataParser;

public class hotel {
    String name;
    int ID;
    String location;
    double cost;
    public hotel(){
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
    
    public void setLocation(String l){
        this.location = l;
    }

    @Override
    public String toString() {
        return "hotel{" + "name=" + name +"."+ ", ID=" + ID +"."+ ", location=" + location +"."+ ", cost=" + cost + '}';
    }
    
    public String getLocation(){
        return this.location;
    }
    
    public void setCost(double c){
        this.cost = c;
    }
    
    public double getCost(){
        return this.cost;
    }
}
