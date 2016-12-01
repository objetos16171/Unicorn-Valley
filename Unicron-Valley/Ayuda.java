import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Conjunto de metodos que hacen cambios de imagen para mostrar la ayuda
 * 
 * @author Diana Huelga 
 * @version 30-11-16
 */
public class Ayuda extends World
{
    private int numeroImagen;
    /**
     * Constructor for objects of class Ayuda.
     * 
     */
    private Botonmenu botMen;
    public Ayuda()
    {   
        super(800, 600, 1); 
        numeroImagen=0;
       
    }
    /**
     * @author Diana Huelga
     * @version 30-11-16
     * @param no hay parametros de entrada
     * @return -
     */
    public void act(){
        if(Greenfoot.isKeyDown("enter") || Greenfoot.isKeyDown("right")){
            
        }
    }
    public void prepare(){
         botMen=new Botonmenu();
        addObject(botMen,720,20);
    }
}
