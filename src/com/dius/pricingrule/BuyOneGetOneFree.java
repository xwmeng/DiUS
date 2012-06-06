package com.dius.pricingrule;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.dius.Consts;

import com.dius.Product;

/**
 * Pricing rule: buy one get one free
 * @author Xiangwei Meng
 *
 */
public class BuyOneGetOneFree implements PricingRule {

	private static List<String> BUY_ONE_GET_ONE_FREE_PRODUCT_CODES;
	public BuyOneGetOneFree() {
		BUY_ONE_GET_ONE_FREE_PRODUCT_CODES = new ArrayList<String>();
		BUY_ONE_GET_ONE_FREE_PRODUCT_CODES.add(Consts.PRODUCT_NF3);
	}
	
	@Override
	public void checkRule(List<Product> products, Product newProduct) {
		String productCode = newProduct.getProductCode();
		if ( ! BUY_ONE_GET_ONE_FREE_PRODUCT_CODES.contains(productCode) ) {
			return;
		}
		for (Product product : products) {
			if ( product.getProductCode().equals(productCode) && ! product.isDiscounted() ) {
				newProduct.setInvoicePrice(new BigDecimal(0));
				product.setDiscounted(true);
				newProduct.setDiscounted(true);
			}
		}
	}

}
