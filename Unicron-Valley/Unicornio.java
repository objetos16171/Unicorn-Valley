import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Unicornio here.
 * 
 * @author Diana Carolina Huelga Huerta
 * @author Carlos Almendarez Ávila
 * @version 5-11-16
 */
public class Unicornio extends Actor
{
    private String derecha;
    private String izquierda;
    private String arriba;
    private String abajo;
    
    private int vel;
    private int dx;
    private int dy;
    private int salto;
    private SimpleTimer tiempoDeSalto;
    private int velS;
    
    /**
     * Constructor for objects of class Unicornio.
     */
    public Unicornio(){
        vel = 4;//2
        dx = 34;
        dy = 34;
        
        derecha="right";
        izquierda="left";
        arriba="up";
        abajo="down";
        
        tiempoDeSalto = new SimpleTimer();
        velS = 8;
    }
    /**
     * Act - do whatever the Unicornio wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        tocaLlave();
    }
    /**
     * cambia el orden de las teclas
     * @author Diana Huelga
     * @version 21-11-16
     * @param no hay parametros de entrada
     */
    public void cambiaTeclas()
    {
       String i,d,a,b;
       d=derecha;
       i=izquierda;
       a=arriba;
       b=abajo;
       
       arriba=d;
       derecha=b;
       abajo=i;
       izquierda=a;
    }
    /**
     * Mueve la posicion del jugador y verifica que no salga del mundo
     * Este metodo pertenece al Nivel1
     * @author Carlos Almendarez y Diana Carolina
     * @version 5-11-16 Carlos 
     * @version 6-11-16 Diana
     * @return No hay valor
     * @param no hay parametros de entrada
     */
     public void mueve()
     {
         World w = getWorld();
        if(Greenfoot.isKeyDown("right") && getX()+50<((Nivel1)w).getAnc() && getOneObjectAtOffset(dx+vel,0,Piedra.class)==null
           && getOneObjectAtOffset(dx,dy,Piedra.class) == null && getOneObjectAtOffset(dx,-dy,Piedra.class)==null && getX() < 800-dx){             
             setLocation(getX()+vel,getY());   
             setImage("unicorn.png");    
        }    
        if(Greenfoot.isKeyDown("left") && getX()-50>0 && getOneObjectAtOffset(-dx-vel,0,Piedra.class)==null
           && getOneObjectAtOffset(-dx,dy,Piedra.class) == null && getOneObjectAtOffset(-dx,-dy,Piedra.class)==null && getX() > dx){
                 setLocation(getX()-vel,getY());
                 setImage("unicorn2.png");   
        }
         if(Greenfoot.isKeyDown("up") && getY()-50>0 && getOneObjectAtOffset(0,-dy-vel,Piedra.class)==null
            && getOneObjectAtOffset(dx,-dy,Piedra.class) == null && getOneObjectAtOffset(-dx,-dy,Piedra.class)==null && getY() > 80){     
             setLocation(getX(),getY()-vel);           
        }         
        if(Greenfoot.isKeyDown("down") && getY()+50<=((Nivel1)w).getAltura() && getOneObjectAtOffset(0,dy+vel,Piedra.class)==null
           && getOneObjectAtOffset(dx,dy,Piedra.class) == null && getOneObjectAtOffset(-dx,dy,Piedra.class)==null && getY() < 600-dy){            
                setLocation(getX(),getY()+vel);            
        }
    }
    /**
     * Verifica si el unicornio ha tocado a un pulpo
     * @author Diana Huelga
     * @version 28-11-16
     * @return true si toco al pulpo 
     * @return false si no toco al pulpo 
     */
    public boolean tocaPulpo(){
        if(this.isTouching(Pulpo.class)){
            removeTouching(Pulpo.class);
            return true;
        }else{ return false;}
    }
    /**
     * Verifica si el unicornio ha tocado a un pulpo secundario
     * @author Diana Huelga
     * @version 30-11-16
     * @return true si toco al pulpo secundario
     * @return false si no toco al pulpo secundario
     */
    public boolean tocaPulpoSecundario(){
        if(this.isTouching(PulpoSecundario.class)){
            removeTouching(PulpoSecundario.class);
            return true;
        }else{ return false;}
    }
    /**
     * Verifica si el unicornio principal esta tocando al unicornio secundario
     * @author Diana Huelga
     * @version 6-11-16
     * @return true si se cumple la condicion, false si no
     * @param no hay parametros de entrada
     */
    public boolean libera(){
        if(this.isTouching(UnicornioSecundario.class)){ 
            return true;                             
        }else {
            return false;
        }
    }
    /**
     * Verifica si el unicornio comio una galleta
     * @author Diana Huelga
     * @version 18-11-16
     * @return true si comio la galleta, false si no
     * @param no hay parametros de entrada
     */
     public boolean comeGalleta()
     {  
        if(this.isTouching(Vida.class)){
            removeTouching(Vida.class);
            return true;
        }else 
        if(this.isTouching(Vida2.class)){
            removeTouching(Vida2.class);
            return true;
        }else 
        if(this.isTouching(Vida3.class)){
            removeTouching(Vida3.class);            
            return true;
        }else{ return false;}
    }           
     /**
     * verifica si el unicornio toco a una estrella
     * @author Diana Huelga
     * @version 20-11-16
     * @param no hay parametros de entrada
     * @return true si toco a una estrella
     * @return flase si no ha tocado una estrella
     */
    public boolean tocaEstrella(){
        if(this.isTouching(Estrella.class)){
            removeTouching(Estrella.class);
            return true;
        }else {return false;}
    }
    /**
     * Verifica si el unicornio toco uno de los enemigos
     * secundarios del nivel1
     * @author Diana Huelga
     * @version 18-11-16
     * @return true si comio la galleta, false si no
     * @param no hay parametros de entrada
     */
     public boolean tocaHormiga()
     {  
        if(isTouching(EneSecundNiv1.class)){
            this.setLocation(60,100);
            return true;
        }else {return false;}
    }
    /**
     * Verifica si el unicornio toco una roca (Nivel2)
     * @author Diana Huelga
     * @version 30-11-16
     * @return true si el unicornio toco una roca
     * @return false si el unicornio no ha tocado una roca
     * @param no hay parametros de entrada
     */
    public boolean tocaRoca(){
        if(isTouching(Roca.class)){
            removeTouching(Roca.class);
            return true;
        }else{
            return false;}
    }
    /**
     *  Cambia la posicion en 'y' del unicornio para simular la caida
     *  @author Diana Huelga
     *  @author Carlos Almendarez
     *  @return -
     *  @param no hay parametros de entrada 
     *  @version 7-11-16 
     *  @version 22-11-16
     */
    public void cae(){        
        if(getOneObjectAtOffset(0,dy,Plataforma.class)==null && getOneObjectAtOffset(dx,dy,Plataforma.class)==null 
        && getOneObjectAtOffset(-dx,dy,Plataforma.class)==null && getOneObjectAtOffset(dx/2,dy,Plataforma.class)==null 
        && getOneObjectAtOffset(-dx/2,dy,Plataforma.class)==null){
            setLocation(getX(),getY()+2);
        }
    }
    /**
     *  (Nivel2) Mueve la posicion en x dependiendo de la tecla presionada
     *  @author Diana Huelga
     *  @author Carlos Almendarez
     *  @return -
     *  @param no hay parametros de entrada 
     *  @version 7-11-16 
     *  @version 22-11-16 
     */
    public void mueveLados(){
        if(Greenfoot.isKeyDown("right") && (getX()+40) <= 800){
            setImage("unicorn.png");
            move(3);
        }
        if(Greenfoot.isKeyDown("left") && (getX()-40) >= 0){
            setImage("unicorn2.png");
            move(-3);
        }
        if(Greenfoot.isKeyDown("down")){                     
            setLocation(getX(),getY()+3);
        }
        if(Greenfoot.isKeyDown("up") && getY()>180 && (getOneObjectAtOffset(0,dy,Plataforma.class)!=null || getOneObjectAtOffset(dx,dy,Plataforma.class)!=null 
        || getOneObjectAtOffset(-dx,dy,Plataforma.class)!=null || getOneObjectAtOffset(dx/2,dy,Plataforma.class)!=null 
        || getOneObjectAtOffset(-dx/2,dy,Plataforma.class)!=null)){
            if(tiempoDeSalto.millisElapsed()>1000 && salto==0){
                salto=25;
                tiempoDeSalto.mark();
            }
        }
    }
    /**
     * reinicializa el tiempo 
     * @author Carlos Almendarez
     * @version 15-11-16
     * @param no hay parametros de entrada
     * @return-
     */
    public void iniciaTimer()
    {
        tiempoDeSalto.mark();
    }
    /**
     * disminute la posicion en y para simular el salto  
     * @author Carlos Almendarez
     * @version 15-11-16
     * @param no hay parametros de entrada
     * @return-
     */    
    public void brinca()
    {
        if(salto>0){
            setLocation(getX(),getY()-velS);
            salto--;
        }
    }
    /**
     * Verifica si el unicornio toco una llave 
     * @author Diana Huelga
     * @version 20-11-16
     * @return true si tocó una llave del Nivel 3
     * @return false si no ha tocado una llave Nivel 3
     * @param no hay parametros de entrada
     */
    public boolean tocaLlave(){
        if(this.isTouching(Llave3.class)){
            removeTouching(Llave3.class);
            return true;
        }else 
        if(this.isTouching(Llave2.class)){
            removeTouching(Llave2.class);
            return true;
        }else 
        if(this.isTouching(Llave.class)){
            removeTouching(Llave.class);
            return true;
        }else{ return false;}
    }
    /**
     * movimiento del unicornio en el nivel 3 
     * @author Carlos Almendarez
     * @author Diana Huelga 
     * @version Diana 25-11-16
     * @version Carlos 15-11-16
     * @param no hay parametros de entrada
     * @return-
     */
    public String mueveteEnNivel3()
     {
        World w = getWorld();
        if(Greenfoot.isKeyDown(derecha)){  
            setImage("unicorn.png");
            if((((Nivel3)w).getWidth()/4)*3 < getX()+vel){
                ((Nivel3)w).generaLlaves();
                ((Nivel3)w).agregaEnemigosSecundarios();
                ((Nivel3)w).agregaVidas();
                ((Nivel3)w).mueveImagenDer();      
            }else{
                setLocation(getX()+vel,getY());
            } 
            return derecha;             
        }
        if(Greenfoot.isKeyDown(izquierda)){
            setImage("unicorn2.png");
            setLocation(getX()-vel,getY());
        }
        if(Greenfoot.isKeyDown(arriba)){
            if(getY() > 80){                
                setLocation(getX(),getY()-vel);
            }
        }
        if(Greenfoot.isKeyDown(abajo)){
            if(getY() < 560)
            setLocation(getX(),getY()+vel);
        }
        return "";
    }
    /**
     * Permite al unicornio moverse sin avanzar al mundo 
     * @author Diana Huelga
     * @version 29-11-16
     * @return -
     * @param no hay paramtros de entrada
     */
    public void mueveSinScroll(){
        if(Greenfoot.isKeyDown(derecha)){  
            setImage("unicorn.png"); 
            setLocation(getX()+vel,getY());            
        }
        if(Greenfoot.isKeyDown(izquierda)){
            setImage("unicorn2.png");
            setLocation(getX()-vel,getY());
        }
        if(Greenfoot.isKeyDown(arriba)){
            if(getY() > 80){                
                setLocation(getX(),getY()-vel);
            }
        }
        if(Greenfoot.isKeyDown(abajo)){
            if(getY() < 560)
                setLocation(getX(),getY()+vel);
        }
    }
}