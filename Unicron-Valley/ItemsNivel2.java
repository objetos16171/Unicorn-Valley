import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ItemsNivel2 here.
 * 
 * @author Diana Huelga
 * @version 04-11-16
 */
public class ItemsNivel2 extends Actor
{
    /**
     * Act - do whatever the ItemsNivel2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    /**
     * mueve al actor verticalmente hacia abajo en el Nivel 2
     *@author Diana Huelga
     *@version 12-11-16
     *@param no hay parametros de entrada
     */   
    public void muevete(){
        World m=getWorld();
        if(((Nivel2)m).getPosYUnicornio() <= 300){
            setLocation(getX(),getY()+1);
        }
        if(getY()>= 590){
            m.removeObject(this);
        }
    }
    /**
     * Movimiento de las plataformas en el nivel 2
     * @author Diana Huelga
     * @version 4-12-16
     * @return- 
     * @param no hay parametros de entrada
     */
    public void muevetePlataforma(){
        World m=getWorld();
        if(((Nivel2)m).getPosYUnicornio() <= 300){
            setLocation(getX(),getY()+1);
        }
        if(getY()>= 580){
            ((Nivel2)m).eliminaPlataforma((Plataforma)this);
             m.removeObject(this);
        }
    }
}
