package Interface;
import CP.*;
import javax.swing.*;
import Archivo.*;

public class I_JP2_Admin extends javax.swing.JPanel {

    CalificarProfesor cp;
    
    public I_JP2_Admin(CalificarProfesor cp) 
    {
        this.cp=cp;
        initComponents();
        buttonGroup1.add(this.RB_Bloquear);
        buttonGroup1.add(this.RB_NoBloquear);
        cargarJL_Cedula();
        cargarDatos();
    }
    private void cargarDatos()
    {
        this.JT_Nombre.setText(cp.getPersona().getNombre());
        this.JT_Apellido.setText(cp.getPersona().getApellido());
        this.JT_Usuario.setText(cp.getPersona().getUsuario());
    }
    private void mostrarDefault()
    {
        I_Default defecto=new I_Default(cp);
        defecto.setSize(950,550);
        cargar(this.JP_Principal,defecto);     
    }

    private void cargarJL_Cedula()
    {
        JLabel cedula =new JLabel();
        cedula.setText("Usuario a modificar: " +cp.getCedula());
        cedula.setSize(300, 50);
        cedula.setLocation(130, 56);
        cedula.setFont(new java.awt.Font("Tahoma", 0, 18));
        cedula.setForeground(new java.awt.Color(0, 0, 0));
        this.JP_Admin.add(cedula);
        this.JP_Admin.revalidate();
        this.JP_Admin.repaint();
    }
    private void mostrarAdmin()
    {
        I_Admin admin=new I_Admin(cp);
        admin.setSize(950,550);
        cargar(this.JP_Principal,admin);      
    }
    private void mostrarJP2()
    {
        I_JP2_Admin jp2=new I_JP2_Admin(cp);
        jp2.setSize(950, 550);
        cargar(this.JP_Principal,jp2);

    }
    private boolean campoVacio()
    {
	if(JT_Nombre.getText().length()==0 || JT_Apellido.getText().length()==0 || JT_Usuario.getText().length()==0 )
            return true;
	 return false;
    } 
    private boolean soloCaracter(String s)
    {
        String aux =s;
        int i;
        for (i= 0; i<s.length()&& aux.charAt(i)>='A'&& aux.charAt(i)<= 'z';i++);
    	    if(i==aux.length()&&i!=0)
	       return true;
        return false;
    }
    public String error()
    {
	String s=new String(" ");
	 	
	if(campoVacio()==false)
	{
	    if(soloCaracter(JT_Nombre.getText())==false)
     		s="El Nombre solo debe poseer caracteres \n";  
     					  			 				
	    if(soloCaracter(JT_Apellido.getText())==false)
	       	s=s+"El Apellido solo debe poseer caracteres \n";	    	
	}
     	else
     	    s="Rellene todos los campos";
	    		 
	return s;		
    }
    private void comprobarDatos()
    {
     	if(error().equals(" ")==true)
        {    
            int i=cp.buscarCedula(Integer.parseInt(cp.getCedula()));
            if(cp.getRegistro().getPersona(i).getClass().getSimpleName().equals("Profesor")&&RB_Bloquear.isSelected())
            {
                JOptionPane.showMessageDialog(null,"Es un profesor y no puede ser bloqueado");
            }
            else
            {
                cp.getRegistro().getPersona(i).setNombre(JT_Nombre.getText());
                cp.getRegistro().getPersona(i).setApellido(JT_Apellido.getText());
                cp.getRegistro().getPersona(i).setUsuario(JT_Usuario.getText());
                cp.getAdmin().bloqueadoAlumno(cp.getRegistro(), Integer.parseInt(cp.getCedula()), RB_Bloquear.isSelected());
                if(cp.getRegistro().getPersona(i).getClass().getSimpleName().equals("Alumno"))
                {
                    Alumno alumno= new Alumno(cp.getRegistro().getPersona(i).getNombre(),cp.getRegistro().getPersona(i).getApellido(),
                            cp.getRegistro().getPersona(i).getCedula(),cp.getRegistro().getPersona(i).getUsuario()
                            ,cp.getRegistro().getPersona(i).getContraseña());
                    alumno.setbloqueado(RB_Bloquear.isSelected());
                
                    A_Registro archivo=new A_Registro();
                    archivo.editarAlumno(alumno);
                }
                else
                {
                    Profesor profesor= new Profesor(cp.getRegistro().getPersona(i).getNombre(),cp.getRegistro().getPersona(i).getApellido(),
                            cp.getRegistro().getPersona(i).getCedula(),cp.getRegistro().getPersona(i).getUsuario()
                            ,cp.getRegistro().getPersona(i).getContraseña());
                
                    A_Registro archivo=new A_Registro();
                
                    archivo.editarProfesor(profesor);
                }          
                JOptionPane.showMessageDialog(null,"Modificacion exitosa \n");
            }                
        }
        else
            JOptionPane.showMessageDialog(null,error());
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        JP_Principal = new javax.swing.JPanel();
        JP_Encabezado = new javax.swing.JPanel();
        JL_Admin = new javax.swing.JLabel();
        JB_CerrarSesion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        JP_Admin = new javax.swing.JPanel();
        jUsuario1 = new javax.swing.JLabel();
        JT_Usuario = new javax.swing.JTextField();
        jApellido1 = new javax.swing.JLabel();
        JT_Apellido = new javax.swing.JTextField();
        jNombre1 = new javax.swing.JLabel();
        JT_Nombre = new javax.swing.JTextField();
        JB_Buscar = new javax.swing.JButton();
        JT_Cedula = new javax.swing.JTextField();
        RB_Bloquear = new javax.swing.JRadioButton();
        RB_NoBloquear = new javax.swing.JRadioButton();
        jButton3 = new javax.swing.JButton();
        JB_Guardar = new javax.swing.JButton();

        JP_Encabezado.setBackground(new java.awt.Color(0, 0, 0));
        JP_Encabezado.setLayout(null);

        JL_Admin.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        JL_Admin.setForeground(new java.awt.Color(255, 255, 255));
        JL_Admin.setText("Admin");
        JP_Encabezado.add(JL_Admin);
        JL_Admin.setBounds(120, 20, 93, 28);

        JB_CerrarSesion.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        JB_CerrarSesion.setText("Cerrar sesión");
        JB_CerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_CerrarSesionActionPerformed(evt);
            }
        });
        JP_Encabezado.add(JB_CerrarSesion);
        JB_CerrarSesion.setBounds(720, 20, 180, 35);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/FondoNegro.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        JP_Encabezado.add(jLabel1);
        jLabel1.setBounds(-5, 0, 960, 70);

        JP_Admin.setBackground(new java.awt.Color(0, 153, 0));

        jUsuario1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jUsuario1.setForeground(new java.awt.Color(255, 255, 255));
        jUsuario1.setText("Usuario");

        JT_Usuario.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        jApellido1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jApellido1.setForeground(new java.awt.Color(255, 255, 255));
        jApellido1.setText("Apellido");

        JT_Apellido.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        jNombre1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jNombre1.setForeground(new java.awt.Color(255, 255, 255));
        jNombre1.setText("Nombre");

        JT_Nombre.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        JB_Buscar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        JB_Buscar.setText("Buscar");
        JB_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_BuscarActionPerformed(evt);
            }
        });

        JT_Cedula.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        JT_Cedula.setText("Cédula");
        JT_Cedula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JT_CedulaMouseClicked(evt);
            }
        });

        RB_Bloquear.setBackground(new java.awt.Color(0, 153, 0));
        RB_Bloquear.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        RB_Bloquear.setText("Bloquear");

        RB_NoBloquear.setBackground(new java.awt.Color(0, 153, 0));
        RB_NoBloquear.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        RB_NoBloquear.setSelected(true);
        RB_NoBloquear.setText("Desbloquear/No Bloquear");

        jButton3.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jButton3.setText("Regresar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        JB_Guardar.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        JB_Guardar.setText("Guardar");
        JB_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_GuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JP_AdminLayout = new javax.swing.GroupLayout(JP_Admin);
        JP_Admin.setLayout(JP_AdminLayout);
        JP_AdminLayout.setHorizontalGroup(
            JP_AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_AdminLayout.createSequentialGroup()
                .addGroup(JP_AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_AdminLayout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(JB_Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JP_AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(JP_AdminLayout.createSequentialGroup()
                            .addGap(161, 161, 161)
                            .addComponent(RB_Bloquear, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(49, 49, 49)
                            .addComponent(RB_NoBloquear))
                        .addGroup(JP_AdminLayout.createSequentialGroup()
                            .addGap(128, 128, 128)
                            .addGroup(JP_AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(JP_AdminLayout.createSequentialGroup()
                                    .addComponent(jApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(JT_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(JP_AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(JP_AdminLayout.createSequentialGroup()
                                        .addComponent(jUsuario1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JT_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(JP_AdminLayout.createSequentialGroup()
                                        .addComponent(jNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(JT_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(141, 141, 141)
                            .addComponent(JB_Buscar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(JT_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_AdminLayout.createSequentialGroup()
                            .addGap(127, 127, 127)
                            .addComponent(jButton3))))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        JP_AdminLayout.setVerticalGroup(
            JP_AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_AdminLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jButton3)
                .addGap(50, 50, 50)
                .addGroup(JP_AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_AdminLayout.createSequentialGroup()
                        .addGroup(JP_AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JB_Buscar)
                            .addComponent(JT_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(106, 106, 106)
                        .addGroup(JP_AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RB_Bloquear)
                            .addComponent(RB_NoBloquear))
                        .addGap(36, 36, 36)
                        .addComponent(JB_Guardar))
                    .addGroup(JP_AdminLayout.createSequentialGroup()
                        .addGroup(JP_AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JT_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JP_AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jNombre1)
                            .addGroup(JP_AdminLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(JT_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16)
                        .addGroup(JP_AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JP_AdminLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JT_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(166, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JP_PrincipalLayout = new javax.swing.GroupLayout(JP_Principal);
        JP_Principal.setLayout(JP_PrincipalLayout);
        JP_PrincipalLayout.setHorizontalGroup(
            JP_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JP_Encabezado, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE)
            .addComponent(JP_Admin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JP_PrincipalLayout.setVerticalGroup(
            JP_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_PrincipalLayout.createSequentialGroup()
                .addComponent(JP_Encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JP_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JP_Principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JP_Principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JB_CerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_CerrarSesionActionPerformed
        cp.setUser(" ");
        mostrarDefault();
    }//GEN-LAST:event_JB_CerrarSesionActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        mostrarAdmin();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void JT_CedulaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JT_CedulaMouseClicked
        this.JT_Cedula.setText("");
    }//GEN-LAST:event_JT_CedulaMouseClicked

    private void JB_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_BuscarActionPerformed
        if(soloNumero(JT_Cedula.getText())==true && cp.buscarCedula(Integer.parseInt(JT_Cedula.getText()))!=-1)
            mostrarJP2();
        else
        {
            cp.setCedula(JT_Cedula.getText());
            JOptionPane.showMessageDialog(null,"Cedula no registrada");
        }
    }//GEN-LAST:event_JB_BuscarActionPerformed

    private void JB_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_GuardarActionPerformed
        comprobarDatos();
    }//GEN-LAST:event_JB_GuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_Buscar;
    private javax.swing.JButton JB_CerrarSesion;
    private javax.swing.JButton JB_Guardar;
    private javax.swing.JLabel JL_Admin;
    private javax.swing.JPanel JP_Admin;
    private javax.swing.JPanel JP_Encabezado;
    private javax.swing.JPanel JP_Principal;
    private javax.swing.JTextField JT_Apellido;
    private javax.swing.JTextField JT_Cedula;
    private javax.swing.JTextField JT_Nombre;
    private javax.swing.JTextField JT_Usuario;
    private javax.swing.JRadioButton RB_Bloquear;
    private javax.swing.JRadioButton RB_NoBloquear;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jApellido1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jNombre1;
    private javax.swing.JLabel jUsuario1;
    // End of variables declaration//GEN-END:variables
}
