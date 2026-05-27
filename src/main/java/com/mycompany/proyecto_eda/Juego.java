package com.mycompany.proyecto_eda;

/**
 *
 * @author paopa, alaydv
 */
public class Juego {

    private String nombre;
    private double playtime;
    private int metacritic;

    public Juego(String nombre, double playtime) {
        this.nombre = nombre;
        this.playtime = playtime;
    }

    public Juego(String nombre, int metacritic) {
        this.nombre = nombre;
        this.metacritic = metacritic;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPlaytime() {
        return playtime;
    }

    public int getMetacritic() {
        return metacritic;
    }
    
}
