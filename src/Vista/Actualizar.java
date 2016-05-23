/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Jessica
 */
public class Actualizar extends Interna {

    /**
     * Creates new form Cargar
     */
    String myId;
    String myCed="";
    String datos[][];
    Fecha pp;

    public Actualizar(JFrame previo) {
        
        super(previo,true);
        
        initComponents();
        
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
        jLabel9.setFont(Etiqueta);
        jLabel9.setForeground(NegroEtiqueta);
        jLabel10.setFont(Etiqueta);
        jLabel10.setForeground(NegroEtiqueta);
        
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
        radioV.setFont(Etiqueta);
        radioV.setForeground(NegroEtiqueta);
        radioV.setBackground(ColorPrincipal);
        radioE.setFont(Etiqueta);
        radioE.setForeground(NegroEtiqueta);
        radioE.setBackground(ColorPrincipal);
        radioOtra.setFont(Etiqueta);
        radioOtra.setForeground(NegroEtiqueta);
        radioOtra.setBackground(ColorPrincipal);
        radioA.setFont(Etiqueta);
        radioA.setForeground(NegroEtiqueta);
        radioA.setBackground(ColorPrincipal);
        
        radioV.setSelected(true);
               
        Panel.setBackground(ColorPrincipal);
        Panel.setVisible(false);
        
        cbox.setVisible(false);
        bsel.setVisible(false);
        
        pp = new Fecha();
        pp.setBounds(280,155,282,20);
        pp.setVisible(true);
        
        Panel.add(pp);
        buscar.setIcon(new ImageIcon("Imagenes/lupa.png"));
        
        this.setTitle("SistemaComunal - Actualizar Datos");
        this.setName("actualizar");
        
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
    
    
    public boolean actualizar()
    {
        String stnom = nom.getText();
        String stape = ape.getText();
        String stsexo = getValor(sexo);
        String stedu = getValor(educacion);
        String stdis = getValor(discapacidad);
        String nac = getValor(nacionalidad);
        String stocup = cargo.getText();
        String xced = ced.getText().trim();
        
        
        boolean ret=false;
        
        if(stnom.compareTo("")!=0 && stape.compareTo("")!=0 && stsexo.compareTo("")!=0 && xced.compareTo("")!=0 && pp.getFecha().compareTo("")!=0)
        {    
            try
            { 
                if(xced.compareTo("")==0)
                {
                    xced="<<N/R>>";
                }
                else
                {
                    int x = Integer.parseInt(xced);
                    xced=nac+"-"+xced;
                }
                
                String datos[][] = (String[][])op.select("Persona","id","cedula='"+xced+"'", con);
                
                if(datos.length==0 || xced.compareTo("<<N/R>>")==0 || ced.getText().trim().compareTo(myCed)==0)
                {
                    op.update("Persona","nombres='"+stnom+"', apellidos='"+stape+"', sexo='"+stsexo+"', educacion='"+stedu+"', ocupacion='"+stocup+"', discapacidad='"+stdis+"', fecha_nac=DATE('"+pp.getFecha()+"') , cedula='"+xced+"'","id="+myId,con);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    public void mostrar(int select)
    {
            jLabel2.setVisible(false);
            jLabel1.setVisible(false);
            cedula.setVisible(false);
            buscar.setVisible(false);
            Panel.setVisible(true);
            
            nom.setText(datos[select][0]);
            ape.setText(datos[select][1]);
            
            cargo.setText(datos[select][5]);
            
            switch(datos[select][3])
            {
                case "M":  radioM.setSelected(true); break;
                case "F":  radioF.setSelected(true); break;
            }
            
            if(datos[select][4].compareTo("")!=0)
            {
                switch(datos[select][4])
                {
                    case "Inicial/Basica": radioBasica.setSelected(true); break;
                    case "Bachiller":      radioBachiller.setSelected(true); break;
                    case "Profesional":    radioProf.setSelected(true); break;
                    case "Analfabeta":     radioA.setSelected(true); break;
                    default: educacion.clearSelection();
                }
            }
            
            if(datos[select][6]!=null)
            if(datos[select][6].compareTo("")!=0)
            {
                switch(datos[select][6])
                {
                    case "Musculoesqueletica": radioMusculo.setSelected(true); break;
                    case "Visual/Auditiva":    radioVA.setSelected(true); break;
                    case "Intelectual":        radioIntel.setSelected(true); break;
                    case "Ninguna":            radioN.setSelected(true); break;
                    case "Otra":               radioOtra.setSelected(true); break;
                    default: discapacidad.clearSelection();
                }
            }
            
            if(datos[select][8].compareTo("<<N/R>>")!=0)
            {
                String nac = datos[select][8].split("-")[0];
                String num_ced = datos[select][8].split("-")[1];
            
                if(nac.compareTo("V")==0)
                {
                    radioV.setSelected(true);
                }   
                else
                {
                    radioE.setSelected(true);
                }
                ced.setText(num_ced);
                    
                myCed=num_ced;
                
            }
            else
            {
                ced.setText("");
                radioV.setSelected(true);
            }
             
            if(datos[select][2].compareTo("2100-01-01")!=0)
            pp.setFecha(datos[select][2]);
            
           
            myId = datos[select][7];
    }
    
    public void accion()
    {
        if(!Panel.isVisible())
        { 
        String xced = cedula.getText().trim();
         
        datos = (String[][])op.select("Persona","nombres, apellidos, fecha_nac, sexo, educacion, ocupacion, discapacidad, id, cedula","cedula='V-"+xced+"' or cedula='E-"+xced+"' or LOWER(nombres) LIKE LOWER('%"+xced+"%') or LOWER(apellidos) LIKE LOWER('%"+xced+"%')",con);
        
        if(datos.length>0)
        {
            cbox.removeAllItems();
            cbox.addItem("<< Seleccione una persona de la lista >>");
            jLabel2.setVisible(false);
            
            for (int i = 0; i < datos.length; i++) 
            {
                String item = datos[i][0]+" "+datos[i][1]+", C.I: "+datos[i][8];
                
                cbox.addItem(item);
            }
            
            cbox.setVisible(true);
            bsel.setVisible(true);
        }
        else
        {
            jLabel2.setVisible(true);
            Panel.setVisible(false);
            cedula.setText("");
            cbox.setVisible(false);
            bsel.setVisible(false);
        }
        
        }
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        discapacidad = new javax.swing.ButtonGroup();
        educacion = new javax.swing.ButtonGroup();
        sexo = new javax.swing.ButtonGroup();
        nacionalidad = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        cedula = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Panel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        guardar = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        radioF = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        radioBasica = new javax.swing.JRadioButton();
        radioBachiller = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        radioProf = new javax.swing.JRadioButton();
        radioMusculo = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        radioVA = new javax.swing.JRadioButton();
        radioN = new javax.swing.JRadioButton();
        radioIntel = new javax.swing.JRadioButton();
        radioM = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        eliminar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cargo = new javax.swing.JTextField();
        ced = new javax.swing.JTextField();
        ape = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        radioV = new javax.swing.JRadioButton();
        radioE = new javax.swing.JRadioButton();
        nom = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        radioA = new javax.swing.JRadioButton();
        radioOtra = new javax.swing.JRadioButton();
        cbox = new javax.swing.JComboBox<>();
        bsel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setText("Buscar");

        cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedulaActionPerformed(evt);
            }
        });
        cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        jLabel2.setText("No se encontraron personas con los datos suministrados.");

        jLabel3.setText("Nombres:");

        jLabel4.setText("Apellidos");

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        sexo.add(radioF);
        radioF.setText("F");

        jLabel5.setText("Sexo");

        educacion.add(radioBasica);
        radioBasica.setText("Inicial/Basica");

        educacion.add(radioBachiller);
        radioBachiller.setText("Bachiller");

        jLabel7.setText("Educación");

        educacion.add(radioProf);
        radioProf.setText("Profesional");

        discapacidad.add(radioMusculo);
        radioMusculo.setText("Musculoesqueletica");
        radioMusculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioMusculoActionPerformed(evt);
            }
        });

