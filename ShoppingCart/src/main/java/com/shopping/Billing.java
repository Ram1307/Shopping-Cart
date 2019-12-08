package com.shopping;

import com.shopping.discunts.CustomerType;

public interface Billing {
	public int calculateFinalBillAmount(int billamount,CustomerType customer);

}
