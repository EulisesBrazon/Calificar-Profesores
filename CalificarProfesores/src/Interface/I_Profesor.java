package Interface;
import  CP.*;
import javax.swing.*;

public class I_Profesor extends javax.swing.JPanel {

    CalificarProfesor cp;
    
    public I_Profesor(CalificarProfesor cp) 
    {
        this.cp=cp;
        initComponents();
        cargarNombre();
        comprobarProfesor();
        mostrarLista();
        
    }
    private boolean comprobarProfesor()
    {
        boolean b=cp.getPosicionPerfil()!=-1;//para saber si ya califico  
        
        JB_Limpiar.setEnabled(b);
        JB_Comentar.setEnabled(b);
        
        b=cp.getPosicionPerfil()!=-1&&cp.getPerfil().compararCedulaProfesor(Integer.parseInt(cp.getUser()));

        JT_EstuduanteAprobado.setEnabled(b);
        JB_Cargar.setEnabled(b);
        JT_Descripcion.setEnabled(b);
        JB_Modificar.setEnabled(b);
         
        return b;
    }
    private void mostrarLista()
    {
        I_Lista_Materia lista=new I_Lista_Materia(cp);
        lista.setSize(600,480);
        cargar(this.JP_Lista,lista);       
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
    private void mostrarDefault()
    {
        cp.setPosicion(-1,-1,-1);
        I_Default defecto=new I_Default(cp);
        defecto.setSize(950,550);
        cargar(this.JP_Principal,defecto);  
    }
    private boolean soloNumero(String s)
    {
	String aux =s;
     	int i;
     	for (i= 0; i<s.length()&& aux.charAt(i)>='0'&& aux.charAt(i)<= '9';i++);
	    if(i==aux.length()&&i!=0)
	       return true;
            return false;
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

        jpLista1 = new javax.swing.JPanel();
        jpAdmin = new javax.swing.JPanel();
        JP_Principal = new javax.swing.JPanel();
        JP_Encabezado = new javax.swing.JPanel();
        JP_Lista = new javax.swing.JPanel();
        JP_Profesor = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JT_tComentario = new javax.swing.JTextArea();
        JB_Limpiar = new javax.swing.JButton();
        JB_Comentar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        JT_EstuduanteAprobado = new javax.swing.JTextField();
        JB_Cargar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JT_Descripcion = new javax.swing.JTextField();
        JB_Modificar = new javax.swing.JButton();
        JB_Comprobar = new javax.swing.JButton();
        JB_CerrarSesion = new javax.swing.JButton();
        JL_FondoEncabezado = new javax.swing.JLabel();

        jpLista1.setBackground(new java.awt.Color(255, 153, 102));
        jpLista1.setPreferredSize(new java.awt.Dimension(600, 480));

        javax.swing.GroupLayout jpLista1Layout = new javax.swing.GroupLayout(jpLista1);
        jpLista1.setLayout(jpLista1Layout);
        jpLista1Layout.setHorizontalGroup(
            jpLista1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jpLista1Layout.setVerticalGroup(
            jpLista1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        jpAdmin.setBackground(new java.awt.Color(204, 204, 0));

        javax.swing.GroupLayout jpAdminLayout = new javax.swing.GroupLayout(jpAdmin);
        jpAdmin.setLayout(jpAdminLayout);
        jpAdminLayout.setHorizontalGroup(
            jpAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jpAdminLayout.setVerticalGroup(
            jpAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        JP_Principal.setLayout(null);

        JP_Encabezado.setBackground(new java.awt.Color(0, 204, 204));
        JP_Encabezado.setLayout(null);
        JP_Principal.add(JP_Encabezado);
        JP_Encabezado.setBounds(0, 0, 965, 0);

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
            .addGap(0, 0, Short.MAX_VALUE)
        );

        JP_Principal.add(JP_Lista);
        JP_Lista.setBounds(0, 70, 600, 481);

        JP_Profesor.setBackground(new java.awt.Color(0, 153, 204));

        JT_tComentario.setColumns(20);
        JT_tComentario.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        JT_tComentario.setRows(5);
        jScrollPane1.setViewportView(JT_tComentario);

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

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));

        JT_EstuduanteAprobado.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        JT_EstuduanteAprobado.setText("Cédula de estudiante aprobado");
        JT_EstuduanteAprobado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JT_EstuduanteAprobadoMouseClicked(evt);
            }
        });

