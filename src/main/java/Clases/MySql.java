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

    public Connection getCon() {
        return con;
    }

    public void seleccionar() {
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = con.prepareStatement("");
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("codigo") + " " + rs.getString("nombre"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(MySql.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void conectarMysql() {
        con = null;
        super.setUser("root");
        super.setClave("Julian01");
        try {
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, super.getUser(), super.getClave());
            if (con != null) {
                System.out.println("se conecto");
            } else {
                System.out.println("no se conecto");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public ResultSet seleccionarProvincias() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            ps = con.prepareStatement("select * from provincias where codigo = ?");
            ps.setString(1, "T01");
            rs = ps.executeQuery();

            /*Statement st = con.createStatement();
            st.executeQuery("select * from provincias where codigo = 'T02'");*/
        } catch (SQLException ex) {
            Logger.getLogger(MySql.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    @Override
    public int controlusuarios(String nombre, String clave) {
        conectarMysql();
        int controlador = 0;
        int contador_intentos = 0;
        PreparedStatement psusuarios, psintentos;
        Statement psactualizar;
        ResultSet rsusuarios, rsintentos;
        LinkedList<String>UsuariosBloqueados = new LinkedList<>();
        //metodo control bloqueos
        try {
            psusuarios = this.getCon().prepareStatement("select userID ,contraseña,bloqueo from usuarios where userID='" + nombre + "';");
            rsusuarios = psusuarios.executeQuery();
            if (rsusuarios.next()) {
                if (rsusuarios.getInt("bloqueo")==1) {
                UsuariosBloqueados.add(rsusuarios.getString("userID"));
                }
            }
            psintentos = this.getCon().prepareStatement("select intentos from usuarios where userID='" + nombre + "';");
            rsintentos = psintentos.executeQuery();
            if (rsintentos.next()) {
                contador_intentos = rsintentos.getInt("intentos");

            }
            if (this.usuariobloc(UsuariosBloqueados, nombre)==true){
            JOptionPane.showMessageDialog(null, "Usuario bloqueado");}
            else
            {
            if (rsusuarios.next()) {
                controlador++;
                String claveusuario = rsusuarios.getString("contraseña");
                if (clave.equals(claveusuario)) {
                    controlador++;
                    this.actualizar("usuarios", "intentos", 0, "userID", nombre);
                    
                } else {
                    if (contador_intentos == 2) {
                        JOptionPane.showMessageDialog(null, "Usuario Bloqueado");
                        psusuarios = this.getCon().prepareStatement("update usuarios set bloqueo=1 where userID='" + nombre + "';");
                        psusuarios.executeUpdate();

                    }
                }

            }
                    }
        } catch (SQLException ex) {
            Logger.getLogger(MySql.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(controlador);
        return controlador;
    }

    @Override
    public void actualizar(String tabla, String columna, int dato, String parametro, String codigo) {
        this.conectarMysql();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("update " + tabla + " set " + columna + "='" + dato + "' where " + parametro + " ='" + codigo + "';");
        } catch (SQLException ex) {
            Logger.getLogger(MySql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean usuariobloc(LinkedList<String> nombres, String usuario ){
        String bloqueado=null;
        for (int i = 0; i < nombres.size(); i++) {
            if (nombres.get(i).equals(usuario)) {
                return true;
            }
            
        }
    return false;
    }
}
