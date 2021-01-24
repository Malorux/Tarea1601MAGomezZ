/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Convertir;
import views.ConvertirFrame;

/**
 *
 * @author Mauro
 */
public class ConvertirController implements ActionListener {
    ConvertirFrame converF ;
    Convertir conv = new Convertir();

    
            
    public ConvertirController(ConvertirFrame coverFrame) {
        converF = coverFrame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Convertir":
                converF.getdato();
            break;
        }
    }
    

    
    
    
    
}
