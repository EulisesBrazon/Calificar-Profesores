package CP;
import Archivo.A_Materia;

public class Materia
{
    private String nombreM;
    private Perfil perfil[]=new Perfil[20];
    private int contadorPerfil=0;
    
    public Materia(String nombreMateria,boolean b)//, int tamannoPerfil)
    {
        this.nombreM=nombreMateria;
        if(b)
        {
            A_Materia archivo=new A_Materia();
            archivo.guardarMateria(nombreMateria);
        }
//        perfil=new Perfil[tamannoPerfil];
    }
    protected String cargarPerfil(String nombreProfesor, String descripcion,String nombreMateria,/*int tamannoAlumnoAprobado,*/int promedioAux, int cedulaProfesor, boolean b)
    {
        if(contadorPerfil<perfil.length)
        {

            perfil[contadorPerfil]=new Perfil(nombreProfesor, descripcion,nombreMateria,/*tamannoAlumnoAprobado,*/promedioAux,cedulaProfesor,b);
            contadorPerfil++;
            return "Carga de profesor exitoso";
        }
        return "No hay espacio para cargar el profesor";
    }
    public void setNombreM(String nombreMateria)
    {
        nombreM=nombreMateria;
    }
    public String getNombreM()
    {
        return nombreM;
    }
    public int getContadorP()
    {
        return contadorPerfil;
    }
    public Perfil getPerfil(int posicionDePerfil)
    {
        return perfil[posicionDePerfil];
    }
}
