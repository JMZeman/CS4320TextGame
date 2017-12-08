/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeoncrawler;

/**
 *
 * @author To
 */
public class Room{
    int x; //x dimension of dungeon
    int y; //y dimension of dungeon
    int a; //x pos in dungeon
    int b;//y pos in dungeon
    
    public String type = "NULL"; // like BOSS,STORE,MONSTER,LOOT
    public String description = "";
    
    public Monster monster = null;
    
    public Room(int x,int y,int a,int b){
        this.a = a;
        this.b = b;
        this.x = x;
        this.y = y;
        setType();
        populateRoom();
    }
    
    
    private void populateRoom(){
        
        if("MONSTER".equals(type)){ //if this room is a monster room
            
            monster = new Monster("Sheldon",10,12,2,23); //one monster for now
            
        }
    }
    
    
    private void setType(){
        
        if(a==0 && b==0 ){ //if this is the first room
            type = "START";
        }
        
        if(a%2==0){ //if x pos in dungeon is even
            type = "MONSTER";
        }
        
        
        else if(a==x-1 && b == y-1){ //if this is the final room//needs to be changed
            type = "FINAL";
        }
        
        
    }
    
}
