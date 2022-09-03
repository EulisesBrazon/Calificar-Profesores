
package CP;

public class NodoComentario 
{
    private Comentario comentario;
    private NodoComentario ste;
    
    public NodoComentario (Comentario c)
    {
        this.comentario=c;
        this.ste= null;
    }

   
    public Comentario getComentario() 
    {
        return comentario;
    }

    
    public NodoComentario getSte() 
    {
        return ste;
    }

    
    public void setComentario(Comentario comentario)
    {
        this.comentario = comentario;
    }

    public void setSte(NodoComentario ste) 
    {
        this.ste = ste;
    }
}
