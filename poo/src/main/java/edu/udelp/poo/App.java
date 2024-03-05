package edu.udelp.poo;

import java.util.ArrayList;
import java.util.List;

import edu.udelp.poo.util.Archivos;

public class App {
    public static void main(String[] args) {
        Persona p = new Persona();
        p.setNombre("Alan David Cortes Varela");
        List<Persona> listP = new ArrayList<>();
        listP.add(p);
        
        Archivos.guardaArchivo(Persona.class.getName(), listP);
        List<Persona>listaPersona = Archivos.leerArchivo(Persona.class.getName());
        System.out.println(listaPersona);
    }
}