/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicaciónmp3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author Kelvin Cano
 */
public class GuardarDatos {
private String nombreDeArchivo;
    private Lista listadoRegistros;
//    private Lista indiceRegistros;
//     private ArrayList<Indice> indiceRegistros;

    public GuardarDatos(String nombreDeArchivo) {
        this.nombreDeArchivo = nombreDeArchivo;
        this.listadoRegistros = new Lista();
//        this.indiceRegistros = new Lista();
//        this.indiceRegistros = new ArrayList<>();

    }

    public void agregarMP3(Byte id, String nombre_cancion, String nombre_artista, String nombre_album, String fecha_album, String genero, String duracion, String URL, String direccion_pista) {
        listadoRegistros.insertar(id, nombre_cancion, nombre_artista, nombre_album, fecha_album, genero, duracion, URL, direccion_pista);
//        indiceRegistros.insertarI((short) 0, nombre_cancion);
//        indiceRegistros.add(new Indice((short) 0, nombre_cancion));
    }

    public void Guardar() throws FileNotFoundException, IOException {
        RandomAccessFile registro = new RandomAccessFile(nombreDeArchivo, "rw");
        short punteroAindice = 0;
        registro.writeShort(punteroAindice);

        int contadorIndice = 0;
        MP3 mp3 = listadoRegistros.getInicio();
        for (int i = 1; i <= listadoRegistros.getSize(); i++) {//recorre la lista

//            indiceRegistros.get(contadorIndice).setPos((short) registro.getFilePointer());//getFilePointer obtiene la posicion en la que se va escribiendo                
            registro.write(mp3.getId());

            registro.write(mp3.getNombre_cancion().length());
            registro.writeChars(mp3.getNombre_cancion());

            registro.write(mp3.getNombre_artista().length());
            registro.writeChars(mp3.getNombre_artista());

            registro.write(mp3.getNombre_album().length());
            registro.writeChars(mp3.getNombre_album());

            registro.write(mp3.getGenero().length());
            registro.writeChars(mp3.getGenero());

            registro.write(mp3.getDuracion().length());
            registro.writeChars(mp3.getDuracion());

            registro.write(mp3.getURL().length());
            registro.writeChars(mp3.getURL());

            registro.write(mp3.getDireccion_pista().length());
            registro.writeChars(mp3.getDireccion_pista());
            if (mp3.getSig() == null) {
                break;
            }
            mp3 = mp3.getSig();
        }

//        for (int i = 1; i <= indiceRegistros.size() - 1; i++) {
//            for (int j = i + 1; j < indiceRegistros.size(); i++) {
//                if (indiceRegistros.get(i).getCadena().compareTo(indiceRegistros.get(j).getCadena()) > 0) {
//                    String temp = indiceRegistros.get(i).getCadena();
//                    indiceRegistros.get(i).setCadena(indiceRegistros.get(j).getCadena());
//                    indiceRegistros.get(j).setCadena(temp);
//
//                    short temp1 = indiceRegistros.get(i).getPos();
//                    indiceRegistros.get(i).setPos(indiceRegistros.get(j).getPos());
//                    indiceRegistros.get(j).setPos(temp1);
//                }
//            }
//        }
//
//        punteroAindice = (short) registro.getFilePointer();
//        for (Indice indice : indiceRegistros) {
//            registro.writeShort(indice.getPos());
//            registro.writeByte(indice.getCadena().length());
//            registro.writeChars(indice.getCadena());
//        }
//        registro.seek(0);//retorna a la pos 0
//        registro.writeShort(punteroAindice);
        registro.close();
    }

    public String getNombreDeArchivo() {
        return nombreDeArchivo;
    }

    public void setNombreDeArchivo(String nombreDeArchivo) {
        this.nombreDeArchivo = nombreDeArchivo;
    }

    public Lista getListadoRegistros() {
        return listadoRegistros;
    }

    public void setListadoRegistros(Lista listadoRegistros) {
        this.listadoRegistros = listadoRegistros;
    }        

//    public ArrayList<Indice> getIndiceRegistros() {
//        return indiceRegistros;
//    }
//
//    public void setIndiceRegistros(ArrayList<Indice> indiceRegistros) {
//        this.indiceRegistros = indiceRegistros;
//    }   
}
