/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto_eda;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mateo
 */
public class Proyecto_EDA {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Menu menu = new Menu();
    //Leer los IDs del CSV una sola vez
    LectorCSV lector = new LectorCSV("src/main/resources/game_info_100mil.csv");
    List<Integer> ids;
    //Excepción que se encarga de verificar la lectura del archivo .csv
    try {
        ids = lector.leerIds();
        System.out.printf("IDs cargados: %,d%n%n", ids.size());
    } catch (IOException e) {
        System.err.println("Error al leer el archivo: " + e.getMessage());
        return;
    }
    
    // Sondeo Cuadratico
    SondeoCuadratico sq = new SondeoCuadratico();
    for (int id : ids) {
       sq.insertar(id);
    }
    int opcion;
    do {
       menu.mostrarMenu(); // mostrar menú en cada vuelta
       opcion = scanner.nextInt(); // leer opción en cada vuelta

       switch(opcion){
            case 1: 
  try {

    List<Juego> juegos = lector.leerJuegosPlaytime();

    Estadisticas.mostrarMilDatos(
            juegos,
            "1000 DATOS ANTES DE APLICAR QUICK SORT"
    );

    QuickSort.mostrarExplicacion();

    long inicio = System.currentTimeMillis();

    QuickSort.ordenarPorPlaytime(juegos);

    long fin = System.currentTimeMillis();

    Estadisticas.mostrarMilDatos(
            juegos,
            "1000 DATOS DESPUES DE APLICAR QUICK SORT"
    );

    Estadisticas.mostrarTop20(juegos);

    System.out.println("Tiempo de ordenamiento QuickSort: "
            + (fin - inicio) + " ms");

} catch (IOException e) {

    System.out.println("Error al leer el archivo: "
            + e.getMessage());
}
    break;
            case 2:
                System.out.println("En mantenimiento");
                break;
            case 3:
                sq.imprimirReporte();
                break;
            case 4:
                System.out.println("Saliendo del programa");
                break;
            default:
                System.out.println("Ingrese una opcion valida");
                }
            } while (opcion != 4);
        }
}
