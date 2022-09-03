package CP;

public class Lista 
{ 
    private Materia materia[]=new Materia[20];;//clase materia
    private int contadorMateria=0;
    
    public Lista()//int numeroDeMateria)
    {
//        materia=new Materia[numeroDeMateria];
    }
    protected String cargarMateria(String nombreDeMateria,boolean b)//,int tamannoPerfil)
    {
        if(contadorMateria<this.materia.length)
        {
            if(buscarNombreM(nombreDeMateria)==-1)
            {
                if(contadorMateria==0)
                {
                    materia[contadorMateria]=new Materia(nombreDeMateria, b);//,tamannoPerfil);
                    contadorMateria++;
                    return "carga exitosa";
                }
                else
                {
                    int i,cambio=0,j;
                    for(i=0;i<contadorMateria&&cambio==0;i++)
                    {
                        if(materia[i].getNombreM().compareTo(nombreDeMateria)>0||materia[i].getNombreM().compareTo(nombreDeMateria)==0)
                        {
                            contadorMateria++;
                            for(j=contadorMateria-1;j>i;j--)
                            {
                                materia[j]=materia[j-1];
                            }
                            materia[i]=new Materia(nombreDeMateria,b);//,tamannoPerfil);
                            cambio=1;
                            return "carga exitosa";
                        }
                    }
                    if(cambio==0)
                    {
                        materia[i]=new Materia(nombreDeMateria,b);//,tamannoPerfil);
                        contadorMateria++;
                        return "carga exitosa";
                    }
                }
            }
            else
                return "Materia ya cargada";

        }
        return "No hay espacio para cargar la materia";
    }
    public int buscarNombreM(String materia)
    {
        int i;
        for(i=0;i<contadorMateria;i++)
        {
            if(materia.equals(this.materia[i].getNombreM())==true)
                return i;
        }
        return -1;
    }
    public Materia getMateria(int posicionDeMateria)
    {
        return materia[posicionDeMateria];
    }
    public int getContadorM()
    {
        return contadorMateria;
    }
}
