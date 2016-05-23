/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.util.Calendar;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Jessica
 */
public class Miembros extends Interna {

    /**
     * Creates new form Miembros
     */
    
    public String id_familia;
    public Fecha panel;
    public Familia f;
    
    public Miembros(JFrame previo) {
        super(previo,false);
        
        initComponents();
       
        this.setName("miembros");
        
        this.getContentPane().setBackground(ColorPrincipal);
        this.setBounds(dimForms);
        
        this.setTitle("SistemaComunal - Cargar Datos - Miembros");
        
        jLabel1.setFont(Etiqueta);
        jLabel1.setForeground(NegroEtiqueta);
        jLabel2.setFont(Etiqueta);
        jLabel2.setForeground(NegroEtiqueta);
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
        
        titulo1.setFont(Titulo);
        titulo1.setForeground(NegroEtiqueta);
        
        jLabel13.setFont(Etiqueta);
        jLabel13.setForeground(RojoEtiqueta);
        jLabel14.setFont(Etiqueta);
        jLabel14.setForeground(RojoEtiqueta);
        jLabel15.setFont(Etiqueta);
        jLabel15.setForeground(RojoEtiqueta);
        jLabel16.setFont(Etiqueta);
        jLabel16.setForeground(RojoEtiqueta);
        jLabel17.setFont(Etiqueta);
        jLabel17.setForeground(RojoEtiqueta);
        jLabel18.setFont(Etiqueta);
        jLabel18.setForeground(RojoEtiqueta);
        
        radioV.setFont(Etiqueta);
        radioV.setForeground(NegroEtiqueta);
        radioV.setBackground(ColorPrincipal);
        radioE.setFont(Etiqueta);
        radioE.setForeground(NegroEtiqueta);
        radioE.setBackground(ColorPrincipal);
        radioM.setFont(Etiqueta);
        radioM.setForeground(NegroEtiqueta);
        radioM.setBackground(ColorPrincipal);
        radioF.setFont(Etiqueta);
        radioF.setForeground(NegroEtiqueta);
        radioF.setBackground(ColorPrincipal);
        radioBasica.setFont(Etiqueta);
        radioBasica.setForeground(NegroEtiqueta);
        radioBasica.setBackground(ColorPrincipal);
        radioBachiller.setFont(Etiqueta);
        radioBachiller.setForeground(NegroEtiqueta);
        radioBachiller.setBackground(ColorPrincipal);
        radioProf.setFont(Etiqueta);
        radioProf.setForeground(NegroEtiqueta);
        radioProf.setBackground(ColorPrincipal);
        radioMusculo.setFont(Etiqueta);
        radioMusculo.setForeground(NegroEtiqueta);
        radioMusculo.setBackground(ColorPrincipal);
        radioVA.setFont(Etiqueta);
        radioVA.setForeground(NegroEtiqueta);
        radioVA.setBackground(ColorPrincipal);
        radioIntel.setFont(Etiqueta);
        radioIntel.setForeground(NegroEtiqueta);
        radioIntel.setBackground(ColorPrincipal);
        radioN.setFont(Etiqueta);
        radioN.setForeground(NegroEtiqueta);
        radioN.setBackground(ColorPrincipal);
        radioOtra.setFont(Etiqueta);
        radioOtra.setForeground(NegroEtiqueta);
        radioOtra.setBackground(ColorPrincipal);
        radioA.setFont(Etiqueta);
        radioA.setForeground(NegroEtiqueta);
        radioA.setBackground(ColorPrincipal);
        
        radioV.setSelected(true);
        
        insertar.setFont(Boton);
        cancelar.setFont(Boton);
        
        panel = new Fecha();
        panel.setBounds(389,455,282,20);
        panel.setVisible(true);
        
        this.add(panel);
                
    }
    
