/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Clases.MySql;
import Frames.FrameClientes;
import Modelo.modeloClientes;
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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pc
 */
public class ControladorClientes implements ActionListener {

    private FrameClientes fClientes;
    private modeloClientes mClientes;
    private MySql msClientes = new MySql();
    private Connection conClientes;

    public ControladorClientes(FrameClientes fClientes, modeloClientes mClientes) {
        this.fClientes = fClientes;
        this.mClientes = mClientes;
        this.fClientes.ActualizarClientebtn.addActionListener(this);
        this.fClientes.buscarClientebtn.addActionListener(this);
        this.fClientes.editarClientebtn.addActionListener(this);
        this.fClientes.eliminarClientebtn.addActionListener(this);
        this.fClientes.guardarClientebtn.addActionListener(this);
        this.cargarClientes();
    }

    public FrameClientes getfClientes() {
        return this.fClientes;
    }

    public modeloClientes getmClientes() {
        return this.mClientes;
    }

    public void setfClientes(FrameClientes fClientes) {
        this.fClientes = fClientes;
    }

    public void setmClientes(modeloClientes mClientes) {
        this.mClientes = mClientes;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.fClientes.ActualizarClientebtn) {
            this.cargarClientes();
            try {
                this.CargarCiudadesCombobox();
                this.CargarProvinciasCombobox();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == this.fClientes.buscarClientebtn) {
            try {
                this.buscarClientes();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() ==this.fClientes.editarClientebtn) {
            try {
                this.editarClientes();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() ==this.fClientes.eliminarClientebtn) {
            try {
                this.eliminarClientes();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() ==this.fClientes.guardarClientebtn) {
            try {
                this.agregarClientes();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void agregarClientes() throws SQLException {
        String OrdenAgregarClientes = ("insert into clientes(cedulaCliente,nombreCliente,direccionCliente,codigoCiudad,codigoProvincia) values(?,?,?,?,?);");
        conClientes = msClientes.iniciarConexion();
        try {
            PreparedStatement psClientes = conClientes.prepareStatement(OrdenAgregarClientes);
            psClientes.setString(1, fClientes.cedulaClientetxt.getText());
            psClientes.setString(2, fClientes.nombreClientetxt.getText());
            psClientes.setString(3, fClientes.direccionClientetxt.getText());
            psClientes.setString(4, fClientes.CiudadBox.getSelectedItem().toString());
            psClientes.setString(5, fClientes.ProvinciaBox.getSelectedItem().toString());
            if (this.fClientes.cedulaClientetxt.getText().isEmpty() || this.fClientes.direccionClientetxt.getText().isEmpty()
                    || this.fClientes.nombreClientetxt.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Puede dejar campos en blanco");
            } else {
                psClientes.executeUpdate();
                psClientes.close();
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar al cliente" + e);
        }
        this.cargarClientes();

    }

    public void eliminarClientes() throws SQLException {
        String OrdenEliminarClientes = ("delete from clientes where codigoCliente=?");
        conClientes = msClientes.iniciarConexion();
        PreparedStatement psClientes = conClientes.prepareStatement(OrdenEliminarClientes);
        try {
            if (this.fClientes.tablaClientes.getSelectedRows().length == 0) {
                JOptionPane.showMessageDialog(null, "Seleccione alemnos un producto");
            } else {
                for (int i = 0; i < this.fClientes.tablaClientes.getSelectedRows().length; i++) {
                    psClientes.setString(1, this.fClientes.tablaClientes.getValueAt(this.fClientes.tablaClientes.getSelectedRows()[i], 0).toString());
                    psClientes.executeUpdate();
                }
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puedo eliminar el producto");
        }
        psClientes.close();
        msClientes.finalizarConexion(conClientes);
        this.cargarClientes();
    }

    public void editarClientes() throws SQLException {
        String OrdenEditarClientes = ("update clientes set cedulaCliente=?,nombreCliente=?,direccionCliente=?,codigoCiudad=?,codigoProvincia=? where codigoCliente=?");
        conClientes = msClientes.iniciarConexion();
        PreparedStatement psClientes = conClientes.prepareStatement(OrdenEditarClientes);
        try {
            if (this.fClientes.cedulaClientetxt.getText().isEmpty() || this.fClientes.direccionClientetxt.getText().isEmpty()
                    || this.fClientes.nombreClientetxt.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Los campos no deben estar vacios");
            } else {
                psClientes.setString(1, this.fClientes.cedulaClientetxt.getText());
                psClientes.setString(2, this.fClientes.nombreClientetxt.getText());
                psClientes.setString(3, this.fClientes.direccionClientetxt.getText());
                psClientes.setString(4, this.fClientes.CiudadBox.getSelectedItem().toString());
                psClientes.setString(5, this.fClientes.ProvinciaBox.getSelectedItem().toString());
                psClientes.setString(6, this.fClientes.tablaClientes.getValueAt(this.fClientes.tablaClientes.getSelectedRow(), 0).toString());
                if (psClientes.executeUpdate() > 0) {

                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar el cliente");
                }
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Debe eleccionar un cliente para modificar");
            System.out.println(e);
        }
        psClientes.close();
        msClientes.finalizarConexion(conClientes);
        this.cargarClientes();
    }

    public void buscarClientes() throws SQLException {
        String OrdenBuscarClientes = ("Select * from clientes where cedulaCliente=?");
        conClientes = msClientes.iniciarConexion();
        DefaultTableModel model = (DefaultTableModel) this.fClientes.tablaClientes.getModel();

        try {
            PreparedStatement psClientes = conClientes.prepareStatement(OrdenBuscarClientes);
            ResultSet rsClientes = psClientes.executeQuery();;
            if (this.fClientes.buscadorClientetxt.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo de busqueda no debe estar en blanco");
            } else {
                if (rsClientes.next()) {
                    modeloClientes moClientes = new modeloClientes();
                    moClientes.setCedula(rsClientes.getString("cedulaCliente"));
                    moClientes.setNombre(rsClientes.getString("nombreCliente"));
                    moClientes.setDireccion(rsClientes.getString("direccionCliente"));
                    moClientes.setCodigoCiudad(rsClientes.getString("codigoCiudad"));
                    moClientes.setCodigoProvincia(rsClientes.getString("codigoProvincia"));
                    model.getDataVector().removeAllElements();
                    this.fClientes.tablaClientes.updateUI();
                    model.addRow(new Object[]{moClientes.getCedula(), moClientes.getNombre(), moClientes.getDireccion(), moClientes.getCodigoCiudad(), moClientes.getCodigoProvincia()});
                }
                JOptionPane.showMessageDialog(null, "El cliente buscado no existe");
            }
            psClientes.close();
            rsClientes.close();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar el cliente" + e);
        }

        msClientes.finalizarConexion(conClientes);

    }

    public LinkedList<modeloClientes> ListarClientes() {
        LinkedList<modeloClientes> ListaClientes = new LinkedList<>();
        String OrdenListarClientes = ("select * from clientes");
        conClientes = msClientes.iniciarConexion();
        try {
            PreparedStatement psclientes = conClientes.prepareStatement(OrdenListarClientes);
            ResultSet rsClientes = psclientes.executeQuery();
            while (rsClientes.next()) {
                modeloClientes moClientes = new modeloClientes();
                moClientes.setCedula(rsClientes.getString("cedulaCliente"));
                moClientes.setNombre(rsClientes.getString("nombreCliente"));
                moClientes.setDireccion(rsClientes.getString("direccionCliente"));
                moClientes.setCodigoCiudad(rsClientes.getString("codigoCiudad"));
                moClientes.setCodigoProvincia(rsClientes.getString("codigoProvincia"));
                ListaClientes.add(moClientes);
            }
            psclientes.close();
            rsClientes.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar clientes");
        }
        msClientes.finalizarConexion(conClientes);
        return ListaClientes;

    }

    public void cargarClientes() {
        try {
            DefaultTableModel model = (DefaultTableModel) this.fClientes.tablaClientes.getModel();
            this.ListarClientes().forEach((lista) -> model.addRow(new Object[]{lista.getCedula(), lista.getNombre(), lista.getDireccion(), lista.getCodigoCiudad(), lista.getCodigoProvincia()}));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los clientes" + e);
        }

    }

    public LinkedList<String> listarCiudad() throws SQLException {
        LinkedList<String> ListaCiudades = new LinkedList<>();
        conClientes = msClientes.iniciarConexion();
        PreparedStatement psProveedores = conClientes.prepareStatement("select codigoCiudad from ciudades;");

        try {
            ResultSet rsClientes = psProveedores.executeQuery();
            while (rsClientes.next()) {
                ListaCiudades.add(rsClientes.getString("codigoCiudad"));

            }
            rsClientes.close();
            msClientes.finalizarConexion(conClientes);
        } catch (SQLException e) {

        }

        return ListaCiudades;
    }

    public void CargarCiudadesCombobox() throws SQLException {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) fClientes.CiudadBox.getModel();
            model.removeAllElements();
            listarCiudad().forEach((lista) -> model.addElement(lista));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha podido listar las ciudades");
        }

    }

    public LinkedList<String> ListarProvincias() throws SQLException {
        LinkedList<String> ListaProvincias = new LinkedList<>();
        conClientes = msClientes.iniciarConexion();
        PreparedStatement psProveedores = conClientes.prepareStatement("select codigoProvincia from Provincias;");
        try {
            ResultSet rsClientes = psProveedores.executeQuery();
            while (rsClientes.next()) {
                ListaProvincias.add(rsClientes.getString("codigoProvincia"));
            }
            rsClientes.close();
            msClientes.finalizarConexion(conClientes);
        } catch (SQLException e) {

        }

        return ListaProvincias;
    }

    public void CargarProvinciasCombobox() throws SQLException {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) fClientes.ProvinciaBox.getModel();
            model.removeAllElements();
            ListarProvincias().forEach((lista) -> model.addElement(lista));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha podido listar las provincias");
        }

    }

}
