import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Esfera here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Esfera extends Actor
{
    /**
     * Act - do whatever the Esfera wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(this.isTouching(Unicornio.class)){
            World m= getWorld(); 
            Label fin= new Label("HAS GANADO",80);
            m.addObject(fin,400,300);
            Greenfoot.stop();
        }
    }    
}
