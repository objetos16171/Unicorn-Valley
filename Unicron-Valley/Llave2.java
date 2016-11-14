import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Llave2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Llave2 extends Actor
{
    /**
     * Act - do whatever the Llave2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        World m=getWorld();
        if(((Nivel2)m).getPosYUnicornio() <= 180){
            setLocation(getX(),getY()+1);
        }
        if(getY()>= 550){
            m.removeObject(this);
        }
    }    
}
