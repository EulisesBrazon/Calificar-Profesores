package Interface;
import  CP.*;
import javax.swing.*;

public class I_Lista_Comentario extends javax.swing.JPanel {

    CalificarProfesor cp;
    DefaultListModel modeloLista;
    public I_Lista_Comentario(CalificarProfesor cp)
    {
        initComponents();
        this.cp= cp;
        modeloLista=new DefaultListModel();
        jLista.setModel(modeloLista);
        cp.importarA_Perfil(true);
        cp.importarA_Comentario();
        cargarComentario();
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
//    private void cargarComentario()
//    {
//        int i;
//        NodoComentario aux1=cp.getlComentario().getPrimerNodo();
//        for(i=0;i<cp.getLista().getMateria(cp.getPosicionMateria()).getPerfil(cp.getPosicionPerfil()).getlComentario().getTamaño();i++)
//        {
//            modeloLista.addElement(cp.getlComentario().getPrimerNodo().getComentario().getComentario());
//            cp.getlComentario().setPrimerNodo(cp.getlComentario().getPrimerNodo().getSte());
//        }
//        cp.getlComentario().setPrimerNodo(aux1);
//    }

    private void cargarComentario()
    {
        int i;
//        ListaComentario aux= new ListaComentario();

//        aux=cp.getlComentario();
        NodoComentario aux=cp.getlComentario().getPrimerNodo();
        for(i=0;i<cp.getlComentario().getTamaño();i++)
        {
            modeloLista.addElement(aux.getComentario().getComentario());
//            aux.insertarPrimero(cp.getlComentario().getPrimerNodo());
            aux=aux.getSte();
            
        }
//        cp.getlComentario().setPrimerNodo(aux);
    }
    private void mostrarListaMateria()
    {
        I_Lista_Materia lMateria = new I_Lista_Materia(cp);
        lMateria.setSize(620,480);
        jpPrincipal.removeAll();
        jpPrincipal.add(lMateria);
        jpPrincipal.revalidate();
        jpPrincipal.repaint();     
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPrincipal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLista = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        JB_Profesores = new javax.swing.JButton();

        jpPrincipal.setPreferredSize(new java.awt.Dimension(930, 335));

        jLista.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        jLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jLista);

        jButton1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jButton1.setText("Materias");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        JB_Profesores.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        JB_Profesores.setText("Profesores");
        JB_Profesores.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JB_Profesores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_ProfesoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(JB_Profesores, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 321, Short.MAX_VALUE))
        );
        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(JB_Profesores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListaMouseClicked
        //JOptionPane.showMessageDialog(null,jLista.getSelectedIndex());       
    }//GEN-LAST:event_jListaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cp.setPosicion(-1, -1, -1);
        mostrarListaMateria();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void JB_ProfesoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_ProfesoresActionPerformed
        cp.setPosicion(cp.getPosicionMateria(), -1, -1);
        mostrarListaPerfil();
    }//GEN-LAST:event_JB_ProfesoresActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_Profesores;
    private javax.swing.JButton jButton1;
    private javax.swing.JList<String> jLista;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpPrincipal;
    // End of variables declaration//GEN-END:variables
}
