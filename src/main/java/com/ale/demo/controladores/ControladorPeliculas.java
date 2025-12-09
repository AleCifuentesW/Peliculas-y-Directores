package com.ale.demo.controladores;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorPeliculas{
    //Agrega el siguiente atributo que contiene un HashMap para almacenar películas y sus respectivos directores:
    private static HashMap<String, String> listaPeliculas = new HashMap<String, String>();
    //Ahora agrega el siguiente constructor que se encarga de llenar el HashMap con información de prueba de películas y sus directores:
    public ControladorPeliculas() {
	    listaPeliculas.put("Winnie the Pooh", "Don Hall");	
	    listaPeliculas.put("El zorro y el sabueso", "Ted Berman");
	    listaPeliculas.put("Tarzán", "Kevin Lima");		
	    listaPeliculas.put("Mulán", "Barry Cook");
	    listaPeliculas.put("Oliver", "Kevin Lima");	
	    listaPeliculas.put("Big Hero 6", "Don Hall");	
    }
    //Implementa los siguientes métodos:
    //obtenerTodasLasPeliculas(): Método que responde a la ruta /peliculas y retorna un string con la lista de todas las películas disponibles.
    @GetMapping("/peliculas")
    public String obtenerTodasLasPeliculas(){
        StringBuilder sb= new StringBuilder("Peliculas disponibles:\n");

        for (Map.Entry<String, String> entry : listaPeliculas.entrySet()){
            String pelicula= entry.getKey();
            String director= entry.getValue();
            sb.append("- ").append(pelicula)
              .append(" (Director: ").append(director).append(")\n");      
        }
        return sb.toString();
    }
    //obtenerPeliculaPorNombre(): Método que responde a la ruta /peliculas/{nombre} y retorna la información de una película específica, devuelve el nombre de la película y su director. En caso de que la película no exista en la lista devolver un mensaje como el siguiente:  «La película no se encuentra en nuestra lista.»
    @GetMapping("/peliculas/{nombre}")
    public String obtenerPeliculaPorNombre(@PathVariable String nombre){
        String director= listaPeliculas.get(nombre);

        if(director == null){
            return "La película no se encuentra en nuestra lista.";
        }
        return "Película: " + nombre + " y Director: " + director;
    }
    //obtenerPeliculasPorDirector(): Método que responde a la ruta /peliculas/director/{nombre} y retorna un string con la lista de todas las películas que tienen ese director asignado. En caso de que el director no exista en la lista devolver un mensaje como el siguiente: «No contamos con películas con ese director en nuestra lista.»
    @GetMapping("/peliculas/director/{nombre}")
    public String obtenerPeliculasPorDirector(@PathVariable String nombre){
        String peliculas= listaPeliculas.entrySet().stream()
            .filter(entry -> entry.getValue().equalsIgnoreCase(nombre))
            .map(Map.Entry::getKey)
            .collect(Collectors.joining(", "));
        
        if(peliculas.isEmpty()){
            return "No contamos con películas con ese director en nuestra lista.";
        }
        return "Películas dirigidas por " + nombre + ": " + peliculas;
    }


}
