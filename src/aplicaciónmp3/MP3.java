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
public class MP3 {
    protected Byte id;
    private String nombre_cancion;
    private String nombre_artista;
    private String nombre_album;
    private String fecha_album;
    private String genero;
    private String duracion;
    private String URL;
    private String direccion_pista;
    private String direccion_letra;
    private String bio;
    private MP3 sig;

    public MP3(Byte id, String nombre_cancion, String nombre_artista, String nombre_album, String fecha_album, String genero, String duracion, String URL, String direccion_pista) {
        this.id = id;
        this.nombre_cancion = nombre_cancion;
        this.nombre_artista = nombre_artista;
        this.nombre_album = nombre_album;
        this.fecha_album = fecha_album;
        this.genero = genero;
        this.duracion = duracion;
        this.URL = URL;
        this.direccion_pista = direccion_pista;
        this.direccion_letra = "";
        this.bio = "";
        this.sig = null;
    }

    public Byte getId() {
        return id;
    }

    public void setId(Byte id) {
        this.id = id;
    }

    public String getNombre_cancion() {
        return nombre_cancion;
    }

    public void setNombre_cancion(String nombre_cancion) {
        this.nombre_cancion = nombre_cancion;
    }

    public String getNombre_artista() {
        return nombre_artista;
    }

    public void setNombre_artista(String nombre_artista) {
        this.nombre_artista = nombre_artista;
    }

    public String getNombre_album() {
        return nombre_album;
    }

    public void setNombre_album(String nombre_album) {
        this.nombre_album = nombre_album;
    }

    public String getFecha_album() {
        return fecha_album;
    }

    public void setFecha_album(String fecha_album) {
        this.fecha_album = fecha_album;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getDireccion_pista() {
        return direccion_pista;
    }

    public void setDireccion_pista(String direccion_pista) {
        this.direccion_pista = direccion_pista;
    }

    public String getDireccion_letra() {
        return direccion_letra;
    }

    public void setDireccion_letra(String direccion_letra) {
        this.direccion_letra = direccion_letra;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public MP3 getSig() {
        return sig;
    }

    public void setSig(MP3 sig) {
        this.sig = sig;
    }    
}
