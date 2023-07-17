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
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.JPanel;

/**
 *
 * @author pc
 */
public class ControladorProductos implements ActionListener, Metvis {

    private FrameProductos fProductos = new FrameProductos();
    private modeloProductos mProductos = new modeloProductos();
    private MySql msProductos = new MySql();

    public ControladorProductos(FrameProductos fProductos, modeloProductos mProductos) {
        this.fProductos = fProductos;
        this.mProductos = mProductos;
        this.fProductos.buscarProductobtn.addActionListener(this);
        this.fProductos.editarProductobtn.addActionListener(this);
        this.fProductos.eliminarProductobtn.addActionListener(this);
        this.fProductos.agregarProductobtn.addActionListener(this);
    }

    public void agregarProductos() throws SQLException {

        String ordenAgregarProductos = ("insert into productos(codigoProducto,nombreProducto,codigoProveedor) values(?,?,?);");
        Connection conProductos = msProductos.iniciarConexion();
        try {

            PreparedStatement psProductos = conProductos.prepareStatement(ordenAgregarProductos);
            psProductos.setString(1, this.fProductos.codigoProductotxt.getText());
            psProductos.setString(2, this.fProductos.nombreProductotxt.getText());
            psProductos.setString(3, this.fProductos.codigoProveedortxt.getActionCommand());

            if (this.fProductos.nombreProductotxt.getText().isEmpty() || this.fProductos.codigoProductotxt.getText().isEmpty()
                    || this.fProductos.codigoProveedortxt.getActionCommand().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No puede dejar los campos en blanco", "Error", WARNING_MESSAGE);
            } else {
                psProductos.executeUpdate();
            }
            msProductos.finalizarConexion(conProductos);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Al guardar el producto " + e);

        }
    }

    public void buscarProductos() throws SQLException {

        String ordenBuscarProductos = ("select * from productos where nombreProducto ='" + this.fProductos.buscadorProductostxt.getText() + "'");
        Connection conProductos = msProductos.iniciarConexion();
        PreparedStatement psProductos = conProductos.prepareStatement(ordenBuscarProductos);
        ResultSet rsProductos;
        if (this.fProductos.buscadorProductostxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese una palabra en el campo");
        } else {
            rsProductos = psProductos.executeQuery();

        }
    }

    public void editarProductos() throws SQLException {

    }

    public void eliminarProductos() throws SQLException {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.fProductos.buscarProductobtn) {
            try {
                this.buscarProductos();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == this.fProductos.editarProductobtn) {

        }
        if (e.getSource() == this.fProductos.eliminarProductobtn) {

        }
        if (e.getSource() == this.fProductos.agregarProductobtn) {
            try {
                this.agregarProductos();
                
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
