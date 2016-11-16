import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Salir here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Salir extends Actor
{
    /**
     * Act - do whatever the Salir wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        MouseInfo m= Greenfoot.getMouseInfo();              
        if(m != null){            
                realizaCambio();
            }
    }    
    public  void realizaCambio(){
        if(Greenfoot.mouseClicked(this)){
           setImage("Salir1.png");
           Greenfoot.delay(50);
           setImage("Salir.png");
           Greenfoot.stop();       
       }
    }
}
