package com.mycompany.proyecto_eda;

import java.io.IOException;
import java.util.ArrayList;
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
    //Excepción que se encarga de verificar la lectura del archivo .csv
    try {
        lector.leer();

        } catch (IOException e) {
        System.err.println("Error al leer el archivo: " + e.getMessage());
        return;
    }
    // Obtener los datos leidos del CSV
    ArrayList<Integer>  ids    = lector.getIds();
    ArrayList<String[]> juegos = lector.getJuegos();
    ArrayList<Juego>    juegosPlaytime  = lector.getJuegosPlaytime();  // Lista de objetos Juego con nombre y playtime
    System.out.printf("IDs cargados: %,d%n%n", ids.size());
    
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
                //Se renombra a juegosOrdenados para evitar conflicto con la variable
                //Se elimina el try-catch debido a que leerJuegosPlayTime ya se encuentra en el try-catch del LectorCSV
                // Se usa una copia para no modificar la lista original al ordenar
                List<Juego> juegosOrdenados = new ArrayList<>(juegosPlaytime);
                Estadisticas.mostrarMilDatos(
                    juegosOrdenados,
                    "1000 DATOS ANTES DE APLICAR QUICK SORT"
            );

                QuickSort.mostrarExplicacion();
                long inicio = System.currentTimeMillis();
                QuickSort.ordenarPorPlaytime(juegosOrdenados);
                long fin = System.currentTimeMillis();

                Estadisticas.mostrarMilDatos(
                    juegosOrdenados,
                    "1000 DATOS DESPUES DE APLICAR QUICK SORT"
            );
                break;
            case 2:
                System.out.println("En mantenimiento");
                break;
            case 3:
                sq.imprimirReporte();
                break;
            case 4:
                AnalisisEstadistico.top10Juegos(juegos);
                break;
            case 5:
                // Obtiene la lista de juegos con su playtime desde el lector
                // Se usa una copia para no modificar la lista original al ordenar
                List<Juego> juegosTop = new ArrayList<>(juegosPlaytime);
                // Ordena la lista de menor a mayor playtime usando QuickSort
                QuickSort.ordenarPorPlaytime(juegosTop);
                // Muestra los 20 juegos con mayor playtime
                Estadisticas.mostrarTop20(juegosTop);
                break;
            case 6:
                System.out.println("En mantenimiento");
                break;
            case 7:
                System.out.println("Saliendo del programa");
                break;
            default:
                System.out.println("Ingrese una opcion valida");
                }
            } while (opcion != 7);
        }
}
