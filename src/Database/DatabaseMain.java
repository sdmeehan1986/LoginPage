/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Warning.ErrorDialog;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author stefan meehan
 * @version 1.0
 */
public class DatabaseMain {
    // Instance variables
    private String host;
    private String uName;
    private String pWord;
    private ResultSet rs;
    private Connection con;
    private Statement state;
    
    /**
     * Constructor to create database connection variables
     * @param aHost
     * @param aUName
     * @param aPWord 
     */
    public DatabaseMain(String aHost, String aUName, String aPWord)
    {
        host = aHost;
        uName = aUName;
        pWord = aPWord;
        rs = null;
        
        try {
            // Cereate connection 
            con = DriverManager.getConnection(host, uName, pWord);
            state = con.createStatement();

        } catch (SQLException ex) {
            String head = "An error has occurred connecting to the database!";
            String type = "Unable to start database connection.";
            ErrorDialog warn = new ErrorDialog(head, type,  ex);
            warn.warning();
        }
        
    }
    
    public String[] resultSet(String aSQL)
    {
        String[] user = new String[5];
        
        
        try {
            
            rs = state.executeQuery(aSQL);
            
            rs.next( );
            
            String userID = rs.getString("USERID");
            String password = rs.getString("PASSWORD");
            String firstName = rs.getString("FIRSTNAME");
            String lastName = rs.getString("LASTNAME");
            boolean admin = rs.getBoolean("Admin");
            String isAdmin = "false";
            
            if(admin)
            {
                isAdmin = "true";
            }
            user[0] = userID;
            user[1] = password;
            user[2] = firstName;
            user[3] = lastName;
            user[4] = isAdmin;
            
        } catch (SQLException ex) {
            String head = "An error has occurred getting data from the database!";
            String type = "Unable to run SQL command.";
            ErrorDialog warn = new ErrorDialog(head, type,  ex);
            warn.warning();
            user[0] = "Error";
            
        }
        
        return user;
    }
    
    
}
