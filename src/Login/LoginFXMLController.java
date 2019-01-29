/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Database.Login;
import Main.Main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
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
    @FXML
    private AnchorPane ap;
    
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
        if(!(invalid.getText().equals("")))
        {
            invalid.setText("");
        }
        
        Login log = new Login();
        String[] user = log.checkUser(username.getText(), password.getText());
        
        if(user[0].equals("Valid"))
        {
            System.out.println("Valid user");
            Main main = new Main();
            Stage stage = (Stage) invalid.getScene().getWindow();
            try {
                main.start(new Stage());
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
