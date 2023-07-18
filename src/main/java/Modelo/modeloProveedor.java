/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author JONATHAN
 */
public class modeloProveedor {

    private int rucProveedor, telefonoProveedor;
    private String nombreProveedor, codigoProvincia, direccionProveedor, codigoCiudad, codigoProveedor;

    public modeloProveedor(int rucProveedor, int telefonoProveedor, String nombreProveedor, String codigoProvincia, String direccionProveedor, String codigoCiudad, String codigoProveedor) {
        this.rucProveedor = rucProveedor;
        this.telefonoProveedor = telefonoProveedor;
        this.nombreProveedor = nombreProveedor;
        this.codigoProvincia = codigoProvincia;
        this.direccionProveedor = direccionProveedor;
        this.codigoCiudad = codigoCiudad;
        this.codigoProveedor = codigoProveedor;
    }

    public modeloProveedor() {
        this.rucProveedor = rucProveedor;
        this.telefonoProveedor = telefonoProveedor;
        this.nombreProveedor = nombreProveedor;
        this.codigoProvincia = codigoProvincia;
        this.direccionProveedor = direccionProveedor;
        this.codigoCiudad = codigoCiudad;
        this.codigoProveedor = codigoProveedor;
    }

    public void setCodigoProveedor(String codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public String getCodigoProveedor() {
        return this.codigoProveedor;
    }

    public void setRucProveedor(int rucProveedor) {
        this.rucProveedor = rucProveedor;
    }

    public void setTelefonoProveedor(int telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public void setCodigoProvincia(String codigoProvincia) {
        this.codigoProvincia = codigoProvincia;
    }

    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }

    public void setCodigoCiudad(String codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }

    public int getRucProveedor() {
        return this.rucProveedor;
    }

    public int getTelefonoProveedor() {
        return this.telefonoProveedor;
    }

    public String getNombreProveedor() {
        return this.nombreProveedor;
    }

    public String getCodigoProvincia() {
        return this.codigoProvincia;
    }

    public String getDireccionProveedor() {
        return this.direccionProveedor;
    }

    public String getCodigoCiudad() {
        return this.codigoCiudad;
    }
    
   
}
