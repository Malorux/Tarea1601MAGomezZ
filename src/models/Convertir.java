/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Mauro
 */
public class Convertir {
    private String [] Dinero = {"Cordoba","Dolar","Euro"};
    private String [] Cordoba ={"Dolar","Euro"};
    private String [] Euro = {"Cordoba","Dolar"};
    private String [] Dolar = {"Cordoba","Euro"};
    private String MontoT;
    private String MontoD;
    
    public Convertir() {
    }

    public String[] getDinero() {
        return Dinero;
    }

    public String[] getCordoba() {
        return Cordoba;
    }

    public String[] getEuro() {
        return Euro;
    }

    public String[] getDolar() {
        return Dolar;
    }

    public String getMontoT() {
        return MontoT;
    }

    public String getMontoD() {
        return MontoD;
    }    
}
