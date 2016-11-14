import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nivel3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel3 extends Nivel
{
    private Unicornio unicornio;
    private Counter contLlaves;   
    /**
     * Constructor for objects of class Nivel3.
     * 
     */
    public Nivel3()
    {
        super();
        prepare();
        unicornio = new Unicornio();
        addObject(unicornio,50,550);  
    }
    /**
     *  Prepara el mundo con los objetos que iran en el
     *  @author Diana Huelga
     *  @version 13-11-16
     *  @param no hay parametros de entrada
     */   
     private void prepare()
     {
        contLlaves=new Counter();
        addObject(contLlaves,115,20);        
        contLlaves.setImage("Llave00.png");     
        unicornio = new Unicornio();
        addObject(unicornio,50,550);        
     }
}
