package Interface;
import  CP.*;
import javax.swing.*;


public class I_Lista_Materia extends javax.swing.JPanel {

    CalificarProfesor cp;
    DefaultListModel modeloLista;
    public I_Lista_Materia(CalificarProfesor cp)
    {
        initComponents();
        this.cp= cp;
        modeloLista=new DefaultListModel();
        jLista.setModel(modeloLista);
        cp.importarA_Materia();
        comprobarPosicion();
    }

    private void comprobarPosicion()
    {
        if(cp.getPosicionMateria()==-1)
            cargarMateria();
        else
            mostrarListaPerfil();
    }
    private void mostrarListaPerfil()
    {
        I_Lista_Perfil lPerfil = new I_Lista_Perfil(cp);
        lPerfil.setSize(950,480);
        jpPrincipal.removeAll();
        jpPrincipal.add(lPerfil);
        jpPrincipal.revalidate();
        jpPrincipal.repaint();     
    }
    private void cargarMateria()
    {
        int i;
        for(i=0;i<cp.getLista().getContadorM();i++)
        {
            modeloLista.addElement(cp.getLista().getMateria(i).getNombreM());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPrincipal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLista = new javax.swing.JList<>();

        setPreferredSize(new java.awt.Dimension(950, 500));

        jpPrincipal.setPreferredSize(new java.awt.Dimension(930, 430));

        jLista.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        jLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jLista);

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 350, Short.MAX_VALUE))
        );
        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListaMouseClicked
        cp.setPosicion(jLista.getSelectedIndex(), -1, -1);
        mostrarListaPerfil();
    }//GEN-LAST:event_jListaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> jLista;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpPrincipal;
    // End of variables declaration//GEN-END:variables
}
