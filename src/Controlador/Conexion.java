/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author David
 */
public class Conexion {
    private Connection conn = null;
    public boolean debug = false;
    public Connection CrearBD(){
       try{
         //obtenemos el driver de para mysql
         Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
         //obtenemos la conexión
         conn = DriverManager.getConnection("jdbc:derby:.\\DB\\Derby.DB;create=true");
         if (conn!=null){
           JOptionPane.showMessageDialog(null,"OK base de datos listo");
            
            String creartabla[]={"create table Consejo(descripcion varchar(100), dirreccion varchar(100))",
                                 "create table Usuario(id int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), login varchar(20), password varchar(20))",
                                 "create table Familia(id int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), direccion varchar(100), id_jefe int)",
                                 "create table Usuario_Funcion(id_usuario int, id_funcion int)",
                                 "create table Funcion(id int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), descripcion varchar(200), nombre varchar(50), pantalla varchar(20))",
                                 "create table Persona(id int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), nombres varchar(50), apellidos varchar(50), cedula varchar(15) DEFAULT NULL, fecha_nac date, sexo char, educacion varchar(25) DEFAULT NULL, ocupacion varchar(25) DEFAULT NULL, discapacidad varchar(25) DEFAULT NULL, id_familia int)",
                                 "create table Subfuncion(id int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), descripcion varchar(200), nombre varchar(50), pantalla varchar(20), formato varchar(20), id_funcion int)"};
    
            
            Statement s = conn.createStatement();
            
            try {
                
                for (int i = 0; i < creartabla.length; i++)
                {
                    s.execute(creartabla[i]);
                }
            PreparedStatement psInsert;
            
            psInsert = conn.prepareStatement("insert into Consejo values ('Consejo Comunal Rio Zuñiga','Pirineos I, Parroquia Pedro Maria Morantes')");
	    psInsert.executeUpdate();
            
            psInsert = conn.prepareStatement("insert into Usuario (login, password) values ('admindb','admindb')");
	    psInsert.executeUpdate();
            psInsert = conn.prepareStatement("insert into Usuario (login, password) values ('admin','admin')");
	    psInsert.executeUpdate();
            psInsert = conn.prepareStatement("insert into Usuario (login, password) values ('usuario','usuario')");
	    psInsert.executeUpdate();
            
            psInsert = conn.prepareStatement("insert into Funcion (descripcion, nombre , pantalla) values ('Ejecutar una sentencia sql','Ejecutar','ejecutar')");
            psInsert.executeUpdate();
            psInsert = conn.prepareStatement("insert into Funcion (descripcion, nombre , pantalla) values ('Generar las cartas con los formatos establecidos','Gestión Cartas','cartas')");
            psInsert.executeUpdate();
            psInsert = conn.prepareStatement("insert into Funcion (descripcion, nombre , pantalla) values ('Cargar un registro en la base de datos','Cargar Datos','cargar')");
            psInsert.executeUpdate();
            psInsert = conn.prepareStatement("insert into Funcion (descripcion, nombre , pantalla) values ('Actualizar un registro en la base de datos','Actualizar Datos','actualizar')");
            psInsert.executeUpdate();
            psInsert = conn.prepareStatement("insert into Funcion (descripcion, nombre , pantalla) values ('Generar el cuaderno electoral','Cuaderno Electoral','generarCuaderno')");
            psInsert.executeUpdate();
            psInsert = conn.prepareStatement("insert into Funcion (descripcion, nombre , pantalla) values ('Mostrar las estadísticas del sistema','Reportes y Listados','estadisticas')");
            psInsert.executeUpdate();
            
            psInsert = conn.prepareStatement("insert into Usuario_Funcion (id_usuario, id_funcion) values (1,1)");
            psInsert.executeUpdate();
            psInsert = conn.prepareStatement("insert into Usuario_Funcion (id_usuario, id_funcion) values (2,2)");
            psInsert.executeUpdate();
            psInsert = conn.prepareStatement("insert into Usuario_Funcion (id_usuario, id_funcion) values (2,3)");
            psInsert.executeUpdate();
            psInsert = conn.prepareStatement("insert into Usuario_Funcion (id_usuario, id_funcion) values (2,4)");
            psInsert.executeUpdate();
            psInsert = conn.prepareStatement("insert into Usuario_Funcion (id_usuario, id_funcion) values (2,5)");
            psInsert.executeUpdate();
            psInsert = conn.prepareStatement("insert into Usuario_Funcion (id_usuario, id_funcion) values (2,6)");
            psInsert.executeUpdate();
            psInsert = conn.prepareStatement("insert into Usuario_Funcion (id_usuario, id_funcion) values (3,2)");
            psInsert.executeUpdate();
            psInsert = conn.prepareStatement("insert into Usuario_Funcion (id_usuario, id_funcion) values (3,5)");
            psInsert.executeUpdate();
            psInsert = conn.prepareStatement("insert into Usuario_Funcion (id_usuario, id_funcion) values (3,6)");
            psInsert.executeUpdate();
 
 
          if(debug)  
          JOptionPane.showMessageDialog(null,"BD Creada correctamente");
        } catch (SQLException ex) {
            if(debug)
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
         }
      }catch(SQLException e){
          if(debug)
          JOptionPane.showMessageDialog(null,e.getMessage(),"Error" ,  JOptionPane.ERROR_MESSAGE);
      }catch(ClassNotFoundException e){
          if(debug)
          JOptionPane.showMessageDialog(null,e.getMessage(),"Error" ,  JOptionPane.ERROR_MESSAGE);
      }
       return conn;
  }
    
     public Connection AccederBD(){
       try{
         //obtenemos el driver de para mysql
         Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
         //obtenemos la conexión
         conn = DriverManager.getConnection("jdbc:derby:.\\DB\\Derby.DB");
         if (conn!=null){
             if(debug)
             JOptionPane.showMessageDialog(null,"OK base de datos listo");
         }
      }catch(SQLException e){
          if(debug)          
          JOptionPane.showMessageDialog(null,e.getMessage(),"Error" ,  JOptionPane.ERROR_MESSAGE);
          conn=CrearBD();
      }catch(ClassNotFoundException e){
          if(debug)
          JOptionPane.showMessageDialog(null,e.getMessage(),"Error" ,  JOptionPane.ERROR_MESSAGE);
      }
       return conn;
  }
     
      public void cerracon (){
        try {
            conn.close();
        } catch (SQLException ex) {
            
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
     
}
