import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Unicornio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Unicornio extends Actor
{
    private int vel = 5;
    /**
     * Act - do whatever the Unicornio wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    // private Unicornio(){
        // setImage("Unicorn.png");
    // }
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
        if(Greenfoot.isKeyDown("right") && getX()+50<((Nivel1)w).getAnc()){             
             setLocation(getX()+vel,getY());
             setImage("unicorn.png");    
        }    
        if(Greenfoot.isKeyDown("left") && getX()-50>0){
                 setLocation(getX()-vel,getY());
                 setImage("unicorn2.png");   
        }
         if(Greenfoot.isKeyDown("up") && getY()-50>0){     
             setLocation(getX(),getY()-vel);           
        }         
        if(Greenfoot.isKeyDown("down") && getY()+50<=((Nivel1)w).getAltura()){
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
     public void tocaLlave(){
        if(isTouching(Llave.class)){
            World m=getWorld();
            ((Nivel1)m).modificaContadorLlaves();            
            removeTouching(Llave.class);
        } 
    }
    /**
     *Salto del unicornio (este metodo se ejecuta desde el mundo: Nivel2)
     * @author Diana Huelga
     * @version 4-11-16
     * @return -
     * @param no hay parametros de entrada
     */
    public void salta(){
        if(Greenfoot.isKeyDown("up") && isTouching(Plataforma.class)){
            for(int i=0 ; i<5 ; i++){
                setLocation(getX(),getY()-8);
            }
        }else
        if(Greenfoot.isKeyDown("up")){
            for(int i=0 ; i<5 ; i++){
                setLocation(getX(),getY()-3);
            }
        }
    }
}
