package com.shopping.discunts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class CustomerDiscount implements Discounts {
	public static ConcurrentHashMap<CustomerType, List<Slabs>> discountList = new ConcurrentHashMap<CustomerType, List<Slabs>>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.shopping.discunts.Discounts#addDiscountSlabs(com.shopping.discunts.
	 * Slabs, com.shopping.discunts.CustomerType) to add new slab in discount
	 * list
	 */
	public boolean addDiscountSlabs(Slabs slabs, CustomerType customer) {
		List<Slabs> list = discountList.get(customer);
		if (slabs == null){
			System.out.println("Please provide proper slabs");
			return false;
		}
		if (list == null) {
			list = new ArrayList<Slabs>();
			list.add(slabs);
			discountList.put(customer, list);
		} else if (!checkIfSlabsExist(slabs, list)) {// to check if same slab is
														// exist or not
			list.add(slabs);
			discountList.put(customer, list);
		} else {
			System.out.println( "Please select proper slabs to add. There is aleady one slabs exist with details :"
					+ slabs.toString());
			return false;
		}
		// TODO Auto-generated method stub
		System.out.println("Slabs Added Successfully. details :" + slabs.toString());
		return true;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.shopping.discunts.Discounts#removeDiscountSlabs(com.shopping.discunts
	 * .Slabs, com.shopping.discunts.CustomerType) To remove any slab from
	 * dicount list
	 */

	public boolean removeDiscountSlabs(Slabs slabs, CustomerType customer) {
		List<Slabs> list = discountList.get(customer);
		String returnComment = "";
		boolean isExist = false;
		if (slabs == null) {
			System.out.println("Please provide proper slabs");
			return false;
		} else {
			if (list != null && !list.isEmpty()) {
				for (Slabs temSlab : list) {
					if (slabs.getMinSlab() == temSlab.getMinSlab() && slabs.getMaxSlab() == temSlab.getMaxSlab()) {
						list.remove(temSlab);
						discountList.put(customer, list);
						isExist = true;
						break;

					}

				}

			}
		}
		if (isExist)
			System.out.println( "Slabs deleted Successfully. details :" + slabs.toString());
		else
			System.out.println("Slabs is not avilable . details :" + slabs.toString());

		return isExist;
		// TODO Auto-generated method stub

	}

	public List<Slabs> getDiscountSlabs(CustomerType customer) {
		// TODO Auto-generated method stub
		return discountList.get(customer);
	}
	/*
	 * checkIfSlabsExist is to check if same slab is already or overlapping in
	 * discount list.
	 */

	private boolean checkIfSlabsExist(Slabs slabs, List<Slabs> list) {
		boolean isExist = false;

		for (Slabs temSlab : list) {
			if ((slabs.getMinSlab() > temSlab.getMinSlab() && slabs.getMinSlab() < temSlab.getMaxSlab())
					|| (slabs.getMaxSlab() > temSlab.getMinSlab() && slabs.getMaxSlab() < temSlab.getMaxSlab())
					|| (slabs.getMinSlab() == temSlab.getMinSlab() && slabs.getMaxSlab() == temSlab.getMaxSlab())) {
				isExist = true;
				break;
			}

		}
		return isExist;
	}
}
