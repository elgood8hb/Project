/*
 * IST 411 Group Project 1
 * File: Client.java
 * Description: This class connects the client
 * to the MasterServer and then to the SocketServer.
 * It is responsible for reading and writing Strings
 * to and from the socket.
 *
 * @author: Kevin Hansen, Gerald Kemper
 * @version 2.0 4/30/19
 */

package userinterface;
import java.net.*;
import java.io.*;


public class Client extends ClientServer {

     protected static Socket socket;
     private static int newPort = 11000;
     private String userStr;

     /**
      *   Client() constructor creates a client object
      *   given the URL and port number of a server that this
      *   client will connect to
      *  @param url -- a String giving the server's URL
      *  @param port -- an int giving the server's port number
      */
     public Client(String url, int port, String userSt) {
         try {
             userStr = userSt;
             socket = new Socket(url, port);
             newPort = Integer.parseInt(readFromSocket(socket));
             socket = new Socket(url, newPort);
             System.out.println("CLIENT: connected to " + url + ":" + port 
                     + " port: " + socket.getLocalPort());
             newPort = newPort + 1;
             
             
         } catch (Exception e) {
             e.printStackTrace();
             System.exit(1);
         }
     } // EchoClient()

     /**
      *  run() defines the client thread's main behavior which is
      *   simply to request service from its server. Since an I/O
      *   exception may result, it is handled here.
      */
     public void run() {
         try {
             requestService(socket, userStr);  
             socket.close();
             System.out.println("CLIENT: connection closed");
             
         } catch (IOException e) { 
             System.out.println(e.getMessage());
             e.printStackTrace(); 
         }
         
     } // run()

    /**
     *  requestService() implements the details of the service
     *   request. In this case it accepts an input string from
     *   the UserInterface and passes it along to the SocketServer. The protocol
     *   with the server requires that the server say "Hello" first.
     *  @param socket -- the Socket connection to the server
     *  @param userStr -- string to hold the database inputs/outputs
     */
    protected void requestService(Socket socket, String userStr) throws IOException {  
        String servStr = readFromSocket(socket);          // Check for "Hello"
        System.out.println("SERVER: " + servStr);         // Report the server's response
        UserInterface ui = new UserInterface();
        if (servStr.substring(0,5).equals("Hello")) {
            do {
                writeToSocket(socket, userStr);          // Send it to server
                servStr = readFromSocket(socket);               // Read the server's response 
                ui.returnStatement(servStr);
            } while (!servStr.toLowerCase().contains("goodbye")); // Until user says 'goodbye'
        }
        
    } // requestService()
   
    /**
     * main() creates a client object given the URL and port number
     * of the Client server.
     * @param args
     * @param userStr 
     */
    public static void main (String args[], String userStr) {
        Client client = new Client("localhost", 10001, userStr);
        client.start();
    } // main() 
} // Client
