import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nivel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel extends World
{
    private Botonmenu botMen;
    private Counter contVidas;
    /**
     * Constructor for objects of class Nivel.
     */
    public Nivel()
    {  
        super(800, 600, 1); 
        
        botMen=new Botonmenu();
        contVidas=new Counter();
        contVidas.setValue(3);
        addObject(contVidas,330,20);       
        addObject(botMen,720,20);
        contVidas.setImage("Vidas3.png");
    }      
    /**
     *  Decrementa el contador de vidas en 1
     *  @author Diana Huelga
     *  @return -
     *  @param no hay parametros de entrada 
     *  @version 7-11-16
     */
    public void decrementaVidas()
    {
        if(contVidas.getValue() >= 1){
            contVidas.add(-1);
            contVidas.act();
            contVidas.setImage("Vidas"+contVidas.getValue()+".png");
        }
        if(contVidas.getValue() == 0){
            pierdes();
        }
    }
    /**
     *  Aumenta en uno al contador de vidas
     *  @author Diana Huelga
     *  @return -
     *  @param no hay parametros de entrada 
     *  @version 7-11-16
     */
    public void agregaVida(){       
        if(contVidas.getValue() <= 2){
            contVidas.add(1);
            contVidas.act();
            contVidas.setImage("Vidas"+contVidas.getValue()+".png");
        }
    }
    /**
     *  cuando es llamdo cambia el mundo a Menu
     *  @author Diana Huelga
     *  @return -
     *  @param no hay parametros de entrada 
     *  @version 7-11-16
     */
    public void pierdes()
    {
        System.out.println("Perdiste");
        Greenfoot.setWorld(new Menu());        
        //Agregar etiqueta
    }
}

