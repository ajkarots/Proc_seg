/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Clases.MySql;
import Modelo.modeloUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author pc
 */
public class ControladorUsuario {
    private MySql msUsuarios = new MySql();
    
    
     
    public int controlusuarios(modeloUsuario user) {
        Connection con1 = msUsuarios.iniciarConexion();
        Connection con2 = msUsuarios.iniciarConexion();
        Connection con3 = msUsuarios.iniciarConexion();
        boolean control=false;
        int controlador = 0;
        int contador_intentos = 0;
        PreparedStatement psusuarios, psintentos,psbloqueos;
        Statement psactualizar;
        ResultSet rsusuarios, rsintentos,rsbloqueos;
        String nom = null,pass;
       
        try {
            psusuarios = con1.prepareStatement("select userID,contraseña,intentos,bloqueo from usuarios where userID='"+user.getUserID()+"';");
            rsusuarios = psusuarios.executeQuery();     
            psintentos = con2.prepareStatement("select bloqueo,intentos from usuarios where userID='" + user.getUserID() + "';");
            rsintentos = psintentos.executeQuery();
            if (rsintentos.next()) {
                contador_intentos = rsintentos.getInt("intentos");
                user.setBloqueo(rsintentos.getInt("bloqueo"));
            }
            
            if (user.getBloqueo()==1){
            JOptionPane.showMessageDialog(null, "Usuario bloqueado");}
            else
            {
                System.out.println(user.getUserID());
            if (rsusuarios.next()){
                System.out.println(rsusuarios.getString("userID"));
                controlador++;
                String nombreusuario= rsusuarios.getString("userID");
                String claveusuario = rsusuarios.getString("contraseña");
                if (user.getContraseña().equals(claveusuario)&&user.getUserID().equals(nombreusuario)) {
                    controlador++;
                    msUsuarios.actualizar("usuarios", "intentos", 0, "userID", user.getUserID());   
                } else {
                        contador_intentos++;
                        msUsuarios.actualizar("usuarios", "intentos",contador_intentos , "userID", user.getUserID());   
                    if (contador_intentos == 3) {
                        JOptionPane.showMessageDialog(null, "Usuario Bloqueado");
                        psbloqueos = con3.prepareStatement("update usuarios set bloqueo=1 where userID='" +user.getUserID() + "';");
                        psbloqueos.executeUpdate();

                    }
                }

            }
            else{
            JOptionPane.showMessageDialog(null, "El usuario no existe");
            }
                    }
        } catch (SQLException ex) {
            Logger.getLogger(MySql.class.getName()).log(Level.SEVERE, null, ex);
        }
        msUsuarios.finalizarConexion(con1);
        msUsuarios.finalizarConexion(con2);
        msUsuarios.finalizarConexion(con3);
        System.out.println(controlador);
        if (controlador==1) {
            JOptionPane.showMessageDialog(null, "Contraseña incorrecta/o usuario incorrecto");
        }
        return controlador;
    }
}
