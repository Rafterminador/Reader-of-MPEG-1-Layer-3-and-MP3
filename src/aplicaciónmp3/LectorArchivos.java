/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicaciónmp3;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
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
    
    public void GetVersion(String ruta) throws FileNotFoundException, IOException{
        RandomAccessFile lectura = new RandomAccessFile(ruta, "rw");
        byte [] caracteres = new byte[3];
        lectura.read(caracteres);
        String nombre = new String(caracteres);
        System.out.println("Etiqueta " + nombre);
        if(nombre.equals("ID3")){
            System.out.println("Parecidos");
        }
        int Version = lectura.readByte();
        System.out.println("Version " + Version);
        int NumRevision = lectura.readByte();
        System.out.println("#Revisión " + NumRevision);
        byte indicadores = lectura.readByte();
        int tamaño = lectura.readInt();
        tamaño = tamaño /8;
        System.out.println("Tamaño " + tamaño);
        String[] array = new String[5];
        int count = Collections.frequency(Arrays.asList(array), null);
        System.out.println("String: " + count + " items out of " + array.length + " are null");
        String [] datosAEncontrar = {"COMM", "TALB", "TIT1", "TIT2", "TCOM", "TCON", "TYER", "WXXX"};
        while(lectura.getFilePointer() < tamaño || count != array.length){
            System.out.println("Posicion de lectura " + lectura.getFilePointer());
            byte [] len = new byte[4];
            lectura.read(len);
            String tag = new String(len);
            int tamString = lectura.readInt() + 1;//Ya que siempre le falta un byte de lectura
            byte [] lenString = new byte[tamString];
            lectura.read(lenString);
            String texto = new String(lenString);
            System.out.println("TAg " + tag);
            System.out.println(texto);
            lectura.readByte();//Para que se acople
            int posicion = 0;
            for(String palabra : datosAEncontrar){
                if ( tag.toLowerCase().indexOf(palabra.toLowerCase()) != -1 ) {
                    System.out.println("Coincidencia");
                    String tempWord = "  " + " "; 
                    texto = texto.replaceAll(tempWord, ""); 
                    datosAEncontrar[posicion] = texto;
                    System.out.println("Esto meto en el array " + datosAEncontrar[posicion]);
                }
                posicion++;
            }

        }
            for(String palabra : datosAEncontrar){
                System.out.println("Info " + palabra);
            }
        //20 bits apra enontra info
//            for(String s: list){
//        if(s.equals(search)){
//            //do whatever
//        }
           // }
        
        //COMM [#sec4.11 Comments]
        //TALB    [#TALB Album/Movie/Show title]
        //TIT1    [#TIT1 Content group description]
        //   TIT2    [#TIT2 Title/songname/content description]
    //TCOM		Composer
    //TCON		Genre
    //TYER		Year
    //WXXX		URL
  
//        try { 
//            String text = "ID3"; // translating text String to 7 bit ASCII encoding 
//            byte[] bytes = text.getBytes("US-ASCII"); 
//            System.out.println("ASCII value of " + text + " is following");
//            System.out.println(Arrays.toString(bytes)); 
//        } catch (java.io.UnsupportedEncodingException e) { e.printStackTrace(); }


    }
//datos = new RandomAccessFile("data.data", "rw");
    
}
