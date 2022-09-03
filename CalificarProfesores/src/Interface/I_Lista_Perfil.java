package Interface;
import  CP.*;
import javax.swing.*;

public class I_Lista_Perfil extends javax.swing.JPanel {

    CalificarProfesor cp;
    DefaultListModel modeloLista;
    public I_Lista_Perfil(CalificarProfesor cp)
    {
        initComponents();
        this.cp= cp;
        modeloLista=new DefaultListModel();
        jLista.setModel(modeloLista);
        cp.importarA_Perfil(false);
        comprobarPosicin();
    }
    private void comprobarPosicin()
    {
        if(cp.getPosicionMateria()!=-1&&cp.getPosicionPerfil()==-1)
        {
            cargarPerfil();
        }
        else
            mostrarListaComentario();
        
    }
    private void cargarPerfil()
    {
        int i;
        for(i=0;i<cp.getMateria().getContadorP();i++)
        {

            modeloLista.addElement(cp.getPerfil(i).getNombreProfesor()
            +"/ \n "+cp.getMateria().getPerfil(i).getDescripcion()+"/ \n"+cp.getMateria().getPerfil(i).getPromedio());
        }
    }
    private void mostrarListaComentario()
    {
        I_Lista_Comentario lcomentario = new I_Lista_Comentario(cp);
        lcomentario.setSize(620,480);
        jpPrincipal.removeAll();
        jpPrincipal.add(lcomentario);
        jpPrincipal.revalidate();
        jpPrincipal.repaint(); 
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
        jbMateria = new javax.swing.JButton();

        jLista.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        jLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jLista);

        jbMateria.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jbMateria.setText("Materias");
        jbMateria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMateriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 350, Short.MAX_VALUE))
        );
        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
                .addComponent(jbMateria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListaMouseClicked
        cp.setPosicion(cp.getPosicionMateria(), jLista.getSelectedIndex(), 0);
        mostrarListaComentario();
        //JOptionPane.showMessageDialog(null,jLista.getSelectedIndex());
    }//GEN-LAST:event_jListaMouseClicked

    private void jbMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMateriaActionPerformed
        cp.setPosicion(-1, -1, -1);
        mostrarListaMateria();
    }//GEN-LAST:event_jbMateriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> jLista;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbMateria;
    private javax.swing.JPanel jpPrincipal;
    // End of variables declaration//GEN-END:variables
}
