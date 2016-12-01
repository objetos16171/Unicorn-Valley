import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tiburon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tiburon extends Actor
{
    /**
     * Act - do whatever the Tiburon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
    }    
    public void mueveteder(){
        move(5);
        turn(2);
    }    
    public void mueveteziq(){
        move(-5);
        turn(-2);
    }
}
