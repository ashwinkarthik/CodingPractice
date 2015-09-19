
public interface HeapInterface {

	/**
	* Insert a new key into a heap
	* @param key key to be inserted
	* @return boolean to check whether it was added or not */
	boolean insert(double key);
	
	
	/**
	* remove the highest priority key (maximum for max heap/minimum for min heap) * @return removed key
	*/
	double remove();
	
	/**
	* Gets the sorted order of values in the heap *
	*/
	public double[] sort();
	
	
}
