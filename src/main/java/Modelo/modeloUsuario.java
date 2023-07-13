/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author pc
 */
public class modeloUsuario {

    private String userID;
    private String contraseña;
    private int intentos, permiso_producto, permiso_cliente, permiso_proveedor,
            permiso_factura, permiso_compra, permiso_kardex, permiso_provincias, permiso_ciudades,
            permiso_lista_venta, permiso_lista_compra, permiso_gestor_usuario,bloqueo;

    public modeloUsuario(String userID, String contraseña, int intentos, int permiso_producto, int permiso_cliente, int permiso_proveedor, int permiso_factura, int permiso_compra, int permiso_kardex, int permiso_provincias, int permiso_ciudades, int permiso_lista_venta, int permiso_lista_compra, int permiso_gestor_usuario, int bloqueo) {
        this.userID = userID;
        this.contraseña = contraseña;
        this.intentos = intentos;
        this.permiso_producto = permiso_producto;
        this.permiso_cliente = permiso_cliente;
        this.permiso_proveedor = permiso_proveedor;
        this.permiso_factura = permiso_factura;
        this.permiso_compra = permiso_compra;
        this.permiso_kardex = permiso_kardex;
        this.permiso_provincias = permiso_provincias;
        this.permiso_ciudades = permiso_ciudades;
        this.permiso_lista_venta = permiso_lista_venta;
        this.permiso_lista_compra = permiso_lista_compra;
        this.permiso_gestor_usuario = permiso_gestor_usuario;
        this.bloqueo = bloqueo;
    }


   
    public modeloUsuario() {
        this.userID = userID;
        this.contraseña = contraseña;
        this.intentos = intentos;
        this.permiso_producto = permiso_producto;
        this.permiso_cliente = permiso_cliente;
        this.permiso_proveedor = permiso_proveedor;
        this.permiso_factura = permiso_factura;
        this.permiso_compra = permiso_compra;
        this.permiso_kardex = permiso_kardex;
        this.permiso_provincias = permiso_provincias;
        this.permiso_ciudades = permiso_ciudades;
        this.permiso_lista_venta = permiso_lista_venta;
        this.permiso_lista_compra = permiso_lista_compra;
        this.permiso_gestor_usuario = permiso_gestor_usuario;
        this.bloqueo = bloqueo;
    }
    
    

    public String getUserID() {
        return this.userID;
    }

    public String getContraseña() {
        return this.contraseña;
    }

    public int getIntentos() {
        return this.intentos;
    }

    public int getPermiso_producto() {
        return this.permiso_producto;
    }

    public int getPermiso_cliente() {
        return this.permiso_cliente;
    }

    public int getPermiso_proveedor() {
        return this.permiso_proveedor;
    }

    public int getPermiso_factura() {
        return this.permiso_factura;
    }

    public int getPermiso_compra() {
        return this.permiso_compra;
    }

    public int getPermiso_kardex() {
        return this.permiso_kardex;
    }

    public int getPermiso_provincias() {
        return this.permiso_provincias;
    }

    public int getPermiso_ciudades() {
        return this.permiso_ciudades;
    }

    public int getPermiso_lista_venta() {
        return this.permiso_lista_venta;
    }

    public int getPermiso_lista_compra() {
        return this.permiso_lista_compra;
    }

    public int getPermiso_gestor_usuario() {
        return this.permiso_gestor_usuario;
    }

    public int getBloqueo() {
        return this.bloqueo;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public void setPermiso_producto(int permiso_producto) {
        this.permiso_producto = permiso_producto;
    }

    public void setPermiso_cliente(int permiso_cliente) {
        this.permiso_cliente = permiso_cliente;
    }

    public void setPermiso_proveedor(int permiso_proveedor) {
        this.permiso_proveedor = permiso_proveedor;
    }

    public void setPermiso_factura(int permiso_factura) {
        this.permiso_factura = permiso_factura;
    }

    public void setPermiso_compra(int permiso_compra) {
        this.permiso_compra = permiso_compra;
    }

    public void setPermiso_kardex(int permiso_kardex) {
        this.permiso_kardex = permiso_kardex;
    }

    public void setPermiso_provincias(int permiso_provincias) {
        this.permiso_provincias = permiso_provincias;
    }

    public void setPermiso_ciudades(int permiso_ciudades) {
        this.permiso_ciudades = permiso_ciudades;
    }

    public void setPermiso_lista_venta(int permiso_lista_venta) {
        this.permiso_lista_venta = permiso_lista_venta;
    }

    public void setPermiso_lista_compra(int permiso_lista_compra) {
        this.permiso_lista_compra = permiso_lista_compra;
    }

    public void setPermiso_gestor_usuario(int permiso_gestor_usuario) {
        this.permiso_gestor_usuario = permiso_gestor_usuario;
    }

    public void setBloqueo(int bloqueo) {
        this.bloqueo = bloqueo;
    }
    

}
