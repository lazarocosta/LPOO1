package geometria;

public class FiguraComposta implements Figura, Countable {
	Figura[] figuras;
	
	public FiguraComposta(Figura[] figuras) {
		this.figuras = figuras;
	}

	public double getArea() {
		double area = 0;
		
		for (int i = 0; i < figuras.length; i++) {
			area += figuras[i].getArea();
		}
		
		return area;
	}
	
	public double getPerimetro() {
		double perimetro = 0;
		
		for (int i = 0; i < figuras.length; i++) {
			perimetro += figuras[i].getPerimetro();
		}
		
		return perimetro;
	}
	
	public int count() {
		return figuras.length;
	}
}
