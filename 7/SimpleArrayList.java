/**
 * The class creates a custom array list and automatically grows or shrinks the internal array when elements are added or removed
 */
public class SimpleArrayList {
	private Integer[] data;
	private int size;
	/**
	 * Constructs an empty SimpleArrayList with an initial size of 0
	 */
	public SimpleArrayList() {
		data = new Integer[0];
		size = 0;
	}
	/**
	 * Constructs an empty SimpleArrayList with an specified initial size and all elements are initialized to zero
	 * @param initialSize the initial number of elements (cannot be negative)
	 */
	public SimpleArrayList(int initialSize) {
		if (initialSize < 0) {
			throw new IllegalArgumentException("Initial size cannot be negative.");
		}
		data = new Integer[initialSize];
		for (int i = 0; i < initialSize; i++) {
			data[i] = 0;
		}
		size = initialSize;
	}
	/**
	 * Automatically resizes the array if needed and adds the specified elements to the end of the list
	 * @param i the integer element to add
	 */
	public void add(Integer i) {
		ensureCapacity(size + 1);
		data[size] = i;
		size++;
	}
	/**
	 * Use if statement to ensure that the array has enough capacity to store the specified number of elements
	 * @param minCapacity the minimum capacity needed
	 */
	private void ensureCapacity(int minCapacity) {
		if (minCapacity > data.length) {
			Integer[] newData = new Integer[minCapacity];
			for (int i = 0; i < size; i++) {
				newData[i] = data[i];
			}
			data = newData;
		}
	}
	/**
	 * Returns the element at the specified position in the list
	 * @param index the index of the element to return
	 * @return the integer element at the specified index, or null if out of bounds
	 */
	public Integer get(int index) {
		if (index < 0 || index >= size) {
			return null;
		}
		return data[index];
	}
	/**
	 * Replaces the element at the specified position with the given element
	 * @param index the index of the element to replace
	 * @param element the new element to store
	 * @return the original element that was replaced, or null if index is out of bounds
	 */
	public Integer set(int index, Integer element) {
		if (index < 0|| index >= size) {
			return null;
		}
		Integer old = data[index];
		data[index] = element;
		return old;
	}
	/**
	 * Use for statement to remove the element at the specified position in the list and use if statement to return the boolean whether the element was removed
	 * @param index the index of the element to remove
	 * @return true if the element was removed; false if the element was already null or index is invalid
	 */
	public boolean remove(int index) {
		if (index < 0 || index >= size || data[index] == null) {
			return false;
		}
		for (int i = index; i < size - 1; i++) {
			data[i] = data[i + 1];
		}
		size--;
		shrinkCapacity();
		return true;
	}
	/**
	 * Shirks the array to fit the current number of elements exactly
	 */
	private void shrinkCapacity() {
		if (size < data.length) {
			Integer[] newData = new Integer[size];
			for (int i = 0; i< size; i++) {
				newData[i] = data[i];
			}
			data = newData;
		}
	}
	/**
	 * Removes all elements from the list and resets to size 0
	 */
	public void clear() {
		data = new Integer[0];
		size = 0;
	}
	/**
	 * Returns the number of elements in the list
	 * @return the number of elements
	 */
	public int size() {
		return size;
	}
	/**
	 * Use for statement, if statement and contain method to retain only the elements in the l list that are also contained and return the boolean whether the list changed or not
	 * @param l the list containing elements to be retained
	 * @return true if the list changed as a result; false otherwise
	 */
	public boolean retainAll(SimpleArrayList l) {
		boolean changed = false;
		int newSize = 0;
		Integer[] newData = new Integer[data.length];
		
		for (int i = 0; i < size; i++) {
			if (l.contains(data[i])) {
				newData[newSize++] = data[i];
			} else {
				changed = true;
			}
		}
		data = newData;
		size = newSize;
		shrinkCapacity();
		return changed;
	}
	/**
	 * Use for statement to check if the list contains the specified value
	 * @param value the value to search for
	 * @return true if the value is found; false otherwise
	 */
	public boolean contains(Integer value) {
		for (int i = 0; i < size; i++) {
			if (data[i] != null && data[i].equals(value)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Main method to test the SimpleArrayList class
	 * @param arg the command-line argument
	 */
	public static void main(String[] arg) {
		System.out.println("=== TASK 1 ===");
		SimpleArrayList list = new SimpleArrayList();
		System.out.println(list.get(0));

		System.out.println("=== TASK 2 ===");
		list.add(2);
		list.add(5);
		list.add(8);
		list.add(1);
		list.add(12);
		System.out.println(list.get(2));

		System.out.println("=== TASK 3 ===");
		System.out.println(list.get(5));

		System.out.println("=== TASK 4 ===");
		System.out.println(list.set(2, 100));

		System.out.println("=== TASK 5 ===");
		System.out.println(list.get(2));

		System.out.println("=== TASK 6 ===");
		System.out.println(list.set(5, 100));

		System.out.println("=== TASK 7 ===");
		System.out.println(list.remove(2));

		System.out.println("=== TASK 8 ===");
		System.out.println(list.get(2));

		System.out.println("=== TASK 9 ===");
		System.out.println(list.remove(2));

		System.out.println("=== TASK 10 ===");
		System.out.println(list.get(2));

		System.out.println("=== TASK 11 ===");
		System.out.println(list.get(3));

		System.out.println("=== TASK 12 ===");
		list.clear();
		System.out.println(list.get(0));

		System.out.println("=== TASK 13 ===");
		SimpleArrayList list2 = new SimpleArrayList(5);
		System.out.println(list2.get(3));

		System.out.println("=== TASK 14 ===");
		System.out.println(list2.get(9));

		System.out.println("=== TASK 15 ===");
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(list2.set(i, i));
		}
		for (int i = 0; i < 5; i++) {
			list.add(i);
		}
		System.out.println(list.retainAll(list2));

		System.out.println("=== TASK 16 ===");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println("=== TASK 17 ===");
		System.out.println(list2.remove(0));
		System.out.println(list2.remove(2));
		System.out.println(list.retainAll(list2));

		System.out.println("=== TASK 18 ===");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println("=== TASK 19 ===");
		System.out.println(list.set(1, null));
		System.out.println(list.remove(1));

		System.out.println("=== TASK 20 ===");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println("=== TASK 21 ===");
		System.out.println(list.set(1, 123));

		System.out.println("=== TASK 22 ===");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println("=== TASK 23 ===");
		System.out.println(list.remove(1));

		System.out.println("=== TASK 24 ===");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println("=== TASK 25 ===");
		list.add(null);
		System.out.println(list.remove(2));

		System.out.println("=== TASK 26 ===");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}