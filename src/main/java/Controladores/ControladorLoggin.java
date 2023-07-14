/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Clases.MySql;
import Frames.Loggin;
import Frames.Principal;
import Modelo.modeloUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class ControladorLoggin implements ActionListener{
    private final Loggin lg;
    private MySql ms = new MySql();
    private Principal frmpri = new Principal();
    private ControladorPrincipal cp = new ControladorPrincipal(frmpri);
    private modeloUsuario user = new modeloUsuario();
    private Controlusuario ctrlloggin;
    

    public ControladorLoggin(Loggin lg,Controlusuario ctrlloggin) {
        this.lg = lg;
        this.lg.botonIngresar.addActionListener(this);
        this.lg.textoContraseña.addActionListener(this);
        this.lg.textoUsuario.addActionListener(this);
        this.ctrlloggin = ctrlloggin;
    }
    
    public void iniciar(){
    this.lg.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==lg.botonIngresar) {
            if (!lg.textoUsuario.getText().isEmpty() || !lg.textoContraseña.getText().isEmpty()) {
                user.setUserID(lg.textoUsuario.getText());
                user.setContraseña(lg.textoContraseña.getText());
                if (ctrlloggin.controlusuarios(user)==2) {
                    JOptionPane.showMessageDialog(null,"Loggin correcto");
                    this.lg.dispose();
                    this.lg.setVisible(false);
                    this.cp.visibleframe();
                }
            } else{                  
                   JOptionPane.showMessageDialog(null,"Ingrese datos validos!\n Los campos no pueden estar vacios");
                }
        }
    }
    
}
