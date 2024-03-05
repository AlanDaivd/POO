package modelo;

import lombok.Data;

@Data 
public class Materia {
    private String nombre;
    private String semestre;
    private String horario;
    private String carrera;
    private double primerParcial;
    private double segundoParcial;
    private double proyecto;
    private double examenFinal;

    public Materia(String nombre, String semestre, String horario, String carrera) {
        this.nombre = nombre;
        this.semestre = semestre;
        this.horario = horario;
        this.carrera = carrera;
        this.primerParcial = 0.0;
        this.segundoParcial = 0.0;
        this.proyecto = 0.0;
        this.examenFinal = 0.0;
    }
}

