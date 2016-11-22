import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Portal here.
 * 
 * @author Carlos Almendarez
 * @version 4-11-16 
 */
public class Portal extends Actor
{
    public static final int ANCHO = 20; 
    public static final int LARGO = 20;
     /* Act - do whatever the Portal wants to do. This method is called whenever
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
     * @author Diana Huelga
     * @version 4-11-16
     * @version 14-11-16 
     * @return No hay valor 
     * @param no hay parametros de entrada
     */
    public void teleport()
    {
        World w = getWorld();
        if(isTouching(Unicornio.class))
        {
            if(((Nivel1)w).getPosXUnicornio() >= getX()-ANCHO && ((Nivel1)w).getPosXUnicornio() <= getX()+ANCHO
                && ((Nivel1)w).getPosYUnicornio() >= getY()-LARGO && ((Nivel1)w).getPosYUnicornio() <= getY()+LARGO){
                    ((Nivel1)w).teleport(getX());
            }
        }
    }
}
