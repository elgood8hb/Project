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
public class UserInterface {
private char c;
private char s;
public void SetData(char fromWho, String stuff){
    if (fromWho == c){
    System.out.println("Client: " + stuff);
}
    else {
     System.out.println("Server: " + stuff);
    }
    }

public void Options (String what){
    if (what == "read"){
        System.out.println("what do you want to read??? motherboard or processor");
    }
    else if (what == "write"){
        System.out.println("what do you want to write??? customer or client");
    }
}
}
