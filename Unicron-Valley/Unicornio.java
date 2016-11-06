import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Unicornio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Unicornio extends Actor
{
    /**
     * Act - do whatever the Unicornio wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        tocaLlave();
    }    
    /**
     * Verifica si el unicornio tomo una llave y manda un mensaje a mundo
     * para poder aumentar el contador y cambiar la imagen
     * @author Diana Huelga
     * @version 4-11-16
     * @return -
     * @param no hay parametros de entrada
     */
     public void tocaLlave(){
        if(isTouching(Llave.class)){
            World m=getWorld();
            ((Nivel2)m).modificaContadorLlaves();            
            removeTouching(Llave.class);
        } 
    }
    /**
     *Salto del unicornio (este metodo se ejecuta desde el mundo: Nivel2)
     * @author Diana Huelga
     * @version 4-11-16
     * @return -
     * @param no hay parametros de entrada
     */
    public void salta(){
        if(Greenfoot.isKeyDown("up") && isTouching(Plataforma.class)){
            for(int i=0 ; i<5 ; i++){
                setLocation(getX(),getY()-8);
            }
        }else
        if(Greenfoot.isKeyDown("up")){
            for(int i=0 ; i<5 ; i++){
                setLocation(getX(),getY()-3);
            }
        }
    }
}
