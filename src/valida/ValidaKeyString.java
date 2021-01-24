/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valida;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Mauro
 */
public class ValidaKeyString extends KeyAdapter{
    
    public void keyTyped(KeyEvent e){
        char c= e.getKeyChar();
        if(!(Character.isLetter(c)||c==KeyEvent.VK_BACK_SPACE||c==KeyEvent.VK_ENTER)){
            e.consume();
        }
    }

    
}
