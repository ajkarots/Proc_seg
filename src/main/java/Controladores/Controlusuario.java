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
public class Controlusuario {
    MySql ms = new MySql();
     
    public int controlusuarios(modeloUsuario user) {
        Connection con1 = ms.iniciarConexion();
        Connection con2 = ms.iniciarConexion();
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
            psintentos = con2.prepareStatement("select intentos from usuarios where userID='" + user.getUserID() + "';");
            rsintentos = psintentos.executeQuery();
            if (rsintentos.next()) {
                contador_intentos = rsintentos.getInt("intentos");
            }
            
            if (user.getBloqueo()==1){
            JOptionPane.showMessageDialog(null, "Usuario bloqueado");}
            else
            {
                System.out.println(user.getUserID());
            if (rsusuarios.next()){
                System.out.println(rsusuarios.getString("userID"));
                controlador++;
                String claveusuario = rsusuarios.getString("contraseña");
                if (user.getContraseña().equals(claveusuario)) {
                    controlador++;
                    ms.actualizar("usuarios", "intentos", 0, "userID", user.getUserID());
                    
                } else {
                    if (contador_intentos == 2) {
                        JOptionPane.showMessageDialog(null, "Usuario Bloqueado");
                        psusuarios = ms.getCon().prepareStatement("update usuarios set bloqueo=1 where userID='" + user.getUserID() + "';");
                        psusuarios.executeUpdate();

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
        ms.finalizarConexion(con1);
        ms.finalizarConexion(con2);
        System.out.println(controlador);
        if (controlador==1) {
            JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
        }
        return controlador;
    }
}
