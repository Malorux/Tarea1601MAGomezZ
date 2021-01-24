/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import views.ConvertirFrame;
import views.DepaFrame;
import views.TextoFrame;
import views.MainFrame;
import views.PersonaFrame;

public class MainController implements ActionListener {
    private MainFrame frame;

    public MainController(MainFrame frame) {
        this.frame = frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "regis":
                invokeTexto();
                break;
            case "exit":
                System.exit(0);
                break;
            case "configurar":
                message();
                break;
            case "depa":
                invokeDepa();
                break;
            case "pers":
                invokePer();
                break;
            case "money":
                InvokeMoney();
                break;
        }
    }
    
    public void invokeTexto(){
        TextoFrame textoframe = new TextoFrame();
        frame.ShowChild(textoframe, true);
    }
    
    public void invokeDepa(){
        DepaFrame depaframe = new DepaFrame();
        frame.ShowChild(depaframe, true);
    }
    
    public void invokePer(){
        PersonaFrame perframe = new PersonaFrame();
        frame.ShowChild(perframe, true);
    }
    
    public void InvokeMoney(){
        ConvertirFrame converframe = new ConvertirFrame();
        frame.ShowChild(converframe, true);
    }
    public void message (){
        JOptionPane.showMessageDialog(null, "Configuracion no Disponible", "lo Siento", 0);
    }
}
