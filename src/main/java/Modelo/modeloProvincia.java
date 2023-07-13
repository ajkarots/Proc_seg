/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author JONATHAN
 */
public class modeloProvincia {
    private String nombreProvincia,codigoProvincia;

    public modeloProvincia(String nombreProvincia, String codigoProvincia) {
        this.nombreProvincia = nombreProvincia;
        this.codigoProvincia = codigoProvincia;
    }

    public modeloProvincia() {
          this.nombreProvincia = nombreProvincia;
        this.codigoProvincia = codigoProvincia;
    }

    public String getNombreProvincia() {
        return this.nombreProvincia;
    }

    public String getCodigoProvincia() {
        return this.codigoProvincia;
    }

    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
    }

    public void setCodigoProvincia(String codigoProvincia) {
        this.codigoProvincia = codigoProvincia;
    }
    
}
