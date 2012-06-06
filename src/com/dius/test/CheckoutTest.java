package com.dius.test;

import java.math.BigDecimal;

import junit.framework.TestCase;

import com.dius.Checkout;
import com.dius.Consts;
import com.dius.Product;
import com.dius.ProductFactory;
import com.dius.pricingrule.BulkPurchases;
import com.dius.pricingrule.BuyOneGetOneFree;

public class CheckoutTest extends TestCase {

	private Product product;
	private Checkout checkout;
	
	public CheckoutTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		checkout = new Checkout();
		checkout.addPricingRule(new BuyOneGetOneFree());
		checkout.addPricingRule(new BulkPurchases());
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		product = null;
		checkout = null;
	}

	public void testTotal() {
		product = ProductFactory.getProduct(Consts.PRODUCT_NF3);
		checkout.scan(product);
		product = ProductFactory.getProduct(Consts.PRODUCT_VFF);
		checkout.scan(product);
		product = ProductFactory.getProduct(Consts.PRODUCT_NF3);
		checkout.scan(product);
		product = ProductFactory.getProduct(Consts.PRODUCT_NF3);
		checkout.scan(product);
		product = ProductFactory.getProduct(Consts.PRODUCT_MIN);
		checkout.scan(product);
		
		BigDecimal actual = checkout.total();
		BigDecimal expected = new BigDecimal(555.57);
		assertEquals(expected.floatValue(), actual.floatValue(), 0.1); 
	}
	
	public void testBuyOneGetOneFree() {
		product = ProductFactory.getProduct(Consts.PRODUCT_NF3);
		checkout.scan(product);
		product = ProductFactory.getProduct(Consts.PRODUCT_NF3);
		checkout.scan(product);
		
		BigDecimal actual = checkout.total();
		BigDecimal expected = new BigDecimal(99.99);
		assertEquals(expected.floatValue(), actual.floatValue(), 0.1); 
	}
	
	public void testBulkPurchases() {
		product = ProductFactory.getProduct(Consts.PRODUCT_VFF);
		checkout.scan(product);
		product = ProductFactory.getProduct(Consts.PRODUCT_VFF);
		checkout.scan(product);
		product = ProductFactory.getProduct(Consts.PRODUCT_NF3);
		checkout.scan(product);
		product = ProductFactory.getProduct(Consts.PRODUCT_VFF);
		checkout.scan(product);
		
		BigDecimal actual = checkout.total();
		BigDecimal expected = new BigDecimal(624.99);
		assertEquals(expected.floatValue(), actual.floatValue(), 0.1); 
	}
	

}
