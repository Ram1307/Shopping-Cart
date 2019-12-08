package com.shopping.test;

import org.junit.Assert;
import org.junit.Test;

import com.shopping.Billing;
import com.shopping.CustomerBilling;
import com.shopping.discunts.CustomerDiscount;
import com.shopping.discunts.CustomerType;
import com.shopping.discunts.Discounts;
import com.shopping.discunts.Slabs;

public class CustomerBillingTest {
	Billing bill=new CustomerBilling();
	
	@Test
	public void testNillDiscount(){
		
		Discounts dis=new CustomerDiscount();
		dis.addDiscountSlabs(new Slabs(0,5000,0), CustomerType.Regular);
		dis.addDiscountSlabs(new Slabs(5000,10000,10), CustomerType.Regular);
		dis.addDiscountSlabs(new Slabs(10000,Integer.MAX_VALUE,20), CustomerType.Regular);
		Assert.assertEquals(5000, bill.calculateFinalBillAmount(5000, CustomerType.Regular));
		
	}
	@Test
	public void testTenPercentDiscount(){
		Discounts dis=new CustomerDiscount();
		dis.addDiscountSlabs(new Slabs(0,5000,0), CustomerType.Regular);
		dis.addDiscountSlabs(new Slabs(5000,10000,10), CustomerType.Regular);
		dis.addDiscountSlabs(new Slabs(10000,Integer.MAX_VALUE,20), CustomerType.Regular);
		Assert.assertEquals(5900, bill.calculateFinalBillAmount(6000, CustomerType.Regular));
		
	}
	@Test
	public void testTwentyPercentDiscount(){
		Discounts dis=new CustomerDiscount();
		dis.addDiscountSlabs(new Slabs(0,5000,0), CustomerType.Regular);
		dis.addDiscountSlabs(new Slabs(5000,10000,10), CustomerType.Regular);
		dis.addDiscountSlabs(new Slabs(10000,Integer.MAX_VALUE,20), CustomerType.Regular);
		Assert.assertEquals(13500, bill.calculateFinalBillAmount(15000, CustomerType.Regular));
		
	}
}
