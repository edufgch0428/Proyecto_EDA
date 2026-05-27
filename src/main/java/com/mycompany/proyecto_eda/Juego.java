package com.mycompany.proyecto_eda;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author paopa
 */
public class Juego {

    private String nombre;
    private double playtime;

    public Juego(String nombre, double playtime) {
        this.nombre = nombre;
        this.playtime = playtime;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPlaytime() {
        return playtime;
    }
}
