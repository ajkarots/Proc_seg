/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author JONATHAN
 */
public class modeloClientes {
    
    private String nombre,direccion,codigoProvincia,codigoCiudad,cedula;

    public modeloClientes(String cedula, String nombres, String direccion, String codigoProvincia, String codigoCiudad) {
        this.cedula = cedula;
        this.nombre = nombres;
        this.direccion = direccion;
        this.codigoProvincia = codigoProvincia;
        this.codigoCiudad = codigoCiudad;
    }

    public modeloClientes() {
    }

    public String getCedula() {
        return this.cedula;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public String getCodigoProvincia() {
        return this.codigoProvincia;
    }

    public String getCodigoCiudad() {
        return this.codigoCiudad;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCodigoProvincia(String codigoProvincia) {
        this.codigoProvincia = codigoProvincia;
    }

    public void setCodigoCiudad(String codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }
    
}
