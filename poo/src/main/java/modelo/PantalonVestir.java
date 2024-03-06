package modelo;

import java.util.Random;

import lombok.Data;

@Data
public class PantalonVestir {
    private String sexo;
    private String tamaño;
    private String codigoVenta;
    private double precioCompra;
    private int inventario = 15;

    public PantalonVestir(String sexo, String tamaño, double precioCompra) {
        this.tamaño = tamaño;
        this.sexo = sexo;
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
        return String.format("%s %s %d %.2f %.2f", "PantalonVestir", tamaño, inventario, precioCompra);
    }
    
}
