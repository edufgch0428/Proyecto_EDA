package com.mycompany.proyecto_eda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mateo
 */
public class LectorCSV {
 
    private final String rutaArchivo; // Ruta del archivo CSV
    private ArrayList<Integer>   ids    = new ArrayList<>(); // Lista de IDs para el hashing
    private ArrayList<String[]>  juegos = new ArrayList<>(); // Lista de [name, owned] para el analisis
    private ArrayList<Juego> juegosPlaytime = new ArrayList<>(); // Lista de objetos Juego con nombre y playtime para QuickSort y Estadisticas
    private ArrayList<Juego> juegosMetacritic = new ArrayList<>(); // Lista para guardar Metacritic y nombre para realizar merge sort
    public LectorCSV(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }
    /**
    * Parsea una línea del CSV respetando comas dentro de comillas dobles.
    * Retorna un arreglo con cada campo separado y sin espacios extremos.
    */
    private String[] parsearLinea(String linea) {
       List<String> campos = new ArrayList<>();
       StringBuilder campo = new StringBuilder();
       boolean dentroComillas = false;

       for (char c : linea.toCharArray()) {
           if (c == '"') {
               dentroComillas = !dentroComillas;
           } else if (c == ',' && !dentroComillas) {
               campos.add(campo.toString().trim());
               campo.setLength(0);
           } else {
               campo.append(c);
           }
       }
       campos.add(campo.toString().trim());
       return campos.toArray(new String[0]);
   }
    
    /**
     * Lee el CSV una sola vez y llena ambas listas.
     * Debe llamarse antes de usar getIds() o getJuegos().
     */
    public void leer() throws IOException { // throws IOException nos advierte que puede fallar
        // FileReader abre el archivo fisico desde el sistema
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) { // BufferedReader lee texto desde una fuente de entrada
 
            br.readLine(); // Salta la primera linea del CSV que es el encabezado (id, slug, name...)
 
            String linea;
 
            while ((linea = br.readLine()) != null) { // br.readLine() lee cada linea asignandola a la variable linea y sale del while cuando no haya nada
                if (linea.isBlank()) continue; // Si la linea tiene vacios o esta en blanco, continua
 
                try {
                    String[] campos = parsearLinea(linea); // metodo split divide el texto en partes usando la coma como separador
                    ids.add(Integer.valueOf(campos[0].trim()));                          // Extrae el ID columna 0 y lo añade
                    juegos.add(new String[]{campos[2].trim(), campos[campos.length - 5].trim()});      // Extrae nombre (col 2) y owned (col 22)
                    // Crea un objeto Juego con el nombre y el playtime
                    // Agrega a la lista para usarla en QuickSort y Estadisticas
                    juegosPlaytime.add(new Juego(campos[2].trim(), Double.parseDouble(campos[campos.length - 3].trim())));
                    // Si metacritic (índice 3) está vacío o es "Sin dato" se asigna 0,
                    // de lo contrario se convierte de Double a int. Luego se agrega
                    // un nuevo Juego con nombre y metacritic a la lista juegosMetacritic.
                    int metacritic = campos[3].trim().isEmpty() ? 0 : (int) Double.parseDouble(campos[3].trim());
                    juegosMetacritic.add(new Juego(campos[2].trim(), metacritic));
                } catch (Exception e) {
                    // Fila con formato invalido, se omite y continua con la siguiente
                    continue;
                }
            }
        }
    }
 
    //Retorna la lista de IDs para el hashing. 
    public ArrayList<Integer> getIds() { return ids; }
 
    //Retorna la lista de [name, owned] para el analisis estadistico.
    public ArrayList<String[]> getJuegos() { return juegos; }
    
    // Retorna la lista de objetos Juego con nombre y playtime para QuickSort y Estadisticas
    public ArrayList<Juego> getJuegosPlaytime() { return juegosPlaytime; }
    
    // Retorna la lista de objetos Juego con nombre y metacritic para MergeSort y Estadisticas
    public ArrayList<Juego> getJuegosMetacritic() { return juegosMetacritic; }
} 
    
