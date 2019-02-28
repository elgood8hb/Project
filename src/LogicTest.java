/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;


/**
 *
 * @author Laptop
 */
public class LogicTest {
    private static int y = 0;
    public static void main (String args[]) 
    {
        // Example 1
        String str = "2229|intel|Intel Core i7-8700K Coffee Lake|899.99|8-core 3.7 GHz|"; // Example of how string will come from socket
        str = str.substring(0, str.length() -1); // remove the last "|" from the end of the string
        String[] strArray = str.split("\\|"); // split the string into substrings at every "|" and place into an array
        for (int i = 0;i<strArray.length;i++)
        {
            System.out.println(strArray[i]); 
        }
        
        /* Example 2 When dealing with multiple values returned
         * remember, there are always 5 columns, so in the array
         * 0 and 5 will always be the item id, 1 and 6 will always be the brand etc...
         * this example also formats the results into the user interface
         */
        String str2 = "2229|intel|Intel Core i7-8700K Coffee Lake|899.99|8-core 3.7 GHz|2230|msi|AMD RYZEN 7 2700X|758.99|6-Core 3.6 GHz|";
        str2 = str2.substring(0, str2.length() -1); 
        String[] strArray2 = str2.split("\\|");
        int x;
        
        String[] items = {"ProductID:    |", "Brand:        |", "Product Name: |", "Price:        |", "Chip:         |"};
        
        for (int i = 0;i<5;i++) //results will always be multiples of 5 so i<5 will always work
        {
            String test1 = strArray2[i] + " | ";
            x = items[i].length() + test1.length();
            if (x > y) {
                y = x;
            }
            }

        if (str2.startsWith("1")) {
            System.out.println(String.format("%1$" + (y+6) + "s", "Motherboards"));
        }
        if (str2.startsWith("2")) {
            System.out.println(String.format("%1$" + (y+3) + "s", "Chips"));
        }
        System.out.println(String.format("%1$" + y + "s", "--------------------------------------------------------------------"));
        for (int i = 0;i<strArray2.length/2;i++)
        {
            String test1 = String.format("%1$" + (y-items[i].length()) + "s", strArray2[i]) + " | ";
            System.out.println(items[i] + test1 + strArray2[i+5]);
        }
    }
}
