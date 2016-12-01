import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase contiene a todos los objetos y métodos que integran al Nivel 3
 * 
 * @author Diana Carolina Huelga Huerta
 * @author Carlos Almendarez Ávila
 * @version 13-11-16
 */
public class Nivel3 extends Nivel
{
    private Unicornio unicornio;
    private Pulpo pulpo;
    private int contPulpos;
    private PulpoSecundario pulpo2;
    private Tiburon tiburon1;
    private Tiburon tiburon2;
    private Counter contLlaves;
    private String direccion;
    private GreenfootImage bgImage;
    private SimpleTimer tiempoPulpo;
    private int imageCount = 0;   //Contador para la imagen   
    
    /**
     * Constructor for objects of class Nivel3.
     */
    public Nivel3(int vidas)
    {
        super(400,550,vidas);
        contPulpos=0;
        unicornio=super.getUnicornio();
        bgImage = new GreenfootImage("FondoNivel3.png");        
        prepare();
    }  
    public void act(){
       if(super.getLlaves() != 100){
           direccion=unicornio.mueveteEnNivel3();
           condicionesGenerales();   
           if(tiempoPulpo.millisElapsed() >= 3000 && contPulpos < 3){
               addObject(pulpo,0,300);
           }else 
           if(tiempoPulpo.millisElapsed() >= 3000 && contPulpos == 4){
               addObject(pulpo2,0,300);
           }
       }else if(super.getLlaves() == 100){
           unicornio.mueveSinScroll();
           addObject(tiburon1,400,150);
           addObject(tiburon2,400,150);
           removeObject(pulpo);
           super.añadeUnicornioSecundario(400,300); 
           tiburon1.mueveteder();
           tiburon2.mueveteziq();
        }
   }
   /**
    * Verifica cuales son los objetos que ha tocado el unicornio 
    * y manda a llamar a los metodos correspondientes
    * @author Diana huelga
    * @version 28-11-16
    * @return -
    * @param no hay parametros de entrada
    */
   public void condicionesGenerales(){
       if(unicornio.tocaLlave() == true){
            super.modificaContadorLlaves();
       }
       if(unicornio.tocaEstrella()== true){
            unicornio.cambiaTeclas();
       }
       if(unicornio.comeGalleta()== true){
            super.aumentaVida();
        } 
       if(unicornio.tocaPulpo() == true){
           this.iniciaTiempo();
           super.disminuyeContadorLlaves();
        }       
       if(unicornio.tocaPulpoSecundario()== true){
       //Si te toca te mueres
           this.iniciaTiempo();
           super.decrementaVida();
       }
   }
   /**
    * Reinicia el tiempo que majena al pulpo
    * @author Diana Huegla
    * @version 30-11-16
    * @param no hay parametros de entrada
    */
   public void iniciaTiempo(){
       if(contPulpos < 3){contPulpos++;}
       if(contPulpos >= 4){contPulpos = 0;}
       if(contPulpos == 3){contPulpos = 4;}       
       tiempoPulpo.mark();
   }
   /**
    * regresa el Strign de la tecla
    * @author Diana Huegla
    * @version 24-11-16
    * @return nombre de la tecla que hace que el unicornio se mueva hacia la derecha 
    */
   public String getDireccion(){
       return direccion;
    }
    /**
     * Agrega galletas de vidas al mundo (Nivel 3)
     * @author Diana Huelga
     * @version 22-11-16
     * @para no hay parametros de entrada
     */
    public void agregaVidas(){
        int y=Greenfoot.getRandomNumber(650);
        if(y < 30){
            y+=30;
        }
        if(Greenfoot.getRandomNumber(500) == 1){
            addObject(new Vida3(),790,y);
        }
   }    
    /** 
     * Agrega a los enemigos secundarios en una posicion en y aleatoria
     * @author Diana Huelga
     * @version 20-11-16
     * @para no hay parametros de entrada
     */
    public void agregaEnemigosSecundarios(){
        if(Greenfoot.getRandomNumber(50) == 1){
            addObject(new Estrella(),770,Greenfoot.getRandomNumber(500));            
        }
    }
    /**
     * Regresa la posicion que tiene el unicornio
     * @author Diana Huelga
     * @version 19-11-16
     * @para no hay parametros de entrada
     * @return posicion del unicornio en x
     */    
    public int getPosXUnicornio(){
        return unicornio.getX();        
    }
    /**
     * Regresa la posicion que tiene el unicornio
     * @author Diana Huelga
     * @version 19-11-16
     * @para no hay parametros de entrada
     * @return posicion del unicornio en y
     */  
    public int getPosYUnicornio(){
        return unicornio.getY(); 
    }    
    /**
     * 
     */
    public void imagenDeFondo() {
       if (imageCount < -bgImage.getWidth()) {
           imageCount += bgImage.getWidth();
       }
        int temp = imageCount;
        getBackground().drawImage(bgImage, temp, 0);
        getBackground().drawImage(bgImage, temp + bgImage.getWidth(), 0);
    }
    /**
     * 
     */
    public void mueveImagenDer()
    {
        imageCount-=5;
        imagenDeFondo();
    }
    /**
     * 
     */
    public void mueveImagenIzq()
    {
        imageCount+=5;
        imagenDeFondo();
    }
    /**
     *  Agrega llaves antes de que comience el scroll 
     *  @author Diana Huelga
     *  @version 20-11-16
     *  @param no hay parametros de entrada
     */
    public void agregaLlavesIniciales(){
        int numLlaves=Greenfoot.getRandomNumber(4);
        int x=Greenfoot.getRandomNumber(800);
        int y=Greenfoot.getRandomNumber(650);
        if( x < 750){
            x+=20;
        }
        for(int i=0 ; i < numLlaves ; i++){
            addObject(new Llave3(),x,y);
        }
    }
    /**
     *  genera llaves en tiempo de ejecucion
     *  @author Diana Huelga
     *  @version 20-11-16
     *  @param no hay parametros de entrada
     */
    public void generaLlaves(){
        if(super.getLlaves() < 100){
            int y=Greenfoot.getRandomNumber(650);
            if(y < 30){
                y+=30;
            }
            if(Greenfoot.getRandomNumber(100) == 1){
                addObject(new Llave3(),790,y);
            }
        }
    }
    /**
     *  Prepara el mundo con los objetos que iran en el
     *  @author Diana Huelga
     *  @version 28-11-16
     *  @param no hay parametros de entrada
     */   
    private void prepare()
    {  
        pulpo=new Pulpo();
        pulpo2=new PulpoSecundario();
        tiempoPulpo=new SimpleTimer();
        tiburon1=new Tiburon();
        tiburon2=new Tiburon();
        tiburon2.setImage("Tiburon2.png");
        tiempoPulpo.mark();
        agregaLlavesIniciales();
    }
}