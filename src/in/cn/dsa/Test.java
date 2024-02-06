package in.cn.dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Test {
	
	private static ArrayList<Integer> removeDuplicate(int[] arr) {
		
		HashMap<Integer, Integer> map = new HashMap<>();
		ArrayList<Integer> arrayList = new ArrayList<>();
		
		for(int i = 0; i < arr.length; i++) {
			if(!map.containsKey(arr[i])) {
				map.put(arr[i], i);
				arrayList.add(arr[i]);
			}
		}
		
		return arrayList;
	}

	public static void main(String[] args) {
		
		int[] arr = {1,3,2,2,3,1,6,2,5};
		ArrayList<Integer> list = removeDuplicate(arr);
//		list.forEach(System.out::println);
		
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		map.put(3, 40);
		map.put(2, 20);
		map.put(1, 30);
		
//		if(map.containsKey(1)) {
//			int val = map.get(1);
//			map.put(1, val+1);
//			System.out.println(map.get(1));
//		}
		
		Set<Integer> keys = map.keySet();
		for(int s : keys) {
			System.out.println(s + ": " + map.get(s));
		}
		
		
		
	}


}
