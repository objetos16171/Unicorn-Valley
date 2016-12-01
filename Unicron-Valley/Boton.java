import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boton extends Actor
{
    /**
     * Act - do whatever the Boton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }    
    public boolean presionaBoton(String archivo){
        MouseInfo m= Greenfoot.getMouseInfo();              
        if(m != null){  
            if(Greenfoot.mouseClicked(this)){
                setImage(archivo);
                Greenfoot.delay(50); 
                return true;
            }                
        }
        return false;
    }
}
