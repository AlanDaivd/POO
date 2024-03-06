package modelo;

import java.util.Random;

import lombok.Data;

@Data
public class Camisa {
    private String sexo;
    private String tamaño;
    private String codigoVenta;
    private double precioCompra;
    private int inventario = 15;

    public Camisa(String sexo, String tamaño, double precioCompra) {
        this.sexo = sexo;
        this.tamaño = tamaño;
        this.precioCompra = precioCompra;
        this.codigoVenta = generarCodigoVenta();
    }

    public String generarCodigoVenta() {
        Random random = new Random();
        int codigo = random.nextInt(900000) + 100000;
        return String.valueOf(codigo);
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %.2f %.2f", "Camisa", tamaño, inventario, precioCompra);
    }
}
