package modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrianguloEquilatero implements Figura{
	private Double altura;
	private Double base;
	
	@Override
	public Double perimietro() {
		// TODO Auto-generated method stub
		return base * 3;
	}

	@Override
	public Double area() {
		// TODO Auto-generated method stub
		return (base * altura)/2;
	}

}
