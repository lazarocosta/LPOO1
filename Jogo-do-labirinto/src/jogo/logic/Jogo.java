package jogo.logic;

public class Jogo {
	public Labirinto labirinto;
	public Heroi heroi;
	public Dragao dragao;
	
	public Jogo() {		
		labirinto = new Labirinto();
		heroi = new Heroi(1,1);
		dragao = new Dragao(1,3);
	}
	
	public String return_board() {
		return labirinto.return_board();
	}
	
	public int play(String modoJogo, String tecla) {	
		if (modoJogo.equals("0") && dragao.estavivo) {
			dragao.move(labirinto);
		}
		if (modoJogo.equals("1") && dragao.estavivo) {
			if (dragao.tipo == 'D') {
				if (dragao.modo(labirinto) == 0)
					dragao.move(labirinto);

				else if (dragao.modo(labirinto) == 1)
					dragao.adormece(labirinto);
			}
			else if (dragao.tipo == 'd')
				if (dragao.modo(labirinto) == 0)
					dragao.acorda(labirinto);

				else if (dragao.modo(labirinto) == 1)
					dragao.adormece(labirinto);
		}
		// modoJogo == "2" -> parado
		
		
		
		heroi.move(tecla, labirinto);
		if (heroi.x == labirinto.saida.x && heroi.y == labirinto.saida.y) {
			return 1;
		}
		
		heroi.apanha(labirinto.espada, labirinto);		
		
		switch(heroi.lutardragao(dragao)) {
		case 1:	return 2; 				 // LOSE
		case 2: dragao.morre(labirinto); // WIN
				return 3; 
		}
		
		return 0;		
	}
}