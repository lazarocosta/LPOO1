package jogo.logic;

public class Dragao {
	public int x;
	public int y;
	public char tipo;
	public boolean estavivo;

	public Dragao(int x, int y) {
		this.x = x;
		this.y = y;
		this.tipo = 'D';
		this.estavivo = true;
	}

	public int modo(Labirinto labirinto){
		int modo = labirinto.rand.nextInt() % 2;//se zero anda // 1 dorme 
		
		return modo;
		
	}
	public void acorda(Labirinto labirinto) {
		tipo = 'D';
		labirinto.lab[y][x] = tipo;
	}
	
	public void adormece(Labirinto labirinto) {
		tipo = 'd';
		labirinto.lab[y][x] = tipo;
	}
	
	
	public void morre(Labirinto labirinto) {
		labirinto.lab[y][x] = ' ';
		labirinto.lab[labirinto.saida.y][labirinto.saida.x] = ' ';
		estavivo = false;
	}

	public void move(Labirinto labirinto) {
		int i = labirinto.rand.nextInt() % 4;

		if (i == 0) {
			if (labirinto.lab[y - 1][x] == ' ') {
				labirinto.lab[y][x] = ' ';
				y--;
				labirinto.lab[y][x] = tipo;
			}
			else if (labirinto.lab[y - 1][x] == 'E') {
				labirinto.lab[y][x] = ' ';
				y--;
				labirinto.lab[y][x] = 'F';
			}
		}

		if (i == 1) {
			if (labirinto.lab[y][x + 1] == ' ')

			{
				labirinto.lab[y][x] = ' ';
				x++;
				labirinto.lab[y][x] = tipo;
			}
			else if (labirinto.lab[y][x + 1] == 'E')

			{
				labirinto.lab[y][x] = ' ';
				x++;
				labirinto.lab[y][x] = 'F';
			}
		}

		if (i == 2) {
			if (labirinto.lab[y + 1][x] == ' ') {
				labirinto.lab[y][x] = ' ';
				y++;
				labirinto.lab[y][x] = tipo;
			
			}
			else if (labirinto.lab[y + 1][x] == 'E') {
				labirinto.lab[y][x] = ' ';
				y++;
				labirinto.lab[y][x] = 'F';
			}
		}

		if (i == 3) {
			if (labirinto.lab[y][x - 1] == ' ') {
				labirinto.lab[y][x] = ' ';
				x--;
				labirinto.lab[y][x] = tipo;
			}
			else if (labirinto.lab[y][x - 1] == 'E') {
				labirinto.lab[y][x] = ' ';
				x--;
				labirinto.lab[y][x] = 'F';
			}
		}
		
		
		if ((labirinto.espada.y != y || labirinto.espada.x !=x) && labirinto.existeEspada) {
			labirinto.lab[labirinto.espada.y][labirinto.espada.x] = 'E';
		}
	}

}
