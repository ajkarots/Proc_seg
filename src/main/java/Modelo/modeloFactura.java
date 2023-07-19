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

    private String codigoProducto,codigoCliente;
    private double precio, total;
    private int cantidad,codigoFactura;

    public modeloFactura() {
        this.codigoCliente =codigoCliente;
        this.codigoProducto = codigoProducto;
        this.precio = precio;
        this.total = total;
        this.cantidad = cantidad;
        this.codigoFactura = codigoFactura;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoFactura(int codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public int getCodigoFactura() {
        return codigoFactura;
    }

    public String getCodigoProducto() {
        return this.codigoProducto;
    }


    public double getPrecio() {
        return this.precio;
    }

    public double getTotal() {
        return this.total;
    }


    public int getCantidad() {
        return this.cantidad;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
