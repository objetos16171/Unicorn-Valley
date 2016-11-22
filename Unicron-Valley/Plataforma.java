import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Plataforma here.
 * 
 * @author Diana Huelga 
 * @version 11-11-16
 */
public class Plataforma extends Actor
{
    /**
     * Act - do whatever the Plataforma wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        World m = getWorld();
        if(((Nivel2)m).getPosYUnicornio() <= 180){
            setLocation(getX(),getY()+1);
        }
        if(getY()>= 550){
            m.removeObject(this);
            ((Nivel2)m).eliminaPlataforma(this);
        }
    }     
}
