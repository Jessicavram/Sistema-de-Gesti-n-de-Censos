/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.Date;


public class Habitante 
{
    public String nombre;
    public String apellido;
    public String cedula;
    public Date fecha_nac;
    public char sexo;
    public String educacion;
    public String ocupacion;
    public String discapacidad;
    public String direccion;
    
    void Persona()
    {
        
    }
    
    public void guardar_datos(String[] datos)
    {
        nombre=datos[0];
        apellido=datos[1];
        cedula=datos[2];
        //fecha_nac = new Date(datos[3]);
        sexo=datos[4].charAt(0);
        educacion=datos[5];
        ocupacion=datos[6];
        discapacidad=datos[7];     
    }
    
    public void guardar_direccion(String dirr)
    {
        direccion=dirr;
    }
}
