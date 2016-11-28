/**
 * Write a description of class Tecla here.
 * 
 * @author Diana Carolina Huelga Huerta
 * @version 20-11-16
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
    /**
     * Constructor for objects of class Tecla
     * @param direccion recibe el nombre de la direccion 
     * @param identificador numero de direccion 1,2,3 ó 4
     */
    public Tecla(String direccion, int identificador)
    {
        dir=direccion;
        id=identificador;  
        band=0;
    }
    /**
     * devuelve el numero identificador de dicha tecla
     * @author Diana Huelga
     * @return id identificador de la tecla
     */
    public int getId(){
        return id;
    }
    /**
     * regresa el nombre de la direccion 
     * @author Diana Huelga
     * @return dir direccion de la tecla 
     */
    public String getDireccion(){
        return dir;
    }
    /**
     * modifica en valor de la bandera
     * @author Diana Huelga
     * @param nuevo valor de la bandera
     */
    public void setBand(int n){
        band=n;
    }  
}
