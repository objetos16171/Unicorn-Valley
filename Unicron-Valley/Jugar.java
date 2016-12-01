import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jugar here.
 * 
 * @author Diana Huelga 
 * @version 5-11-16
 */
public class Jugar extends Boton
{    
    private String nombre;
    /**
     * Act - do whatever the Jugar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Jugar(){
        nombre="Jugar1.png";
    }
    public void act() 
    {
        if(super.presionaBoton(nombre) == true){
            Greenfoot.setWorld(new Nivel1()); 
        }
    }     
}
