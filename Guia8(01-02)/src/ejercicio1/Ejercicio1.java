/*
1. Diseñar un programa que lea y guarde razas de perros en un ArrayList de tipo String.
El programa pedirá una raza de perro en un bucle, el mismo se guardará en la lista y
después se le preguntará al usuario si quiere guardar otro perro o si quiere salir. Si
decide salir, se mostrará todos los perros guardados en el ArrayList.

2. Continuando el ejercicio anterior, después de mostrar los perros, al usuario se le
pedirá un perro y se recorrerá la lista con un Iterator, se buscará el perro en la lista.
Si el perro está en la lista, se eliminará el perro que ingresó el usuario y se mostrará
la lista ordenada. Si el perro no se encuentra en la lista, se le informará al usuario y
se mostrará la lista ordenada.
 */
package ejercicio1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);

        ArrayList<String> razaPerros = new ArrayList<>();

        int opcion;

        do {
            System.out.println("Ingrese una raza de Perro: ");
            String raza = entrada.next();
            razaPerros.add(raza);
            System.out.println("Elija una opcion: ");
            System.out.println("1) Agregar otra raza");
            System.out.println("2) Salir");
            opcion = entrada.nextInt();
        } while (opcion != 2);

        for (String elemento : razaPerros) {
            System.out.println("Las razas de perro son: ");
            System.out.println(elemento);
        }

        System.out.println("Ingrese una raza a remover: ");
        String razaBuscar = entrada.next();
        
        Iterator<String> it = razaPerros.iterator();
        boolean vF = true;
        while (it.hasNext()) {
            if (it.next().equals(razaBuscar)){
            it.remove();
            vF = false;
            }
        }
        
        if (vF){
            System.out.println("No se encontró la raza");
        }
        
        System.out.println("Las razas de perro son: ");
        for (String elemento : razaPerros) {
            System.out.println(elemento);
        }

    }

}
