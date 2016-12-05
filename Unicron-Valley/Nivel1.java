import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * La clase contiene a todos los objetos y métodos que integran al Nivel 1
 * 
 * @author Diana Carolina Huelga Huerta
 * @author Carlos Almendarez Ávila
 * @version 5-11-16
 */
public class Nivel1 extends Nivel
{
    private Unicornio unicornio;
    private Topo topo;
    private List<Portal> listaPortales;
    private SimpleTimer relojPortales;
    
    /**
     * Constructor for objects of class Nivel1.
    */
    public Nivel1(){     
        super(60,100,3); 
        unicornio=super.getUnicornio();
        super.añadeUnicornioSecundario(730,550);
        prepare(); 
    }
    public void act(){ 
        listaPortales=getObjects(Portal.class);
        unicornio.mueve();
        generaPortales();
        eliminaPortales();
        condicionesGenerales();
       }
    /**
     * Verifica las condiciones generales de las acciones del unicornio
     * @author Diana Huelga
     * @version 04-12-16
     * @return -
     * @param no hay parametros de entrada 
     */
    public void condicionesGenerales(){
        if(unicornio.libera()== true){
            super.cambiaNivel(new Nivel2(super.getNumeroViadas()));
        }
        if(unicornio.comeGalleta() == true){
            super.aumentaVida();
        }
        if(unicornio.tocaHormiga() == true){
            List<EneSecundNiv1> listaHormigas = getObjects(EneSecundNiv1.class);
            if(listaHormigas != null){removeObjects(listaHormigas);}
            this.agregaEnemigosAleatoriamente();
            super.decrementaVida();
        }
        if(unicornio.tocaLlave() == true){
            super.modificaContadorLlaves();
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
     * @author Diana Huelga
     * @version 15-11-16
     * @return - 
     * @param una lista de tipo Portal
     */
    public void eliminaPortales(){
        if(listaPortales.size() > 0 ){
            if(relojPortales.millisElapsed() > 5000){
                    Portal p=listaPortales.remove(0);
                    removeObject(p);
                    relojPortales.mark();
            }        
        }
    }
    /**
     * Agrega portales al mundo Nivel 1
     * @author Diana Huelga
     * @param no hay parametros de entrada
     * @return - 
     * @version 15-11-16
     */
    public void generaPortales(){
        int x=Greenfoot.getRandomNumber(750);
        int y=Greenfoot.getRandomNumber(550);        
        if(Greenfoot.getRandomNumber(500) == 1){
            if(listaPortales.size() == 0){
                relojPortales.mark();
            }
            if(x <= 0 ){
                x+=20;
            }
            if(x > 750 && y >550){
                x-=30;
                y-=30;
            }            
            if(y <= 80){
                y+=20;
            }
                addObject(new Portal(),topo.getX(),topo.getY());
                addObject(new Portal(),x,y);
                topo.setLocation(x,y);
        }
    }    
    /**
     * Regresa la posicion que tiene el unicornio
     * @author Diana Huelga
     * @version 14-11-16
     * @para no hay parametros de entrada
     * @return posicion del unicornio en x
     */    
    public int getPosXUnicornio(){
        return unicornio.getX();        
    }
    /**
     * Regresa la posicion que tiene el unicornio
     * @author Diana Huelga
     * @version 14-11-16
     * @para no hay parametros de entrada
     * @return posicion del unicornio en y
     */  
    public int getPosYUnicornio(){
        return unicornio.getY(); 
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
            
            if(xLlav >= 20 && yLlav >= 80 && (xLlav > 60 && yLlav > 100)){ //Condicion para evitar que las llaves
                                                //aparezcan en las orillas del mundo en x tanto como en y
                addObject(new Llave(),xLlav,yLlav);
                i++;
            }
        }
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
    }
    /**
     * Agrega galletas de vid al mundo 
     * @author Diana Huelga
     * @version 14-11-16
     * @return -
     * @param no hay parametros de entrada
     */
    public void agregaVidasAlMundo(){
        for(int i=0 ; i < 3 ; i++){
            int x=Greenfoot.getRandomNumber(750);
            int y=Greenfoot.getRandomNumber(550);
            if(y < 50){
                y+=30;
            }else if(x < 20){
                x+=20;
            }
            addObject(new Vida(),x,y);
        }
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
        relojPortales=new SimpleTimer();
        topo=new Topo();
        addObject(topo,Greenfoot.getRandomNumber(800),Greenfoot.getRandomNumber(600));     
        acomodaPiedras();
        agregaLlavesAleatoriamente();
        agregaEnemigosAleatoriamente(); 
        agregaVidasAlMundo();
    }    
}