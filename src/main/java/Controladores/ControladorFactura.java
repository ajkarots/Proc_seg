/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Clases.MySql;
import Frames.FrameFacturas;
import Modelo.modeloFactura;
import Modelo.modeloProductos;
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
public class ControladorFactura implements ActionListener {

    private Connection conFactura;
    private MySql msFactura = new MySql();
    private modeloFactura mFactura;
    private FrameFacturas fFacturas;

    public ControladorFactura(modeloFactura mFactura, FrameFacturas fFacturas) {
        this.mFactura = mFactura;
        this.fFacturas = fFacturas;
        this.fFacturas.añadirFacturabtn.addActionListener(this);
        this.fFacturas.CodigoProductoBox.addActionListener(this);
        this.fFacturas.eliminarFacturabtn.addActionListener(this);
        this.cargarBoxProductos();
        this.cargarBoxClientes();
        this.cargarFacturas();
    }

    public MySql getMsFactura() {
        return this.msFactura;
    }

    public modeloFactura getmFactura() {
        return this.mFactura;
    }

    public FrameFacturas getfFacturas() {
        return this.fFacturas;
    }

    public void setMsFactura(MySql msFactura) {
        this.msFactura = msFactura;
    }

    public void setmFactura(modeloFactura mFactura) {
        this.mFactura = mFactura;
    }

