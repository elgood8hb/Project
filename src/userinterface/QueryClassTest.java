/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;
import java.util.Scanner;
import java.net.*;
import java.io.*;


/**
 *
 * @author Laptop
 */
public class QueryClassTest  extends ClientServer {
    private Socket socket;
    
    public static void main (String args[]) 
    {
        
        String str = "";
        //Client cl = new Client("localhost", 10001, str);
        //cl.run();
        Scanner sc = new Scanner(System.in);
        System.out.println("press 1 for motherboards;  press 2 for processors");
        str = str + sc.nextLine();
        System.out.println("press 1 for read;  press 2 for write");
        str = str + sc.nextLine();
        
        if (str.equals("11")) {
           System.out.println("enter digit to define your search");
           System.out.println("0 - all; 1 - product number; 2 - brand; 3 - chip; 4 - price; 5 - brand and chip (ex: asus intel)");
           str = str + sc.nextLine();
        }
        if (str.equals("111")) {
            System.out.println("enter the product number. ex: 1119");
            str = str + sc.nextLine();
        }
        if (str.equals("112")) {
            System.out.println("enter the brand. ex: ASRock or Gigabyte or Intel or MSI");
            str = str + sc.nextLine();
        }
        if (str.equals("113")){
            System.out.println("enter the chip. ex: AMD or Intel");
            str = str + sc.nextLine();
        }
        if (str.equals("114")) {
            System.out.println("enter the price range, include over or under. ex: for all boards under $500 type \"under 500.00\"");
            str = str + sc.nextLine();
        }
        if (str.equals("115")) {
            System.out.println("enter brand and chip. ex: asus intel");
            str = str + sc.nextLine();
        }
        if (str.equals("12")) {
            System.out.println("enter your items to write into the table. productID, brand, product name, price, chip");
            System.out.println("ex: 1119, asus, asus rog dominus extreme, 899.99, amd");
            str = str + sc.nextLine(); 
    }
    //////////////////////////////////////////////////////////////
    if (str.equals("21")) {
           System.out.println("enter digit to define your search");
           System.out.println("0 - all; 1 - product number; 2 - chip brand; 3 - chip name; 4 - price; 5 - core (ex: 8-core)");
           str = str + sc.nextLine();
        }
        if (str.equals("211")) {
            System.out.println("enter the product number. ex: 2229");
            str = str + sc.nextLine();
        }
        if (str.equals("212")) {
            System.out.println("enter the brand. ex: AMD or Intel");
            str = str + sc.nextLine();
        }
        if (str.equals("213")){
            System.out.println("enter the chip name. ex: Intel Core i7-8700K Coffee Lake");
            str = str + sc.nextLine();
        }
        if (str.equals("214")) {
            System.out.println("enter the price range, include over or under. ex: for all chips under $500 type \"under 500.00\"");
            str = str + sc.nextLine();
        }
        if (str.equals("215")) {
            System.out.println("enter chip core. ex: 6-core");
            str = str + sc.nextLine();
        }
        if (str.equals("22")) {
            System.out.println("enter your items to write into the table. chipID, chip brand, chip name, price, chip core");
            System.out.println("ex: 2229, intel, Intel Core i7-8700K Coffee Lake, 899.99, 8-core 3.7 GHz");
            str = str + sc.nextLine(); 
        }
        
        Client cl = new Client("localhost", 10001, str);
        cl.run();
    }
    public void returnStatement(String servStr)
    {
        System.out.println(servStr);
        
    }
    
}
