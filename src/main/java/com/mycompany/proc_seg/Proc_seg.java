/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proc_seg;

import Controladores.ControladorLoggin;
import Frames.Principal;
import Controladores.ControladorPrincipal;
import Frames.Loggin;
import com.formdev.flatlaf.intellijthemes.FlatVuesionIJTheme;

/**
 *
 * @author pc
 */
public class Proc_seg {

    public static void main(String[] args) {
        FlatVuesionIJTheme.setup();
        //Principal pl = new Principal();
        //ControladorPrincipal cp = new ControladorPrincipal(pl);
        //pl.setVisible(true);
        //cp.iniciarcontenido();
        Loggin lg = new Loggin();
        ControladorLoggin cl = new ControladorLoggin(lg);
        cl.iniciar();
        
    }
}
