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
     public Client(String url, int port, String userStr) {
         try {
             userStr = userStr;
             setStr(userStr);
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
             userStr = getStr();
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
     *   request. In this case it accepts a line of input from
     *   the user and passes it along to the server. The protocol
     *   with the server requires that the server say "Hello" first.
     *  @param socket -- the Socket connection to the server
     */
    protected void requestService(Socket socket, String userStr) throws IOException {  
        String servStr = readFromSocket(socket);          // Check for "Hello"
        System.out.println("SERVER: " + servStr);         // Report the server's response
        //Logic lg = new Logic();
        QueryClassTest qc = new QueryClassTest();
        if (servStr.substring(0,5).equals("Hello")) {
            //System.out.println("CLIENT: type a line or 'goodbye' to quit"); // Prompt the user
            //String userStr = "";
            do {
                userStr = userStr;                 
                writeToSocket(socket, userStr + "\n");          // Send it to server
                //writeToSocket(socket, "goodbye");
                servStr = readFromSocket(socket);               // Read the server's response       
                qc.returnStatement(servStr);
            } while (!userStr.toLowerCase().contains("goodbye")); // Until user says 'goodbye'
        }
        
    } // requestService()
    public void setStr(String str) {
        userStr = str;
    }
    public String getStr() {
        return userStr;
    }
   
    /**
     *  main() creates a client object given the URL and port number
     *   of the echo server
     */
    
    public static void main (String args[], String userStr) {
        Client client = new Client("localhost", 10001, userStr);
        client.start();
    } // main() 
} // Client
