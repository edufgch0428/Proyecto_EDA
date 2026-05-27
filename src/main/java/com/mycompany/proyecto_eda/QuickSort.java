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
public class QuickSort {
public static void ordenarPorPlaytime(List<Juego> juegos) {

        quickSort(juegos, 0, juegos.size() - 1);
        
    }

    private static void quickSort(List<Juego> juegos, int inicio, int fin) {

        if (inicio >= fin) {
            return;
        }

        int izquierda = inicio;
        int derecha = fin;

        double pivote = juegos.get((inicio + fin) / 2).getPlaytime();

        while (izquierda <= derecha) {

            while (juegos.get(izquierda).getPlaytime() < pivote) {
                izquierda++;
            }

            while (juegos.get(derecha).getPlaytime() > pivote) {
                derecha--;
            }

            if (izquierda <= derecha) {


                Juego aux = juegos.get(izquierda);

                juegos.set(izquierda, juegos.get(derecha));

                juegos.set(derecha, aux);

                izquierda++;
                derecha--;
            }
        }

        if (inicio < derecha) {
            quickSort(juegos, inicio, derecha);
        }

        if (izquierda < fin) {
            quickSort(juegos, izquierda, fin);
        }
    }
    
    public static void mostrarExplicacion() {

    System.out.println("\n==============================================");
    System.out.println("      EXPLICACION DEL PROCESO QUICK SORT");
    System.out.println("==============================================");
    System.out.println("QuickSort no ordena copiando otra lista.");
    System.out.println("Ordena la misma lista dividiendola por partes.");
    System.out.println();
    System.out.println("Pasos principales:");
    System.out.println("1. Se selecciona un pivote, en este caso el dato del medio.");
    System.out.println("2. Se comparan los juegos segun su playtime.");
    System.out.println("3. Los juegos con mayor playtime se colocan a la izquierda.");
    System.out.println("4. Los juegos con menor playtime se colocan a la derecha.");
    System.out.println("5. Luego se repite el proceso en cada mitad de la lista.");
    System.out.println("6. Al final, toda la lista queda ordenada de mayor a menor playtime.");
    System.out.println();
    System.out.println("Nota: Se muestran solo los resultados principales para no saturar la consola.");
    System.out.println("==============================================\n");
}
}
