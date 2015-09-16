


public class HashTable implements HashTableInterface {
	private int initialCapacity;
	private double loadFactor;
	DataItem[] hashTable;
	private int numberOfItems;
	private int numberOfCollisions;
	private static DataItem deleted = new DataItem("#DELETED#",-1);
	
	HashTable(){
		initialCapacity = 10;
		loadFactor = 0.5;
		hashTable = new DataItem[initialCapacity];
		numberOfItems = 0;
		numberOfCollisions = 0;
	}
	
	HashTable(int initialCapacity){
		this.initialCapacity = initialCapacity;
		this.loadFactor = 0.5;
		hashTable = new DataItem[initialCapacity];
		numberOfItems = 0;
		numberOfCollisions = 0;
	}
	
	private boolean isPresentAlready(String value,int index){
		while(hashTable[index]!=null){
			if(hashTable[index]!=deleted){
				if(hashTable[index].value==value){
					hashTable[index].frequency = hashTable[index].frequency + 1;
					return true;
				}
			}
			index++;
			index = index % hashTable.length;
		}
		return false;
	}
	@Override
	public void insert(String value) {
		// TODO Auto-generated method stub
		boolean sawCollison = false;
		if(value == null || !value.matches("[a-z]+"))
			return;
		int index = hashValue(value);
		if(!isPresentAlready(value,index)){ //Checks if it is already present
			
			int hash = index;	
			//If not, finds the first null or previously deleted spot
			while(hashTable[index]!=null && hashTable[index]!=deleted){
				if(hashValue(hashTable[index].value)==hash && !sawCollison){
					numberOfCollisions++;
					sawCollison = true;
				}
				index++;
				index = index%hashTable.length;
			}
			hashTable[index] = new DataItem(value,1);
			numberOfItems++;
			
			//Calculate the load factor and rehash if it is greater than the given loadFactor.
			double load = (double)((double)size() /(double) hashTable.length);
			if(load>loadFactor){
				reHash();
			}
		}
	}
	
	private void reHash(){
		int newSize = nextGreaterPrime(hashTable.length*2);

		System.out.println("Before Rehashing, Size is "+hashTable.length+ " and Collisions is "+numberOfCollisions);

		
		DataItem[] oldHashTable = hashTable;
		hashTable = new DataItem[newSize];
		numberOfItems = 0;
		numberOfCollisions = 0;
		for(DataItem item:oldHashTable){
			if(item!=null && item!=deleted){
				insert(item.value);
			}
		}
		
		System.out.println("After Rehashing, Size is "+hashTable.length+ " and Collisions is "+numberOfCollisions);
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return numberOfItems;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
		for(DataItem item:hashTable){
			if(item==null){
				System.out.println("#NULL#");
			}
			else if(item == deleted){
				System.out.println("#DELETED#");
			}
			else{
				System.out.println(item.value+":"+item.frequency);
			}
		}
	}

	@Override
	public boolean contains(String key) {
		// TODO Auto-generated method stub
		int index = hashValue(key);
		
		while(hashTable[index]!=null){
			if(hashTable[index]!=deleted){
				if(hashTable[index].value == key){
					return true;
				}
			}
			index++;
			index = index % hashTable.length;
		}
		return false;
	}

	@Override
	public int numOfCollisions() {
		// TODO Auto-generated method stub
		return numberOfCollisions;
	}

	@Override
	public int hashValue(String value) {
		// TODO Auto-generated method stub
		return hashFunc(value);
	}

	private int hashFunc(String value){
		long hashValue = 0;
		int i;
		for(i=0;i<value.length()-1;i++){
			hashValue = (hashValue +(value.charAt(i)-'a'+1))*27;
		}
		hashValue+=(value.charAt(i)-'a'+1);
		int capacity = hashTable.length;
		return (int) (hashValue%capacity);
	}
	
	public int nextGreaterPrime(int num){
		int i,j;
		boolean done = false;
		for(i=num;;i++){
			for(j=2;j<=Math.sqrt(i);j++){
				if(i%j==0)
					break;
				done = true;
			}
			if(j>Math.sqrt(i) && done)
				break;
			else
				continue;
			
		}
		return i;
	}


	@Override
	public String remove(String key) {
		// TODO Auto-generated method stub
		int index = hashValue(key);
		
		while(hashTable[index]!=null){
			if(hashTable[index]!=deleted){
				if(hashTable[index].value == key){
					hashTable[index] = deleted;
					numberOfItems--;
					return key;
				}
			}
			index++;
			index = index % hashTable.length;
		}
		return null;
	}
	
	private static class DataItem{
		String value;
		int frequency;
		
		DataItem(){
			
		}
		
		DataItem(String value,int frequency){
			this.value = value;
			this.frequency = frequency;
		}
	}

}