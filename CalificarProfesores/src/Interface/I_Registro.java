package Interface;

import CP.*;
import javax.swing.JOptionPane;

public class I_Registro extends javax.swing.JPanel 
{
    CalificarProfesor cp;


    public I_Registro(CalificarProfesor cp) 
    {
        this.cp = cp;
        initComponents();
        buttonGroup1.add(rbAlumno);
        buttonGroup1.add(rbProfesor);
        jpCodigo.setVisible(false);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jNombre = new javax.swing.JLabel();
        jApellido = new javax.swing.JLabel();
        jCedula = new javax.swing.JLabel();
        jUsuario = new javax.swing.JLabel();
        jContraseña = new javax.swing.JLabel();
        tApellido = new javax.swing.JTextField();
        tCedula = new javax.swing.JTextField();
        tUsuario = new javax.swing.JTextField();
        tContraseña = new javax.swing.JTextField();
        bGuardar = new javax.swing.JButton();
        bSalir = new javax.swing.JButton();
        tNombre = new javax.swing.JTextField();
        rbAlumno = new javax.swing.JRadioButton();
        rbProfesor = new javax.swing.JRadioButton();
        jpCodigo = new javax.swing.JPanel();
        jContraseña1 = new javax.swing.JLabel();
        tCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 102));
        setLayout(null);

        jNombre.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jNombre.setForeground(new java.awt.Color(255, 255, 255));
        jNombre.setText("Nombre");
        add(jNombre);
        jNombre.setBounds(317, 105, 75, 26);

        jApellido.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jApellido.setForeground(new java.awt.Color(255, 255, 255));
        jApellido.setText("Apellido");
        add(jApellido);
        jApellido.setBounds(320, 150, 80, 26);

        jCedula.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jCedula.setForeground(new java.awt.Color(255, 255, 255));
        jCedula.setText("Cédula");
        add(jCedula);
        jCedula.setBounds(330, 190, 63, 22);

        jUsuario.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jUsuario.setText("Usuario");
        add(jUsuario);
        jUsuario.setBounds(320, 230, 80, 20);

        jContraseña.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jContraseña.setForeground(new java.awt.Color(255, 255, 255));
        jContraseña.setText("Contraseña");
        jContraseña.setName(""); // NOI18N
        add(jContraseña);
        jContraseña.setBounds(292, 271, 100, 26);

        tApellido.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        add(tApellido);
        tApellido.setBounds(400, 150, 220, 20);

        tCedula.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        add(tCedula);
        tCedula.setBounds(400, 190, 220, 20);

        tUsuario.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        add(tUsuario);
        tUsuario.setBounds(401, 230, 220, 20);

        tContraseña.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        tContraseña.setMaximumSize(null);
        tContraseña.setName(""); // NOI18N
        add(tContraseña);
        tContraseña.setBounds(401, 272, 220, 20);

        bGuardar.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        bGuardar.setText("Guardar");
        bGuardar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarActionPerformed(evt);
            }
        });
        add(bGuardar);
        bGuardar.setBounds(304, 445, 112, 29);

        bSalir.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        bSalir.setText("Regresar");
        bSalir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });
        add(bSalir);
        bSalir.setBounds(512, 444, 110, 30);

        tNombre.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        add(tNombre);
        tNombre.setBounds(400, 110, 220, 20);

        rbAlumno.setBackground(java.awt.Color.white);
        rbAlumno.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        rbAlumno.setForeground(new java.awt.Color(255, 255, 255));
        rbAlumno.setSelected(true);
        rbAlumno.setText("Alumno");
        rbAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAlumnoActionPerformed(evt);
            }
        });
        add(rbAlumno);
        rbAlumno.setBounds(339, 302, 85, 35);
        rbAlumno.setOpaque(false);

        rbProfesor.setBackground(java.awt.Color.white);
        rbProfesor.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        rbProfesor.setForeground(new java.awt.Color(255, 255, 255));
        rbProfesor.setText("Profesor");
        rbProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbProfesorActionPerformed(evt);
            }
        });
        add(rbProfesor);
        rbProfesor.setBounds(510, 302, 99, 35);
        rbProfesor.setOpaque(false);

        jContraseña1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jContraseña1.setForeground(java.awt.Color.white);
        jContraseña1.setText("Código");
        jContraseña1.setName(""); // NOI18N

        tCodigo.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        tCodigo.setMaximumSize(null);
        tCodigo.setName(""); // NOI18N
        tCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tCodigoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpCodigoLayout = new javax.swing.GroupLayout(jpCodigo);
        jpCodigo.setLayout(jpCodigoLayout);
        jpCodigoLayout.setHorizontalGroup(
            jpCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCodigoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jContraseña1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpCodigoLayout.setVerticalGroup(
            jpCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCodigoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jContraseña1)
                    .addComponent(tCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(338, 338, 338))
        );

        add(jpCodigo);
        jpCodigo.setBounds(290, 340, 340, 50);
        jpCodigo.setOpaque(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/FondoTurqueza.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1);
        jLabel1.setBounds(0, 0, 950, 550);
    }// </editor-fold>//GEN-END:initComponents

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_bGuardarActionPerformed

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        salir();
    }//GEN-LAST:event_bSalirActionPerformed

    private void rbAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAlumnoActionPerformed
        jpCodigo.setVisible(false);
    }//GEN-LAST:event_rbAlumnoActionPerformed

    private void rbProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbProfesorActionPerformed
        jpCodigo.setVisible(true);
    }//GEN-LAST:event_rbProfesorActionPerformed

    private void tCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tCodigoActionPerformed
    private boolean soloCaracter(String s)
    {
        String aux =s;
        int i;
        for (i= 0; i<s.length()&& aux.charAt(i)>='A'&& aux.charAt(i)<= 'z';i++);
    	    if(i==aux.length()&&i!=0)
	       return true;
        return false;
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
    private boolean contrasennaSegura(String s)
    {
	int i;
	boolean v1=false,v2=false,v3=false,v4=true;
	 	
     	for (i = 0; i<s.length() && v1==false;i++)
     	{
     	    if(s.charAt(i)>='0' && s.charAt(i)<= '9')
     		v1=true;
            if(s.charAt(i)>='A'&& s.charAt(i)<= 'Z')
     	        v2=true;
            if(s.charAt(i)==' ')
     	        v2=false;
	}
        if(s.length()>=8)
            v3=true;
            
	if(v1==true && v2==true && v3 ==true && v4==true)
	    return true;
	else
	    return false;
    }
    private boolean campoVacio()
    {
	if(tNombre.getText().length()==0 || tApellido.getText().length()==0 || tCedula.getText().length()==0 || tUsuario.getText().length()==0 | tContraseña.getText().length()==0)
            return true;
	 return false;
    }
    
    public String error()
    {
	String s=" ";
	 	
	if(campoVacio()==false)
	{
	    if(soloCaracter(tNombre.getText())==false)
     		s="El Nombre solo debe poseer caracteres \n";  
     					  			 				
	    if(soloCaracter(tApellido.getText())==false)
	       	s=s+"El Apellido solo debe poseer caracteres \n";
            
            if(soloCaracter(tUsuario.getText())==false)
	       	s=s+"El Usuario solo debe poseer caracteres \n";
	       	 		
	    if(tCedula.getText().length()>=7 && tCedula.getText().length()<=9)
	    {
	      	if(soloNumero(tCedula.getText())==false)
	    	    s=s+"La cedula solo debe poseer numeros";
	    }	    	
	    else
	      	s=s+"Ingrese un numero de cedula valido";
	      	    	
	    if(contrasennaSegura(tContraseña.getText())==false)
	        s="La contraseña no es segura debe contener al menos un numero, una letra mayuscula\n y un minimo de 8 caracteres";
	}
     	else
     	    s="Rellene todos los campos";
	    		 
	return s;		
    }
    private void guardar ()
     {
     	if(error().equals(" ")==true)
        {
            if(rbAlumno.isSelected()==true)
            {
                if(cp.buscarCedulaRegistro(Integer.parseInt(tCedula.getText()))==-1)                
                {
                    if(cp.buscarUsuarioRegistro(tUsuario.getText())==-1)
                    {
                        cp.registrarAlumno(tNombre.getText(),tApellido.getText(),Integer.parseInt(tCedula.getText()),tUsuario.getText(),tContraseña.getText(),true);
                        JOptionPane.showMessageDialog(null,"registro exitoso, ahora puede iniciar sesion");
                        mostrarEncabezado();
                    }
                    else
                       JOptionPane.showMessageDialog(null,"Usuario ya registrado");
                }
               else
                   JOptionPane.showMessageDialog(null,"cedula ya registrada");
            }
            else  if(rbProfesor.isSelected()==true)     
            {
                if(cp.buscarCedulaRegistro(Integer.parseInt(tCedula.getText()))==-1)
                {
                    if(cp.compararCodigoValidacion(tCodigo.getText()))
                    {
                        cp.registrarProfesor(tCodigo.getText(),tNombre.getText(),tApellido.getText(),Integer.parseInt(tCedula.getText()),tUsuario.getText(),tContraseña.getText(),true);
                        JOptionPane.showMessageDialog(null,"registro exitoso, ahora puede iniciar sesion");
                        mostrarEncabezado();
                    }
                    else                
                        JOptionPane.showMessageDialog(null,"Código de validacion incorrecto");                    
                }
                else
                    JOptionPane.showMessageDialog(null,"Cedula ya registrada");                 
            }                    
        }   
     	else
     	    JOptionPane.showMessageDialog(null,error());
        
     }
    
    private void salir ()
    {  
        String botones[]= {"Si", "No"};
        int option = JOptionPane.showOptionDialog(this, "¿Desea regresar?", "Advertencia", 0, JOptionPane.WARNING_MESSAGE, null, botones, this);

     	if(option==JOptionPane.YES_OPTION)
     	{
            mostrarEncabezado();        
     	}
    }
    private void mostrarEncabezado ()
    {
        I_Default encabezado = new I_Default(cp);
        encabezado.setSize(950,550);
        encabezado.setLocation(0,0);
        this.removeAll();
        this.add(encabezado);
        this.revalidate();
        this.repaint();
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bGuardar;
    private javax.swing.JButton bSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jApellido;
    private javax.swing.JLabel jCedula;
    private javax.swing.JLabel jContraseña;
    private javax.swing.JLabel jContraseña1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jNombre;
    private javax.swing.JLabel jUsuario;
    private javax.swing.JPanel jpCodigo;
    private javax.swing.JRadioButton rbAlumno;
    private javax.swing.JRadioButton rbProfesor;
    private javax.swing.JTextField tApellido;
    private javax.swing.JTextField tCedula;
    private javax.swing.JTextField tCodigo;
    private javax.swing.JTextField tContraseña;
    private javax.swing.JTextField tNombre;
    private javax.swing.JTextField tUsuario;
    // End of variables declaration//GEN-END:variables
}
