import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Botoncreditos here.
 * 
 * @author Diana Huelga 
 * @version 22-11-16
 */
public class Botoncreditos extends Actor
{
    /**
     * Act - do whatever the Botonayuda wants to do. This method is called whenever
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
     * Hace el cambio de mundos de menu a ayuda
     * @author Diana Huelga
     * @version 22-11-16
     * @param no hay parametros de entrada
     */
    public  void realizaCambio(){
        if(Greenfoot.mouseClicked(this)){
            setImage("Creditos1.png");
            Greenfoot.delay(50);
            Greenfoot.setWorld(new Creditos());      
        }
    }
}
