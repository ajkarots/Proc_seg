/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Clases.MySql;
import java.sql.Connection;

/**
 *
 * @author pc
 */
public class modeloCompra {

    private int codigoCompra,cantidad;
    private String codigoProveedor, codigoProducto;
    private double precioCompra,total;

    public modeloCompra() {
        this.codigoCompra = codigoCompra;
        this.codigoProveedor = codigoProveedor;
        this.codigoProducto = codigoProducto;
        this.precioCompra = precioCompra;
        this.cantidad = cantidad;
        this.total= total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotal() {
        return this.total;
    }

    public int getCodigoCompra() {
        return this.codigoCompra;
    }

    public String getCodigoProveedor() {
        return this.codigoProveedor;
    }

    public String getCodigoProducto() {
        return this.codigoProducto;
    }

    public double getPrecioCompra() {
        return this.precioCompra;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCodigoCompra(int codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public void setCodigoProveedor(String codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
