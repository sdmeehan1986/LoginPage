/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Encryption;

/**
 *
 * @author stefan meehan
 * @version 1.0
 */
public class Hash {
    
    /**
     * Zero argument constructor
     */
    public Hash()
    {
        
    }
    
    /**
     * Creates a password hash from a string
     * @param password
     * @return Hashed password as a string
     */
    public String passwordHash(String password)
    {
        String encrypted = BCrypt.hashpw(password, BCrypt.gensalt(12));
        
        return encrypted;
    }
    
    /**
     * Check password's match
     * @param password
     * @param hash
     * @return 
     */
    public boolean checkPassword(String password, String hash)
    {
        boolean match = BCrypt.checkpw(password, hash);
        
        return match;
    }
    
}
