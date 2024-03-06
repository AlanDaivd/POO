package modelo;

import java.util.Random;

import lombok.Data;

@Data
public class PantalonMezclilla {
    private String sexo;
    private String tamaño;
    private String codigoVenta;
    private double precioCompra;
    private int inventario;

    public PantalonMezclilla(String sexo, String tamaño, double precioCompra) {
        this.sexo = sexo;
        this.tamaño = tamaño;
        this.precioCompra = precioCompra;
        this.inventario = 15;
        this.codigoVenta = generarCodigoVenta();
    }

    private String generarCodigoVenta() {
        Random random = new Random();
        int codigo = random.nextInt(900000) + 100000;
        return String.valueOf(codigo);
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %.2f %.2f", "PantalonMezclilla", tamaño, inventario, precioCompra);
    }
}
