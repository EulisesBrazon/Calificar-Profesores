package Archivo;
import CP.*;
import java.io.*;

public class A_Comentario
{
    private FileWriter e_archivo;
    private PrintWriter e_buffer;
    private FileReader l_archivo;
    private BufferedReader l_buffer;
    private String nombreMateria,cedulaProfesor;
    private int contador;
    
    public A_Comentario (String nombreMateria,String cedulaProfesor)//, int tamañoPerfil)
    {
        this.nombreMateria=nombreMateria;
        this.cedulaProfesor=cedulaProfesor;
        try 
        {
            
            File archivo=new File("archivo/lista/"+nombreMateria+"/"+cedulaProfesor+"/"+"Comentarios.txt");

            if(!archivo.exists())
            {
                archivo.createNewFile();
                mostrar("Se creo el archivo "+archivo.getName());
            }
            contador=getTamaño();          
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
        
            try {             
                l_archivo = new FileReader("archivo/lista/"+nombreMateria+"/"+cedulaProfesor+"/"+"Comentarios.txt");
                l_buffer = new BufferedReader(l_archivo);
            while((linea = l_buffer.readLine()) != null)
            {
               contadorLinea++;               
            }
            l_buffer.close();
            l_archivo.close();
        } catch (IOException error) {
            mostrar(error.getMessage());
        }
        return contadorLinea;
    }
    
    public void guardarComentario(Comentario comentario)
    {
        try
        {
            e_archivo = new FileWriter("archivo/lista/"+nombreMateria+"/"+cedulaProfesor+"/"+"Comentarios.txt", true);
            e_buffer = new PrintWriter(e_archivo);
            
            e_buffer.println(comentario.getCedula()+"&"+comentario.getComentario()+"&"+comentario.getFecha()+"&"+
                comentario.getHora()+"&"+comentario.getModificado()+"&"+contador);  
            
            e_buffer.close();
            e_buffer.close();
        }   
        catch(IOException error) 
        {
            mostrar(error.getMessage());
        }     
    }
    
    public int buscarPosicion(int cedulaProfesor)
    {
        String linea;
        String nombre;
        int numero=-1;
        try {
            
            l_archivo = new FileReader("archivo/lista/"+nombreMateria+"/"+this.cedulaProfesor+"/"+"Comentarios.txt");
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
    
    public String buscarAtributos(int posicion)
    {
        String linea;
        String cedula;
        String descripcion;
        String fecha;
        String hora;
        String modificado;
        int contadorPosicion = -1;
        
        try {
            
            l_archivo = new FileReader("archivo/lista/"+nombreMateria+"/"+cedulaProfesor+"/"+"Comentarios.txt");
            l_buffer = new BufferedReader(l_archivo);
            
            while((linea = l_buffer.readLine()) != null)
            {   
//                System.out.print(linea);
               cedula=linea.substring(0, linea.indexOf("&"));
               linea = linea.substring(linea.indexOf("&")+1);
               descripcion = linea.substring(0, linea.indexOf("&"));
               linea = linea.substring(linea.indexOf("&")+1);
               fecha = linea.substring(0, linea.indexOf("&"));
               linea = linea.substring(linea.indexOf("&")+1);
               hora = linea.substring(0, linea.indexOf("&"));
               linea = linea.substring(linea.indexOf("&")+1);
               modificado = linea.substring(0, linea.indexOf("&"));
               contadorPosicion++;
               if(contadorPosicion==posicion)
               {
//                   System.out.print(cedula+"&&&"+descripcion+"&&&"+fecha+"&&&"+hora+"&&&"+modificado);
                   l_archivo.close();
                   return cedula+"&"+descripcion+"&"+fecha+"&"+hora+"&"+modificado+"&"+contadorPosicion; 
               }
                                   
            }  
            l_archivo.close();
        } 
        catch (IOException error) 
        {
            mostrar(error.getMessage());
        }
        return " ";
    }
    
    public void editarComentario(Comentario comentario)
    {
        String [][] datos = new String[contador][5];
        String linea;
        String cedula;
        String descripcion;
        String fecha;
        String hora;
        String modificado;
        int contadorPosicion = -1;
        try 
        {
            
            l_archivo = new FileReader("archivo/lista/"+nombreMateria+"/"+cedulaProfesor+"/"+"Comentarios.txt");
            l_buffer = new BufferedReader(l_archivo);
//            System.out.println(l_buffer.readLine());
            while((linea = l_buffer.readLine()) != null)
            {
                cedula=linea.substring(0, linea.indexOf("&"));
                linea = linea.substring(linea.indexOf("&")+1);
                descripcion = linea.substring(0, linea.indexOf("&"));
                linea = linea.substring(linea.indexOf("&")+1);
                fecha = linea.substring(0, linea.indexOf("&"));
                linea = linea.substring(linea.indexOf("&")+1);
                hora = linea.substring(0, linea.indexOf("&"));
                linea = linea.substring(linea.indexOf("&")+1);
                modificado = linea.substring(0, linea.indexOf("&"));
                contadorPosicion++;
                
                if(cedula.equals(Integer.toString(comentario.getCedula())))
                { // se cambia el contenido
                    datos[contadorPosicion][0] = cedula;
                    datos[contadorPosicion][1] = comentario.getComentario();
                    datos[contadorPosicion][2] = comentario.getFecha();
                    datos[contadorPosicion][3] = comentario.getHora();
                    if(comentario.getModificado())
                        datos[contadorPosicion][4] = "true";
                    else
                        datos[contadorPosicion][4] = "false";
                }
                else
                { // si no se deja igual
                    datos[contadorPosicion][0] = cedula;
                    datos[contadorPosicion][1] = descripcion;
                    datos[contadorPosicion][2] = fecha;
                    datos[contadorPosicion][3] = hora;
                    datos[contadorPosicion][4] = modificado;
                }
            }
            l_archivo.close();
            
            e_archivo = new FileWriter("archivo/lista/"+nombreMateria+"/"+cedulaProfesor+"/"+"Comentarios.txt", false);
            e_buffer = new PrintWriter(e_archivo);
            
            for(int contadorP = 0; contadorP < contadorPosicion+1; contadorP++)
            {
                e_buffer.println(datos[contadorP][0]+"&"+datos[contadorP][1]+"&"+datos[contadorP][2]+"&"+datos[contadorP][3]+"&"+
                        datos[contadorP][4]+"&"+contadorP);
            }
            e_archivo.close();
        } catch (IOException error) {
            mostrar(error.getMessage());
        }
    }
    
    public void eliminar(Comentario comentario)
    {
        String [][] datos = new String[contador][5];
        String linea;
        String cedula;
        String descripcion;
        String fecha;
        String hora;
        String modificado;
        int contadorPosicion = -1;
        try 
        {
            
            l_archivo = new FileReader("archivo/lista/"+nombreMateria+"/"+cedulaProfesor+"/"+"Comentarios.txt");
            l_buffer = new BufferedReader(l_archivo);
            
            while((linea = l_buffer.readLine()) != null)
            {
                cedula=linea.substring(0, linea.indexOf("&"));
                linea = linea.substring(linea.indexOf("&")+1);
                descripcion = linea.substring(0, linea.indexOf("&"));
                linea = linea.substring(linea.indexOf("&")+1);
                fecha = linea.substring(0, linea.indexOf("&"));
                linea = linea.substring(linea.indexOf("&")+1);
                hora = linea.substring(0, linea.indexOf("&"));
                linea = linea.substring(linea.indexOf("&")+1);
                modificado = linea.substring(0, linea.indexOf("&"));
                contadorPosicion++;
                
                if(!cedula.equals(Integer.toString(comentario.getCedula())))
                {// si no se deja igual
                    datos[contadorPosicion][0] = cedula;
                    datos[contadorPosicion][1] = descripcion;
                    datos[contadorPosicion][2] = fecha;
                    datos[contadorPosicion][3] = hora;
                    datos[contadorPosicion][4] = modificado;
                }
            }
            l_archivo.close();
            
            e_archivo = new FileWriter("archivo/lista/"+nombreMateria+"/"+cedulaProfesor+"/"+"Comentarios.txt", false);
            e_buffer = new PrintWriter(e_archivo);
            
            for(int contadorP = 0; contadorP < contadorPosicion; contadorP++)
            {
                e_buffer.println(datos[contadorP][0]+"&"+datos[contadorP][1]+"&"+datos[contadorP][2]+"&"+datos[contadorP][3]+"&"+
                        datos[contadorP][4]+"&"+contadorP);
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
