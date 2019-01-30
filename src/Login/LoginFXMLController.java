/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Database.Login;
import Main.MainFXMLController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

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
     * Call cancelBTN on enter key pressed
     * @param event 
     */
    @FXML 
    public void cancelKeyPressed(KeyEvent event)
    {
         if (event.getCode().equals(KeyCode.ENTER))
            {
                cancelBTN();
            }
    }
    
    /**
     * Call signInBTN on enter key pressed
     * @param event 
     */
    @FXML 
    public void signInKeyPressed(KeyEvent event)
    {
         if (event.getCode().equals(KeyCode.ENTER))
            {
                signInBTN();
            }
    }
    
    /**
     * System exit called on cancel button
     */
    @FXML
    public void cancelBTN()
    {
        System.exit(0);
    }
    
    /**
     * Sign in button to check if username and password
     * is valid and signs in, else updates label to 
     * inform user of error
     */
    @FXML
    public void signInBTN()
    {
        if(!(invalid.getText().equals("")))
        {
            invalid.setText("");
        }
        
        Login log = new Login();
        String[] user = log.checkUser(username.getText(), password.getText());
        
        if(user[0].equals("Valid"))
        {
            MainFXMLController main = new MainFXMLController();
            Stage stage = (Stage) invalid.getScene().getWindow();
            try {
                main.startMain(user[1], user[2]);
                stage.close();
            } catch (Exception ex) {
                System.out.println("System error");
            }
        }
        else if(user[0].equals("Invalid password"))
        {
            invalid.setText("Invalid Password");
        }
        else if(user[0].equals("Invalid Username"))
        {
            invalid.setText("Invalid User Name");
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
