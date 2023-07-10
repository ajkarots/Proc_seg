/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author User
 */
public interface GestorBD {
    public void conectarMysql();    
    public int controlusuarios(String nombre,String clave);
    public void actualizar(String tabla,String columna,int dato,String parametro,String codigo);
    public ResultSet seleccionarProvincias();
}
