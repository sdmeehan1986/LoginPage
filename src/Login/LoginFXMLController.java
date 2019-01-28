/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Database.Login;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author stefan meehan
 * @version 1.0
 */
public class LoginFXMLController implements Initializable {
    
    @FXML 
    private Label invalid;
    @FXML 
    private TextField username;
    @FXML 
    private PasswordField password;
    
    /**
     * System exit called on cancel button
     */
    @FXML
    public void cancelBTN()
    {
        System.exit(0);
    }
    
    /**
     * Sign in button 
     */
    @FXML
    public void signInBTN()
    {
        Login log = new Login();
        String[] user = log.checkUser(username.getText(), password.getText());
        
        if(user[0].equals("Valid"))
        {
            System.out.println("Valid user");
        }
        else if(user[0].equals("Invalid password"))
        {
            System.out.println("Invalid Password");
        }
        else if(user[0].equals("Invalid Username"))
        {
            System.out.println("Invalid Username");
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
