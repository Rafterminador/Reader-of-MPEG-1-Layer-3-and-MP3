/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicaciónmp3;

/**
 *
 * @author Kelvin Cano
 */
public class Indice {
    private short pos;
    private String cadena;
    private Indice sig;

    public Indice(short pos, String cadena) {
        this.pos = pos;
        this.cadena = cadena;
        this.sig = null;
    }

    public short getPos() {
        return pos;
    }

    public void setPos(short pos) {
        this.pos = pos;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
    
    public Indice getSig() {
        return sig;
    }

    public void setSig(Indice sig) {
        this.sig = sig;
    }  
}

