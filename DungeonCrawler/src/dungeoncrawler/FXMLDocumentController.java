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
    
    private void foundItem(){                                       //cheacks if better stats then equips it if it is
        if(gameHandler.player.currentRoom.type.equals("ITEM")){
        gameHandler.player.currentRoom.type = "";
            if(gameHandler.player.currentRoom.weapon != null && gameHandler.player.currentRoom.weapon.attack > gameHandler.player.weapon.attack){
                gameHandler.player.weapon = gameHandler.player.currentRoom.weapon;
                textBox.appendText("\n You found a better weapon and equiped it\n it has an attack of " + gameHandler.player.weapon.attack);
            }
            if(gameHandler.player.currentRoom.armor != null && gameHandler.player.currentRoom.armor.defense > gameHandler.player.armor.defense){
                gameHandler.player.armor = gameHandler.player.currentRoom.armor;
                textBox.appendText("\n\n You found better armor and equiped it\nIt has a defense of " + gameHandler.player.currentRoom.armor.defense);
            }
        gameHandler.player.currentRoom.type = "";
        }
    }
    
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
        foundItem();
        
    }
    
    @FXML
    private void moveDown(ActionEvent event) throws IOException {
        
        gameHandler.movePlayer("down");
        loadBattlePane();
        foundItem();
    }
    
    @FXML
    private void moveRight(ActionEvent event) throws IOException {
        
        gameHandler.movePlayer("right");
        loadBattlePane();
        foundItem();
        
    }
    
    @FXML
    private void moveLeft(ActionEvent event) throws IOException {
        
        gameHandler.movePlayer("left");
        loadBattlePane();
        foundItem();
        
    }
    
    public void returnFromBattle(GameHandler gameHandler){
        this.gameHandler = gameHandler;
        if(gameHandler.player.currentRoom.type.equals("FINAL")){
            textBox.setText("\n***********\nYou have escaped the dungeon!\n**************\n");
        }
        else{
        gameHandler.player.currentRoom.type = "";
        gameHandler.ReturnFromBattleStart(textBox);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        textBox.setText("Welcome");
        
        gameHandler = new GameHandler(textBox);
        gameHandler.start();
        
    }    
    
    
    
}
