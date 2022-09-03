package Interface;

import CP.CalificarProfesor;
import CP.Persona;
import javax.swing.*;

public class I_Default extends javax.swing.JPanel {

    CalificarProfesor cp;
    
    public I_Default(CalificarProfesor cp)
    {
        this.cp=cp;
        initComponents();
        cp.importarA_Registro();
        mostrarLista();
    }
    private boolean validarCedula(String s)
    {
	String aux =s;
        boolean v1=false;
     	int i;
     	for (i= 0; i<s.length()&& aux.charAt(i)>='0'&& aux.charAt(i)<= '9';i++);
	    if(i==aux.length()&&i!=0)
	       v1=true;
        if(JT_Cedula.getText().length()>=7 && JT_Cedula.getText().length()<=9&& v1==true)
            return true;
        else	    
            return false;
    }
    
    private void iniciarSesion()
    {
//        cp.setPosicion(-1, -1, -1);
        cp.setUser(JT_Cedula.getText());
        if(cp.getAdmin().compararUsuario(cp.getUser())==true)
        {
            mostrarAdmin();
        }
        else if(cp.getRegistro().buscarCedula(Integer.parseInt(cp.getUser()))!=-1)
        {
            if(cp.getRegistro().getPersona(cp.getRegistro().buscarCedula(Integer.parseInt(cp.getUser()))).getClass().getSimpleName().equals("Alumno")==true)
                mostrarAlumno();           
            else
                mostrarProfesor();                  
        }       
    }
    
    private void mostrarAdmin()
    {
        I_Admin admin=new I_Admin(cp);
        admin.setSize(950,550);
        cargar(this.JP_Principal,admin);      
    }
    
    private void mostrarAlumno()
    {
        I_Alumno alumno=new I_Alumno(cp);
        alumno.setSize(950,550);
        cargar(this.JP_Principal,alumno);
    }

    private void mostrarProfesor()
    {
        I_Profesor profesor=new I_Profesor(cp);
        profesor.setSize(950,550);
        cargar(this.JP_Principal,profesor);
    }
    
