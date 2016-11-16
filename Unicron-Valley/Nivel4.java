import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel4 extends Nivel
{
    private int imageCount = 0;
   
    private GreenfootImage bgImage = new GreenfootImage("11a.png");
  
    public void act() {
       imageCount -= 5; //(or any other value; small -> slow moving, big -> fast movement)
       drawBackgroundImage();
    }
    public void drawBackgroundImage() {
       if (imageCount < -bgImage.getWidth()) {
           imageCount += bgImage.getWidth();
       }
        int temp = imageCount;
        getBackground().drawImage(bgImage, temp, 0);
        getBackground().drawImage(bgImage, temp + bgImage.getWidth(), 0);
    }
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Nivel4()
    {
        super();
    }
}
