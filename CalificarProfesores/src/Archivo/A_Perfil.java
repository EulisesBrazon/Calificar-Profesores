package Archivo;
import CP.*;
import java.io.*;

public class A_Perfil
{
    private FileWriter e_archivo;
    private PrintWriter e_buffer;
    private FileReader l_archivo;
    private BufferedReader l_buffer;
    private String nombreMateria;
    private int contador;
    
    public A_Perfil (String nombreMateria)//, int tamañoPerfil)
    {
        this.nombreMateria=nombreMateria;
        try 
        {
            
            File archivo=new File("archivo/lista/"+nombreMateria+"/"+nombreMateria+".txt");

            if(!archivo.exists())
            {
                archivo.createNewFile();
                mostrar("Se creo el archivo "+archivo.getName());
            }
            this.contador=getTamañoPerfil();
            
        } 
        catch (IOException error) 
        {
            mostrar(error.getMessage());
        }
    }
    public int getTamañoPerfil()
    {
        String linea;
        int contadorLinea=0;
        
            try {             
                l_archivo = new FileReader("archivo/lista/"+nombreMateria+"/"+nombreMateria+".txt");
                l_buffer = new BufferedReader(l_archivo);
            while((linea = l_buffer.readLine()) != null)
            {
               contadorLinea++;               
            }
            l_archivo.close();
        } catch (IOException error) {
            mostrar(error.getMessage());
        }
        return contadorLinea;
    }
    public int getTamañoAlumnosAprobados(Perfil perfil)
    {
        String linea;
        int contadorLinea=0;
        
            try {             
                l_archivo = new FileReader("archivo/lista/"+nombreMateria+"/"+perfil.getCedulaProfesor()+"/Alumnos aprobados.txt");
                l_buffer = new BufferedReader(l_archivo);
            while((linea = l_buffer.readLine()) != null)
            {
               contadorLinea++;               
            }
            l_archivo.close();
        } catch (IOException error) {
            mostrar(error.getMessage());
        }
        return contadorLinea;
    }
    public int getTamañoAlumnosYaComentado(Perfil perfil)
    {
        String linea;
        int contadorLinea=0;
        
            try {             
                l_archivo = new FileReader("archivo/lista/"+nombreMateria+"/"+perfil.getCedulaProfesor()+"/Alumnos que ya comentaron.txt");
                l_buffer = new BufferedReader(l_archivo);
            while((linea = l_buffer.readLine()) != null)
            {
               contadorLinea++;               
            }
            l_archivo.close();
        } catch (IOException error) {
            mostrar(error.getMessage());
        }
        return contadorLinea;
    }
        public int getTamañoPromedio(Perfil perfil)
    {
        String linea;
        int contadorLinea=0;
        
            try {             
                l_archivo = new FileReader("archivo/lista/"+nombreMateria+"/"+perfil.getCedulaProfesor()+"/Promedio.txt");
                l_buffer = new BufferedReader(l_archivo);
            while((linea = l_buffer.readLine()) != null)
            {
               contadorLinea++;               
            }
            l_archivo.close();
        } catch (IOException error) {
            mostrar(error.getMessage());
        }
        return contadorLinea;
    }
    
