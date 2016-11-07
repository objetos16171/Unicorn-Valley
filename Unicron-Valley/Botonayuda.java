import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Botonayuda here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Botonayuda extends Actor
{
    /**
     * Act - do whatever the Botonayuda wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        MouseInfo m= Greenfoot.getMouseInfo();              
        if(m != null){
            if(Greenfoot.mouseClicked(this)){
                setImage("Ayuda1.png");
                Greenfoot.delay(50);
                Greenfoot.setWorld(new Ayuda());                
            }
        }
    }    
}
