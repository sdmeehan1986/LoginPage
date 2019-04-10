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
