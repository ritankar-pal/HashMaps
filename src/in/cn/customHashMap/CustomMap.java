package in.cn.customHashMap;

import java.util.ArrayList;

public class CustomMap<K,V> {

	ArrayList<MapNode<K, V>> buckets;
	int count;
	int numBuckets;

	public CustomMap() {
		this.buckets = new ArrayList<>();
		this.numBuckets = 20;
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

	}
	
	
	public V removeKey(K key) {
		
		int bucketIndex = getBucketIndex(key);

		MapNode<K, V> head = buckets.get(bucketIndex);
		MapNode<K, V> prev = null;

//		//if head.key == key then remove the head and update the head:
//		if(helper.key.equals(key)) {
//			head = helper.next;
//			buckets.set(bucketIndex, head);
//			return helper.value;
//		}
//		
//		
//		//searching: check if the key is already present, if yes then just remove the node and return the value:
//		while(helper != null) {
//			if(helper.next != null && helper.next.key.equals(key)) {
//				MapNode<K, V> node = helper.next;
//				helper.next = helper.next.next;
//				return node.value;
//			}
//			helper = helper.next;
//		}
		
		
		while(head != null) {
			
			if(head.key.equals(key)) {
				if(prev != null) {
					prev.next = head.next;
				}
				else {
					buckets.set(bucketIndex, head.next);
				}
			}
			
			prev = head;
			head = head.next;
		}
		
		
		return null;
	}

}
