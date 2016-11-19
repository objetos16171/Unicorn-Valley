import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nivel3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel3 extends Nivel
{
    private Unicornio unicornio;
    private Counter contLlaves;
    private GreenfootImage bgImage;
    private int imageCount = 0;   //Contador para la imagen   
    
    /**
     * Constructor for objects of class Nivel3.
     * 
     */
    public Nivel3(int vidas)
    {
        super(50,500,vidas);
        unicornio=super.getUnicornio();
        bgImage = new GreenfootImage("FondoNivel3.png");
        prepare();
    }    
    public void act(){
        unicornio.moverNiv3();
    }
    /**
     * 
     */
    public void imagenDeFondo() {
       if (imageCount < -bgImage.getWidth()) {
           imageCount += bgImage.getWidth();
       }
        int temp = imageCount;
        getBackground().drawImage(bgImage, temp, 0);
        getBackground().drawImage(bgImage, temp + bgImage.getWidth(), 0);
    }
    /**
     * 
     */
    public void mueveImagenDer()
    {
        imageCount-=5;
        imagenDeFondo();
    }
    /**
     * 
     */
    public void mueveImagenIzq()
    {
        imageCount+=5;
        imagenDeFondo();
    }
    /**
     *  Prepara el mundo con los objetos que iran en el
     *  @author Diana Huelga
     *  @version 13-11-16
     *  @param no hay parametros de entrada
     */   
    private void prepare()
    {
       contLlaves=new Counter();
       addObject(contLlaves,115,20);        
       contLlaves.setImage("Llave00.png");     
    }
}
