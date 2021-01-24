/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import views.DepaFrame;

/**
 *
 * @author Mauro
 */
public class DepaController implements ActionListener{
    private DepaFrame depf;
    
    public DepaController(DepaFrame Df) {
        this.depf = Df;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Message":
                mensaje();
                break;
        }
    }
    
    public void mensaje (){
        JOptionPane.showMessageDialog(null, "Nicaragua es un país ubicado en el istmo centroamericano. Limita al norte con Honduras y al sur, con Costa Rica,\nestá dividido en 15 departamentos, dos regiones autónomas, y cuenta con 153 municipios.", "Breve descripcion de Nicaragua",1);
    }
    
    
}
