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
package Main;

import Warning.ErrorDialog;
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
    private static boolean isAdmin;
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
            String head = "An error has occurred loggin in!";
            String type = "Unable to start main application.";
            ErrorDialog warn = new ErrorDialog(head, type,  ex);
            warn.warning();
        }   

        isAdmin = admin.equals("true");
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
        setLabel();
    }    
    
}
