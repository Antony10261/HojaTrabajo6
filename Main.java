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
    }
}