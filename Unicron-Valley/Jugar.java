import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jugar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jugar extends Actor
{
    /**
     * Act - do whatever the Jugar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        MouseInfo m= Greenfoot.getMouseInfo();              
        if(m != null){
            if(Greenfoot.mouseClicked(this)){
                setImage("Jugar1.png");
                Greenfoot.delay(50);
                Greenfoot.setWorld(new Nivel2());
            }
        }
    }    
}
