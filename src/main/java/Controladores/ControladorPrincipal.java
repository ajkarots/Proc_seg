/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Frames.*;
import Modelo.*;
import interfaces.Metvis;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author JONATHAN
 */
public class ControladorPrincipal implements ActionListener,Metvis{
    private Principal frmpri;
    private FrameProductos fProductos =  new FrameProductos();
    private modeloProductos mProductos = new modeloProductos();
    private ControladorProductos controladorProductos = new ControladorProductos(fProductos,mProductos);
    private FrameProvincias fProvincias = new FrameProvincias();
    private modeloProvincia mProvincia= new modeloProvincia();
    private ControladorProvincias cProvincia = new ControladorProvincias(fProvincias,mProvincia);
    private FrameProveedores fProveedores = new FrameProveedores();
    private modeloProveedor mProveedor= new modeloProveedor();
    private ControladorProveedores cProveedores = new ControladorProveedores(fProveedores, mProveedor);
    private FrameCiudades fCiudades = new FrameCiudades();
    private modeloCiudad mCiudad = new modeloCiudad();
    private ControladorCiudades cCiudades = new ControladorCiudades(mCiudad, fCiudades);   
    private FrameClientes fClientes = new FrameClientes();
    private modeloClientes mClientes = new modeloClientes();
    private ControladorClientes cClientes = new ControladorClientes(fClientes, mClientes);
    private FrameUsuarios fUsuario = new FrameUsuarios();
    private modeloUsuario mUsuario = new modeloUsuario();
    private ControladorPermisosUsusario cPermisosUsuario = new ControladorPermisosUsusario(mUsuario, fUsuario);
    private FrameFacturas fFacturas = new FrameFacturas();
    private modeloFactura mFactura = new modeloFactura();
    private ControladorFactura cFactura = new ControladorFactura(mFactura, fFacturas);
    private FrameCompra fCompra = new FrameCompra();
    private modeloCompra mCompra = new modeloCompra();
    private ControladorCompra cCompra = new ControladorCompra(fCompra, mCompra);


    public ControladorPrincipal(Principal frmpri) {
        this.frmpri = frmpri;        
        this.fProductos.agregarProductobtn.addActionListener(this);
        this.frmpri.BotonCiudad.addActionListener(this);
        this.frmpri.BotonClientes.addActionListener(this);
        this.frmpri.BotonCompra.addActionListener(this);
        this.frmpri.BotonComprasGeneradas.addActionListener(this);
        this.frmpri.BotonFactura.addActionListener(this);
        this.frmpri.BotonKardex.addActionListener(this);
        this.frmpri.BotonProductos.addActionListener(this);
        this.frmpri.BotonProveedor.addActionListener(this);
        this.frmpri.BotonProvincia.addActionListener(this);
        this.frmpri.BotonUsuarios.addActionListener(this);
        this.frmpri.BotonVentas.addActionListener(this);
        this.frmpri.BotonSalir.addActionListener(this);
        
        
        
    }
    
    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==frmpri.BotonProductos) {
            try {
               
                controladorProductos.CargarProveedoresCombobox();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            mostrarJpanel(fProductos);
        }
        if (e.getSource()==frmpri.BotonClientes) {
            try {
                
                cClientes.CargarProvinciasCombobox();
                
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            mostrarJpanel(fClientes);
        }
        if (e.getSource()==frmpri.BotonProveedor) {
            try {
                cProveedores.CargarCiudadesCombobox();
                cProveedores.CargarProvinciasCombobox();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            mostrarJpanel(fProveedores);
        }
        if (e.getSource()==frmpri.BotonFactura) {

               mostrarJpanel(fFacturas); 
            
            
        }
        if (e.getSource()==frmpri.BotonCompra) {
            try {
                cCompra.cargarBoxProductos();
            cCompra.CargarProveedoresCombobox();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            mostrarJpanel(fCompra);
        }
        if (e.getSource()==frmpri.BotonKardex) {
            mostrarJpanel(new FrameCompra());
        }
        if (e.getSource()==frmpri.BotonProvincia) {
            mostrarJpanel(fProvincias);
        }
        
        if (e.getSource()==frmpri.BotonCiudad) {
            try {
                cCiudades.cargarCombobox();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            mostrarJpanel(fCiudades);
        }
        if (e.getSource()==frmpri.BotonVentas) {
            mostrarJpanel(new FrameListaFacturas());
        }
        if (e.getSource()==frmpri.BotonComprasGeneradas) {
            mostrarJpanel(new FrameComprasGeneradas());
        }
        if (e.getSource()==frmpri.BotonUsuarios) {
            mostrarJpanel(fUsuario);
        }
        if (e.getSource()==frmpri.BotonSalir) {
            this.frmpri.dispose();   
        }
    }

    public void setmUsuario(modeloUsuario mUsuario) {
        this.mUsuario = mUsuario;
    }

    public modeloUsuario getmUsuario() {
        return mUsuario;
    }

    @Override
    public void iniciarcontenido() {
        mostrarJpanel(new FrameProductos());
    }

    @Override
    public void mostrarJpanel(JPanel a) {
        a.setSize(855, 550);
        a.setLocation(0,0);
        this.frmpri.Contenido.removeAll();
        this.frmpri.Contenido.add(a,BorderLayout.CENTER);
        this.frmpri.Contenido.revalidate();
        this.frmpri.Contenido.repaint();
    }
    public void visibleframe(){
           this.frmpri.setVisible(true); 
        }
        
    
    }
