

package com.mycompany.consumoapi;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


public class ConsumoAPI {

    public static void main(String[] args) {
        
        try{
        // solicitar una peticion
        //https://jsonplaceholder.typicode.com/users
        URL url = new URL ("https://jsonplaceholder.typicode.com/users");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        
        // peticion correcta ?
        int responseCode = conn.getResponseCode();
        if(responseCode != 200) {
        throw new RuntimeException("Ocurrio un error" + responseCode);
        } else {
            StringBuilder informationString = new StringBuilder();
            Scanner scanner = new Scanner(url.openStream());
            
            while(scanner.hasNext()) {
                informationString.append(scanner.nextLine());
                
            }
            
            scanner.close();
            
            System.out.println(informationString);
        }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        // abrir un escaner que lea el flujo de datos 
        
        // pintar la informacion obtenida por consola
       
        
    }
}
