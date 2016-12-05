import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boton here.
 * 
 * @auhtor Diana Huelga
 * @version 27-11-16
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
    /**
     * verifica si se dio click en algunas de las opciones
     * del menú
     * @author Diana Huelga
     * @version 28-11-16
     * @param nombre del archivo para cambiar la imagen de
     * la opcion seleccionada 
     * @return true si se ha presionado una opcion
     * @return false si no se ha presionado una opcion
     */
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
