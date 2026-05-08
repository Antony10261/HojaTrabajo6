import java.util.*;

public class Inventario {

    private Map<String, String> productos;
    private Map<String, Integer> carrito = new HashMap<>();

    public Inventario(Map<String, String> map) {
        this.productos = map;
    }

    // cargar archivo
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

    // mostrar inventario completo
    public void mostrarInventario() {
        for (String producto : productos.keySet()) {
            System.out.println(producto + " - " + productos.get(producto));
        }
    }

    // agregar producto al carrito
    public void agregarProducto(String categoria) {
        boolean encontrado = false;

        for (String producto : productos.keySet()) {
            if (productos.get(producto).equalsIgnoreCase(categoria)) {

                carrito.put(producto, carrito.getOrDefault(producto, 0) + 1);
                System.out.println("Producto agregado: " + producto);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Categoria no encontrada");
        }
    }

    // buscar categoria de producto
    public void buscarCategoria(String producto) {
        if (productos.containsKey(producto)) {
            System.out.println("Categoria: " + productos.get(producto));
        } else {
            System.out.println("Producto no encontrado");
        }
    }

    public void mostrarCarrito() {

        if (carrito.isEmpty()) {
            System.out.println("No hay productos en la colección.");
            return;
        }

        System.out.println("\nProductos en tu colección:");

        for (String producto : carrito.keySet()) {
            String categoria = productos.get(producto);
            int cantidad = carrito.get(producto);

            System.out.println(producto + " | " + categoria + " | Cantidad: " + cantidad);
        }
    }
}