    public void guardarPerfil(Perfil perfil)
    {
        try
        {
            e_archivo = new FileWriter("archivo/lista/"+nombreMateria+"/"+nombreMateria+".txt", true);
            e_buffer = new PrintWriter(e_archivo);
            
            e_buffer.println(Integer.toString(perfil.getCedulaProfesor())+"&"+perfil.getNombreProfesor()+"&"+perfil.getDescripcion()+"&"+
                perfil.getPromedio()+"&"+contador);//carga el nombre y la posicion          
             contador++;
            
            File directorio=new File("archivo/lista/"+nombreMateria+"/"+perfil.getCedulaProfesor());
            
            if(!directorio.exists())
            {
                directorio.mkdir();//lo crea
               mostrar("Se creo el directorio "+directorio.getName());
            }
            e_buffer.close();
        }   
        catch(IOException error) 
        {
            mostrar(error.getMessage());
        }
      
    }
    public void guardarPromedio(Perfil perfil)
    {
        try
        {
            File archivo=new File("archivo/lista/"+nombreMateria+"/"+perfil.getCedulaProfesor()+"/Promedio.txt");
            contador++;
            if(!archivo.exists())
            {
                archivo.createNewFile();
                mostrar("Se creo el archivo "+archivo.getName());
            }
            e_archivo= new FileWriter(archivo, true);
            e_buffer = new PrintWriter(e_archivo);
            
            for(int i=0;i<perfil.getcontadorPromedio();i++)
            {
                e_buffer.println(Integer.toString(perfil.getPromedio(i)));
            }
            e_buffer.close();
            editarPerfil(perfil);
            
        }
        catch(IOException error) 
        {
            mostrar(error.getMessage());
        }           
    }
    public void guardarAlumnoAprobado(Perfil perfil)
    {
        try
        {
            File archivo=new File("archivo/lista/"+nombreMateria+"/"+perfil.getCedulaProfesor()+"/Alumnos aprobados.txt");
            if(!archivo.exists())
            {
                archivo.createNewFile();
                mostrar("Se creo el archivo "+archivo.getName());
            }
            e_archivo= new FileWriter(archivo, true);
            e_buffer = new PrintWriter(e_archivo);
            
            for(int i=0;i<perfil.getContadorAlumnoAprobado();i++)
            {
                e_buffer.println(Integer.toString(perfil.getAlumnoAprobado(i)));
            }
            e_buffer.close();
        }
        catch(IOException error) 
        {
            mostrar(error.getMessage());
        }           
    }
    public void guardarAlumnoYaComentado(Perfil perfil)
    {
        try
        {
            File archivoArreglo=new File("archivo/lista/"+nombreMateria+"/"+perfil.getCedulaProfesor()+"/Alumnos que ya comentaron.txt");
            if(!archivoArreglo.exists())
            {
                archivoArreglo.createNewFile();
                mostrar("Se creo el archivo "+archivoArreglo.getName());
            }
            e_archivo = new FileWriter(archivoArreglo, true);
            e_buffer = new PrintWriter(e_archivo);

            for(int i=0;i<perfil.getContadorAlumnoYaCalificado();i++)
            {
                e_buffer.println(Integer.toString(perfil.getAlumnoYaCalificado(i)));
            }
            e_buffer.close();
        }
        catch(IOException error) 
        {
            mostrar(error.getMessage());
        }           
    }
    public int buscarPosicionPerfil(int cedulaProfesor)
    {
        String linea;
        String nombre;
        int numero=-1;
        try {
            
            l_archivo = new FileReader("archivo/lista/"+nombreMateria+"/"+nombreMateria+".txt");
            l_buffer = new BufferedReader(l_archivo);
            
            while((linea = l_buffer.readLine()) != null)
            {
               nombre=linea.substring(0, linea.indexOf("&"));
               numero++;
               
               if(nombre.equals(Integer.toString(cedulaProfesor)))
                   return numero;                 
            } 
            l_archivo.close();
        } 
        catch (IOException error) 
        {
            mostrar(error.getMessage());
        }
        return -1;
    }
    
    public String buscarAtributosPerfil(int posicion)
    {
        String linea;
        String atributos;
        int contadorPosicion = -1;
        
        try {
            
            l_archivo = new FileReader("archivo/lista/"+nombreMateria+"/"+nombreMateria+".txt");
            l_buffer = new BufferedReader(l_archivo);
            while((atributos = l_buffer.readLine()) != null)
            {   
               contadorPosicion++;
               if(contadorPosicion==posicion)
                   return atributos;                 
            }  
            l_archivo.close();
        } 
        catch (IOException error) 
        {
            mostrar(error.getMessage());
        }
        return " ";
    }
        public String buscarAtributoAlumnosAprobado(Perfil perfil,int posicion)
    {
        String linea;
        String atributos;
        int contadorPosicion = -1;
        
        try {
            
            l_archivo = new FileReader("archivo/lista/"+nombreMateria+"/"+perfil.getCedulaProfesor()+"/Alumnos aprobados.txt");
            l_buffer = new BufferedReader(l_archivo);
            while((atributos = l_buffer.readLine()) != null)
            {   
               contadorPosicion++;
               if(contadorPosicion==posicion)
                   return atributos;                 
            }  
            l_archivo.close();
        } 
        catch (IOException error) 
        {
            mostrar(error.getMessage());
        }
        return " ";
    }
    public String buscarAtributoYaComentado(Perfil perfil,int posicion)
    {
        String linea;
        String atributos;
        int contadorPosicion = -1;
        
        try {
            
            l_archivo = new FileReader("archivo/lista/"+nombreMateria+"/"+perfil.getCedulaProfesor()+"/Alumnos que ya comentaron.txt");
            l_buffer = new BufferedReader(l_archivo);
            while((atributos = l_buffer.readLine()) != null)
            {   
               contadorPosicion++;
               if(contadorPosicion==posicion)
                   return atributos;                 
            }  
            l_archivo.close();
        } 
        catch (IOException error) 
        {
            mostrar(error.getMessage());
        }
        return " ";
    }
    public String buscarPromedio(Perfil perfil,int posicion)
    {
        String linea;
        String atributos;
        int contadorPosicion = -1;
        
        try {
            
            l_archivo = new FileReader("archivo/lista/"+nombreMateria+"/"+perfil.getCedulaProfesor()+"/Promedio.txt");
            l_buffer = new BufferedReader(l_archivo);
            while((atributos = l_buffer.readLine()) != null)
            {   
               contadorPosicion++;
               if(contadorPosicion==posicion)
                   return atributos;                 
            }  
            l_archivo.close();
        } 
        catch (IOException error) 
        {
            mostrar(error.getMessage());
        }
        return " ";
    }
    
