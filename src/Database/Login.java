/*
 * Copyright (C) 2019 Stefan.Meehan
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
