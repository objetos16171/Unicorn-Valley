import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pajaro here.
 * 
 * @author Carlos Almendarez 
 * @version 24-11-16
 */
public class EnemigoSecundarioNiv2 extends Actor
{
    private int vel;
    private int dx,dy;
    /**
     *  Constructor de Pajaro, inicializa sus atributos
     *  @author Carlos Almendarez
     *  @version 24-11-16
     */
    public EnemigoSecundarioNiv2()
    {
        vel = 4;
        dx = 24;
        dy = 20;
    }
    /**
     * Act - do whatever the Pajaro wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        mover();
        elimina();
    }    
    
    /**
     *  Hace el movimiento del enemigo secundario dentro del nivel 2 y modifica la imagen con la direccion que se toma
     *  @author Carlos Almendarez
     *  @version 29-11-16
     *  @param no hay parametros de entrada 
     */
    public void mover()
    {
        World w = getWorld();
        setLocation(getX()+vel,getY());
        if((getOneObjectAtOffset(dx-vel,dy,Plataforma.class)==null && isTouching(Plataforma.class)) || getX()> ((Nivel2)w).ANCHO-80 || getX()< 80)
        {
            if(getX()> ((Nivel2)w).ANCHO-80)
            {
                setLocation(((Nivel2)w).ANCHO-100,getY());
            }
            if(getX()< 80)
            {
                setLocation(100,getY());
            }
            vel=vel*(-1);
            if(vel<0)
            {
                setImage("EnemigoNiv2 (1).png");
            }else{
                setImage("EnemigoNiv2 (2).png");
            }
        }
        if(getOneObjectAtOffset(0,dy,Plataforma.class)==null)
        {
            setLocation(getX(),getY()+1);
        }
    }
    /**
     *  Manda un mensaje al mundo para que Elimine al pajaro una vez que llegue al limite del mundo 
     *  @author Carlos Almendarez
     *  @version 29-11-16
     *  @param no hay parametros de entrada 
     */
    public void elimina()
    {
        World w = getWorld();
        if(getY() > ((Nivel2)w).LARGO-80 || isTouching(Unicornio.class))
        {
            if(isTouching(Unicornio.class))
            {
                ((Nivel2)w).disminuyeContadorLlaves();
            }
            ((Nivel2)w).removeObject(this);
        }
    }
}