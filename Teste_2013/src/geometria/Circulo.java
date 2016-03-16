package geometria;

public class Circulo implements Figura {
	private Ponto centro;
	private int raio;
	
	public Circulo(Ponto p, int r) throws IllegalArgumentException {
		if (r <= 0) {
			throw new IllegalArgumentException();
		}
		
		centro = p;
		raio = r;
	}
	
	public Ponto getCentro() {
		return centro;
	}
	
	public int getRaio() {
		return raio;
	}
	
	public double getArea() {
		return raio*raio*Math.PI;
	}
	
	public double getPerimetro() {
		return 2*Math.PI*(2*raio);
	}
	
}
