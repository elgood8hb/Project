/*
 * IST 411 Group Project 1
 * File: UserInterface.java
 * Description: This class promts the user for input
 * to create an sql query in a simplified form.
 * It then instantiates the client server and sends the
 * simplified user input string to it via the constructor.
 *
 * @author: Kevin Hansen
 * @version 2.0 4/30/19
 */


package userinterface;
import java.util.Scanner;
import java.net.*;
import java.io.*;

public class UserInterface  extends ClientServer {
    private Socket socket;
    
    /**
     * method to display prompts to the user in order to
     * obtain a simplified query string.
     * @param args 
     */
    public static void main (String args[]) 
    {
        
        String str = "";
        
        Scanner sc = new Scanner(System.in);
        System.out.println("press 1 for motherboards;  press 2 for processors");
        str = str + sc.nextLine();
        System.out.println("press 1 for read;  press 2 for write");
        str = str + sc.nextLine();
        
        // motherboards
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
        
        if (str.equals("12")) {
            System.out.println("enter your items to write into the table. productID, brand, product name, price, chip");
            System.out.println("ex: 1119, 'asus', 'asus rog dominus extreme', 899.99, 'amd'");
            str = str + sc.nextLine(); 
    }
    // processors
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
        
        if (str.equals("22")) {
            System.out.println("enter your items to write into the table. chipID, chip brand, chip name, price, chip core");
            System.out.println("ex: 2229, 'intel', 'Intel Core i7-8700K Coffee Lake', 899.99, '8-core 3.7 GHz'");
            str = str + sc.nextLine(); 
        }
        
        Client cl = new Client("localhost", 10001, str);
        cl.run();
    }
    
    /**
     *  Method to display output to the user
     * @param servStr -- String that holds the database query results
     */
    public void returnStatement(String servStr)
    {
        System.out.println(servStr);
        
    }
    
}
