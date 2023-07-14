/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Frames.*;
import Frames.Principal;
import Modelo.modeloProductos;
import interfaces.Metvis;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    public ControladorPrincipal(Principal frmpri) {
        this.frmpri = frmpri;
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
    }
    
    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==frmpri.BotonProductos) {
            mostrarJpanel(new FrameProductos());
            controladorProductos.actionPerformed(e);
            
        }
        if (e.getSource()==frmpri.BotonClientes) {
            mostrarJpanel(new FrameClientes());
        }
        if (e.getSource()==frmpri.BotonProveedor) {
            mostrarJpanel(new FrameProveedores());
        }
        if (e.getSource()==frmpri.BotonFactura) {
            String CodigoDeCliente;
            CodigoDeCliente = JOptionPane.showInputDialog(null,"Ingrese su codigo de cliente");
            if (true) {
               mostrarJpanel(new FrameFacturas()); 
            }
            
        }
        if (e.getSource()==frmpri.BotonCompra) {
            mostrarJpanel(new FrameCompra());
        }
        if (e.getSource()==frmpri.BotonKardex) {
            mostrarJpanel(new FrameCompra());
        }
        if (e.getSource()==frmpri.BotonProvincia) {
            mostrarJpanel(new FrameProvincias());
        }
        if (e.getSource()==frmpri.BotonCiudad) {
            mostrarJpanel(new FrameCiudades());
        }
        if (e.getSource()==frmpri.BotonVentas) {
            mostrarJpanel(new FrameListaFacturas());
        }
        if (e.getSource()==frmpri.BotonComprasGeneradas) {
            mostrarJpanel(new FrameComprasGeneradas());
        }
        if (e.getSource()==frmpri.BotonUsuarios) {
            mostrarJpanel(new FrameUsuarios());
        }
        
        
        
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
