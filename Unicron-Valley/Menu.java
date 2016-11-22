import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author Diana Carolina Huelga Huerta
 * @version 5-11-16
 */
public class Menu extends World
{
    private Jugar jug;
    private Botonayuda ayud;    
    private Salir salir;
    private Botoncreditos creditos;

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
        salir= new Salir();
        creditos= new Botoncreditos();
        addObject(jug,400,350);        
        addObject(ayud,400,400);
        addObject(salir,400,450);
        addObject(creditos,400,500); 
    }
}
