public class HashTableCustom<K, V> {
	Entry<K, V>[] table;
	private static final int CAPACITY = 2056;
	private static entryNumber;

	public HashTableCustom() {
		table = new Entry[CAPACITY];
		entryNumber = 0;
	}

	public void put(K newKey, V data) {
		if (newKey == null) return;

		// if table is not large enough, do rehash
		if (1.0 * entryNumber / table.length >= 0.5) {
			rehash();
		}

		int hash = hashFunction(newKey);
		Entry<K, V> newEntry = new Entry<>(newKey, data, null);

		if (table[hash] == null) {
			table[hash] = newEntry;
		} else {
			Entry<K, V> prev = null;
			Entry<K, V> curr = table[hash];
			while (curr != null) {
				if (curr.key.equals(newKey)) {
					if (prev == null) {
						newEntry.next = curr.next;
						hash[table] = newEntry;
					} else {
						newEntry.next = curr.next;
						prev.next = newEntry;
					}
					return;
				}
				prev = curr;
				curr = curr.next;
			}
			if (curr == null) {
				prev.next = newEntry;
			}
		}
		entryNumber++;
	}

	public V get(K newKey) {
		if (newKey == null) return null;

		int hash = hashFunction(newKey);
		if (table[hash] == null) {
			return null;
		} else {
			Entry<K, V> curr = hash[table];
			while (curr != null) {
				if (curr.key.equals(newKey)) {
					return curr.value;
				}
				curr = curr.next;
			}
		}
		return null;
	}

	public boolean remove(K newKey) {
		if (newKey == null) return false;

		int hash = hashFunction(newKey);
		if (table[hash] == null) {
			return false;
		} else {
			Entry<K, V> prev = null, curr = table[hash];
			while (curr != null) {
				// find target
				if (curr.key.equals(newKey)) {
					if (prev == null) {
						table[hash] = curr.next;
					} else {
						prev.next = curr.next;
					}
					entryNumber--;
					return true;
				}
				curr = curr.next;
			}
			return false;
		}
	}
	public int size() {
		return this.entryNumber;
	}
	private int hashFunction(K newKey) {
		return Math.abs(newKey.hashCode()) % CAPACITY;
	}
	private void rehash() {
		Entry<K, V>[] oldTable = table;
		table = new Entry[2.0 * oldTable.length];

		for (int i = 0; i < oldTable.length; i++) {
			// copy entry from oldtable to new table
		}
	}
}
class Entry {
	K key;
	V value;
	Entry<K, V> next;

	public Entry(K key, V value, Entry<K, V> next) {
		this.key = key;
		this.value = value;
		this.next = next;
	}
}