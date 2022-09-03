package CP;

public class Comentario 
{
    
    private String comentario;
    private String fecha;
    private String hora;
    private int cedula;
    private boolean modificado=false;

    
    protected Comentario (String texto,int cedula,String fecha,String hora,boolean modificado)
    {
        this.fecha=fecha;
        this.hora=hora;
        this.modificado=modificado;
        this.comentario = texto;
        this.cedula=cedula;
        fecha=Fecha.setFecha();
        hora=Fecha.setHora();
    }
    public Comentario (String texto,int cedula)
    {
        this.comentario = texto;
        this.cedula=cedula;
        fecha=Fecha.setFecha();
        hora=Fecha.setHora();
    }
    public String  setComentario(String textoDelComentario,int cedula)
    {
        if(this.cedula==cedula)
        {
            comentario=textoDelComentario;
            fecha=Fecha.setFecha();
            hora=Fecha.setHora();
            modificado=true;
            return "carga exitosa";
        }
        return "carga fallida";
    }
    public String getComentario()
    {
        return comentario;
    }
    public String getFecha()
    {
        return fecha;
    }
    public String getHora()
    {
        return hora;
    }
    public int getCedula()
    {
        return cedula;
    } 
    public boolean getModificado()
    {
        return modificado;
    }  
}

