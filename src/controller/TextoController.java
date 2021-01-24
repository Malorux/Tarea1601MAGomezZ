/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import models.Texto;
import views.TextoFrame;

/**
 *
 * @author Mauro
 */
public class TextoController implements ActionListener{
    private final TextoFrame textof;
    private Texto t = new Texto();
    private int seleccion;
    private String b,a;
    JFileChooser j;
    

    public TextoController(TextoFrame texto) {
        this.textof = texto;
        j = new JFileChooser();
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
   
        switch(e.getActionCommand()){
            case "save" -> {
                seleccion = j.showSaveDialog(textof);
                if(seleccion == JFileChooser.APPROVE_OPTION){
                    File file = j.getSelectedFile();
                    t = textof.getTexto();
                    guardar(file);
//                    save(file);                       
                }else if(seleccion == JFileChooser.CANCEL_OPTION){
                }
            }
            case "open" -> {
                seleccion = j.showOpenDialog(textof);
                if(seleccion == JFileChooser.APPROVE_OPTION){
                    File file =j.getSelectedFile();
                    b=file.toString();
                    textof.directorios(b);
                    a = abrir(file);
                    textof.setTexto(a);
                }else if(seleccion == JFileChooser.CANCEL_OPTION ){
                }
            }
            case "clear" -> textof.clearTexto();
        }
    }
    
    public String abrir(File file){

        String ora=""; 
        int caracter; 
        try {
            FileReader lect = new FileReader(file);     
            while((caracter = lect.read())!=-1){
              ora +=(char)caracter; 
            }
        } catch (IOException e) {
        }
        
        return ora;
    }
    public void guardar(File file){
        try {
            FileWriter lect = new FileWriter(file);
            lect.write(t.getArea());
            lect.flush();    
        } catch (IOException e) {
        }
    }    
    
    //area de prueba
//    public void save(File file){
//        try{
//            ObjectOutputStream w = new ObjectOutputStream (new FileOutputStream(file));
//            w.writeObject(t);
//            w.flush();
//        }catch(IOException ex){   
//        }
//    }
//    
//    public Texto open (File file){
//          
//        Texto text = new Texto();
//        try{
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file) );
//            text = (Texto)ois.readObject();        
//        }catch(IOException | ClassNotFoundException ex){
//        }
//        return text;
//    }
        
}
