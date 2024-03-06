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
        
        pantalonVestir = new PantalonVestir("M/F", "M, CH, G, XG", 300.0);
        pantalonMezclilla = new PantalonMezclilla("M/F", "M, CH, G, XG", 350.0);
        camisa = new Camisa("M/F", "M, CH, G, XG", 200.0);
        falda = new Falda("F" + "M, CH, G, XG", 150.0);
        blusa = new Blusa("F" + "M, CH, G, XG", 100.0);
        playera = new Playera("M/F", "M, CH, G, XG", 190.0);

        Scanner leer = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Que quieres hacer?:");
            System.out.println("1. Mostrar artículos");
            System.out.println("2. Comprar");
            System.out.println("3. Salir");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    mostrarArticulos();
                    break;
                case 2:
                    comprarArticulo();
                    break;
                case 3:
                    System.out.println("Gracias or comprar aquí :)");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 3);

        leer.close();
    }

    private static void mostrarArticulos() {
        System.out.println("Prenda | Tamaño | Cantidad | Precio Compra");
        System.out.println("Pantalón de Vestir: " + pantalonVestir.getTamaño() + " | " + pantalonVestir.getInventario() + " | $" + pantalonVestir.getPrecioCompra());
        System.out.println("Pantalón de Mezclilla: " + pantalonMezclilla.getTamaño() + " | " + pantalonMezclilla.getInventario() + " | $" + pantalonMezclilla.getPrecioCompra());
        System.out.println("Camisa: " + camisa.getTamaño() + " | " + camisa.getInventario() + " | $" + camisa.getPrecioCompra());
        System.out.println("Falda: " + falda.getTamaño() + " | " + falda.getInventario() + " | $" + falda.getPrecioCompra());
        System.out.println("Blusa: " + blusa.getTamaño() + " | " + blusa.getInventario() + " | $" + blusa.getPrecioCompra());
        System.out.println("Playera: " + playera.getTamaño() + " | " + playera.getInventario() + " | $" + playera.getPrecioCompra());
    }

    private static void comprarArticulo() {
        Scanner leer = new Scanner(System.in);
        double totalCompra = 0.0;

        do {
            
            System.out.println("Artículos disponibles:");
            System.out.println("1. Pantalón de Vestir");
            System.out.println("2. Pantalón de Mezclilla");
            System.out.println("3. Camisa");
            System.out.println("4. Falda");
            System.out.println("5. Blusa");
            System.out.println("6. Playera");
            System.out.println("0. Terminar");            
            int opcionArticulo; 
            opcionArticulo = leer.nextInt();

            if (opcionArticulo == 0) {
                break;
            }

            System.out.print("Ingrese la cantidad de artículos que desea comprar: ");
            int cantidad;
            cantidad = leer.nextInt();
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
        leer.close();
    }

    private static double comprarPantalonVestir(int cantidad) {
        Scanner leer = new Scanner(System.in);
        
        System.out.print("Ingrese la talla de la prenda CH, M, G, XG ");
        String talla;
        talla = leer.next().toUpperCase();
        
        double precioBase = pantalonVestir.getPrecioCompra();
        
        if (talla.equals("CH") || talla.equals("M")) {
            precioBase *= 1.1;
        } else if (talla.equals("G") || talla.equals("XG")) {
            precioBase *= 1.2;
        }

        if (cantidad > pantalonVestir.getInventario()) {
            System.out.println("No hay suficientes prendas");
            return 0.0;
        }

        double precioTotal = cantidad * precioBase;
        pantalonVestir.setInventario(pantalonVestir.getInventario() - cantidad);

        System.out.println("Compra hecha");
        System.out.println("Artículo: Pantalón de Vestir");
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio total: $" + precioTotal);
        
        return precioTotal;
    }

    private static double comprarPantalonMezclilla(int cantidad) {
        Scanner leer = new Scanner(System.in);
        
        if (cantidad > pantalonMezclilla.getInventario()) {
            System.out.println("No hay suficientes prendas");
            leer.close();
            return 0.0;
        }

        System.out.print("Ingrese la talla de la prenda CH, M, G, XG ");
        String talla;
        talla = leer.next().toUpperCase();
        double precioBase = pantalonMezclilla.getPrecioCompra();
        
        if (talla.equals("CH") || talla.equals("M")) {
            precioBase *= 1.1;
        } else if (talla.equals("G") || talla.equals("XG")) {
            precioBase *= 1.2;
        }

        double precioTotal = cantidad * precioBase;
        pantalonMezclilla.setInventario(pantalonMezclilla.getInventario() - cantidad);
        System.out.println("Compra hecha");
        System.out.println("Artículo: Pantalón de Mezclilla");
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio total: $" + precioTotal);
        
        return precioTotal;
    }

    private static double comprarCamisa(int cantidad) {
        Scanner leer = new Scanner(System.in);
        
        if (cantidad > camisa.getInventario()) {
            System.out.println("No hay suficientes prendas");
            leer.close();
            return 0.0;
        }

        System.out.print("Ingrese la talla de la prenda CH, M, G, XG ");
        String talla;
        talla = leer.next().toUpperCase();
        
        double precioBase = camisa.getPrecioCompra();
        
        if (talla.equals("CH") || talla.equals("M")) {
            precioBase *= 1.1;
        } else if (talla.equals("G") || talla.equals("XG")) {
            precioBase *= 1.2; 
        }

        double precioTotal = cantidad * precioBase;
        camisa.setInventario(camisa.getInventario() - cantidad);
        System.out.println("Compra hecha");
        System.out.println("Artículo: Camisa");
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio total: $" + precioTotal);
        
        return precioTotal;
    }

    private static double comprarFalda(int cantidad) {
        Scanner leer = new Scanner(System.in);
        
        if (cantidad > falda.getInventario()) {
            System.out.println("No hay suficientes prendas");
            leer.close();
            return 0.0;
        }

        
        System.out.print("Ingrese la talla de la prenda CH, M, G, XG");
        String talla;
        talla = leer.next().toUpperCase(); 
        
        double precioBase = falda.getPrecioCompra();
        
        if (talla.equals("CH") || talla.equals("M")) {
            precioBase *= 1.1;
        } else if (talla.equals("G") || talla.equals("XG")) {
            precioBase *= 1.2;
        }

        double precioTotal = cantidad * precioBase;
        falda.setInventario(falda.getInventario() - cantidad);
        System.out.println("Compra hecha");
        System.out.println("Artículo: Falda");
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio total: $" + precioTotal);
        
        return precioTotal;
    }

    private static double comprarBlusa(int cantidad) {
        Scanner leer = new Scanner(System.in);
        
        if (cantidad > blusa.getInventario()) {
            System.out.println("No hay suficientes prendas");
            leer.close();
            return 0.0;
        }

        System.out.print("Ingrese la talla de la prenda CH, M, G, XG");
        String talla;
        talla= leer.next().toUpperCase();
        
        double precioBase = blusa.getPrecioCompra();
        
        if (talla.equals("CH") || talla.equals("M")) {
            precioBase *= 1.1;
        } else if (talla.equals("G") || talla.equals("XG")) {
            precioBase *= 1.2;
        }

        double precioTotal = cantidad * precioBase;
        blusa.setInventario(blusa.getInventario() - cantidad);
        System.out.println("Compra hecha");
        System.out.println("Artículo: Blusa");
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio total: $" + precioTotal);
        
        return precioTotal;
    }

    private static double comprarPlayera(int cantidad) {
        Scanner leer = new Scanner(System.in);
        
        if (cantidad > playera.getInventario()) {
            System.out.println("No hay suficientes prendas");
            leer.close();
            return 0.0;
        }

        System.out.print("Ingrese la talla de la prenda CH, M, G, XG");
        String talla;
        talla = leer.next().toUpperCase();
        
        double precioBase = playera.getPrecioCompra();
        
        if (talla.equals("CH") || talla.equals("M")) {
            precioBase *= 1.1;
        } else if (talla.equals("G") || talla.equals("XG")) {
            precioBase *= 1.2;
        }

        double precioTotal = cantidad * precioBase;
        playera.setInventario(playera.getInventario() - cantidad);
        System.out.println("Compra hecha");
        System.out.println("Artículo: Playera");
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio total: $" + precioTotal);
        
        return precioTotal;
    }
 
}
