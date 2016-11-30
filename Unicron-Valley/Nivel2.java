import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
/**
 * La clase contiene a todos los objetos y métodos que integran al nivel2
 * @author Carlos Almendarez Ávila
 * @author Diana Carolina Huelga Huerta
 * @version 14-11-16
 */
public class Nivel2 extends Nivel
{
    /** ancho del mundo Nivel2 */
    public static final int ANCHO=800;
    /** largo del mundo Nivel2 */
    public static final int LARGO=600;
    
    /**contador para la distancia entre plataformas 
       Se utiliza en el metodo: generaPlataformas() */
    private int contPlat=0;
    private EnemigoNivel2 enemigoPrincipal;
    
    private Unicornio unicornio;
    private Counter contLlaves;    
    /**Lista de plataformas*/
    private List<Plataforma> listPlat;     //lista de plataformas presentes en el mundo
    /**
    * Constructor for objects of class Nivel2. 
    */
    public Nivel2(int vidas)
    {            
        super(ANCHO/2,LARGO/2+40,vidas);
        unicornio=super.getUnicornio();
        prepare();
    }
    public void act(){
		verificaPosUnicornio(); 
        avanzaMundo();   
        unicornio.brinca();
        unicornio.cae();
        unicornio.mueveLados();
        if(unicornio.libera()== true){
            super.cambiaNivel(new Nivel3(super.getNumeroViadas()));
        }
        if(unicornio.comeGalleta() == true){
            super.aumentaVida();
        }
        if(unicornio.tocaLlave() == true){
            super.modificaContadorLlaves();
        }      
    } 
    /**
     * Avanza los objetos que hay en el mundo
     * @author Diana Huelga
     * @return -
     * @param no hay parametros de entrada
     * @version 14-11-16
     */
    public void avanzaMundo(){
        if(unicornio.getY() <= 180){
             generaPlataformas();
             super.unicornioSecundarioNivel2(Greenfoot.getRandomNumber(750),20);                 
        }         
    }
    /**
     * Elimina un objeto de la clase Plataforma de la lista de 
     * plataformas
     * @author Diana Huelga
     * @return -
     * @param objeto de la clase Plataforma
     * @version 12-11-16
     */
    public void eliminaPlataforma(Plataforma p){
        listPlat.remove(p);        
    }
    /**
     * genera plataformas en tiempo de ejecucion
     * @author Diana Huelga
     * @return 1, si ya ha aparecido el unicornio a salvar
     * @param no hay parametros de entrada
     * @version 12-11-16
     */
    public void generaPlataformas(){
         int maxPlat=Greenfoot.getRandomNumber(5);
         if(contPlat == 100){
            if(maxPlat <= 1){
                maxPlat=2;
            }
            for(int i=0 ; i < maxPlat; i++){
                Plataforma plat=new Plataforma();
                int x=Greenfoot.getRandomNumber(800);
                addObject(plat,x,80);
                agregaLlave(x,50);
                agregaVida(x,50);
                agregaAve(x,50);
                listPlat.add(plat);
            }
            contPlat=0;
        }else {
            contPlat++;
        }
    }
    /**
     * Agrega una llave en la posicion x,y indicada
     * @author Diana Huelga
     * @return -
     * @version 13-11-16
     * @param x posicion en x donde se colocara la llave
     * @param y posicion en y donde se colocara la llave
     */
    public void agregaLlave(int x, int y){
        if(Greenfoot.getRandomNumber(5) == 1 && super.getLlaves() < 100){
            addObject(new Llave2(),x,y);
        }
    }
    /**
     * Agrega una galelta de vida en la posicion x,y indicada
     * @author Diana Huelga
     * @return -
     * @version 22-11-16
     * @param x posicion en x donde se colocara la galleta
     * @param y posicion en y donde se colocara la galleta
     */
    public void agregaVida(int x, int y){
        if( Greenfoot.getRandomNumber(10) == 1 ){
            addObject(new Vida2(),x,y);
        }
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
        addObject(new Plataforma(),ANCHO/2,380);
        unicornio.setLocation(ANCHO/2,340);
        generaPlataformasIniciales();
        listPlat=getObjects(Plataforma.class);
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
     * Vefiaca la posicion del unicornio para saber si esta en la 
     * parte baja del escenario 
     * @author Diana Huelga 
     * @return -
     * @version 9-11-16
     * @param no hay parametros de entrada
     */
    public void verificaPosUnicornio(){
        if(unicornio.getY() >= 570){
            removeObjects(listPlat);
            listPlat.clear();                   
            posicionesIniciales();
			super.decrementaVida();
         }
    }
    /**
     * Coloca plataformas aelatoriamente en el escenario 
     * @author Diana Huelga
     * @version 7-11-16
     * @return -
     * @param no hay parametros de entrada
     */
    public void generaPlataformasIniciales(){
        int y = 80;
        int numMaxReng=0;
        int uni=0;
        int x=0;
        for(int i=0 ; i < 6 ; i++){
            numMaxReng=Greenfoot.getRandomNumber(5);
            if(numMaxReng == 0){
                numMaxReng=1;
            }
            for(int j=0 ; j < numMaxReng ; j++){
                addObject(new Plataforma(),Greenfoot.getRandomNumber(800),y);                
                }
             y+=100;
        }
    }
     /**
      *  Crea un nuevo objeto de tipo Roca en la posicion del Pajaro
      *  @author Carlos Almendarez
      *  @version 24-11-16
      *  @param no hay parametros de entrada
      */
    public void creaRoca()
    {
        Roca r = new Roca();
        addObject(r,enemigoPrincipal.getX(),enemigoPrincipal.getY()+25);
    }
    public void prepare(){
        enemigoPrincipal = new EnemigoNivel2();
        listPlat= new ArrayList<Plataforma>();   
        posicionesIniciales();
        modificaContadorVidas();
        unicornio.iniciaTimer();
        addObject(enemigoPrincipal,ANCHO/2,60);
    }
    
    public void agregaAve(int x, int y){
        if(Greenfoot.getRandomNumber(5) == 1){
            addObject(new Pajaro(),x,y);
        }
    }
}