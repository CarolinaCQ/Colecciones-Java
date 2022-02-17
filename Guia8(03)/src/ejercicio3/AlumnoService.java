/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author carol
 */
public class AlumnoService {

    private ArrayList<Alumno> arrayAlumnos;
    private Scanner entrada;

    public AlumnoService() {
        this.arrayAlumnos = new ArrayList<>();
        this.entrada = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
    }
    
    public void procesoPrincipal(){
        String opcion;
        do{
            
            System.out.println("Desea ingresar un alumno? SI/NO");
            opcion = entrada.next();
            opcion = opcion.toUpperCase();
            
            switch (opcion){
                case "SI":
                    this.ingresarNombreNotas();
                    break;
                case "NO":
                    System.out.println("Se ha completado con éxito!");
                    break;
                default:
                    System.out.println("ERROR! Ingrese una opción válida");
            }
        } while (!opcion.equalsIgnoreCase("NO"));
        
        this.buscarNombre();
    }
    
    public void ingresarNombreNotas(){
        System.out.println("Ingrese el nombre del alumno");
        String nombre = entrada.next();
        
        System.out.println("Ingrese las notas de del alumno");
        System.out.println("Nota 1");
        double nota1 = entrada.nextDouble();
        System.out.println("Nota 2");
        double nota2 = entrada.nextDouble();
        System.out.println("Nota 3");
        double nota3 = entrada.nextDouble();
        
        crearAlumno(nombre, nota1, nota2, nota3);
    }

    public void crearAlumno(String nombre, double nota1, double nota2, double nota3) {

        Alumno alumno = new Alumno();
        ArrayList<Double> arrayNotas = new ArrayList();

        alumno.setNombre(nombre);

        arrayNotas.add(nota1);
        arrayNotas.add(nota2);
        arrayNotas.add(nota3);
        alumno.setListaNotas(arrayNotas);

        agregarAlumno(alumno);

    }

    public void agregarAlumno(Alumno alumno) {
        arrayAlumnos.add(alumno);
    }

    public void mostrarAlumnos() {
        for (Alumno elemento : arrayAlumnos) {
            System.out.println(elemento);
        }
    }

    public double notaFinal(Alumno alumno) {
        double suma = 0;
        for (int i=0; i<alumno.getListaNotas().size(); i++){
            suma += alumno.getListaNotas().get(i);
        }
        return suma/3;
    }
    
    public String ingresarNombreBuscar(){
        System.out.println("Ingrese un alumno del cual desea obtener la nota final");
        String nombreBuscar = entrada.next();
        return nombreBuscar;
    }

    public void buscarNombre() {
        
        String nombreBuscar = ingresarNombreBuscar();

        boolean noEncontro = true;
        for (int i=0; i<arrayAlumnos.size(); i++){
            if(arrayAlumnos.get(i).getNombre().equalsIgnoreCase(nombreBuscar)){
                String nombreAlumno = arrayAlumnos.get(i).getNombre();
                double notaFinal = notaFinal(arrayAlumnos.get(i));
                System.out.printf("La nota final del alumno %s es %.2f. \n", nombreAlumno, notaFinal );
                noEncontro = false;
            }
        }
        
        if (noEncontro){
            System.out.println("No se encontró el nombre del alumno");
        }
    }
}
