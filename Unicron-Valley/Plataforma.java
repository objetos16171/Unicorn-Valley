import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Plataforma here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plataforma extends Actor
{
    /**
     * Act - do whatever the Plataforma wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        World m=getWorld();
        if(getY() == ((Nivel2)m).getPosYUnicornio()){
            ((Nivel2)m).unicornioCae();            
        }
    }    
    /** 
     * @author Diana Huelga
     * @version 9-11-16
     * @return valor de la coordenada donde termina la plataforma en x
     * @param no hay parametros de entrada
     */
    public int getLimDer(){
        return getX()+getX();
    }
    /** 
     * @author Diana Huelga
     * @version 9-11-16
     * @return valor de la coordenada donde termina la plataforma en y
     * @param no hay parametros de entrada
     */
    public int getLimInferior(){
        return getY()+getY();
    }
    /** 
     * @author Diana Huelga
     * @version 9-11-16
     * @return valor de la coordenada donde comienza la plataforma en y
     * @param no hay parametros de entrada
     */
    public int getLimSuperior(){
        return getY()-getY();
    }
    /** 
     * @author Diana Huelga
     * @version 9-11-16
     * @return valor de la coordenada donde comienza la plataforma en x
     * @param no hay parametros de entrada
     */
    public int getLimIzquierdo(){
        return getX()-getX();
    }
}
