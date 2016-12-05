import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Botonmenu here.
 * 
 * @author Diana Huelga
 * @version 5-11-16
 */
public class Botonmenu extends Actor
{
    private Menu menu;
    
    public Botonmenu(){
        menu= new Menu();
    }
    /**
     * Act - do whatever the Botonmenu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     *@auhtor Diana Huelga
     *@version 5-11-16
    */
    public void act() 
    {
        MouseInfo m= Greenfoot.getMouseInfo();              
        if(m != null){
            if(Greenfoot.mouseClicked(this)){
                Greenfoot.setWorld(menu);                
            }
        }
    }    
    /**
     * @auhtor Diana huelga
     * @version 04-12-16
     */
    public void regresaMenu(){
        Greenfoot.setWorld(menu);
    }
}
