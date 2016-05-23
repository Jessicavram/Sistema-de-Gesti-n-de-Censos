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
public class DatosConcubinato extends Datos{

    /**
     * 
     */
    
    public DatosConcubinato(Interna in) 
    {
        super(in);
        initComponents();
        
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
        jLabel8.setFont(Etiqueta);
        jLabel8.setForeground(NegroEtiqueta);
        
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
 
            ZipEntry entry = new ZipEntry(f.getPath().substring(19));
            zos.putNextEntry(entry);
   
            if(f.getPath().compareTo("cartas\\concubinato\\word\\document.xml")==0)
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
                salida.output(documentJDOM,new FileOutputStream("cartas\\concubinato\\word\\document.xml"));
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
        String nom = nomMenor.getText();
        String ced = cedMenor.getText();
        String nac1 = nac.getText();
        String nac2 = nacPareja.getText();
        int a = Integer.parseInt(anyos.getValue().toString());
        int m = Integer.parseInt(meses.getValue().toString());
        
        if(nac1.compareTo("")!=0 && nac2.compareTo("")!=0 && nom.compareTo("")!=0 && ced.compareTo("")!=0 && (a+m)>0)
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
            
            String param[] = new String[9];
            param[0]=h.apellido+" "+h.nombre+", "+nom;
            param[1]=nac1+", "+nac2+" ";
            param[2]=h.cedula+", "+ced;
            param[3]="CONCUBINATO";
            param[4]=tiempo;
            param[5]="RESIDENCIA FIJA EN: "+h.direccion+".";
            param[6]=String.valueOf(dia);
            param[7]=getMes(mes);
            param[8]=String.valueOf(annio);
            
            try
            {
                
            FileOutputStream fos = new FileOutputStream("cartas\\generada.docx");
            ZipOutputStream zos = new ZipOutputStream(fos);
        
            File f = new File("cartas\\concubinato");
        
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
            
            nomMenor.setText("");
            cedMenor.setText("");
            nac.setText("");
            nacPareja.setText("");
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
        jLabel1 = new javax.swing.JLabel();
        nomMenor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cedMenor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        anyos = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        meses = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        crear = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nacPareja = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        nac = new javax.swing.JTextField();

        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ElemKeyPressed(evt);
            }
        });

        jLabel1.setText("Nombre de la pareja:");

        nomMenor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ElemKeyPressed(evt);
            }
        });

        jLabel2.setText("Cédula de la pareja");

        cedMenor.addKeyListener(new java.awt.event.KeyAdapter() {
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

        crear.setText("Crear Documento");
        crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearActionPerformed(evt);
            }
        });
        crear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ElemKeyPressed(evt);
            }
        });

        jLabel7.setText("Datos Requeridos");

        jLabel6.setText("Nacionalidad de la pareja:");

        nacPareja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nacParejaElemKeyPressed(evt);
            }
        });

        jLabel8.setText("Nacionalidad:");

        nac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ElemKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel1))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomMenor, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nac, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(44, 44, 44)
                        .addComponent(nacPareja, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cedMenor, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(108, 108, 108))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jLabel3)
                        .addGap(56, 56, 56)
                        .addComponent(anyos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(meses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(380, 380, 380)
                        .addComponent(crear)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomMenor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cedMenor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(nacPareja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(nac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anyos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(meses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(crear)
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearActionPerformed
        evento();
    }//GEN-LAST:event_crearActionPerformed

    private void ElemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ElemKeyPressed
        if(evt.getKeyCode()==10)
        {
            evento();
        }
    }//GEN-LAST:event_ElemKeyPressed

    private void nacParejaElemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nacParejaElemKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_nacParejaElemKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner anyos;
    private javax.swing.JTextField cedMenor;
    private javax.swing.JButton crear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSpinner meses;
    private javax.swing.JTextField nac;
    private javax.swing.JTextField nacPareja;
    private javax.swing.JTextField nomMenor;
    // End of variables declaration//GEN-END:variables
}
