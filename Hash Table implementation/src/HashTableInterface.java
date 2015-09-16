

/***************************************************************
 * 
 *Interface for HashTable
 *A simple HashTable interface that takes lowercase String values
 *
 * Helper Resources Acknowledgement:-
 * Prof.Terry Lee
 * Carnegie Mellon University
 *
 ***************************************************************/

public interface HashTableInterface {

	/**
	 * Inserts a new String value (word).
	 * Frequency of each word is stored too.
	 *
	 * @param value String value to be added.
	 */
	void insert(String value);

	/**
	 * Returns the size, number of items, of the table
	 *
	 * @return the number of items in the table.
	 */
	int size();

	/**
	 * Displays the values of the table
	 * If an index is empty, it shows #NULL#
	 * If previously existed dataitem is deleted at a slot, then it shows #DELETED#
	 */
	void display();

	/**
	 * Returns true if value is contained in the table
	 *
	 * @param key String key value to be searched
	 * @return true if found, false if not found.
	 */
	boolean contains(String key);

	/**
	 * Returns the number of collisions in relation to insert and rehash.
	 *
	 * @return number of collisions
	 */
	int numOfCollisions();

	/**
	 * Returns the hash value of a String
	 *
	 * @param value value for which the hash value is calculated
	 * @return int hash value of a String.
	 */
	int hashValue(String value);

	/**
	 * Removes and returns removed value
	 *
	 * @param value String value to be removed
	 * @return value that is removed
	 */
	String remove(String key);

}