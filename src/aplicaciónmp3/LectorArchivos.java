/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicaciónmp3;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.File;

/**
 *
 * @author ferna
 */
public class LectorArchivos {
    private RandomAccessFile datos;
    public boolean VerificarDatos() throws FileNotFoundException{
        File Aux = new File("data.data");
        boolean HayDatos = false;
        if(Aux.length() > 0){//Va a leer si tiene al menos algun byte
            HayDatos = true;
        }
        return HayDatos;
    }
    //datos = new RandomAccessFile("data.data", "rw");
}
