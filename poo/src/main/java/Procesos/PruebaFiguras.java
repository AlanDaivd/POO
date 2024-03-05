package Procesos;


import modelo.Figura;
import modelo.TrianguloEquilatero;
import modelo.Cuadrado;

public class PruebaFiguras {
	
	public static void main(String[] args) {
		
		Figura f = new Cuadrado(3D);
		Double res = f.perimietro();
		System.out.println(res);
		
		f = new TrianguloEquilatero(3D,3D);
		res = f.perimietro();
		System.out.println(res);
	}

}
