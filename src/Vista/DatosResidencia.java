/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Habitante;
import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.swing.JOptionPane;
import org.jdom.*;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

/**
 *
 * @author Jessica
 */
public class DatosResidencia extends Datos{

    /**
     * 
     */
    
    public DatosResidencia(Interna in) 
    {
        super(in);
        initComponents();
        
        jLabel3.setFont(Etiqueta);
        jLabel3.setForeground(NegroEtiqueta);
        jLabel4.setFont(Etiqueta);
        jLabel4.setForeground(NegroEtiqueta);
        jLabel5.setFont(Etiqueta);
        jLabel5.setForeground(NegroEtiqueta);
        
        jLabel7.setFont(Titulo);
        jLabel7.setForeground(NegroEtiqueta);
            
    }
    
    
    public static void crear_docx(String[] param,ZipOutputStream zos, File f) throws FileNotFoundException, IOException, JDOMException
    {
        if(f.isDirectory())
        {
            String[] data=f.list();
            for (String data1 : data)
            {
                crear_docx(param,zos, new File(f.getPath()+"/" + data1));
            }
        }
        else
        {
 
            ZipEntry entry = new ZipEntry(f.getPath().substring(18));
            zos.putNextEntry(entry);
   
            if(f.getPath().compareTo("cartas\\residencia\\word\\document.xml")==0)
            {
                SAXBuilder builder = new SAXBuilder();  
                Document documentJDOM = builder.build(new FileInputStream(f));   
                List<Element> lista, Lpag, p1, p2;
                lista = documentJDOM.getRootElement().getChildren();
                Lpag = lista.get(0).getChildren();
                p1 = Lpag.get(2).getChildren();
                p2 = Lpag.get(3).getChildren();
                int pos=0;
 
                for(Element e: p1)
                {
                    if(e.getName().compareTo("r")==0)
                    {
                        List<Attribute> Lattr = e.getAttributes();
                        if(Lattr.size()>0)
                        {
                            if(Lattr.get(0).getValue().compareTo("00DB684A")==0)
                            {
                                List<Element> listR = e.getChildren();
                                listR.get(1).setText(param[pos]);
                                pos++;
                            }
                        }
                    }
                }
        
                for(Element e: p2)
                {
                    if(e.getName().compareTo("r")==0)
                    {
                        List<Attribute> Lattr = e.getAttributes();
                        if(Lattr.size()>0)
                        {
                            if(Lattr.get(0).getValue().compareTo("00DB684A")==0)
                            {
                                List<Element> listR = e.getChildren();
                                listR.get(1).setText(param[pos]);
                                pos++;
                            }
                        }
                    }
                }
        
                XMLOutputter salida = new XMLOutputter();
                salida.output(documentJDOM,new FileOutputStream("cartas\\residencia\\word\\document.xml"));
            }
            
            BufferedReader buffer = new BufferedReader(new FileReader(f));
          
            String linea=buffer.readLine();
            while(linea!=null)
            {
                zos.write(linea.getBytes());
                linea=buffer.readLine();
            }
            zos.closeEntry(); 
        }
    }
    
    
    
    public void evento()
    {
        int a = Integer.parseInt(anyos.getValue().toString());
        int m = Integer.parseInt(meses.getValue().toString());
        
        if((a+m)>0)
        {
            
            String tiempo="";
    
            if(a==1)
            tiempo="1 Año";
            else if(a>1)
            tiempo=a+" Años";
            if(m>0)
            {
                String meses="";
                if(m==1)
                meses="1 Mes";
                else if(m>1)
                meses=m+" Meses";
                if(tiempo.length()>0)
                tiempo+=" y "+meses;
                else
                tiempo=meses;
            }
            
            Calendar c = Calendar.getInstance();
            
            int dia = c.get(Calendar.DATE);
            int mes = c.get(Calendar.MONTH);
            int annio = c.get(Calendar.YEAR);
            
            String param[] = new String[8];
            param[0]=h.apellido;
            param[1]=" "+h.nombre;
            param[2]=h.cedula;
            param[3]=h.direccion;
            param[4]=tiempo;
            param[5]=String.valueOf(dia);
            param[6]=getMes(mes);
            param[7]=String.valueOf(annio);
            
            try
            {
                
            FileOutputStream fos = new FileOutputStream("cartas\\generada.docx");
            ZipOutputStream zos = new ZipOutputStream(fos);
        
            File f = new File("cartas\\residencia");
        
            crear_docx(param,zos,f);
            zos.finish();
            zos.close();
            fos.close();
            
            }catch(FileNotFoundException ex)
            {
                
            }catch(IOException ex)
            {
                
            }catch(JDOMException ex)
            {
                
            }
         
            JOptionPane.showMessageDialog(null, "Carta generada exitosamente");
            
            try {
                Runtime.getRuntime().exec("cmd /c start cartas/generada.docx");
            } catch (IOException ex) {
 
            }
            
            anyos.setValue(0);
            meses.setValue(0);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Algunos campos estan vacios");
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

        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        anyos = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        meses = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        crear1 = new javax.swing.JButton();

        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ElemKeyPressed(evt);
            }
        });

        jLabel3.setText("Tiempo de residencia:");

        anyos.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        anyos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ElemKeyPressed(evt);
            }
        });

        jLabel4.setText("Años");

        meses.setModel(new javax.swing.SpinnerNumberModel(0, 0, 11, 1));
        meses.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ElemKeyPressed(evt);
            }
        });

        jLabel5.setText("Meses");

        jLabel7.setText("Datos Requeridos");

        crear1.setText("Crear Documento");
        crear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crear1ActionPerformed(evt);
            }
        });
        crear1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                crear1ElemKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 842, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(jLabel3)
                        .addGap(48, 48, 48)
                        .addComponent(anyos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(51, 51, 51)
                        .addComponent(meses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(crear1)
                .addGap(346, 346, 346))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(jLabel7)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(anyos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(meses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(31, 31, 31)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(crear1)
                .addContainerGap(34, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ElemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ElemKeyPressed
        if(evt.getKeyCode()==10)
        {
            evento();
        }
    }//GEN-LAST:event_ElemKeyPressed

    private void crear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crear1ActionPerformed
            evento();      
    }//GEN-LAST:event_crear1ActionPerformed

    private void crear1ElemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_crear1ElemKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_crear1ElemKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner anyos;
    private javax.swing.JButton crear1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSpinner meses;
    // End of variables declaration//GEN-END:variables
}
