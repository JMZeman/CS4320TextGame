/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeoncrawler;

/**
 *
 * @author Zuldred
 */
public class Monster {
    String name;
    int health;
    int attack;
    int hitRate;
    int defense;
    
    public Monster(String name, int health, int attack, int hitRate, int defense){
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.hitRate = hitRate;
        this.defense = defense;

}
    
}


