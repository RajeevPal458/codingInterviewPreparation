package com.bt.arrTree.mix;

import java.util.Comparator;

public class Sort2DArray {

	public enum SortingOrder{
	    ASCENDING, DESCENDING;
	};

	/*
	 * Utility Comparator class to sort two dimensional array in Java
	 */
    public static class ColumnComparator implements Comparator<Comparable[]> {
	    private final int iColumn;
	    private final SortingOrder order;

	    public ColumnComparator(int column, SortingOrder order) {
	        this.iColumn = column;
	        this.order = order;
	    }

	    @Override
	    public int compare(Comparable[] c1, Comparable[] c2) {
	        int result = c1[iColumn].compareTo(c2[iColumn]);
	        return order==SortingOrder.ASCENDING ? result : -result;
	    }
	}
}