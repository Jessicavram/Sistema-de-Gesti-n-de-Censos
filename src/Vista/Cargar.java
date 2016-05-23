/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;


import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author Jessica
 */
public class Cargar extends Interna {

    /**
     * Creates new form Cargar
     */
    String id_familia;
    Fecha panel;
    String datos[][];
    Miembros m;
    Familia f;
    
    public Cargar(JFrame previo) {
        
        super(previo,true);
        
        initComponents();   
        
        this.getContentPane().setBackground(ColorPrincipal);
        this.setBounds(dimForms);
        
        this.setTitle("SistemaComunal - Cargar Datos");
        this.setName("cargar");
        
        titulo1.setFont(Titulo);
        titulo1.setForeground(NegroEtiqueta);
        
        jLabel1.setFont(Etiqueta);
        jLabel1.setForeground(NegroEtiqueta);
        jLabel20.setFont(Etiqueta);
        jLabel20.setForeground(NegroEtiqueta);
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
        jLabel10.setFont(Etiqueta);
        jLabel10.setForeground(NegroEtiqueta);
        jLabel8.setFont(Etiqueta);
        jLabel8.setForeground(NegroEtiqueta);
        jLabel11.setFont(Etiqueta);
        jLabel11.setForeground(NegroEtiqueta);
        jLabel12.setFont(Etiqueta);
        jLabel12.setForeground(NegroEtiqueta);
        
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
        radioOtra.setFont(Etiqueta);
        radioOtra.setForeground(NegroEtiqueta);
        radioOtra.setBackground(ColorPrincipal);
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
        radioA.setFont(Etiqueta);
        radioA.setForeground(NegroEtiqueta);
        radioA.setBackground(ColorPrincipal);
        
        radioV.setSelected(true);
        
        guardar.setFont(Boton);
        insertar.setFont(Boton);
        cancelar.setFont(Boton);
        
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
        
        jLabel19.setFont(Etiqueta);
        
        panel = new Fecha();
        panel.setBounds(574,371,282,20);
        panel.setVisible(true);
        
        this.add(panel);
        
        bsel.setVisible(false);
        cbox.setVisible(false);
        bsel1.setVisible(false);
        
 
    }

    public void deshabilitar_componentes() 
    {
        nombre.setEnabled(false);
        apellido.setEnabled(false);
        cedula.setEnabled(false);
        radioV.setEnabled(false);
        radioE.setEnabled(false);
        radioF.setEnabled(false);
        radioM.setEnabled(false);
        radioBasica.setEnabled(false);
        radioProf.setEnabled(false);
        radioBachiller.setEnabled(false);
        cargo.setEnabled(false);
        panel.setEnabled(false);
        vereda.setEnabled(false);
        casa.setEnabled(false);
        buscar.setEnabled(false);
    }
    
