/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import java.util.*;
import java.io.*;
import java.net.Socket;
import java.sql.*;

public class DatabaseServer {

    String className = null;
    String url = null;
    String user = null;
    String password = null;
    ResultSet rs;

    public void connectDb(String queryString, Socket socket, SocketServer ss) {
        try {
            UserInterface ui = new UserInterface();
            ui.returnStatement("DatabaseServer: " + queryString);
            ResourceBundle resources;
            InputStream in = null;
            ResourceBundle newResources;

            in = ClassLoader.getSystemResourceAsStream("db.properties");

            resources = new PropertyResourceBundle(in);

            in.close();

            className = resources.getString("jdbc.driver");
            url = resources.getString("jdbc.url");
            //System.out.println(url);
            user = resources.getString("jdbc.user");
            password = resources.getString("jdbc.password");
        } catch (Exception exp) {
            System.out.println("Couldn't load resources." + exp);
            System.exit(-1);
        }

        try {
            Class.forName(className);
        } catch (Exception e) {
            System.out.println("Failed to load  driver.");
            return;
        }

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
            if (!queryString.startsWith("S")) {
                stmt.execute(queryString);
                ResultSetProcessing rsp = new ResultSetProcessing(null, queryString, socket, ss);
            }
            else {
                rs = stmt.executeQuery(queryString); 
                ResultSetProcessing rsp = new ResultSetProcessing(rs, queryString, socket, ss);
            }
            
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
