import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Botonmenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Botonmenu extends Actor
{
    /**
     * Act - do whatever the Botonmenu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        MouseInfo m= Greenfoot.getMouseInfo();              
        if(m != null){
            if(Greenfoot.mouseClicked(this)){
                Greenfoot.setWorld(new Menu());                
            }
        }
    }    
}
