package in.cn.customHashMap;

import java.util.ArrayList;

public class CustomMap<K,V> {

	ArrayList<MapNode<K, V>> buckets;
	int count;
	int numBuckets;

	public CustomMap() {
		this.buckets = new ArrayList<>();
		this.numBuckets = 5;
		for(int i = 0; i < this.numBuckets; i++) {
			buckets.add(null);
		}
	}


	public int size() {
		return count;
	}


	public V getValue(K key) {

		int bucketIndex = getBucketIndex(key);

		MapNode<K, V> head = buckets.get(bucketIndex);
		MapNode<K, V> helper = head;

		//searching: check if the key is already present, if yes then just return the value:
		while(helper != null) {
			if(helper.key.equals(key)) {
				return helper.value;
			}
			helper = helper.next;
		}
		
		return null;
	}


	//hash function: returns the compressed integer (hash code + compression):
	private int getBucketIndex(K key) {
		int hc = key.hashCode();
		int index = hc % numBuckets;
		return index;
	}

	
	private void reHash() {
		
		ArrayList<MapNode<K, V>> temp = buckets;
		buckets = new ArrayList<>();
		
		//double the size of the ArrayList<>
		for(int i = 0; i < 2 * numBuckets; i++) {
			buckets.add(null);
		}
		
		count = 0; 
		numBuckets = 2 * numBuckets;
		
		//iterating over the temp and putting each node of the LinkedList in each bucket of buckets:
		for(int i = 0; i < temp.size(); i++) {
			MapNode<K, V> head = temp.get(i);
			
			while(head != null) {
				K key = head.key;
				V value = head.value;
				insert(key, value);
				head = head.next;
			}
		}
		
	}
	
	public double loadFactor() {
		return (1.0 * count) / numBuckets;
	}
	
	
	public void insert(K key, V value) {

		int bucketIndex = getBucketIndex(key);

		MapNode<K, V> head = buckets.get(bucketIndex);
		MapNode<K, V> helper = head;

		//searching: check if the key is already present, if yes then just update the value else add the key:
		while(helper != null) {
			if(helper.key.equals(key)) {
				helper.value = value;
				return;
			}
			helper = helper.next;
		}

		//key is not present so added to the front of LL and updated head is replaced with the current head at bucketIndex:
		MapNode<K, V> node = new MapNode<>(key, value);
		node.next = head;
		buckets.set(bucketIndex, node);
		count++;
		
		//If loadfactor is > 0.7 then we will increase the size of numBuckets:
		double loadFactor = (1.0 * count) / numBuckets;
		if(loadFactor > 0.7) {
			reHash();
		}

	}
	


	public V removeKey(K key) {
		
		int bucketIndex = getBucketIndex(key);

		MapNode<K, V> head = buckets.get(bucketIndex);
		MapNode<K, V> prev = null;
		
		while(head != null) {
			
			if(head.key.equals(key)) {
				if(prev != null) {
					prev.next = head.next;
				}
				else {
					buckets.set(bucketIndex, head.next);
				}
				count--;
				return head.value;
			}
			
			prev = head;
			head = head.next;
		}
		
		return null;
	}

}
