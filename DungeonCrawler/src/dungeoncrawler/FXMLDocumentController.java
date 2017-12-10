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
    private TextArea textBox;
    
    @FXML
    private TextArea descriptionBox;
    
    @FXML
    private Button up;
    @FXML
    private Button right;
    @FXML
    private Button down;
    @FXML
    private Button left;
    
    private GameHandler gameHandler;
   
    
    private void cheackRoomType() throws IOException{                    //cheacks room type then loads logic for each type
        if(gameHandler.player.currentRoom.type.equals("MONSTER")){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXMLBattleDocument.fxml"));
            AnchorPane pane = loader.load();
            FXMLBattleDocumentController battleController = loader.getController();
            battleController.transferGameHandler(gameHandler);
            dungeonPane.getChildren().setAll(pane);

        }
        else if(gameHandler.player.currentRoom.type.equals("FINAL")){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXMLBattleDocument.fxml"));
            AnchorPane pane = loader.load();
            FXMLBattleDocumentController battleController = loader.getController();
            battleController.transferGameHandler(gameHandler);
            dungeonPane.getChildren().setAll(pane);

        }
        else if(gameHandler.player.currentRoom.type.equals("ITEM")){
        gameHandler.player.currentRoom.type = "";
            if(gameHandler.player.currentRoom.weapon != null && gameHandler.player.currentRoom.weapon.attack > gameHandler.player.weapon.attack){
                gameHandler.player.weapon = gameHandler.player.currentRoom.weapon;
                descriptionBox.appendText("\n You found a better weapon and equiped it\n it has an attack of " + gameHandler.player.weapon.attack);
            }
            if(gameHandler.player.currentRoom.armor != null && gameHandler.player.currentRoom.armor.defense > gameHandler.player.armor.defense){
                gameHandler.player.armor = gameHandler.player.currentRoom.armor;
                descriptionBox.appendText("\nYou found better armor and equiped it\nIt has a defense of " + gameHandler.player.currentRoom.armor.defense);
            }
        gameHandler.player.currentRoom.type = null;
        }
        else{  //if just regular room
            descriptionBox.appendText("\nYou find yourself in a dark room with a few exits on the edge of your vision\n");
        }
    }
    
    @FXML
    private void moveUp(ActionEvent event) throws IOException {

        gameHandler.movePlayer("up");
        cheackRoomType();
        
    }
    
    @FXML
    private void moveDown(ActionEvent event) throws IOException {
        
        gameHandler.movePlayer("down");
        cheackRoomType();
    }
    
    @FXML
    private void moveRight(ActionEvent event) throws IOException {
        
        gameHandler.movePlayer("right");
        cheackRoomType();
        
    }
    
    @FXML
    private void moveLeft(ActionEvent event) throws IOException {
        
        gameHandler.movePlayer("left");
        cheackRoomType();
        
    }
    
    private void end(){
            left.setDisable(true);
            right.setDisable(true);
            up.setDisable(true);
            down.setDisable(true);
            textBox.setText("");
    }
    
    public void returnFromBattle(GameHandler gameHandler){
        this.gameHandler = gameHandler;
        

        
        if(gameHandler.battleLoss == true){
            descriptionBox.appendText("\nYou have lost the battle! You die in agony...\n");
            end();
        }
        
        
        else if(gameHandler.player.currentRoom.type.equals("FINAL")){
            descriptionBox.setText("\n***********\nYou have escaped the dungeon!\n**************\n");
            end();
        }

        else{
        descriptionBox.appendText("\nYou stand triumphiant over the defeted monster\n");
        gameHandler.player.currentRoom.type = "";
        gameHandler.ReturnFromBattleStart(textBox);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        gameHandler = new GameHandler(textBox);
        gameHandler.start();
        
    }    
    
    
    
}
