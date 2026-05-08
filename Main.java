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
            System.out.println("3. Mostrar colección");
            System.out.println("4. Salir");

            opcion2 = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            if (opcion2 == 1) {
                System.out.println("Ingrese categoria:");
                String cat = sc.nextLine();
                inv.agregarProducto(cat);

            } else if (opcion2 == 2) {
                System.out.println("Ingrese producto:");
                String prod = sc.nextLine();
                inv.buscarCategoria(prod);

            } else if (opcion2 == 3) {
                inv.mostrarCarrito();

            } else if (opcion2 == 4) {
                System.out.println("Saliendo...");
            } else {
                System.out.println("Opcion invalida");
            }
        }

        sc.close();
    }
}