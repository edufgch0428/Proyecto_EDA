/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_eda;

import java.util.ArrayList;

/**
 *
 * @author mateo
 */
public class AnalisisEstadistico {
    
    public static void top10Juegos(ArrayList<String[]> juegos) {

    System.out.println("============================================");
    System.out.println("  TOP 10 JUEGOS MAS POPULARES (owned)      ");
    System.out.println("============================================");

    // Solo busca el top 10, no ordena toda la lista
    for (int i = 0; i < 10; i++) {
        int maxPos = i;

        // Busca el mayor desde la posicion actual
        for (int j = i + 1; j < juegos.size(); j++) {
            try {
                int ownerActual = Integer.parseInt(juegos.get(j)[1]); //Lo trata como un numero para comparar 
                int ownerMax    = Integer.parseInt(juegos.get(maxPos)[1]); //Lo trata como un numero para comparar
                if (ownerActual > ownerMax) {
                    maxPos = j;
                }
            } catch (NumberFormatException e) {
                continue;
            }
        }

        // Intercambiar el mayor encontrado con la posicion i
        String[] temp = juegos.get(i);
        juegos.set(i, juegos.get(maxPos));
        juegos.set(maxPos, temp);

        // Extraer los datos del juego ganador para imprimirlos
        int puesto   = i + 1;          // numero del puesto (1, 2, 3...)
        String name  = juegos.get(i)[0]; // nombre del juego
        String owned = juegos.get(i)[1]; // cantidad de duenos

    System.out.printf("%2d. %-40s owned: %s%n", puesto, name, owned);
         }

    System.out.println("============================================");
    }
}
