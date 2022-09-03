package Interface;
import  CP.*;
import javax.swing.*;

public class I_Alumno extends javax.swing.JPanel {

    CalificarProfesor cp;
    
    public I_Alumno(CalificarProfesor cp) 
    {
        this.cp=cp;
        initComponents();
        cargarNombre();
        buttonGroup1.add(this.jRadioButton1);
        buttonGroup1.add(this.jRadioButton2);
        buttonGroup1.add(this.jRadioButton3);
        buttonGroup1.add(this.jRadioButton4);
        buttonGroup1.add(this.jRadioButton5);
        comprobacionAlumnoAprobado();
        comprobacionAlumnoComentado();
        mostrarLista();
    }
    private boolean comprobacionAlumnoAprobado()
    {
        boolean b=cp.getPosicionPerfil()!=-1&&!cp.getPerfil().buscarCedulaAlumnoYaCalificado(cp.getUsuario().getCedula());//para saber si ya califico  
        b=b && !cp.getUsuario().getbloqueado() && cp.getPerfil().buscarCedulaAlumnoAprobado(cp.getUsuario().getCedula());
        
        JB_Calificar.setEnabled(b);
        jRadioButton1.setEnabled(b);
        jRadioButton2.setEnabled(b);
        jRadioButton3.setEnabled(b);
        jRadioButton4.setEnabled(b);
        jRadioButton5.setEnabled(b);
            
        return b;
        
    }
    private boolean comprobacionAlumnoComentado()
    {
       boolean b=cp.getPosicionPerfil()!=-1&&cp.getPerfil().buscarCedulaComentario(Integer.parseInt(cp.getUser()))==-1;
        b=b && !cp.getUsuario().getbloqueado();

        JT_tComentario.setEnabled(b);
        JB_Limpiar.setEnabled(b);
        JB_Comentar.setEnabled(b);
        
        return b;
    }
    private void cargarNombre()
    {
        JLabel nombre =new JLabel();
        nombre.setText(cp.getUsuario().getNombre());
        nombre.setSize(300, 50);
        nombre.setLocation(110, 10);
        nombre.setFont(new java.awt.Font("Comic Sans MS", 0, 18));
        nombre.setForeground(new java.awt.Color(255, 255, 255));
        JL_FondoEncabezado.add(nombre);
        JL_FondoEncabezado.revalidate();
        JL_FondoEncabezado.repaint();
    }
    
    private void mostrarLista()
    {
        I_Lista_Materia lista=new I_Lista_Materia(cp);
        lista.setSize(600,480);
        cargar(this.JP_Lista,lista);      
    }
    
    private void mostrarDefault()
    {
        cp.setPosicion(-1, -1, -1);
        I_Default defecto=new I_Default(cp);
        defecto.setSize(950,550); 
        cargar(this.JP_Principal,defecto); 
    }
    
