import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jugar here.
 * 
 * @author Diana Huelga 
 * @version 5-11-16
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
                realizaCambio();
            }
    }    
    /**
     * Realiza el cambio de menu a nivel 1
     * @author Diana Huelga
     * @param no hay parametros de entrada
     */
    public  void realizaCambio(){
        if(Greenfoot.mouseClicked(this)){
            setImage("Jugar1.png");
            Greenfoot.delay(50);
            Greenfoot.setWorld(new Nivel3(3));          
        }
    }
}
