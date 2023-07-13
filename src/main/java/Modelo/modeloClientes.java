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
    private int cedula;
    private String nombres,direccion,codigoProvincia,codigoCiudad;

    public modeloClientes(int cedula, String nombres, String direccion, String codigoProvincia, String codigoCiudad) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.direccion = direccion;
        this.codigoProvincia = codigoProvincia;
        this.codigoCiudad = codigoCiudad;
    }

    public modeloClientes() {
    }

    public int getCedula() {
        return this.cedula;
    }

    public String getNombres() {
        return this.nombres;
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

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
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