    public void setfFacturas(FrameFacturas fFacturas) {
        this.fFacturas = fFacturas;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.fFacturas.añadirFacturabtn) {
            try {
                this.añadiraFactura();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorFactura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == this.fFacturas.CodigoProductoBox) {
            try {
                this.ActualizarCantidad();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorFactura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource()== this.fFacturas.eliminarFacturabtn) {
            try {
                this.eliminarFactura();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorFactura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void eliminarFactura() throws SQLException {
        Connection conProductos;
        String OrdenEliminarFactura = ("delete from compras where codigoCompra=?");
        String OrdenRegresarProductos = ("update productos set CantidadProducto=CantidadProducto+?,CostoTotal=CostoTotal-? where codigoProducto=?;");
        conFactura = msFactura.iniciarConexion();
        conProductos = msFactura.iniciarConexion();
        PreparedStatement psFactura = conFactura.prepareStatement(OrdenEliminarFactura);
        PreparedStatement psProducto= conProductos.prepareStatement(OrdenRegresarProductos);
        try {
            for (int i = 0; i < this.fFacturas.tablaFactura.getSelectedRows().length; i++) {
                psFactura.setInt(1, (int) this.fFacturas.tablaFactura.getValueAt(this.fFacturas.tablaFactura.getSelectedRows()[i], 0));
                psProducto.setInt(1, (int) this.fFacturas.tablaFactura.getValueAt(this.fFacturas.tablaFactura.getSelectedRows()[i], 3));
                psProducto.setDouble(2, (double) this.fFacturas.tablaFactura.getValueAt(this.fFacturas.tablaFactura.getSelectedRows()[i],5));
                psProducto.setString(3,this.fFacturas.tablaFactura.getValueAt(this.fFacturas.tablaFactura.getSelectedRows()[i], 2).toString());
                if (psFactura.executeUpdate()<1) {
                    JOptionPane.showMessageDialog(null, "No se elimino la Factura de producto");
                }
                if (psProducto.executeUpdate()<1) {
                    JOptionPane.showMessageDialog(null, "No se actualizo el inventario");
                }
            }

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error"+e);
        }
        psFactura.close();
        psProducto.close();
        msFactura.finalizarConexion(conFactura);
        msFactura.finalizarConexion(conProductos);
        this.cargarFacturas();
    }
    
    public void añadiraFactura() throws SQLException {
        Connection conProductos;
        double total = 0;
        total = Integer.parseInt(this.fFacturas.Cantidadtxt.getText()) * Double.parseDouble(this.fFacturas.precioproductoFacturatxt.getText());
        String OrdenAgregarFactura = ("insert into factura(codigoCliente,codigoProducto,cantidad,precio,total) values(?,?,?,?,?);");
        String OrdenReducirStringProducto = ("update productos set CantidadProducto=CantidadProducto-?,CostoTotal=CostoTotal+? where codigoProducto=?;");
        conFactura = msFactura.iniciarConexion();
        conProductos = msFactura.iniciarConexion();
        PreparedStatement psProducto = conProductos.prepareStatement(OrdenReducirStringProducto);
        PreparedStatement psFactura = conFactura.prepareStatement(OrdenAgregarFactura);
        try {
            psFactura.setString(1, this.fFacturas.codigoClienteBox.getSelectedItem().toString());
            psFactura.setString(2, this.fFacturas.CodigoProductoBox.getSelectedItem().toString());
            psFactura.setInt(3, Integer.parseInt(this.fFacturas.Cantidadtxt.getText()));
            psFactura.setDouble(4, Double.parseDouble(this.fFacturas.precioproductoFacturatxt.getText()));
            psFactura.setDouble(5, total);
            psProducto.setInt(1, Integer.parseInt(this.fFacturas.Cantidadtxt.getText()));
            psProducto.setDouble(2, total);
            psProducto.setString(3, this.fFacturas.CodigoProductoBox.getSelectedItem().toString());

            if (psFactura.executeUpdate() < 1) {
                JOptionPane.showMessageDialog(null, "No se ha podido agregar la compra");
            }
            if (psProducto.executeUpdate() < 1) {
                JOptionPane.showMessageDialog(null, "No se ha actualizado el inventario");
            }
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        psFactura.close();
        psProducto.close();
        msFactura.finalizarConexion(conProductos);
        msFactura.finalizarConexion(conFactura);
        this.cargarFacturas();
    }

    public void ActualizarCantidad() throws SQLException {
        String CantidadProducto = ("select CantidadProducto from productos where codigoProducto=?;");
        conFactura = msFactura.iniciarConexion();
        PreparedStatement psFactura = conFactura.prepareStatement(CantidadProducto);
        psFactura.setString(1, this.fFacturas.CodigoProductoBox.getSelectedItem().toString());
        try {
            ResultSet rsFactura = psFactura.executeQuery();
            while (rsFactura.next()) {
                this.fFacturas.CantidadExistentetxt.setText(String.valueOf(rsFactura.getInt("CantidadProducto")));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la cantidad/no existen registros");
        }
    }

//    public void Total() {
//        double total = 0;
//        for (int i = 0; i < this.fFacturas.tablaFactura.getRowCount(); i++) {
//            total=(Integer.valueOf(this.fFacturas.tablaFactura.getValueAt(i, 3).toString()) * Double.valueOf(this.fFacturas.tablaFactura.getValueAt(i, 4).toString()));
//        }
//        
//    }
    public LinkedList<String> ListarCodigosproductos() throws SQLException {
        LinkedList<String> ListaCodigoProductos = new LinkedList<>();
        String OrdenListarProductos = ("Select codigoProducto from productos;");
        conFactura = msFactura.iniciarConexion();
        PreparedStatement psFactura = conFactura.prepareStatement(OrdenListarProductos);
        try {
            ResultSet rsFactura = psFactura.executeQuery();
            while (rsFactura.next()) {
                ListaCodigoProductos.add(rsFactura.getString("codigoProducto"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "no se ha podido listar los codigos");
        }

        return ListaCodigoProductos;
    }

    public void cargarBoxProductos() {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) this.fFacturas.CodigoProductoBox.getModel();
            model.removeAllElements();
            //this.fFacturas.CodigoProductoBox.removeAllItems();
            ListarCodigosproductos().forEach((lista) -> model.addElement(lista));
            this.fFacturas.CodigoProductoBox.revalidate();
            this.fFacturas.CodigoProductoBox.repaint();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los codigos de producto");
        }
    }
    public LinkedList<modeloFactura> ListarFacturas() throws SQLException{
    LinkedList<modeloFactura> ListaFacturas = new LinkedList<>();
      conFactura = msFactura.iniciarConexion();
        String OrderCargarFacturas=  ("select * from factura;");
        PreparedStatement psCompras = conFactura.prepareCall(OrderCargarFacturas);
        try {
            ResultSet rsCompras = psCompras.executeQuery();
            while (rsCompras.next()) {
                modeloFactura moFactura = new modeloFactura();
                moFactura.setCodigoFactura(rsCompras.getInt("codigoFactura"));
                moFactura.setCodigoCliente(rsCompras.getString("codigoCliente"));
                moFactura.setCodigoProducto(rsCompras.getString("codigoProducto"));
                moFactura.setCantidad(rsCompras.getInt("cantidad"));
                moFactura.setPrecio(rsCompras.getDouble("precio"));
                moFactura.setTotal(rsCompras.getDouble("total"));
                ListaFacturas.add(moFactura);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo listar las Facturas");
        }
    return ListaFacturas;
    }
    
    public void cargarFacturas(){
        DefaultTableModel model = (DefaultTableModel)this.fFacturas.tablaFactura.getModel();
        model.getDataVector().removeAllElements();
        this.fFacturas.tablaFactura.updateUI();
        try {
            ListarFacturas().forEach((lista) ->model.addRow(new Object[]{lista.getCodigoFactura(), lista.getCodigoCliente(), lista.getCodigoProducto(),
                lista.getCantidad(), lista.getPrecio(), lista.getTotal()}));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar sus facturas");
        }
    };
    
        public LinkedList<String> ListarCodigoCliente() throws SQLException {
        LinkedList<String> ListaCodigoCliente = new LinkedList<>();
        String OrdenListarClientes = ("Select cedulaCliente from clientes;");
        conFactura = msFactura.iniciarConexion();
        PreparedStatement psFactura = conFactura.prepareStatement(OrdenListarClientes);
        try {
            ResultSet rsFactura = psFactura.executeQuery();
            while (rsFactura.next()) {
                ListaCodigoCliente.add(rsFactura.getString("cedulaCliente"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "no se ha podido listar los codigos");
        }

        return ListaCodigoCliente;
    }

    public void cargarBoxClientes() {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) this.fFacturas.codigoClienteBox.getModel();
            model.removeAllElements();
            ListarCodigoCliente().forEach((lista) -> model.addElement(lista));
            this.fFacturas.codigoClienteBox.revalidate();
            this.fFacturas.codigoClienteBox.repaint();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los codigos de cliente");
        }
    }
    
}
