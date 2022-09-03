package Interface;
import Archivo.*;
import CP.*;
import java.io.*;

public class Main
{
    
    public static void main(String[] args)
    {        
        I_VentanaPrincipal a = new I_VentanaPrincipal(new CalificarProfesor("admin","1234",new Lista(),new Registro("1234")));    
    }
}
