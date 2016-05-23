/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class Operaciones {
    
    public boolean debug = false;
    
     public Object [][] select(String table, String fields, String where,Connection con){
      int registros = 0;      
      String colname[] = fields.split(",");

      //Consultas SQL
      String q ="SELECT " + fields + " FROM " + table;
      String q2 = "SELECT count(*) as total FROM " + table;
      if(where!=null)
      {
          q+= " WHERE " + where;
          q2+= " WHERE " + where;
      }
      
       try{
         PreparedStatement pstm = con.prepareStatement(q2);
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
      }
    
    //se crea una matriz con tantas filas y columnas que necesite
    Object[][] data = new String[registros][fields.split(",").length];
    //realizamos la consulta sql y llenamos los datos en la matriz "Object"
      try{
         PreparedStatement pstm = con.prepareStatement(q);
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            for(int j=0; j<=fields.split(",").length-1;j++){
                data[i][j] = res.getString( colname[j].trim() );
            }
            i++;         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
      
      
    return data;
 }
  
 public Object [][] select_orderby(String table, String fields, String where,String orderby,Connection con){
      int registros = 0;      
      String colname[] = fields.split(",");

      //Consultas SQL
      String q ="SELECT " + fields + " FROM " + table;
      String q2 = "SELECT count(*) as total FROM " + table;
      if(where!=null)
      {
          q+= " WHERE " + where+" ORDER BY "+orderby;
          q2+= " WHERE " + where;
      }
      
       try{
         PreparedStatement pstm = con.prepareStatement(q2);
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
      }
    
    //se crea una matriz con tantas filas y columnas que necesite
    Object[][] data = new String[registros][fields.split(",").length];
    //realizamos la consulta sql y llenamos los datos en la matriz "Object"
      try{
         PreparedStatement pstm = con.prepareStatement(q);
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            for(int j=0; j<=fields.split(",").length-1;j++){
                data[i][j] = res.getString( colname[j].trim() );
            }
            i++;         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
      
      
    return data;
 }    
     
     
     
      public boolean insert(String table, String fields, String values,Connection con) 
    {
        boolean res=false;
        //Se arma la consulta
        String q=" INSERT INTO " + table + " ( " + fields + " ) VALUES ( " + values + " ) ";
        //se ejecuta la consulta
        try {
            PreparedStatement pstm = con.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
               
            if(debug)
            JOptionPane.showMessageDialog(null,"Insertado correctamente");
        } catch (SQLException ex) {
            if(debug)
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        
      return res;
    }
      
      public boolean update(String table, String set, String where, Connection con)
      {
          boolean res=false;
          
          String q = "UPDATE "+table+" SET "+set+" WHERE "+where;
          
          try {
            PreparedStatement pstm = con.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
            
           if(debug) 
           JOptionPane.showMessageDialog(null,"Actualizado correctamente");
        } catch (SQLException ex) {
           
           if(debug) 
           JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
          
          return res;
      }
     
      public boolean delete(String table, String where, Connection con)
      {
          boolean res=false;
          
          String q = "DELETE FROM "+table+" WHERE "+where;
          
          try {
            PreparedStatement pstm = con.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
 
           if(debug) 
           JOptionPane.showMessageDialog(null,"Eliminado correctamente");
        } catch (SQLException ex) {
            if(debug) 
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
          
          return res;
      }
      
    public void imprimir(Object[][] data)
    {
        for (int i = 0; i < data.length; i++)
        {
            for (int j = 0; j < data[i].length; j++)
            {
                System.out.print(data[i][j].toString()+" , ");
            }
            System.out.println("");
        }
    }
     
}
