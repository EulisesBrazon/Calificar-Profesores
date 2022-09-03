package Archivo;
import CP.*;
import java.io.*;

public class A_Materia
{
    private FileWriter e_archivo;
    private PrintWriter e_buffer;
    private FileReader l_archivo;
    private BufferedReader l_buffer;
    private int contador;
    
    public A_Materia ()//, int tamañoPerfil)
    {
        try 
        {
            File directorioA=new File("archivo");
            File directorioL=new File("archivo/lista");
            if(!directorioA.exists())//si el directorio no exite
            {
                directorioA.mkdir();//lo crea
                mostrar("Se creo el directorio "+directorioA.getName());
            }  
            
            if(!directorioL.exists())//si el directorio no exite
            {
                directorioL.mkdir();//lo crea
                mostrar("Se creo el directorio "+directorioL.getName());
            }               
            
            File archivo=new File(directorioL,"materias.txt");

            
            if(!archivo.exists())
            {
                archivo.createNewFile();
                mostrar("Se creo el archivo "+archivo.getName());
            }
            this.contador=getTamaño();
            
        } 
        catch (IOException error) 
        {
            mostrar(error.getMessage());
        }
    }
    public int getTamaño()
    {
        String linea;
        int contadorLinea=0;
        
        try 
        {
            l_archivo = new FileReader("archivo/lista/materias.txt");
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
    
    public void guardarMateria(String nombreMateria)
    {
        
        try
        {
            e_archivo = new FileWriter("archivo/lista/materias.txt", true);
            e_buffer = new PrintWriter(e_archivo);
            
            e_buffer.println(nombreMateria+" "+contador);
            contador++;
            //crea un nuevo directorio y archivo para el arreglo de perfiles
            File directorio=new File("archivo/lista/"+nombreMateria);
            
            if(!directorio.exists())
            {
                directorio.mkdir();//lo crea
                mostrar("Se creo el directorio "+directorio.getName());
            }
            File archivo=new File(directorio,nombreMateria+".txt");
            
            if(!archivo.exists())
            {
                archivo.createNewFile();
                mostrar("Se creo el archivo "+archivo.getName());
            }
            e_archivo.close();
        } 
        catch(IOException error) 
        {
            mostrar(error.getMessage());
        }
        
    }
    
    public int buscarPosicion(String nombreMateria)
    {
        String linea;
        String nombre;
        String numero;
        int existe = 0;
        try {
            
            l_archivo = new FileReader("archivo/lista/materias.txt");
            l_buffer = new BufferedReader(l_archivo);
            
            while((linea = l_buffer.readLine()) != null)
            {
               nombre=linea.substring(0, linea.indexOf(" "));
               numero= linea.substring(linea.indexOf(" ")+1);
               
               if(nombre.equals(nombreMateria))
                   return Integer.parseInt(numero);                 
            } 
            l_archivo.close();
        } 
        catch (IOException error) 
        {
            mostrar(error.getMessage());
        }
        return -1;
    }
    
    public String buscarNombre(int posicion)
    {
        String linea;
        String nombre;
        String numero;
        int existe = 0;
        try {
            
            l_archivo = new FileReader("archivo/lista/materias.txt");
            l_buffer = new BufferedReader(l_archivo);
            while((linea = l_buffer.readLine()) != null)
            {
               nombre=linea.substring(0, linea.indexOf(" "));
               numero= linea.substring(linea.indexOf(" ")+1);
               
               if(Integer.parseInt(numero)==posicion)
                   return nombre;                 
            }   
            l_archivo.close();
        } 
        catch (IOException error) 
        {
            mostrar(error.getMessage());
        }
        return " ";
    }
    
    public void editar(String nombreMateria,String nuevoNombreMateria)
    {
        String [] datos = new String[contador];
        String linea;
        String nombre;
        
        
        int contadorPosicion = -1;
        try 
        {
            
            l_archivo = new FileReader("archivo/lista/materias.txt");
            l_buffer = new BufferedReader(l_archivo);
            
            while((linea = l_buffer.readLine()) != null)
            {
               nombre=linea.substring(0, linea.indexOf(" "));
                contadorPosicion++;
                if(nombre.equals(nombreMateria)){ // se cambia el contenido
                    datos[contadorPosicion] = nuevoNombreMateria;
                }
                else
                { // si no se deja igual
                    datos[contadorPosicion] = nombre;
                }
            }
            l_archivo.close();
            
            e_archivo = new FileWriter("archivo/lista/materias.txt", false);
            e_buffer = new PrintWriter(e_archivo);
            
            for(int contadorP = 0; contadorP < contadorPosicion+1; contadorP++)
            {
                e_buffer.println(datos[contadorP]+" "+contadorP);
            }           
            e_archivo.close();
        } catch (IOException error) {
            mostrar(error.getMessage());
        }
    }
    
    public void eliminar(String nombreMateria)
    {
        String [][] datos = new String[contador][2];
        String linea;
        String nombre;
           
        int contadorPosicion = -1;
        try 
        {
            
            l_archivo = new FileReader("archivo/lista/materias.txt");
            l_buffer = new BufferedReader(l_archivo);
            mostrar(l_buffer.readLine());
            
            while((linea = l_buffer.readLine()) != null)
            {
               nombre=linea.substring(0, linea.indexOf(" "));   
               mostrar(!nombre.equals(nombreMateria));
                if(!nombre.equals(nombreMateria))
                { // no se guarda
                    contadorPosicion++;
                    datos[contadorPosicion][0] = nombre;
                }
            }
            l_archivo.close();
            e_archivo = new FileWriter("archivo/lista/materias.txt", false);
            e_buffer = new PrintWriter(e_archivo);
           
            for(int contadorP = 0; contadorP < contadorPosicion+1; contadorP++)
            {
                e_buffer.println(datos[contadorP][0]+" "+contadorP);
            }
            e_archivo.close();
        } catch (IOException error)
        {
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
