package userinterface;

import java.net.Socket;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package databaseTest;
 
public class QueryClass {
    private String tabStr;
    private int strLength;
    //private ServerSocket port;
    //private Socket socket;
    
    //public void changeQuery(String str, Socket socket, SocketServer ss)
    public void changeQuery(String str)

    {   
        strLength = str.length();
    
        if (str.startsWith("1")) {
            str = str.substring(1);
            if (str.startsWith("1")) {
                str = str.substring(1);
                 
                if (str.startsWith("0")) {
                    str = ("SELECT * FROM MOTHERBOARDS");
                    System.out.println(str);
                }
                
                else if (str.startsWith("1")) {
                str = str.substring(1);
                str = ("SELECT * FROM MOTHERBOARDS WHERE PRODUCTID=" + str);
                System.out.println(str);
                }
                
                else if (str.startsWith("2")) {
                str = str.substring(1);
                str = ("SELECT * FROM MOTHERBOARDS WHERE BRAND=" + str);
                System.out.println(str);
                }
                
                else if (str.startsWith("3")) {
                str = str.substring(1);
                str = ("SELECT * FROM MOTHERBOARDS WHERE CHIP=" + str);
                System.out.println(str);
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
                System.out.println(str);
                }
                
                else if (str.startsWith("5")) {
                str = str.substring(1);
                str = str.replace(" ", " AND CHIP=");
                str = ("SELECT * FROM MOTHERBOARDS WHERE BRAND=" + str);
                System.out.println(str);
                }
            }
            else if (str.startsWith("2")) {
                str = str.substring(1);
                str = str.substring(1);
                str = ("INSERT INTO MOTHERBOARDS (PRODUCTID, BRAND, PRODUCTNAME, PRICE, CHIP)" +
                       " VALUES (" + str.toUpperCase() + ")");
                System.out.println(str);
            }
        }
	if (str.startsWith("2")) {
            str = str.substring(1);
            if (str.startsWith("1")) {
                str = str.substring(1);
                 
                if (str.startsWith("0")) {
                    str = ("SELECT * FROM PROCESSORS");
                }
                
                else if (str.startsWith("1")) {
                str = str.substring(1);
                str = ("SELECT * FROM PROCESSORS WHERE CHIPID=" + str);
                System.out.println(str);
                }
                
                else if (str.startsWith("2")) {
                str = str.substring(1);
                str = ("SELECT * FROM PROCESSORS WHERE CHIPBRAND=" + str);
                System.out.println(str);
                }
                
                else if (str.startsWith("3")) {
                str = str.substring(1);
                str = ("SELECT * FROM PROCESSORS WHERE CHIPNAME=" + str);
                System.out.println(str);
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
                System.out.println(str);
                }
                
                else if (str.startsWith("5")) {
                str = str.substring(1);
                str = str.replace(" ", " AND CHIPCORE=");
                str = ("SELECT * FROM PROCESSORS WHERE CHIPBRAND=" + str);
                System.out.println(str);
                }
            }
            else if (str.startsWith("2")) {
                str = str.substring(1);
                str = str.substring(1);
                str = ("INSERT INTO PROCESSORS (CHIPID, CHIPBRAND, CHIPNAME, CHIPPRICE, CHIPCORE)" +
                       " VALUES (" + str.toUpperCase() + ")");
                System.out.println(str);
            }    
            
        }
       /*
        else if (str.toLowerCase().contains("write")) {
            if (str.toLowerCase().contains("customer")) {
                str = str.toLowerCase().replace("write ", "").replace("customer ", "");
	        str = ("INSERT INTO CUSTOMER (CUSTID, FIRSTNAME, LASTNAME)" +
                       " VALUES (" + str.toUpperCase() + ")");
                System.out.println(str);
                tabStr = "Customer";
	            }
                   else if (str.toLowerCase().contains("employee")) {
	              str = str.toLowerCase().replace("write ", "").replace("employee ", "");
	              str = ("INSERT INTO EMPLOYEE (EMPID, FIRSTNAME, LASTNAME) VALUES (" + str.toUpperCase() + ")");
                      tabStr = "Employee";
	            }
                   System.out.println("Table " + tabStr + " written to");
                   
                }
             else
             System.out.println(str + " is an invalid input\n");
        DatabaseServer dbs = new DatabaseServer();
        dbs.connectDb(str, socket,ss); */
    } 
}
