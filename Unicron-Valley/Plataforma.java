import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Plataforma here.
 * 
 * @author Diana Huelga 
 * @version 11-11-16
 */
public class Plataforma extends ItemsNivel2
{
    /**
     * Act - do whatever the Plataforma wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * @auhtor Diana Huelga
     * @version 15-11-16
     */
    public void act() 
    {
        World m=getWorld();
        super.muevetePlataforma();
    }  
}
