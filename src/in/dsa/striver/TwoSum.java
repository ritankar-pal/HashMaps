package in.dsa.striver;

import java.util.HashMap;

public class TwoSum {
	
	public int[] twoSum(int[] numbers, int target) {
		
		int[] res = new int[2];
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < numbers.length; i++) {
			
			int rem = Math.abs(target - numbers[i]);
			
			if(map.containsKey(rem)) {
				res[0] = map.get(rem);
				res[1] = i;
				return res;
			}
			else {
				map.put(numbers[i], i);
			}
			
		}
		
		
		return res;
	}
	
}