        JB_Cargar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        JB_Cargar.setText("Cargar");
        JB_Cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_CargarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel3.setText("  Escriba aquí el nombre del estudiante");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel4.setText("aprobado para que este pueda puntuarlo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(JB_Cargar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(JT_EstuduanteAprobado, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JT_EstuduanteAprobado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JB_Cargar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 153, 204));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel1.setText("Modificar Descripción");

        JT_Descripcion.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        JB_Modificar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        JB_Modificar.setText("Modificar");
        JB_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_ModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jLabel1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(JB_Modificar)))
                        .addGap(0, 70, Short.MAX_VALUE))
                    .addComponent(JT_Descripcion))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JT_Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JB_Modificar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JB_Comprobar.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        JB_Comprobar.setText("Comprobar");
        JB_Comprobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_ComprobarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JP_ProfesorLayout = new javax.swing.GroupLayout(JP_Profesor);
        JP_Profesor.setLayout(JP_ProfesorLayout);
        JP_ProfesorLayout.setHorizontalGroup(
            JP_ProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_ProfesorLayout.createSequentialGroup()
                .addGroup(JP_ProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_ProfesorLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(JP_ProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(JP_ProfesorLayout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3))
                            .addGroup(JP_ProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(JP_ProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(JP_ProfesorLayout.createSequentialGroup()
                                        .addComponent(JB_Limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(JB_Comentar))
                                    .addGroup(JP_ProfesorLayout.createSequentialGroup()
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3))))))
                    .addGroup(JP_ProfesorLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(JB_Comprobar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 45, Short.MAX_VALUE))
        );
        JP_ProfesorLayout.setVerticalGroup(
            JP_ProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_ProfesorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JP_ProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JB_Limpiar)
                    .addComponent(JB_Comentar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JB_Comprobar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        JP_Principal.add(JP_Profesor);
        JP_Profesor.setBounds(600, 70, 365, 496);

        JB_CerrarSesion.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        JB_CerrarSesion.setText("Cerrar sesión");
        JB_CerrarSesion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JB_CerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_CerrarSesionActionPerformed(evt);
            }
        });
        JP_Principal.add(JB_CerrarSesion);
        JB_CerrarSesion.setBounds(710, 20, 140, 30);

        JL_FondoEncabezado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/FondoTurqueza.png"))); // NOI18N
        JP_Principal.add(JL_FondoEncabezado);
        JL_FondoEncabezado.setBounds(0, 0, 950, 70);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JP_Principal, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE)
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

    private void JB_LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_LimpiarActionPerformed
        JT_tComentario.setText("");
    }//GEN-LAST:event_JB_LimpiarActionPerformed

    private void JB_ComentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_ComentarActionPerformed
        JOptionPane.showMessageDialog(null,cp.comentar(JT_tComentario.getText()));
        JT_tComentario.setText("");
        mostrarLista();
        comprobarProfesor();
    }//GEN-LAST:event_JB_ComentarActionPerformed

    private void JB_CargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_CargarActionPerformed
        if(cp.getPosicionMateria()!=-1&&cp.getPosicionPerfil()!=-1 && comprobarProfesor())
        {
            if(cp.getLista().getMateria(cp.getPosicionMateria()).getPerfil(cp.getPosicionPerfil()).compararCedulaProfesor(Integer.parseInt(cp.getUser())))
            {
                if(soloNumero(JT_EstuduanteAprobado.getText()))
                {
                    cp.cargarNotar(Integer.parseInt(JT_EstuduanteAprobado.getText()), true);
//                    cp.getLista().getMateria(cp.getPosicionMateria()).getPerfil(cp.getPosicionPerfil()).cargarAlumnoAprobado(Integer.parseInt(JT_EstuduanteAprobado.getText()));
                    JOptionPane.showMessageDialog(null,"Carga exitosa");
                }             
                else
                    JOptionPane.showMessageDialog(null,"numero de cedula no valido");
    
            }
            else 
                JOptionPane.showMessageDialog(null,"Necesita ser elProfesor de esta asignatura");
        }
        else
            JOptionPane.showMessageDialog(null,"Debe selecionar su asignatura");
        
    }//GEN-LAST:event_JB_CargarActionPerformed

    private void JT_EstuduanteAprobadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JT_EstuduanteAprobadoMouseClicked
        JT_EstuduanteAprobado.setText("");
    }//GEN-LAST:event_JT_EstuduanteAprobadoMouseClicked

    private void JB_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_ModificarActionPerformed
        if(cp.getPosicionMateria()!=-1&&cp.getPosicionPerfil()!=-1&&comprobarProfesor())
        {
            if(cp.getLista().getMateria(cp.getPosicionMateria()).getPerfil(cp.getPosicionPerfil()).compararCedulaProfesor(Integer.parseInt(cp.getUser())))
            {
                cp.getLista().getMateria(cp.getPosicionMateria()).getPerfil(cp.getPosicionPerfil()).setDescripcion(JT_Descripcion.getText());
                JOptionPane.showMessageDialog(null,"Carga exitosa");
            }
            else 
                JOptionPane.showMessageDialog(null,"Debe selecionar su asignatura");
        }
        else
            JOptionPane.showMessageDialog(null,"Debe selecionar su asignatura");
        
    }//GEN-LAST:event_JB_ModificarActionPerformed

    private void JB_ComprobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_ComprobarActionPerformed
        comprobarProfesor();
    }//GEN-LAST:event_JB_ComprobarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_Cargar;
    private javax.swing.JButton JB_CerrarSesion;
    private javax.swing.JButton JB_Comentar;
    private javax.swing.JButton JB_Comprobar;
    private javax.swing.JButton JB_Limpiar;
    private javax.swing.JButton JB_Modificar;
    private javax.swing.JLabel JL_FondoEncabezado;
    private javax.swing.JPanel JP_Encabezado;
    private javax.swing.JPanel JP_Lista;
    private javax.swing.JPanel JP_Principal;
    private javax.swing.JPanel JP_Profesor;
    private javax.swing.JTextField JT_Descripcion;
    private javax.swing.JTextField JT_EstuduanteAprobado;
    private javax.swing.JTextArea JT_tComentario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpAdmin;
    private javax.swing.JPanel jpLista1;
    // End of variables declaration//GEN-END:variables
}
