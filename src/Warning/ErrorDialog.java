/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Warning;

import java.io.PrintWriter;
import java.io.StringWriter;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

/**
 *
 * @author stefan meehan
 */
public class ErrorDialog {
    
    private String headerText;
    private String content;
    private String contentHeader;
    
    public ErrorDialog(String aHeader, String contentHead, Exception anEx)
    {
        headerText = aHeader;
        contentHeader = contentHead;
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        anEx.printStackTrace(pw);
        content = sw.toString();
    }
    
        public void warning()
    {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Stocker 2.0 - Warning");
        alert.setHeaderText(headerText);
        alert.setContentText(contentHeader);
        
        TextArea textArea = new TextArea(content);
        textArea.setEditable(false);
        textArea.setWrapText(true);
        
        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        
        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(textArea, 0, 0);
        
        alert.getDialogPane().setExpandableContent(expContent);

        alert.showAndWait();
    }
    
}
