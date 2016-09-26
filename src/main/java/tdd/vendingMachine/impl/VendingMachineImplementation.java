package tdd.vendingMachine.impl;

import java.util.HashMap;

import tdd.vendingMachine.VendingMachine;
import tdd.vendingMachine.display.Display;
import tdd.vendingMachine.itemtype.ItemType;
import tdd.vendingMachine.product.Product;
import tdd.vendingMachine.shelf.Shelf;

public class VendingMachineImplementation implements VendingMachine {

	private final HashMap<Integer, Shelf> shelfsNumberMap = new HashMap<Integer, Shelf>();
	Display display;
	private Double availableCashAmountInMachine;

	public VendingMachineImplementation(Display display) {
		super();
		this.display = display;
		this.availableCashAmountInMachine = 0.0;
		this.shelfsNumberMap.put(1, new Shelf(new Product(ItemType.BREADSTIKS,
				0.5), 50));
		this.shelfsNumberMap.put(2, new Shelf(new Product(
				ItemType.CHOCOLATE_BAR, 2.5), 20));
		this.shelfsNumberMap.put(3, new Shelf(new Product(ItemType.COLA, 3.6),
				15));
		this.shelfsNumberMap.put(4, new Shelf(new Product(
				ItemType.MINERAL_WATER, 1.5), 10));
	}

	@Override
	public void selectProductAndShowPrice(int shelveNumber) {
		this.getDisplay().showProductPrice();
	}
	
	@Override
	public double returnChange() {
		double changeToReturn = 0.0;
		if (this.display.getTransaction().getChangeToPayBack() <= this
				.getAvailableCashAmountInMachine()) {
			changeToReturn = this.display.getTransaction().getChangeToPayBack();

		} else
			changeToReturn = this.display.getTransaction().getGivenPayment();
		return changeToReturn;
	}

	@Override
	public boolean checkIfPaymentCoverPrice(int choosenProduct) {
		boolean enoughPayment = false;
		if (this.getShelfsNumberMap().get(choosenProduct).getProduct()
				.getPrice() > this.getDisplay().getTransaction()
				.getGivenPayment()) {
			this.getDisplay().showNotEnoughPaymentStatement();

		} else {
			enoughPayment = true;
		}
		return enoughPayment;
	}

	@Override
	public void insertCoin(double coin) {
		calcultateInsertedPayment(coin);

	}

	public void calcultateInsertedPayment(Double insertedCoinValue) {

		if (validateCoinDenomintation(insertedCoinValue)) {
			double amount = this.display.getTransaction().getGivenPayment();
			amount = this.display.getTransaction().getGivenPayment()
					+ insertedCoinValue;
			this.display.getTransaction().setGivenPayment(amount);
			this.availableCashAmountInMachine = this.availableCashAmountInMachine
					+ insertedCoinValue;
		}
	}

	public boolean validateCoinDenomintation(Double coin) {
		boolean validationResult = false;
		if (coin == 0.5 | coin == 0.1 | coin == 0.2 | coin == 1 | coin == 2
				| coin == 5)
			validationResult = true;
		else
			this.display.showValidCoinsDenomination();
		return validationResult;
	}

	public void renderProduct(int productType) {
		if (this.getShelfsNumberMap().get(productType).isProductAvailable()) {
			int quantity = this.getShelfsNumberMap().get(productType)
					.getShelfQuantity();
			quantity = quantity - 1;
			this.getShelfsNumberMap().get(productType)
					.setShelfQuantity(quantity);
			this.getDisplay().showRenderProductStatement(
					this.getShelfsNumberMap().get(productType).getProduct());
			
		}
	}
	public void decreaseMachineCoinAmoutStatus(){
		this.availableCashAmountInMachine = this
				.getAvailableCashAmountInMachine()
				- this.getDisplay().getTransaction().getChangeToPayBack();
	}

	public Display getDisplay() {
		return display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}

	public Double getAvailableCashAmountInMachine() {
		return availableCashAmountInMachine;
	}

	public void setAvailableCashAmountInMachine(
			Double availableCashAmountInMachine) {
		this.availableCashAmountInMachine = availableCashAmountInMachine;
	}

	public HashMap<Integer, Shelf> getShelfsNumberMap() {
		return shelfsNumberMap;
	}

}
