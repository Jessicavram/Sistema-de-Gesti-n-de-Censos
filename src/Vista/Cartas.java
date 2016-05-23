/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Habitante;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Jessica
 */
public class Cartas extends Interna {

    /**
     * Creates new form Cargar
     */
    
    JButton tipo[] = new JButton[6];
    
    Habitante h;
    
    int sel=-1;
    
    String datos[][];
    
    Datos generar[] = new Datos[6];
    
    public Cartas(JFrame previo) {
        
        super(previo,true);
        
        initComponents();
        
        this.setName("cartas");
        
        this.getContentPane().setBackground(ColorPrincipal);
        this.setBounds(dimForms);

        jLabel1.setFont(Etiqueta);
        jLabel1.setForeground(NegroEtiqueta);
        
        jLabel2.setFont(Etiqueta);
        jLabel2.setForeground(RojoEtiqueta);
        jLabel2.setVisible(false);
        
        jLabel3.setFont(Etiqueta);
        jLabel3.setForeground(NegroEtiqueta);
        
        jLabel4.setFont(Etiqueta);
        jLabel4.setForeground(NegroEtiqueta);
        
        jLabel5.setFont(Etiqueta);
        jLabel5.setForeground(NegroEtiqueta);
        
        jLabel6.setFont(Etiqueta);
        jLabel6.setForeground(NegroEtiqueta);
        
        jLabel7.setFont(Etiqueta);
        jLabel7.setForeground(NegroEtiqueta);
        
        jLabel8.setFont(Etiqueta);
        jLabel8.setForeground(NegroEtiqueta);
  
        jPanel1.setVisible(false);
        
        tipo[0]=carta1;
        generar[0] = new DatosPobreza(this);
        tipo[1]=carta2;
        generar[1] = new DatosVida(this);
        tipo[2]=carta3;
        generar[2] = new DatosMenor(this);
        tipo[3]=carta4;
        generar[3] = new DatosConcubinato(this);
        tipo[4]=carta5;
        generar[4] = new DatosResidencia(this);
        tipo[5]=carta6;
        generar[5] = new DatosViuda(this);
       
        for (int i = 0; i < tipo.length; i++)
        {
            tipo[i].setIcon(word);
            generar[i].setVisible(false);       
            tipo[i].setName(String.valueOf(i));
        }
        
        cbox.setVisible(false);
        bsel.setVisible(false);
          
        this.setTitle("SistemaComunal - Gestion de Cartas");
        
        buscar.setIcon(new ImageIcon("Imagenes/lupa.png"));
        
    }
    
    
    void desmarcar(int pos)
    {
        if(pos>=0)
        {
            tipo[pos].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
            generar[pos].setVisible(false);
        }
    }
    
    public void mostrar(int select)
    {
        String dirr = op.select("Familia","direccion","id="+datos[select][9], con)[0][0].toString();
            
        h = new Habitante();
        h.guardar_datos(datos[select]);
        h.guardar_direccion(dirr);
           
        if(datos[select][2].compareTo("<<N/R>>")!=0 && datos[select][3].compareTo("2100-01-01")!=0)
        {  
            for (int i = 0; i < generar.length; i++)
            {
                generar[i].h=h;
                this.add(generar[i]);
            }
            
            jPanel1.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Debe actualizar datos");
            this.setVisible(false);
            prev.fun.i = new Actualizar(prev); 
            Session.activa=prev.fun.i.getName();
            ((Actualizar)prev.fun.i).datos = get_datos(datos[select]);
            ((Actualizar)prev.fun.i).mostrar(0);
            prev.fun.i.setVisible(true);
        }
    }
    
