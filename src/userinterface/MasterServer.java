/*
 * IST 411 Group Project 1
 * File: MasterServer.java
 * Description: This class accepts a connection from
 * a client and then redircts to SocketServer.
 *
 * @author: Kevin Hansen
 * @version 2.0 4/30/19
 */


package userinterface;
import java.net.*;
import java.io.*;

public class MasterServer extends ClientServer {

    private ServerSocket port;
    private Socket socket;
    private SocketServer ThreadedServer[] = new SocketServer[5];
    private int numberServer = 11000;
    private String stPort;
    private int i = 0;

    /**
     * MasterServer() constructor creates a server object given
     *  it port number and a number representing the number of
     *  clients it can backlog.
     * @param portNum -- an int giving the port number
     * @param nBacklog -- the number of clients that can backlog
     */    
    public MasterServer(int portNum, int nBacklog)  {
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
     *   server repeatedly accepts a connection from clients and
     *   directs them to a separate sever on different socket.
     */
    public void run() {
        try {
            System.out.println("MasterServer at " 
                               + InetAddress.getLocalHost() + " waiting for connections ");
            while(true) {
                socket = port.accept();
                System.out.println("Accepted a connection from " + socket.getInetAddress());
                numberServer++;
                stPort = Integer.toString(numberServer);

                ThreadedServer[i] = new SocketServer(numberServer, 5);
                ThreadedServer[i].start();
                writeToSocket(socket, stPort);
                i++;
                
                System.out.println("MasterServer: on port " + socket.getLocalPort() 
                        + " is sendig to port " + numberServer);
                System.out.println("Closed the connection\n");
                }

        } catch (IOException e) {
             e.printStackTrace();
        }
    } // run()

     /** 
      *  main() creates an EchoServerMaster at port 10001
      */
    public static void main(String args[]) {
        MasterServer master = new MasterServer(10001,5);
        master.start();
    } // main()
} // MasterServer
