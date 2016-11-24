import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Creditos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Creditos extends World
{
    private Botonmenu botMen;
    /**
     * Constructor for objects of class Creditos.
     * 
     */
    public Creditos()
    {   
        super(800, 600, 1); 
        botMen=new Botonmenu();
        addObject(botMen,400,570); 
    }
}
