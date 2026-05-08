import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Seleccione tipo de Map:");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");

        int opcion = sc.nextInt();

        Map<String, String> mapa = MapFactory.getMap(opcion);
        Inventario inv = new Inventario(mapa);

        inv.cargarArchivo("inventario.txt");

        System.out.println("\nInventario cargado:");
        inv.mostrarInventario();

        int opcion2 = 0;

        // menú continuo
        while (opcion2 != 4) {

            System.out.println("\n--- MENU ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Buscar categoria");
            System.out.println("3. Mostrar coleccion");
            System.out.println("4. Mostrar coleccio5n ordenada");
            System.out.println("5. Mostrar inventario");
            System.out.println("6. Mostrar inventario ordenado");
            System.out.println("7. Salir");
            opcion2 = sc.nextInt();
            sc.nextLine();

            if (opcion2 == 1) {
                System.out.println("Ingrese categoria:");
                String cat = sc.nextLine();
                inv.agregarProducto(cat);
            }            
            else if (opcion2 == 2) {
                System.out.println("Ingrese producto:");
                String prod = sc.nextLine();
                inv.buscarCategoria(prod);
            } 
            else if (opcion2 == 3) {
                inv.mostrarCarrito();
            } 
            else if (opcion2 == 4) {
                inv.mostrarCarritoOrdenado();
            } 
            else if (opcion2 == 5) {

                long inicio = System.nanoTime();

                inv.mostrarInventario();

                long fin = System.nanoTime();

                System.out.println("Tiempo de ejecucion: " + (fin - inicio) + " ns");
            }
            else if (opcion2 == 6) {

                long inicio = System.nanoTime();

                inv.mostrarInventarioOrdenado();

                long fin = System.nanoTime();

                System.out.println("Tiempo de ejecucion: " + (fin - inicio) + " ns");
            }
            else if (opcion2 == 7) {
                System.out.println("Saliendo del programa...");
                break; // 🔥 ESTO ES LA CLAVE
            }           
            else {
                System.out.println("Opción inválida");
            }
        }
    }     
}