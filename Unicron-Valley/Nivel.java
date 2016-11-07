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
     * 
     */
    public Nivel()
    {  
        super(800, 600, 1); 
        
        botMen=new Botonmenu();
        contVidas=new Counter();
        
        addObject(contVidas,330,20);       
        addObject(botMen,720,20);
        contVidas.setImage("Vidas3.png");
    }      
    public void decrementaVidas()
    {
        if(contVidas.getValue() >= 1){
            contVidas.add(-1);
        }else 
        pierdes();
    }
    public void agregaVida(){
        if(contVidas.getValue() <= 2){
            contVidas.add(1);
        }
    }
    public void pierdes()
    {
        System.out.println("Perdiste");
        //Agregar etiqueta
    }
}

