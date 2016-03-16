package geometria;

public class Ponto implements Comparable<Ponto> {
	private int x;
	private int y;
	
	public Ponto(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	@Override
	public String toString() {
		return ("(" + x + ", " + y + ")");
	}
	
	@Override
	public boolean equals(Object p) {
		Ponto ponto = (Ponto) p;
		
		if (x == ponto.getX() && y == ponto.getY()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public int compareTo(Ponto p) {
		Ponto ponto = (Ponto) p;
		
		if (x < ponto.getX()) {
			return -1;
		}
		else if (x == ponto.getX() && y < ponto.getY()) {
			return -1;
		}
		else if (x == ponto.getX() && y == ponto.getY()) {
			return 0;
		}
		else {
			return 1;
		}
		
	}
}
