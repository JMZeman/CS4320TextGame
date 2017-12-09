/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeoncrawler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Node;

/**
 *
 * @author To
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private AnchorPane dungeonPane;
     
    
    @FXML
    private Label label;
    
    @FXML
    private TextArea textBox;
    @FXML
    private Button button1;
    
    public Object test;
    
    private GameHandler gameHandler;
    
    private void loadBattlePane() throws IOException{
        if(gameHandler.player.currentRoom.type.equals("MONSTER")){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXMLBattleDocument.fxml"));
            AnchorPane pane = loader.load();
            FXMLBattleDocumentController battleController = loader.getController();
            battleController.transferGameHandler(gameHandler);
            dungeonPane.getChildren().setAll(pane);

        }
        if(gameHandler.player.currentRoom.type.equals("FINAL")){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXMLBattleDocument.fxml"));
            AnchorPane pane = loader.load();
            FXMLBattleDocumentController battleController = loader.getController();
            battleController.transferGameHandler(gameHandler);
            dungeonPane.getChildren().setAll(pane);

        }
    }
    
    @FXML
    private void moveUp(ActionEvent event) throws IOException {

        gameHandler.movePlayer("up");
        loadBattlePane();
        
        
    }
    
    @FXML
    private void moveDown(ActionEvent event) throws IOException {
        
        gameHandler.movePlayer("down");
        loadBattlePane();
        
    }
    
    @FXML
    private void moveRight(ActionEvent event) throws IOException {
        
        gameHandler.movePlayer("right");
        loadBattlePane();
        
        
    }
    
    @FXML
    private void moveLeft(ActionEvent event) throws IOException {
        
        gameHandler.movePlayer("left");
        loadBattlePane();
        
        
    }
    
    public void returnFromBattle(GameHandler gameHandler){
        this.gameHandler = gameHandler;
        gameHandler.player.currentRoom.type = "";
        gameHandler.ReturnFromBattleStart(textBox);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        textBox.setText("Welcome");
        
        gameHandler = new GameHandler(textBox);
        gameHandler.start();
        
    }    
    
    
    
}
