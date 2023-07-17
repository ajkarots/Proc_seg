/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proc_seg;

import Controladores.ControladorLoggin;
import Frames.Principal;
import Controladores.ControladorPrincipal;
import Controladores.ControladorUsuario;
import Frames.Loggin;
import com.formdev.flatlaf.intellijthemes.FlatVuesionIJTheme;

/**
 *
 * @author pc
 */
public class Proc_seg {

    public static void main(String[] args) {
        FlatVuesionIJTheme.setup();
        Loggin lg = new Loggin();
        ControladorUsuario cluser = new ControladorUsuario();
        ControladorLoggin cl = new ControladorLoggin(lg,cluser);
        cl.iniciar();
        
            
            
        
        
        
    }
}
