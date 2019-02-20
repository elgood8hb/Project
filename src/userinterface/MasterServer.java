
package userinterface;
//Steve Hansen here.  When creating a new SocketServer, 
//I think we need to pass its reference to the ResultSetProcessing class so that it has
//something to return output to. I think. Maybe I'm just lit. If you think of a 
// better way, I'm all for it. 

package ClientServer;

import java.net.*;
import java.io.*;
/**
 *
 * @author gkemp
 */


public class MasterServer extends ClientServer {
    
   
    
        
    public MasterServer(int portNum, int nBacklog)  {
        
        clientPortNumber = socket.getPort();
        
        try {
            
        } catch (IOException e) {
            
        }     
    } 
 
    
    public void run() {
        try {
            
            while(true) {
                
                  
                
            }
        } catch (IOException e) {
            
        }
    } // run()


     
    public static void main(String args[]) {
        
    } // main()
} // MasterServer

