import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    private Jugar jug;
    private Botonayuda ayud;    

    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {     
        super(800, 600, 1); 
        setBackground("Menu.png");          
        prepare();       
    }
    /**
     * Prepara al mundo para comenzar el programa
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        ayud= new Botonayuda();
        jug = new Jugar();
        addObject(jug,400,350);        
        addObject(ayud,400,400);
    }
}
