package tdd.vendingMachine.shelf;

import tdd.vendingMachine.product.Product;

public class Shelf {
	private Product product;
	private int shelfQuantity;

	public Shelf(Product product, int shelfQuantity) {
		this.product = product;
		this.shelfQuantity = shelfQuantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getShelfQuantity() {
		return shelfQuantity;
	}

	public void setShelfQuantity(int shelfQuantity) {
		this.shelfQuantity = shelfQuantity;
	}

	public boolean isProductAvailable() {
		boolean isAvailable = false;
		if (this.shelfQuantity > 0)
			isAvailable = true;
		return isAvailable;
	}
}
