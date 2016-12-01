import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemigoSecundarioNivel3 here.
 * 
 * @author Diana Huelga 
 * @version 30-11-16
 */
public class EnemigoSecundarioNivel3 extends Actor
{
    /**
     * Act - do whatever the EnemigoSecundarioNivel3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }    
    public void muevete(World m){
        move(1);        
        if(getY() > ((Nivel3)m).getPosYUnicornio()){
            setLocation(getX(),getY()-1);
        }else if(getY() < ((Nivel3)m).getPosYUnicornio()){
            setLocation(getX(),getY()+1);
        }
    }
}
