/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Encryption.Hash;

/**
 *
 * @author stefan meehan
 */
public class Login extends DatabaseMain{
    
    private final static String HOST = "jdbc:derby:LoginUsers";
    private final static String UNAME = "LoginFX";
    private final static String PWORD = "LoginFX";
    
    /**
     * Constructor to setup connection details to login database
     */
    public Login()
    {
        super(HOST, UNAME, PWORD);
    }
    
    /**
     * Checks username and password against database
     * @param userName
     * @param password
     * @return String array for valid/invalid user
     */
    public String[] checkUser(String userName, String password)
    {
        String[] auth = new String[3];
        String sql = "SELECT * FROM UserLogin WHERE USERID = " + "'" + userName + "'";
        
        String[] user = resultSet(sql);
        
        if(!(user[0].equals("Error")))
        {
            Hash hash = new Hash();
            
            boolean match = hash.checkPassword(password, user[1]);

            if(match)
            {
                auth[0] = "Valid";
                auth[1] = user[2];
                auth[2] = user[4];
                return auth;
            }
            else
            {
                auth[0] = "Invalid password";
                return auth;
            }
            
        }
        else
        {
            auth[0] = "Invalid Username";
            return auth;
        }
    }
    
}
