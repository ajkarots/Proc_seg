/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Clases.MySql;
import Frames.FrameCiudades;
import Modelo.modeloCiudad;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
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
        this.cargarCiudades();
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
            this.cargarCiudades();
            try {
                this.cargarCombobox();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorCiudades.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource()==fCiudad.AgregarCiudad) {
            try {
                this.agregarCiudad();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorCiudades.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource()==fCiudad.Buscarciudad) {
            try {
                this.buscaCiudad();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorCiudades.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource()==fCiudad.EditarCiudad) {
            try {
                this.modificarCiudad();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorCiudades.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource()==fCiudad.EliminarCiudad) {
            try {
                this.eliminarCiudad();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorCiudades.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
        public void buscaCiudad() throws SQLException {
        String OrdenBuscarCiudad = ("select * from ciudades where codigoCiudad =?;");
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

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println("Ingrese unicamente hasta 4 digitos entre numeros y letras" + e);
        }

        
    }

    public void modificarCiudad() throws SQLException {
        String OrdenModificarCiudad = ("update Ciudades set codigoCiudad =?, NombreCiudad=?, codigoProvincia=? where codigoCiudad=?;");
        conCiudad = msCiudades.iniciarConexion();
        DefaultTableModel model = (DefaultTableModel) fCiudad.tablaCiudades.getModel();
        PreparedStatement psCiudad = conCiudad.prepareStatement(OrdenModificarCiudad);
        try {
            if (this.fCiudad.Nombreciudadtxt.getText().isEmpty() || this.fCiudad.CodigoCiudadtxt.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar e Ingresar nuevos valores en los campos");
            } else {
                psCiudad.setString(1, this.fCiudad.CodigoCiudadtxt.getText());
                psCiudad.setString(2, this.fCiudad.Nombreciudadtxt.getText());
                psCiudad.setString(3, (String) this.fCiudad.CodigoProvinciaBox.getSelectedItem());
                psCiudad.setString(4, this.fCiudad.tablaCiudades.getValueAt(this.fCiudad.tablaCiudades.getSelectedRow(), 0).toString());
                if (psCiudad.executeUpdate() > 0) {

                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar");
                }
            }

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar debe seleccionar un item para modificar");
            System.out.println("Error del servidor" + e);
        }
        this.cargarCiudades();
    }

    public void eliminarCiudad() throws SQLException {
        
        String OrdenEliminarCiudad = ("delete from ciudades where codigoCiudad =?;");
        conCiudad = msCiudades.iniciarConexion();
        DefaultTableModel model = (DefaultTableModel) fCiudad.tablaCiudades.getModel();

        PreparedStatement psCiudades = conCiudad.prepareStatement(OrdenEliminarCiudad);
        try {
            if (this.fCiudad.tablaCiudades.getSelectedRows().length == 0) {
                JOptionPane.showMessageDialog(null, "Seleccione alemnos una ciudad", "Error", WARNING_MESSAGE);
            } else {
                for (int i = 0; i < this.fCiudad.tablaCiudades.getSelectedRows().length; i++) {
                    psCiudades.setString(1, (String) this.fCiudad.tablaCiudades.getValueAt(this.fCiudad.tablaCiudades.getSelectedRows()[i], 0));
                    psCiudades.executeUpdate();
                }
            }

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo Eliminar", "Atencion", CANCEL_OPTION);
        }
        psCiudades.close();
        msCiudades.finalizarConexion(conCiudad);
        this.cargarCiudades();
    }

    public void agregarCiudad() throws SQLException {
        String OrdenAgregarCiudad = ("insert into ciudades(codigoCiudad,NombreCiudad,codigoProvincia) values(?,?,?);");
        conCiudad = msCiudades.iniciarConexion();

        try {
            PreparedStatement psCiudad = conCiudad.prepareStatement(OrdenAgregarCiudad);
            psCiudad.setString(1, this.fCiudad.CodigoCiudadtxt.getText());
            psCiudad.setString(2, this.fCiudad.Nombreciudadtxt.getText());
            psCiudad.setString(3, this.fCiudad.CodigoProvinciaBox.getSelectedItem().toString());
            if (this.fCiudad.CodigoCiudadtxt.getText().isEmpty() || this.fCiudad.CodigoCiudadtxt.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No puede dejar los campos en blanco", "Error", WARNING_MESSAGE);
            } else {
                psCiudad.executeUpdate();
            }
            msCiudades.finalizarConexion(conCiudad);
            psCiudad.close();
        } catch (HeadlessException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "No se a podido agregar la ciudad" + e);
        }
        this.cargarCiudades();
    }

    public LinkedList<modeloCiudad> ListarCiudades() {
        LinkedList<modeloCiudad> listaCiudad = new LinkedList<>();
        try {
            conCiudad = msCiudades.iniciarConexion();
            PreparedStatement psCiudades = conCiudad.prepareStatement("select * from ciudades;");
            ResultSet rsProvincias = psCiudades.executeQuery();
            while (rsProvincias.next()) {

                modeloCiudad moCiudad = new modeloCiudad();
                moCiudad.setCodigoCiudad(rsProvincias.getString("codigoCiudad"));
                moCiudad.setNombreCiudad(rsProvincias.getString("NombreCiudad"));
                moCiudad.setCodigoProvincia(rsProvincias.getString("codigoProvincia"));
                listaCiudad.add(moCiudad);
            }
            psCiudades.close();
            rsProvincias.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha podido listar las provincias", "Error", WARNING_MESSAGE);
        }
        msCiudades.finalizarConexion(conCiudad);
        return listaCiudad;
    }

    public void cargarCiudades() {
        try {

            DefaultTableModel model = (DefaultTableModel) fCiudad.tablaCiudades.getModel();
            model.getDataVector().removeAllElements();
            fCiudad.tablaCiudades.updateUI();
            ListarCiudades().forEach((lista) -> model.addRow(new Object[]{lista.getCodigoCiudad(), lista.getNombreCiudad(),lista.getCodigoProvincia()}));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al cargar las ciudad");
        }
    }
    
        public LinkedList<String> ListarProvincias() throws SQLException{
    LinkedList<String> ListaCiudades = new LinkedList<>();
    conCiudad = msCiudades.iniciarConexion();
    PreparedStatement psCiudades = conCiudad.prepareStatement("select codigoProvincia from provincias;");
        try {
        ResultSet rsProveedores = psCiudades.executeQuery();
            while (rsProveedores.next()) {
              ListaCiudades.add(rsProveedores.getString("codigoProvincia"));
              
            }
            rsProveedores.close();
            msCiudades.finalizarConexion(conCiudad);
        } catch (SQLException e) {
            
        }
 
    return ListaCiudades;
    }
            public void cargarCombobox() throws SQLException{
                DefaultComboBoxModel model = (DefaultComboBoxModel) fCiudad.CodigoProvinciaBox.getModel();
                model.removeAllElements();
                
                ListarProvincias().forEach((lista)->model.addElement(lista));}
  
        
}
