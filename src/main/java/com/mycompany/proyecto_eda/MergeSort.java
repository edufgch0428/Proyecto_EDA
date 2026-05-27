package com.mycompany.proyecto_eda;

import java.util.ArrayList;

public class MergeSort {

    public static void sort(ArrayList<Juego> lista, int inicio, int fin) {
        if (inicio < fin) {
            int medio = (inicio + fin) / 2;
            sort(lista, inicio, medio);
            sort(lista, medio + 1, fin);
            merge(lista, inicio, medio, fin);
        }
    }

    private static void merge(ArrayList<Juego> lista, int inicio, int medio, int fin) {
        ArrayList<Juego> izquierda = new ArrayList<>();
        ArrayList<Juego> derecha = new ArrayList<>();

        for (int i = inicio; i <= medio; i++)
            izquierda.add(lista.get(i));
        for (int i = medio + 1; i <= fin; i++)
            derecha.add(lista.get(i));

        int i = 0, j = 0, k = inicio;

        while (i < izquierda.size() && j < derecha.size()) {
            int metaIzq = (izquierda.get(i).getMetacritic() != null) ? izquierda.get(i).getMetacritic() : 0;
            int metaDer = (derecha.get(j).getMetacritic() != null) ? derecha.get(j).getMetacritic() : 0;

            // Mayor a menor
            if (metaIzq >= metaDer) {
                lista.set(k++, izquierda.get(i++));
            } else {
                lista.set(k++, derecha.get(j++));
            }
        }

        while (i < izquierda.size()) lista.set(k++, izquierda.get(i++));
        while (j < derecha.size()) lista.set(k++, derecha.get(j++));
    }
}