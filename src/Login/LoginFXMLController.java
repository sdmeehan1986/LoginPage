/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

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
        System.out.println(username.getText());
        System.out.println(password.getText());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
