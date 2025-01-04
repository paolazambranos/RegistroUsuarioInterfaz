package com.usuario.logica.modelo;

public class Usuario{
    private String alias;
    private String correo;
    private int puntosTotales;
    private int horasJugadas;
    private int minutosJugados;
    private int segundosJugados;
    private int cantidadDePalabras;
    //private LinkedList<DatosDePartidas> listaDePartidas;

    public Usuario(String alias, String correo) {
        this.alias = alias;
        this.correo = correo;
        this.puntosTotales = 0;
        this.horasJugadas = 0;
        this.minutosJugados = 0;
        this.segundosJugados = 0;
        this.cantidadDePalabras = 0;
        //this.listaDePartidas = new LinkedList<DatosDePartidas>();
    }

    public Usuario(String alias, String correo, int puntosTotales, int minutosJugados, int horasJugadas, int segundosJugados, int cantidadDePalabras) {
        this.alias = alias;
        this.correo = correo;
        this.puntosTotales = puntosTotales;
        this.minutosJugados = minutosJugados;
        this.horasJugadas = horasJugadas;
        this.segundosJugados = segundosJugados;
        this.cantidadDePalabras = cantidadDePalabras;
    }

    public Usuario() {
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getPuntosTotales() {
        return puntosTotales;
    }

    public void setPuntosTotales(int puntosTotales) {
        this.puntosTotales = puntosTotales;
    }

    public int getHorasJugadas() {
        return horasJugadas;
    }

    public void setHorasJugadas(int horasJugadas) {
        this.horasJugadas = horasJugadas;
    }

    public int getMinutosJugados() {
        return minutosJugados;
    }

    public void setMinutosJugados(int minutosJugados) {
        this.minutosJugados = minutosJugados;
    }

    public int getSegundosJugados() {
        return segundosJugados;
    }

    public void setSegundosJugados(int segundosJugados) {
        this.segundosJugados = segundosJugados;
    }

    public int getCantidadDePalabras() {
        return cantidadDePalabras;
    }

    public void setCantidadDePalabras(int cantidadDePalabras) {
        this.cantidadDePalabras = cantidadDePalabras;
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "alias='" + alias + '\'' +
                ", correo='" + correo + '\'' +
                ", puntosTotales=" + puntosTotales +
                ", horasJugadas=" + horasJugadas +
                ", minutosJugados=" + minutosJugados +
                ", segundosJugados=" + segundosJugados +
                ", cantidadDePalabras=" + cantidadDePalabras +
                '}';
    }
}

