package modelo;

import lombok.Data;

@Data
public class Persona {
    private String id;
    private String nombre;
    private char sexo;
    private double peso;
    private double altura;
    private double imc;

    public Persona(String nombre, String id, char sexo, double peso, double altura, double imc) {
        this.nombre = nombre;
        this.id = id;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
        this.imc = imc;
    }
}
