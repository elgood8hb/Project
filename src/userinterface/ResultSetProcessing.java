/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import java.net.Socket;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ResultSetProcessing {

    public ResultSetProcessing(Statement stmt, String query, Socket socket, SocketServer ss) {

        try {
            ResultSet rs = stmt.executeQuery(query);
            format(rs, socket,ss);
        } catch (SQLException ex) {
            Logger.getLogger(ResultSetProcessing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void format(ResultSet rs, Socket socket, SocketServer ss) {

        try {

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            for (int x = 1; x <= columnCount; x++) {
                String columnName = rsmd.getColumnName(x);

                }

            while (rs.next()) {
                for (int x = 1; x <= columnCount; x++) {
                    String resultStr = rs.getString(x);
                    
                   ss.sendResult(socket, resultStr + "\t");
                    
                }
                System.out.println("");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
