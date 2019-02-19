package userinterface;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package databaseTest;
 
public class QueryClass {
    private String tabStr;
    //private ServerSocket port;
    //private Socket socket;
    
    public void changeQuery(String str)
    {   
        if (str.toLowerCase().contains("read")) {
            if (str.toLowerCase().contains("all")) {
                str = str.toLowerCase().replace("read ", "").replace("all", "");
	        str = ("SELECT * FROM " + str.toUpperCase());
                System.out.println(str.toUpperCase());
	      }
              else if (str.toLowerCase().contains("motherboard")) {
                 str = str.toLowerCase().replace("read ", "").replace("motherboard ", "");
                 str = ("SELECT * FROM CUSTOMER WHERE PRODUCTID=" + str);
                 System.out.println(str);
	       }
	       else if (str.toLowerCase().contains("processor")) {
                 str = str.toLowerCase().replace("read ", "").replace("processor ", "");
                 str = ("SELECT * FROM EMPLOYEE WHERE CHIPID=" + str);
                 System.out.println(str);
	       }
          }
       
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
        dbs.connectDb(str);
    }
}
