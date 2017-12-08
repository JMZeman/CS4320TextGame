/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeoncrawler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Zuldred
 */
public class FXMLBattleDocumentController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private AnchorPane battlePane; 
    
    private GameHandler gameHandler;
    private Player player;
    
    public void transferGameHandler(GameHandler gameHandler){
        this.gameHandler = gameHandler;
        this.player = gameHandler.player;
        battleLog.appendText("You are fighting a " + player.currentRoom.monster.name+ "\n Your Health: " + player.health + "\n");
    }
    
    @FXML
    private TextArea battleLog;
    
    @FXML
    public void attackButton() throws IOException{
        int attackDamage = player.weapon.attack; //Attack logic here , can change to use hit chance, etc
        player.currentRoom.monster.health -= attackDamage; //Can change to be based off monster defense
        monsterAction();
        
        
    }
    
    @FXML
    public void usePotionButton() throws IOException{
        gameHandler.player.health += 10;
        monsterAction();
    }
    
    @FXML
    public void defendButton() throws IOException{
        
        //defend logic
        monsterAction();
        
        
    }
    
    private void monsterAction() throws IOException{
        
        battleLog.appendText("Players current health: " + player.health + "\nMonsters current health: " + player.currentRoom.monster.health + "\n");
        
        
        if(player.currentRoom.monster.health > 0){ //if the monster is alive still
        
        
            battleLog.appendText("Monsters Turn!\n");
            //logic here for Monsters attack or other action
        }
        else{
            
            battleVictory();
        }
        
    }
    
    private void battleVictory() throws IOException{
        
        //You defeated the monster, go back to previous screen
        
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXMLDocument.fxml"));
            
            AnchorPane pane = loader.load();
            
            
            //FXMLDocumentController controller = loader.getController();
            //need to pass back gamehandler so game doesnt restart
            
            battlePane.getChildren().setAll(pane);
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
