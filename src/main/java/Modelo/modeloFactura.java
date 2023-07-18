/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author JONATHAN
 */
public class modeloFactura {

    private String codigoProducto, nombreProducto;
    private double precio, total, dineroEmpresa;
    private int cantidad;

    public modeloFactura() {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.total = total;
        this.dineroEmpresa = dineroEmpresa;
        this.cantidad = cantidad;
    }

    public String getCodigoProducto() {
        return this.codigoProducto;
    }

    public String getNombreProducto() {
        return this.nombreProducto;
    }

    public double getPrecio() {
        return this.precio;
    }

    public double getTotal() {
        return this.total;
    }

    public double getDineroEmpresa() {
        return this.dineroEmpresa;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setDineroEmpresa(double dineroEmpresa) {
        this.dineroEmpresa = dineroEmpresa;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
