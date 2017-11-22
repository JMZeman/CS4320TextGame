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
public class Player {
    public int health;
    public Dungeon currentDungeon;
    public String name;
    int x; //current x
    int y; //current y
    public Room currentRoom;
    public Armor armor;
    public Weapon weapon;
    
    public Player(Dungeon dungeon,int x,int y){
        currentDungeon = dungeon;
        this.x = x; //sets initial pos in dungeon
        this.y = y;
        currentRoom = currentDungeon.rooms[x][y];
        
        
    }
    
    private boolean roomIsEmpty(Room room){ 
        if(room.type=="NULL" || room.type =="START"){ //NULL rooms have nothing, so you can continue
            return(true);
        }
        return(true);
    }
    
    public void moveRight(){
        
        if(roomIsEmpty(currentRoom)==true){ //Room must be empty (ie cleared of monsters) to go to next room
            
            
        
        
        
        
            if(x==currentDungeon.x-1 && y==currentDungeon.y-1){ //if in the final room and you hit next, you win

                //Victory!
                return;
            }



            if(x<(currentDungeon.x-1)){ //if not in last column , jut continue right column

                x++;
                currentRoom = currentDungeon.rooms[x][y];

                return;

            }
            else{ //give message that you have reached a dead end
                
            }


        
            
        }
        else{
            //Room has a monster in it
            
        }
    }
        
    public void moveLeft(){
        
        if(roomIsEmpty(currentRoom)==true){ //Room must be empty (ie cleared of monsters) to go to next room
            
            
        
        
        
        
            if(x==currentDungeon.x-1 && y==currentDungeon.y-1){ //if in the final room and you hit next, you win

                //Victory!
                return;
            }



            if(x!=0){ //if not at first collumn, jut continue down row

                x--;
                currentRoom = currentDungeon.rooms[x][y];

                return;

            }
            else{ //give message that you have reached a dead end
                
            }


        
            
        }
        else{
            //Room has a monster in it
            
        }
    }
    
    
        
    public void moveDown(){
        
        if(roomIsEmpty(currentRoom)==true){ //Room must be empty (ie cleared of monsters) to go to next room
            
            
        
        
        
        
            if(x==currentDungeon.x-1 && y==currentDungeon.y-1){ //if in the final room and you hit next, you win

                //Victory!
                return;
            }



            if(y!=0){ //if not on bottom row move up

                y--;
                currentRoom = currentDungeon.rooms[x][y];

                return;

            }
            else{ //give message that you have reached a dead end
                System.out.println("here");
                
            }


        
            
        }
        else{
            //Room has a monster in it
            
        }
    }
    
    public void moveUp(){
        
        if(roomIsEmpty(currentRoom)==true){ //Room must be empty (ie cleared of monsters) to go to next room
            
            
        
        
        
        
            if(x==currentDungeon.x-1 && y==currentDungeon.y-1){ //if in the final room and you hit next, you win

                //Victory!
                return;
            }



            if(y<(currentDungeon.y-1)){ //if not in last column , jut continue right column

                y++;
                currentRoom = currentDungeon.rooms[x][y];

                return;

            }
            else{ //give message that you have reached a dead end
                
            }


        
            
        }
        else{
            //Room has a monster in it
            
        }
    }
}
