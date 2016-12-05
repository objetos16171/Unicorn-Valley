import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * tiene los metodos que realizan todos los items del nivel 3
 * 
 * @author Diana Huelga
 * @version 30-11-16
 */
public class ItemsNivel3 extends Actor
{
    String tecla;
    /**
     * Act - do whatever the ItemsNivel3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    /**
     * Mueve el los items verticalmente hacia abajo
     * en el nivel 3 
     * @auhtor Diana Huelga
     * @version 27-11-16
     * @return -
     * @param recibe el el nivel de tipo Mundo donde se encuentra
     * el objeto
     */
    public void mueve(World m){
        tecla= ((Nivel3)m).getDireccion();
        if(tecla != ""){
            if(Greenfoot.isKeyDown(tecla) && (((Nivel3)m).getWidth()/4)*3 < (((Nivel3)m).getPosXUnicornio()+1)){
                this.move(-2); 
            }
        }     
        if(this.getX() <= 10){
            ((Nivel3)m).removeObject(this);
        }        
    }
}
