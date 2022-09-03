
package CP;
public class Admin 
{
    private String usuario;
    private String contrasenna;
    private Lista lista;
    
    public Admin(String usuario,String contrasenna,Lista lista)
    {
        this.lista=lista;
        this.usuario=usuario;
        this.contrasenna=contrasenna;
    }
    public boolean compararUsuario(String usuario)
    {
        if(this.usuario.equals(usuario)==true)
            return true;
        return false;
    }
    public boolean compararContrasenna(String contrasenna)
    {
        if(this.contrasenna.equals(contrasenna)==true)
            return true;
        return false;
    }
//    public void setCodigoValidacio(Registro r, String codigo)
//    {
//        r.setCodigoValidacio(codigo);
//    }
    public String bloqueadoAlumno(Registro r,int cedula,boolean b)
    {
        int aux;
        if(r.buscarCedula(cedula)!=-1)
        {
            if(r.getPersona(r.buscarCedula(cedula)).getClass().getSimpleName().equals("Profesor"))
                return "Es un profesor y no puede ser bloqueado";
            else
            {
                r.getPersona(r.buscarCedula(cedula)).setbloqueado(b);
                if(b)
                    return "El Alumno está bloqueado";
                else 
                    return "El Alumno está desbloqueado";
            }
                
        }
        return "no se encontraron coincidencias";
    }
    public String cargarMateria(String nombreDeMateria,boolean b)//,int tamannoPerfil)
    {
        return lista.cargarMateria(nombreDeMateria,b);//, tamannoPerfil);
    }
    public String setPerfil(int materia, String nombreProfesor, String descripcion,int tamannoAlumnoAprobado,int cedulaProfesor,boolean b)
    {
        return lista.getMateria(materia).cargarPerfil(nombreProfesor, descripcion,lista.getMateria(materia).getNombreM(), /*tamannoAlumnoAprobado,*/ 5,cedulaProfesor,b);

    }
    public void setUsuario(String s)
    {
        usuario=s;
    }
    public void setContrasenna(String c)
    {
        contrasenna=c;
    }            
}