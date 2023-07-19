/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Clases.MySql;
import Frames.FrameUsuarios;
import Modelo.modeloUsuario;
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
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pc
 */
public class ControladorPermisosUsusario implements ActionListener {

    private modeloUsuario mUsuario;
    private FrameUsuarios fUsuarios;
    private MySql msUsuarios = new MySql();
    private Connection conUsuarios;

    public ControladorPermisosUsusario(modeloUsuario mUsuario, FrameUsuarios frameUsuarios) {
        this.mUsuario = mUsuario;
        this.fUsuarios = frameUsuarios;
        this.fUsuarios.eliminarUsuariobtn.addActionListener(this);
        this.fUsuarios.AgregarUsuariobtn.addActionListener(this);
        this.fUsuarios.editarUsuariobtn.addActionListener(this);
        this.fUsuarios.buscarUsuariobtn.addActionListener(this);
        this.fUsuarios.Actualizarbtn.addActionListener(this);
        this.cargarUsuarios();
    }

    public modeloUsuario getmUsuario() {
        return mUsuario;
    }

    public FrameUsuarios getfUsuarios() {
        return fUsuarios;
    }

    public void setmUsuario(modeloUsuario mUsuario) {
        this.mUsuario = mUsuario;
    }

    public void setfUsuarios(FrameUsuarios fUsuarios) {
        this.fUsuarios = fUsuarios;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.fUsuarios.Actualizarbtn) {
            this.cargarUsuarios();

        }
        if (e.getSource() == this.fUsuarios.buscarUsuariobtn) {
            try {
                this.BuscarUsuario();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPermisosUsusario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == this.fUsuarios.eliminarUsuariobtn) {
            try {
                this.EliminarUsuario();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPermisosUsusario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == this.fUsuarios.AgregarUsuariobtn) {
            try {
                this.agregarUsuario();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPermisosUsusario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == this.fUsuarios.editarUsuariobtn) {
            try {
                this.EditarUsuario();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPermisosUsusario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void agregarUsuario() throws SQLException {
        String OrdenAgregarUsuario = ("insert into usuarios(userID, contraseña,intentos,permiso_producto,permiso_cliente,permiso_proveedor,"
                + "permiso_factura,permiso_compra,permiso_kardex,permiso_provincias,permiso_ciudades,"
                + "permiso_lista_venta,permiso_lista_compra,permiso_gestor_usuario,bloqueo) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
        conUsuarios = msUsuarios.iniciarConexion();
        try {
            PreparedStatement psUsuarios = conUsuarios.prepareStatement(OrdenAgregarUsuario);
            psUsuarios.setString(1, this.fUsuarios.nombreUsuariotxt.getText());
            psUsuarios.setString(2, this.fUsuarios.contraseñaUsuariotxt.getText());
            psUsuarios.setInt(3, 0);
            psUsuarios.setInt(4, this.interpreteBox(this.fUsuarios.boxProductos));
            psUsuarios.setInt(5, this.interpreteBox(this.fUsuarios.boxCliente));
            psUsuarios.setInt(6, this.interpreteBox(this.fUsuarios.boxProveedores));
            psUsuarios.setInt(7, this.interpreteBox(this.fUsuarios.boxFactura));
            psUsuarios.setInt(8, this.interpreteBox(this.fUsuarios.boxCompra));
            psUsuarios.setInt(9, this.interpreteBox(this.fUsuarios.boxKardex));
            psUsuarios.setInt(10, this.interpreteBox(this.fUsuarios.boxProvincia));
            psUsuarios.setInt(11, this.interpreteBox(this.fUsuarios.boxCiudad));
            psUsuarios.setInt(12, this.interpreteBox(this.fUsuarios.boxCompras));
            psUsuarios.setInt(13, this.interpreteBox(this.fUsuarios.boxFacturas));
            psUsuarios.setInt(14, this.interpreteBox(this.fUsuarios.boxUsuarios));
            psUsuarios.setInt(15, 0);
            if (this.fUsuarios.nombreUsuariotxt.getText().isEmpty() || this.fUsuarios.contraseñaUsuariotxt.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No deje los campos en blanco");
            } else {
                if (psUsuarios.executeUpdate() > 0) {
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha podido agregar al usuario");
                }
            }
            psUsuarios.close();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
        msUsuarios.finalizarConexion(conUsuarios);
        this.cargarUsuarios();
        this.limpiarSeleccion();
    }

    public void EliminarUsuario() throws SQLException {
        String OrdenEliminarUsuario = ("delete from usuarios where userID=?;");
        conUsuarios = msUsuarios.iniciarConexion();
        try {
            PreparedStatement psUsuarios = conUsuarios.prepareStatement(OrdenEliminarUsuario);
            for (int i = 0; i < this.fUsuarios.TablaUsuarios.getSelectedRows().length; i++) {
                psUsuarios.setString(1, (String) this.fUsuarios.TablaUsuarios.getValueAt(this.fUsuarios.TablaUsuarios.getSelectedRows()[i], 0));
                psUsuarios.executeUpdate();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el usuario");
        }
        this.cargarUsuarios();
    }

    public void BuscarUsuario() throws SQLException {
        String OrdenBuscarUsuario = ("select * from usuarios where userID=?;");
        conUsuarios = msUsuarios.iniciarConexion();
        DefaultTableModel model = (DefaultTableModel) this.fUsuarios.TablaUsuarios.getModel();
        try {
            PreparedStatement psUsuarios = conUsuarios.prepareStatement(OrdenBuscarUsuario);
            psUsuarios.setString(1, this.fUsuarios.buscadorUsuariotxt.getText());
            ResultSet rsUsuarios = psUsuarios.executeQuery();
            if (rsUsuarios.next()) {
                modeloUsuario moUsuario = new modeloUsuario();
                moUsuario.setUserID(rsUsuarios.getString("userID"));
                moUsuario.setContraseña(rsUsuarios.getString("contraseña"));
                moUsuario.setIntentos(rsUsuarios.getInt("intentos"));
                moUsuario.setPermiso_producto(rsUsuarios.getInt("permiso_producto"));
                moUsuario.setPermiso_cliente(rsUsuarios.getInt("permiso_cliente"));
                moUsuario.setPermiso_proveedor(rsUsuarios.getInt("permiso_proveedor"));
                moUsuario.setPermiso_factura(rsUsuarios.getInt("permiso_factura"));
                moUsuario.setPermiso_compra(rsUsuarios.getInt("permiso_compra"));
                moUsuario.setPermiso_kardex(rsUsuarios.getInt("permiso_kardex"));
                moUsuario.setPermiso_provincias(rsUsuarios.getInt("permiso_provincias"));
                moUsuario.setPermiso_ciudades(rsUsuarios.getInt("permiso_ciudades"));
                moUsuario.setPermiso_lista_venta(rsUsuarios.getInt("permiso_lista_venta"));
                moUsuario.setPermiso_lista_compra(rsUsuarios.getInt("permiso_lista_compra"));
                moUsuario.setPermiso_gestor_usuario(rsUsuarios.getInt("permiso_gestor_usuario"));
                moUsuario.setBloqueo(rsUsuarios.getInt("bloqueo"));
                model.getDataVector().removeAllElements();
                this.fUsuarios.TablaUsuarios.updateUI();
                model.addRow(new Object[]{moUsuario.getUserID(), moUsuario.getContraseña(), this.interpreteBox2(moUsuario.getPermiso_producto()), this.interpreteBox2(moUsuario.getPermiso_cliente()),
                    this.interpreteBox2(moUsuario.getPermiso_proveedor()), this.interpreteBox2(moUsuario.getPermiso_factura()), this.interpreteBox2(moUsuario.getPermiso_compra()), this.interpreteBox2(moUsuario.getPermiso_kardex()), this.interpreteBox2(moUsuario.getPermiso_provincias()), this.interpreteBox2(moUsuario.getPermiso_ciudades()),
                    this.interpreteBox2(moUsuario.getPermiso_lista_venta()), this.interpreteBox2(moUsuario.getPermiso_lista_compra()), this.interpreteBox2(moUsuario.getPermiso_gestor_usuario()), this.interpreteBox2(moUsuario.getBloqueo())});
            } else {
                JOptionPane.showMessageDialog(null, "El usuario buscado no existe");
            }
            rsUsuarios.close();
            psUsuarios.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        msUsuarios.finalizarConexion(conUsuarios);
    }

    public void EditarUsuario() throws SQLException {
        String OrdenModificarUsuario = ("update usuarios set userID=?, contraseña=?,intentos=?,permiso_producto=?,permiso_cliente=?,permiso_proveedor=?,"
                + "permiso_factura=?,permiso_compra=?,permiso_kardex=?,permiso_provincias=?,permiso_ciudades=?,"
                + "permiso_lista_venta=?,permiso_lista_compra=?,permiso_gestor_usuario=?,bloqueo=? where userID=?;");
        conUsuarios = msUsuarios.iniciarConexion();
        try {
            PreparedStatement psUsuarios = conUsuarios.prepareStatement(OrdenModificarUsuario);
            psUsuarios.setString(1, this.fUsuarios.nombreUsuariotxt.getText());
            psUsuarios.setString(2, this.fUsuarios.contraseñaUsuariotxt.getText());
            psUsuarios.setInt(3, 0);
            psUsuarios.setInt(4, this.interpreteBox(this.fUsuarios.boxProductos));
            psUsuarios.setInt(5, this.interpreteBox(this.fUsuarios.boxCliente));
            psUsuarios.setInt(6, this.interpreteBox(this.fUsuarios.boxProveedores));
            psUsuarios.setInt(7, this.interpreteBox(this.fUsuarios.boxFactura));
            psUsuarios.setInt(8, this.interpreteBox(this.fUsuarios.boxCompra));
            psUsuarios.setInt(9, this.interpreteBox(this.fUsuarios.boxKardex));
            psUsuarios.setInt(10, this.interpreteBox(this.fUsuarios.boxProvincia));
            psUsuarios.setInt(11, this.interpreteBox(this.fUsuarios.boxCiudad));
            psUsuarios.setInt(12, this.interpreteBox(this.fUsuarios.boxCompras));
            psUsuarios.setInt(13, this.interpreteBox(this.fUsuarios.boxFacturas));
            psUsuarios.setInt(14, this.interpreteBox(this.fUsuarios.boxUsuarios));
            psUsuarios.setInt(15, 0);
            psUsuarios.setString(16, this.fUsuarios.TablaUsuarios.getValueAt(this.fUsuarios.TablaUsuarios.getSelectedRow(), 0).toString());
            if (psUsuarios.executeUpdate() > 0) {
            } else {
                JOptionPane.showMessageDialog(null, "No se ha podido modificar el usuario");
            }
            psUsuarios.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
            msUsuarios.finalizarConexion(conUsuarios);
        }
        this.cargarUsuarios();
        this.limpiarSeleccion();
    }

    public int interpreteBox(JCheckBox entrada) {
        if (entrada.isSelected()) {
            return 1;
        } else {
            return 0;
        }
    }

    public String interpreteBox2(int a) {
        if (a == 1) {
            return "Si";
        } else {
            return "No";
        }
    }

    public LinkedList<modeloUsuario> ListarUsuarios() {
        LinkedList<modeloUsuario> ListaUsuarios = new LinkedList<>();
        String OrdenSeleccionarUsuarios = ("select * from usuarios");
        conUsuarios = msUsuarios.iniciarConexion();
        try {
            PreparedStatement psUsuarios = conUsuarios.prepareStatement(OrdenSeleccionarUsuarios);
            ResultSet rsUsuarios = psUsuarios.executeQuery();
            while (rsUsuarios.next()) {
                modeloUsuario moUsuario = new modeloUsuario();
                moUsuario.setUserID(rsUsuarios.getString("userID"));
                moUsuario.setContraseña(rsUsuarios.getString("contraseña"));
                moUsuario.setIntentos(rsUsuarios.getInt("intentos"));
                moUsuario.setPermiso_producto(rsUsuarios.getInt("permiso_producto"));
                moUsuario.setPermiso_cliente(rsUsuarios.getInt("permiso_cliente"));
                moUsuario.setPermiso_proveedor(rsUsuarios.getInt("permiso_proveedor"));
                moUsuario.setPermiso_factura(rsUsuarios.getInt("permiso_factura"));
                moUsuario.setPermiso_compra(rsUsuarios.getInt("permiso_compra"));
                moUsuario.setPermiso_kardex(rsUsuarios.getInt("permiso_kardex"));
                moUsuario.setPermiso_provincias(rsUsuarios.getInt("permiso_provincias"));
                moUsuario.setPermiso_ciudades(rsUsuarios.getInt("permiso_ciudades"));
                moUsuario.setPermiso_lista_venta(rsUsuarios.getInt("permiso_lista_venta"));
                moUsuario.setPermiso_lista_compra(rsUsuarios.getInt("permiso_lista_compra"));
                moUsuario.setPermiso_gestor_usuario(rsUsuarios.getInt("permiso_gestor_usuario"));
                moUsuario.setBloqueo(rsUsuarios.getInt("bloqueo"));
                ListaUsuarios.add(moUsuario);
            }
            rsUsuarios.close();
            psUsuarios.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar los usuarios" + e);
        }
        msUsuarios.finalizarConexion(conUsuarios);
        return ListaUsuarios;
    }

    public void cargarUsuarios() {
        DefaultTableModel model = (DefaultTableModel) this.fUsuarios.TablaUsuarios.getModel();
        try {
            model.getDataVector().removeAllElements();
            this.fUsuarios.TablaUsuarios.updateUI();
            ListarUsuarios().forEach((lista) -> model.addRow(new Object[]{lista.getUserID(), lista.getContraseña(), this.interpreteBox2(lista.getPermiso_producto()), this.interpreteBox2(lista.getPermiso_cliente()),
                this.interpreteBox2(lista.getPermiso_proveedor()), this.interpreteBox2(lista.getPermiso_factura()), this.interpreteBox2(lista.getPermiso_compra()), this.interpreteBox2(lista.getPermiso_kardex()), this.interpreteBox2(lista.getPermiso_provincias()), this.interpreteBox2(lista.getPermiso_ciudades()),
                this.interpreteBox2(lista.getPermiso_lista_venta()), this.interpreteBox2(lista.getPermiso_lista_compra()), this.interpreteBox2(lista.getPermiso_gestor_usuario()), this.interpreteBox2(lista.getBloqueo())}));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar los usuarios" + e);
        }

    }

    public void limpiarSeleccion() {
        this.fUsuarios.boxCiudad.setSelected(false);
        this.fUsuarios.boxCliente.setSelected(false);
        this.fUsuarios.boxCompra.setSelected(false);
        this.fUsuarios.boxCompras.setSelected(false);
        this.fUsuarios.boxFactura.setSelected(false);
        this.fUsuarios.boxFacturas.setSelected(false);
        this.fUsuarios.boxKardex.setSelected(false);
        this.fUsuarios.boxProductos.setSelected(false);
        this.fUsuarios.boxProveedores.setSelected(false);
        this.fUsuarios.boxProvincia.setSelected(false);
        this.fUsuarios.boxUsuarios.setSelected(false);
    }
    
}
