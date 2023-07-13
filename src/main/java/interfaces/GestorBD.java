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
   public Connection iniciarConexion();
   public void finalizarConexion(Connection conexion);

    public void actualizar(String tabla,String columna,int dato,String parametro,String codigo);
   
}
