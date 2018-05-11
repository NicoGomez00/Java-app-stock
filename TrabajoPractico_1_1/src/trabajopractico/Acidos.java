/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajopractico;

import javax.swing.JOptionPane;

/**
 *
 * @author Nico
 */
public class Acidos extends Caramelos{
    
    private double porcentajeAcidez;
    
    
    public double getPorcentajeAcidez() {
      return porcentajeAcidez;
    }
    public void setPorcentajeAcidez(double porcentajeAcidez) {
        this.porcentajeAcidez = porcentajeAcidez;
    }

    public void ingresar(){
        super.getMarca();
        super.getPesoNeto();
        super.getStock();
    }
    
    public String toString() {
        return super.toString();
        
    }
}