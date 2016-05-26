/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 *
 * @author saeed
 */
public class NewClass {
   static  ArrayList <hotel> hotels ;
  static   ArrayList <car> cars;
    private static JSONTokener jsonOut;
    private static JSONTokener jsonOut1;

    public static void main(String[] myHelpers) throws IOException, JSONException {
          
            
            
  
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
            
        }for(int i =0; i <cars.size(); i++){
            car u = (car) cars.get(i);
           System.out.println(" \nUser : "+ u.getID());
           System.out.println(" \t Name : "+ u.getName());
           System.out.println(" \t Date  : "+ u.getCost());
       
           System.out.println(" \t Address : "+u.getColor());
         
          }
            }
    
    private static String readFile(String file) throws IOException {
        
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
}