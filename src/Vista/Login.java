/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
/**
 *
 * @author Jessica
 */

import Controlador.*;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame implements Componentes {
   
    Conexion cn;
    Operaciones op;
    Connection con;

    Cambiar c;
     
    Interna vista;
    
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        this.setVisible(false);
        this.setTitle("SistemaComunal - Login");
        
        jLabel1.setFont(Etiqueta);
        jLabel1.setForeground(NegroEtiqueta);
        
        jLabel2.setFont(Etiqueta);
        jLabel2.setForeground(NegroEtiqueta);
        
        iniciar.setFont(Boton);
        salir.setFont(Boton);
        jButton1.setFont(Boton);
        
        this.getContentPane().setBackground(ColorPrincipal);
        
        cn=new Conexion();
        op=new Operaciones();
        con=cn.AccederBD();
        
        if(con!=null)
        {
            this.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "El sistema ya se encuenta en uso");
            System.exit(0);
        }
            
    }
  
    public void borrar()
    {
        usuario.setText("");
        password.setText("");
    }

    public void accion()
    {
        String login = usuario.getText().trim();
        String pass = password.getText();
        
        if(login.compareTo("")!=0 && pass.compareTo("")!=0)
        {
            Object data[][] = op.select("Usuario","id, login","login='"+login+"' and password='"+pass+"'",con);
            if(data.length >0)
            {               
                String id = data[0][0].toString();      
                
                Session.log=this;
                Session.id=id;
                Session.login=data[0][1].toString();
                
                data = op.select("Usuario_Funcion","id_funcion","id_usuario="+id,con);
                
                
                String id_fun[] = new String[data.length];
                
                for (int i = 0; i < id_fun.length; i++) 
                {
                    id_fun[i] = data[i][0].toString();
                }
               
                
                vista = new Interna(null,false);
                vista.setName("vista");
                vista.setTitle("SistemaComunal - Home");
                vista.getContentPane().setBackground(ColorPrincipal);
                
                Object[][] dat;
                String[][] datosbd = new String[id_fun.length][];
                for (int i = 0; i < id_fun.length; i++)
                {
                    data = op.select("Funcion","descripcion, nombre, pantalla","id="+id_fun[i], con);
                    datosbd[i] = (String[])data[0];
                }
                
                Funciones fun = new Funciones(vista,datosbd);
                vista.fun=fun;
                vista.add(fun);
               
                Session.activa="vista";
               
                this.usuario.setText("");
                this.password.setText("");
                
                this.setVisible(false);
                vista.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Usuario y contraseña incorrectos");
                usuario.setText("");
                password.setText("");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Introduzca usuario y contraseña");
            usuario.setText("");
            password.setText("");
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iniciar = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        usuario = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 255));
        setBounds(new java.awt.Rectangle(200, 300, 350, 180));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("LoginFrame"); // NOI18N
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        iniciar.setText("Entrar");
        iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarActionPerformed(evt);
            }
        });
        iniciar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        salir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                salirKeyPressed(evt);
            }
        });

        usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setText("Usuario");

        jLabel2.setText("Contraseña");

        jButton1.setText("Cambiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addComponent(jSeparator2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void iniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarActionPerformed
       
        accion();
    }//GEN-LAST:event_iniciarActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            accion();
        }
    }//GEN-LAST:event_formKeyPressed

    private void salirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_salirKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            System.exit(0);
        }
    }//GEN-LAST:event_salirKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nom = usuario.getText();
        String data[][] = (String[][])op.select("Usuario","login, password","login='"+nom+"'",con);
        if(data.length==0)
        {
            JOptionPane.showMessageDialog(null, "Usuario no registrado.");
        }
        else
        {
             c = null;
             c = new Cambiar();
             c.set_data(data[0][0], data[0][1], this);
             this.setVisible(false);
             c.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton iniciar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton salir;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
