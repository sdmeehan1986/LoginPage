/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

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
    private Connection con;
    private Statement state;
    private ResultSet rs;
    
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
            con = DriverManager.getConnection(host, uName, pWord);
            state = con.createStatement();
        } catch (SQLException ex) {
            System.out.println("Sytem error with connection");
        }
        
    }
    
    public String[] resultSet(String aSQL)
    {
        String[] user = new String[4];
        
        try {
            rs = state.executeQuery( aSQL );
            rs.next( );
            
            String userID = rs.getString("USERID");
            String password = rs.getString("PASSWORD");
            String firstName = rs.getString("FIRSTNAME");
            String lastName = rs.getString("LASTNAME");
            
            user[0] = userID;
            user[1] = password;
            user[2] = firstName;
            user[3] = lastName;
            
        } catch (SQLException ex) {
            System.out.println("System Error with SQL");
            user[0] = "Error";
            
        }
        
        return user;
    }
    
    
}
