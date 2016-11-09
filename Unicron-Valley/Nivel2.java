import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
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
     private List<Plataforma> listPlat;    
    /**
    * Constructor for objects of class Nivel2. 
    */
    public Nivel2()
    {            
        super();  
        listPlat= new ArrayList<Plataforma>();        
        prepare();                
        posicionesIniciales();
    }
    public void act(){
         // unicornio.salta();
         unicornio.mueveLados();
         posicionUnicornio();    
         saltaUnicornio();
    }
    /**
     * Asigna las posiciones iniciales de los elementos principales del escenario
     * (plataformas y unicornio)
     * @author Diana Huelga
     * @return -
     * @version 9-11-16
     * @param no hay parametros de entrada
     */
    public void posicionesIniciales(){
        addObject(new Plataforma(),400,380);
        unicornio.setLocation(400,340);
        generaPlataformas();
        listPlat=getObjects(Plataforma.class);
    }
    /**
     * Manda un mensaje a Unicornio para que aumente su posicion en y
     * @author Diana Huelga
     * @version 9-11-16
     * @para no hay parametros de entrada
     * @return -
     */
    public void unicornioCae(){
        unicornio.cae();
    }
    /**
     * Regresa la posicion que tiene el unicornio
     * @author Diana Huelga
     * @version 9-11-16
     * @para no hay parametros de entrada
     * @return posicion del unicornio en x
     */    
    public int getPosXUnicornio(){
        return unicornio.getX();        
    }
    /**
     * Regresa la posicion que tiene el unicornio
     * @author Diana Huelga
     * @version 9-11-16
     * @para no hay parametros de entrada
     * @return posicion del unicornio en y
     */  
    public int getPosYUnicornio(){
        return unicornio.getY(); 
    }
    /**
     * @author Diana Huelga 
     * @return -
     * @version 9-11-16
     * @param no hay parametros de entrada
     */
    public void aumentaCoordenadasUnicornio(){
        unicornio.setLocation(unicornio.getX(),unicornio.getY()+2);
    }
    public void saltaUnicornio(){
        if(Greenfoot.isKeyDown("up")){
            for(int i=0 ; i < 10 ; i++){
                unicornio.setLocation(unicornio.getX(),unicornio.getY()-5);
            }    
        }   
    }
    /**
     * Vefiaca la posicion del unicornio para saber si esta en la 
     * parte baja del escenario 
     * @author Diana Huelga 
     * @return -
     * @version 9-11-16
     * @param no hay parametros de entrada
     */
    public void posicionUnicornio(){
        if(unicornio.getY() >= 570){
            removeObjects(listPlat);
            posicionesIniciales();
            super.decrementaVidas();
         }
    }
    /**
     * Coloca plataformas aelatoriamente en el escenario 
     * @author Diana Huelga
     * @version 7-11-16
     * @return -
     * @param no hay parametros de entrada
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
        botMen= new Botonmenu();
        addObject(botMen,720,20);
        contLlaves=new Counter();
        addObject(contLlaves,115,20);        
        contLlaves.setImage("Llave00.png");     
        unicornio=new Unicornio();
        addObject(unicornio, 400,340);        
     }
}
