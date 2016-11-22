import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Unicornio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Unicornio extends Actor
{
    private int vel;
    private int dx;
    private int dy;
    private int salto;
    private SimpleTimer tiempoDeSalto;
    private int velS;
    public Unicornio(){
        vel = 2;
        dx = 34;
        dy = 34;
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
     * movimiento del unicornio en el nivel 3 
     * @Carlos Almendarez
     * @version 15-11-16
     * @param no hay parametros de entrada
     * @return-
     */
    public void moverNiv3()
    {
        World w = getWorld();
        if(Greenfoot.isKeyDown("right")){
            if((((Nivel3)w).getWidth()/4)*3<getX()+vel){
                ((Nivel3)w).mueveImagenDer();
            }else{
                setLocation(getX()+vel,getY());
            }
        }
        if(Greenfoot.isKeyDown("left")){
            if(100>getX()+vel){
            }else{
                setLocation(getX()-vel,getY());
            }
        }
        if(Greenfoot.isKeyDown("up")){
            setLocation(getX(),getY()-vel);
        }
        if(Greenfoot.isKeyDown("down")){
            setLocation(getX(),getY()+vel);
        }
    }
}