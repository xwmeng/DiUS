package com.dius;

import java.math.BigDecimal;

/**
 * Product for sale in running club.
 * @author Xiangwei Meng
 *
 */
public class Product {
	
	private String productCode;
	private String name;
	private BigDecimal price;
	/* The price displayed on invoice after discount */
	private BigDecimal invoicePrice;
	/* Flag to indicated whether the product has been discounted */
	private boolean discounted = false;

	public Product() {
	}

	public Product(String productCode, String name, BigDecimal price) {
		this.setProductCode(productCode);
		this.setName(name);
		this.setPrice(price);
		
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
		this.invoicePrice = price;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setInvoicePrice(BigDecimal invoicePrice) {
		this.invoicePrice = invoicePrice;
	}

	public BigDecimal getInvoicePrice() {
		return invoicePrice;
	}

	public void setDiscounted(boolean discounted) {
		this.discounted = discounted;
	}

	public boolean isDiscounted() {
		return discounted;
	}
}
