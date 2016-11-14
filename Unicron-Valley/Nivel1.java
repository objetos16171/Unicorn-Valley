import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Nivel1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel1 extends Nivel
{
    private Unicornio unicornio;
    private Counter contLlaves;
    private UnicornioSecundario uni2;
    /**
     * Constructor for objects of class Nivel1.
     */
    public Nivel1()    
    {     
        super();
        agregaPortales();
        acomodaPiedras();
        agregaLlavesAleatoriamente();
        agregaEnemigosAleatoriamente();        
        prepare();
    }
    public void act()
    {
        unicornio.mueve();
        liberaAmigoUnicornio();
    }
    /**
     * valida si se puede avanzar al mundo Nivel2
     * @author Diana Huelga
     * @version 6-11-16
     * @return - 
     * @param no hay parametros de entrada
     */
     public void liberaAmigoUnicornio(){
     if(unicornio.libera() && contLlaves.getValue() == 100){
                 uni2.cambiaNivel();
            }
    }
    /**
     * Agrega portales al mundo Nivel 1
     * @author Diana Huelga
     * @param no hay parametros de entrada
     * @return - 
     * @version 6-11-16
     */
    public void agregaPortales(){
        int y=0;
        int x=0;
        for(int i=0 ; i < 5 ;)
        {
            x=Greenfoot.getRandomNumber(750);
            y=Greenfoot.getRandomNumber(600);
            if( x > 10 && y > 50){
                addObject(new Portal(),x,y);
                i++;
            }
        }
    }
    /**
     * Agrega las piedras que irán en el escenario
     * @author Diana Huelga
     * @version 6-11-16
     * @return -
     * @param no hay parametros de entrada
     */
    public void acomodaPiedras(){
        int x=15;
        int y=150;
        int i=0;
        
        for(i=0; i < 11 ; i++){     
            if(i == 3){
                x+=120;}
            addObject(new Piedra(),x,y);             
            x+=30;
        }          
        x=15;
        y=270;
        for(i=0 ; i < 18 ; i++){
            if(i == 8){
                x+=y;}
            addObject(new Piedra(),x,y);             
            x+=30;
        }
        y=390;
        x=15;
        for(i=0 ; i< 19; i++){
            if(i == 0 || i == 17){
                x+=120;
            }
            addObject(new Piedra(),x,y);             
            x+=30;            
        }  
    }
    /**
     * Agerga al mundo los enemigos secundarios del nivel
     * @author Diana Huelga
     * @version 6-11-16
     * @retunrn -
     * @param no hay parametros de entrada
     */
    public void agregaEnemigosAleatoriamente(){
        int y=0;
        int x=0;
        for(int i=0 ; i < 5 ;)
        {
            x=Greenfoot.getRandomNumber(750);
            y=Greenfoot.getRandomNumber(600);
            if( x > 10 && y > 80){
                addObject(new EneSecundNiv1(),x,y);
                i++;
            }
        }
    }
    /**
     * Cambia la ubicacíon del unicornio
     * @author Carlos Almendarez
     * @version 4-11-16
     * @return No hay valor 
     * @param int x la coordenada del portal que acciono el usuario
     */
    public void teleport(int x)
    {
        Portal p;
        int a;
        List L;
        L=getObjects(Portal.class);        
        a=Greenfoot.getRandomNumber(L.size());
        p=(Portal)L.get(a);
        if(p.getX()!=x) //validacion para que no salga por el mismo portal
        {
           unicornio.setLocation(p.getX()+110,p.getY());
        }
    }
    
    /**
     * Obtiene el valor de la anchura del mundo
     * @author Carlos Almendarez
     * @version 4-11-16
     * @return Width 
     * @param No hay parametro de entrada
     */
    public int getAnc()
    {
        return getWidth();
    }    
    /**
     * Obtiene el valor de la altura del mundo
     * @author Carlos Almendarez
     * @version 4-11-16
     * @return Height 
     * @param No hay parametro de entrada
     */
    public int getAltura()
    {
        return getHeight();
    }
    /**
     * Agrega aleatoriamente 10 llaves al mundo Nivel1
     * @author Diana Huelga
     * @version 6-11-16
     * @return -
     * @pararm no hay parametros de entrada
     */
    public void agregaLlavesAleatoriamente(){
        int i;
        int xLlav=0;
        int yLlav=0;
        
        for(i = 0 ; i < 10 ;){            
            xLlav=Greenfoot.getRandomNumber(750);
            yLlav=Greenfoot.getRandomNumber(550);
            
            if(xLlav >= 20 && yLlav >= 80 && (xLlav > 60 && yLlav > 100)){ //Condicion para evitar que las llaves aparezcan en las orillas 
                                            //del mundo en x tanto como en y
                addObject(new Llave(),xLlav,yLlav);
                i++;
            }
        }
    }
    /**
     * @author Diana Huelga
     * @version 7-11-16
     * @return posicion del unicornio en x
     * @param no hay parametros de entrada
     */
    public int getPosUniX(){
        return unicornio.getX();
    }
    /**
     * @author Diana Huelga
     * @version 7-11-16
     * @return posicion del unicornio en y
     * @param no hay parametros de entrada
     */
    public int getPosUniy(){
        return unicornio.getY();
    }
    /**
     * Agrega puntos al contador de llaves y 
     * modifica su imagen.
     * @author Diana Huelga
     * @version 5-11-16
     * @param no hay parametros de entrada
     * @return -
     */
    public void modificaContadorLlaves(){     
        String nombArch="";
        contLlaves.setValue(contLlaves.getValue()+10);
        contLlaves.act();        
        nombArch="Llave" + contLlaves.getValue() + ".png"; 
        contLlaves.setImage(nombArch);
    }
    /** 
     * Prepara a los objetos que estarán en el mundo
     * @author Diana Huelga
     * @version 06-11-16
     * @return -
     * @param no hay parametros de entrada
     */
    private void prepare()
    {                
        unicornio = new Unicornio();
        contLlaves=new Counter();
        addObject(contLlaves,115,20);
        contLlaves.setImage("Llave00.png");
        uni2= new UnicornioSecundario();
        addObject(uni2,730,550);   
        addObject(unicornio,60,100); 
    }
    /**
     * Regresa el unicornio a su posicion inicial
     * @author Carlos Almendarez
     * @version 12-11-16
     * @return -
     * @param no hay parametros de entrada
     */
    public void posInicial(){
        unicornio.setLocation(60,100);
        super.decrementaVidas();
    }
}
