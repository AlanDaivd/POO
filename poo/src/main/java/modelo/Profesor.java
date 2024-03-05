package modelo;

import lombok.Data;

@Data
public class Profesor extends Persona {
    private String materia;

    public Profesor(String nombre, String materia) {
        super(nombre, null, '\0', 0.0, 0.0, 0.0);
        this.materia = materia;
    }
}
