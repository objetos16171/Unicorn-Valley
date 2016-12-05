import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Estrella here.
 * 
 * @author Diana Huelga
 * @version 22-11-16
 */
public class Estrella extends ItemsNivel3
{
    
    /**
     * Act - do whatever the Estrella wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        World m=getWorld();
        super.mueve(m);     
    } 
}