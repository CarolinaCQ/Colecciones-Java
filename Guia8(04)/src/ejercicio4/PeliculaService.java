/*
Un cine necesita implementar un sistema en el que se puedan cargar peliculas. Para
esto, tendremos una clase Pelicula con el titulo, director y duración de la película (en
horas). Implemente las clases y métodos necesarios para esta situación, teniendo en
cuenta lo que se pide a continuación:

19
En el main deberemos tener un bucle que crea un objeto Pelicula pidiéndole al
usuario todos sus datos y guardándolos en el objeto Pelicula.
Después, esa Pelicula se guarda una lista de Peliculas y se le pregunta al usuario si
quiere crear otra Pelicula o no.
Después de ese bucle realizaremos las siguientes acciones:
• Mostrar en pantalla todas las películas.
• Mostrar en pantalla todas las películas con una duración mayor a 1 hora.
• Ordenar las películas de acuerdo a su duración (de mayor a menor) y mostrarlo
en pantalla.
• Ordenar las películas de acuerdo a su duración (de menor a mayor) y mostrarlo
en pantalla.
• Ordenar las películas por titulo, alfabéticamente y mostrarlo en pantalla.
• Ordenar las películas por director, alfabéticamente y mostrarlo en pantalla.
 */
package ejercicio4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class PeliculaService {
    private ArrayList<Pelicula> arrayPeliculas;
    private Scanner entrada;

    
    public PeliculaService() {
        this.arrayPeliculas = new ArrayList<>();
        this.entrada = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
    }
    
    public void procesoPrincipal(){
        String opcion;
        do{
            
            System.out.println("Desea ingresar una película? SI/NO");
            opcion = entrada.next();
            opcion = opcion.toUpperCase();
            
            switch (opcion){
                case "SI":
                    this.ingresarDatosPelicula();
                    break;
                case "NO":
                    System.out.println("Se ha completado con éxito!");
                    break;
                default:
                    System.out.println("ERROR! Ingrese una opción válida");
            }
        } while (!opcion.equalsIgnoreCase("NO"));
    }
    
    public void mostrarPeliculas(){
        int opcion;
        do{
            
            System.out.println("Elija la acción que desea realizar: ");
            System.out.println("1) Mostrar la totalidad de las películas");
            System.out.println("2) Mostrar las películas con una duración mayor a una hora");
            System.out.println("3) Mostrar las películas ordenadas por criterio de duración, de mayor a menor");
            System.out.println("4) Mostrar las películas ordenadas por criterio de duración, de menor a menor");
            System.out.println("5) Mostrar las películas ordenadas albabeticamente por el título");
            System.out.println("6) Mostrar las películas ordenadas albabeticamente por el director");
            System.out.println("7) Salir");
            opcion = entrada.nextInt();
            
            
            switch (opcion){
                case 1:
                    this.mostrarTodasPeliculas();
                    break;
                case 2:
                    this.mostrarPeliculaMayorHora();
                    break;
                case 3:
                    this.ordenarDuracionMayorMenor();
                    break;
                case 4:
                    this.ordenarDuracionMenorMayor();
                    break;
                case 5:
                    this.ordenarTitulo();
                    break;
                case 6:
                    this.ordenarDirector();
                    break;
                case 7:
                    System.out.println("Ha salido correctamente del programa");
                    break;
                default:
                    System.out.println("ERROR! Ingrese una opción válida");
            }
        } while (opcion!=7);
    }
    
    public void ingresarDatosPelicula(){
        System.out.println("Ingresar los datos de las películas");
        System.out.println("a) Autor de la película: ");
        String titulo = entrada.next();
        System.out.println("b) Director de la pelicula: ");
        String director = entrada.next();
        System.out.println("c) Duración de la pelicula: ");
        double duracion = entrada.nextDouble();
        
        this.crearPelicula(titulo,director,duracion);
    }
    
    
    public void crearPelicula(String titulo, String director, double duracion){
        
        
        Pelicula pelicula = new Pelicula();
        
        
        pelicula.setTitulo(titulo);
        pelicula.setDirector(director);
        pelicula.setDuracion(duracion);
        
        this.agregarPelicula(pelicula);
        
    }
    
    public void agregarPelicula (Pelicula pelicula) {
        arrayPeliculas.add(pelicula);
    }
    
    public void mostrarTodasPeliculas(){
        System.out.println("El listado completo de películas es: ");
        for (Pelicula elemento: arrayPeliculas){
            System.out.println(elemento);
        }
    }
    
    public void visualizarPeliculas(){
        for (Pelicula elemento: arrayPeliculas){
            System.out.println(elemento);
        }
    }
    
    public void mostrarPeliculaMayorHora(){
        System.out.println("El listado de las películas que tienen una duración mayor a una hora es: ");
        for (int i=0; i<arrayPeliculas.size(); i++){
            if(arrayPeliculas.get(i).getDuracion()>1){
                System.out.println(arrayPeliculas.get(i));
            }
        }
    }
    
    public void ordenarDuracionMayorMenor(){
        System.out.println("El listado de películas ordenado por duración de mayor a menor es: ");
        Collections.sort(arrayPeliculas);
        this.visualizarPeliculas();
    }
    
    public void ordenarDuracionMenorMayor(){
        System.out.println("El listado de películas ordenado por duración de menor a mayor es: ");
        Collections.sort(arrayPeliculas, Collections.reverseOrder());
        this.visualizarPeliculas();
    }
    
    public void ordenarTitulo(){
        System.out.println("El listado de películas ordenado alfabeticamente por título: ");
        arrayPeliculas.sort(Pelicula.compararAlfabeticamenteTitulo);
        this.visualizarPeliculas();
    }
    
    public void ordenarDirector(){
        System.out.println("El listado de películas ordenado alfabeticamente por título: ");
        arrayPeliculas.sort(Pelicula.compararAlfabeticamenteDirector);
        this.visualizarPeliculas();
    }
    
    
    
}
