
package CP;

public class ListaComentario 
{
    
    private NodoComentario primerNodo;
    private int tamaño=0;
    
    public ListaComentario () 
    {
        primerNodo = null ;
    }
    public boolean esVacia ( ) 
    {
        if ( getPrimerNodo() == null )
            return true ;
        return false ;
    }
    public void insertarPrimero ( NodoComentario n ) 
    {
        if ( esVacia ( ) )
        {
            setPrimerNodo(n);
            tamaño++;
        }     
        else
        {
            n.setSte (getPrimerNodo());
            setPrimerNodo(n);
            tamaño++;
        }
    }
    public void cerrar()
    {
        NodoComentario x = primerNodo;
        while(x!=null)
        {
            NodoComentario aux=x;
            x=x.getSte();
            aux=null;
         //deja la memoria vacia para ser ocupada posteriormente de ser necesario
         //eso solo depende del sistema operativo que decide cuando limpiar memoria en el momento que la requiere
        }
    }
    public void insertarFinal ( NodoComentario n ) 
    {
        if ( esVacia ( ) )
        {
            setPrimerNodo(n) ;
            tamaño++;
        }
        
        else
        {
            NodoComentario x = getPrimerNodo() ;
            while ( x.getSte ( ) != null )
            x = x . getSte ( ) ;
            x . setSte ( n ) ;
            tamaño++;
        }
    }
    public NodoComentario suprimir ( int cedula )
    {
        NodoComentario x = localizar ( cedula ) ;
        NodoComentario y ;
        if ( x != null )
        {
            //el equials de una clase recibeun objeto
            if( x.equals(primerNodo))
            { //si el nodo a eliminar es el primerNodo
                y = new NodoComentario ( x.getComentario()) ;
                primerNodo = primerNodo . getSte ( ) ;
            }
            else
            {
                if( x. getSte()== null)
                {// si el nodo a eliminar es el ultimo
                    y = primerNodo ;
                    while ( !y . getSte ( ) . equals ( x ) )
                    y = y . getSte ( ) ;
                    y . setSte ( null ) ;
                }
                else 
                {//si el nodo a eliminar esta en medio de dos nodos
                    y = primerNodo ;
                    while ( !(y . getSte ( ) . equals ( x ) ) )
                    y = y . getSte ( ) ;
                    y . setSte ( x . getSte ( ) ) ;
                }
            }
            return x ;
        }
        return null ;
    }

    public NodoComentario localizar ( int cedula ) 
    {
        NodoComentario x = primerNodo ;
        if ( !esVacia() )
        {
            while ( x != null) 
            {
                if ( x .getComentario().getCedula() == cedula)
                    return x ;
                x = x . getSte() ;
            }
        }
        return null ;
     }


    public NodoComentario getPrimerNodo() 
    {
        return primerNodo;
    }
    public void setPrimerNodo(NodoComentario primerNodo) {
        this.primerNodo = primerNodo;
    }
    public int getTamaño() 
    {
        return tamaño;
    }
 }


