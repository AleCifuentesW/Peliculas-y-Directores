Películas y Directores (Core)
Objetivos

Comprender y aplicar el concepto de rutas con variables de rutas en una aplicación de Spring Boot.
Practicar la creación de controladores en la aplicación de Spring Boot.
 

Desarrollar una aplicación en Spring Boot que permita buscar información sobre productos utilizando variables de ruta.

 

Requerimientos

Crea un nuevo proyecto e llamado peliculas_y_directores.
Asigna el paquete base com.tunombre para que ahí se cree el archivo principal de la aplicación.
Agrega un paquete para tus controladores: com.tunombre.controladores.
Dentro de ese nuevo paquete agrega una clase llamada ControladorPeliculas.java
Agrega el siguiente atributo que contiene un HashMap para almacenar películas y sus respectivos directores:
private static HashMap<String, String> listaPeliculas = new HashMap<String, String>();
Ahora agrega el siguiente constructor que se encarga de llenar el HashMap con información de prueba de películas y sus directores:
public ControladorPeliculas() {
	listaPeliculas.put("Winnie the Pooh", "Don Hall");	
	listaPeliculas.put("El zorro y el sabueso", "Ted Berman");
	listaPeliculas.put("Tarzán", "Kevin Lima");		
	listaPeliculas.put("Mulán", "Barry Cook");
	listaPeliculas.put("Oliver", "Kevin Lima");	
	listaPeliculas.put("Big Hero 6", "Don Hall");	
}
Implementa los siguientes métodos:
obtenerTodasLasPeliculas(): Método que responde a la ruta /peliculas y retorna un string con la lista de todas las películas disponibles.
obtenerPeliculaPorNombre(): Método que responde a la ruta /peliculas/{nombre} y retorna la información de una película específica, devuelve el nombre de la película y su director. En caso de que la película no exista en la lista devolver un mensaje como el siguiente:  «La película no se encuentra en nuestra lista.»
obtenerPeliculasPorDirector(): Método que responde a la ruta /peliculas/director/{nombre} y retorna un string con la lista de todas las películas que tienen ese director asignado. En caso de que el director no exista en la lista devolver un mensaje como el siguiente: «No contamos con películas con ese director en nuestra lista.»
Ejecuta la aplicación utilizando Spring Boot. Asegúrate de que la aplicación se ejecuta sin errores.
Utiliza un navegador web o una herramienta como Postman para acceder a las rutas y verificar que cada una retorne la información esperada.
