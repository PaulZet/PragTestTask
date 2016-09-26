package tdd.vendingMachine.display;

import tdd.vendingMachine.product.Product;
import tdd.vendingMachine.transaction.Transaction;

public class Display {

	Transaction transaction;
	boolean openTransaction;

	public void Display() {
	}

	public void startDisplay() {
		System.out.println("Welcome and choose product");
	}

	public void startTransaction(Double price, Double currentPayment) {
		Transaction transaction = null;
		this.openTransaction = true;
		if (openTransaction)
			this.transaction = new Transaction(currentPayment, price);
		
	}

	public void showInsertedPayment() {
		System.out.println("Thrown " + this.transaction.getGivenPayment()
				+ "zlotys");
	}
	public void showRenderProductStatement(Product product){
		System.out.println("Product " + product.getProductType() + "has been rendered");
	}

	public void showNotEnoughPaymentStatement() {
		System.out.println("Thrown not enough money");
	}

	public void showProductPrice() {
		System.out.println("The price is "
				+ this.transaction.getTotalStockToPay());
	}

	public void showValidCoinsDenomination() {
		System.out.println("Proper coins are 0.1 , 0.2 , 0.5 , 1 , 2  ,5  ");
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public boolean isOpenTransaction() {
		return openTransaction;
	}

	public void setOpenTransaction(boolean openTransaction) {
		this.openTransaction = openTransaction;
	}

}
