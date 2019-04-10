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
