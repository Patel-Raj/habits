package servlets;

public class BinarySearch {
	
	BubbleSort bubbleSort;

	public BubbleSort getBubbleSort() {
		return bubbleSort;
	}

	public void setBubbleSort(BubbleSort bubbleSort) {
		this.bubbleSort = bubbleSort;
	}
	
	public void pintVal() {
		System.out.println("Value is : " + bubbleSort.getVal());
	}
}
