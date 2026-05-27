/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_eda;

import java.util.Arrays;

/**
 *
 * @author mateo
 */
public class SondeoCuadratico {
    private static final int M = 40009; //Numero de celdas donde se guardarán los ids
    private static final int max_intentos = 5; //Limite de iteraciones al existir colisiones
    
    private String[] tabla = new String[M]; //Array donde se guardará los ids
    private int insertados = 0;  //Variable que guardara el numero de insertados
    private int overflow = 0;    //Variable que guardara el numero de ids que se quedaran afuera
    private int colisiones = 0;  //Variable donde se guardara el numero de colisiones 
    //Getters para leer las variables que estan en private
    public int getInsertados() {return insertados;}
    public int getOverflow() { return overflow;}
    public int getColisiones() {return colisiones;}
   
    //Primer hashing para convertir los ids y ubicarlos
    static int h1(int id){
        return id % M;
    }
    //Segundo hashing en caso de haber colision 
    static int h2 (int id, int i){
        return (h1(id) + i*i) % M;
    }
    //Metodo que insertara los id
    public void insertar(int id){
        boolean insertado = false; //Se pone en true cuando se inserta el dato 
        //Recorre hasta 5 veces al existir colision
        for(int i = 0; i < max_intentos;i++){
            int pos = h2(id, i);
            //If que va haciendo el conteo de insertados y colisiones, en cojunto de llenar la tabla
            if(tabla[pos] == null){
                tabla[pos] = String.valueOf(id);
                insertados++;
                insertado = true;
                break;
            }
            colisiones++;
        }
        if(!insertado) overflow++;
    }
    public String [] imprimirMilPrimeros(){
        System.out.println("====== 1000 PRIMEROS ID´S ORDENADOS ======");
        for(int i = 0; i < 1001; i++){
            if(tabla[i] != null){
                System.out.println("Posicion -> " + i + ", ID: " + tabla[i]);
            }
        }
        return tabla;
    }
    
    public void imprimirReporte() {
        System.out.println("============================================");
        System.out.println("       REPORTE - SONDEO CUADRATICO         ");
        System.out.println("============================================");
        System.out.printf("Tamanio de tabla (M)  : %,d%n",  M);
        System.out.printf("1000 primeros digitos ingresados \n", Arrays.toString(imprimirMilPrimeros()));
        System.out.printf("Elementos insertados  : %,d%n",  insertados);
        System.out.printf("Elementos en overflow : %,d%n",  overflow);
        System.out.printf("Colisiones totales    : %,d%n",  colisiones);
        System.out.println("============================================");
    }
    
}