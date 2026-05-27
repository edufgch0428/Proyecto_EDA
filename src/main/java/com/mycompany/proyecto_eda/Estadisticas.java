/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_eda;
import java.util.List;

/**
 *
 * @author paopa
 */
public class Estadisticas {
    public static void mostrarTop20(List<Juego> juegos) {

    System.out.println("\n==============================================");
    System.out.println("        TOP 20 JUEGOS CON MAYOR PLAYTIME");
    System.out.println("==============================================");

    int posicion = 1;

    for (int i = juegos.size() - 1;
         i >= 0 && posicion <= 20;
         i--) {

        Juego j = juegos.get(i);

        System.out.println(posicion + ". "
                + j.getNombre()
                + " | Playtime: "
                + j.getPlaytime());

        posicion++;
    }

    System.out.println("==============================================\n");
}

    public static void mostrarPrimerosDatos(List<Juego> juegos, String titulo) {

        System.out.println("\n==============================================");
        System.out.println(titulo);
        System.out.println("==============================================");

        for (int i = 0; i < 20 && i < juegos.size(); i++) {
            Juego j = juegos.get(i);

            System.out.println((i + 1) + ". " + j.getNombre()
                    + " | Playtime: " + j.getPlaytime());
        }
    }
    
    public static void mostrarMilDatos(List<Juego> juegos, String titulo) {

      System.out.println("\n==============================================");
      System.out.println(titulo);
      System.out.println("==============================================");

      for (int i = 0; i < juegos.size() && i < 1000; i++) {
          Juego j = juegos.get(i);

          System.out.println((i + 1) + ". " + j.getNombre()
                  + " | Playtime: " + j.getPlaytime());
      }

      System.out.println("==============================================\n");
  }
}