    public void editarPerfil(Perfil perfil)
    {
        String [][] datos = new String[contador][4];
        String linea;
        String cedula;
        String nombre;
        String descripcion;
        String promedio;
        int contadorPosicion = -1;
        try 
        {
            
            l_archivo = new FileReader("archivo/lista/"+nombreMateria+"/"+nombreMateria+".txt");
            l_buffer = new BufferedReader(l_archivo);
            
            while((linea = l_buffer.readLine()) != null)
            {
                cedula=linea.substring(0, linea.indexOf("&"));
                linea = linea.substring(linea.indexOf("&")+1);
                nombre = linea.substring(0, linea.indexOf("&"));
                linea = linea.substring(linea.indexOf("&")+1);
                descripcion = linea.substring(0, linea.indexOf("&"));
                linea = linea.substring(linea.indexOf("&")+1);
                promedio = linea.substring(0, linea.indexOf("&"));
                contadorPosicion++;
                
                if(cedula.equals(Integer.toString(perfil.getCedulaProfesor())))
                { // se cambia el contenido
                    datos[contadorPosicion][0] = cedula;
                    datos[contadorPosicion][1] = perfil.getNombreProfesor();
                    datos[contadorPosicion][2] = perfil.getDescripcion();
                    datos[contadorPosicion][3] = Integer.toString(perfil.getPromedio());
                }
                else
                { // si no se deja igual
                    datos[contadorPosicion][0] = cedula;
                    datos[contadorPosicion][1] = nombre;
                    datos[contadorPosicion][2] = descripcion;
                    datos[contadorPosicion][3] = promedio;
                }
            }
            l_archivo.close();
            
            e_archivo = new FileWriter("archivo/lista/"+nombreMateria+"/"+nombreMateria+".txt", false);
            e_buffer = new PrintWriter(e_archivo);
            
            for(int contadorP = 0; contadorP < contadorPosicion+1; contadorP++)
            {
                e_buffer.println(datos[contadorP][0]+"&"+datos[contadorP][1]+"&"+datos[contadorP][2]+"&"+datos[contadorP][3]+"&"+contadorP);
            }
            e_archivo.close();
        } catch (IOException error) {
            mostrar(error.getMessage());
        }
    }
    
    public void eliminar(Perfil perfil)
    {
        String [][] datos = new String[contador][4];
        String linea;
        String cedula;
        String nombre;
        String descripcion;
        String promedio;
        int contadorPosicion = -1;
        try 
        {
            
            l_archivo = new FileReader("archivo/lista/"+nombreMateria+"/"+nombreMateria+".txt");
            l_buffer = new BufferedReader(l_archivo);
            
            while((linea = l_buffer.readLine()) != null)
            {
                cedula=linea.substring(0, linea.indexOf("&"));
                linea = linea.substring(linea.indexOf("&")+1);
                nombre = linea.substring(0, linea.indexOf("&"));
                linea = linea.substring(linea.indexOf("&")+1);
                descripcion = linea.substring(0, linea.indexOf("&"));
                linea = linea.substring(linea.indexOf("&")+1);
                promedio = linea.substring(0, linea.indexOf("&"));
                contadorPosicion++;
                
                if(!cedula.equals(Integer.toString(perfil.getCedulaProfesor())))
                {// si no se deja igual
                    datos[contadorPosicion][0] = cedula;
                    datos[contadorPosicion][1] = nombre;
                    datos[contadorPosicion][2] = descripcion;
                    datos[contadorPosicion][3] = promedio;
                }
                else
                {
                    File directorio=new File("archivo/lista/"+nombreMateria+"/"+perfil.getCedulaProfesor());
            
                    if(directorio.exists())
                    {
                        directorio.delete();//lo crea
                        mostrar("Se elimino el directorio "+directorio.getName());
                    }
                }
            }
            l_archivo.close();
            
            e_archivo = new FileWriter("archivo/lista/"+nombreMateria+"/"+nombreMateria+".txt", false);
            e_buffer = new PrintWriter(e_archivo);
            
            for(int contadorP = 0; contadorP < contadorPosicion; contadorP++)
            {
                e_buffer.println(datos[contadorP][0]+"&"+datos[contadorP][1]+"&"+datos[contadorP][2]+"&"+datos[contadorP][3]+"&"+contadorP);
            }
            e_archivo.close();
        } catch (IOException error) {
            mostrar(error.getMessage());
        }
    } 
    
    private void mostrar(String s)
    {
        System.out.println(s);
    }
        private void mostrar(boolean s)
    {
        System.out.println(s);
    }
}
