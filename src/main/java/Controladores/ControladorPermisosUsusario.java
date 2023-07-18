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
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pc
 */
public class ControladorPermisosUsusario implements ActionListener{
    private modeloUsuario mUsuario;
    private FrameUsuarios fUsuarios;
    private MySql msUsuarios= new MySql();
    private Connection conUsuarios;

    public ControladorPermisosUsusario(modeloUsuario mUsuario, FrameUsuarios frameUsuarios) {
        this.mUsuario = mUsuario;
        this.fUsuarios = frameUsuarios;
        this.fUsuarios.eliminarUsuariobtn.addActionListener(this);
        this.fUsuarios.AgregarUsuariobtn.addActionListener(this);
        this.fUsuarios.editarUsuariobtn.addActionListener(this);
        this.fUsuarios.buscarUsuariobtn.addActionListener(this);
        this.fUsuarios.Actualizarbtn.addActionListener(this);
        
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
        if (e.getSource()==this.fUsuarios.Actualizarbtn) {
            
        }
        if (e.getSource()==this.fUsuarios.buscarUsuariobtn) {
            
        }
        if (e.getSource()==this.fUsuarios.eliminarUsuariobtn) {
            
        }
        if (e.getSource()==this.fUsuarios.AgregarUsuariobtn) {
            
        }
        if (e.getSource()==this.fUsuarios.editarUsuariobtn) {
            
        }
    }
    public void agregarUsuario() throws SQLException{
        String OrdenAgregarUsuario=("insert into usuarios(userID=?, contraseña=?,intentos=?,permiso_producto=?,permiso_cliente=?,permiso_proveedor=?,\n" +
"permiso_factura=?,permiso_compra=?,permiso_kardex=?,permiso_provincias=?,permiso_ciudades=?,\n" +
"permiso_lista_venta=?,permiso_lista_compra=?,permiso_gestor_usuario=?,bloqueo=? values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
        conUsuarios= msUsuarios.iniciarConexion();
        try {
            PreparedStatement psUsuarios = conUsuarios.prepareStatement(OrdenAgregarUsuario);
            psUsuarios.setString(1, this.fUsuarios.nombreUsuariotxt.getText());
            psUsuarios.setString(2, this.fUsuarios.contraseñaUsuariotxt.getText());
            psUsuarios.setInt(3,0);
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
            if (psUsuarios.executeUpdate()>0) {
            }
            else{
                JOptionPane.showMessageDialog(null, "No se ha podido agregar al usuario");
            }
            psUsuarios.close();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error "+e);
        }
        msUsuarios.finalizarConexion(conUsuarios);
        this.cargarUsuarios();
    }
    
    public void EliminarUsuario(){
    String OrdenEliminarUsuario=("delete from usuarios where userID=?;");
    conUsuarios= msUsuarios.iniciarConexion();
        try {
            PreparedStatement psUsuarios = conUsuarios.prepareStatement(OrdenEliminarUsuario);
            for (int i = 0; i < this.fUsuarios.TablaUsuarios.getSelectedRows().length; i++) {
                psUsuarios.setString(1, (String) this.fUsuarios.TablaUsuarios.getValueAt(this.fUsuarios.TablaUsuarios.getSelectedRows()[i],0));
                psUsuarios.executeUpdate();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el usuario");
        }
        this.cargarUsuarios();
    }
    
    public void BuscarUsuario(){
        String OrdenBuscarUsuario=("select * from usuarios where userID=?;");
        conUsuarios= msUsuarios.iniciarConexion();
        DefaultTableModel model = (DefaultTableModel)this.fUsuarios.TablaUsuarios.getModel();
        try {
            PreparedStatement psUsuarios = conUsuarios.prepareStatement(OrdenBuscarUsuario);
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
                model.addRow(new Object[]{moUsuario.getUserID(),moUsuario.getContraseña(),moUsuario.getIntentos(),this.interpreteBox2(moUsuario.getPermiso_producto()),this.interpreteBox2(moUsuario.getPermiso_cliente()),
                this.interpreteBox2(moUsuario.getPermiso_proveedor()),this.interpreteBox2(moUsuario.getPermiso_factura()),this.interpreteBox2(moUsuario.getPermiso_compra()),this.interpreteBox2(moUsuario.getPermiso_kardex()),this.interpreteBox2(moUsuario.getPermiso_provincias()),this.interpreteBox2(moUsuario.getPermiso_ciudades()),
                this.interpreteBox2(moUsuario.getPermiso_lista_venta()),this.interpreteBox2(moUsuario.getPermiso_lista_compra()),this.interpreteBox2(moUsuario.getPermiso_gestor_usuario()),this.interpreteBox2(moUsuario.getBloqueo())});
            }
            else{
            JOptionPane.showMessageDialog(null, "El usuario buscado no existe");
            }
            rsUsuarios.close();
            psUsuarios.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        msUsuarios.finalizarConexion(conUsuarios);
    }
    
    public void EditarUsuario(){
    
    
    }
    public int interpreteBox(JCheckBox entrada){
        if (entrada.isSelected()) {
            return 1;
        }
        else{
        return 0;
        }
    }
    
    public String interpreteBox2(int a){
        if (a==1) {
            return "Si";
        }
        else{
        return "No";
        }
    }
    
    public void cargarUsuarios(){
    
    }
}
