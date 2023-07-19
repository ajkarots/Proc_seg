/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Clases.MySql;
import Frames.FrameProductos;
import Modelo.modeloProductos;
import Modelo.modeloProvincia;
import interfaces.Metvis;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.CANCEL_OPTION;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pc
 */
public class ControladorProductos implements ActionListener {

    private FrameProductos fProductos = new FrameProductos();
    private modeloProductos mProductos = new modeloProductos();
    private MySql msProductos = new MySql();
    private Connection conProductos;

    public ControladorProductos(FrameProductos fProductos, modeloProductos mProductos) {
        this.fProductos = fProductos;
        this.mProductos = mProductos;
        this.fProductos.buscarProductobtn.addActionListener(this);
        this.fProductos.editarProductobtn.addActionListener(this);
        this.fProductos.eliminarProductobtn.addActionListener(this);
        this.fProductos.agregarProductobtn.addActionListener(this);
        this.fProductos.ActualizarProductosbtn.addActionListener(this);
        this.cargarProductos();
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
            try {
                this.editarProductos();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == this.fProductos.eliminarProductobtn) {
            try {
                this.eliminarProductos();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == this.fProductos.agregarProductobtn) {
            try {
                this.agregarProductos();

            } catch (SQLException ex) {
                Logger.getLogger(ControladorProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == this.fProductos.ActualizarProductosbtn) {
            this.cargarProductos();
            try {
                this.CargarProveedoresCombobox();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorProductos.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void agregarProductos() throws SQLException {
        String ordenAgregarProductos = ("insert into productos(codigoProducto,nombreProducto,codigoProveedor) values(?,?,?);");
        Connection conProductos = msProductos.iniciarConexion();
        try {
            PreparedStatement psProductos = conProductos.prepareStatement(ordenAgregarProductos);
            psProductos.setString(1, this.fProductos.codigoProductotxt.getText());
            psProductos.setString(2, this.fProductos.nombreProductotxt.getText());
            psProductos.setString(3, this.fProductos.codigoProveedortxt.getSelectedItem().toString());
            if (this.fProductos.nombreProductotxt.getText().isEmpty() || this.fProductos.codigoProductotxt.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No puede dejar los campos en blanco", "Error", WARNING_MESSAGE);
            } else {
                psProductos.executeUpdate();
                psProductos.close();
            }
            msProductos.finalizarConexion(conProductos);
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Al guardar el producto Ya" + e);
        }
        this.cargarProductos();
    }

    public void buscarProductos() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) fProductos.tablaProductos.getModel();
        String ordenBuscarProductos = ("select * from productos where nombreProducto ='" + this.fProductos.buscadorProductostxt.getText() + "'");
        Connection conProductos = msProductos.iniciarConexion();
        PreparedStatement psProductos = conProductos.prepareStatement(ordenBuscarProductos);
        ResultSet rsProductos;
        if (this.fProductos.buscadorProductostxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese una palabra en el campo");
        } else {
            rsProductos = psProductos.executeQuery();
            if (rsProductos.next()) {
                modeloProductos moProductos = new modeloProductos();
                moProductos.setCodigoProducto(rsProductos.getString("codigoProducto"));
                moProductos.setNombreProducto(rsProductos.getString("nombreProducto"));
                moProductos.setCodigoProveedor(rsProductos.getString("codigoProveedor"));
                model.getDataVector().removeAllElements();
                this.fProductos.tablaProductos.updateUI();
                model.addRow(new Object[]{moProductos.getCodigoProducto(), moProductos.getNombreProducto(), moProductos.getCodigoProveedor()});
            } else {
                JOptionPane.showMessageDialog(null, "El producto buscado no existe");
            }

        }
    }

    public void editarProductos() throws SQLException {
        String OrdenModificarProducto = ("update productos set codigoProducto =?, nombreProducto=?, codigoProveedor=? where codigoProducto=?;");
        conProductos = msProductos.iniciarConexion();
        DefaultTableModel model = (DefaultTableModel) fProductos.tablaProductos.getModel();
        PreparedStatement psProductos = conProductos.prepareStatement(OrdenModificarProducto);
        try {
            if (this.fProductos.nombreProductotxt.getText().isEmpty() || this.fProductos.codigoProductotxt.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar e Ingresar nuevos valores en los campos");
            } else {
                psProductos.setString(1, this.fProductos.codigoProductotxt.getText());
                psProductos.setString(2, this.fProductos.nombreProductotxt.getText());
                psProductos.setString(3, (String) this.fProductos.codigoProveedortxt.getSelectedItem());
                psProductos.setString(4, this.fProductos.tablaProductos.getValueAt(this.fProductos.tablaProductos.getSelectedRow(), 0).toString());
                if (psProductos.executeUpdate() > 0) {

                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar");
                }
            }

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar debe seleccionar un item para modificar");
            System.out.println("Error del servidor" + e);
        }
        psProductos.close();
        msProductos.finalizarConexion(conProductos);
        this.cargarProductos();
    }

    public void eliminarProductos() throws SQLException {
        String OrdenEliminarProducto = ("delete from productos where codigoProducto =?;");
        conProductos = msProductos.iniciarConexion();
        PreparedStatement psProductos = conProductos.prepareStatement(OrdenEliminarProducto);
        try {
            if (this.fProductos.tablaProductos.getSelectedRows().length == 0) {
                JOptionPane.showMessageDialog(null, "Seleccione alemnos una ciudad", "Error", WARNING_MESSAGE);
            } else {
                for (int i = 0; i < this.fProductos.tablaProductos.getSelectedRows().length; i++) {
                    psProductos.setString(1, this.fProductos.tablaProductos.getValueAt(this.fProductos.tablaProductos.getSelectedRows()[i], 0).toString());
                    psProductos.executeUpdate();
                }
            }

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo Eliminar", "Atencion", CANCEL_OPTION);
        }
        psProductos.close();
        msProductos.finalizarConexion(conProductos);
        this.cargarProductos();
    }

    public LinkedList<modeloProductos> ListarProductos() {
        LinkedList<modeloProductos> listaProductos = new LinkedList<>();
        try {
            conProductos = msProductos.iniciarConexion();
            PreparedStatement psProductos = conProductos.prepareStatement("select * from productos;");
            ResultSet rsProductos = psProductos.executeQuery();
            while (rsProductos.next()) {
                modeloProductos moProductos = new modeloProductos();
                moProductos.setCodigoProducto(rsProductos.getString("codigoProducto"));
                moProductos.setNombreProducto(rsProductos.getString("nombreProducto"));
                moProductos.setCodigoProveedor(rsProductos.getString("codigoProveedor"));
                listaProductos.add(moProductos);
            }
            psProductos.close();
            rsProductos.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha podido listar los productos", "Error", WARNING_MESSAGE);
        }
        msProductos.finalizarConexion(conProductos);
        return listaProductos;
    }

    public void cargarProductos() {
        try {

            DefaultTableModel model = (DefaultTableModel) fProductos.tablaProductos.getModel();
            model.getDataVector().removeAllElements();
            this.fProductos.tablaProductos.updateUI();
            ListarProductos().forEach((lista) -> model.addRow(new Object[]{lista.getCodigoProducto(), lista.getNombreProducto(), lista.getCodigoProveedor()}));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los Productos");
        }
    }

    public LinkedList<String> ListarProveedores() throws SQLException {
        LinkedList<String> ListaProveedores = new LinkedList<>();
        conProductos = msProductos.iniciarConexion();
        PreparedStatement psProductos = conProductos.prepareStatement("select codigoProveedor from proveedores;");
        try {
            ResultSet rsProductos = psProductos.executeQuery();
            while (rsProductos.next()) {
                ListaProveedores.add(rsProductos.getString("codigoProveedor"));
            }
            rsProductos.close();
            msProductos.finalizarConexion(conProductos);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Listar");
        }

        return ListaProveedores;
    }

    public void CargarProveedoresCombobox() throws SQLException {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) fProductos.codigoProveedortxt.getModel();
            model.removeAllElements();
            ListarProveedores().forEach((lista) -> model.addElement(lista));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha podido listar los Proveedores");
        }

    }
}
