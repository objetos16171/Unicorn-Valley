import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Roca here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Roca extends Actor
{
    private int vel;
    
    /**
     *  Constructor que inicializa el atributo de la clase
     *  @author Carlos Almendarez
     *  @version 24-11-16
     *  @param no hay parametros de entrada 
     */
    public Roca()
    {
        vel=6;
    }
    
    /**
     * Act - do whatever the Roca wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        cae();
        elimina();
    }   
    
    /**
     *  Movimiento principal del objeto
     *  @author Carlos Almendarez
     *  @version 24-11-16
     *  @param no hay parametros de entrada 
     */
    public void cae()
    {
        setLocation(getX(),getY()+vel);
    }    
    /**
     *  Elimina la el objeto al llegar al borde o al tocar al unicornio y manda un mensaje al mundo si toca al unicornio
     *  @author Carlos Almendarez
     *  @version 24-11-16
     *  @param no hay parametros de entrada 
     */
    public void elimina()
    {
        World w = getWorld();        
        if(getY()>((Nivel2)w).LARGO-80)
        {           
            ((Nivel2)w).removeObject(this);
        }
    }
}
