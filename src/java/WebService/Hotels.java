/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import DataParser.car;
import DataParser.hotel;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

import org.jboss.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author saeed
 */
@WebService(serviceName = "Hotels")
public class Hotels {
 ArrayList <hotel> hotels ;
     ArrayList <car> cars;
    
  public void parsing() throws org.json.JSONException, java.io.IOException   {    
  
  
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
    private  String readFile(String file) throws FileNotFoundException, java.io.IOException  {
        
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
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     * @throws main.IOException
     * @throws main.IOException
     * @throws main.IOException
     * @throws main.IOException
     */
    @WebMethod(operationName = "showHotels")
    public String showHotels() throws org.json.JSONException, java.io.IOException  {
       
 try {
             parsing();
         } 
          catch (org.json.JSONException ex) {
         java.util.logging.Logger.getLogger(Hotels.class.getName()).log(Level.SEVERE, null, ex);
     }         
             String f="";
        for(int i=0;i<hotels.size();i++){
        
         hotel u = (hotel) hotels.get(i);
        f+="ID="+u.getID()+"."+"\n"+"name="+u.getName()+"."+"\n"+"Cost="+u.getCost()+"."+"\n"+"Color"+u.getLocation()+"."+"\n"+"||";

        
        
        
        
        }
     return f;
        
        
        

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ShowCars")
    public String ShowCars() throws java.io.IOException, org.json.JSONException {
 try {
             parsing();
         } 
          catch (org.json.JSONException ex) {
         java.util.logging.Logger.getLogger(Hotels.class.getName()).log(Level.SEVERE, null, ex);
     }         
             String f="";
        for(int i=0;i<cars.size();i++){
        
         car u = (car) cars.get(i);
        f+="ID="+u.getID()+"."+"\n"+"name="+u.getName()+"."+"\n"+"Cost="+u.getCost()+"."+"\n"+"Color"+u.getColor()+"."+"\n"+"||";
        
        
        
        
        
        }
        
        
        
        return f;
    }


    /**
     * Web service operation
     */
    @WebMethod(operationName = "FindHotel")
    public String FindHotel(@WebParam(name = "id") int id) throws java.io.IOException {
 try {
             parsing();
         } 
          catch (org.json.JSONException ex) {
         java.util.logging.Logger.getLogger(Hotels.class.getName()).log(Level.SEVERE, null, ex);
     }         
 String q="";

               hotel m = new hotel();
              m= hotels.get(id-1);
                              String name = m.getName();
           int idd = m.getID();
                String col = m.getLocation();
                           double c = m.getCost();

                   q+="ID="+idd+"."+"\n"+"name="+name+"."+"\n"+"Cost="+c+"."+"\n"+"Location"+col;

    
            
        return q ;    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "FindCar")
    public String FindCar(@WebParam(name = "id") int id) throws java.io.IOException {
      
     try {
             parsing();
         } 
          catch (org.json.JSONException ex) {
         java.util.logging.Logger.getLogger(Hotels.class.getName()).log(Level.SEVERE, null, ex);
     }         
     
     
     
     String q="";

               car m = new car();
              m= cars.get(id-1);
                              String name = m.getName();
           int idd= m.getID();
                                      double c = m.getCost();

                String col = m.getColor();
                   q+="ID="+idd+"."+"\n"+"name="+name+"."+"\n"+"Cost="+c+"."+"\n"+"Color"+col;
                   
                   return q;
    }
}
