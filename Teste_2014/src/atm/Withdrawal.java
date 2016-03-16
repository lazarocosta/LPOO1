package atm;

public class Withdrawal extends Transaction {
	public Withdrawal(ATM atm, Session session, Card card, int amount) {
		super(atm, session, card, amount);
	}
	
	@Override
	public String toString() {
		return ("Withdrawal at ATM " + atm.getID() + " (" + atm.getCity()
		+ ", " + atm.getBank() + ") of " + String.format("%.2f", amount));
	}
	
}