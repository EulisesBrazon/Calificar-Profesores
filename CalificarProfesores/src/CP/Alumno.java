package CP;
import Archivo.A_Comentario;

public class Alumno extends Persona 
{
    private boolean bloqueado=false;
    public Alumno(String nombre, String apellido,int cedula, String usuario, String contrasenna)
    {
        super(nombre,apellido,cedula,usuario,contrasenna);
    }
    protected Alumno(String nombre, String apellido,int cedula, String usuario, String contrasenna,boolean bloqueado)
    {
        super(nombre,apellido,cedula,usuario,contrasenna);
        this.bloqueado=bloqueado;
    }
    public String comentar(String s,Lista l,int materia,int perfil,boolean b)
    {
 
        if(!bloqueado)
        {
            l.getMateria(materia).getPerfil(perfil).cargarComentario(s, getCedula());

            if(b)
            {
                A_Comentario archivo=new A_Comentario(l.getMateria(materia).getNombreM(),
                    Integer.toString(l.getMateria(materia).getPerfil(perfil).getCedulaProfesor()));
                
                archivo.guardarComentario(l.getMateria(materia).getPerfil(perfil).getComentario(super.getCedula()));
            }
            return "comentario exitoso";
            
        }
        return "comentario fallido";         

        
    }
    public void setbloqueado(boolean b)
    {
        bloqueado=b;
    }
    public boolean getbloqueado()
    {
        return bloqueado;
    }
    public String cargarNota(Lista l,int m,int p,int calificacion,boolean b)
    {
        if(bloqueado==false)
        {
            l.getMateria(m).getPerfil(p).cargarPromedio(calificacion,getCedula(),l.getMateria(m).getNombreM(),b);
            return "carga exitosa";
        }
        return "carga fallida";
    }
}