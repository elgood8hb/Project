/*
 * IST 411 Group Project 1
 * File: SocketServer.java
 * Description: This class connects the client
 * to the database. It reads a string from the
 * socket and sends it to QueryClass for restructuring
 * into an sql query.
 *
 * @author: Kevin Hansen
 * @version 2.0 4/30/19
 */
package userinterface;
import java.net.*;
import java.io.*;

public class SocketServer extends ClientServer {

    private ServerSocket port;
    private Socket socket;
    /**
     * SocketServer() constructor creates a server object given
     *  it port number and a number representing the number of
     *  clients it can backlog.
     * @param portNum -- an int giving the port number
     * @param nBacklog -- the number of clients that can backlog
     */    
    public SocketServer(int portNum, int nBacklog)  {
        try {
            port = new ServerSocket (portNum, nBacklog);
        } catch (IOException e) {
            e.printStackTrace();
        }     
    } 
 
    /**
     *  run() defines the server thread's main behavior which is
     *   simply to provide service whenever it is requested by a client. 
     *   Since an I/O exception may result, it is handled here. The
     *   server repeatedly accepts a connection from a client and
     *   provides it whatever service is defined in provideService().
     */
    
    public void run() {
        try {
            System.out.println("Socket server at ServerSockets "
                               + InetAddress.getLocalHost() + " waiting for connections ");
            while(true) {
                socket = port.accept();
                System.out.println("Accepted a connection from " + socket.getInetAddress());
                provideService(socket);
                socket.close();
                System.out.println("Closed the connection\n");
            }
        } catch (IOException e) {
             e.printStackTrace();
        }
    } // run() 

    /**
     *  provideService() defines this server's service, which consists
     *   of simply echoing whatever string it receives from the client.
     *  The server's protocol calls for it to begin by saying hello
     *  and end by saying goodbye. Isn't it polite?
     *  @param socket -- The socket used for reading/writhing
     */

    protected void provideService (Socket socket) {
        String str="";
        QueryClass qc = new QueryClass();
        try {
            writeToSocket(socket, "Hello. You are connected to2 " + socket.getLocalPort() + "\n"); //change to display port number 11001
            do {     
                str = readFromSocket(socket);

                if (str.toLowerCase().equals("goodbye"))
                    writeToSocket(socket, "Goodbye\n");
                else
                    qc.changeQuery(str, socket, this);
                    writeToSocket( socket, "goodbye");

            }  while (!str.contains("goodbye"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // provideService() 
    
    /**
     * Reads the result from the database query and sends it
     * UserInterface for display to user.
     * @param socket -- The socket to read the output from
     * @param resultString -- the String that stores the output
     */
    protected void sendResult (Socket socket, String resultString) {
        try {
            writeToSocket(socket, resultString);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }// try/catch
    }// sendResult 
} // EchoServer
