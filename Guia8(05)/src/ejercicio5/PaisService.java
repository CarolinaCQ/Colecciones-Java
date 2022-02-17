/*
Se requiere un programa que lea y guarde países, y para evitar que se ingresen
repetidos usaremos un conjunto. El programa pedirá un país en un bucle, se
guardará el país en el conjunto y después se le preguntará al usuario si quiere
guardar otro país o si quiere salir, si decide salir, se mostrará todos los países
guardados en el conjunto.
Después deberemos mostrar el conjunto ordenado alfabéticamente para esto
recordar como se ordena un conjunto.
Y por ultimo, al usuario se le pedirá un país y se recorrerá el conjunto con un Iterator,
se buscará el país en el conjunto y si está en el conjunto se eliminará el país que
ingresó el usuario y se mostrará el conjunto. Si el país no se encuentra en el conjunto
se le informará al usuario.
 */
package ejercicio5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class PaisService {
    private Scanner entrada;
    private HashSet<Pais> conjuntoPais;

    public PaisService() {
        this.entrada = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
        this.conjuntoPais = new HashSet<>();
    }
    
    public void procesoPincipal(){
        
        String opcion;
        do {
            System.out.println("Desea ingresar un país? SI/NO");
            opcion = entrada.next();
            opcion = opcion.toUpperCase();
            
            switch (opcion){
                case "SI":
                    this.ingresarDatosPais();
                    break;
                case "NO":
                    System.out.println("Se ha completado con éxito!");
                    break;
                default:
                    System.out.println("ERROR! Ingrese una opción válida");
            }
        } while(!opcion.equalsIgnoreCase("NO"));
        
        this.mostrarConjuntoPais();
        
        this.ordenarAlfabeticamente();
        
        this.procesoAdicionalEliminacion();
        
    }
    
    public void procesoAdicionalEliminacion(){
        String opcion;
        do {
            System.out.println("Desea eliminar un país? SI/NO");
            opcion = entrada.next();
            opcion = opcion.toUpperCase();
            
            switch (opcion){
                case "SI":
                    this.eliminarPais();
                    break;
                case "NO":
                    System.out.println("Ha concluido con éxito!");
                    break;
                default:
                    System.out.println("ERROR! Ingrese una opción válida");
            }
        } while(!opcion.equalsIgnoreCase("NO"));
    }
    
    public void ingresarDatosPais(){
        System.out.println("Ingrese el nombre del País");
        String nombrePais = entrada.next();
        nombrePais = nombrePais.toUpperCase();
        
        this.crearPais(nombrePais);
    }
    
    public void crearPais(String nombrePais){
        Pais pais = new Pais();
        
        pais.setNombrePais(nombrePais);
        
        this.agregarPais(pais);
    }
    
    public void agregarPais(Pais pais){
        if (conjuntoPais.add(pais)){
            System.out.println("Se ha agregado correctamente el país!");
        } else {
            System.out.println("ERROR! Es un país duplicado, no se puede agregar");
        }
        
    }
    
    public void mostrarConjuntoPais(){
        for (Pais elemento: conjuntoPais){
            System.out.println(elemento);
        }
    }
    
    public void ordenarAlfabeticamente(){
        System.out.println("Lista de Paises ordenado alfabeticamente");
        ArrayList<Pais> listPais = new ArrayList (conjuntoPais);
        listPais.sort(Pais.compararNombre);
        this.mostrarAlfabeticamente(listPais);
    }
    
    public void mostrarAlfabeticamente(ArrayList<Pais> listPais){
        for (Pais elemento: listPais){
            System.out.println(elemento);
        }
    }
    
    public String paisBuscar(){
        System.out.println("Ingrese un país para buscar en el conjunto y eliminarlo");
        String paisBuscar = entrada.next().toUpperCase();
        return paisBuscar;
    }
    
    public void eliminarPais(){
        String paisEliminar = this.paisBuscar();
        
        Iterator<Pais> it = conjuntoPais.iterator();
        boolean noExiste = true;
        while (it.hasNext()){
            if (it.next().getNombrePais().equals(paisEliminar)){
                it.remove();
                System.out.println("El país se ha eliminado correctamente.");
                noExiste = false; 
            }
        }
        if (noExiste){
            System.out.println("ERROR! El país no se encontró dentro del conjunto.");
        }
        
    }
    
}
