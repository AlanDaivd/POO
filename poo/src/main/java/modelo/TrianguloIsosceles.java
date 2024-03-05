package modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrianguloIsosceles extends TrianguloEquilatero{

	private double lado;
	
	@Override
	public Double perimietro() {
		// TODO Auto-generated method stub
		return (lado * 2) + getBase();
	}
}
