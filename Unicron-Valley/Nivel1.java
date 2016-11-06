import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Nivel1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel1 extends World
{
    Unicornio unicornio;
    Portal portal1;
    Portal portal2;
    Portal portal;
    
    /**
     * Constructor for objects of class Nivel1.
     */
    public Nivel1()
    {    
        super(800, 600, 1);
        unicornio = new Unicornio();
        portal1 = new Portal();
        portal2 = new Portal();
        portal = new Portal();
        addObject(unicornio,60,500);
        addObject(portal1,60,100);
        addObject(portal2,600,100);
        addObject(portal,610,400);
    }
    
    public void act()
    {
        unicornio.mueve();
    }
    
    /**
     * Cambia la ubicacíon del unicornio
     * @author Carlos Almendarez
     * @version 4-11-16
     * @return No hay valor 
     * @param int x la coordenada del portal que acciono el usuario
     */
    public void teleport(int x)
    {
        Portal p;
        int a;
        List L;
        L=getObjects(Portal.class);
        
        a=Greenfoot.getRandomNumber(L.size());
        p=(Portal)L.get(a);
        if(p.getX()!=x) //validacion para que no salga por el mismo portal
        {
           unicornio.setLocation(p.getX()+110,p.getY());
        }
    }
    
    /**
     * Obtiene el valor de la anchura del mundo
     * @author Carlos Almendarez
     * @version 4-11-16
     * @return Width 
     * @param No hay parametro de entrada
     */
    public int getAnc()
    {
        return getWidth();
    }
    
    /**
     * Obtiene el valor de la altura del mundo
     * @author Carlos Almendarez
     * @version 4-11-16
     * @return Height 
     * @param No hay parametro de entrada
     */
    public int getAltura()
    {
        return getHeight();
    }
}
