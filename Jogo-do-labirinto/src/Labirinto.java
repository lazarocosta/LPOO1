import java.util.Random;

public class Labirinto {

	public Random rand = new Random(System.currentTimeMillis());
	public char lab[][] = {
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
			{ 'X', 'H', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
			{ 'X', 'D', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
			{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
			{ 'X', 'E', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'S' },
			{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
			{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
			{ 'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };

	public class Saida {
		public int x;
		public int y;
	}

	public class Espada {
		public int x;
		public int y;
	}

	public Saida saida = new Saida();
	public Espada espada = new Espada();

	public Labirinto() {
		saida.x = 9;
		saida.y = 5;

		espada.x = 1;
		espada.y = 5;
	}

	public boolean existeEspada=true;
	public void print() {
		for (int i = 0; i < lab.length; i++) {
			for (int j = 0; j < lab[i].length; j++) {
				System.out.print(lab[i][j] + " ");
			}

			System.out.println();
		}
	}
}