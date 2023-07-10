/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Clases.MySql;
import Frames.Loggin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class ControladorLoggin implements ActionListener{
    private final Loggin lg;
    private MySql ms = new MySql()  ;

    public ControladorLoggin(Loggin lg) {
        this.lg = lg;
        this.lg.botonIngresar.addActionListener(this);
        this.lg.textoContraseña.addActionListener(this);
        this.lg.textoUsuario.addActionListener(this);
    }
    
    public void iniciar(){
    this.lg.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==lg.botonIngresar) {
            if (lg.textoUsuario.getText()==null || lg.textoContraseña.getText()==null) {
                JOptionPane.showMessageDialog(null,"Ingrese datos validos!\n Los campos no pueden estar vacios");
            }else{
            ms.conectarMysql();       
                if (ms.controlusuarios(lg.textoUsuario.getText(),lg.textoContraseña.getText())==2) {
                   this.lg.setVisible(false);
                }
            }
        }
    }
}