    void marcar(int pos)
    {
        tipo[pos].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,175, 0), 2));
    }
           
     public void accion()
    {
        
        if(!jPanel1.isVisible())
        {
        
        String xced = cedula.getText().trim();
            
        datos = (String[][])op.select("Persona","nombres, apellidos, cedula, fecha_nac, sexo, educacion, ocupacion, discapacidad, id, id_familia","cedula='V-"+xced+"' or cedula='E-"+xced+"' or LOWER(nombres) LIKE LOWER('%"+xced+"%') or LOWER(apellidos) LIKE LOWER('%"+xced+"%')",con);
        
        if(datos.length>0)
        {
            
            cbox.removeAllItems();
            cbox.addItem("<< Seleccione una persona de la lista >>");
            jLabel2.setVisible(false);
            
            for (int i = 0; i < datos.length; i++) 
            {
                if(datos[i][2]=="")
                    datos[i][2]="<<N/R>>";
                String item = datos[i][0]+" "+datos[i][1]+", C.I: "+datos[i][2];
                
                cbox.addItem(item);
            }
            
            cbox.setVisible(true);
            bsel.setVisible(true);
        }
        else
        {
            jLabel2.setVisible(true);
            cedula.setText("");
            jPanel1.setVisible(false);
            for (int i = 0; i < generar.length; i++) 
            {
                generar[i].setVisible(false);
            }
        }
        
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

        jLabel1 = new javax.swing.JLabel();
        buscar = new javax.swing.JButton();
        cedula = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        carta1 = new javax.swing.JButton();
        carta2 = new javax.swing.JButton();
        carta3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        carta4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        carta5 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        carta6 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cbox = new javax.swing.JComboBox<>();
        bsel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Buscar ");

        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedulaActionPerformed(evt);
            }
        });
        cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cedulaformKeyPressed(evt);
            }
        });

        jLabel2.setText("No se encontraron personas con los datos suministrados.");

        carta1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        carta1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cartaMousePressed(evt);
            }
        });
        carta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carta1ActionPerformed(evt);
            }
        });

        carta2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        carta2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cartaMousePressed(evt);
            }
        });
        carta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carta2ActionPerformed(evt);
            }
        });

        carta3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        carta3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cartaMousePressed(evt);
            }
        });

        jLabel3.setText("Carta de Pobreza");

        jLabel4.setText("Fé de Vida");

        jLabel5.setText("Constancia Menor");

        carta4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        carta4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cartaMousePressed(evt);
            }
        });
        carta4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carta4ActionPerformed(evt);
            }
        });

        jLabel6.setText("Carta Concubinato");

        carta5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        carta5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cartaMousePressed(evt);
            }
        });

        jLabel7.setText("Carta de Residencia");

        carta6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        carta6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cartaMousePressed(evt);
            }
        });

        jLabel8.setText("Carta de Viudez");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(carta3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(carta2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(carta1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(carta4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(carta5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(carta6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(carta5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(carta1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(carta2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(carta3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(carta6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(carta4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<< seleccione una persona de la lista >>" }));
        cbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxActionPerformed(evt);
            }
        });

        bsel.setText("Seleccionar");
        bsel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bselActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(284, 284, 284)
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(233, 233, 233)
                                    .addComponent(cbox, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(bsel))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bsel))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(372, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
        accion();

    }//GEN-LAST:event_buscarActionPerformed

    private void cedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedulaActionPerformed

    private void cedulaformKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cedulaformKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            accion();
        }
    }//GEN-LAST:event_cedulaformKeyPressed

    private void cartaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaMousePressed
        // TODO add your handling code here:
        JButton b = (JButton)evt.getComponent();
        
        int pos = Integer.parseInt(b.getName());
        
        
        desmarcar(sel);
        marcar(pos);
        sel=pos;
        
        generar[pos].setVisible(true);
    }//GEN-LAST:event_cartaMousePressed

    private void carta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carta2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carta2ActionPerformed

    private void carta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carta1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carta1ActionPerformed

    private void carta4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carta4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carta4ActionPerformed

    private void cboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxActionPerformed

    private void bselActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bselActionPerformed
   
        int x=cbox.getSelectedIndex();
        if(x>0)
        {
            mostrar(x-1);
            cbox.setVisible(false);
            bsel.setVisible(false);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una persona de la lista");
        }
        
    }//GEN-LAST:event_bselActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bsel;
    private javax.swing.JButton buscar;
    private javax.swing.JButton carta1;
    private javax.swing.JButton carta2;
    private javax.swing.JButton carta3;
    private javax.swing.JButton carta4;
    private javax.swing.JButton carta5;
    private javax.swing.JButton carta6;
    private javax.swing.JComboBox<String> cbox;
    private javax.swing.JTextField cedula;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private String[][] get_datos(String[] d) 
    {
        String ret[][] = new String[1][d.length-1];
        ret[0][0]=d[0];
        ret[0][1]=d[1];
        for (int i = 2; i < ret[0].length; i++) 
        {
            ret[0][i]=d[i+1];   
        }
        ret[0][ret[0].length-1]=d[2];
        return ret;
    }
}
