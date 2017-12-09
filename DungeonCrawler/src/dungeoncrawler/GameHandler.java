/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeoncrawler;

import java.io.IOException;
import javafx.scene.control.TextArea;

/**
 *
 * @author To
 */
public class GameHandler {
    private TextArea textarea;
    private final int rows = 10;
    private final int columns = 10;
    public Dungeon dungeon;
    public Player player;
    public boolean gameActive = true;
    
    public GameHandler(TextArea textarea){
        this.textarea = textarea;
        
        
    }
    
    public void start(){
         
       dungeon = new Dungeon(rows,columns);
       player = new Player(dungeon,0,0);
       player.health = 50;
       player.name = "Player";
       Armor unarmored = new Armor(0);
       Weapon unarmed = new Weapon(1, 90); //1 attack 90 hit rate
       player.armor = unarmored;
       player.weapon = unarmed;
       textarea.setText(player.name + " has spawned at Room 0,0");
       //textarea.appendText("\nRoom Type:"+player.currentRoom.type);    type should be just backend for us?
       
        
        
    }
    
    public void ReturnFromBattleStart(TextArea textarea){
        
//       this.dungeon = new Dungeon(rows,columns);
//       this.player = new Player(dungeon,0,0);
       this.textarea = textarea;
       textarea.setText(player.name + " is at Room "+player.x +","+player.y);
       textarea.appendText("\nRoom Type:"+player.currentRoom.type);
        
    }
    
    
    public void movePlayer(String direction) throws IOException{
        int x1 = player.x;//x before move
        int y1 = player.y;//y before move
        switch (direction){
            case "up":      player.moveUp();
                            break;
            case "down":    player.moveDown();
                            break;
            case "right":   player.moveRight();
                            break;
            case "left":    player.moveLeft();
                            break;
                            
        }
        if(x1 == player.x && y1 == player.y){ //if player did not move
            textarea.appendText("\nCannot move in that direction\n Dead end");
        }

        else{
            textarea.appendText("\nMoved to room "+player.x +","+player.y);
            textarea.appendText("\nRoom Type:"+player.currentRoom.type);
        }
    }
    
}
 