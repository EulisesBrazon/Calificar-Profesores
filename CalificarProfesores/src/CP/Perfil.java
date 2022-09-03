package CP;
import Archivo.A_Perfil;


public class Perfil 
{
    private String nombreProfesor;
    private int cedulaProfesor;
    private String descripcion;
    private ListaComentario lComentario;
    private int promedio[]=new int[20];
    private int promedioAux=5;
    private int contadorPromedio=0;
    private int alumnoAprobado[]=new int[20];
    private int contadorAlumnoAprobado=0;
    private int alumnoYaCalificado[]=new int[20];
    private int contadorAlumnoYaCalificado=0;
    
    public Perfil(String nombreProfesor, String descripcion,String nombreMateria,/*int tamannoAlumnoAprobado,*/int promedioAux, int cedulaProfesor,boolean b)
    {    
        this.promedioAux=promedioAux;
        this.cedulaProfesor=cedulaProfesor;
        lComentario = new ListaComentario();
        this.nombreProfesor=nombreProfesor;
        this.descripcion=descripcion;
        if(b)
        {
            A_Perfil archivo=new A_Perfil(nombreMateria);
            archivo.guardarPerfil(this);
        }
    }

    public Comentario getComentario(int cedula)
    {
        int i;
        ListaComentario aux = getlComentario();
        for(i=0;i<aux.getTamaño();i++,aux.setPrimerNodo(aux.getPrimerNodo().getSte()))
            if(aux.getPrimerNodo().getComentario().getCedula()==cedula)
                return aux.getPrimerNodo().getComentario();
        return null;
    }
    public void cargarAlumnoAprobado(int cedula,String nombreMateria,boolean b)
    {
        alumnoAprobado[getContadorAlumnoAprobado()]=cedula;
        contadorAlumnoAprobado++;
        if(b)
        {
            A_Perfil archivo=new A_Perfil(nombreMateria);
            archivo.guardarAlumnoAprobado(this);
        }
    }
    protected void cargarAlumnoYaCalificado(int cedula,String nombreMateria,boolean b)
    {
        alumnoYaCalificado[getContadorAlumnoYaCalificado()]=cedula;
        contadorAlumnoYaCalificado++;
        if(b)
        {
            A_Perfil archivo=new A_Perfil(nombreMateria);
            archivo.guardarAlumnoYaComentado(this);
        }
    }
     public String eliminarAlumnoAprobado(int cedula)
    {
        int i,j;
        for(i=0;i<getContadorAlumnoAprobado();i++)
        {
            if(alumnoAprobado[i]==cedula)
            {
                for(j=i;i<getContadorAlumnoAprobado();i++)
                {
                    alumnoAprobado[j]=alumnoAprobado[j+1];                   
                }
                contadorAlumnoAprobado--;
                return "eliminacion exitosa";
            }
        }
        return "no se encontro coincidencia";
    }
    public boolean compararCedulaProfesor(int cedula)
    {
        if(this.getCedulaProfesor()==cedula)
            return true;
        return false;
    }
    public boolean buscarCedulaAlumnoAprobado(int cedula)
    {
        int i;
        for(i=0;i<getContadorAlumnoAprobado();i++)
        {
            if(alumnoAprobado[i]==cedula)
                return true;
        } 
        return false;
    }
    
    public boolean buscarCedulaAlumnoYaCalificado(int cedula)
    {
        int i;
        for(i=0;i<getContadorAlumnoYaCalificado();i++)
        {
            if(this.alumnoYaCalificado[i]==cedula)
                return true;
        }  
        return false;
    }
//    public int buscarCedulaComentario(int cedula)
//    {
//        int i;
//        NodoComentario aux=lComentario.getPrimerNodo();
//        for(i=0;i<lComentario.getTamaño();i++)
//        {
//            if(lComentario.getPrimerNodo().getComentario().getCedula()==cedula)
//            {
//                lComentario.setPrimerNodo(aux);
//                return i;
//            }
//                
//            lComentario.setPrimerNodo(lComentario.getPrimerNodo().getSte());
//        }
//        lComentario.setPrimerNodo(aux);
//        int i;
//        ListaComentario aux = getlComentario();
//        for(i=0;i<aux.getTamaño();i++,aux.setPrimerNodo(aux.getPrimerNodo().getSte()))
//            if(aux.getPrimerNodo().getComentario().getCedula()==cedula)
//                return 1;
//        return -1;
//    }
    public int buscarCedulaComentario(int cedula)
    {
        int i;
        NodoComentario aux = getlComentario().getPrimerNodo();
        for(i=0;i<lComentario.getTamaño();i++)
        {
            if(aux.getComentario().getCedula()==cedula)
            {
                return i;
            }
            aux=aux.getSte();
               
        }
        return -1;
    }
    protected String cargarPromedio(int calificacion,int cedula,String nombreMateria,boolean b)
    {
        if(buscarCedulaAlumnoAprobado(cedula))
        {
            if(buscarCedulaAlumnoYaCalificado(cedula)==false)                
            {
                promedio[contadorPromedio]=calificacion;
                contadorPromedio++;
                cargarAlumnoYaCalificado(cedula,nombreMateria,b);
                if(b)
                {
                    A_Perfil archivo=new A_Perfil(nombreMateria);
                    archivo.guardarPromedio(this);    
                }
                return "carga exitosa";
            }
            return "Solo puedes calificar una vez";
        }
        return "carga fallida";
        
    }
    
    protected void cargarPromedio(int calificacion)
    {

        promedio[contadorPromedio]=calificacion;
        contadorPromedio++;  
    }
    protected String cargarComentario(String comentario,int cedula)
    {  
        NodoComentario nodo= new NodoComentario(new Comentario(comentario,cedula));
        lComentario.insertarPrimero(nodo);
        return "Carga del comentario exitoso";
    }
    protected String cargarComentario(String texto,int cedula,String fecha,String hora,boolean modificado)
    {  
        NodoComentario nodo= new NodoComentario(new Comentario(texto,cedula,fecha,hora, modificado));
        lComentario.insertarPrimero(nodo);
        return "Carga del comentario exitoso";
    }
    public void setNombreP(String nombreP)
    {
        this.nombreProfesor=nombreP;
    } 
    public void setDescripcion(String descripcion)
    {
        this.descripcion=descripcion;
    }
    public String getDescripcion()
    {
        return descripcion;
    }
    public String getNombreProfesor()
    {
        return nombreProfesor;
    }
    public int getPromedio()
    {
        int aux=0,i;
        if(contadorPromedio==0)
            return promedioAux;
        
        for(i=0;i<contadorPromedio;i++)
        {
            aux=aux+promedio[i];
        }
        return aux/contadorPromedio;
    }
    public int getPromedio(int i)
    {
        return promedio[i];
    }
    public int getcontadorPromedio()
    {
        return contadorPromedio;
    }
    public ListaComentario getlComentario() {
        return lComentario;
    }

    public int getAlumnoAprobado(int i)
    {
        return alumnoAprobado[i];
    }
    public int getCedulaProfesor() 
    {
        return cedulaProfesor;
    }

    public int getContadorAlumnoAprobado() 
    {
        return contadorAlumnoAprobado;
    }

    public int getAlumnoYaCalificado(int i) 
    {
        return alumnoYaCalificado[i];
    }

    public int getContadorAlumnoYaCalificado() 
    {
        return contadorAlumnoYaCalificado;
    }
}
