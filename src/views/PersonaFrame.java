/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controller.PersonaController;
import javax.swing.JOptionPane;
import models.Persona;
import valida.ValidaKeyString;

/**
 *
 * @author Mauro
 */
public class PersonaFrame extends javax.swing.JInternalFrame {
    private PersonaController perc;
    private Persona per;
    
    
    /**
     * Creates new form PersonaFrame
     */
    public PersonaFrame() {
        setTitle("Registros de Personas");
        initComponents();
        keyController();
        setupController();
        
    }
    
    public void setupController(){
        perc = new PersonaController(this);
        Verificar_Button.addActionListener(perc);
        Cedula.addActionListener(perc);
        Save_Button.addActionListener(perc);
        Select_Button.addActionListener(perc);
        Clean_Button.addActionListener(perc);
    }
    
    public void keyController(){
        PrimerN.addKeyListener(new ValidaKeyString());
        SegundoN.addKeyListener(new ValidaKeyString());
        PrimerA.addKeyListener(new ValidaKeyString());
        SegundoA.addKeyListener(new ValidaKeyString());
        Nacimiento.setEditable(false);
        Age.setEditable(false); 
    }
    public Persona getPersona(){
        per = new Persona();
        per.setCedula(Cedula.getText());
        per.setPrimerNombre(PrimerN.getText());
        per.setPrimerApellido(PrimerA.getText());
        per.setSegundoNombre(SegundoN.getText());
        per.setSegundoApellido(SegundoA.getText());
        per.setEdad(Age.getText());
        per.setFecha_Nacimiento(Nacimiento.getText());
        return per;
    }
    
    public void cleanPersona(){
        Cedula.setText("");
        PrimerN.setText("");
        PrimerA.setText("");
        SegundoN.setText("");
        SegundoA.setText("");
        Age.setText("");
        Nacimiento.setText("");
    
    }
    
    public void setPersona(Persona per){
        Cedula.setText(per.getCedula());
        PrimerN.setText(per.getPrimerNombre());
        PrimerA.setText(per.getPrimerApellido());
        SegundoN.setText(per.getSegundoNombre());
        SegundoA.setText(per.getSegundoApellido());
        Age.setText(per.getEdad());
        Nacimiento.setText(per.getFecha_Nacimiento());
    }
        
    public void cap(){
        String Dato;String lol;
        Dato = Cedula.getText();
        boolean verdad = PersonaController.isNicaraguanNumberId(Dato);
        if (verdad == false) {
            JOptionPane.showMessageDialog(null, "La cedula no es Valida", "Error de Cedula", 0);
            Cedula.setText("");
            Age.setText("");
            Nacimiento.setText("");
        }else{
            Nacimiento.setText(PersonaController.getBirthDateFromId(Dato));
            int d = PersonaController.getAge(PersonaController.stringToDate(PersonaController.getBirthDateFromId(Dato),"yyyy-MM-dd"));
            lol = String.valueOf(d);
            Age.setText(lol);    
        }   
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SegundoA = new javax.swing.JTextField();
        SegundoN = new javax.swing.JTextField();
        PrimerA = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Age = new javax.swing.JTextField();
        Cedula = new javax.swing.JTextField();
        Nacimiento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        Select_Button = new javax.swing.JButton();
        Clean_Button = new javax.swing.JButton();
        Save_Button = new javax.swing.JButton();
        PrimerN = new javax.swing.JTextField();
        Verificar_Button = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setText("Primer Nombre");

        jLabel2.setText("Segundo Nombre");

        jLabel3.setText("Primer Apellido");

        jLabel4.setText("Segundo Apellido");

        Age.setActionCommand("");

        Cedula.setToolTipText("");
        Cedula.setActionCommand("ver");

        Nacimiento.setActionCommand("");

        jLabel5.setText("# de cédula");

        jLabel6.setText("Edad");

        jLabel7.setText("Fecha de Nacimiento");

        Select_Button.setText("Seleccionar");
        Select_Button.setActionCommand("Abrir");

        Clean_Button.setText("Limpiar");

        Save_Button.setText("Guardar");

        Verificar_Button.setText("Verificar Cedula");
        Verificar_Button.setActionCommand("Obten");
        Verificar_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Verificar_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Select_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addComponent(Clean_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(Save_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PrimerN, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Age, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                    .addComponent(PrimerA)
                                    .addComponent(Cedula))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(40, 40, 40)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(SegundoA, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(26, 26, 26)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(Nacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                        .addComponent(Verificar_Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(SegundoN, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PrimerN, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(SegundoN))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(PrimerA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(SegundoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Verificar_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Select_Button)
                    .addComponent(Save_Button)
                    .addComponent(Clean_Button))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Verificar_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Verificar_ButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Verificar_ButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Age;
    private javax.swing.JTextField Cedula;
    private javax.swing.JButton Clean_Button;
    private javax.swing.JTextField Nacimiento;
    private javax.swing.JTextField PrimerA;
    private javax.swing.JTextField PrimerN;
    private javax.swing.JButton Save_Button;
    private javax.swing.JTextField SegundoA;
    private javax.swing.JTextField SegundoN;
    private javax.swing.JButton Select_Button;
    private javax.swing.JButton Verificar_Button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables

}
