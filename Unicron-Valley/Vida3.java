import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Llave3 here.
 * 
 * @author Diana Huelga 
 * @version 22-11-16
 */
public class Vida3 extends ItemsNivel3
{
    String tecla;
    /**
     * Act - do whatever the Llave3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        World m=getWorld();
        super.mueve(m);
    }
}
