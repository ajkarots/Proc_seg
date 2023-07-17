/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Clases.MySql;
import Frames.FrameProveedores;
import Modelo.modeloProveedor;
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
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.CANCEL_OPTION;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pc
 */
public class ControladorProveedores implements ActionListener{
    private FrameProveedores fProveedores ;
    private modeloProveedor mProveedor;
    private MySql msProveedores = new MySql();
    Connection conProveedores;

    public ControladorProveedores(FrameProveedores fProveedores, modeloProveedor mProveedor) {
        this.fProveedores = fProveedores;
        this.mProveedor = mProveedor;
        this.fProveedores.buscarProveedores.addActionListener(this);
        this.fProveedores.editarProveedor.addActionListener(this);
        this.fProveedores.eliminiarProveedor.addActionListener(this);
        this.fProveedores.editarProveedor.addActionListener(this);
        this.fProveedores.Actualizarbtn.addActionListener(this);
        this.cargarProveedores();
    }

    public void setfProveedores(FrameProveedores fProveedores) {
        this.fProveedores = fProveedores;
    }

    public void setmProveedor(modeloProveedor mProveedor) {
        this.mProveedor = mProveedor;
    }

    public FrameProveedores getfProveedores() {
        return this.fProveedores;
    }

    public modeloProveedor getmProveedor() {
        return this.mProveedor;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==fProveedores.Actualizarbtn) {
            this.cargarProveedores();
        }
        if (e.getSource()==fProveedores.eliminiarProveedor) {
            try {
                this.eliminarProveedor();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorProveedores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource()==fProveedores.editarProveedor) {

            try {
                this.modificarProveedor();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorProveedores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource()==fProveedores.guardarProveedor) {
            try {
                this.agregarProveedor();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorProveedores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource()==fProveedores.buscadorProveedores) {
            try {
                this.buscarProveedor();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorProveedores.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    public void buscarProveedor() throws SQLException {
        String OrdenBuscarProveedor = ("select * from proveedores where codigoProveedor =?;");
        conProveedores = msProveedores.iniciarConexion();
        DefaultTableModel model = (DefaultTableModel) fProveedores.tablaProveedores.getModel();
        PreparedStatement psProveedores = conProveedores.prepareStatement(OrdenBuscarProveedor);

        try {
            if (this.fProveedores.buscadorProveedores.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor en el cuadro de busqueda");
            } else {
                psProveedores.setString(1, this.fProveedores.buscadorProveedores.getText());
                ResultSet rsProveedores = psProveedores.executeQuery();
                if (rsProveedores.next()) {
                    modeloProveedor moProveedor = new modeloProveedor();
                    moProveedor.setCodigoCiudad(rsProveedores.getString("codigoProveedor"));
                    moProveedor.setRucProveedor(rsProveedores.getInt("rucProveedor"));
                    moProveedor.setNombreProveedor(rsProveedores.getString("nombreProveedor"));
                    moProveedor.setTelefonoProveedor(rsProveedores.getInt("telefonoProveedor"));
                    moProveedor.setDireccionProveedor(rsProveedores.getString("direccionProveedor"));
                    moProveedor.setCodigoCiudad(rsProveedores.getString("codigoCiudad"));
                    moProveedor.setCodigoProvincia(rsProveedores.getString("codigoProvincia"));
                    model.getDataVector().removeAllElements();
                    this.fProveedores.tablaProveedores.updateUI();
                    model.addRow(new Object[]{moProveedor.getCodigoProveedor(),moProveedor.getRucProveedor(),moProveedor.getNombreProveedor(),moProveedor.getTelefonoProveedor(),
                    moProveedor.getDireccionProveedor(),moProveedor.getCodigoCiudad(),moProveedor.getCodigoProvincia()});
                } else {
                    JOptionPane.showMessageDialog(null, "No existe el Proveedor buscad");
                }
            }

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println("Ingrese unicamente hasta 4 digitos entre numeros y letras" + e);
        }

        
    }

    public void modificarProveedor() throws SQLException {
        String OrdenModificarProveedores = ("update proveedores set codigoProveedor=?, rucProveedor=?, nombreProveedor=?, telefonoProveedor=?, "
                + "direccionProveedor=?, codigoCiudad=?, cdoigoProvincia=? where codigoProveedor=?;");
        conProveedores = msProveedores.iniciarConexion();
        DefaultTableModel model = (DefaultTableModel) fProveedores.tablaProveedores.getModel();
        PreparedStatement psProveedores = conProveedores.prepareStatement(OrdenModificarProveedores);
        try {
            if (this.fProveedores.rucproveedortxt.getText().isEmpty() || this.fProveedores.nombreProveedor.getText().isEmpty()
                    || this.fProveedores.nombreProveedor.getText().isEmpty() ||this.fProveedores.telefonoProveedor.getText().isEmpty()
                    || this.fProveedores.direccionProveedor.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar e Ingresar nuevos valores en los campos");
            } else {
            psProveedores.setString(1, this.fProveedores.codigoProveedortxt.getText());
            psProveedores.setInt(2, Integer.parseInt(this.fProveedores.rucproveedortxt.getText()));
            psProveedores.setString(3, this.fProveedores.nombreProveedor.getText());
            psProveedores.setInt(4, Integer.parseInt(this.fProveedores.telefonoProveedor.getText()));
            psProveedores.setString(5, this.fProveedores.direccionProveedor.getText());
            psProveedores.setString(6, this.fProveedores.CiudadProveedortxt.getSelectedItem().toString());
            psProveedores.setString(7, this.fProveedores.ProvinciaProveedortxt.getSelectedItem().toString());
                if (psProveedores.executeUpdate() > 0) {

                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar");
                }
            }

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar debe seleccionar un item para modificar");
            System.out.println("Error del servidor" + e);
        }
        this.cargarProveedores();
    }

    public void eliminarProveedor() throws SQLException {
        this.fProveedores.tablaProveedores.getSelectedRows();
        String ordenEliminarProvincia = ("delete from proveedores where codigoProveedor =?;");
        conProveedores = msProveedores.iniciarConexion();
        DefaultTableModel model = (DefaultTableModel) fProveedores.tablaProveedores.getModel();

        PreparedStatement psProvincia = conProveedores.prepareStatement(ordenEliminarProvincia);
        try {
            if (this.fProveedores.tablaProveedores.getSelectedRows().length == 0) {
                JOptionPane.showMessageDialog(null, "Seleccione alemnos un proveedor", "Error", WARNING_MESSAGE);
            } else {
                for (int i = 0; i < this.fProveedores.tablaProveedores.getSelectedRows().length; i++) {
                    System.out.println(this.fProveedores.tablaProveedores.getValueAt(this.fProveedores.tablaProveedores.getSelectedRows()[i], 0));
                    psProvincia.setString(1, (String) this.fProveedores.tablaProveedores.getValueAt(this.fProveedores.tablaProveedores.getSelectedRows()[i], 0));
                    psProvincia.executeUpdate();
                }
            }

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo Eliminar", "Atencion", CANCEL_OPTION);
        }
        psProvincia.close();
        msProveedores.finalizarConexion(conProveedores);
        this.cargarProveedores();
    }

    public void agregarProveedor() throws SQLException {
        String OrdenAgregarProveedor = ("insert into proveedores(codigoProveedor,rucProveedor,nombreProveedor,telefonoProveedor,direccionProveedor\n" +
",codigoCiudad,cdoigoProvincia) values(?,?,?,?,?,?,?);");
        conProveedores = msProveedores.iniciarConexion();

        try {
            PreparedStatement psProveedores = conProveedores.prepareStatement(OrdenAgregarProveedor);
            psProveedores.setString(1, this.fProveedores.codigoProveedortxt.getText());
            psProveedores.setInt(2, Integer.parseInt(this.fProveedores.rucproveedortxt.getText()));
            psProveedores.setString(3, this.fProveedores.nombreProveedor.getText());
            psProveedores.setInt(4, Integer.parseInt(this.fProveedores.telefonoProveedor.getText()));
            psProveedores.setString(5, this.fProveedores.direccionProveedor.getText());
            psProveedores.setString(6, this.fProveedores.CiudadProveedortxt.getSelectedItem().toString());
            psProveedores.setString(7, this.fProveedores.ProvinciaProveedortxt.getSelectedItem().toString());
            if (this.fProveedores.rucproveedortxt.getText().isEmpty() || this.fProveedores.nombreProveedor.getText().isEmpty()
                    || this.fProveedores.nombreProveedor.getText().isEmpty() ||this.fProveedores.telefonoProveedor.getText().isEmpty()
                    || this.fProveedores.direccionProveedor.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No puede dejar los campos en blanco", "Error", WARNING_MESSAGE);
            } else {
                psProveedores.executeUpdate();
            }
            msProveedores.finalizarConexion(conProveedores);
            psProveedores.close();
        } catch (HeadlessException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "No se a podido agregar el Proveedor" + e);
        }
        this.cargarProveedores();
    }

    public LinkedList<modeloProveedor> ListarProveedores() {
        LinkedList<modeloProveedor> listaProveedores = new LinkedList<>();
        try {
            conProveedores = msProveedores.iniciarConexion();
            PreparedStatement psProveedores = conProveedores.prepareStatement("select * from proveedores;");
            ResultSet rsProveedores = psProveedores.executeQuery();
            while (rsProveedores.next()) {

                modeloProveedor moProveedor = new modeloProveedor();
                    moProveedor.setCodigoCiudad(rsProveedores.getString("codigoProveedor"));
                    moProveedor.setRucProveedor(rsProveedores.getInt("rucProveedor"));
                    moProveedor.setNombreProveedor(rsProveedores.getString("nombreProveedor"));
                    moProveedor.setTelefonoProveedor(rsProveedores.getInt("telefonoProveedor"));
                    moProveedor.setDireccionProveedor(rsProveedores.getString("direccionProveedor"));
                    moProveedor.setCodigoCiudad(rsProveedores.getString("codigoCiudad"));
                    moProveedor.setCodigoProvincia(rsProveedores.getString("codigoProvincia"));
                listaProveedores.add(moProveedor);
            }
            psProveedores.close();
            rsProveedores.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha podido listar los proveedores", "Error", WARNING_MESSAGE);
        }
        msProveedores.finalizarConexion(conProveedores);
        return listaProveedores;
    }

    public void cargarProveedores() {
        try {

            DefaultTableModel model = (DefaultTableModel) fProveedores.tablaProveedores.getModel();
            model.getDataVector().removeAllElements();
            this.fProveedores.tablaProveedores.updateUI();
            ListarProveedores().forEach((lista) -> model.addRow(new Object[]{lista.getCodigoProveedor(),lista.getRucProveedor(),lista.getNombreProveedor(),lista.getTelefonoProveedor(),
                    lista.getDireccionProveedor(),lista.getCodigoCiudad(),lista.getCodigoProvincia()}));
        } catch (Exception e) {

        }
    }

}
    

