/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeoncrawler;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author To
 */
public class FXMLDocumentController implements Initializable {
    
    
    
    @FXML
    private Label label;
    
    @FXML
    private TextArea text_box;
    @FXML
    private Button button1;
    
    private GameHandler gameHandler;
    
    @FXML
    private void moveUp(ActionEvent event) {
        
        gameHandler.movePlayer("up");
        
        
    }
    
    @FXML
    private void moveDown(ActionEvent event) {
        
        gameHandler.movePlayer("down");
        
        
    }
    
    @FXML
    private void moveRight(ActionEvent event) {
        
        gameHandler.movePlayer("right");
        
        
    }
    
    @FXML
    private void moveLeft(ActionEvent event) {
        
        gameHandler.movePlayer("left");
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        text_box.setText("Welcome");
        
        gameHandler = new GameHandler(text_box);
        gameHandler.start();
        
    }    
    
    
    
}
