import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EneSecundNiv1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EneSecundNiv1 extends Actor
{
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

