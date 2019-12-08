package com.shopping;

import java.util.List;

import com.shopping.discunts.CustomerDiscount;
import com.shopping.discunts.CustomerType;
import com.shopping.discunts.Discounts;
import com.shopping.discunts.Slabs;

public class CustomerBilling implements Billing {

	public int calculateFinalBillAmount(int billamount, CustomerType customer) {
		Discounts dis = new CustomerDiscount();
		List<Slabs> list = dis.getDiscountSlabs(customer);
		int discountAmount = 0;
		if (list == null || list.isEmpty()) {
			return billamount;
		} else {

			for (Slabs slab : list) {

				if (billamount >= slab.getMaxSlab()) {
					discountAmount += (slab.getMaxSlab() - slab.getMinSlab()) * slab.getDiscountPercentage() / 100;

				} else if (billamount > slab.getMinSlab()) {
					discountAmount += (billamount - slab.getMinSlab()) * slab.getDiscountPercentage() / 100;
					break;
				}

			}
		}
		// TODO Auto-generated method stub
		return billamount - discountAmount;
	}

}
