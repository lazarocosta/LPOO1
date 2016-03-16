
public class TGV extends Comboio{
	public TGV(String nome){
		super(nome);
		servico_a_bordo = new ServicoPrioritario();
	}
	
	public String toString() {
		String s = "";
		
		s += "TGV " + nome + ", " + carruagens.size();
		if (carruagens.size() == 1) {
			s += " carruagem, ";
		}
		else {
			s += " carruagens, ";
		}
		
		s += getNumLugares();
		if (getNumLugares() == 1) {
			s += " lugar, ";
		}
		else {
			s += " lugares, ";
		}
		
		s += num_passageiros;
		if (num_passageiros == 1) {
			s += " passageiro";
		}
		else {
			s += " passageiros";
		}
		
		return s;
	}

}