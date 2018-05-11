package trabajopractico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;


public class Menuu {
    private List<Chupetines> chupetines = new ArrayList<Chupetines>();
    private List<Masticables> masticables = new ArrayList<Masticables>();
    private List<Acidos> acidos = new ArrayList<Acidos>();
    
    public void opciones(){
    try{    
    String opcion="";
    do{
        String [] opciones ={"1_Consultar","2_Ingresar","3_Consumir","4_Salir de la aplicacion"}; 
        opcion = (String) JOptionPane.showInputDialog(null,"Selecciona una opcion", "Elegir",JOptionPane.QUESTION_MESSAGE,null,opciones, opciones[0]);
     
    if (opcion.equalsIgnoreCase("1_Consultar")){
        String [] opciones1 ={"1_Chupetines","2_Caramelos","3_Volver al menu principal"}; 
        String opcion1 = (String) JOptionPane.showInputDialog(null,"Selecciona una opcion", "Elegir",JOptionPane.QUESTION_MESSAGE,null,opciones1, opciones1[0]);
   
            
        if (opcion1.equalsIgnoreCase("1_Chupetines")){
            consultarChupetines();
        
        } else if (opcion1.equalsIgnoreCase("2_Caramelos")){
            String [] options1 = {"Masticables","Acidos"};
            String opcion2 =(String) JOptionPane.showInputDialog(null,"Selecciona una opcion", "Elegir",JOptionPane.QUESTION_MESSAGE,null,options1, options1[0]);
        
            if (opcion2.equalsIgnoreCase("Masticables")){
              Masticables m = new Masticables();
                consultarMasticables();
            }
            else {
                Acidos a = new Acidos ();
                consultarAcidos(); 
            }
        }
    }
        else if (opcion.equalsIgnoreCase("2_Ingresar")){
        
         String [] opciones1 ={"1_Chupetines","2_Caramelos","3_Volver al menu principal"}; 
         String opcion11 = (String) JOptionPane.showInputDialog(null,"Selecciona una opcion", "Elegir",JOptionPane.QUESTION_MESSAGE,null,opciones1, opciones1[0]);
  
    if (opcion11.equalsIgnoreCase("1_Chupetines")){
        Chupetines c = new Chupetines();
        ingresarChupetines();
    }
        else   if (opcion11.equalsIgnoreCase("2_Caramelos")){
        
        String [] options1 = {"Masticables","Acidos"};
    String opcion2 = (String)JOptionPane.showInputDialog(null,"Selecciona una opcion", "Elegir",JOptionPane.QUESTION_MESSAGE,null,options1, options1[0]);
    
            if (opcion2.equalsIgnoreCase("Masticables")){
            Masticables m = new Masticables();
            ingresarMasticables();
            }
            else{
            Acidos a = new Acidos ();
            ingresarAcidos();
            }
        }
    }
    
    if (opcion.equalsIgnoreCase("3_Consumir")){
        
        String[] opciones1 ={"1_Chupetines","2_Caramelos","3_Volver al menu principal"}; 
        String opcion12 = (String) JOptionPane.showInputDialog(null,"Selecciona una opcion", "Elegir",JOptionPane.QUESTION_MESSAGE,null,opciones1, opciones1[0]);
    
        if (opcion12.equalsIgnoreCase("1_Chupetines")){
        Chupetines c = new Chupetines();
        restaChupetines();
        }
        if (opcion12.equalsIgnoreCase("2_Caramelos")){
       
        String [] options1 = {"Masticables","Acidos"};
        String opcion2 = (String)JOptionPane.showInputDialog(null,"Selecciona una opcion", "Elegir",JOptionPane.QUESTION_MESSAGE,null,options1, options1[0]);
    
        if (opcion2.equalsIgnoreCase("Masticables")){
            Masticables m = new Masticables();
            restaMasticables();
        }
            else{
            Acidos a = new Acidos ();
            restaAcidos();
            }
        }
    }

if (opcion.equalsIgnoreCase("4_Salir de la aplicacion")){
        JOptionPane.showMessageDialog(null, "Fin de la aplicacion");
    }
    
    }while(!opcion.equals("4_Salir de la aplicacion"));
    
    }catch(NullPointerException nu){
        JOptionPane.showMessageDialog(null, "Aplicacion cancelada",
  "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
    }
  }

   
    
    private void consultarChupetines() {
        if(chupetines.isEmpty()){
            JOptionPane.showMessageDialog(null, "No existen chupetines");
        } else {
            for(Chupetines c: chupetines){
              JOptionPane.showMessageDialog(null, chupetines.toString());
            }
            
        }
    }
    public void ingresarChupetines(){
        try{
            Chupetines c =new Chupetines();
            
            c.setMarca(JOptionPane.showInputDialog("Ingrese marca de chupetines:"));
            c.setPesoNeto(Integer.parseInt(JOptionPane.showInputDialog("Ingrese peso neto de chupetines:")));
            c.setStock(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el stock de chupetines:")));
            
            chupetines.add(c);
            }
        catch(NumberFormatException n){
            JOptionPane.showMessageDialog(null, "Error de dato!!!",
            "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void restaChupetines(){
        
        if(chupetines.isEmpty()){
            JOptionPane.showMessageDialog(null, "No existen chupetines");
        } else {
        try{    
            String marcas = "";
                for(Chupetines c : chupetines){
                    int i = 0;
                    marcas += (i+1) + " - " + c.getMarca() + "\n";
                    i++;
                }
                int respuesta= Integer.parseInt(JOptionPane.showInputDialog(null, marcas+"-Ingrese el numero de la lista que desea consumir-"));
                
                int cantidadAConsumir = Integer.parseInt(JOptionPane.showInputDialog(null, chupetines.get(respuesta-1).toString()+" -Ingrese la cantidad que desea consumir-"));  
                int resta = chupetines.get(respuesta-1).getStock() - cantidadAConsumir;
                
                chupetines.get(respuesta-1).setStock( chupetines.get(respuesta-1).getStock() - cantidadAConsumir );
                
                if (resta>=0){
                JOptionPane.showMessageDialog(null,"El stock actual de chupetines '"+chupetines.get(respuesta-1).getMarca() + "' es:"+ resta);
                }
                else{
                JOptionPane.showMessageDialog(null,"Numero de chupetines insuficientes!!");    
                }
        }catch(IndexOutOfBoundsException i){
            JOptionPane.showMessageDialog(null,"Opcion no valida");   
        }
        }
    }
    private void consultarMasticables(){
        if(masticables.isEmpty()){
            JOptionPane.showMessageDialog(null, "No existen caramelos masticables");
        } else {
            for(Masticables m : masticables){
              JOptionPane.showMessageDialog(null, masticables.toString());
            }
        }
     }
     public void ingresarMasticables(){
        try{
            Masticables m = new Masticables();
            m.setMarca(JOptionPane.showInputDialog("Ingrese marca de caramelo masticable:"));
            m.setPesoNeto(Integer.parseInt(JOptionPane.showInputDialog("Ingrese peso neto de caramelo:")));
            m.setStock(Integer.parseInt(JOptionPane.showInputDialog("Ingrese stock de caramelo masticable:")));
            
            masticables.add(m);
        }
        catch(NumberFormatException n){
            JOptionPane.showMessageDialog(null, "Error de dato!!!",
            "ERROR", JOptionPane.ERROR_MESSAGE); 
        }
     }    
     public void restaMasticables(){
       if(chupetines.isEmpty()){
            JOptionPane.showMessageDialog(null, "No existen caramelos masticables");
        } else {
        try{    
            String marcas = "";
                for(Masticables m : masticables){
                    int i = 0;
                    marcas += (i+1) + " - " + m.getMarca() + "\n";
                    i++;
                }
                int respuesta= Integer.parseInt(JOptionPane.showInputDialog(null, marcas+"-Ingrese el numero de la lista que desea consumir-"));
                
                int cantidadAConsumir = Integer.parseInt(JOptionPane.showInputDialog(null, masticables.get(respuesta-1).toString()+" -Ingrese la cantidad que desea consumir-"));  
                
                int resta = masticables.get(respuesta-1).getStock() - cantidadAConsumir;
                masticables.get(respuesta-1).setStock( masticables.get(respuesta-1).getStock() - cantidadAConsumir );
                if (resta>=0){
                JOptionPane.showMessageDialog(null,"El stock actual de Caramelos masticables '"+masticables.get(respuesta-1).getMarca() + "' es:"+ resta);
                }
                else{
                JOptionPane.showMessageDialog(null,"Numero de caramelos insuficientes!!");    
                }
        }catch(IndexOutOfBoundsException i){
            JOptionPane.showMessageDialog(null,"Opcion no valida");   
        }
        }
     }
     
    
     private void consultarAcidos(){
        if(acidos.isEmpty()){
            JOptionPane.showMessageDialog(null, "No existen caramelos acidos");
        } else {
            for(Acidos a : acidos){
              JOptionPane.showMessageDialog(null, a.toString()+", Porcentaje de acides="+a.getPorcentajeAcidez());
            }
        }
    }

     public void ingresarAcidos(){
        try{
            Acidos a = new Acidos();
            a.setMarca(JOptionPane.showInputDialog("Ingrese marca de caramelo acido:"));
            a.setPesoNeto(Integer.parseInt(JOptionPane.showInputDialog("Ingrese peso neto de caramelo:")));
            a.setStock(Integer.parseInt(JOptionPane.showInputDialog("Ingrese stock de caramelo acido:")));
            a.setPorcentajeAcidez(Double.parseDouble(JOptionPane.showInputDialog("Ingrese porcentaje de acidez")));
            acidos.add(a);
        }
        catch(NumberFormatException n){
            JOptionPane.showMessageDialog(null, "Error de dato!!!",
            "ERROR", JOptionPane.ERROR_MESSAGE); 
        }
    } 
     public void restaAcidos(){
        if(chupetines.isEmpty()){
            JOptionPane.showMessageDialog(null, "No existen chupetines");
        } else {
        try{    
            String marcas = "";
                for(Acidos a : acidos){
                    int i = 0;
                    marcas += (i+1) + " - " + a.getMarca() + "\n";
                    i++;
                }
                int respuesta= Integer.parseInt(JOptionPane.showInputDialog(null, marcas+"-Ingrese el numero de la lista que desea consumir-"));
                
                int cantidadAConsumir = Integer.parseInt(JOptionPane.showInputDialog(null, acidos.get(respuesta-1).toString()+" -Ingrese la cantidad que desea consumir-"));  
                
                
                
                int resta = acidos.get(respuesta-1).getStock() - cantidadAConsumir;
                acidos.get(respuesta-1).setStock( acidos.get(respuesta-1).getStock() - cantidadAConsumir );
                
                if (resta>=0){
                JOptionPane.showMessageDialog(null,"El stock actual de caramelos acidos '"+acidos.get(respuesta-1).getMarca() + "' es:"+ resta);
                }
                else{
                JOptionPane.showMessageDialog(null,"Numero de caramelos insuficientes!!");    
                }
        }catch(IndexOutOfBoundsException i){
            JOptionPane.showMessageDialog(null,"Opcion no valida");   
        }
        }
    
    
    
        }
    }




