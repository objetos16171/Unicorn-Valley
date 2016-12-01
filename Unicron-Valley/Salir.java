import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Salir here.
 * 
 * @author Diana Huelga
 * @version 5-11-16
 */
public class Salir extends Boton
{
    private String nombre;
    public Salir(){
        nombre="Salir1.png";
    }
    /**
     * Act - do whatever the Salir wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(super.presionaBoton(nombre) == true){
            Greenfoot.stop(); 
        }
    }
}
