package in.dsa.striver;

import java.util.HashSet;
import java.util.Set;

public class LongestConsSequence {
	
	public int lengthOfLongestConsSequence(int[] nums) {
		
		if(nums == null || nums.length == 0) return 0;
		
		Set<Integer> set = new HashSet<>();
		
		//traversing the array and putting it in set:
		for(int elem : nums) {
			set.add(elem);
		}
		
		//traversing the array and check if the num-1 exist ? continue : increase the num by one and check how far it goes and cal length
		
		int longestStreak = 0;
		
		//if i want to return the first and last elem of the longest sequence:
		int first = -1;
		int last = -1;
		
		for(int i = 0; i < nums.length; i++) {
			
			if(!set.contains(nums[i] - 1)) {
				
				int elem = nums[i]; //99 100
				int currentStreak = 1;  //2
				
				int start = nums[i];
				int end = nums[i];
	
				
				while(set.contains(elem+1)) {
					elem = elem + 1;
					end = elem;
					currentStreak++;
				}
				
				if(currentStreak > longestStreak) {
					longestStreak = currentStreak;
					first = start;
					last = end;
				}
				
			}
			
		}
		return longestStreak;
	}

}
