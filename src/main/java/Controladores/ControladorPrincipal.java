/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Frames.*;
import Frames.Principal;
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
            mostrarJpanel(new Productos());
        }
        if (e.getSource()==frmpri.BotonClientes) {
            mostrarJpanel(new Clientes());
        }
        if (e.getSource()==frmpri.BotonProveedor) {
            mostrarJpanel(new Proveedores());
        }
        if (e.getSource()==frmpri.BotonFactura) {
            String CodigoDeCliente;
            CodigoDeCliente = OptionPane.showInputDialog(null,"Ingrese su codigod de cliente");
            if (true) {
                
            }
            mostrarJpanel(new Facturas());
        }
        if (e.getSource()==frmpri.BotonCompra) {
            mostrarJpanel(new Compra());
        }
        
    }

    @Override
    public void iniciarcontenido() {
        mostrarJpanel(new Productos());
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
    
    
}
