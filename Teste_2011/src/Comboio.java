import java.util.*;

public class Comboio {
	public String nome;
	public int num_lugares_livres;
	public int num_passageiros;
	public ServicoABordo servico_a_bordo;
	public ArrayList<Carruagem> carruagens;
	
	public Comboio(String nome) {
		this.nome = nome;
		num_passageiros = 0;
		num_lugares_livres = 0;
		servico_a_bordo = new ServicoRegular();
		carruagens = new ArrayList<Carruagem>(0);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void addCarruagem(Carruagem c) {
		carruagens.add(c);
		num_lugares_livres += c.getNumLugares();
	}
	
	public int getNumCarruagens() {
		return carruagens.size();
	}
	
	public Carruagem getCarruagemByOrder(int pos) {
		return carruagens.get(pos);
	}
	
	public int getNumLugares() {
		int num_lugares = 0;
		
		for (int i = 0; i < carruagens.size(); i++) {
			num_lugares += carruagens.get(i).getNumLugares();
		}
		
		return num_lugares;
	}
	
	public void removeAllCarruagens(int capacidade) {
		for (int i = 0; i < carruagens.size(); i++) {
			if (carruagens.get(i).getNumLugares() == capacidade) {
				carruagens.remove(i);
				i--;
			}
		}		
	}
	
	public int getNumPassageiros() {
		return num_passageiros;
	}
	
	public int getLugaresLivres() {
		return num_lugares_livres;
	}
	
	public void addPassageiros(int n) throws PassengerCapacityExceeded {
		if (n > num_lugares_livres) {
			throw new PassengerCapacityExceeded();
		}
		else {
			num_passageiros += n;
			num_lugares_livres -= n;
		}
	}
	
	public void removePassageiros() {
		num_lugares_livres += num_passageiros;
		num_passageiros = 0;
	}
	
	public void removePassageiros(int n) {
		num_lugares_livres += n;
		num_passageiros -= n;
	}
	
	public String toString() {
		String s = "";
		
		s += "Comboio " + nome + ", " + carruagens.size();
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
	
	@Override
	public boolean equals(Object c) {
		final Comboio cc = (Comboio) c;		
		
		if (cc.getNumCarruagens() != getNumCarruagens()) {
			return false;
		}
		
		for (int i = 0; i < getNumCarruagens(); i++) {
			if (cc.carruagens.get(i).num_lugares != carruagens.get(i).num_lugares) {
				return false;
			}
		}
		
		return true;		
	}

	public ServicoABordo getServicoABordo() {
		return servico_a_bordo;
	}

	public String getDescricaoServico() {
		return servico_a_bordo.return_descricao();
	}
	
	public void setServicoABordo(Object obj) {
		servico_a_bordo = (ServicoABordo) Object.class.cast(obj);
	}
	
}