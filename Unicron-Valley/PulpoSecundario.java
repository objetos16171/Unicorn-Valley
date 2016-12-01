import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PulpoSecundario here.
 * 
 * @author Diana Huelga
 * @version 30-11-16
 */
public class PulpoSecundario extends EnemigoSecundarioNivel3
{
    /**
     * Act - do whatever the PulpoSecundario wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        World m=getWorld();
        super.muevete(m);
        if(getX() >= 650){
            m.removeObject(this);
            ((Nivel3)m).iniciaTiempo();
        }
    }    
}
