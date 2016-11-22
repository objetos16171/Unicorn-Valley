/**
 * Write a description of class Tecla here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tecla  
{
    // instance variables - replace the example below with your own
    private String dir;
    private int id;
    private int band;

    /**
     * Constructor for objects of class Tecla
     */
    public Tecla()
    {
               
    }
    public Tecla(String direccion, int identificador)
    {
        dir=direccion;
        id=identificador;  
        band=0;
    }
    public int getId(){
        return id;
    }
    public String getDireccion(){
        return dir;
    }
    public void setBand(int n){
        band=n;
    }  
    public int getBand(){
        return band;
    }
}
