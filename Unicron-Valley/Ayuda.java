import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ayuda here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ayuda extends World
{

    /**
     * Constructor for objects of class Ayuda.
     * 
     */
    private Botonmenu botMen;
    public Ayuda()
    {   
        super(800, 600, 1); 
        botMen=new Botonmenu();
        addObject(botMen,720,20);
    }
}