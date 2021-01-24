/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valida;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Mauro
 */
public class ValidaKeyDouble extends KeyAdapter{
    
    public void keyTyped(KeyEvent e){
        char c= e.getKeyChar();
        if(!Character.isDigit(c)&& e.getKeyChar()!= '.'){
            e.consume();   
        }
        
    }
    
}
