/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

@WebService(serviceName = "parser")
public class parser {
    static ArrayList <hotel> hotels = new ArrayList<hotel>();
    static ArrayList <car> cars = new ArrayList<car>();
    private static JSONTokener jsonOut;
    private static JSONTokener jsonOut1;
    public static void main(String myHelpers[]) throws JSONException, IOException {
        File f = new File("C:\\Users\\saeed\\Documents\\NetBeansProjects\\webserviceProject\\src\\java\\main\\cars.json");
        File f1 = new File("C:\\Users\\saeed\\Documents\\NetBeansProjects\\webserviceProject\\src\\java\\main\\hotels.json");
        String jsonString = readFile(f.getPath());
        String jsonString1 = readFile(f1.getPath());
        jsonOut = new JSONTokener(jsonString);
        jsonOut1 = new JSONTokener(jsonString1);
        JSONObject output = new JSONObject(jsonOut);
        JSONObject output1 = new JSONObject(jsonOut1);
        String test = "car";
        for(int i=1;i<=4;i++){
            car test1 = new car();
            String id = (String) output.getJSONObject(test+i).get("ID");
            test1.setID(id);
            String name = (String) output.getJSONObject(test+i).get("name");
            test1.setName(name);
            String color = (String) output.getJSONObject(test+i).get("color");
            test1.setColor(color);
            String cost = (String) output.getJSONObject(test+i).get("cost");
            test1.setCost(cost);
            cars.add(test1);
        }
        
        String test3 = "hotel";
        for(int i=1;i<=3;i++){
            hotel test2 = new hotel();
            String name = (String) output1.getJSONObject(test3+i).get("name");
            test2.setName(name);
            String id = (String) output1.getJSONObject(test3+i).get("ID");
            test2.setID(id);
            String cost = (String) output1.getJSONObject(test3+i).get("cost");
            test2.setCost(cost);
            String loc = (String) output1.getJSONObject(test3+i).get("location");
            test2.setLocation(loc);
            hotels.add(test2);
        }
        ShowHotels("test");
        System.out.println("\n\n");
        ShowCars("test");
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
    
    
    @WebMethod(operationName = "hello")
    public static void ShowHotels(@WebParam() String txt) {
        hotel temp;
        for(int i=0;i<hotels.size();i++){
            temp = hotels.get(i);
            System.out.println(temp.ID + " "+temp.name+" "+temp.location+" "+temp.cost);
        }
    }
    @WebMethod(operationName = "hello")
    public static void ShowCars(@WebParam() String txt) {
        car temp;
        for(int i=0;i<cars.size();i++){
            temp = cars.get(i);
            System.out.println(temp.ID + " "+temp.name+" "+temp.color+" "+temp.cost);
        }
    }
}