    private void mostrarLista()
    {
        I_Lista_Materia lista=new I_Lista_Materia(cp);
        lista.setSize(620,480);
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
        bRegistrar = new javax.swing.JButton();
        bIniciar = new javax.swing.JButton();
        JL_Contraseña = new javax.swing.JLabel();
        JL_Cedula = new javax.swing.JLabel();
        JT_Contraseña = new javax.swing.JTextField();
        JT_Cedula = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JP_Lista = new javax.swing.JPanel();
        JP_Default = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setVerifyInputWhenFocusTarget(false);
        setLayout(null);

        JP_Encabezado.setBackground(new java.awt.Color(0, 204, 102));
        JP_Encabezado.setLayout(null);

        bRegistrar.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        bRegistrar.setText("Registrar");
        bRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRegistrarActionPerformed(evt);
            }
        });
        JP_Encabezado.add(bRegistrar);
        bRegistrar.setBounds(770, 20, 150, 30);

        bIniciar.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        bIniciar.setText("Inciar Sesión");
        bIniciar.setToolTipText("");
        bIniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bIniciarActionPerformed(evt);
            }
        });
        JP_Encabezado.add(bIniciar);
        bIniciar.setBounds(600, 20, 150, 30);

        JL_Contraseña.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        JL_Contraseña.setForeground(new java.awt.Color(255, 255, 255));
        JL_Contraseña.setText("Contraseña");
        JP_Encabezado.add(JL_Contraseña);
        JL_Contraseña.setBounds(440, 10, 120, 20);

        JL_Cedula.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        JL_Cedula.setForeground(new java.awt.Color(255, 255, 255));
        JL_Cedula.setText("Cédula");
        JP_Encabezado.add(JL_Cedula);
        JL_Cedula.setBounds(270, 10, 58, 20);

        JT_Contraseña.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        JT_Contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JT_ContraseñaActionPerformed(evt);
            }
        });
        JP_Encabezado.add(JT_Contraseña);
        JT_Contraseña.setBounds(410, 30, 160, 20);

        JT_Cedula.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        JP_Encabezado.add(JT_Cedula);
        JT_Cedula.setBounds(220, 30, 160, 20);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Logo UDO proyecto.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        JP_Encabezado.add(jLabel5);
        jLabel5.setBounds(70, 0, 80, 70);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/FondoTurqueza.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        JP_Encabezado.add(jLabel4);
        jLabel4.setBounds(0, 0, 950, 70);

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

        JP_Default.setBackground(new java.awt.Color(0, 204, 102));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel1.setText("Aqui puedes buscar calificaciones ");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel2.setText("y opiniones sobre los profesores.");

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel3.setText("¡Registrate y aporta tu comentario!");

        javax.swing.GroupLayout JP_DefaultLayout = new javax.swing.GroupLayout(JP_Default);
        JP_Default.setLayout(JP_DefaultLayout);
        JP_DefaultLayout.setHorizontalGroup(
            JP_DefaultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_DefaultLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(JP_DefaultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        JP_DefaultLayout.setVerticalGroup(
            JP_DefaultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_DefaultLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 303, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );

        javax.swing.GroupLayout JP_PrincipalLayout = new javax.swing.GroupLayout(JP_Principal);
        JP_Principal.setLayout(JP_PrincipalLayout);
        JP_PrincipalLayout.setHorizontalGroup(
            JP_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_PrincipalLayout.createSequentialGroup()
                .addGroup(JP_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JP_Encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JP_PrincipalLayout.createSequentialGroup()
                        .addComponent(JP_Lista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(JP_Default, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        JP_PrincipalLayout.setVerticalGroup(
            JP_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_PrincipalLayout.createSequentialGroup()
                .addComponent(JP_Encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(JP_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JP_Lista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JP_Default, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        add(JP_Principal);
        JP_Principal.setBounds(0, 0, 950, 550);
    }// </editor-fold>//GEN-END:initComponents

    private void bIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bIniciarActionPerformed
        cp.setUser(JT_Cedula.getText());
        
        if(validarCedula(JT_Cedula.getText())==true)
        {
            int i=cp.buscarCedula(Integer.parseInt(JT_Cedula.getText()));
            if(i==-1)
                JOptionPane.showMessageDialog(null,"Cedula no registrada");
            else if(cp.compararContrseña(JT_Contraseña.getText())==true)
                iniciarSesion();
            else
            JOptionPane.showMessageDialog(null,"Contraseña invalida");
        }
        else if(cp.getAdmin().compararUsuario(JT_Cedula.getText())==true)
        {
            if(cp.getAdmin().compararContrasenna(JT_Contraseña.getText())==true)
                iniciarSesion();
            else
                JOptionPane.showMessageDialog(null,"cedula no valida");
        }
        else
        {
            cp.setUser(JT_Cedula.getText());
            JOptionPane.showMessageDialog(null,"cedula no valida");
        }
    }//GEN-LAST:event_bIniciarActionPerformed

    private void bRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRegistrarActionPerformed

        I_Registro registro = new I_Registro(cp);
        registro.setSize (950,550);
        cargar(this.JP_Principal,registro);
    }//GEN-LAST:event_bRegistrarActionPerformed

    private void JT_ContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JT_ContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JT_ContraseñaActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JL_Cedula;
    private javax.swing.JLabel JL_Contraseña;
    private javax.swing.JPanel JP_Default;
    private javax.swing.JPanel JP_Encabezado;
    private javax.swing.JPanel JP_Lista;
    private javax.swing.JPanel JP_Principal;
    private javax.swing.JTextField JT_Cedula;
    private javax.swing.JTextField JT_Contraseña;
    private javax.swing.JButton bIniciar;
    private javax.swing.JButton bRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
