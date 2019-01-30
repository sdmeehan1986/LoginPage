/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 *
 * @author stefan meehan
 * @version 1.0
 */
public class MainFXMLController implements Initializable {
    
    private String user;
    private boolean isAdmin;
    
    /**
     * Starts the main app and assigns username and admin variables
     * @param uName
     * @param admin 
     */
    public void startMain(String uName, String admin)
    {
        Main main = new Main();
        try {
            main.start(new Stage());
        } catch (Exception ex) {
            System.out.println("Error starting main");
        }   
        
        String[] parts = uName.split(" ", 2);
        user = parts[0];
        if(admin.equals("true"))
        {
            isAdmin = true;
        }
        else
        {
            isAdmin = false;
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
