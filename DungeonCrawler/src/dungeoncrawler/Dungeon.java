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
public class Dungeon {
    
    public int x; //# of columns in dungeon
    public int y; //# of rows in dungeon
    public Room[][] rooms; //2D array of rooms
    
    
    public Dungeon(int x,int y){
        this.x = x;
        this.y = y;
        createRooms(x,y);
    }
    
    
    public void createRooms(int x,int y){
        int a,b;
        rooms = new Room[x][y];
        
        for(a=0;a<x;a++){
            for(b=0;b<y;b++){
                rooms[a][b] = new Room(x,y,a,b);
            }
            
        }
        
        
    }
    
}
