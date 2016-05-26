/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import DataParser.car;
import DataParser.hotel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

@WebService(serviceName = "parser")
public class parser {
     ArrayList <hotel> hotels ;
     ArrayList <car> cars;
  public void parsing() throws JSONException, IOException {    
  
  
   hotels   = new ArrayList<hotel>();
   cars = new ArrayList<car>();
     String f="/home/saeed/NetBeansProjects/webserviceProject/src/java/DataParser/hotels.json";
                    JSONObject req;

        req =new JSONObject (readFile(f)) ;
        
        JSONArray jsonArray = req.getJSONArray("hotels");

        for(int i=0;i<jsonArray.length();i++){
                        JSONObject hotelsObject = jsonArray.getJSONObject(i);
            hotel test1 = new hotel();
test1.setName(hotelsObject.getString("name"));  
            test1.setID(Integer.parseInt(hotelsObject.getString("ID")));
                      test1.setCost(Double.parseDouble(hotelsObject.getString("cost")));

                        test1.setLocation((hotelsObject.getString("location")));

            
            
        
            hotels.add(test1);
        }
                            JSONObject req1;

            String g1=  "/home/saeed/NetBeansProjects/webserviceProject/src/java/DataParser/cars.json";
                               req1 =new JSONObject(readFile(g1));


        
                JSONArray jsonarray = req1.getJSONArray("cars");

        for(int i=0;i<jsonarray.length();i++){
               JSONObject carsObject = jsonarray.getJSONObject(i);
            car test1 = new car();
                        test1.setID(Integer.parseInt(carsObject.getString("ID")));

test1.setName(carsObject.getString("name"));  
                        test1.setColor((carsObject.getString("color")));

                      test1.setCost(Double.parseDouble(carsObject.getString("cost")));


            
            
        
            cars.add(test1);
            
        }
        
          for(int i =0; i <cars.size(); i++){
            car u = (car) cars.get(i);
           System.out.println(" \nUser : "+ u.getID());
           System.out.println(" \t Name : "+ u.getName());
           System.out.println(" \t Date  : "+ u.getCost());
       
           System.out.println(" \t Address : "+u.getColor());
         
          }
       
    }
    
    private  String readFile(String file) throws IOException {
        
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");

        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }

        return stringBuilder.toString();
    }

    /**
     * Web service operation
     */
    public String findhotels(@WebParam(name = "Id") int Id) throws IOException{
        //TODO write your implementation code here:

    try {
             parsing();
         } catch (JSONException ex) {
             Logger.getLogger(parser.class.getName()).log(Level.SEVERE, null, ex);
         }             String q="";

               hotel m = new hotel();
              m= hotels.get(Id-1);
                              String name = m.getName();
           int id = m.getID();
                String col = m.getLocation();
                           double c = m.getCost();

                   q+=id+"\n"+name+"\n"+c+"\n"+col;

    
            
        return q ;
    }

    /**
     * Web service operation
     */
    public String findscar(@WebParam(name = "Id") int Id) throws IOException{

    try {
             parsing();
         } catch (JSONException ex) {
             Logger.getLogger(parser.class.getName()).log(Level.SEVERE, null, ex);
         }             String q="";

               car m = new car();
              m= cars.get(Id-1);
                              String name = m.getName();
           int id = m.getID();
                                      double c = m.getCost();

                String col = m.getColor();
                   q+=id+"\n"+name+"\n"+c+"\n"+col;
                   
                   return q;
    }

    /**
     * Web service operation
     */
    public String showhotels() throws IOException {
        try {
             parsing();
         } catch (JSONException ex) {
             Logger.getLogger(parser.class.getName()).log(Level.SEVERE, null, ex);
         } 
        String f="";
        for(int i=0;i<hotels.size();i++){
        
         hotel u = (hotel) hotels.get(i);
        f+=u.getID()+"\n"+u.getName()+"\n"+u.getCost()+"\n"+u.getLocation()+"\n";
        
        
        
        
        
        }
        
        
        
        return f;
    }

    public String showcars() throws IOException {
        try {
             parsing();
         } catch (JSONException ex) {
             Logger.getLogger(parser.class.getName()).log(Level.SEVERE, null, ex);
         } 
        String f="";
        for(int i=0;i<cars.size();i++){
        
         car u = (car) cars.get(i);
        f+=u.getID()+"\n"+u.getName()+"\n"+u.getCost()+"\n"+u.getColor()+"\n";
        
        
        
        
        
        }
        
        
        
        return f;
    }
    
    
}

  