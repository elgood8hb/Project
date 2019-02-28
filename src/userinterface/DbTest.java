/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;


public class DbTest {
    
    public static void main(String args[]){
       String query = "Select * from MOTHERBOARDS";
        DatabaseServer db = new DatabaseServer();
        db.connectDb(query);
    }
}
