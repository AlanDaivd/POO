package modelo;

import java.util.Scanner;

public class Tienda {
    private static PantalonVestir pantalonVestir;
    private static PantalonMezclilla pantalonMezclilla;
    private static Camisa camisa;
    private static Falda falda;
    private static Blusa blusa;
    private static Playera playera;

    public static void main(String[] args) {
        
        pantalonVestir = new PantalonVestir("Masculino", "Mediano", 300.0, 450.0);
        pantalonMezclilla = new PantalonMezclilla("Masculino", "Mediano", 350.0, 500.0);
        camisa = new Camisa("Masculino", "Mediano", 200.0, 350.0);
        falda = new Falda("Mediano", 150.0, 250.0);
        blusa = new Blusa("Mediano", 100.0, 200.0);
        playera = new Playera("Femenino", "Mediano", 190.0, 300.0);

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("1. Mostrar artículos");
            System.out.println("2. Comprar");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                	
                    mostrarArticulos();
                    break;
                case 2:
                    comprarArticulo();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (opcion != 3);

        scanner.close();
    }

    private static void mostrarArticulos() {
    	System.out.println("Prenda | Tamaño | Cantidad | Precio Compra | Precio venta");
        System.out.println("Pantalón de Vestir: " + pantalonVestir);
        System.out.println("Pantalón de Mezclilla: " + pantalonMezclilla);
        System.out.println("Camisa: " + camisa);
        System.out.println("Falda: " + falda);
        System.out.println("Blusa: " + blusa);
        System.out.println("Playera: " + playera);
    }

    private static void comprarArticulo() {
        Scanner scanner = new Scanner(System.in);
        double totalCompra = 0.0;

        do {
            
            System.out.println("Artículos disponibles:");
            System.out.println("1. Pantalón de Vestir");
            System.out.println("2. Pantalón de Mezclilla");
            System.out.println("3. Camisa");
            System.out.println("4. Falda");
            System.out.println("5. Blusa");
            System.out.println("6. Playera");
            System.out.println("7. Calcular total");
            System.out.println("0. Terminar");            
            int opcionArticulo = scanner.nextInt();

            if (opcionArticulo == 7) {
                System.out.println("Total de la compra: $" + totalCompra);
                continue;
            }

            if (opcionArticulo == 0) {
                break;
            }

            System.out.print("Ingrese la cantidad de artículos que desea comprar: ");
            int cantidad = scanner.nextInt();
            switch (opcionArticulo) {
                case 1:
                    totalCompra += comprarPantalonVestir(cantidad);
                    break;
                case 2:
                    totalCompra += comprarPantalonMezclilla(cantidad);
                    break;
                case 3:
                    totalCompra += comprarCamisa(cantidad);
                    break;
                case 4:
                    totalCompra += comprarFalda(cantidad);
                    break;
                case 5:
                    totalCompra += comprarBlusa(cantidad);
                    break;
                case 6:
                    totalCompra += comprarPlayera(cantidad);
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (true); 

        System.out.println("Total de la compra: $" + totalCompra);
        scanner.close();
    }

    
    private static double comprarPantalonVestir(int cantidad) {
        if (cantidad > pantalonVestir.getInventario()) {
            System.out.println("Lo siento, no hay suficiente inventario disponible para la compra.");
            return 0.0;
        }

        double precioTotal = cantidad * pantalonVestir.getPrecioVenta();
        pantalonVestir.setInventario(pantalonVestir.getInventario() - cantidad);

        System.out.println("Compra realizada con éxito:");
        System.out.println("Artículo: Pantalón de Vestir");
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio total: $" + precioTotal);
        
        return precioTotal;
    }

    private static double comprarPantalonMezclilla(int cantidad) {
        if (cantidad > pantalonMezclilla.getInventario()) {
            System.out.println("Lo siento, no hay suficiente inventario disponible para la compra.");
            return 0.0;
        }
        double precioTotal = cantidad * pantalonMezclilla.getPrecioVenta();
        pantalonMezclilla.setInventario(pantalonMezclilla.getInventario() - cantidad);
        System.out.println("Compra realizada con éxito:");
        System.out.println("Artículo: Pantalón de Mezclilla");
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio total: $" + precioTotal);
        
        return precioTotal;
    }

    private static double comprarCamisa(int cantidad) {
        if (cantidad > camisa.getInventario()) {
            System.out.println("Lo siento, no hay suficiente inventario disponible para la compra.");
            return 0.0;
        }
        double precioTotal = cantidad * camisa.getPrecioVenta();
        camisa.setInventario(camisa.getInventario() - cantidad);

        System.out.println("Compra realizada con éxito:");
        System.out.println("Artículo: Camisa");
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio total: $" + precioTotal);
        
        return precioTotal;
    }
    
    private static double comprarFalda(int cantidad) {
        if (cantidad > falda.getInventario()) {
            System.out.println("Lo siento, no hay suficiente inventario disponible para la compra.");
            return 0.0;
        }
        double precioTotal = cantidad * falda.getPrecioVenta();
        falda.setInventario(falda.getInventario() - cantidad);
        System.out.println("Compra realizada con éxito:");
        System.out.println("Artículo: Falda");
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio total: $" + precioTotal);
        
        return precioTotal;
    }

    private static double comprarBlusa(int cantidad) {
        if (cantidad > blusa.getInventario()) {
            System.out.println("Lo siento, no hay suficiente inventario disponible para la compra.");
            return 0.0;
        }
        double precioTotal = cantidad * blusa.getPrecioVenta();
        blusa.setInventario(blusa.getInventario() - cantidad);
        System.out.println("Compra realizada con éxito:");
        System.out.println("Artículo: Blusa");
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio total: $" + precioTotal);
    
        return precioTotal;
    }

    private static double comprarPlayera(int cantidad) {
        if (cantidad > playera.getInventario()) {
            System.out.println("Lo siento, no hay suficiente inventario disponible para la compra.");
            return 0.0;
        }
        double precioTotal = cantidad * playera.getPrecioVenta();
        playera.setInventario(playera.getInventario() - cantidad);
        System.out.println("Compra realizada con éxito:");
        System.out.println("Artículo: Playera");
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio total: $" + precioTotal);
        
        return precioTotal;
    }


    
    
}
