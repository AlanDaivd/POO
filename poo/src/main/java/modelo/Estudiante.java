package modelo;

import lombok.Data;

@Data
public class Estudiante extends Persona {
    private int semestre;
    private String generacion;
    private String carrera;
    private Materia materia;
    private Profesor profesor;

    public Estudiante(String nombre, char sexo, double peso, double altura, double imc,
                      int semestre, String generacion, String carrera) {
        super(nombre, null, sexo, peso, altura, imc);
        this.semestre = semestre;
        this.generacion = generacion;
        this.carrera = carrera;
    }
}
