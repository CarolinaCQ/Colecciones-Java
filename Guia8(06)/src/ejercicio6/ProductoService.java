/*
Se necesita una aplicación para una tienda en la cual queremos almacenar los
distintos productos que venderemos y el precio que tendrán. Además, se necesita
que la aplicación cuente con las funciones básicas.
Estas las realizaremos en el main. Como, introducir un elemento, modificar su precio,
eliminar un producto y mostrar los productos que tenemos con su precio (Utilizar
Hashmap). El HashMap tendrá de llave el nombre del producto y de valor el precio.
Realizar un menú para lograr todas las acciones previamente mencionadas.
 */
package ejercicio6;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class ProductoService {

    private HashMap<String, Double> mapProducto;
    private Scanner entrada;

    public ProductoService() {
        this.mapProducto = new HashMap();
        this.entrada = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
    }

    public void procesoPincipal() {

        String opcion;
        do {
            System.out.println("Elija la acción que desea realizar: ");
            System.out.println("a) Agregar un nuevo producto");
            System.out.println("b) Modificar el precio de un producto");
            System.out.println("c) Eliminar un producto");
            System.out.println("d) Mostrar los productos");
            System.out.println("e) Salir");
            opcion = entrada.next();
            opcion = opcion.toUpperCase();

            switch (opcion) {
                case "A":
                    System.out.println("Ingrese los datos del producto que desea agregar: ");
                    this.ingresarDatosProducto();
                    System.out.println("Se ha agregado con éxito el producto!");
                    break;
                case "B":
                    System.out.println("Ingrese el producto para modificar el precio: ");
                    this.modificarPrecio();
                    break;
                case "C":
                    System.out.println("Ingrese el producto que desea eliminar: ");
                    this.eliminarProducto();
                    break;
                case "D":
                    if (mapProducto.isEmpty()){
                        System.out.println("No existen productos para mostrar.");
                    } else {
                        System.out.println("Los productos guardados son: ");
                        this.mostrarProductos();
                    }
                    break;
                case "E":
                    System.out.println("Ha concluido correctamente!");
                    break;
                default:
                    System.out.println("ERROR! Ingrese una opción válida");
            }
        } while (!opcion.equalsIgnoreCase("E"));

    }

    public void ingresarDatosProducto() {
        System.out.println("a) Nombre del producto");
        String nombre = entrada.next().toUpperCase();

        System.out.println("b) Precio del producto");
        double precio = entrada.nextInt();

        this.crearProducto(nombre, precio);
    }

    public void crearProducto(String nombre, double precio) {
        Producto producto = new Producto();

        producto.setNombreProducto(nombre);
        producto.setPrecioProducto(precio);

        this.agregarProducto(producto);
    }

    public void agregarProducto(Producto producto) {
        mapProducto.put(producto.getNombreProducto(), producto.getPrecioProducto());
    }

    public void mostrarProductos() {
        for (Map.Entry<String, Double> entry : mapProducto.entrySet()) {
            System.out.println("Nombre del producto: " + entry.getKey() + " ,Precio del producto: " + entry.getValue());
        }
    }

    public String ingresarProductoBuscar() {
        String productoBuscar = entrada.next().toUpperCase();
        return productoBuscar;
    }

    public double ingresarPrecioActualizado() {
        System.out.println("Ingrese el precio actualizado");
        double precioActualizado = entrada.nextDouble();
        return precioActualizado;
    }

    public void modificarPrecio() {

        String productoBuscar = this.ingresarProductoBuscar();
        double precioActualizado = this.ingresarPrecioActualizado();

        if (mapProducto.containsKey(productoBuscar)) {
            mapProducto.replace(productoBuscar, precioActualizado);
            System.out.println("Se ha modificado correctamente el precio!");
        } else {
            System.out.println("El producto no existe!");
        }

    }

    public void eliminarProducto() {

        String productoBuscar = this.ingresarProductoBuscar();

        Iterator<Map.Entry<String, Double>> it = mapProducto.entrySet().iterator();
        boolean noEncuentra = true;
        while (it.hasNext()) {
            if (it.next().getKey().equalsIgnoreCase(productoBuscar)) {
                it.remove();
                System.out.println("Se ha eliminado correctamente.");
                noEncuentra = false;
            }
        }
        if (noEncuentra) {
            System.out.println("No se encontró el producto.");
        }

    }
}
