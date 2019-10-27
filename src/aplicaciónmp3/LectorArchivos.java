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
import java.io.*;
/**
 *
 * @author ferna
 */
public class LectorArchivos {
    private RandomAccessFile datos;
    private String path;
    private Lista lista = new Lista();
    public LectorArchivos(){//Cuando ya tiene datos no hay que enviarle información

    }
    
    public LectorArchivos(String ruta){
        path = ruta;
    }
    public boolean VerificarDatos() throws FileNotFoundException{
        File Aux = new File("data.data");
        boolean HayDatos = false;
        if(Aux.length() > 0){//Va a leer si tiene al menos algun byte
            HayDatos = true;
        }
        return HayDatos;
    }
    
    public void SaveInformation() throws IOException{
        LectorCanciones algo = new LectorCanciones();
        algo.listFile(path);//Leo la carpeta que eligio
        algo.getCanciones().mostrar();
        Pila data = algo.getCanciones();
        byte id = 0;
        while(data.tope() != null){
            id++;
            this.GetTypeMP3(data.eliminar(), id);
        }
        System.out.println("Esta es la lista a guardar");
        lista.mostrar();
    }
    
    public void GetTypeMP3(String ruta, byte id) throws FileNotFoundException, IOException{
        RandomAccessFile lectura = new RandomAccessFile(ruta, "rw");
        short comparoIniciales = lectura.readShort();
        System.out.println("dATO A COMPARAR " + comparoIniciales);
        short Id3v2 = 18756; //49 44
        int  MPEG1Layer = -5;  //FF FB ya que por el bit del signo este hace que se vuelva negativo todo 
        if (comparoIniciales == Id3v2){
            this.GetID3v2Data(ruta, id);
        }else if(comparoIniciales == MPEG1Layer){
            this.GetMPEG1LayerData(ruta, id);
        }else{
            System.out.println("Ningun formato coincide");
        }
//        for (byte b : bytes) {
//            sb.append(String.format("%02X ", b));
//        }
//    System.out.println(sb.toString());
        
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
    private void GetID3v2Data(String ruta, byte id) throws FileNotFoundException, IOException{
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
        String [] datosAEncontrar = {"COMM", "TALB", "TIT1", "TIT2", "TCOM", "TCON", "TDAT", "WXXX"};
        String [] datosAQuerer = {"COMM", "TALB", "TIT1", "TIT2", "TCOM", "TCON", "TDAT", "WXXX"};
        while(lectura.getFilePointer() < tamaño){
            //Que se detenga si encuentra una imagen en el encabezado, si encuentra todos los datos o si llega al final al programa
            //System.out.println("Posicion de lectura " + lectura.getFilePointer());
            byte [] len = new byte[4];
            lectura.read(len);
            String tag = new String(len);
            if(tag.equals("APIC"))break;
            int tamString = lectura.readInt() + 1;//Ya que siempre le falta un byte de lectura
            byte [] lenString = new byte[tamString];
            lectura.read(lenString);
            String texto = new String(lenString);
            //System.out.println("TAg " + tag);
            //System.out.println(texto);
            lectura.readByte();//Para que se acople
            int posicion = 0;
            for(String palabra : datosAEncontrar){
                if ( tag.toLowerCase().indexOf(palabra.toLowerCase()) != -1 ) {
                    String tempWord = "  " + " "; 
                    texto = texto.replaceAll(tempWord, ""); 
                    datosAEncontrar[posicion] = texto;
                    //System.out.println("Esto meto en el array " + datosAEncontrar[posicion]);
                }
                posicion++;
            }

        }
        for(String palabra : datosAEncontrar){
            System.out.println("Info " + palabra);
        }
        for(int i = 0; i < datosAQuerer.length; i++){//Los datos no encontrados no estan identificados
            if(datosAEncontrar[i] == datosAQuerer[i]){
                datosAEncontrar[i] = "No identificado";
            }
        }
        lista.insertar(id, datosAEncontrar[3], datosAEncontrar[4], datosAEncontrar[1], datosAEncontrar[6], datosAEncontrar[5], "No identificado", datosAEncontrar[7], ruta);
        lectura.close();                                                                             //falta duracion
    }  
    
    private void GetMPEG1LayerData(String ruta, byte id) throws FileNotFoundException, IOException{
        try {
            File song = new File(ruta);
            FileInputStream file = new FileInputStream(song);
            int size = (int)song.length();
            file.skip(size - 128);
            byte[] last128 = new byte[128];
            file.read(last128);
            String id3 = new String(last128);
            String tag = id3.substring(0, 3);
            if (tag.equals("TAG")) {
                    System.out.println("Title: " + id3.substring(3, 32));
                    System.out.println("Artist: " + id3.substring(33, 62));
                    System.out.println("Album: " + id3.substring(63, 91));
                    System.out.println("Year: " + id3.substring(93, 97));
                    lista.insertar(id, id3.substring(3, 32), id3.substring(33, 62), id3.substring(63, 91), id3.substring(93, 97), "No identificado", "No identificado", "No identificado", ruta);
            } else
                    System.out.println("No leeyo nada");
            file.close();
            } catch (Exception e) {
                    System.out.println("Error - " + e.toString());
            }
    }
}
