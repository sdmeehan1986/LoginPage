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
    
    public String passwordHash(String password)
    {
        String encrypted = BCrypt.hashpw(password, BCrypt.gensalt(12));
        
        return encrypted;
    }
    
}
