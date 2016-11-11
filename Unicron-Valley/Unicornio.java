import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Unicornio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Unicornio extends Actor
{
    private int vel = 2;
    private int disty = 34;
    private int distx = 36;
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
     * @version 11-11-16 Carlos
     * @return No hay valor
     * @param no hay parametros de entrada
     */
     public void mueve()
     {
         World w = getWorld(); 
         Actor a;
        if(Greenfoot.isKeyDown("right") && getX()+50<((Nivel1)w).getAnc()){             
             if(getOneObjectAtOffset(distx+vel,0,Piedra.class)==null && getOneObjectAtOffset(distx,disty,Piedra.class)==null 
                && getOneObjectAtOffset(distx,-disty,Piedra.class)==null && getOneObjectAtOffset(distx,disty/2,Piedra.class)==null 
                && getOneObjectAtOffset(distx,-disty/2,Piedra.class)==null && getOneObjectAtOffset(distx,0,Counter.class)==null){
                 setLocation(getX()+vel,getY());                               
                 setImage("unicorn.png");
             }else{
                   setLocation(getX()-1,getY());
             }
        }   
        if(Greenfoot.isKeyDown("left") && getX()-50>0){
               if(getOneObjectAtOffset(-distx-vel,0,Piedra.class)==null && getOneObjectAtOffset(-distx,disty,Piedra.class)==null
                  && getOneObjectAtOffset(-distx,-disty,Piedra.class)==null && getOneObjectAtOffset(-distx,0,Counter.class)==null
                  && getOneObjectAtOffset(-distx,disty/2,Piedra.class)==null && getOneObjectAtOffset(-distx,-disty/2,Piedra.class)==null){  
                   setLocation(getX()-vel,getY());
                   setImage("unicorn2.png");   
               }else{
                      
                       setLocation(getX()+1,getY());
               }
        }
         if(Greenfoot.isKeyDown("up") && getY()-50>0){     
             if(getOneObjectAtOffset(0,-disty-vel,Piedra.class)==null && getOneObjectAtOffset(distx,-disty,Piedra.class)==null 
                && getOneObjectAtOffset(-distx,-disty,Piedra.class)==null && getOneObjectAtOffset(0,-disty,Counter.class)==null
                && getOneObjectAtOffset(distx/2,-disty,Piedra.class)==null && getOneObjectAtOffset(-distx/2,-disty,Piedra.class)==null){
                  setLocation(getX(),getY()-vel);
             }else{
                     setLocation(getX(),getY()+1);
             }
        }         
        if(Greenfoot.isKeyDown("down") && getY()+50<=((Nivel1)w).getAltura()){            
               if( getOneObjectAtOffset(0,disty+vel,Piedra.class)==null && getOneObjectAtOffset(distx,disty,Piedra.class)==null 
                   && getOneObjectAtOffset(-distx,disty,Piedra.class)==null && getOneObjectAtOffset(0,disty,Counter.class)==null
                   && getOneObjectAtOffset(distx/2,disty,Piedra.class)==null && getOneObjectAtOffset(-distx/2,disty,Piedra.class)==null){ 
                    setLocation(getX(),getY()+vel);            
               }else
               {
                       setLocation(getX(),getY()-1);
               }
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
    public void tocar()
    {
        World w = getWorld();
        if(isTouching(EneSecundNiv1.class))
        {
            setLocation(60,100);
            ((Nivel1)w).decrementaVidas();
        }
    }
}
