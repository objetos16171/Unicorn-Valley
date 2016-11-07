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
    /** 
     * 
     */
    public void generaPlataformas(){
        int y = 80;
        int numMaxReng=0;
        int uni=0;
        int x=0;
        for(int i=0 ; i < 6 ; i++){
            numMaxReng=Greenfoot.getRandomNumber(5);
            for(int j=0 ; j < numMaxReng ; j++){
                addObject(new Plataforma(),Greenfoot.getRandomNumber(800),y);                
                }
             y+=100;
        }
    }
     public void act(){
         unicornio.cae();
         unicornio.mueveLados();
         if(unicornio.getY() >= 570){
             unicornio.setLocation(400,340);
             super.decrementaVidas();
          }
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
        botMen= new Botonmenu();
        addObject(botMen,720,20);
        contLlaves=new Counter();
        addObject(contLlaves,115,20);        
        contLlaves.setImage("Llave00.png");
        addObject(new Plataforma(),400,380);
        addObject(unicornio, 400,340);        
        generaPlataformas();
     }
}
