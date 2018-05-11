package trabajopractico;

import java.util.List;
import javax.swing.JOptionPane;


public class Chupetines {
    private String marca;
    private int pesoNeto;
    private int stock;

    
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public int getPesoNeto() {
        return pesoNeto;
    }
    public void setPesoNeto(int pesoNeto) {
        this.pesoNeto = pesoNeto;
    }

    
    public int getStock() {
    return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    @Override
    public  String toString() {
         return "Caramelos:" + " marca=" + getMarca() 
                 + ", pesoNeto=" + getPesoNeto() + "g"
                 + ", stock=" + getStock() + " unidades";
    }

    
    
}