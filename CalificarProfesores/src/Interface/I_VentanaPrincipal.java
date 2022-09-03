package Interface;
import  CP.*;
import java.awt.*;
import javax.swing.JOptionPane;


public class I_VentanaPrincipal extends javax.swing.JFrame 
{
    CalificarProfesor cp;
    static int ANCHO=950;
    static int ALTO=550;
    
    public I_VentanaPrincipal(CalificarProfesor cp)
    {
        this.cp = cp;
        initComponents();
        this.setSize(950, 550);
        this.setResizable(false);
//        JOptionPane.showMessageDialog(null,cp.getLista().getMateria(cp.getPosicionMateria()).getPerfil(cp.getPosicionPerfil()).buscarCedulaAlumnoAprobado(cp.getUsuario().getCedula()));
        this.setLocationRelativeTo(null);
        mostrarDefault();
        setVisible(true);
    }
    
    private void salir ()
    {  
        String botones[]= {"Si", "No"};
        int option = JOptionPane.showOptionDialog(this, "¿Desea salir?", "Advertencia", 0, JOptionPane.WARNING_MESSAGE, null, botones, this);
     	
     	if(option==JOptionPane.YES_OPTION)
     	{
     	    this.setVisible(false);
     	    System.exit(0);
     	}
        
        if (option==JOptionPane.NO_OPTION)
        {
            setDefaultCloseOperation (DO_NOTHING_ON_CLOSE);
        }
    }
    
    private void mostrarDefault()
    {
        I_Default encabezado=new I_Default(cp);
        encabezado.setSize(ANCHO,ALTO);
        jpPrincipal.removeAll();
        jpPrincipal.add(encabezado);
        jpPrincipal.revalidate();
        jpPrincipal.repaint();     
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 950, Short.MAX_VALUE)
        );
        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        salir();
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jpPrincipal;
    // End of variables declaration//GEN-END:variables
}
