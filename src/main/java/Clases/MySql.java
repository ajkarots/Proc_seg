/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import interfaces.GestorBD;
import java.sql.*;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class MySql extends Gestor implements GestorBD {

    private static final String url = "jdbc:mysql://localhost:3306/proyecto";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private Connection con;

    public void setCon(Connection con) {
        this.con = con;
    }

    public void insertar(String tabla, String columnas) {
        try {

            Statement st = con.createStatement();
            st.executeUpdate("insert into " + tabla + " set " + columnas);
        } catch (SQLException ex) {

        }
    }

    public static String getUrl() {
        return url;
    }

    public static String getDriver() {
        return driver;
    }

        
    public void actualizar(String tabla, String columna, int dato, String parametro, String codigo) {
        this.con = iniciarConexion();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("update " + tabla + " set " + columna + "='" + dato + "' where " + parametro + " ='" + codigo + "';");
        } catch (SQLException ex) {
            Logger.getLogger(MySql.class.getName()).log(Level.SEVERE, null, ex);
        }
        finalizarConexion(this.con);
    }

    public boolean usuariobloc(LinkedList<String> nombres, String usuario) {
        String bloqueado = null;
        for (int i = 0; i < nombres.size(); i++) {
            if (nombres.get(i).equals(usuario)) {
                return true;
            }

        }
        return false;
    }

    public Connection iniciarConexion() {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, "root", "Julian01");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage()
                    + ". >>> Error de Conexion 1!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()
                    + ". >>> Error de Conexion 2!!");
        }
        return null;
    }

    public Connection getCon() {
        return con;
    }
    
    public void finalizarConexion(Connection conexion) {
    if (conexion != null) {
        try {
            conexion.close();
            conexion = null;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + 
                    ". >>> Error de Desconexion!!");
        }
    }
}
}
