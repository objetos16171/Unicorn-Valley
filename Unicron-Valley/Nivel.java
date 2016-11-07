import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nivel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel extends World
{
    private Botonmenu botMen;
    /**
     * Constructor for objects of class Nivel.
     * 
     */
    public Nivel()
    {  
        super(800, 600, 1); 
        botMen=new Botonmenu();
        addObject(botMen,720,20);        
    }      
}
