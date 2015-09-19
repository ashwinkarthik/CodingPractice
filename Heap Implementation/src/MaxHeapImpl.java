
public class MaxHeapImpl implements HeapInterface{
	
	
	Node[] heapContainer;
	int sizeOfHeap;
	
	MaxHeapImpl(){
		heapContainer = new Node[10];
		sizeOfHeap = 0;
	}
	
	MaxHeapImpl(int initialCapacity){
		heapContainer = new Node[initialCapacity];
		sizeOfHeap = 0;
	}
	
	MaxHeapImpl(double[] data){
		heapContainer = new Node[data.length*3];
		int index = 0;
		for(double item:data)
			heapContainer[index++] = new Node(item);
		sizeOfHeap = 0;
	}
	
	@Override
	public boolean insert(double key) {
		// TODO Auto-generated method stub	
		if(sizeOfHeap==heapContainer.length)
			return false;

		heapContainer[sizeOfHeap] = new Node(key);
		percolateUp(sizeOfHeap);
		sizeOfHeap++;
		return true;
	}

	
	/* Gets the sorted order of values in the heap */
	public double[] sort(){
		
		// Save the original state of the heap
		Node[] originalHeap = heapContainer.clone();
		int originalHeapSize = sizeOfHeap;
		
		
		double[] temp = new double[sizeOfHeap];
		int index = sizeOfHeap-1;
		
		//Keep calling the remove operation and store the value in the right index of the temporary array.
		while(index>=0){
			temp[index--]=remove();
		}
		
		// Restore the state of the original heap
		heapContainer = originalHeap;
		sizeOfHeap = originalHeapSize;
		
		return temp;
	}
	

	
	private void percolateUp(int index){	
		Node insertedNode = heapContainer[index];
		int parentIndex = getParentIndex(index);
		Node parent = heapContainer[parentIndex];
		while(parentIndex>=0 && insertedNode.key>parent.key){
			heapContainer[index] = parent;
			index = parentIndex;
			if(index==0)
				break;
			parentIndex = getParentIndex(index);
			parent = heapContainer[parentIndex];
		}
		heapContainer[index] = insertedNode;
	}
	
	private int getParentIndex(int index){
		if(index == 0 || index==1 || index==2)
			return 0;
		else
			return (int) Math.ceil(index/2);
	}
	
	private int getLeftChildIndex(int index){
		if(index==0)
			return 1;
		else
			return 2*index;
	}
	
	private int getRightChildIndex(int index){
		if(index==0)
			return 2;
		else
			return 2*index+1;
	}
	
	@Override
	public double remove() {
		// TODO Auto-generated method stub
		if(sizeOfHeap==0)
			return 0;
		//Store the root which is the result
		double result = heapContainer[0].key;
		//Replace the root with the last element in the array and empty the last element
		heapContainer[0] = heapContainer[sizeOfHeap-1];
		heapContainer[sizeOfHeap-1]=null;
		sizeOfHeap--;
		percolateDown(0);
		return result;
	}
	
	private void percolateDown(int index){
		Node inCorrectNode = heapContainer[index];
		
		int maxIndex = getIndexToPercolateDown(index);
		int parentIndex = index;
		if(maxIndex==index)
			return; // Already at the right position
		
		while(true){
			Node child = heapContainer[maxIndex];
			heapContainer[parentIndex] = child;
			heapContainer[maxIndex] = inCorrectNode;
			parentIndex = maxIndex;
			maxIndex = getIndexToPercolateDown(maxIndex);
			if(maxIndex==parentIndex)
				break;
		}	
	}
	
	private int getIndexToPercolateDown(int index){
		
		int leftChildIndex = getLeftChildIndex(index);
		int rightChildIndex = getRightChildIndex(index);
		
		//leaf node
		if(heapContainer[leftChildIndex]==null && heapContainer[rightChildIndex]==null ){
			return index;
		}
		
		//both children are present
		if(heapContainer[leftChildIndex]!=null && heapContainer[rightChildIndex]!=null ){
			if(heapContainer[index].key>heapContainer[leftChildIndex].key){
				if(heapContainer[index].key>heapContainer[rightChildIndex].key){
					return index;
				}
				else{
					return rightChildIndex;
				}
			}
			else{
				if(heapContainer[leftChildIndex].key>heapContainer[rightChildIndex].key){
					return leftChildIndex;
				}
				else{
					return rightChildIndex;
				}
			}
		}
		
		//only one child is present
		int childIndex = (heapContainer[leftChildIndex]==null)?rightChildIndex:leftChildIndex;
		if(heapContainer[index].key>heapContainer[childIndex].key)
			return index;
		else
			return childIndex;
		
		
	}
	
	public void display(){
		for(Node item:heapContainer){
			if(item!=null)
				System.out.print(item.key+" ");
			else
				System.out.print("# ");
		}
		System.out.println();
	}
	
	public static class Node{
		private double key;
		public Node(double key){
			this.key = key;
		}
		
	}
	

}
