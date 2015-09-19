

/*
 * 
 * Test Class to test the functionality of the Max Heap implementation.
 * 
 */

public class HeapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Sample heap insertion
		MaxHeapImpl maxHeap = new MaxHeapImpl(20);
		maxHeap.insert(73);
		maxHeap.insert(32);
		maxHeap.insert(45);
		maxHeap.insert(56);
		maxHeap.insert(78);
		maxHeap.insert(99);
		maxHeap.insert(102);
		maxHeap.insert(150);
		
		//Displays the values stored in the heap level by level
		maxHeap.display();
		
		//Get a snapshot of the values stored in the heap in the sorted order
		//Sort internally calls remove.
		double[] sortedArray = maxHeap.sort();
		System.out.println("Sorted Array");
		for(double item:sortedArray)
			System.out.print(item+" ");
		
		//Display is called again to show that the original state of the heap before calling sort is retained
		System.out.println("\nOriginal Array");
		maxHeap.display();
		
		
	}

}
