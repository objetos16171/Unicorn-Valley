import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pulpo here.
 * 
 * @author Diana Huelga 
 * @version 26-11-16
 */
public class Pulpo extends EnemigoSecundarioNivel3
{
    /**
     * Act - do whatever the Pulpo wants to do. This method is called whenever
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
