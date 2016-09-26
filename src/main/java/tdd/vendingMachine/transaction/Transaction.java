package tdd.vendingMachine.transaction;

public class Transaction {

	private double givenPayment;
	private double totalStockToPay;
	private double changeToPayBack;

	
	
	public Transaction(double givenPayment, double totalStockToPay) {
		super();
		this.givenPayment = givenPayment;
		this.totalStockToPay = totalStockToPay;
	}

	public double getGivenPayment() {
		return givenPayment;
	}

	public void setGivenPayment(double givenPayment) {
		this.givenPayment = givenPayment;
	}

	public Double getTotalStockToPay() {
		return totalStockToPay;
	}

	public void setTotalStockToPay(Double totalStockToPay) {
		this.totalStockToPay = totalStockToPay;
	}

	public Double getChangeToPayBack() {
		return changeToPayBack;
	}

	public void setChangeToPayBack(Double changeToPayBack) {
		this.changeToPayBack = changeToPayBack;
	}

	public double calculateChangeToPayBack(){
		if (validateEnoughPayment())
			this.changeToPayBack = givenPayment - totalStockToPay;
		
		return this.changeToPayBack;
	}
	
	public boolean validateEnoughPayment(){
		boolean validationResult = false;
		if (this.getTotalStockToPay() <= this.getGivenPayment())
			validationResult = true;
		return validationResult;
	}
}
