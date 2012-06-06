package com.dius;

import java.math.BigDecimal;

/**
 * Product factory class
 * @author Xiangwei Meng
 *
 */
public class ProductFactory {

	public static Product getProduct(String productCode) {
		if ( Consts.PRODUCT_NF3.equals(productCode) ) {
			return new Product(Consts.PRODUCT_NF3, Consts.PRODUCT_NF3_NAME, new BigDecimal(99.99));
		} else if ( Consts.PRODUCT_VFF.equals(productCode) ) {
			return new Product(Consts.PRODUCT_VFF, Consts.PRODUCT_VFF_NAME, new BigDecimal(200));
		} else if ( Consts.PRODUCT_MIN.equals(productCode) ) {
			return new Product(Consts.PRODUCT_MIN, Consts.PRODUCT_MIN_NAME, new BigDecimal(155.59));
		}
		return null;
	}

}
