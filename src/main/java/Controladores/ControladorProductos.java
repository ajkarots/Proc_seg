/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Clases.MySql;
import Frames.FrameProductos;
import Modelo.modeloProductos;
import interfaces.Metvis;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author pc
 */
public class ControladorProductos implements ActionListener,Metvis {

    private FrameProductos fProductos = new FrameProductos();
    private modeloProductos mProductos = new modeloProductos();

    public ControladorProductos(FrameProductos fProductos, modeloProductos mProductos) {
        this.fProductos = fProductos;
        this.mProductos = mProductos;
        this.fProductos.buscarProductobtn.addActionListener(this);
        this.fProductos.editarProductobtn.addActionListener(this);
        this.fProductos.eliminarProductobtn.addActionListener(this);
        this.fProductos.agregarProductobtn.addActionListener(this);
    }

    public void agregarProductos() throws SQLException {
        MySql msProductos = new MySql();
        String ordenAgregarProductos= ("insert into provincias values(?,?,?)");
        Connection conProductos = msProductos.iniciarConexion();
        PreparedStatement psProductos= conProductos.prepareStatement(ordenAgregarProductos);
        psProductos.setString(1,this.fProductos.codigoProductotxt.getText());
        psProductos.setString(2, this.fProductos.nombreProductotxt.getText());
        psProductos.setString(3, this.fProductos.codigoProveedortxt.getText());
        ResultSet rsProductos;
        System.out.println("hola");
        
//        String OrdenAgregarProductos =("insert into productos set codigoProducto='"+this.fProductos.codigoProductotxt.getText()+
//                "',nombreProducto='"+fProductos.nombreProductotxt.getText()+"',codigoProveedor='"+this.fProductos.codigoProveedortxt.getText()+"' ");
        if (this.fProductos.nombreProductotxt.getText().isEmpty() || this.fProductos.codigoProductotxt.getText().isEmpty()
                || this.fProductos.codigoProveedortxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No puede dejar campos en blanco");
        } else {
            if (psProductos.executeUpdate()>0) {
                
            }
            else{
            JOptionPane.showMessageDialog(null, "Error Al guardar el producto");
            }  
        }
        msProductos.finalizarConexion(conProductos);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.fProductos.buscarProductobtn) {

        }
        if (e.getSource() == this.fProductos.editarProductobtn) {

        }
        if (e.getSource() == this.fProductos.eliminarProductobtn) {

        }
        if (e.getSource() == this.fProductos.agregarProductobtn) {
            try {
                this.agregarProductos();
                System.out.println("");
            } catch (SQLException ex) {
                Logger.getLogger(ControladorProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void iniciarcontenido() {
        this.fProductos.setVisible(true);
    }

    @Override
    public void mostrarJpanel(JPanel a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
