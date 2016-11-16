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
    /** ancho del mundo Nivel2 */
    public static final int ANCHO=800;
    /** largo del mundo Nivel2 */
    public static final int LARGO=600;
    
    /**contador para la distancia entre plataformas 
       Se utiliza en el metodo: generaPlataformas() */
    private int contPlat=0;  
        
    private Unicornio unicornio;
    private UnicornioSecundario uni3;
    private Counter contLlaves;
    
    /**Lista de plataformas*/
    private List<Plataforma> listPlat;     //lista de plataformas presentes en el mundo
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
         unicornio.mueveLados();
         verificaPosUnicornio(); 
         avanzaMundo();
         liberaAmigoUnicornio();         
    }
    /**
     * valida si el unicornio toco al unicornio secundario
     * @author Diana Huelga
     * @return -
     * @param no hay parametros de entrada
     * @version 14-11-16
     */
    public void liberaAmigoUnicornio(){
        if(unicornio.libera()){
             uni3.setImage("unicornioLibre.png");
             Greenfoot.delay(50);
             uni3.cambiaNivel(new Nivel3());
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
             if(contLlaves.getValue() == 100){    
                 addObject(uni3,Greenfoot.getRandomNumber(750),20);
                 uni3.setLocation(uni3.getX(),uni3.getY()+1);
             }
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
        if(Greenfoot.getRandomNumber(5) == 1 && contLlaves.getValue() < 100){
            addObject(new Llave2(),x,y);
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
     * Agrega puntos al contador de llaves y 
     * modifica su imagen.
     * @author Diana Huelga
     * @version 14-11-16
     * @param no hay parametros de entrada
     * @return -
     */
    public void modificaContadorLlaves(){     
        if(contLlaves.getValue() < 100){
            String nombArch="";
            contLlaves.setValue(contLlaves.getValue()+10);
            contLlaves.act();        
            nombArch="Llave" + contLlaves.getValue() + ".png"; 
            contLlaves.setImage(nombArch);
        }
    }
    /**
     *  Prepara el mundo con los objetos que iran en el
     *  @author Diana Huelga
     *  @version 04-11-16
     *  @param no hay parametros de entrada
     */   
     private void prepare()
     {
         int x=50;
         int y=585;   
        contLlaves=new Counter();
        uni3= new UnicornioSecundario();
        addObject(contLlaves,115,20);   
        contLlaves.setImage("Llave00.png");     
        unicornio=new Unicornio();
        addObject(unicornio, ANCHO/2,340); 
     }
}