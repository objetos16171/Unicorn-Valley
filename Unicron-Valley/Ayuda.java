import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Conjunto de metodos que hacen cambios de imagen para mostrar la ayuda
 * 
 * @author Diana Huelga 
 * @version 30-11-16
 */
public class Ayuda extends World
{
    private int numeroImagen;
    private Botonmenu botMen;
    private SimpleTimer tiempoTecla;
    private AyudaFondo a;
    /**
     * Constructor for objects of class Ayuda.
     * 
     */
    public Ayuda()
    {   
        super(800, 600, 1); 
        a=new AyudaFondo();
        addObject(a,400,300);
        a.setImage("A0.png");
        numeroImagen=0;   
        prepare();
        tiempoTecla.mark();
    }
    /**
     * @author Diana Huelga
     * @version 30-11-16
     * @param no hay parametros de entrada
     * @return -
     */
    public void act(){
        String nombre="";
        nombre="A"+numeroImagen+".png";    
        a.setImage(nombre);
        if(tiempoTecla.millisElapsed() > 1000 && ( Greenfoot.isKeyDown("enter") || Greenfoot.isKeyDown("right")) ){
            numeroImagen++;
            if(numeroImagen >= 5){
                botMen.regresaMenu();
                tiempoTecla.mark();
            }
            tiempoTecla.mark();            
        }
        if(tiempoTecla.millisElapsed() > 1000 && Greenfoot.isKeyDown("left")){
            if(numeroImagen >= 1){
                numeroImagen--;
                tiempoTecla.mark();
            }
            tiempoTecla.mark();
        }
    }
    public void prepare(){
        botMen=new Botonmenu();
        addObject(botMen,730,15); 
        tiempoTecla= new SimpleTimer();        
    }
}
