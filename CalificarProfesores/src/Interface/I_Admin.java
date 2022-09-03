package Interface;
import CP.*;
import javax.swing.*;
//import Archivo.*;

public class I_Admin extends javax.swing.JPanel {

    CalificarProfesor cp;
    int MaxProfesores=3;
    public I_Admin( CalificarProfesor cp) 
    {
        this.cp = cp;
        initComponents();
        mostrarLista();
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

    private void mostrarJP2()
    {
        I_JP2_Admin jp2=new I_JP2_Admin(cp);
        jp2.setSize(950, 550);
        cargar(this.JP_Principal,jp2);

    }
    
    private void mostrarLista()
    {
        I_Lista_Materia lista=new I_Lista_Materia(cp);
        lista.setSize(600,480);
        cargar(this.JP_Lista,lista);      
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

        JP_Principal = new javax.swing.JPanel();
        JP_Encabezado = new javax.swing.JPanel();
        JL_Admin = new javax.swing.JLabel();
        JB_CerrarSesion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        JP_Lista = new javax.swing.JPanel();
        JP_Alumno = new javax.swing.JPanel();
        JB_AgregarMateria = new javax.swing.JButton();
        JT_nMateria = new javax.swing.JTextField();
        JB_AgregarProfesor = new javax.swing.JButton();
        JT_nProfesor = new javax.swing.JTextField();
        JT_descripcionProfesor = new javax.swing.JTextField();
        JB_ModificarUsuario = new javax.swing.JButton();
        JT_Cedula = new javax.swing.JTextField();
        JT_cedulaProfesor = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(950, 500));

        JP_Principal.setLayout(null);

        JP_Encabezado.setBackground(new java.awt.Color(0, 0, 0));
        JP_Encabezado.setLayout(null);

        JL_Admin.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        JL_Admin.setForeground(new java.awt.Color(255, 255, 255));
        JL_Admin.setText("Admin");
        JP_Encabezado.add(JL_Admin);
        JL_Admin.setBounds(120, 20, 93, 28);

        JB_CerrarSesion.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        JB_CerrarSesion.setText("Cerrar sesión");
        JB_CerrarSesion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JB_CerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_CerrarSesionActionPerformed(evt);
            }
        });
        JP_Encabezado.add(JB_CerrarSesion);
        JB_CerrarSesion.setBounds(720, 20, 140, 29);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/FondoNegro.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        JP_Encabezado.add(jLabel1);
        jLabel1.setBounds(0, 0, 950, 70);

        JP_Principal.add(JP_Encabezado);
        JP_Encabezado.setBounds(0, 0, 955, 70);

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

        JP_Alumno.setBackground(new java.awt.Color(0, 153, 0));

        JB_AgregarMateria.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        JB_AgregarMateria.setText("Agregar Materia");
        JB_AgregarMateria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JB_AgregarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_AgregarMateriaActionPerformed(evt);
            }
        });

        JT_nMateria.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        JT_nMateria.setText("Nombre de la materia");
        JT_nMateria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JT_nMateriaMouseClicked(evt);
            }
        });

        JB_AgregarProfesor.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        JB_AgregarProfesor.setText("Agregar Profesor");
        JB_AgregarProfesor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JB_AgregarProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_AgregarProfesorActionPerformed(evt);
            }
        });

        JT_nProfesor.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        JT_nProfesor.setText("Nombre del Profesor");
        JT_nProfesor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JT_nProfesorMouseClicked(evt);
            }
        });

        JT_descripcionProfesor.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        JT_descripcionProfesor.setText("Descripción del Profesor");
        JT_descripcionProfesor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JT_descripcionProfesorMouseClicked(evt);
            }
        });
        JT_descripcionProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JT_descripcionProfesorActionPerformed(evt);
            }
        });

        JB_ModificarUsuario.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        JB_ModificarUsuario.setText("Modificar Usuario");
        JB_ModificarUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JB_ModificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_ModificarUsuarioActionPerformed(evt);
            }
        });

        JT_Cedula.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        JT_Cedula.setText("Cédula del usuario");
        JT_Cedula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JT_CedulaMouseClicked(evt);
            }
        });

        JT_cedulaProfesor.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        JT_cedulaProfesor.setText("Cédula del Profesor");
        JT_cedulaProfesor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JT_cedulaProfesorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JP_AlumnoLayout = new javax.swing.GroupLayout(JP_Alumno);
        JP_Alumno.setLayout(JP_AlumnoLayout);
        JP_AlumnoLayout.setHorizontalGroup(
            JP_AlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_AlumnoLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(JP_AlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_AlumnoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JB_AgregarProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))
                    .addGroup(JP_AlumnoLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(JB_ModificarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))
                    .addGroup(JP_AlumnoLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(JB_AgregarMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JT_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JP_AlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(JT_descripcionProfesor, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(JT_cedulaProfesor, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(JT_nProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JT_nMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        JP_AlumnoLayout.setVerticalGroup(
            JP_AlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_AlumnoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(JT_nMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JB_AgregarMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(JT_nProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JT_descripcionProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JT_cedulaProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JB_AgregarProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(JT_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JB_ModificarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );

        JP_Principal.add(JP_Alumno);
        JP_Alumno.setBounds(600, 70, 350, 486);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JP_Principal, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JP_Principal, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JB_CerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_CerrarSesionActionPerformed
        cp.setUser(" ");
        mostrarDefault();
    }//GEN-LAST:event_JB_CerrarSesionActionPerformed

    private void JB_AgregarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_AgregarMateriaActionPerformed

//        if(soloNumero(JT_numProfesor.getText())==true && MaxProfesores>=Integer.parseInt(JT_numProfesor.getText()))
//        {
            if(JT_nMateria.getText().equals("Nombre de la materia")==true || /*JT_numProfesor.getText().equals("Numero de profesores")==true ||*/ 
            JT_nMateria.getText().equals("")==true)// || JT_numProfesor.getText().equals("")==true)
            {
                JOptionPane.showMessageDialog(null, "Campo de texto no valido");
            }
            else
            {
//                A_Materia archivo=new A_Materia();
                JOptionPane.showMessageDialog(null, cp.cargarMateria(JT_nMateria.getText(),true));//,Integer.parseInt(JT_numProfesor.getText())));
                mostrarLista();
            }
//        }
//        else
//            JOptionPane.showMessageDialog(null, "Ingrese un numero valido \n maximo " + MaxProfesores +" profesores");
    }//GEN-LAST:event_JB_AgregarMateriaActionPerformed

    private void JT_nMateriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JT_nMateriaMouseClicked
        JT_nMateria.setText("");
    }//GEN-LAST:event_JT_nMateriaMouseClicked

    private void JT_nProfesorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JT_nProfesorMouseClicked
        JT_nProfesor.setText("");
    }//GEN-LAST:event_JT_nProfesorMouseClicked

    private void JT_descripcionProfesorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JT_descripcionProfesorMouseClicked
        JT_descripcionProfesor.setText("");
    }//GEN-LAST:event_JT_descripcionProfesorMouseClicked

    private void JB_AgregarProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_AgregarProfesorActionPerformed
        if(JT_nProfesor.getText().equals("Nombre del profesor")==true || JT_descripcionProfesor.getText().equals("Descripcion del Profesor")==true || 
        JT_nProfesor.getText().equals("")==true || JT_descripcionProfesor.getText().equals("")==true || soloNumero(JT_cedulaProfesor.getText())==false)
            JOptionPane.showMessageDialog(null, "Campo de texto no valido");
        else if(cp.getPosicionMateria()==-1)
        {
               JOptionPane.showMessageDialog(null, "selecione una materia pra agregar el profesor");     
        }
        else
            JOptionPane.showMessageDialog(null, cp.cargarPeffil(JT_nProfesor.getText(), JT_descripcionProfesor.getText(),Integer.parseInt(JT_cedulaProfesor.getText()),true));
        mostrarLista();
    }//GEN-LAST:event_JB_AgregarProfesorActionPerformed

    private void JB_ModificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_ModificarUsuarioActionPerformed
        if(soloNumero(JT_Cedula.getText())==true && cp.buscarCedula(Integer.parseInt(JT_Cedula.getText()))!=-1)
        {
            cp.setCedula(JT_Cedula.getText());
            mostrarJP2();
        }
        else
            JOptionPane.showMessageDialog(null,"Cedula no registrada");
            
        
    }//GEN-LAST:event_JB_ModificarUsuarioActionPerformed

    private void JT_CedulaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JT_CedulaMouseClicked
        JT_Cedula.setText("");
    }//GEN-LAST:event_JT_CedulaMouseClicked

    private void JT_cedulaProfesorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JT_cedulaProfesorMouseClicked
        JT_cedulaProfesor.setText("");
    }//GEN-LAST:event_JT_cedulaProfesorMouseClicked

    private void JT_descripcionProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JT_descripcionProfesorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JT_descripcionProfesorActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_AgregarMateria;
    private javax.swing.JButton JB_AgregarProfesor;
    private javax.swing.JButton JB_CerrarSesion;
    private javax.swing.JButton JB_ModificarUsuario;
    private javax.swing.JLabel JL_Admin;
    private javax.swing.JPanel JP_Alumno;
    private javax.swing.JPanel JP_Encabezado;
    private javax.swing.JPanel JP_Lista;
    private javax.swing.JPanel JP_Principal;
    private javax.swing.JTextField JT_Cedula;
    private javax.swing.JTextField JT_cedulaProfesor;
    private javax.swing.JTextField JT_descripcionProfesor;
    private javax.swing.JTextField JT_nMateria;
    private javax.swing.JTextField JT_nProfesor;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
