package CP;


public class Posicion 
{
    int materia;
    int perfil;
    int comentario;
    public Posicion(int materia,int perfil, int comentario)
    {
        this.materia=materia;
        this.perfil=perfil;
        this.comentario=comentario;               
    }
 
    public void setMateria(int materia)
    {
        this.materia=materia;
    }
    
    public void setPerfil(int perfil)
    {
        this.perfil=perfil;
    }
        
    public void setComentario(int comentario)
    {
        this.comentario=comentario;
    }
    
    public int getMateria()
    {
        return materia;
    }
    
    public int getPerfil()
    {
        return perfil;
    }
        
    public int getComentario()
    {
        return comentario;
    }
}
