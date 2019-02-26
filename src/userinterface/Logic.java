/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

/**
 *
 * @author elgoo
 */

import java.net.*;
import java.io.*;

public class Logic extends ClientServer{
    
   private char s;
   private char c; 
   private String request;
   private String userStr;
   private String create;
   private String delete;
   private String add;
   private String view;
   private int num;
   
   
   public void requestService(Socket socket) throws IOException{
       String servStr = readFromSocket(socket);
       UserInterface intFace = new UserInterface();
       intFace.setData(s,servStr);
       if (servStr.substring(0,5).equals("Hello")){
           userStr = " ";
           
           do{
               userStr = readFromKeyboard();
               num = Integer.parseInt(userStr);
               
               if (num == 1){
               //create whatever 1 is;
               request = create;
               }
               
               else if (num == 2){
               //whatever 2 is;
               request = delete;
               }
               
               /*continues with requests for different numbers*/
           
           } while (!userStr.toLowerCase().equals("goodbye"));
           }
           
           }
   
      protected String readFromKeyboard( ) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("INPUT: ");
        String line = input.readLine();
        return line;
    } // readFromKeyboard()

    
}
