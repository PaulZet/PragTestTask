package tdd.vendingMachine;

public interface VendingMachine {
	public void selectProductAndShowPrice(int shelveNumber);

	public double returnChange();

	public boolean checkIfPaymentCoverPrice(int choosenProduct);

	public void insertCoin(double coin);
	
}
