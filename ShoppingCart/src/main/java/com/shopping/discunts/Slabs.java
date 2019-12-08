package com.shopping.discunts;

public class Slabs {
	private int minSlab;
	private int maxSlab;
	private int discountPercentage;

	public Slabs(int minSlab, int maxSlab, int discountPercentage) {
		super();
		this.minSlab = minSlab;
		this.maxSlab = maxSlab;
		this.discountPercentage = discountPercentage;
	}

	public int getMinSlab() {
		return minSlab;
	}

	public void setMinSlab(int minSlab) {
		this.minSlab = minSlab;
	}

	public int getMaxSlab() {
		return maxSlab;
	}

	public void setMaxSlab(int maxSlab) {
		this.maxSlab = maxSlab;
	}

	public int getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(int discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	@Override
	public String toString() {
		return "Slabs [minSlab=" + minSlab + ", maxSlab=" + maxSlab + ", discountPercentage=" + discountPercentage
				+ "]";
	}

}
