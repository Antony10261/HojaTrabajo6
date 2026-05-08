import java.util.*;

public class Inventario {

    private Map<String, String> productos;

    public Inventario(Map<String, String> map) {
        this.productos = map;
    }

    // carga archivo
    public void cargarArchivo(String archivo) {
        try {
            Scanner sc = new Scanner(new java.io.File(archivo));

            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] partes = linea.split("\\|");

                if (partes.length == 2) {
                    String categoria = partes[0];
                    String producto = partes[1];

                    productos.put(producto, categoria);
                }
            }

            sc.close();

        } catch (Exception e) {
            System.out.println("Error leyendo archivo");
        }
    }

    public void mostrarInventario() {
        for (String producto : productos.keySet()) {
            System.out.println(producto + " - " + productos.get(producto));
        }
    }
}