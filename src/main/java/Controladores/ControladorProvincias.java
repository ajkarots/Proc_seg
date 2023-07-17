/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Clases.MySql;
import Frames.FrameProvincias;
import Modelo.modeloProvincia;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pc
 */
public class ControladorProvincias implements ActionListener {

    private modeloProvincia mProvincias;
    private FrameProvincias fProvincia;
    private MySql msProvincias = new MySql();
    Connection conProvincias;

    public ControladorProvincias(FrameProvincias fProvincia, modeloProvincia mProvincias) {
        this.mProvincias = mProvincias;
        this.fProvincia = fProvincia;
        this.fProvincia.BuscarProvincia.addActionListener(this);
        this.fProvincia.agregarProvincia.addActionListener(this);
        this.fProvincia.editarProvincia.addActionListener(this);
        this.fProvincia.eliminarProvincia.addActionListener(this);
        this.cargarProvincias();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.fProvincia.BuscarProvincia) {

        }
        if (e.getSource() == this.fProvincia.agregarProvincia) {
            try {
                this.agregarProvincia();

            } catch (SQLException ex) {
                Logger.getLogger(ControladorProvincias.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == this.fProvincia.editarProvincia) {
            try {
                this.modificarProvincia();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorProvincias.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == this.fProvincia.eliminarProvincia) {
            try {
                this.eliminarProvincia();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorProvincias.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void modificarProvincia() throws SQLException {
        String ordenModificarProvincia = ("update provincias set codigoProvincia =?, NombreProvincia=? where codigoProvincia=?;");
        conProvincias = msProvincias.iniciarConexion();
        DefaultTableModel model = (DefaultTableModel) fProvincia.tablaProvincias.getModel();
        PreparedStatement psProvincia = conProvincias.prepareStatement(ordenModificarProvincia);
        try {
            if (this.fProvincia.nombreProvinciatxt.getText().isEmpty() ||this.fProvincia.CodigoProvinciatxt.getText().isEmpty() ) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar e Ingresar nuevos valores en los campos");
            }else{
                System.out.println(this.fProvincia.tablaProvincias.getValueAt(this.fProvincia.tablaProvincias.getSelectedRow(), 0));
                psProvincia.setString(1, this.fProvincia.CodigoProvinciatxt.getText());
                psProvincia.setString(2, this.fProvincia.nombreProvinciatxt.getText());
                psProvincia.setString(3, (String) this.fProvincia.tablaProvincias.getValueAt(this.fProvincia.tablaProvincias.getSelectedRow(), 0));
                if (psProvincia.executeUpdate()>0) {
                    
                }
                else{
                JOptionPane.showMessageDialog(null, "Error al modificar");
                }
            }
            
        } catch (Exception e) {
            System.out.println("Error del servidor"+e);
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

    public LinkedList<modeloProvincia> ListarProvincias() {
        LinkedList<modeloProvincia> listaProvincias = new LinkedList<>();
        try {
            conProvincias = msProvincias.iniciarConexion();
            PreparedStatement psProvincias = conProvincias.prepareStatement("select * from provincias;");
            ResultSet rsProvincias = psProvincias.executeQuery();
            while (rsProvincias.next()) {

                modeloProvincia moProvincia = new modeloProvincia();
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
