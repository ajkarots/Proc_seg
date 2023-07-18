/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Clases.MySql;
import Frames.FrameCiudades;
import Modelo.modeloCiudad;
import Modelo.modeloCiudades;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.CANCEL_OPTION;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JONATHAN
 */
public class ControladorCiudades implements ActionListener{
    private modeloCiudad mCiudad;
    private FrameCiudades fCiudad;
    private MySql msCiudades = new MySql();
    private Connection conCiudad;

    public ControladorCiudades(modeloCiudad mCiudad, FrameCiudades fCiudad) {
        this.mCiudad = mCiudad;
        this.fCiudad = fCiudad;
        this.fCiudad.AgregarCiudad.addActionListener(this);
        this.fCiudad.EliminarCiudad.addActionListener(this);
        this.fCiudad.EditarCiudad.addActionListener(this);
        this.fCiudad.Buscarciudad.addActionListener(this);
        this.fCiudad.Actualizarbtn.addActionListener(this);
    }

    public modeloCiudad getmCiudad() {
        return this.mCiudad;
    }

    public FrameCiudades getfCiudad() {
        return this.fCiudad;
    }

    public void setmCiudad(modeloCiudad mCiudad) {
        this.mCiudad = mCiudad;
    }

    public void setfCiudad(FrameCiudades fCiudad) {
        this.fCiudad = fCiudad;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==fCiudad.Actualizarbtn) {
            
        }
        if (e.getSource()==fCiudad.AgregarCiudad) {
            
        }
        if (e.getSource()==fCiudad.BuscarCiudadtxt) {
            
        }
        if (e.getSource()==fCiudad.EditarCiudad) {
            
        }
        if (e.getSource()==fCiudad.EliminarCiudad) {
            
        }
    }
    
        public void buscaCiudad() throws SQLException {
        String OrdenBuscarCiudad = ("select * from provincias where codigoProvincia =?;");
        conCiudad = msCiudades.iniciarConexion();
        DefaultTableModel model = (DefaultTableModel) fCiudad.tablaCiudades.getModel();
        PreparedStatement psCiudades = conCiudad.prepareStatement(OrdenBuscarCiudad);

        try {
            if (this.fCiudad.BuscarCiudadtxt.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor en el cuadro de busqueda");
            } else {
                psCiudades.setString(1, this.fCiudad.BuscarCiudadtxt.getText());
                ResultSet rsCiudades = psCiudades.executeQuery();
                if (rsCiudades.next()) {
                    modeloCiudad moCiudades = new modeloCiudad();
                    moCiudades.setCodigoCiudad(rsCiudades.getString("codigoCiudad"));
                    moCiudades.setNombreCiudad(rsCiudades.getString("nombreCiudad"));
                    moCiudades.setCodigoProvincia(rsCiudades.getString("codigoProvincia"));
                    model.getDataVector().removeAllElements();
                    this.fCiudad.tablaCiudades.updateUI();
                    model.addRow(new Object[]{moCiudades.getCodigoCiudad(),moCiudades.getNombreCiudad(),moCiudades.getCodigoProvincia()});
                } else {
                    JOptionPane.showMessageDialog(null, "No existe la ciudad buscada");
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println("Ingrese unicamente hasta 4 digitos entre numeros y letras" + e);
        }

        
    }

    public void modificarCiudad() throws SQLException {
        String OrdenModificarCiudad = ("update provincias set codigoProvincia =?, NombreProvincia=? where codigoProvincia=?;");
        conCiudad = msCiudades.iniciarConexion();
        DefaultTableModel model = (DefaultTableModel) fCiudad.tablaCiudades.getModel();
        PreparedStatement psCiudad = conCiudad.prepareStatement(OrdenModificarCiudad);
        try {
            if (this.fCiudad.Nombreciudadtxt.getText().isEmpty() || this.fCiudad.CodigoCiudadtxt.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar e Ingresar nuevos valores en los campos");
            } else {
                psCiudad.setString(1, this.fCiudad.CodigoCiudadtxt.getText());
                psCiudad.setString(2, this.fCiudad.Nombreciudadtxt.getText());
                psCiudad.setString(3, (String) this.fCiudad.tablaProvincias.getValueAt(this.fProvincia.tablaProvincias.getSelectedRow(), 0));
                if (psProvincia.executeUpdate() > 0) {

                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar");
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar debe seleccionar un item para modificar");
            System.out.println("Error del servidor" + e);
        }
        this.cargarProvincias();
    }

    public void eliminarProvincia() throws SQLException {
        this.fProvincia.tablaProvincias.getSelectedRows();
        String ordenEliminarProvincia = ("delete from provincias where codigoProvincia =?;");
        conProvincias = msProvincias.iniciarConexion();
        DefaultTableModel model = (DefaultTableModel) fProvincia.tablaProvincias.getModel();

        PreparedStatement psProvincia = conProvincias.prepareStatement(ordenEliminarProvincia);
        try {
            if (this.fProvincia.tablaProvincias.getSelectedRows().length == 0) {
                JOptionPane.showMessageDialog(null, "Seleccione alemnos una provincia", "Error", WARNING_MESSAGE);
            } else {
                for (int i = 0; i < this.fProvincia.tablaProvincias.getSelectedRows().length; i++) {
                    System.out.println(this.fProvincia.tablaProvincias.getValueAt(this.fProvincia.tablaProvincias.getSelectedRows()[i], 0));
                    psProvincia.setString(1, (String) this.fProvincia.tablaProvincias.getValueAt(this.fProvincia.tablaProvincias.getSelectedRows()[i], 0));
                    psProvincia.executeUpdate();
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo Eliminar", "Atencion", CANCEL_OPTION);
        }
        psProvincia.close();
        msProvincias.finalizarConexion(conProvincias);
        this.cargarProvincias();
    }

    public void agregarProvincia() throws SQLException {
        String OrdenAgregarProvincia = ("insert into provincias(codigoProvincia,NombreProvincia) values(?,?);");
        conProvincias = msProvincias.iniciarConexion();

        try {
            PreparedStatement psProvincias = conProvincias.prepareStatement(OrdenAgregarProvincia);
            psProvincias.setInt(1, Integer.parseInt(this.fProvincia.CodigoProvinciatxt.getText()));
            psProvincias.setString(2, this.fProvincia.nombreProvinciatxt.getText());
            if (this.fProvincia.CodigoProvinciatxt.getText().isEmpty() || this.fProvincia.nombreProvinciatxt.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No puede dejar los campos en blanco", "Error", WARNING_MESSAGE);
            } else {
                psProvincias.executeUpdate();
            }
            msProvincias.finalizarConexion(conProvincias);
            psProvincias.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se a podido agregar la provincia" + e);
        }
        this.cargarProvincias();
    }

    public LinkedList<modeloCiudades> ListarProvincias() {
        LinkedList<modeloCiudades> listaProvincias = new LinkedList<>();
        try {
            conProvincias = msProvincias.iniciarConexion();
            PreparedStatement psProvincias = conProvincias.prepareStatement("select * from provincias;");
            ResultSet rsProvincias = psProvincias.executeQuery();
            while (rsProvincias.next()) {

                modeloCiudades moProvincia = new modeloCiudades();
                moProvincia.setCodigoProvincia(rsProvincias.getString("codigoProvincia"));
                moProvincia.setNombreProvincia(rsProvincias.getString("NombreProvincia"));
                listaProvincias.add(moProvincia);
            }
            psProvincias.close();
            rsProvincias.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha podido listar las provincias", "Error", WARNING_MESSAGE);
        }
        msProvincias.finalizarConexion(conProvincias);
        return listaProvincias;
    }

    public void cargarProvincias() {
        try {

            DefaultTableModel model = (DefaultTableModel) fProvincia.tablaProvincias.getModel();
            model.getDataVector().removeAllElements();
            fProvincia.tablaProvincias.updateUI();
            ListarProvincias().forEach((lista) -> model.addRow(new Object[]{lista.getCodigoProvincia(), lista.getNombreProvincia()}));
        } catch (Exception e) {

        }
    }

}
    
}
