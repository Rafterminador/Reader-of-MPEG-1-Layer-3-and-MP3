/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicaciónmp3;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/**
 *
 * @author ferna
 */
public class RecuperadorInformacion {
    private String ruta = "canciones.data";
    private Lista datos;
    public void leer() throws FileNotFoundException{
        RandomAccessFile lectura = new RandomAccessFile(ruta, "rw");
        
    }
}
