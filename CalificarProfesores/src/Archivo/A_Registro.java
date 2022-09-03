package Archivo;
import CP.*;
import java.io.*;

public class A_Registro
{
    private FileWriter e_archivo;
    private PrintWriter e_buffer;
    private FileReader l_archivo;
    private BufferedReader l_buffer;
    private int contadorA,contadorP;
    
    public A_Registro ()//, int tamañoPerfil)
    {
        try 
        {
            File directorio=new File("archivo");
            
            if(!directorio.exists())//si el directorio no exite
            {
                directorio.mkdir();//lo crea
                mostrar("Se creo el directorio "+directorio.getName());
            }  
            directorio=new File("archivo/registro");
            if(!directorio.exists())//si el directorio no exite
            {
                directorio.mkdir();//lo crea
                mostrar("Se creo el directorio "+directorio.getName());
            }                          
            File archivo=new File(directorio,"alumno.txt");
            
            if(!archivo.exists())
            {
                archivo.createNewFile();
                mostrar("Se creo el archivo "+archivo.getName());
            }            
            archivo=new File(directorio,"profesor.txt");
          
            if(!archivo.exists())
            {
                archivo.createNewFile();
                mostrar("Se creo el archivo "+archivo.getName());
            }
            this.contadorA=getTamañoAlumno();
            this.contadorP=getTamañoProfesor();
            
        } 
        catch (IOException error) 
        {
            mostrar(error.getMessage());
        }
    }
    public int getTamañoAlumno()
    {
        String linea;
        int contadorLinea=0;
        
        try 
        {             
            l_archivo = new FileReader("archivo/registro/alumno.txt");
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
    
    public int getTamañoProfesor()
    {
        String linea;
        int contadorLinea=0;
        
        try 
        {             
            l_archivo = new FileReader("archivo/registro/profesor.txt");
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
    
    public void guardarAlumno(Alumno  alumno)
    {
        try
        {
            e_archivo = new FileWriter("archivo/registro/alumno.txt", true);
            e_buffer = new PrintWriter(e_archivo);
            
            e_buffer.println(alumno.getCedula()+"&"+alumno.getNombre()+"&"+alumno.getApellido()+"&"+
                alumno.getUsuario()+"&"+alumno.getContraseña()+"&"+alumno.getbloqueado()+"&"+contadorA);  
            
            e_archivo.close();
            contadorA++;
                
        }   
        catch(IOException error) 
        {
            mostrar(error.getMessage());
        }     
    }
        public void guardarProfesor(Profesor  profesor)
    {
        try
        {
            e_archivo = new FileWriter("archivo/registro/profesor.txt", true);
            e_buffer = new PrintWriter(e_archivo);
            
            e_buffer.println(profesor.getCedula()+"&"+profesor.getNombre()+"&"+profesor.getApellido()+"&"+
                profesor.getUsuario()+"&"+profesor.getContraseña()+"&"+contadorP);  
            
            e_archivo.close();
            contadorP++;
        }   
        catch(IOException error) 
        {
            mostrar(error.getMessage());
        }     
    }
    
    public int buscarPosicionAlumno(int cedulaAlumno)
    {
        String linea;
        String nombre;
        int numero=-1;
        try {
            
            l_archivo = new FileReader("archivo/registro/alumno.txt");
            l_buffer = new BufferedReader(l_archivo);
            
            while((linea = l_buffer.readLine()) != null)
            {
               nombre=linea.substring(0, linea.indexOf("&"));
               numero++;
               
               if(nombre.equals(Integer.toString(cedulaAlumno)))
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
    public int buscarPosicionProfesor(int cedulaProfesor)
    {
        String linea;
        String nombre;
        int numero=-1;
        try {
            
            l_archivo = new FileReader("archivo/registro/profesor.txt");
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
    
    public String buscarAtributoAlumno(int posicionAlumno)
    {
        String atributo;
        int contadorPosicion = -1;
        
        try {
            
            l_archivo = new FileReader("archivo/registro/alumno.txt");
            l_buffer = new BufferedReader(l_archivo);
            while((atributo = l_buffer.readLine()) != null)
            {   
               contadorPosicion++;
               if(contadorPosicion==posicionAlumno)
                   return atributo;                 
            }  
            l_archivo.close();
        } 
        catch (IOException error) 
        {
            mostrar(error.getMessage());
        }
        return " ";
    }
    public String buscarAtributoProfesor(int posicionProfesor)
    {
        String atributo;
        int contadorPosicion = -1;
        
        try {
            
            l_archivo = new FileReader("archivo/registro/profesor.txt");
            l_buffer = new BufferedReader(l_archivo);
            while((atributo = l_buffer.readLine()) != null)
            {   
               contadorPosicion++;
               if(contadorPosicion==posicionProfesor)
                   return atributo;                 
            }  
            l_archivo.close();
        } 
        catch (IOException error) 
        {
            mostrar(error.getMessage());
        }
        return " ";
    }
    
    public void editarAlumno(Alumno alumno)
    {
        String [][] datos = new String[contadorA][6];
        String linea;
        String cedula;
        String nombre;
        String apellido;
        String usuario;
        String contraseña;
        String bloqueado;
        int contadorPosicion = -1;
        try 
        {
            
            l_archivo = new FileReader("archivo/registro/alumno.txt");
            l_buffer = new BufferedReader(l_archivo);
//            System.out.println(l_buffer.readLine());
            while((linea = l_buffer.readLine()) != null)
            {
                cedula=linea.substring(0, linea.indexOf("&"));
                linea = linea.substring(linea.indexOf("&")+1);
                nombre = linea.substring(0, linea.indexOf("&"));
                linea = linea.substring(linea.indexOf("&")+1);
                apellido = linea.substring(0, linea.indexOf("&"));
                linea = linea.substring(linea.indexOf("&")+1);
                usuario = linea.substring(0, linea.indexOf("&"));
                linea = linea.substring(linea.indexOf("&")+1);
                contraseña = linea.substring(0, linea.indexOf("&"));
                linea = linea.substring(linea.indexOf("&")+1);
                bloqueado = linea.substring(0, linea.indexOf("&"));
                contadorPosicion++;
                
                if(cedula.equals(Integer.toString(alumno.getCedula())))
                { // se cambia el contenido
                    datos[contadorPosicion][0] = Integer.toString(alumno.getCedula());
                    datos[contadorPosicion][1] = alumno.getNombre();
                    datos[contadorPosicion][2] = alumno.getApellido();
                    datos[contadorPosicion][3] = alumno.getUsuario();
                    datos[contadorPosicion][4] = alumno.getContraseña();
                    if(alumno.getbloqueado())
                        datos[contadorPosicion][5] = "true";
                    else 
                        datos[contadorPosicion][5] = "false";
                }
                else
                { // si no se deja igual
                    datos[contadorPosicion][0] = cedula;
                    datos[contadorPosicion][1] = nombre;
                    datos[contadorPosicion][2] = apellido;
                    datos[contadorPosicion][3] = usuario;
                    datos[contadorPosicion][4] = contraseña;
                    datos[contadorPosicion][5] = bloqueado;
                }
            }
            l_archivo.close();
            
            e_archivo = new FileWriter("archivo/registro/alumno.txt", false);
            e_buffer = new PrintWriter(e_archivo);
            
            for(int contador = 0; contador < contadorPosicion+1; contador++)
            {
                e_buffer.println(datos[contador][0]+"&"+datos[contador][1]+"&"+datos[contador][2]+"&"+datos[contador][3]+"&"+
                        datos[contador][4]+"&"+datos[contador][5]+"&"+contador);
            }
            e_archivo.close();
        } catch (IOException error) {
            mostrar(error.getMessage());
        }
    }
    
      public void editarProfesor(Profesor profesor)
    {
        String [][] datos = new String[contadorP][5];
        String linea;
        String cedula;
        String nombre;
        String apellido;
        String usuario;
        String contraseña;
        int contadorPosicion = -1;
        try 
        {
            
            l_archivo = new FileReader("archivo/registro/profesor.txt");
            l_buffer = new BufferedReader(l_archivo);
//            System.out.println(l_buffer.readLine());
            while((linea = l_buffer.readLine()) != null)
            {
                cedula=linea.substring(0, linea.indexOf("&"));
                linea = linea.substring(linea.indexOf("&")+1);
                nombre = linea.substring(0, linea.indexOf("&"));
                linea = linea.substring(linea.indexOf("&")+1);
                apellido = linea.substring(0, linea.indexOf("&"));
                linea = linea.substring(linea.indexOf("&")+1);
                usuario = linea.substring(0, linea.indexOf("&"));
                linea = linea.substring(linea.indexOf("&")+1);
                contraseña = linea.substring(0, linea.indexOf("&"));
                contadorPosicion++;
                
                if(cedula.equals(Integer.toString(profesor.getCedula())))
                { // se cambia el contenido
                    datos[contadorPosicion][0] = Integer.toString(profesor.getCedula());
                    datos[contadorPosicion][1] = profesor.getNombre();
                    datos[contadorPosicion][2] = profesor.getApellido();
                    datos[contadorPosicion][3] = profesor.getUsuario();
                    datos[contadorPosicion][4] = profesor.getContraseña();
                }
                else
                { // si no se deja igual
                    datos[contadorPosicion][0] = cedula;
                    datos[contadorPosicion][1] = nombre;
                    datos[contadorPosicion][2] = apellido;
                    datos[contadorPosicion][3] = usuario;
                    datos[contadorPosicion][4] = contraseña;
                }
            }
            l_archivo.close();
            
            e_archivo = new FileWriter("archivo/registro/profesor.txt", false);
            e_buffer = new PrintWriter(e_archivo);
            
            for(int contador = 0; contador < contadorPosicion+1; contador++)
            {
                e_buffer.println(datos[contador][0]+"&"+datos[contador][1]+"&"+datos[contador][2]+"&"+datos[contador][3]+"&"+
                        datos[contador][4]+"&"+contador);
            }
            e_archivo.close();
        } catch (IOException error) {
            mostrar(error.getMessage());
        }
    }
   
    public void eliminarAlumno(int cedulaAlumno)
    {
        String [][] datos = new String[contadorA][6];
        String linea;
        String cedula;
        String nombre;
        String apellido;
        String usuario;
        String contraseña;
        String bloqueado;
        int contadorPosicion = -1;
        try 
        {
            
            l_archivo = new FileReader("archivo/registro/alumno.txt");
            l_buffer = new BufferedReader(l_archivo);
//            System.out.println(l_buffer.readLine());
            while((linea = l_buffer.readLine()) != null)
            {
                cedula=linea.substring(0, linea.indexOf("&"));
                linea = linea.substring(linea.indexOf("&")+1);
                nombre = linea.substring(0, linea.indexOf("&"));
                linea = linea.substring(linea.indexOf("&")+1);
                apellido = linea.substring(0, linea.indexOf("&"));
                linea = linea.substring(linea.indexOf("&")+1);
                usuario = linea.substring(0, linea.indexOf("&"));
                linea = linea.substring(linea.indexOf("&")+1);
                contraseña = linea.substring(0, linea.indexOf("&"));
                linea = linea.substring(linea.indexOf("&")+1);
                bloqueado = linea.substring(0, linea.indexOf("&"));
                contadorPosicion++;
                
                if(!cedula.equals(Integer.toString(cedulaAlumno)))
                { // se cambia el contenido
                    datos[contadorPosicion][0] = cedula;
                    datos[contadorPosicion][1] = nombre;
                    datos[contadorPosicion][2] = apellido;
                    datos[contadorPosicion][3] = usuario;
                    datos[contadorPosicion][4] = contraseña;
                    datos[contadorPosicion][5] = bloqueado;
                }
            }
            l_archivo.close();
            
            e_archivo = new FileWriter("archivo/registro/alumno.txt", false);
            e_buffer = new PrintWriter(e_archivo);
            
            for(int contador = 0; contador < contadorPosicion; contador++)
            {
                e_buffer.println(datos[contador][0]+"&"+datos[contador][1]+"&"+datos[contador][2]+"&"+datos[contador][3]+"&"+
                        datos[contador][4]+"&"+datos[contador][5]+"&"+contador);
            }
            e_archivo.close();
        } catch (IOException error) {
            mostrar(error.getMessage());
        }
    }
          public void eliminarProfesor(int cedulaProfesor)
    {
        String [][] datos = new String[contadorP][5];
        String linea;
        String cedula;
        String nombre;
        String apellido;
        String usuario;
        String contraseña;
        int contadorPosicion = -1;
        try 
        {
            
            l_archivo = new FileReader("archivo/registro/profesor.txt");
            l_buffer = new BufferedReader(l_archivo);
//            System.out.println(l_buffer.readLine());
            while((linea = l_buffer.readLine()) != null)
            {
                cedula=linea.substring(0, linea.indexOf("&"));
                linea = linea.substring(linea.indexOf("&")+1);
                nombre = linea.substring(0, linea.indexOf("&"));
                linea = linea.substring(linea.indexOf("&")+1);
                apellido = linea.substring(0, linea.indexOf("&"));
                linea = linea.substring(linea.indexOf("&")+1);
                usuario = linea.substring(0, linea.indexOf("&"));
                linea = linea.substring(linea.indexOf("&")+1);
                contraseña = linea.substring(0, linea.indexOf("&"));
                contadorPosicion++;
                
                if(cedula.equals(Integer.toString(cedulaProfesor)))
                { // se cambia el contenido
                    datos[contadorPosicion][0] = cedula;
                    datos[contadorPosicion][1] = nombre;
                    datos[contadorPosicion][2] = apellido;
                    datos[contadorPosicion][3] = usuario;
                    datos[contadorPosicion][4] = contraseña;
                }
            }
            l_archivo.close();
            
            e_archivo = new FileWriter("archivo/registro/profesor.txt", false);
            e_buffer = new PrintWriter(e_archivo);
            
            for(int contador = 0; contador < contadorPosicion; contador++)
            {
                e_buffer.println(datos[contador][0]+"&"+datos[contador][1]+"&"+datos[contador][2]+"&"+datos[contador][3]+"&"+
                        datos[contador][4]+"&"+contador);
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
