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
import Warning.ErrorDialog;

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
        
        switch (user[0]) {
            case "Valid":
                MainFXMLController main = new MainFXMLController();
                Stage stage = (Stage) invalid.getScene().getWindow();
                try {
                    main.startMain(user[1], user[2]);
                    stage.close();
                } catch (Exception ex) {
                    String head = "An error has occurred loggin in!";
                    String type = "Unable to start main application.";
                    ErrorDialog warn = new ErrorDialog(head, type,  ex);
                    warn.warning();
                }   break;
            case "Invalid password":
                invalid.setText("Invalid Password");
                break;
            case "Invalid Username":
                invalid.setText("Invalid User Name");
                break;
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
