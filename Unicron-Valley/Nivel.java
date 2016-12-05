import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase contiene a todos los objetos y métodos que comparten todos los niveles
 * 
 * @author Diana Carolina Huelga Huerta
 * @version 17-11-16
 */
public abstract class Nivel extends World
{
    private Botonmenu botMen;
    private int numVidas;
    private Counter contVidas; // Contador para las llaves
    private Counter contLlaves; // Contador para las vidas
    private UnicornioSecundario uni2;
    private Unicornio unicornio;
    private Label vidaMenos;
    /**
     * Constructor for objects of class Nivel.
     * @param x posicion en x donde se colocara el unicornio
     * @param y posicion en y donde se colocara el unicornio 
     */
    public Nivel(int x, int y, int vidas)
    {  
        super(800, 600, 1);         
        agregaObjetosPrincipales();
        addObject(unicornio,x,y);
        numVidas=vidas;
        modificaContadorVidas();
    }      
    /**
     * Llama al metodo del Unicornio secundario para cambiar de nivel
     * @author Diana Huelga
     * @param no hay parametros de entrada
     * @version 18-11-16 
     */
    public void cambiaNivel(World n){
        if(contLlaves.getValue() == 100){
            uni2.setImage("unicornioLibre.png");
            Greenfoot.delay(50);
            uni2.cambiaNivel(n);
        }
    }
    /**
     * regresa el numerod e vidas que hay en el nivel
     * @author Diana Huelga
     * @version 20-11-16
     * @return el numero de vidas en el actual nivel
     */
    public int getNumeroViadas(){
        return numVidas;
    }
    /**
     * Agrega una etiqueta que dice: perdiste
     * @author Diana Huelga
     * @param no hay parametros de entrada
     * @version 18-11-16 
     */
    public void perdiste()
    {
        Label perdiste = new Label("PERDISTE",80);
        addObject(perdiste,400,300);
        Greenfoot.delay(200);
        botMen.regresaMenu();
    }
    /**
    * inicializa unicamente la imagen del contador dependiendo de 
    * el numero de vidas que haya
    * @author Diana Huelga
    * @param no hay parametros de entrada
    * @version 18-11-16 
    **/
    public void modificaContadorVidas(){
        contVidas.setValue(numVidas);
        String nombArch="";
        nombArch="Vidas" + contVidas.getValue()+ ".png"; 
        contVidas.setImage(nombArch);    
    }
    /**
    * decrementa en 1 el numero de vidas del unicornio 
    * @author Diana Huelga
    * @param no hay parametros de entrada
    * @version 18-11-16 
    **/
    public void decrementaVida(){
        addObject(vidaMenos,350,60); 
        Greenfoot.delay(50);
        removeObject(vidaMenos);
        if(numVidas >= 1){
            numVidas--;
            this.modificaContadorVidas();
            if(numVidas == 0){
                this.perdiste();
            }
        }
    }
    /**
    * aumenta en 1 el numero de vidas del unicornio 
    * @author Diana Huelga
    * @param no hay parametros de entrada
    * @version 18-11-16 
    **/
    public void aumentaVida(){
        if(numVidas < 3){
            numVidas++;
            modificaContadorVidas();
        }
    }    
    /**
     * Añade al unicornio secundario en la posicion indicada
     * @author Diana Huelga
     * @versio 18-11-16
     * @return -
     * @param x coordenada en x donde se posicionará el unicornio secundario
     * @param y coordenada en y donde se posicionará el unicornio secundario
     */
    public void unicornioSecundarioNivel2(int x, int y){
        if(contLlaves.getValue() == 100){
            añadeUnicornioSecundario(x,y);
            mueveUnicornioSecundarioNivel2();
        }
    }
    /**
     * aunmenta la posicion del unicornio secundario en el 
     * nivel 2 para simular la caida de este
     * @author Diana Huelga
     * @version 18-11-16
     * @return - 
     * @param no hay parametros de entrada
     */
    public void mueveUnicornioSecundarioNivel2(){
        uni2.setLocation(uni2.getX(),uni2.getY()+1);
    }
    /**
     * es llamado por las subclases para añadir al unicornio secundario en el mundo 
     * @author Diana Huelga
     * @version 17-11-16
     * @return - 
     * @param x posicion en x donde colocar el unicornio secundario
     * @param y posicion en y donde colocar el unicornio secundario
     */
    public void añadeUnicornioSecundario(int x, int y){
        addObject(uni2,x,y);     
    }    
     /**
     * valida si se puede avanzar al mundo Nivel2
     * @author Diana Huelga
     * @version 17-11-16
     * @return - 
     * @param no hay parametros de entrada
     */
     public void liberaAmigoUnicornio(World n){
     if(unicornio.libera() && contLlaves.getValue() == 100){
         uni2.setImage("unicornioLibre.png");
         Greenfoot.delay(50);
         uni2.cambiaNivel(n);
      }
    }
    /**
     * Agrega 10% al contador de llaves
     * @author Diana Huelga
     * @version 14-11-16
     * @param no hay parametros de entrada
     * @return -
     */
    public void modificaContadorLlaves(){     
        if(contLlaves.getValue() < 100){            
            contLlaves.setValue(contLlaves.getValue()+10);  
            cambiaImagenContadorLlaves();
        }
    }
    /**
     * disminuye en un 10% el contador de llaves
     * @author Diana Huelga
     * @version 28-11-16
     * @return-
     * @param no hay parametros de entrada
     */
    public void disminuyeContadorLlaves(){
        if(contLlaves.getValue() >= 10){
            contLlaves.setValue(contLlaves.getValue()-10);  
            cambiaImagenContadorLlaves();
        }
    }
    /**
     * Cambia la imagen del contador de llaves
     * @author Diana Huelga
     * @version 14-11-16
     * @return-
     * @param no hay parametros de entrada
     */
    public void cambiaImagenContadorLlaves(){
        String nombArch="";
            contLlaves.act();            
            nombArch="Llave" + contLlaves.getValue() + ".png"; 
            contLlaves.setImage(nombArch);
    }
    /**
     * regresa el valor que tiene el contador de llaves
     * @author Diana Huelga
     * @version 22-11-16
     * @return numero de llaves en el nivel 
     */
    public int getLlaves(){
        return contLlaves.getValue();
    }
    /**
     * Regresa el unicornio creado en nivel
     * @author Diana Huelga
     * @version 18-11-16
     * @param no hay parametros de entrada
     * @return el unicornio presente en el nivel
     */
    public Unicornio getUnicornio(){
        return unicornio;
    }
    /**
     * Agrega al mundo los objetos que tendran 
     * todos lo niveles
     * @author Diana Huelga
     * @version 18-11-16
     */
    public void agregaObjetosPrincipales(){
        botMen=new Botonmenu();   
        unicornio= new Unicornio();
        uni2=new UnicornioSecundario();
        contVidas=new Counter();
        contLlaves=new Counter();
        contLlaves.setValue(0);
        addObject(contVidas,350,20);
        contLlaves.setImage("Llave0.png");  
        addObject(botMen,600,20);        
        addObject(contLlaves,115,20);
        vidaMenos= new Label("-1 Vida",30);        
    }
}
 
