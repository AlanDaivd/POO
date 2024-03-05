package Procesos;

import modelo.Estudiante;
import modelo.Materia;
import modelo.Profesor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Escuela {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Estudiante> estudiantes = new ArrayList<>();

        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1. Ingresar alumno");
            System.out.println("2. Ver alumnos registrados");
            System.out.println("3. Salir");
            System.out.print("Ingrese una opción: ");

            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese los datos del alumno:");
                    System.out.print("Nombre: ");
                    String nombreEstudiante = scanner.nextLine();
                    System.out.print("Semestre: ");
                    int semestreEstudiante = Integer.parseInt(scanner.nextLine());
                    System.out.print("Generación: ");
                    String generacionEstudiante = scanner.nextLine();
                    System.out.print("Carrera: ");
                    String carreraEstudiante = scanner.nextLine();
                    Estudiante estudiante = new Estudiante(nombreEstudiante, ' ', 0.0, 0.0, 0.0, semestreEstudiante, generacionEstudiante, carreraEstudiante);
                    
                    System.out.println("Ingrese los datos para la materia:");
                    System.out.print("Nombre: ");
                    String nombreMateria = scanner.nextLine();
                    String semestreMateria = Integer.toString(semestreEstudiante);  
                    System.out.print("Horario: ");
                    String horarioMateria = scanner.nextLine();
                    System.out.println("Ingrese las calificaciones de la materia:");
                    System.out.print("Primer parcial: ");
                    double primerParcial = Double.parseDouble(scanner.nextLine());
                    System.out.print("Segundo parcial: ");
                    double segundoParcial = Double.parseDouble(scanner.nextLine());
                    System.out.print("Proyecto: ");
                    double proyecto = Double.parseDouble(scanner.nextLine());
                    System.out.print("Examen final: ");
                    double examenFinal = Double.parseDouble(scanner.nextLine());

                    Materia materia = new Materia(nombreMateria, semestreMateria, horarioMateria, carreraEstudiante);
                    materia.setPrimerParcial(primerParcial);
                    materia.setSegundoParcial(segundoParcial);
                    materia.setProyecto(proyecto);
                    materia.setExamenFinal(examenFinal);
                    estudiante.setMateria(materia);

                    System.out.println("Ingrese los datos para el profesor:");
                    System.out.print("Nombre: ");
                    String nombreProfesor = scanner.nextLine();
                    System.out.print("Materia: ");
                    String materiaProfesor = scanner.nextLine();

                    Profesor profesor = new Profesor(nombreProfesor, materiaProfesor);
                    estudiante.setProfesor(profesor);
                    estudiantes.add(estudiante);

                    break;
                case 2:
                    System.out.println("Registros de estudiantes ingresados:");
                    for (Estudiante est : estudiantes) {
                        System.out.println("Nombre: " + est.getNombre());
                        System.out.println("Semestre: " + est.getSemestre());
                        System.out.println("Generación: " + est.getGeneracion());
                        System.out.println("Carrera: " + est.getCarrera());
                        System.out.println("Materia: " + est.getMateria().getNombre());
                        System.out.println("Semestre de la materia: " + est.getMateria().getSemestre());
                        System.out.println("Horario de la materia: " + est.getMateria().getHorario());
                        System.out.println("Primer parcial: " + est.getMateria().getPrimerParcial());
                        System.out.println("Segundo parcial: " + est.getMateria().getSegundoParcial());
                        System.out.println("Proyecto: " + est.getMateria().getProyecto());
                        System.out.println("Examen final: " + est.getMateria().getExamenFinal());
                        double promedio = calcularPromedio(est.getMateria().getPrimerParcial(),
                                est.getMateria().getSegundoParcial(),
                                est.getMateria().getProyecto(),
                                est.getMateria().getExamenFinal());
                        System.out.println("Promedio: " + promedio);
                        System.out.println("Profesor: " + est.getProfesor().getNombre());
                        System.out.println("Materia del profesor: " + est.getProfesor().getMateria());
                        System.out.println("-----------------------------------");
                    }
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 3);
        
        scanner.close();
    }
    
    public static double calcularPromedio(double calificacionPrimerParcial, double calificacionSegundoParcial,
		            double calificacionProyecto, double calificacionExamenFinal) {
		double ponderacionPrimerParcial = 0.25;
		double ponderacionSegundoParcial = 0.25;
		double ponderacionProyecto = 0.25;
		double ponderacionExamenFinal = 0.25;
		double sumaPonderada = (calificacionPrimerParcial * ponderacionPrimerParcial) + (calificacionSegundoParcial * ponderacionSegundoParcial) + (calificacionProyecto * ponderacionProyecto) + (calificacionExamenFinal * ponderacionExamenFinal);
		double promedio = sumaPonderada / (ponderacionPrimerParcial + ponderacionSegundoParcial +
		                     ponderacionProyecto + ponderacionExamenFinal);
		
		return promedio;
}

}