    public String getValor(ButtonGroup group)
    {
        Enumeration<AbstractButton> en = group.getElements();
        String ret = "";
        while(en.hasMoreElements() && ret.compareTo("")==0)
        {
            AbstractButton ab = en.nextElement();
            if(ab.isSelected())
                ret=ab.getText();
        }
        return ret;
    }
    
    
    public void set_id_familia(String id)
    {
        id_familia=id;
    }

    
    public boolean insertar()
    {
        String stnom = nombre.getText();
        String stape = apellido.getText();
        String ced = cedula.getText().trim();
        String nac = getValor(nacionalidad);
        String stsexo = getValor(sexo);
        String stedu = getValor(educacion);
        String stdis = getValor(discapacidad);
        
        boolean ret=false;
        
        if(stnom.compareTo("")!=0 && stape.compareTo("")!=0 && stsexo.compareTo("")!=0 && ced.compareTo("")!=0 && panel.getFecha().compareTo("")!=0)
        {    
            try
            {
                String stced;
                if(ced.compareTo("")!=0)
                {
                    int x = Integer.parseInt(ced);
                    stced = nac+"-"+x;
                }
                else
                {
                     stced = "<<N/R>>";
                }  
                
                String datos[][] = (String[][])op.select("Persona","id","cedula='"+stced+"'", con);
                
                if(datos.length==0 || stced.compareTo("<<N/R>>")==0)
                {
                    op.insert("Persona","nombres, apellidos, cedula, sexo, educacion, discapacidad, fecha_nac, id_familia","'"+stnom+"', '"+stape+"', '"+stced+"', '"+stsexo+"', '"+stedu+"', '"+stdis+"', DATE('"+panel.getFecha()+"'), "+id_familia, con);
                    
                    ret=true;
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Cedula ya registrada");
                    cedula.setText("");
                } 
            }
            catch(NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(null, "El campo cedula debe ser numerico");
                cedula.setText("");
            }    
        }
            
        
        else
        {
            JOptionPane.showMessageDialog(null, "Complete todos los campos obligatorios");
        }
        return ret;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nacionalidad = new javax.swing.ButtonGroup();
        sexo = new javax.swing.ButtonGroup();
        educacion = new javax.swing.ButtonGroup();
        discapacidad = new javax.swing.ButtonGroup();
        jLabel19 = new javax.swing.JLabel();
        titulo1 = new javax.swing.JLabel();
        radioF = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        cedula = new javax.swing.JTextField();
        radioM = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        radioV = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        radioE = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        apellido = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        radioBasica = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        radioProf = new javax.swing.JRadioButton();
        radioBachiller = new javax.swing.JRadioButton();
        radioN = new javax.swing.JRadioButton();
        radioVA = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        radioMusculo = new javax.swing.JRadioButton();
        insertar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        radioIntel = new javax.swing.JRadioButton();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        radioOtra = new javax.swing.JRadioButton();
        radioA = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel19.setText("Los campos con (*) son obligatorios");

        titulo1.setText("Datos de Identificación del Miembro de la familia");

        sexo.add(radioF);
        radioF.setText("F");

        sexo.add(radioM);
        radioM.setText("M");

        jLabel13.setText("(*)");

        nacionalidad.add(radioV);
        radioV.setText("V");

        jLabel14.setText("(*)");

        nacionalidad.add(radioE);
        radioE.setText("E");

        jLabel17.setText("(*)");

        jLabel16.setText("(*)");

        jLabel1.setText("Fecha de Nacimiento");

        jLabel4.setText("Cédula de Identidad");

        jLabel3.setText("Apellidos");

        jLabel2.setText("Nombres");

        jLabel5.setText("Sexo");

        educacion.add(radioBasica);
        radioBasica.setText("Inicial/Basica");

        jLabel7.setText("Educación");

        educacion.add(radioProf);
        radioProf.setText("Profesional");

        educacion.add(radioBachiller);
        radioBachiller.setText("Bachiller");

        discapacidad.add(radioN);
        radioN.setText("Ninguna");

        discapacidad.add(radioVA);
        radioVA.setText("Visual/Auditiva");

        jLabel6.setText("Discapacidad");

        discapacidad.add(radioMusculo);
        radioMusculo.setText("Musculoesqueletica");
        radioMusculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioMusculoActionPerformed(evt);
            }
        });

        insertar.setText("Insertar");
        insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarActionPerformed(evt);
            }
        });

        cancelar.setText("Salir");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        discapacidad.add(radioIntel);
        radioIntel.setText("Intelectual");

        jLabel18.setText("(*)");

        discapacidad.add(radioOtra);
        radioOtra.setText("Otra");

        educacion.add(radioA);
        radioA.setText("Analfabeta");
        radioA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                radioAradioAction(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(jLabel19))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titulo1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addGap(48, 48, 48)
                                .addComponent(radioV)
                                .addGap(18, 18, 18)
                                .addComponent(radioE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(46, 46, 46)
                                                .addComponent(radioMusculo)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(radioVA)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(radioIntel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                                                .addComponent(radioOtra))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(radioA)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(radioBasica)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(radioBachiller)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(radioProf)
                                                .addGap(35, 35, 35))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel7)
                                                    .addComponent(jLabel5))
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel14))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addGap(21, 21, 21)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(radioM)
                                                .addGap(31, 31, 31)
                                                .addComponent(radioF))
                                            .addComponent(nombre)
                                            .addComponent(apellido))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radioN)
                                    .addComponent(jLabel15)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(324, 324, 324)
                        .addComponent(insertar)
                        .addGap(158, 158, 158)
                        .addComponent(cancelar)))
                .addContainerGap(306, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(titulo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(radioV)
                    .addComponent(radioE)
                    .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel15))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel13))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel14)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radioM)
                            .addComponent(radioF)
                            .addComponent(jLabel5)
                            .addComponent(jLabel17))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel16))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(radioBasica)
                            .addComponent(radioBachiller)
                            .addComponent(radioProf)
                            .addComponent(radioA))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(radioMusculo)
                            .addComponent(radioVA)
                            .addComponent(radioN)
                            .addComponent(radioIntel)
                            .addComponent(radioOtra))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(insertar)
                    .addComponent(cancelar))
                .addContainerGap(186, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void reset()
    {
        nombre.setText("");
        apellido.setText("");
        cedula.setText("");
        
        nacionalidad.clearSelection();
        sexo.clearSelection();
        discapacidad.clearSelection();
        educacion.clearSelection();
        
        panel.setFecha("");
        
        radioV.setSelected(true);
    }
    
    
    private void insertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarActionPerformed
        // TODO add your handling code here:
        boolean b = insertar();
        if(b)
        {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Miembro guardado. ¿desea agregar otro miembro?","", dialogButton);
            if(dialogResult == 0)
            {
                reset();
            } 
            else 
            {
                f=null;
                
                f = new Familia(prev);
                
                f.set_id_familia(id_familia);
                
                f.mostrar_jefe();
                
                f.mostrar_miembros();
   
                f.setVisible(true);
                this.setVisible(false);
            } 
        }
    }//GEN-LAST:event_insertarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        // TODO add your handling code here:
        
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "¿Desea salir sin guardar los datos?","", dialogButton);
            if(dialogResult == 0)
            {
                f=null;
                
                f = new Familia(prev);
                
                f.set_id_familia(id_familia);
                
                f.mostrar_jefe();
                
                f.mostrar_miembros();
   
                f.setVisible(true);
                this.setVisible(false);
            } 
        
  

    }//GEN-LAST:event_cancelarActionPerformed

    private void radioAradioAction(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioAradioAction
        // TODO add your handling code here:
    }//GEN-LAST:event_radioAradioAction

    private void radioMusculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioMusculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioMusculoActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellido;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField cedula;
    private javax.swing.ButtonGroup discapacidad;
    private javax.swing.ButtonGroup educacion;
    private javax.swing.JButton insertar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.ButtonGroup nacionalidad;
    private javax.swing.JTextField nombre;
    private javax.swing.JRadioButton radioA;
    private javax.swing.JRadioButton radioBachiller;
    private javax.swing.JRadioButton radioBasica;
    private javax.swing.JRadioButton radioE;
    private javax.swing.JRadioButton radioF;
    private javax.swing.JRadioButton radioIntel;
    private javax.swing.JRadioButton radioM;
    private javax.swing.JRadioButton radioMusculo;
    private javax.swing.JRadioButton radioN;
    private javax.swing.JRadioButton radioOtra;
    private javax.swing.JRadioButton radioProf;
    private javax.swing.JRadioButton radioV;
    private javax.swing.JRadioButton radioVA;
    private javax.swing.ButtonGroup sexo;
    private javax.swing.JLabel titulo1;
    // End of variables declaration//GEN-END:variables
}
