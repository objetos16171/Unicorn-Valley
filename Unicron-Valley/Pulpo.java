import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pulpo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pulpo extends Actor
{
    /**
     * Act - do whatever the Pulpo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        World m=getWorld();
        muevete(m);
        if(getX() >= 650){
            m.removeObject(this);
            ((Nivel3)m).iniciaTiempo();
        }
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
