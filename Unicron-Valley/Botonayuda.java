import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Botonayuda here.
 * 
 * @author Diana Huelga
 * @version 5-11-16
 */
public class Botonayuda extends Boton
{
    private String nombre;
    public Botonayuda(){
        nombre="Ayuda1.png";
    }
    /**
     * Act - do whatever the Botonayuda wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(super.presionaBoton(nombre) == true){
            Greenfoot.setWorld(new Ayuda());
        }
    }
}
