package com.shopping.test;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.shopping.discunts.CustomerDiscount;
import com.shopping.discunts.CustomerType;
import com.shopping.discunts.Discounts;
import com.shopping.discunts.Slabs;
public class DiscountSlabsTest {
	Discounts dis=new CustomerDiscount();
	@Test
		public void A_testAddDiscountSlabsWithFirstSlab(){
		Assert.assertEquals(true, dis.addDiscountSlabs(new Slabs(0,5000,0), CustomerType.Regular));
		
	}
	@Test
	public void B_testAddDiscountSlabsWithNullSlab(){
		Assert.assertEquals(false, dis.addDiscountSlabs(null, CustomerType.Regular));
		
	}
	
	@Test
	public void C_testAddDiscountSlabsWithDuplicateSlab(){
		dis.addDiscountSlabs(new Slabs(0,5000,0), CustomerType.Regular);
		Assert.assertEquals(false, dis.addDiscountSlabs(new Slabs(0,5000,0), CustomerType.Regular));
		
	}
	@Test
	public void D_testAddDiscountSlabsWithInbetweenSlabValue(){
		dis.addDiscountSlabs(new Slabs(0,5000,0), CustomerType.Regular);
		Assert.assertEquals(false, dis.addDiscountSlabs(new Slabs(2000,5000,0), CustomerType.Regular));
		
	}

}
