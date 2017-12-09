/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeoncrawler;

import java.util.Random;

/**
 *
 * @author To
 */
public class Room{
    int x; //x dimension of dungeon
    int y; //y dimension of dungeon
    int a; //x pos in dungeon
    int b;//y pos in dungeon
    int n;
    Random random = new Random();
    
    public String type = "NULL"; // like BOSS,STORE,MONSTER,LOOT
    public String description = "";
    
    public Monster monster = null;
    
    public Room(int x,int y,int a,int b){
        this.a = a;
        this.b = b;
        this.x = x;
        this.y = y;
        n = random.nextInt(100) + 1;
        setType();
        populateRoom();
    }
    
    
    private void populateRoom(){
        
        if("MONSTER".equals(type)){ //if this room is a monster room
            n = random.nextInt(3) + 1;
            
            switch(n){  //populates with random monsters
                
                case 1:
                    monster = new Monster("Orc",10,5,90,0);
                    break;
                case 2:
                    monster = new Monster("Giant spider", 5, 3, 95, 0);
                    break;
                case 3:
                    monster = new Monster("Man Eating Plant", 5, 7, 80, 0);
                    break;
                    
            }
            
        }
        //if("FINAL".equals(type)){// makes a final boss monster
            
        //}
    }
    
    
    private void setType(){
        
        if(a==0 && b==0 ){ //if this is the first room
            type = "START";
        }
        
        
        else if(a==x-1 && b == y-1){ //if this is the final room//needs to be changed
            type = "FINAL";
            monster = new Monster("Demon Lord", 20, 8, 95, 0);
        }
        
        if(n<=20){ //if x pos in dungeon is even
            type = "MONSTER";
        }
        
        
    }
    
}
