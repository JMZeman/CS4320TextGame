/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeoncrawler;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
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
    
    private Random hitChanceRoll = new Random();
    private boolean defended = false;
    
    public void transferGameHandler(GameHandler gameHandler){
        this.gameHandler = gameHandler;
        this.player = gameHandler.player;
        battleLog.appendText("You are fighting a " + player.currentRoom.monster.name+ "\n Your Health: " + player.health + "\n " + player.currentRoom.monster.name + "'s Health: " + player.currentRoom.monster.health + "\n");
    }
    
    @FXML
    private TextArea battleLog;
    
    @FXML
    public void attackButton() throws IOException{
        if ((hitChanceRoll.nextInt(100)+1) <= player.weapon.hitRate){
            int attackDamage = player.weapon.attack - player.currentRoom.monster.defense; //Attack logic here , can change to use hit chance, etc
            player.currentRoom.monster.health -= attackDamage; //Can change to be based off monster defense
            battleLog.appendText("\nYou attack and deal " + (player.weapon.attack - player.currentRoom.monster.defense) + "\nMonster's health: " + player.currentRoom.monster.health + "\n");
        }
        else{
            battleLog.appendText("\nYou missed\n");
        }
        monsterAction();
        
        
    }
    
    @FXML
    public void usePotionButton() throws IOException{
        
        
        if(player.health == player.maxHealth){
            battleLog.appendText("\nCannot heal! Already at max health\n");
        }
        else{
            if(player.health+10 > player.maxHealth)
                player.health = player.maxHealth;
            else
                player.health += 10;
            
        }
        monsterAction();
    }
    
    @FXML
    public void defendButton() throws IOException{
        
        player.armor.defense += 5;
        defended = true;
        battleLog.appendText("\nYou defended\n");
        monsterAction();
        
        
    }
    
    private void monsterAction() throws IOException{
        
        if(player.health <= 0){
            battleFailure();
        }
        
        
        if(player.currentRoom.monster.health > 0){ //if the monster is alive still
        
            if ((hitChanceRoll.nextInt(100)+1) <= player.weapon.hitRate){
                int attackDamage = player.currentRoom.monster.attack - player.armor.defense; //Attack logic here , can change to use hit chance, etc
                if(attackDamage <= 0 ){
                    battleLog.appendText("\nYou took no damage\n");
                }
                else{
                player.health -= attackDamage; //Can change to be based off monster defense
                battleLog.appendText("\n" + player.currentRoom.monster.name + " attacks and deals " + (player.currentRoom.monster.attack - player.armor.defense) + "\nYour health: " + player.health + "\n");
                }
            }
            else{
            battleLog.appendText("\n" + player.currentRoom.monster.name + " missed\n");
            }
            if (defended){
                gameHandler.player.armor.defense -= 5;
                defended = false;
            }
            //logic here for Monsters attack or other action
        }
        else{
            if (defended){
                gameHandler.player.armor.defense -= 5;
                defended = false;
            }
            battleVictory();
        }
        
    }
    
    private void battleFailure() throws IOException{
        
            gameHandler.battleLoss = true;
        
        
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXMLDocument.fxml"));
            
            AnchorPane pane = loader.load();
            
            
            FXMLDocumentController controller = loader.getController();
            controller.returnFromBattle(gameHandler);
            
            battlePane.getChildren().setAll(pane);
        
        
    }
    
    
    private void battleVictory() throws IOException{
        
        //You defeated the monster, go back to previous screen
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXMLDocument.fxml"));
            
            AnchorPane pane = loader.load();
            
            
            FXMLDocumentController controller = loader.getController();
            controller.returnFromBattle(gameHandler);
            
            battlePane.getChildren().setAll(pane);
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
