package com.dius.pricingrule;

import java.util.List;

import com.dius.Product;

/**
 * Each pricing rule should implement this interface
 * @author Xiangwei Meng
 *
 */
public interface PricingRule {

	public void checkRule(List<Product> products, Product newProduct);

}
