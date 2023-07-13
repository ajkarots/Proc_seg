/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author pc
 */
public class modeloProductos {
    private String codigoProducto,nombreProducto,codigoProveedor;

    public modeloProductos(String codigoProducto, String nombreProducto, String codigoProveedor) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.codigoProveedor = codigoProveedor;
    }

    public modeloProductos() {
              this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.codigoProveedor = codigoProveedor;
    }

    public String getCodigoProducto() {
        return this.codigoProducto;
    }

    public String getNombreProducto() {
        return this.nombreProducto;
    }

    public String getCodigoProveedor() {
        return this.codigoProveedor;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setCodigoProveedor(String codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }
    
    
}
