package CP;
import Archivo.*;
public class CalificarProfesor 
{
    private Admin administrador;
    private Lista lista;
    private Registro registro;
    private Posicion posicion;
    private String usuario;
    private String cedula;
    
    public CalificarProfesor (String usuario,String contrasenna, Lista lista, Registro registro)
    {
        this.usuario= " ";
        this.posicion=new Posicion(-1,-1,-1);
        this.lista = lista;
        this.administrador = new Admin(usuario, contrasenna, this.lista);
        this.registro = registro;      
    }
    public void setUser(String usuario)
    {
        this.usuario=usuario;
    }
    public String getUser()
    {
        return usuario;
    }
    public void setPosicion(int materia,int perfil, int comentario)
    {
        this.posicion.setMateria(materia);
        this.posicion.setPerfil(perfil);
        this.posicion.setComentario(comentario);
    }
    public int getPosicionMateria()
    {
        return posicion.getMateria();
    }
    public int getPosicionPerfil()
    {
        return posicion.getPerfil();
    }
    public int getPosicionComentario()
    {
        return posicion.getComentario();
    }
    public String cargarPeffil(String nombreProfesor, String descripcion,int cedulaProfesor,boolean b)
    {
        if(administrador.compararUsuario(usuario)==true)
            return administrador.setPerfil(posicion.getMateria(), nombreProfesor, descripcion, cedulaProfesor,cedulaProfesor,b);
        return "Debe ser administrador";
    }
    public Materia getMateria()
    {
        return lista.getMateria(posicion.getMateria());
    }
    public Perfil getPerfil()
    {
        return lista.getMateria(posicion.getMateria()).getPerfil(posicion.getPerfil());
    }
    public Perfil getPerfil(int i)
    {
        return lista.getMateria(posicion.getMateria()).getPerfil(i);
    }
    public String getCedula()
    {
        return cedula;
    }
    public void setCedula(String cedula)
    {
        this.cedula=cedula;
    }
    public Admin getAdmin() 
    {
        return administrador;
    }
    public void setAdmin(Admin admin) 
    {
        this.administrador = admin;
    }
    public Lista getLista() 
    {
        return lista;
    }
    public void setLista(Lista lista)
    {
        this.lista = lista;
    }
    public Registro getRegistro() 
    {
        return registro;
    }
    public void setRegistro(Registro registro)
    {
        this.registro = registro;
    } 
    public String comentar(String comentario)
    {
        return registro.getPersona(registro.buscarCedula(Integer.parseInt(usuario)))
                .comentar(comentario, lista, posicion.getMateria(), posicion.getPerfil(), true);
    }
    public String cargarMateria(String nombreMateria,boolean b)//,int numeroProfesores)
    {
        return lista.cargarMateria(nombreMateria,b);//, numeroProfesores);
    }
    public int buscarCedulaRegistro(int cedula)
    {
        return registro.buscarCedula(cedula);
    }
    public int buscarUsuarioRegistro(String usuario)
    {
        return registro.buscarUsuario(usuario);
    }
    public boolean compararCodigoValidacion(String codigo)
    {
        return registro.compararCV(codigo);
    }
    public void registrarAlumno(String nombre,String apellido,int cedula,String usuario,String contraseña,boolean b)
    {
        registro.registrar(new Alumno(nombre,apellido,cedula,usuario,contraseña), b);
    }
    public void registrarProfesor(String codigoValidacion,String nombre,String apellido,int cedula,String usuario,String contraseña,boolean b)
    {
        registro.registrar(codigoValidacion,new Profesor(nombre,apellido,cedula,usuario,contraseña), b);
    }
    public Persona getUsuario()
    {
        return registro.getPersona(registro.buscarCedula(Integer.parseInt(this.usuario)));
    }
    public Persona getPersona()
    {
        return registro.getPersona(registro.buscarCedula(Integer.parseInt(this.cedula)));
    }
    public int buscarCedula(int cedula)
    {
        return registro.buscarCedula(cedula);
    }
    public void buscarCedulaLista()
    {
        
    }
    public boolean compararContrseña(String contraseña)
    {
        return registro.getPersona(registro.buscarCedula(Integer.parseInt(usuario))).compararContraseña(contraseña);
    }
    public ListaComentario getlComentario()
    {
        //cp.getLista().getMateria(cp.getPosicionMateria()).getPerfil(cp.getPosicionPerfil()).getlComentario().getPrimerNodo()
        return lista.getMateria(posicion.getMateria()).getPerfil(posicion.getPerfil()).getlComentario();
    }
    public String cargarNotar(int calificacion,boolean b)
    {
        return getUsuario().cargarNota(lista, posicion.getMateria(), posicion.getPerfil(), calificacion, b);
    }
    public void importarA_Materia()
    {
        
        int i;
        A_Materia archivo = new A_Materia();
        if(lista.getContadorM()!=archivo.getTamaño())
        {               
            for(i=0;i<archivo.getTamaño();i++)
            {
                lista.cargarMateria(archivo.buscarNombre(i), false);        
            }
        }
    }
    public void importarA_Perfil(boolean todo)
    { 
        int i;
        A_Perfil archivo = new A_Perfil(lista.getMateria(posicion.getMateria()).getNombreM());
        if(lista.getMateria(posicion.getMateria()).getContadorP()!=archivo.getTamañoPerfil())
        {               
            for(i=0;i<archivo.getTamañoPerfil();i++)
            {
                String atributo = archivo.buscarAtributosPerfil(i);
                String cedulaA=atributo.substring(0, atributo.indexOf("&"));
                atributo = atributo.substring(atributo.indexOf("&")+1);
                String nombre = atributo.substring(0, atributo.indexOf("&"));
                atributo = atributo.substring(atributo.indexOf("&")+1);
                String descripcion = atributo.substring(0, atributo.indexOf("&"));
                atributo = atributo.substring(atributo.indexOf("&")+1);
                String promedio = atributo.substring(0, atributo.indexOf("&"));
                lista.getMateria(posicion.getMateria()).cargarPerfil(nombre, descripcion, getMateria().getNombreM(),
                        Integer.parseInt(promedio),Integer.parseInt(cedulaA), false);
                
            }
        }
        if(todo)
        {
            if(archivo.getTamañoAlumnosAprobados(getPerfil())!=getPerfil().getContadorAlumnoAprobado())
            {
                int j;
                for(j=0;j<archivo.getTamañoAlumnosAprobados(getPerfil());j++)
                {
                    getPerfil().cargarAlumnoAprobado(Integer.parseInt(archivo.buscarAtributoAlumnosAprobado(getPerfil(), j)), 
                        getMateria().getNombreM(), false);
                }
                for(j=0;j<archivo.getTamañoAlumnosYaComentado(getPerfil());j++)
                {
                    getPerfil().cargarAlumnoYaCalificado(Integer.parseInt(archivo.buscarAtributoYaComentado(getPerfil(), j)), 
                        getMateria().getNombreM(), false);
                }
                for(j=0;j<archivo.getTamañoPromedio(getPerfil());j++)
                {
                    getPerfil().cargarPromedio(Integer.parseInt(archivo.buscarPromedio(getPerfil(), j)));
                }    
            }
        }
    }
    public void importarA_Comentario()
    {
        int i;
        A_Comentario archivo = new A_Comentario(lista.getMateria(posicion.getMateria()).getNombreM(),
                Integer.toString(lista.getMateria(posicion.getMateria()).getPerfil(posicion.getPerfil()).getCedulaProfesor()));
        
        if(lista.getMateria(posicion.getMateria()).getPerfil(posicion.getPerfil()).getlComentario().getTamaño()!=archivo.getTamaño())
        {               
            for(i=0;i<archivo.getTamaño();i++)
            {
                String linea;
                String cedulaC;
                String descripcion;
                String fecha;
                String hora;
                String modificado;
                
                linea = archivo.buscarAtributos(i);
                cedulaC=linea.substring(0, linea.indexOf("&"));
                linea = linea.substring(linea.indexOf("&")+1);
                descripcion = linea.substring(0, linea.indexOf("&"));
                linea = linea.substring(linea.indexOf("&")+1);
                fecha = linea.substring(0, linea.indexOf("&"));
                linea = linea.substring(linea.indexOf("&")+1);
                hora = linea.substring(0, linea.indexOf("&"));
                linea = linea.substring(linea.indexOf("&")+1);
                modificado = linea.substring(0, linea.indexOf("&"));
                lista.getMateria(posicion.getMateria()).getPerfil(posicion.getPerfil())
                        .cargarComentario(descripcion,Integer.parseInt(cedulaC),fecha,hora,modificado.equals("true"));
            }
        }
    }
    public void importarA_Registro()
    {
        int i;
        A_Registro archivo = new A_Registro();
        
        if(registro.getTamañoAlumno()!=archivo.getTamañoAlumno())
        {               
            for(i=0;i<archivo.getTamañoAlumno();i++)
            {
                String atributo = archivo.buscarAtributoAlumno(i);
                String cedulaA=atributo.substring(0, atributo.indexOf("&"));
                atributo = atributo.substring(atributo.indexOf("&")+1);
                String nombre = atributo.substring(0, atributo.indexOf("&"));
                atributo = atributo.substring(atributo.indexOf("&")+1);
                String apellido = atributo.substring(0, atributo.indexOf("&"));
                atributo = atributo.substring(atributo.indexOf("&")+1);
                String usuarioA = atributo.substring(0, atributo.indexOf("&"));
                atributo = atributo.substring(atributo.indexOf("&")+1);
                String contraseña = atributo.substring(0, atributo.indexOf("&"));
                atributo = atributo.substring(atributo.indexOf("&")+1);
                String bloqueado = atributo.substring(0, atributo.indexOf("&"));        
                
                Alumno alumno=new Alumno(nombre, apellido,Integer.parseInt(cedulaA), usuarioA, contraseña, bloqueado.equals("true"));
                registro.registrar(alumno, false);
            }
        }
        if(registro.getTamañoProfesor()!=archivo.getTamañoProfesor())
        {               
            for(i=0;i<archivo.getTamañoProfesor();i++)
            {
                String atributo = archivo.buscarAtributoProfesor(i);
                String cedulaP=atributo.substring(0, atributo.indexOf("&"));
                atributo = atributo.substring(atributo.indexOf("&")+1);
                String nombre = atributo.substring(0, atributo.indexOf("&"));
                atributo = atributo.substring(atributo.indexOf("&")+1);
                String apellido = atributo.substring(0, atributo.indexOf("&"));
                atributo = atributo.substring(atributo.indexOf("&")+1);
                String usuarioP = atributo.substring(0, atributo.indexOf("&"));
                atributo = atributo.substring(atributo.indexOf("&")+1);
                String contraseña = atributo.substring(0, atributo.indexOf("&"));       
                
                Profesor profesor=new Profesor(nombre, apellido,Integer.parseInt(cedulaP), usuarioP, contraseña);
                registro.registrar(profesor, false);
            }
        }
    }
                 
}
