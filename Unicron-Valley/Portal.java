import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Portal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Portal extends Actor
{
    /**
     * Act - do whatever the Portal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        teleport();
        turn(-2);
    }    
    /**
     * Llama al mundo para decirle que acaba de tocar al usuario y anda su coordenada en x (este metodo pertenece al Nivel1)
     * @author Carlos Almendarez
     * @version 4-11-16
     * @return No hay valor 
     * @param no hay parametros de entrada
     */
    public void teleport()
    {
        World w = getWorld();
        if(isTouching(Unicornio.class))
        {
            ((Nivel1)w).teleport(getX());
        }
    }
}
