import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vida2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vida2 extends Actor
{
    /**
     * Act - do whatever the Vida2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
         muevete();
    }   
    /**
     * @author Diana Huelga 
     * @version 13-11-16
     * @param no hay parametros de entrada
     */
    public void muevete(){
        World m=getWorld();
        if(((Nivel2)m).getPosYUnicornio() <= 180){
            setLocation(getX(),getY()+1);
        }
        if(getY()>= 550){
            m.removeObject(this);
        }
    }
}
