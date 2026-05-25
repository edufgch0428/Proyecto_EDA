/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_eda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.*;


/**
 *
 * @author mateo
 */
public class LectorCSV {
    //Se crea la variable donde se guardará la ruta 
    private final String rutaArchivo;
    
    public LectorCSV(String rutaArchivo){
        this.rutaArchivo = rutaArchivo;
    }
    
    public List<Integer> leerIds() throws IOException{ //throws IOException nos advierte que puede fallar  
        List<Integer> ids = new ArrayList<>(); //Se crea un ArrayList para guardar los ids  
        //FileReader lee directamente el archivo desde el sistema
        try(BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))){ //BufferedReader lee texto desde una fuente de entrada
            
            br.readLine(); //Se encarga de leer las lineas de cada texto 
            
            String linea; 
            
            while((linea = br.readLine()) != null) { //del br.readLine() lee cada linea asignandolo a la variable linea y sale del while cuando no haya nada
                if(linea.isBlank()) continue; //Si la linea tiene vacios o esta en blanco, continua
                
            try {
                //Extrae solamente el id de cada linea de la base de datos
                String[] corte = linea.split(",", 2); // metodo split corta la funcion o la divide un texto en partes y las organiza
                ids.add(Integer.valueOf(corte[0].trim()));
            } catch (NumberFormatException e) {
                // Fila con formato invalido, se omite y continua con la siguiente
                continue;
            }    
            }
            
        }
        return ids;
        
    }
    
    public List<Juego> leerJuegosPlaytime() throws IOException {

    List<Juego> juegos = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(
        new InputStreamReader(new FileInputStream(rutaArchivo), "UTF-8"))) {
        
        br.readLine();
        String linea;

        while ((linea = br.readLine()) != null) {

            if (linea.isBlank()) continue;

            try {
                String[] datos = linea.split(",");

                String nombre = datos[2].trim();
                double playtime = Double.parseDouble(datos[10].trim());

                juegos.add(new Juego(nombre, playtime));

            } catch (Exception e) {
                continue;
            }
        }
    }

    return juegos;
}
}
