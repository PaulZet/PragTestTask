package tdd.vendingMachine.product;

import tdd.vendingMachine.itemtype.ItemType;

public class Product {

	private ItemType productType;
	private double price;

	public Product(ItemType productType, double price) {
		super();
		this.productType = productType;
		this.price = price;
	}

	public ItemType getProductType() {
		return productType;
	}

	public void setProductType(ItemType productType) {
		this.productType = productType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productType=" + productType + ", price=" + price + "]";
	}

}
