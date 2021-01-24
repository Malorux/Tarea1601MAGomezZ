/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import models.Persona;
import views.PersonaFrame;

/**
 *
 * @author Mauro
 */
public class PersonaController implements ActionListener {
    private PersonaFrame frame;
    private Persona per ;
    private int Seleccion;
    JFileChooser j;


    public PersonaController(PersonaFrame f) {
        frame = f;
        j = new JFileChooser();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Obten":
                frame.cap();
                break;
            case "Abrir":
                Seleccion = j.showOpenDialog(frame);
                if(Seleccion == JFileChooser.APPROVE_OPTION){
                    per = open(j.getSelectedFile());
                    frame.setPersona(per);                
                }else if(Seleccion == JFileChooser.CANCEL_OPTION ){
                }
                break;
            case "Limpiar":
                frame.cleanPersona();
                break;
            case "Guardar":
                Seleccion = j.showSaveDialog(frame);
                if(Seleccion == JFileChooser.APPROVE_OPTION){
                    File file = j.getSelectedFile();
                    per = frame.getPersona();
                    save(file);                       
                }else if(Seleccion == JFileChooser.CANCEL_OPTION){
                }
                break;
            
        }
    }
    
    
    public File save(File file){

        try{
            ObjectOutputStream w = new ObjectOutputStream (new FileOutputStream(file));
            w.writeObject(per);
            w.flush();
        }catch(IOException ex){   
        }
        return file;
    }
    
    public Persona open (File file){
        
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            return (Persona)ois.readObject();        
        }catch(IOException | ClassNotFoundException ex){
        }
        return null;
    }    
    
    
    public static boolean isNicaraguanNumberId(String idNumber){
        //la longitud debe ser exactamente de 14 caracteres
        if(idNumber.length()!= 14){
            return false;
        }
        //El último caracter debe ser letra
        if(!Character.isLetter(idNumber.charAt(13))){
            return false;
        }
        //El resto de caracteres deben ser numeros
        if(!(Character.isDigit(idNumber.charAt(0))&&Character.isDigit(idNumber.charAt(1))&&
           Character.isDigit(idNumber.charAt(2))&&Character.isDigit(idNumber.charAt(3))&&     
           Character.isDigit(idNumber.charAt(4))&&Character.isDigit(idNumber.charAt(5))&&
           Character.isDigit(idNumber.charAt(6))&&Character.isDigit(idNumber.charAt(7))&&     
           Character.isDigit(idNumber.charAt(8))&&Character.isDigit(idNumber.charAt(9))&&
           Character.isDigit(idNumber.charAt(10))&&Character.isDigit(idNumber.charAt(11))&&
           Character.isDigit(idNumber.charAt(12)))){
           return false;
        }

        //Los seis caracteres del centro deben conformar una fecha válida
        String birthDate = idNumber.substring(3,9);
        if (!isDate(birthDate,"ddMMyy")) {
            return false;
        }   
        return getAge(stringToDate(getBirthDateFromId(idNumber),"dd-mm-yyyy"))>=16; 
    }
    
    public static String getBirthDateFromId(String idNumber){
        String day = idNumber.substring(3, 5);
        String month = idNumber.substring(5, 7);
        String year = idNumber.substring(7, 9);
        int y = Integer.parseInt(year);

        if (y >= 0 && y <= 29) {
            y += 2000;
        } else {
            y += 1900;
        }
        String date= String.valueOf(y)+"-"+month+ "-" + day;
        return date;    
    }
    
    public static boolean isDate(String stringDate, String format) {
        int dd,mm,yy;
        boolean leapyear=false;
        
        switch(format){
            case "ddMMyy":
            case "ddMMyyyy":
                dd= Integer.parseInt(stringDate.substring(0, 2));
                mm= Integer.parseInt(stringDate.substring(2, 4));
                yy= Integer.parseInt(stringDate.substring(4));                               
                break;
            case "dd-MM-yyyy":
            case "dd/MM/yyyy":                
                dd= Integer.parseInt(stringDate.substring(0, 2));
                mm= Integer.parseInt(stringDate.substring(3, 5));
                yy= Integer.parseInt(stringDate.substring(6));                               
                break;                
            case "yyyyMMdd":
                yy= Integer.parseInt(stringDate.substring(0, 4));
                mm= Integer.parseInt(stringDate.substring(4, 6));
                dd= Integer.parseInt(stringDate.substring(6));                 
                break;
            case "yyyy-MM-dd":
            case "yyyy/MM/dd":    
                yy= Integer.parseInt(stringDate.substring(0, 4));
                mm= Integer.parseInt(stringDate.substring(5, 7));
                dd= Integer.parseInt(stringDate.substring(8));                 
                break;               
            default:
                dd =0;mm=0;yy=0;
                break;
        }

        if(yy % 2 == 0){
            if (yy % 4 == 0) { leapyear = true; }
        }
        if(mm < 1 || mm > 12) {
            return false;
        }
        else{
            switch(mm){
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    if (dd < 1 || dd > 31){ return false; }
                case 2:
                    if (leapyear) {
                        if (dd < 1 || dd > 29){ return false; }
                    }
                    else{
                        if (dd < 1 || dd > 28){ return false;}
                    }
                default:
                    if(dd < 1 || dd > 30){ return false; }
            }
        }
        return true;
    }    
    public static Date stringToDate(String date, String format){
        try{
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.parse(date);        
        }catch(ParseException ex){
           
            return null;
        }    
    }
    public static String dateToString(Date date, String format){
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
    }    
    public static int getAge(Date birthDate){        
        int age=0;
        if(birthDate==null){
            return age;
        }
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(year);
        System.out.println(month);
        System.out.println(day);

        String stringBirthDate = dateToString(birthDate,"yyyy-MM-dd");
        StringTokenizer tokens=new StringTokenizer(stringBirthDate,"-");  
        System.out.println(stringBirthDate);

        int byear=Integer.parseInt(tokens.nextToken());
        int bmonth=Integer.parseInt(tokens.nextToken());
        int bday=Integer.parseInt(tokens.nextToken());
        System.out.println(byear);
        System.out.println(bmonth);
        System.out.println(bday);

        //la diferencia
        age = year - byear;
        if( month < bmonth ){
            age = age-1;
        }
        else{
            if(month == bmonth){
                if(day < bday){
                    age = age-1;
                }
            }
        }
        return age;        
    }
    
}    
    
    

