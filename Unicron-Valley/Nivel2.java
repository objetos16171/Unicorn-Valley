import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nivel2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel2 extends World
{
    private Unicornio uni;
    private Counter contLlaves;
    /**
     * Constructor for objects of class Nivel2. 
     */
    public Nivel2()
    {    
        super(800, 600, 1); 
        contLlaves.setValue(0);
        prepare();
    }
    public void act(){
        uni.salta();
    }
    /**
     *  @author Diana Huelga
     *  @version 04-11-16
     *  @param no hay parametros de entrada
     *  @return -
     */
    public void modificaContadorLlaves(){
        contLlaves.setValue(contLlaves.getValue()+10);
        contLlaves.act();
        switch(contLlaves.getValue()){
            case 10: contLlaves.setImage("Llave10.png");   
                break;
            case 20: contLlaves.setImage("Llave20.png");   
                break;
            case 30: contLlaves.setImage("Llave30.png");   
                break;
            case 40: contLlaves.setImage("Llave40.png");   
                break;
            case 50: contLlaves.setImage("Llave50.png");   
                break;
            case 60: contLlaves.setImage("Llave60.png");   
                break;
            case 70:contLlaves.setImage("Llave70.png");   
                break;
            case 80: contLlaves.setImage("Llave80.png");   
                break; 
            case 90: contLlaves.setImage("Llave90.png");   
                break;
            case 100: contLlaves.setImage("Llave100.png");   
                break;
        }
    }
    private void prepare()
    {
        uni=new Unicornio();
        addObject(uni,50,540);
        contLlaves=new Counter();
        addObject(contLlaves,110,30);
    }
}
