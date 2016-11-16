import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Diana Huelga
 * @version 14-11-16
 */
public class Topo extends Actor
{
    private int velx; //velcidad en x
    private int vel; //velcidad general
    private int vely;   //velocidad en 
    private int dx=30; //distancia en x del centro a la orilla de la imagen del topo
    private int dy=15;  //distancia en y del centro a la orilla de la imagen del topo
    
    public Topo(){
        velx=2;
        vely=2;
        vel=1;
        setImage("Topo.png");         
    }
    public void act() 
    {
        movimientoAleatorio();  
    }
    /**
     * mueve al topo aleatoriamente por el mundo
     * @author Diana Huelga
     * @version 15-11-16
     * @return -
     * @param no hay parametros de entrada
     */
    public void movimientoAleatorio(){  
        World w = getWorld(); 
        setLocation(getX()+velx,getY()+vely);        
        if(getX()+50<((Nivel1)w).getAnc() && getOneObjectAtOffset(dx+vel,0,Piedra.class)==null
           && getOneObjectAtOffset(dx,dy,Piedra.class)==null 
           && getOneObjectAtOffset(dx,-dy,Piedra.class)==null 
           && getX() < 800-dx){  
        }else{      
            setImage("Topo2.png");
            velx=-1;
        }
        if(getX()-50>0 && getOneObjectAtOffset(-dx-vel,0,Piedra.class)==null
           && getOneObjectAtOffset(-dx,dy,Piedra.class)==null 
           && getOneObjectAtOffset(-dx,-dy,Piedra.class)==null 
           && getX() > dx){               
        }else{    
            setImage("Topo.png");
            velx=1;
        }        
         if(getY()-50 > 0 && getOneObjectAtOffset(0,-dy-vel,Piedra.class)==null
            && getOneObjectAtOffset(dx,-dy,Piedra.class)==null 
            && getOneObjectAtOffset(-dx,-dy,Piedra.class)==null 
            && getY() > 80){
        }else{      
            vely=1;
        }       
        if(getY()+50<=((Nivel1)w).getAltura() 
            && getOneObjectAtOffset(0,dy+vel,Piedra.class)==null
           && getOneObjectAtOffset(dx,dy,Piedra.class)==null 
           && getOneObjectAtOffset(-dx,dy,Piedra.class)==null 
           && getY() < 600-dy){       
        }else{     
            vely=-1;
        }
   }
}