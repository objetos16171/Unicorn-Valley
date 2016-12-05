import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pajaro here.
 * 
 * @author Carloz Almendarez 
 * @version 28-11-16
 */
public class Pajaro extends Actor
{
    private int vel;
    private int velRoca;
    private SimpleTimer tiempoDeRoca;
    /**
     *  Constructor de Pajaro, inicializa sus atributos
     *  @author Carlos Almendarez
     *  @version 24-11-16
     */
    public Pajaro()
    {
        prepare();
        vel = 4;
        velRoca = 2000;
    }
    /**
     * Act - do whatever the Pajaro wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        World m=getWorld();
        if(((Nivel2)m).getValorReloj() > 2000){
            mover(m);
            arroja(m);
        }
    }        
    /**
     *  Hace el movimiento del objeto dentro del nivel 2 y modifica la imagen con la direccion que se toma
     *  @author Carlos Almendarez
     *  @version 24-11-16
     *  @param no hay parametros de entrada 
     */
    public void mover(World w)
    {
        setLocation(getX()+vel,getY());
        if( getX()+vel>=((Nivel2)w).ANCHO-80 || getX()+vel<=80)
        {
          vel = vel * (-1);
          if(vel<0)
          {
           setImage("EnemigoNivel2.png");   
          }else{
           setImage("EnemigoNivel21.png");
          }
        }
    }    
    /**
     *  Manda un mensaje al mundo para que cree una nueva roca dependiendo del tiempo del timer
     *  @author Carlos Almendarez
     *  @version 24-11-16
     *  @param no hay parametros de entrada 
     */
    public void arroja(World w)
    {
        if(tiempoDeRoca.millisElapsed() > velRoca)
        {
            ((Nivel2)w).creaRoca();
            tiempoDeRoca.mark();
        }
    }
    public void prepare(){
        tiempoDeRoca = new SimpleTimer();
    }
}
