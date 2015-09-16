
/***************************************************************
 * 
 * TEST INPUT
 * 
 * Helper Resources Acknowledgement:-
 * Prof.Terry Lee
 * Carnegie Mellon University
 *
 ***************************************************************/

import java.io.*;

public class HTTest {

	public static void main(String[] args) throws IOException {
		int size;
		HashTable test=new HashTable();
		int hash; hash=Integer.MIN_VALUE;
		
		System.out.println("hash value:"+test.hashValue("increase"));
		System.out.print("Enter size of hash table (bigger than 0): ");
		size = getInt();
		HashTable theHashTable;
		if (size == 0)
			theHashTable = new HashTable();
		else
			theHashTable = new HashTable(size);

		theHashTable.insert("increase");
		theHashTable.insert("creeping");
		theHashTable.insert("everything");
		theHashTable.insert("ourselves");
		theHashTable.insert("himself");
		theHashTable.insert("finished");
		theHashTable.insert("seventh");
		theHashTable.insert("learned");
		theHashTable.insert("learned");
		theHashTable.insert("creeping");
		theHashTable.insert("receive");

		System.out.println("");
		System.out.println("Number of collisions: "
				+ theHashTable.numOfCollisions());
		System.out.println("Number of items: " + theHashTable.size());
		System.out.println("");
		System.out.print("Table: ");
		theHashTable.display();

		if (theHashTable.contains("finished")) {
			System.out.println("Found: 'finished'");
		} else
			System.out.println("Cannot find: 'finished'");
		System.out.println("");

		System.out.println("Hash value of 'increase': "
				+ theHashTable.hashValue("increase"));
		System.out.println("Hash value of 'creeping': "
				+ theHashTable.hashValue("creeping"));
		System.out.println("Hash value of 'everything': "
				+ theHashTable.hashValue("everything"));
		System.out.println("Hash value of 'ourselves': "
				+ theHashTable.hashValue("ourselves"));
		System.out.println("Hash value of 'himself': "
				+ theHashTable.hashValue("himself"));
		System.out.println("Hash value of 'finished': "
				+ theHashTable.hashValue("finished"));
		System.out.println("Hash value of 'seventh': "
				+ theHashTable.hashValue("seventh"));
		System.out.println("Hash value of 'learned': "
				+ theHashTable.hashValue("learned"));
		System.out.println("Hash value of 'receive': "
				+ theHashTable.hashValue("receive"));

		theHashTable.remove("seventh");
		System.out.println("Number of items: " + theHashTable.size());
		
		System.out.println("");
		System.out.print("Table: ");
		theHashTable.display();
	}

	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

	public static int getInt() throws IOException {
		String s = getString();
		return Integer.parseInt(s);
	}

}
