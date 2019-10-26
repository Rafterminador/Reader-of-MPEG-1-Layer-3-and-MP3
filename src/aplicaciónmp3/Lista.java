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
public class Lista {

    private MP3 inicio;
    private int size;

    public Lista() {
        this.inicio = null;
        this.size = 0;
    }

    public void insertar(Byte id, String nc, String na, String nal, String f, String g, String d, String URL, String dp) {
        inicio = agregar(inicio, id, nc, na, nal, f, g, d, URL, dp);
    }

    private MP3 agregar(MP3 new_canc, Byte id, String nombre_cancion, String nombre_artista, String nombre_album, String fecha_album, String genero, String duracion, String URL, String direccion_pista) {
        if (new_canc == null) {
            new_canc = new MP3(id, nombre_cancion, nombre_artista, nombre_album, fecha_album, genero, duracion, URL, direccion_pista);
        } else {
            if (new_canc.getId() < id) {
                new_canc.setSig(agregar(new_canc.getSig(), id, nombre_cancion, nombre_artista, nombre_album, fecha_album, genero, duracion, URL, direccion_pista));
            }
        }
        size++;
        return new_canc;
    }

//    public void mostrar(){
//        Elemento aux = inicio;
//        if (inicio != null){
//            for (int i = 0; i<=size; i++){
//                System.out.println("Valor: "+ aux.getValor());
//                if(aux.getSiguiente() == null){
//                    break;
//                }
//                aux = aux.getSiguiente();
//            }
//        }
//        else{System.out.println("No hay elementos para mostrar");}
//    }
    public void mostrar() {
        MP3 cancion = this.inicio.getSig();
        System.out.println("ID: " + cancion.getId());
        System.out.println("ID: " + cancion.getNombre_cancion());
        System.out.println("ID: " + cancion.getNombre_artista());
        System.out.println("ID: " + cancion.getNombre_album());
        System.out.println("ID: " + cancion.getFecha_album());
        System.out.println("ID: " + cancion.getGenero());
        System.out.println("ID: " + cancion.getDuracion());
        System.out.println("ID: " + cancion.getURL());
        System.out.println("ID: " + cancion.getDireccion_pista());
    }

    public int getSize() {
        return size;
    }

    public MP3 getInicio() {
        return inicio;
    }
}
