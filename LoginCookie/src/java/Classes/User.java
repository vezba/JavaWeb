/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Aleksa Kuzman
 */
public class User {

 String username;
 String password;

    public User(String username, String password) {
        
        this.username = username;
        this.password = password;
        
    }

    User() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return username + password;

    }
    
    
    
    
    
    
    
    
}