        jLabel6.setText("Discapacidad");

        discapacidad.add(radioVA);
        radioVA.setText("Visual/Auditiva");
        radioVA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioVAActionPerformed(evt);
            }
        });

        discapacidad.add(radioN);
        radioN.setText("Ninguna");

        discapacidad.add(radioIntel);
        radioIntel.setText("Intelectual");

        sexo.add(radioM);
        radioM.setText("M");

        jLabel8.setText("Fecha de Nacimiento");

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        jLabel9.setText("Cargo Laboral");

        jLabel15.setText("(*)");

        jLabel13.setText("(*)");

        jLabel14.setText("(*)");

        jLabel16.setText("(*)");

        jLabel10.setText("Cédula:");

        nacionalidad.add(radioV);
        radioV.setText("V");

        nacionalidad.add(radioE);
        radioE.setText("E");

        jLabel17.setText("(*)");

        educacion.add(radioA);
        radioA.setText("Analfabeta");
        radioA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                radioAradioAction(evt);
            }
        });

        discapacidad.add(radioOtra);
        radioOtra.setText("Otra");

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(guardar)
                .addGap(51, 51, 51)
                .addComponent(eliminar)
                .addGap(54, 54, 54)
                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(197, 197, 197))
            .addGroup(PanelLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(81, 81, 81)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addComponent(radioMusculo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radioVA)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radioIntel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radioOtra)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radioN))
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addComponent(radioM)
                                .addGap(18, 18, 18)
                                .addComponent(radioF))
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addComponent(radioA)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioBasica)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radioBachiller)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radioProf))))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel17))
                                .addGap(18, 18, 18)
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel9)))
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel13))
                                .addGap(18, 18, 18)
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel10))))
                        .addGap(41, 41, 41)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ape, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addComponent(radioV)
                                .addGap(18, 18, 18)
                                .addComponent(radioE)
                                .addGap(30, 30, 30)
                                .addComponent(ced, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radioV)
                            .addComponent(radioE)
                            .addComponent(ced, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel13))))
                .addGap(18, 18, 18)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel14)))
                .addGap(18, 18, 18)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(radioM)
                        .addComponent(radioF)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioBasica)
                    .addComponent(radioBachiller)
                    .addComponent(radioProf)
                    .addComponent(jLabel7)
                    .addComponent(radioA))
                .addGap(18, 18, 18)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioMusculo)
                    .addComponent(radioVA)
                    .addComponent(radioIntel)
                    .addComponent(jLabel6)
                    .addComponent(radioOtra)
                    .addComponent(radioN))
                .addGap(25, 25, 25)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardar)
                    .addComponent(salir)
                    .addComponent(eliminar))
                .addGap(121, 121, 121))
        );

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
                .addGap(327, 327, 327)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(247, 247, 247)
                .addComponent(cbox, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bsel))
            .addGroup(layout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(buscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bsel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
        accion();
        
    }//GEN-LAST:event_buscarActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            accion();
        }
    }//GEN-LAST:event_formKeyPressed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        // TODO add your handling code here

        String datos[][] = (String[][])op.select("Familia","id","id_jefe="+myId,con);

        if(datos.length==0)
        {

            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro actual?","", dialogButton);
            if(dialogResult == 0)
            {
                op.delete("Persona","id="+myId,con);
                Panel.setVisible(false);
                cedula.setText("");
                jLabel1.setVisible(true);
                cedula.setVisible(true);
                buscar.setVisible(true);
            }

        }
        else
        {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Al eliminar un jefe familiar elimina toda la famila. ¿Desea continuar?","", dialogButton);
            if(dialogResult == 0)
            {
                String id_familia = op.select("Persona","id_familia","id="+myId,con)[0][0].toString();
                op.delete("Persona","id_familia="+id_familia,con);
                op.delete("Familia","id="+id_familia,con);
                Panel.setVisible(false);
                cedula.setText("");
                jLabel1.setVisible(true);
                cedula.setVisible(true);
                buscar.setVisible(true);
            }
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void radioVAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioVAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioVAActionPerformed

    private void radioMusculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioMusculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioMusculoActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "¿Desea salir sin guardar los datos?","", dialogButton);
        if(dialogResult == 0)
        {
            Panel.setVisible(false);
            cedula.setText("");
            jLabel1.setVisible(true);
            cedula.setVisible(true);
            buscar.setVisible(true);
        }
    }//GEN-LAST:event_salirActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
        boolean b=actualizar();
        if(b)
        {
            Panel.setVisible(false);
            cedula.setText("");
            jLabel1.setVisible(true);
            cedula.setVisible(true);
            buscar.setVisible(true);
            JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
        }
    }//GEN-LAST:event_guardarActionPerformed

    private void bselActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bselActionPerformed
        int x=cbox.getSelectedIndex();
        if(x>0)
        {
            cbox.setVisible(false);
            bsel.setVisible(false);
            mostrar(x-1);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una persona de la lista");
        }
    }//GEN-LAST:event_bselActionPerformed

    private void cedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedulaActionPerformed

    private void radioAradioAction(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioAradioAction
        // TODO add your handling code here:
    }//GEN-LAST:event_radioAradioAction

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private javax.swing.JTextField ape;
    private javax.swing.JButton bsel;
    private javax.swing.JButton buscar;
    private javax.swing.JTextField cargo;
    private javax.swing.JComboBox<String> cbox;
    private javax.swing.JTextField ced;
    private javax.swing.JTextField cedula;
    private javax.swing.ButtonGroup discapacidad;
    private javax.swing.ButtonGroup educacion;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.ButtonGroup nacionalidad;
    private javax.swing.JTextField nom;
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
    private javax.swing.JButton salir;
    private javax.swing.ButtonGroup sexo;
    // End of variables declaration//GEN-END:variables
}
