/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author JONATHAN
 */
public class modeloCiudad{
    private String codigoCiudad,nombreCiudad,codigoProvincia;
    
    public modeloCiudad(String codigoCiudad, String nombreCiudad, String codigoProvincia) {
        this.codigoProvincia = codigoProvincia;
        this.codigoCiudad = codigoCiudad;
        this.nombreCiudad = nombreCiudad;
    }

    public modeloCiudad() {
        this.codigoProvincia = codigoProvincia;
        this.codigoCiudad = codigoCiudad;
        this.nombreCiudad = nombreCiudad;
    }

    public void setCodigoCiudad(String codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public void setCodigoProvincia(String codigoProvincia) {
        this.codigoProvincia = codigoProvincia;
    }

    public String getCodigoCiudad() {
        return this.codigoCiudad;
    }

    public String getNombreCiudad() {
        return this.nombreCiudad;
    }

    public String getCodigoProvincia() {
        return this.codigoProvincia;
    }
    
}
