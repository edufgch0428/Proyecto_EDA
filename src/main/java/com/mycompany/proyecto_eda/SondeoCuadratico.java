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
public class SondeoCuadratico {
 
    private static final int TAMANO_TABLA = 70003; // Numero primo escogido para la tabla hash
    private static final int MAX_INTENTOS = 5;     // Maximo de saltos cuadraticos permitidos
 
    private String[]          tabla        = new String[TAMANO_TABLA]; // Tabla hash, null = celda vacia
    private ArrayList<Integer> noInsertados = new ArrayList<>();       // IDs que no cupieron en la tabla
    private int insertados = 0;
    private int colisiones = 0;
 
    // Posicion inicial del elemento en la tabla
    static int hashAuxiliar(int num) {
        return num % TAMANO_TABLA;
    }
 
    // Posicion con sondeo cuadratico: (posInicial + salto²) % tamano
    // salto=0 -> sin colision, salto>0 -> hubo colision
    static int hashPrincipal(int num, int salto) {
        return (hashAuxiliar(num) + salto * salto) % TAMANO_TABLA;
    }
 
    // Inserta un ID aplicando sondeo cuadratico
    public void insertar(int num) {
        for (int salto = 0; salto < MAX_INTENTOS; salto++) {
            int pos = hashPrincipal(num, salto);
 
            if (tabla[pos] == null) {
                tabla[pos] = String.valueOf(num);
                insertados++;
                if (salto > 0) colisiones++;
                return;
            }
        }
        // No encontro celda libre en los 5 intentos -> guardar en lista de no insertados
        noInsertados.add(num);
    }
 
    // Busca un ID en la tabla con la misma logica de sondeo
    public boolean buscar(int num) {
        for (int salto = 0; salto < MAX_INTENTOS; salto++) {
            int pos = hashPrincipal(num, salto);
            if (tabla[pos] == null) return false;
            if (tabla[pos].equals(String.valueOf(num))) return true;
        }
        return false;
    }
 
    // Reporte final llamado desde el menu (case 3)
    public void imprimirReporte() {
        System.out.println("\n========== SONDEO CUADRATICO ==========");
        System.out.println("Tamano de tabla:    " + TAMANO_TABLA);
        System.out.println("IDs insertados:     " + insertados);
        System.out.println("IDs no insertados:  " + noInsertados.size());
        System.out.println("Colisiones:         " + colisiones);
 
        // Todos los elementos insertados en la tabla
        System.out.println("---------------------------------------");
        System.out.println("Elementos insertados en la tabla:");
        for (int i = 0; i < TAMANO_TABLA; i++) {
            if (tabla[i] != null) {
                System.out.println("  [" + i + "] = " + tabla[i]);
            }
        }
 
        // IDs que no se pudieron insertar
        System.out.println("---------------------------------------");
        System.out.println("IDs que NO fueron insertados:");
        for (int id : noInsertados) {
            System.out.println("  " + id);
        }
        System.out.println("=======================================");
    }
}