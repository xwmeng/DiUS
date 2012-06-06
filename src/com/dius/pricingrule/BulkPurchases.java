package com.dius.pricingrule;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.dius.Consts;
import com.dius.Product;

/**
 * Pricing rule: bulk purchases
 * @author Xiangwei Meng
 *
 */
public class BulkPurchases implements PricingRule {

	private static List<String> BULK_PURCHASES_PRODUCT_CODES;
	public BulkPurchases() {
		BULK_PURCHASES_PRODUCT_CODES = new ArrayList<String>();
		BULK_PURCHASES_PRODUCT_CODES.add(Consts.PRODUCT_VFF);
	}

	
	@Override
	public void checkRule(List<Product> products, Product newProduct) {
		String productCode = newProduct.getProductCode();
		if ( ! BULK_PURCHASES_PRODUCT_CODES.contains(productCode) ) {
			return;
		}
		List<Integer> bulkProducts = new ArrayList<Integer>();
		for ( int i = 0; i < products.size(); i ++ ) {
			Product product = products.get(i);
			if ( product.getProductCode().equals(productCode) && ! product.isDiscounted() ) {
				bulkProducts.add(i);
			}
		}
		if ( bulkProducts.size() >= 2 ){
			for (Integer index : bulkProducts) {
				Product bulkProduct = products.get(index);
				bulkProduct.setInvoicePrice(new BigDecimal(175));
				bulkProduct.setDiscounted(true);
			}
			newProduct.setInvoicePrice(new BigDecimal(175));
			newProduct.setDiscounted(true);
		}

	}

}
