import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Final here.
 * 
 * @author Diana Huelga
 * @version 28-11-16
 */
public class Final extends World
{
    private Unicornio unicornio;
    /**
     * Constructor for objects of class Final.
     * 
     */
    public Final()
    {   
        super(800, 600, 1); 
        prepare();
    }
    /**
     * @author Diana Huelga
     * @version 28-11-16
     */
    public void act(){
        unicornio.mueveFinal();
    }
    /**
     * @author Diana Huelga
     * @version 28-11-16
     */
    public void prepare(){
        addObject(new Esfera(), 700,300);
        unicornio= new Unicornio();
        addObject(unicornio,40,300);
        UnicornioSecundario u1= new UnicornioSecundario();
        UnicornioSecundario u2= new UnicornioSecundario();
        u1.setImage("UnicornioSolo.png");
        u2.setImage("UnicornioSolo2.png");
        addObject(u1,200,80);
        addObject(u2,600,80);
    }
}
