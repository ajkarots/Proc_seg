/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Clases.MySql;
import Frames.FrameFacturas;
import Modelo.modeloFactura;
import Modelo.modeloProductos;
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
        this.fFacturas.BotontotalFacturabtn.addActionListener(this);
        this.fFacturas.añadirFacturabtn.addActionListener(this);
        this.fFacturas.CodigoProductoBox.addActionListener(this);
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
        if (e.getSource()== this.fFacturas.BotontotalFacturabtn) {
            
        }
        if (e.getSource()==this.fFacturas.añadirFacturabtn) {
            
        }
        if (e.getSource()==this.fFacturas.CodigoProductoBox) {
            try {
                this.ActualizarCantidad();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorFactura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void añadiraFactura() {
    String BuscarNombreProducto = ("select nombreProducto from productos where codigoProducto='"+this.fFacturas.CodigoProductoBox+"';"); 
        
        
    }
    public void ActualizarCantidad() throws SQLException{
    String CantidadProducto = ("Select cantidad from inventario where codigoProducto ='"+this.fFacturas.CodigoProductoBox.getSelectedItem().toString()+"';");
    conFactura=msFactura.iniciarConexion();
    PreparedStatement psFactura = conFactura.prepareStatement(CantidadProducto);
        try {
            ResultSet rsFactura = psFactura.executeQuery();
            while (rsFactura.next()) {                
                this.fFacturas.CantidadExistentetxt.setText(String.valueOf(rsFactura.getInt("cantidad")));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la cantidad/no existen registros");
        }
    }
    public void Total() {
        double total = 0;
        for (int i = 0; i < this.fFacturas.tablaFactura.getRowCount(); i++) {
            total = total+(Integer.valueOf(this.fFacturas.tablaFactura.getValueAt(i,3).toString())*Double.valueOf(this.fFacturas.tablaFactura.getValueAt(i,4).toString()));
        }
        this.fFacturas.totalFactura.setText(String.valueOf(total));
    }

    public LinkedList<String> ListarCodigosproductos() throws SQLException {
        LinkedList<String> ListaCodigoProductos = new LinkedList<>();
        String OrdenListarProductos = ("Select codigoProducto from productos;");
        conFactura=msFactura.iniciarConexion();
        PreparedStatement psFactura= conFactura.prepareStatement(OrdenListarProductos);
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
            DefaultComboBoxModel model = (DefaultComboBoxModel)this.fFacturas.CodigoProductoBox.getModel();
            ListarCodigosproductos().forEach((lista) -> model.addElement(lista));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los codigos de producto");
        }
    }
}
