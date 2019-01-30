/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author stefan meehan
 * @version 1.0
 */
public class MainFXMLController implements Initializable {
    
    private static String user;
    private boolean isAdmin;
    @FXML
    private Label welcome;
    
    /**
     * Starts the main app and assigns username and admin variables
     * @param uName
     * @param admin 
     */
    public void startMain(String uName, String admin)
    {        
        String[] parts = uName.split(" ", 2);
        user = parts[0];
        
        Main main = new Main();
        try {
            main.start(new Stage());
        } catch (Exception ex) {
            System.out.println("Error starting main");
        }   

        if(admin.equals("true"))
        {
            isAdmin = true;
        }
        else
        {
            isAdmin = false;
        }
    }
    
    /**
     * Sets the welcome message with the users name
     */
    public void setLabel()
    {
        welcome.setText("Welcome " + user);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println(user);
        setLabel();
    }    
    
}
