/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ResultSetProcessing extends ClientServer {

    public ResultSetProcessing(Statement stmt, String query) {

        try {
            ResultSet rs = stmt.executeQuery(query);
            format(rs);
        } catch (SQLException ex) {
            Logger.getLogger(ResultSetProcessing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void format(ResultSet rs) {

        try {

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            for (int x = 1; x <= columnCount; x++) {
                String columnName = rsmd.getColumnName(x);

                //output to SocketServer
            }

            while (rs.next()) {
                for (int x = 1; x <= columnCount; x++) {
                    String resultStr = rs.getString(x);

                    //return resultStr + "\t";
                }
                System.out.println("");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
