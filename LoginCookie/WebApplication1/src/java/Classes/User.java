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
    
   public String username;
   public String password;
    
    
    public User (String Username, String Password)
    {
        this.username = Username;
        this.password = Password;
        
    }
    
    
    public boolean Compare(User u)
    {
        if(this.username.equals( u.username) && this.password.equals(u.password))
            return true;
        else
        return false;
        
    }
    
   
 
    
            
    
    
}
