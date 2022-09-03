package CP;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Fecha
{

    	
    public static String setFecha()
    {
        Date f = new Date();
        SimpleDateFormat formatoF = new SimpleDateFormat("dd/mm/yyyy");
        
        return formatoF.format (f);
    }
    
    public static String setHora()
    {
       Date h = new Date();
       SimpleDateFormat formatoH = new SimpleDateFormat("hh:mm a");
        
       return formatoH.format (h);
    }
}