    private void cargar(JPanel jp,JPanel cargar)
    {
        jp.removeAll();
        jp.add(cargar);
        jp.revalidate();
        jp.repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        JP_Principal = new javax.swing.JPanel();
        JP_Encabezado = new javax.swing.JPanel();
        JP_Alumno = new javax.swing.JPanel();
        JB_Limpiar = new javax.swing.JButton();
        JB_Comentar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JT_tComentario = new javax.swing.JTextArea();
        JP_Calificacion = new javax.swing.JPanel();
        JL_Calificacion = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        JB_Calificar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        JP_Lista = new javax.swing.JPanel();
        JB_CerrarSesion = new javax.swing.JButton();
        JL_FondoEncabezado = new javax.swing.JLabel();

        JP_Principal.setLayout(null);

        JP_Encabezado.setBackground(new java.awt.Color(0, 102, 204));
        JP_Encabezado.setLayout(null);
        JP_Principal.add(JP_Encabezado);
        JP_Encabezado.setBounds(0, 0, 947, 0);

        JP_Alumno.setBackground(new java.awt.Color(0, 153, 204));

        JB_Limpiar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        JB_Limpiar.setText("Limpiar");
        JB_Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_LimpiarActionPerformed(evt);
            }
        });

        JB_Comentar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        JB_Comentar.setText("Comentar");
        JB_Comentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_ComentarActionPerformed(evt);
            }
        });

        JT_tComentario.setColumns(20);
        JT_tComentario.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        JT_tComentario.setRows(5);
        jScrollPane1.setViewportView(JT_tComentario);

        JP_Calificacion.setBackground(new java.awt.Color(0, 153, 204));

        JL_Calificacion.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        JL_Calificacion.setText("¿Que calificación le das al profesor?");

        jRadioButton1.setBackground(new java.awt.Color(0, 153, 204));
        jRadioButton1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jRadioButton1.setText("Muy bueno(a)");

        jRadioButton2.setBackground(new java.awt.Color(0, 153, 204));
        jRadioButton2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jRadioButton2.setText("Bueno(a)");

        jRadioButton3.setBackground(new java.awt.Color(0, 153, 204));
        jRadioButton3.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jRadioButton3.setSelected(true);
        jRadioButton3.setText("Normal");

        jRadioButton4.setBackground(new java.awt.Color(0, 153, 204));
        jRadioButton4.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jRadioButton4.setText("Malo(a)");

        jRadioButton5.setBackground(new java.awt.Color(0, 153, 204));
        jRadioButton5.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jRadioButton5.setText("Muy malo(a)");

        JB_Calificar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        JB_Calificar.setText("Calificar");
        JB_Calificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_CalificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JP_CalificacionLayout = new javax.swing.GroupLayout(JP_Calificacion);
        JP_Calificacion.setLayout(JP_CalificacionLayout);
        JP_CalificacionLayout.setHorizontalGroup(
            JP_CalificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_CalificacionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JP_CalificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton5)
                    .addComponent(JB_Calificar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84))
            .addGroup(JP_CalificacionLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(JL_Calificacion)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        JP_CalificacionLayout.setVerticalGroup(
            JP_CalificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_CalificacionLayout.createSequentialGroup()
                .addComponent(JL_Calificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JB_Calificar)
                .addContainerGap())
        );

        jButton1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jButton1.setText("Comprobar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JP_AlumnoLayout = new javax.swing.GroupLayout(JP_Alumno);
        JP_Alumno.setLayout(JP_AlumnoLayout);
        JP_AlumnoLayout.setHorizontalGroup(
            JP_AlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_AlumnoLayout.createSequentialGroup()
                .addGroup(JP_AlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_AlumnoLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(JP_AlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JB_Limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(JP_AlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(JP_Calificacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JB_Comentar)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(JP_AlumnoLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        JP_AlumnoLayout.setVerticalGroup(
            JP_AlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_AlumnoLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JP_AlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JB_Limpiar)
                    .addComponent(JB_Comentar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JP_Calificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        JP_Principal.add(JP_Alumno);
        JP_Alumno.setBounds(600, 70, 350, 480);

        JP_Lista.setBackground(new java.awt.Color(255, 153, 102));
        JP_Lista.setPreferredSize(new java.awt.Dimension(600, 480));

        javax.swing.GroupLayout JP_ListaLayout = new javax.swing.GroupLayout(JP_Lista);
        JP_Lista.setLayout(JP_ListaLayout);
        JP_ListaLayout.setHorizontalGroup(
            JP_ListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        JP_ListaLayout.setVerticalGroup(
            JP_ListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        JP_Principal.add(JP_Lista);
        JP_Lista.setBounds(0, 70, 600, 480);

        JB_CerrarSesion.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        JB_CerrarSesion.setText("Cerrar sesión\n");
        JB_CerrarSesion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JB_CerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_CerrarSesionActionPerformed(evt);
            }
        });
        JP_Principal.add(JB_CerrarSesion);
        JB_CerrarSesion.setBounds(699, 20, 140, 29);

        JL_FondoEncabezado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/FondoAzul.png"))); // NOI18N
        JL_FondoEncabezado.setToolTipText("");
        JP_Principal.add(JL_FondoEncabezado);
        JL_FondoEncabezado.setBounds(0, 0, 950, 70);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JP_Principal, javax.swing.GroupLayout.DEFAULT_SIZE, 947, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JP_Principal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JB_CerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_CerrarSesionActionPerformed
        cp.setUser(" ");
        mostrarDefault();
    }//GEN-LAST:event_JB_CerrarSesionActionPerformed

    private void JB_ComentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_ComentarActionPerformed
        if(comprobacionAlumnoComentado())
        {
            JOptionPane.showMessageDialog(null,cp.comentar(JT_tComentario.getText()));
            JT_tComentario.setText("");
            mostrarLista();
            comprobacionAlumnoComentado();
        }
        else
            JOptionPane.showMessageDialog(null,"ya ah realizado su comentario");
        
    }//GEN-LAST:event_JB_ComentarActionPerformed

    private void JB_LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_LimpiarActionPerformed
         JT_tComentario.setText("");
    }//GEN-LAST:event_JB_LimpiarActionPerformed

    private void JB_CalificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_CalificarActionPerformed
        if(cp.getPosicionMateria()!=-1&&cp.getPosicionPerfil()!=-1&&comprobacionAlumnoAprobado())
        {
            if(cp.getPerfil().buscarCedulaAlumnoAprobado(cp.getUsuario().getCedula()))
            {
                        int i;
                        if(jRadioButton1.isSelected())
                            i=5;
                        else if(jRadioButton2.isSelected())
                            i=4;
                        else if(jRadioButton3.isSelected())
                            i=3;
                        else if(jRadioButton4.isSelected())
                            i=2;
                        else
                            i=1;
                        
                        JOptionPane.showMessageDialog(null,cp.cargarNotar(i, true));  
                        comprobacionAlumnoAprobado();
            }
            else 
                JOptionPane.showMessageDialog(null,"Debe aprobar la materia");
        }
        else
            JOptionPane.showMessageDialog(null,"Debe seleccionar la asignatura aprobada");
       
    }//GEN-LAST:event_JB_CalificarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        comprobacionAlumnoAprobado();
        comprobacionAlumnoComentado();
    }//GEN-LAST:event_jButton1ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_Calificar;
    private javax.swing.JButton JB_CerrarSesion;
    private javax.swing.JButton JB_Comentar;
    private javax.swing.JButton JB_Limpiar;
    private javax.swing.JLabel JL_Calificacion;
    private javax.swing.JLabel JL_FondoEncabezado;
    private javax.swing.JPanel JP_Alumno;
    private javax.swing.JPanel JP_Calificacion;
    private javax.swing.JPanel JP_Encabezado;
    private javax.swing.JPanel JP_Lista;
    private javax.swing.JPanel JP_Principal;
    private javax.swing.JTextArea JT_tComentario;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
