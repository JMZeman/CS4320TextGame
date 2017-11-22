/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeoncrawler;

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
       player.health = 2000;
       player.name = "Jonas";
       textarea.setText(player.name + " has spawned at Room 0,0");
       textarea.appendText("\nRoom Type:"+player.currentRoom.type);
       
        
        
    }
    
    public void movePlayer(){
        int x1 = player.x;//x before move
        int y1 = player.y;//y before move
        player.moveToNextRoom();
        if(x1 == player.x && y1 == player.y){ //if player did not move
            textarea.appendText("\nCannot go to next room! Monster blocking path");
        }
        else{
            textarea.appendText("\nMoved to room "+player.x +","+player.y);
            textarea.appendText("\nRoom Type:"+player.currentRoom.type);
        }
    }
    
}
 