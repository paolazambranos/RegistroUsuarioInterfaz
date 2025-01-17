package com.usuario.logica.modelo;

/**

 * Esta clase representa al usuario en la aplicacion
 * de registro, almacena informacion sobre el usuario,
 * como el alias, correo y estadisticas del juego
 *
 * @author Paola Zambrano
 * @version 1.0
 */
public class Usuario{
    private String alias;
    private String correo;
    private int puntosTotales;
    private int horasJugadas;
    private int minutosJugados;
    private int segundosJugados;
    private int cantidadDePalabras;
    //private LinkedList<DatosDePartidas> listaDePartidas;

    /**
     *
     * Este metodo es el constructor de la clase Usuario
     *
     *
     * @param alias apodo del usuario
     * @param correo direccion de correo electronico del usuario
     */
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

    /**
     * Este metodo es un constructor de la clase
     * Usuario que crea una instancia de Usuario
     * inicializando todos sus atributos
     *
     * @param alias apodo del usuario
     * @param correo direccion del correo electronico del usuario
     * @param puntosTotales numero total de puntos acumulados
     * @param minutosJugados cantidad de minutos totales jugadas
     * @param horasJugadas cantidad de horas totales jugadas
     * @param segundosJugados cantidad de segundos totales jugadas
     * @param cantidadDePalabras numero total de palabras asociadas
     */
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

    /**
     * Este metodo llama al metodo toString()
     * de ese objeto para convertir una cadena
     *
     * @return una representacion de la cadena
     */
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

