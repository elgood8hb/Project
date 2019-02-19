/*
 * IST 411 Program #4
 * File: ExecuteExample.java
 * Description: Program to populate the columns 
 * in the table SALESHISTORY4 with values
 *
 * @author Bill Cantor
 * Modified by: Kevin Hansen
 * @version 1.0 2/9/19
 */

package userinterface;
import java.util.*;
import java.io.*;
import java.sql.*;

/* Class ExecuteEample is loged into a database
* based on credentials stored in the file db.properties
* and writes values into the table SALESHISTORY4
*/
public class DatabaseSetup  
{
    public static void main (String args[]) 
    {
        String className=null;
        String url=null;
        String user = null;
        String password = null;
        
        try
        {
            ResourceBundle resources;
            InputStream in = null;
            ResourceBundle newResources;

            in = ClassLoader.getSystemResourceAsStream("db.properties");

            resources = new PropertyResourceBundle(in);

            in.close();

            className = resources.getString("jdbc.driver");
            url = resources.getString("jdbc.url");
            System.out.println(url);
            user = resources.getString("jdbc.user");
            password = resources.getString("jdbc.password");
        } // end try
        
        catch (Exception exp)
        {
            System.out.println("Couldn't load resources." + exp);
            System.exit(-1);
        } // end catch
        
        try
        {
            Class.forName(className);
        } // end try
        
        catch (Exception e) 
        {
            System.out.println("Failed to load  driver.");
            return;
        } // end catch
        
        try
        {
            Connection con = DriverManager.getConnection(url,user,password);   
              
            Statement stmt = con.createStatement();
            
            String tmpString;
            
            tmpString = ("CREATE TABLE motherboards" + 
                         "(ProductID int," +
                         "Brand varchar(255), " +
                         "ProdName varchar(255), " +
                         "Price double, " + 
                         "Chip varchar(255), " +
                         "primary key (ProductID))"); 
            
            stmt.execute(tmpString);
            
            
            System.out.println("Created Motherboards Table");
            String[] brand = {"Asus", "Gigabyte", "MSI", "ASRock", "Asus", "MSI", "Gigabyte", "ASRock"};
            String[] prod = {"ASUS ROG DOMINUS EXTREME", "GIGABYTE Z390 AORUS XTREME WATERFORCE LGA 1151 (300 Series)", "MSI MEG Z390 GODLIKE LGA 1151 (300 Series)", "ASRock Z390 Phantom Gaming 9 LGA 1151 (300 Series)", "ASUS ROG Zenith Extreme Alpha X399", "MSI MEG X399 CREATION sTR4", "GIGABYTE X399 AORUS Gaming 7 sTR4", "ASRock X399 Phantom Gaming 6 sTR4"};
            double[] price = {1799.99, 899.99, 566.34, 233.99, 649.99, 549.99, 369.99, 249.99};
            String[] chip = {"Intel", "Intel", "Intel", "AMD", "AMD", "AMD", "AMD", "AMD"};
            for (int i=0;i<brand.length;i++) {
                tmpString = ("INSERT INTO  MOTHERBOARDS (PRODUCTID, BRAND, PRODNAME, PRICE, CHIP)" +
                         "VALUES (" + (1111+i) + ", '" + brand[i] + "', '" + prod[i] + "', " + price[i] + ", '" + chip[i] + "')"); 
                stmt.execute(tmpString);
                        }; 
            System.out.println("Populated Motherboards table with data");
            
            tmpString = ("CREATE TABLE processors" + 
                         "(ChipID int," +
                         "ChipBrand varchar(255), " +
                         "ChipName varchar(255), " +
                         "ChipPrice double, " + 
                         "ChipCore varchar(255), " +
                         "primary key (ChipID))"); 
            
            stmt.execute(tmpString);
           
            System.out.println("Created Processor Table");
            String[] chipBrand = {"Intel", "AMD", "AMD", "Intel", "AMD", "Intel", "AMD", "Intel"};
            String[] chipName = {"Intel Core i7-8700K Coffee Lake", "AMD RYZEN 7 2700X", "AMD RYZEN 5 2600X", "Intel Core i7-8700 Coffee Lake", "AMD RYZEN 7 2700", "Intel Core i5-8400 Coffee Lake", "AMD RYZEN 5 2600", "Intel Core i3-8100"};
            double[] chipPrice = {379.99, 309.99, 199.99, 314.99, 259.99, 199.99, 164.99, 118.99};
            String[] chipSet = {"6-Core 3.7 GHz", "8-Core 3.7 GHz", "6-Core 3.6 GHz", "6-Core 3.2 GHz", "8-Core 3.2 GHz", "6-Core 2.8 GHz", "6-Core 3.4 GHz", "3.6 GHz LGA 1151"};
            for (int i=0;i<brand.length;i++) {
                tmpString = ("INSERT INTO PROCESSORS (CHIPID, CHIPBRAND, CHIPNAME, CHIPPRICE, CHIPCORE)" +
                         "VALUES (" + (2222+i) + ", '" + chipBrand[i] + "', '" + chipName[i] + "', " + chipPrice[i] + ", '" + chipSet[i] + "')"); 
                stmt.execute(tmpString);
                        }; 
            System.out.println("Populated Processor table with data");
            stmt.close();
        
            con.close();
        } // end try
        
        catch (Exception e) 
        {
            System.out.println(e);
        } // end catch
    } // end main
} // end ExecuteExample

