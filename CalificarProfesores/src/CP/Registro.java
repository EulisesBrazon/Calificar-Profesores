package CP;
import Archivo.A_Registro;
public class Registro 
{
    private Persona persona[]=new Persona[20];
    private String codigoValidacion;
    private int contadorPersona=0;

    
    public Registro(String codigoValidacion)
    {
        this.codigoValidacion=codigoValidacion;
        
    }
    public void registrar(String codigoValidacion,Profesor p,boolean b)
    {
        if(this.codigoValidacion.equals(codigoValidacion)==true)
        {

            persona[contadorPersona]=p;       
            if(b)
            {
                A_Registro archivo=new A_Registro();
                archivo.guardarProfesor(p);       
            }
            contadorPersona++;
        }
    }
    protected void registrar(Profesor p,boolean b)
    {
            persona[contadorPersona]=p;       
            if(b)
            {
                A_Registro archivo=new A_Registro();
                archivo.guardarProfesor(p);       
            }
            contadorPersona++;
;
    }
    public boolean compararCV(String codigo)
    {
        return this.codigoValidacion.equals(codigo);          
    }
    public void registrar(Alumno a,boolean b)
    {
        persona[contadorPersona]=a;
        if(b)
        {
            A_Registro archivo=new A_Registro();          
             archivo.guardarAlumno(a);       
        }
        contadorPersona++;

    }
    public String elimimiar(int cedula)
    {
        int i,j,cambio=0;
        for(i=0;i<contadorPersona&&cambio==0;i++)
        {
            if(persona[i].getCedula()==cedula)
            {
                for(j=i;j<contadorPersona;j++)
                {
                    persona[i]=persona[i+1];
                }
                return "eliminacion exitosa";
            }
        }
        return "eliminacion fallida";
    }
    public int buscarApellido(String apellido)
    {
        int i;
        for(i=0;i<contadorPersona;i++)
        {
            if(persona[i].getApellido().equals(apellido))
                return i;           
        }
        return -1;
    }
    public int buscarUsuario(String usuario)
    {
        int i;
        for(i=0;i<contadorPersona;i++)
        {
            if(persona[i].getUsuario().equals(usuario))
                return i;           
        }
        return -1;
    }
    public int buscarNombre(String nombre)
    {
        int i;
        for(i=0;i<contadorPersona;i++)
        {
            if(persona[i].getNombre().equals(nombre))
                return i;           
        }
        return -1;
    }
    public int buscarCedula(int cedula)
    {
        int i;
        for(i=0;i<contadorPersona;i++)
        {
            if(persona[i].getCedula()==cedula)
                return i;
        }
        return -1;
    }

    public int getcontador()
    {
        return contadorPersona;
    }
    public int getTamañoAlumno()
    {
        int i,contador;
        
        for(i=0,contador=0;i<contadorPersona;i++)
        {
            if(persona[i].getClass().getSimpleName().equals("Alumno"))
                contador++;       
        }
        return contador;
    }
    public int getTamañoProfesor()
    {
        int i,contador;
        
        for(i=0,contador=0;i<contadorPersona;i++)
        {
            if(persona[i].getClass().getSimpleName().equals("Profesor"))
                contador++;       
        }
        return contador;
    }
    public Persona getPersona(int posicion)
    {
        
        return persona[posicion];
    }
}
