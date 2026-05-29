package com.mycompany.proyecto_eda;

import java.util.ArrayList;

public class MergeSort {

    // Divide recursivamente la lista en mitades hasta tener elementos individuales
    public static void sort(ArrayList<Juego> lista, int inicio, int fin) {
        if (inicio < fin) {
            int medio = (inicio + fin) / 2; // Punto de división de la lista
            sort(lista, inicio, medio);     // Punto de división de la lista
            sort(lista, medio + 1, fin);    // Ordenar mitad derecha
            merge(lista, inicio, medio, fin);// Fusionar ambas mitades ordenadas
        }
    }

    // Fusiona dos sublistas ordenadas en una sola, de mayor a menor metacritic
    private static void merge(ArrayList<Juego> lista, int inicio, int medio, int fin) {
        
        // Copiar los elementos de cada mitad en sublistas temporales
        ArrayList<Juego> izquierda = new ArrayList<>();
        ArrayList<Juego> derecha = new ArrayList<>();

        for (int i = inicio; i <= medio; i++)
            izquierda.add(lista.get(i));
        for (int i = medio + 1; i <= fin; i++)
            derecha.add(lista.get(i));

        int i = 0, j = 0, k = inicio;

        // Comparar elemento a elemento y colocar el mayor primero
        while (i < izquierda.size() && j < derecha.size()) {
            //De mayor a menor:
            if (izquierda.get(i).getMetacritic() >= derecha.get(j).getMetacritic()) {
                lista.set(k++, izquierda.get(i++));// El de la izquierda es mayor o igual
            } else {
                lista.set(k++, derecha.get(j++));   // El de la derecha es mayor
            }
        }

        // Vaciar los elementos restantes de cada sublista
        while (i < izquierda.size()) lista.set(k++, izquierda.get(i++));
        while (j < derecha.size()) lista.set(k++, derecha.get(j++));
    }
    public static void mostrarExplicacion() {
    System.out.println("\n========================================================");
    System.out.println("               ALGORITMO: MERGE SORT                      ");
    System.out.println("========================================================╝");
    System.out.println("  Merge Sort aplica el principio de 'Divide y Vencerás'");
    System.out.println("  PASOS:");
    System.out.println("  1. DIVIDIR");
    System.out.println("         Se divide la lista en dos mitades recursivamente");
    System.out.println("         hasta que cada sublista tenga un solo elemento.");
    System.out.println("         [92, 45, 78, 96] → [92,45] [78,96] → [92][45][78][96]");
    System.out.println("  2. COMPARAR");
    System.out.println("         Cada elemento individual se compara con su par.");
    System.out.println("         [92][45] → ¿92 >= 45? Si → [92, 45]");
    System.out.println("  3. MEZCLAR (MERGE)");
    System.out.println("         Las sublistas ordenadas se fusionan comparando");
    System.out.println("         elemento a elemento hasta reconstruir la lista.");
    System.out.println("         [92,45] + [96,78] → [96, 92, 78, 45]");
    System.out.println("  4. RESULTADO");
    System.out.println("         La lista queda ordenada de MAYOR a MENOR por Metacritic.");
    System.out.println("  MEMORIA EXTRA: O(n) — usa sublistas temporales en cada merge");
    System.out.println("========================================================");
    System.out.println();
}
}