/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import java.net.Socket;
import java.sql.*;

public class ResultSetProcessing {

    public ResultSetProcessing(ResultSet rs, String query, Socket socket, SocketServer ss) {
    //public ResultSetProcessing(ResultSet rs, String query) {

        if (query.toUpperCase().startsWith("SELECT")) {
          //  format(rs, socket, ss);
          format(rs);
        } else {
          //  ss.sendResult(socket, "Data insertion successful.");
        }

    }

    //public void format(ResultSet rs, Socket socket, SocketServer ss) {
    public void format(ResultSet rs){
        try {

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            for (int x = 1; x <= columnCount; x++) {
                String columnName = rsmd.getColumnName(x);

            }

            while (rs.next()) {
                for (int x = 1; x <= columnCount; x++) {
                    String resultStr = rs.getString(x);
                     System.out.println(resultStr);
                    //ss.sendResult(socket, resultStr + "\t");

                }
                System.out.println("");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
