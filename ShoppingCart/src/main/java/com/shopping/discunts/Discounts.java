package com.shopping.discunts;

import java.util.List;

public interface Discounts {
	public boolean addDiscountSlabs(Slabs slabs,CustomerType customer);
	public boolean removeDiscountSlabs(Slabs slabs,CustomerType customer);
	public List<Slabs> getDiscountSlabs(CustomerType customer);


}
