import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nivel2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel2 extends Nivel
{
     private Botonmenu botMen;
     private Unicornio unicornio;
     private Counter contLlaves;
    
    /**
    * Constructor for objects of class Nivel2. 
    */
    public Nivel2()
    {            
        super();
        prepare();
    }
     public void act(){
     }
    /**
     *  @author Diana Huelga
     *  @version 04-11-16
     *  @param no hay parametros de entrada
     *  @return -
     */   
     private void prepare()
     {
         int x=50;
         int y=585;
        unicornio=new Unicornio();
        addObject(unicornio,50,540);     
        botMen= new Botonmenu();
        addObject(botMen,720,20);
        contLlaves=new Counter();
        addObject(contLlaves,115,20);
        contLlaves.setImage("Llave00.png");
        
        for(int i = 0 ; i < 7 ; i++){
            addObject(new Plataforma(),x,y);
            x+=150;
        }
    }
}
