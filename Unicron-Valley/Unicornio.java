import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
import java.util.*;
/**
 * Write a description of class Unicornio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Unicornio extends Actor
{
    private Tecla der;    
    private Tecla izq;
    private Tecla arr;
    private Tecla aba;
    
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
    // private SimpleTimer tiempoDeSalto;
    private ArrayList<Tecla> lTec;
    
    public Unicornio(){
        vel = 2;
        dx = 34;
        dy = 34;
        lTec= new ArrayList<Tecla>();
        der=new Tecla("right",1);
        izq=new Tecla("left",2);
        arr=new Tecla("up",3);
        aba=new Tecla("down",4);
        
        lTec.add(der);
        lTec.add(izq);
        lTec.add(arr);
        lTec.add(aba);
        
        derecha=der.getDireccion();
        izquierda=izq.getDireccion();
        arriba=arr.getDireccion();
        abajo=aba.getDireccion();
        
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
     * @return -
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
           && getOneObjectAtOffset(dx,dy,Piedra.class)==null && getOneObjectAtOffset(dx,-dy,Piedra.class)==null && getX() < 800-dx){             
             setLocation(getX()+vel,getY());   
             setImage("unicorn.png");    
        }    
        if(Greenfoot.isKeyDown("left") && getX()-50>0 && getOneObjectAtOffset(-dx-vel,0,Piedra.class)==null
           && getOneObjectAtOffset(-dx,dy,Piedra.class)==null && getOneObjectAtOffset(-dx,-dy,Piedra.class)==null && getX() > dx){
                 setLocation(getX()-vel,getY());
                 setImage("unicorn2.png");   
        }
         if(Greenfoot.isKeyDown("up") && getY()-50>0 && getOneObjectAtOffset(0,-dy-vel,Piedra.class)==null
            && getOneObjectAtOffset(dx,-dy,Piedra.class)==null && getOneObjectAtOffset(-dx,-dy,Piedra.class)==null && getY() > 80){     
             setLocation(getX(),getY()-vel);           
        }         
        if(Greenfoot.isKeyDown("down") && getY()+50<=((Nivel1)w).getAltura() && getOneObjectAtOffset(0,dy+vel,Piedra.class)==null
           && getOneObjectAtOffset(dx,dy,Piedra.class)==null && getOneObjectAtOffset(-dx,dy,Piedra.class)==null && getY() < 600-dy){            
                setLocation(getX(),getY()+vel);            
        }
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
     * Verifica si el unicornio tomo una llave y manda un mensaje a mundo
     * para poder aumentar el contador y cambiar la imagen
     * @author Diana Huelga
     * @version 4-11-16
     * @return -
     * @param no hay parametros de entrada
     */
     public void tocaLlave()
     {  
        if(isTouching(Llave.class)){      
            World m=getWorld();
            ((Nivel)m).modificaContadorLlaves();            
            removeTouching(Llave.class);
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
        if(isTouching(Vida.class)){   
             removeTouching(Vida.class);
            return true;
        }else {return false;}
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
     *  Cambia la posicion en 'y' del unicornio para simular la caida
     *  @author Diana Huelga
     *  @return -
     *  @param no hay parametros de entrada 
     *  @version 7-11-16
     */
    public void cae(){        
        if(!isTouching(Plataforma.class)){
            setLocation(getX(),getY()+2);
        }
    }
    /**
     *  Mueve la posicion en x dependiendo de la tecla presionada
     *  @author Diana Huelga
     *  @return -
     *  @param no hay parametros de entrada 
     *  @version 7-11-16
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
        if(Greenfoot.isKeyDown("up") && getY()>180 && isTouching(Plataforma.class)){
            if(tiempoDeSalto.millisElapsed()>1000 && salto==0){
                salto=25;
                tiempoDeSalto.mark();
            }
        }
    }
    /**
     * reinicializa el tiempo 
     * @Carlos Almendarez
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
     * @Carlos Almendarez
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
     * @return true si tocó una llave del nivel 3, false si no lo ha hecho
     * @param no hay parametros de entrada
     */
    public boolean tocaLlave3(){
        if(this.isTouching(Llave3.class)){
            removeTouching(Llave3.class);
            return true;
        }else{ return false;}
    }
    /**
     * movimiento del unicornio en el nivel 3 
     * @Carlos Almendarez
     * @version 15-11-16
     * @param no hay parametros de entrada
     * @return-
     */
    public void moverNiv3()
     {
        World w = getWorld();
        if(Greenfoot.isKeyDown(derecha)){
            if((((Nivel3)w).getWidth()/4)*3<getX()+vel){
                ((Nivel3)w).mueveImagenDer();
                ((Nivel3)w).generaLlaves();
                ((Nivel3)w).agregaEnemigosSecundarios();
            }else{
                setLocation(getX()+vel,getY());
            }
        }
        if(Greenfoot.isKeyDown(izquierda)){
            if(80 > getX()+vel){
            }else{
                setLocation(getX()-vel,getY());
            }
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