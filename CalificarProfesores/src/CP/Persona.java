
package CP;
import Archivo.A_Comentario;

public abstract class Persona 
{
    private String nombre;
    private String apellido;
    private int cedula;
    private String usuario;
    private String contraseña;
    
    Persona (String nombre, String apellido,int cedula, String usuario, String contrasenna)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.usuario = usuario;
        this.contraseña = contrasenna;
    }
    public abstract String comentar(String s,Lista l,int materia,int perfil,boolean b);
    public abstract String cargarNota(Lista l,int m,int p,int i_cedula,boolean b);
    //public abstract String setcomentario(String s,Lista l,int materia,int perfil,int comentario);
    protected abstract void setbloqueado(boolean b);
    public abstract boolean getbloqueado();

    public boolean compararContraseña(String contraseña)
    {
        if(this.getContraseña().compareTo(contraseña)==0)
            return true;
        else
            return false;
    }
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public void setApellido(String apellido)
    {
        this.apellido = apellido;
    }
    public void setCedula(int cedula)
    {
        this.cedula = cedula;
    }
    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }
    public void setContrasenna(String contrasenna)
    {
        this.contraseña = contrasenna;
    }
    public String getNombre()
    {
        return nombre;
    }
    public String getApellido()
    {
        return apellido;
    }
    public int getCedula()
    {
        return cedula;
    }
    public String getUsuario()
    {
        return usuario;
    }
    public String getContraseña() {
        return contraseña;
    }
}
