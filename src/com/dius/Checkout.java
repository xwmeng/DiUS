package com.dius;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.dius.pricingrule.PricingRule;

/**
 * Checkout system for products
 * @author Xiangwei Meng
 *
 */
public class Checkout {

	/* Products to be checked out */
	private List<Product> products;
	/* List of pricing rules */
	private List<PricingRule> pricingRules;
	
	public Checkout() {
		products = new ArrayList<Product>();
		pricingRules = new ArrayList<PricingRule>();
	}
	
	/**
	 * Scans each product and add it to product list
	 * @param product
	 */
	public void scan(Product product) {
		products.add(product);
	}
	
	/**
	 * Calculates the total price
	 * @return total price
	 */
	public BigDecimal total() {
		BigDecimal total = new BigDecimal(0);
		List<Product> checkedProducts = new ArrayList<Product>();
		for (Product product : products) {
			checkDiscount(checkedProducts, product);
			checkedProducts.add(product);
		}
		/* Get total price  */
		for (Product product : products) {
			total = total.add(product.getInvoicePrice());
		}
		return total;
	}
	
	/**
	 * Checks the discount
	 * @param checkedProducts
	 * @param newProduct
	 */
	private void checkDiscount(List<Product> checkedProducts, Product newProduct) {
		for ( PricingRule pricingRule : pricingRules ) {
			pricingRule.checkRule(checkedProducts, newProduct);
		}
	}

	/**
	 * Adds pricing rule to checkout system
	 * @param pricingRule
	 */
	public void addPricingRule(PricingRule pricingRule) {
		this.pricingRules.add(pricingRule);
	}


}
