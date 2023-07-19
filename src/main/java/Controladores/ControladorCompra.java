/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Clases.MySql;
import Frames.FrameCompra;
import Modelo.modeloCompra;
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
public class ControladorCompra implements ActionListener {

    private modeloCompra mCompra;
    private FrameCompra fCompra;
    private MySql msCompra = new MySql();
    private Connection conCompra;

    public ControladorCompra(FrameCompra fCompra, modeloCompra mCompra) {
        this.mCompra = mCompra;
        this.fCompra = fCompra;
        this.fCompra.añadirCompra.addActionListener(this);
        this.fCompra.eliminarCompra.addActionListener(this);
        this.cargarCompras();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.fCompra.añadirCompra) {
            try {
                this.AgregarCompra();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorCompra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == this.fCompra.eliminarCompra) {
            try {
                this.EliminarCompra();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorCompra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void AgregarCompra() throws SQLException {
        double total = 0;
        Connection conProductos;
        total = Integer.parseInt(this.fCompra.cantidadCompratxt.getText()) * Double.parseDouble(this.fCompra.precioproductoCompratxt.getText());
        String OrdenAgregarCompra = ("insert into compras(codigoCompra,codigoProveedor,codigoProducto,cantidad,precio,total) values(?,?,?,?,?,?);");
        String OrdenAgregarProducto = ("update productos set CantidadProducto=CantidadProducto+?,CostoTotal=CostoTotal-? where codigoProducto=?;");
        conCompra = msCompra.iniciarConexion();
        conProductos = msCompra.iniciarConexion();
        PreparedStatement psProducto = conProductos.prepareStatement(OrdenAgregarProducto);
        PreparedStatement psCompra = conCompra.prepareStatement(OrdenAgregarCompra);
        try {
            psCompra.setInt(1, 0);
            psCompra.setString(2, this.fCompra.codigoProveedorBox.getSelectedItem().toString());
            psCompra.setString(3, this.fCompra.CodigoProductoBox.getSelectedItem().toString());
            psCompra.setInt(4, Integer.parseInt(this.fCompra.cantidadCompratxt.getText()));
            psCompra.setDouble(5, Double.parseDouble(this.fCompra.precioproductoCompratxt.getText()));
            psCompra.setDouble(6, total);
            psProducto.setInt(1, Integer.parseInt(this.fCompra.cantidadCompratxt.getText()));
            psProducto.setDouble(2, total);
            psProducto.setString(3, this.fCompra.CodigoProductoBox.getSelectedItem().toString());
            psProducto.executeUpdate();
            if (psCompra.executeUpdate() > 0) {

            } else {
                JOptionPane.showMessageDialog(null, "No se ha podido agregar la compra");
            }
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        psCompra.close();
        psProducto.close();
        msCompra.finalizarConexion(conCompra);
        this.cargarCompras();
    }

    public void EliminarCompra() throws SQLException {
        Connection conProductos;
        String OrdenEliminarCompra = ("delete from compras where codigoCompra=?");
        String OrdenReducirProductos = ("update productos set CantidadProducto=CantidadProducto-?,CostoTotal=CostoTotal+? where codigoProducto=?;");
        conCompra = msCompra.iniciarConexion();
        conProductos = msCompra.iniciarConexion();
        PreparedStatement psCompra = conCompra.prepareStatement(OrdenEliminarCompra);
        PreparedStatement psProducto= conProductos.prepareStatement(OrdenReducirProductos);
        try {
            for (int i = 0; i < this.fCompra.tablaCompras.getSelectedRows().length; i++) {
                psCompra.setInt(1, (int) this.fCompra.tablaCompras.getValueAt(this.fCompra.tablaCompras.getSelectedRows()[i], 0));
                psProducto.setInt(1, (int) this.fCompra.tablaCompras.getValueAt(this.fCompra.tablaCompras.getSelectedRows()[i], 3));
                psProducto.setDouble(2, (double) this.fCompra.tablaCompras.getValueAt(this.fCompra.tablaCompras.getSelectedRows()[i],5));
                psProducto.setString(3,this.fCompra.tablaCompras.getValueAt(this.fCompra.tablaCompras.getSelectedRows()[i], 2).toString());
                if (psCompra.executeUpdate()<1) {
                    JOptionPane.showMessageDialog(null, "No se elimino la compra de producto");
                }
                if (psProducto.executeUpdate()<1) {
                    JOptionPane.showMessageDialog(null, "No se actualizo el inventario");
                }
            }

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error"+e);
        }
        psCompra.close();
        psProducto.close();
        msCompra.finalizarConexion(conCompra);
        msCompra.finalizarConexion(conProductos);
        this.cargarCompras();
    }

    public LinkedList<String> ListarProveedores() throws SQLException {
        LinkedList<String> ListaProveedores = new LinkedList<>();
        conCompra = msCompra.iniciarConexion();
        PreparedStatement psCompra = conCompra.prepareStatement("select codigoProveedor from proveedores;");
        try {
            ResultSet rsCompra = psCompra.executeQuery();
            while (rsCompra.next()) {
                ListaProveedores.add(rsCompra.getString("codigoProveedor"));
            }
            rsCompra.close();
            msCompra.finalizarConexion(conCompra);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Listar");
        }
        psCompra.close();
        msCompra.finalizarConexion(conCompra);
        return ListaProveedores;
    }

    public void CargarProveedoresCombobox() throws SQLException {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) fCompra.codigoProveedorBox.getModel();
            model.removeAllElements();
            ListarProveedores().forEach((lista) -> model.addElement(lista));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha podido listar los Proveedores");
        }

    }

    public LinkedList<String> ListarCodigosproductos() throws SQLException {
        LinkedList<String> ListaCodigoProductos = new LinkedList<>();
        String OrdenListarProductos = ("Select codigoProducto from productos;");
        conCompra = msCompra.iniciarConexion();
        PreparedStatement psCompra = conCompra.prepareStatement(OrdenListarProductos);
        try {
            ResultSet rsCompra = psCompra.executeQuery();
            while (rsCompra.next()) {
                ListaCodigoProductos.add(rsCompra.getString("codigoProducto"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "no se ha podido listar los codigos");
        }
        psCompra.close();
        msCompra.finalizarConexion(conCompra);
        return ListaCodigoProductos;
    }

    public void cargarBoxProductos() throws SQLException {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) this.fCompra.CodigoProductoBox.getModel();
            model.removeAllElements();
            this.fCompra.CodigoProductoBox.updateUI();
            ListarCodigosproductos().forEach((lista) -> model.addElement(lista));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los codigos de producto");
        }
    }

    public LinkedList<modeloCompra> ListarCompras() throws SQLException {
        LinkedList<modeloCompra> ListaCompras = new LinkedList<>();
        conCompra = msCompra.iniciarConexion();
        String OrderCargarCompras = ("select * from compras;");
        PreparedStatement psCompras = conCompra.prepareCall(OrderCargarCompras);
        try {
            ResultSet rsCompras = psCompras.executeQuery();
            while (rsCompras.next()) {
                modeloCompra moCompra = new modeloCompra();
                moCompra.setCodigoCompra(rsCompras.getInt("codigoCompra"));
                moCompra.setCodigoProveedor(rsCompras.getString("codigoProveedor"));
                moCompra.setCodigoProducto(rsCompras.getString("codigoProducto"));
                moCompra.setCantidad(rsCompras.getInt("cantidad"));
                moCompra.setPrecioCompra(rsCompras.getDouble("precio"));
                moCompra.setTotal(rsCompras.getDouble("total"));
                ListaCompras.add(moCompra);
            }

        } catch (SQLException e) {
        }
        msCompra.finalizarConexion(conCompra);
        return ListaCompras;
    }

    public void cargarCompras() {
        try {
            DefaultTableModel model = (DefaultTableModel) this.fCompra.tablaCompras.getModel();
            model.getDataVector().removeAllElements();
            this.fCompra.tablaCompras.updateUI();
            this.ListarCompras().forEach((lista) -> model.addRow(new Object[]{lista.getCodigoCompra(), lista.getCodigoProveedor(), lista.getCodigoProducto(),
                lista.getCantidad(), lista.getPrecioCompra(), lista.getTotal()}));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "no se ha podido listar");
        }
    }

    public String nombreProducto(String codigo) throws SQLException{
        String nombre = null;
        String ObtenerNombreProducto=("select nombreProducto from productos where codigoProducto=?");
        conCompra= msCompra.iniciarConexion();
        PreparedStatement psCompra = conCompra.prepareStatement(ObtenerNombreProducto);
        try {
            psCompra.setString(1, codigo);
            ResultSet rsCompra = psCompra.executeQuery();
            if (rsCompra.next()) {
                nombre= rsCompra.getString("nombreProducto");
            }
            else{
            JOptionPane.showMessageDialog(null, "No se Obtuvo el nombre");
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error"+e);
        }
        
        return nombre;
    }
}
