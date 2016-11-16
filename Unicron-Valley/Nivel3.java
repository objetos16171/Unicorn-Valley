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
    private int imageCount = 0;   
    private GreenfootImage bgImage = new GreenfootImage("FondoNivel3.png");
    
    /**
     * Constructor for objects of class Nivel3.
     * 
     */
    public Nivel3()
    {
        super();
        prepare();
        unicornio = new Unicornio();
        addObject(unicornio,50,550);  
    }
    
    public void act()
    {
        unicornio.moverNiv3();
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
     
    public void drawBackgroundImage() {
       if (imageCount < -bgImage.getWidth()) {
           imageCount += bgImage.getWidth();
       }
        int temp = imageCount;
        getBackground().drawImage(bgImage, temp, 0);
        getBackground().drawImage(bgImage, temp + bgImage.getWidth(), 0);
    }
    public void moveImagDer()
    {
        imageCount-=5;
        drawBackgroundImage();
    }
    public void moveImagIzq()
    {
        imageCount+=5;
        drawBackgroundImage();
    }
}
