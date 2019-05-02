/*
 * IST 411 Group Project 1
 * File: QueryClass.java
 * Description: This class takes a string of user input
 * form UserInterface and restructures it into an sql
 * query based on the values of input.
 *
 * @author: Kevin Hansen
 * @version 2.0 4/30/19
 */


package userinterface;

import java.net.Socket;

 
public class QueryClass {
    private String tabStr;
    private int strLength;
    private Socket socket;
    
    /**
     * Method to read a string from the UserInterface input
     * and restructure it into an sql query.
     * @param str -- String to store the input and output queries
     * @param socket -- socket to read from
     * @param ss -- SocketServer object
     */
    public void changeQuery(String str, Socket socket, SocketServer ss)

    {   
        strLength = str.length();
        
        if (str.startsWith("1")) {
            str = str.substring(1);
            if (str.startsWith("1")) {
                str = str.substring(1);
                 
                if (str.startsWith("0")) {
                    str = ("SELECT * FROM MOTHERBOARDS");
                    DatabaseServer ds = new DatabaseServer();
                    ds.connectDb(str, socket, ss);
                }
                
                else if (str.startsWith("1")) {
                str = str.substring(1);
                str = ("SELECT * FROM MOTHERBOARDS WHERE PRODUCTID = " + str);
                DatabaseServer ds = new DatabaseServer();
                ds.connectDb(str, socket, ss);
                }
                
                else if (str.startsWith("2")) {
                str = str.substring(1);
                str = ("SELECT * FROM MOTHERBOARDS WHERE BRAND = '" + str + "'");
                DatabaseServer ds = new DatabaseServer();
                ds.connectDb(str, socket, ss);
                }
                
                else if (str.startsWith("3")) {
                str = str.substring(1);
                str = ("SELECT * FROM MOTHERBOARDS WHERE CHIP = '" + str + "'");
                DatabaseServer ds = new DatabaseServer();
                ds.connectDb(str, socket, ss);
                }
                
                else if (str.startsWith("4")) {
                str = str.substring(1);
                if (str.toLowerCase().contains("over")) {
                    str = str.replace("over ", "> ");
                }
                if (str.toLowerCase().contains("under")) {
                    str = str.replace("under ", "< ");
                }
                str = ("SELECT * FROM MOTHERBOARDS WHERE PRICE " + str);
                DatabaseServer ds = new DatabaseServer();
                ds.connectDb(str, socket, ss);
                }
                
            }
            else if (str.startsWith("2")) {
                str = str.substring(1);
                str = ("INSERT INTO MOTHERBOARDS (PRODUCTID, BRAND, PRODNAME, PRICE, CHIP)" +
                       " VALUES (" + str.toUpperCase() + ")");
                DatabaseServer ds = new DatabaseServer();
                ds.connectDb(str, socket, ss);
            }
            
        }
        if (str.startsWith("2")) {
            str = str.substring(1);

            if (str.startsWith("1")) {
                str = str.substring(1);

                if (str.startsWith("0")) {
                    str = ("SELECT * FROM PROCESSORS");
                    DatabaseServer ds = new DatabaseServer();
                    ds.connectDb(str, socket, ss);
                }
                
                else if (str.startsWith("1")) {
                str = str.substring(1);
                str = ("SELECT * FROM PROCESSORS WHERE CHIPID = " + str);
                DatabaseServer ds = new DatabaseServer();
                ds.connectDb(str, socket, ss);
                }
                
                else if (str.startsWith("2")) {
                str = str.substring(1);
                str = ("SELECT * FROM PROCESSORS WHERE CHIPBRAND = '" + str + "'");
                DatabaseServer ds = new DatabaseServer();
                ds.connectDb(str, socket, ss);
                }
                
                else if (str.startsWith("3")) {
                str = str.substring(1);
                str = ("SELECT * FROM PROCESSORS WHERE CHIPNAME = '" + str + "'");
                DatabaseServer ds = new DatabaseServer();
                ds.connectDb(str, socket, ss);
                }
                
                else if (str.startsWith("4")) {
                str = str.substring(1);
                if (str.toLowerCase().contains("over")) {
                    str = str.replace("over ", "> ");
                }
                if (str.toLowerCase().contains("under")) {
                    str = str.replace("under ", "< ");
                }
                str = ("SELECT * FROM PROCESSORS WHERE CHIPPRICE " + str);
                DatabaseServer ds = new DatabaseServer();
                ds.connectDb(str, socket, ss);
                }
                
            }
            else if (str.startsWith("2")) {
                str = str.substring(1);
                str = ("INSERT INTO PROCESSORS (CHIPID, CHIPBRAND, CHIPNAME, CHIPPRICE, CHIPCORE)" +
                       " VALUES (" + str.toUpperCase() + ")");
                DatabaseServer ds = new DatabaseServer();
                ds.connectDb(str, socket, ss);
            }    
            
        }
       
    } 
}
