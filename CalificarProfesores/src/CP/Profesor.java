package CP;
import Archivo.A_Comentario;

public class Profesor extends Persona 
{
    public Profesor(String nombre, String apellido,int cedula, String usuario, String contrasenna)
    {
        super(nombre,apellido,cedula,usuario,contrasenna);
    }
    public String comentar(String s,Lista l,int materia,int perfil,boolean b)
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
    public String cargarNota(Lista l,int m,int p,int cedula,boolean b)
    {
        if(l.getMateria(m).getPerfil(p).compararCedulaProfesor(getCedula())==true)
        {
            l.getMateria(m).getPerfil(p).cargarAlumnoAprobado(cedula,l.getMateria(m).getNombreM(),b);
            return "carga exitosa";
        }
        return "datos incorrectos";
    }

    protected void setbloqueado(boolean b){}
    public boolean getbloqueado(){return false;}
}
 