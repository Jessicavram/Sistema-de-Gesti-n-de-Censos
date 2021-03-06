/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.util.Calendar;

/**
 *
 * @author Jessica
 */
public class Fecha extends javax.swing.JPanel implements Componentes{

    /**
     * Creates new form Fecha
     */
    public String meses[] = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
    public int total_dias[] = {31,28,31,30,31,30,31,31,30,31,30,31};
    int annio;
    
    
    
    public Fecha() 
    {
        initComponents();
        
        this.setBackground(ColorPrincipal);
        
        Calendar c = Calendar.getInstance();

        annio = c.get(Calendar.YEAR);
        
        for (int i = annio; i >= 1920; i--) 
        {
           anio.addItem(String.valueOf(i));
        }
        
        for (int i = 0; i < meses.length; i++) 
        {
            mes.addItem(meses[i]);
        }
        
        for (int i = 1; i <= 31; i++) 
        {
            dia.addItem(String.valueOf(i));
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

        dia = new javax.swing.JComboBox<>();
        mes = new javax.swing.JComboBox<>();
        anio = new javax.swing.JComboBox<>();

        dia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dia" }));

        mes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mes" }));
        mes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                mesItemStateChanged(evt);
            }
        });
        mes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesActionPerformed(evt);
            }
        });

        anio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Año" }));
        anio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                anioItemStateChanged(evt);
            }
        });
        anio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mes, 0, 142, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(anio, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void mesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesActionPerformed
      
        int m = mes.getSelectedIndex();
        int a = annio-anio.getSelectedIndex()+1;
        if(m>0 && a<=annio)
        {
            int x = total_dias[m-1];
            if(((a%4==0 && a%100!=0) || a%400==0) && m==2)
                x++;
            int select=dia.getSelectedIndex();
            set_dias(x);
            if(select>x)
                dia.setSelectedIndex(x);
            else
                dia.setSelectedIndex(select);
        }
    }//GEN-LAST:event_mesActionPerformed

    public void set_dias(int num)
    {
        dia.removeAllItems();
        dia.addItem("Dia");
        for (int i = 1; i <= num; i++) 
        {
            dia.addItem(String.valueOf(i));
        }
    }
    
    @Override
    public void setEnabled(boolean enable)
    {
        dia.setEnabled(enable);
        mes.setEnabled(enable);
        anio.setEnabled(enable);
        this.repaint();
    }
    
    
    public String getFecha()
    {
        int m = mes.getSelectedIndex();
        int a = annio-anio.getSelectedIndex()+1;
        int d = dia.getSelectedIndex();
        
        if(m>0 && d>0 && a<=annio)
            return a+"-"+m+"-"+d;
        else
            return "";
    }
    
    public void setFecha(String str)
    {
        if(str.compareTo("")!=0)
        {
            int a = Integer.parseInt(str.split("-")[0]);
            int m = Integer.parseInt(str.split("-")[1]);
            int d = Integer.parseInt(str.split("-")[2]);
        
            anio.setSelectedIndex(annio-a+1);
            mes.setSelectedIndex(m);
            dia.setSelectedIndex(d);
        }
        else
        {
            anio.setSelectedIndex(0);
            mes.setSelectedIndex(0);
            dia.setSelectedIndex(0);
        }
    }
    
    private void anioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_anioItemStateChanged
        
    }//GEN-LAST:event_anioItemStateChanged

    private void mesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_mesItemStateChanged
        
    }//GEN-LAST:event_mesItemStateChanged

    private void anioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anioActionPerformed
        int a = annio-anio.getSelectedIndex()+1;
        if(mes.getSelectedIndex()==2 && a<=annio)
        {
            int select=dia.getSelectedIndex();
            if((a%4==0 && a%100!=0) || a%400==0)
            {
                set_dias(29);
            }
            else
            {
                set_dias(28);
            }
            if(select>=dia.getItemCount())
            {  
                dia.setSelectedIndex(dia.getItemCount()-1); 
            }
            else
            {
                dia.setSelectedIndex(select);
            }
        }
    }//GEN-LAST:event_anioActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> anio;
    private javax.swing.JComboBox<String> dia;
    private javax.swing.JComboBox<String> mes;
    // End of variables declaration//GEN-END:variables
}
