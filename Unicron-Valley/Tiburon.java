import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tiburon here.
 * 
 * @author Diana Huelga
 * @version 25-11-16
 */
public class Tiburon extends Actor
{
    /**
     * Act - do whatever the Tiburon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
    }    
    /**
     * Mueve al actor en forma circular hacia la derecha
     * @author Diana Huelga
     * @version 25-11-16
     * @return -
     * @para no hay parametros de entrada
     */
    public void mueveteder(){
        move(5);
        turn(2);
    }    
    /**
     * Mueve al actor en forma circular hacia la izquierda
     * @author Diana Huelga
     * @version 25-11-16
     * @return -
     * @para no hay parametros de entrada
     */
    public void mueveteziq(){
        move(-5);
        turn(-2);
    }
}