    public String insertar_familia()
    {
        String stvereda = vereda.getText().trim();
        String stcasa = casa.getText().trim();
        
        if(stvereda.compareTo("")!=0 || stcasa.compareTo("")!=0)
        {
            String dir ="";
            
            if(stvereda.compareTo("")!=0)
                 if(dir.compareTo("")!=0)
                    dir+=", Vereda "+stvereda;
                  else
                    dir="Vereda "+stvereda;
            
            if(stcasa.compareTo("")!=0)
                if(dir.compareTo("")!=0)
                    dir+=", Casa "+stcasa;
                else
                    dir+="Casa "+stcasa;
            
            op.insert("Familia","direccion, id_jefe","'"+dir+"', 1000", con);
            
            String id = op.select("Familia","id","id_jefe=1000",con)[0][0].toString();
            return id;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "El campo direccion esta vacio");
            return "";
        }    
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
    
    
    public boolean insertar_jefe(String id_familia)
    {
        String stnom = nombre.getText();
        String stape = apellido.getText();
        String ced = cedula.getText().trim();
        String nac = getValor(nacionalidad);
        String stsexo = getValor(sexo);
        String stedu = getValor(educacion);
        String stdis = getValor(discapacidad);
        String ocupacion = cargo.getText();
        
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
                
                    op.insert("Persona","nombres, apellidos, cedula, sexo, educacion, ocupacion, discapacidad, fecha_nac, id_familia","'"+stnom+"', '"+stape+"', '"+stced+"', '"+stsexo+"', '"+stedu+"', '"+ocupacion+"', '"+stdis+"', DATE('"+panel.getFecha()+"'), "+id_familia, con);
                
                    String id_jefe = op.select("Persona","id","id_familia="+id_familia, con)[0][0].toString();
                
                    op.update("Familia","id_jefe="+id_jefe,"id_jefe=1000", con);
                
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
                op.delete("Familia","id_jefe=1000", con);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Complete todos los campos obligatorios");
            op.delete("Familia","id_jefe=1000", con);
        }
        return ret;
    }
    
    public boolean insertar()
    {
        String id=insertar_familia();
        id_familia=id;
        if(id.compareTo("")!=0)
            return insertar_jefe(id);
        return false;
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
        titulo1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        apellido = new javax.swing.JTextField();
        radioV = new javax.swing.JRadioButton();
        radioE = new javax.swing.JRadioButton();
        cedula = new javax.swing.JTextField();
        radioM = new javax.swing.JRadioButton();
        radioF = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        cargo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        radioBasica = new javax.swing.JRadioButton();
        radioBachiller = new javax.swing.JRadioButton();
        radioProf = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        vereda = new javax.swing.JTextField();
        casa = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        guardar = new javax.swing.JButton();
        insertar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        buscar = new javax.swing.JButton();
        cbox = new javax.swing.JComboBox<>();
        bsel = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        radioN = new javax.swing.JRadioButton();
        radioVA = new javax.swing.JRadioButton();
        radioMusculo = new javax.swing.JRadioButton();
        radioIntel = new javax.swing.JRadioButton();
        radioOtra = new javax.swing.JRadioButton();
        bsel1 = new javax.swing.JButton();
        radioA = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        titulo1.setText("Datos de Identificación del Jefe del grupo familiar");

        jLabel3.setText("Apellidos");

        jLabel4.setText("Cédula de Identidad");

        jLabel1.setText("Fecha de Nacimiento");

        jLabel5.setText("Sexo");

        nacionalidad.add(radioV);
        radioV.setText("V");

        nacionalidad.add(radioE);
        radioE.setText("E");

        sexo.add(radioM);
        radioM.setText("M");

        sexo.add(radioF);
        radioF.setText("F");

        jLabel6.setText("Cargo Laboral");

        jLabel7.setText("Educación");

        educacion.add(radioBasica);
        radioBasica.setText("Inicial/Basica");

        educacion.add(radioBachiller);
        radioBachiller.setText("Bachiller");

        educacion.add(radioProf);
        radioProf.setText("Profesional");

        jLabel8.setText("Dirección");

        jLabel11.setText("Vereda");

        jLabel12.setText("# Casa");

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        insertar.setText("Insertar Miembros de la Familia");
        insertar.setEnabled(false);
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

        jLabel13.setText("(*)");

        jLabel14.setText("(*)");

        jLabel15.setText("(*)");

        jLabel16.setText("(*)");

        jLabel17.setText("(*)");

        jLabel18.setText("(*)");

        jLabel19.setText("Los campos con (*) son obligatorios");

        buscar.setText("Buscar jefe familiar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        bsel.setText("Agregar");
        bsel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bselActionPerformed(evt);
            }
        });

        jLabel20.setText("Nombres");

        discapacidad.add(radioN);
        radioN.setText("Ninguna");

        discapacidad.add(radioVA);
        radioVA.setText("Visual/Auditiva");

        discapacidad.add(radioMusculo);
        radioMusculo.setText("Musculoesquelética");
        radioMusculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioMusculoActionPerformed(evt);
            }
        });

        discapacidad.add(radioIntel);
        radioIntel.setText("Intelectual");

        discapacidad.add(radioOtra);
        radioOtra.setText("Otra");

        bsel1.setText("Mostrar");
        bsel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsel1ActionPerformed(evt);
            }
        });

        educacion.add(radioA);
        radioA.setText("Analfabeta");

        jLabel10.setText("Discapacidad");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel20))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(nombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                                    .addComponent(apellido, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5)
                                        .addGap(28, 28, 28)
                                        .addComponent(radioM)
                                        .addGap(18, 18, 18)
                                        .addComponent(radioF)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(cbox, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bsel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bsel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(radioV)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(radioE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(guardar)
                        .addGap(55, 55, 55)
                        .addComponent(insertar)
                        .addGap(50, 50, 50)
                        .addComponent(cancelar)))
                .addGap(0, 91, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel11)
                                                    .addComponent(jLabel12))
                                                .addGap(53, 53, 53)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(vereda)
                                                    .addComponent(casa, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addComponent(radioMusculo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(radioVA)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(radioIntel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(radioOtra)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(radioN))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addComponent(radioA)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(radioBasica)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(radioBachiller)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(radioProf))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(330, 330, 330)
                        .addComponent(titulo1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(titulo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(radioV)
                    .addComponent(radioE)
                    .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel20))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel14)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscar)
                    .addComponent(cbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bsel)
                    .addComponent(bsel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioM)
                    .addComponent(radioF)
                    .addComponent(jLabel5)
                    .addComponent(jLabel17)
                    .addComponent(jLabel1)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(radioBasica)
                    .addComponent(radioBachiller)
                    .addComponent(radioProf)
                    .addComponent(radioA))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioMusculo)
                    .addComponent(radioVA)
                    .addComponent(radioN)
                    .addComponent(radioIntel)
                    .addComponent(radioOtra)
                    .addComponent(jLabel10))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(vereda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(casa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardar)
                    .addComponent(insertar)
                    .addComponent(cancelar))
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
            boolean b=insertar();
            if(b)
            {
                guardar.setEnabled(false);
                insertar.setEnabled(true);
                JOptionPane.showMessageDialog(null, "Jefe familiar registrado exitosamente");
                deshabilitar_componentes();     
            }
    }//GEN-LAST:event_guardarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        // TODO add your handling code here:
        if(insertar.isEnabled())
        {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "¿Desea salir sin agregar miembros a la familia?","", dialogButton);
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
        }
       
        
    }//GEN-LAST:event_cancelarActionPerformed

   
    
    private void insertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarActionPerformed
        // TODO add your handling code here:
         m=null;
         m = new Miembros(prev);
         m.set_id_familia(id_familia);
         m.setVisible(true);
         this.setVisible(false);
    }//GEN-LAST:event_insertarActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
        String ced = cedula.getText().trim();
        String nom = nombre.getText().trim();
        String ape = apellido.getText().trim();
        
        if(ced.compareTo("")!=0 || nom.compareTo("")!=0 || ape.compareTo("")!=0)
        {
            try
            {
                String pwhere="";
 
                if(ced.compareTo("")!=0)
                {
                    String nac = getValor(nacionalidad);
                    int x = Integer.parseInt(ced);
                    String stced = nac+"-"+x;
                    pwhere="Persona.cedula='"+stced+"'";
                }
                
                if(nom.compareTo("")!=0)
                {
                    String stnom="LOWER(Persona.nombres) LIKE LOWER('%"+nom+"%')";
                    if(pwhere.compareTo("")==0)
                        pwhere=stnom;
                    else
                        pwhere+=(" and "+stnom);
                }
                
                if(ape.compareTo("")!=0)
                {
                    String stape="LOWER(Persona.apellidos) LIKE LOWER('%"+ape+"%')";
                    if(pwhere.compareTo("")==0)
                        pwhere=stape;
                    else
                        pwhere+=(" and "+stape);
                }
                
                pwhere+=" and Persona.id_familia = Familia.id and Familia.id_jefe=Persona.id";
                
                datos = (String[][])op.select("Persona, Familia","id_familia, nombres, apellidos, cedula",pwhere,con);
                
                if(datos.length==0)
                {
                    JOptionPane.showMessageDialog(null, "Jefe familiar no registrado");
                    cbox.removeAllItems();
                    bsel.setVisible(false);
                    cbox.setVisible(false);
                    bsel1.setVisible(false);
                }
                else
                {
                    cbox.removeAllItems();
                    cbox.addItem("<< Seleccione un jefe familiar de la lista >>");
             
            
                    for (int i = 0; i < datos.length; i++) 
                    {
                        
                        if(datos[i][3]=="")
                            datos[i][3]="<<No registra>>";
                        String item = datos[i][1]+" "+datos[i][2]+", C.I: "+datos[i][3];
                
                        cbox.addItem(item);
                    }
            
                    cbox.setVisible(true);
                    bsel.setVisible(true);
                    bsel1.setVisible(true);
                      
                }
            
            }catch(NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(null, "El campo cedula debe ser numerico");
            }
        }
        else
        {
           JOptionPane.showMessageDialog(null, "Ingresar datos del jefe familiar");       
        }
    }//GEN-LAST:event_buscarActionPerformed

    private void bselActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bselActionPerformed
        // TODO add your handling code here:
        int x = cbox.getSelectedIndex();
        if(x>0)
        {
            id_familia = datos[x-1][0];
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "¿Desea agregar miembros a la familia?","", dialogButton);
            if(dialogResult == 0)
            {
                Miembros m = new Miembros(prev);
                m.set_id_familia(id_familia);
                m.setVisible(true);
                this.setVisible(false);
            } 
            else
            {
                bsel.setVisible(false);
                bsel1.setVisible(false);
                cbox.setVisible(false);
                cedula.setText("");
                nombre.setText("");
                apellido.setText("");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un jefe familiar de la lista");           
        }    
    }//GEN-LAST:event_bselActionPerformed

    private void bsel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsel1ActionPerformed
        // TODO add your handling code here:
        int x = cbox.getSelectedIndex();
        if(x>0)
        {
            id_familia = datos[x-1][0];
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "¿Desea mostrar los miembros de la familia?","", dialogButton);
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
            else
            {
                bsel.setVisible(false);
                bsel1.setVisible(false);
                cbox.setVisible(false);
                cedula.setText("");
                nombre.setText("");
                apellido.setText("");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un jefe familiar de la lista");           
        } 
    }//GEN-LAST:event_bsel1ActionPerformed

    private void radioMusculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioMusculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioMusculoActionPerformed

    /**
     * @param args the command line arguments
     */
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellido;
    private javax.swing.JButton bsel;
    private javax.swing.JButton bsel1;
    private javax.swing.JButton buscar;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField cargo;
    private javax.swing.JTextField casa;
    private javax.swing.JComboBox<String> cbox;
    private javax.swing.JTextField cedula;
    private javax.swing.ButtonGroup discapacidad;
    private javax.swing.ButtonGroup educacion;
    private javax.swing.JButton guardar;
    private javax.swing.JButton insertar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator3;
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
    private javax.swing.JTextField vereda;
    // End of variables declaration//GEN-END:variables

    
}
