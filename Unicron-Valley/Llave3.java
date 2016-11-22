import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Llave3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Llave3 extends Actor
{
    /**
     * Act - do whatever the Llave3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        World m = getWorld();
        muevete(m);     
        if(this.getX() <= 10){
            ((Nivel3)m).removeObject(this);
        }
        
    }    
    /**
     * Simula el movimiento de la llave por el nivel 3 dependiendo
     * de la posicion en x del unicornio.
     * @athor Diana Huelga
     * @version 19-11-16
     * @param el mundo donde está la llave
     * @return -
     */
    public void muevete(World m){
        if(Greenfoot.isKeyDown("right") && (((Nivel3)m).getWidth()/4)*3 < (((Nivel3)m).getPosXUnicornio()+1)){
            this.move(-2);            
        }        
    }
}
