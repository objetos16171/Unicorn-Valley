import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EneSecundNiv1 here.
 * 
 * @author Carlos Almendarez
 * @author Diana Huelga
 * @version 11-11-16
 */
public class EneSecundNiv1 extends Actor
{
    public static final int ANCHO = 24; 
    public static final int LARGO = 10;
    private int vel=1;
    private int cont=0;
    /**
     * Act - do whatever the EneSecundNiv1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        move(vel);
        movimientoHorizontal();
    }       
    /**
     * Gira la imagen cada 200 celdas 
     * @param no hay parametros de entrada
     * @author Diana Carolina 
     * @version 11-11-16
     */
    public void movimientoHorizontal(){
        cont++;        
        if(cont == 300){
            if(getX() >= 700){
                turn(180);
                cont=0;
            }else{
                turn(180);
                cont=0;
            }
        }
    }
}