package in.dsa.striver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSumProblem {

	public ArrayList<List<Integer>> fourSum(int[] num, int target){
		
		ArrayList<List<Integer>> list = new ArrayList<>();
		
		if(num == null || num.length == 0) return list;
		
		
		//Sorting the Array:
		Arrays.sort(num);
		
		for(int i = 0; i < num.length; i++) {
			
			for(int j = i+1; i < num.length; j++) {
				
				int target_2 = target - (num[i] + num[j]);
				
				int left = j + 1;
				int right = num.length - 1;
				
				while(left < right) {
					
					if(num[left] + num[right] < target_2) left++;
					else if(num[left] + num[right] > target_2) right--;
					else {
						List<Integer> quadList = new ArrayList<>();
						quadList.add(num[i]);
						quadList.add(num[j]);
						quadList.add(num[left]);
						quadList.add(num[right]);
						
						list.add(quadList);
						
						//moving the left pointer to the non-duplicate number:
						while(left < right && num[left] == quadList.get(2)) left++;
						
						
						//moving the right pointer to the non-duplicate number:
						while(left < right && num[right] == quadList.get(3)) right--;
					}
				}
				
				//moving the j pointer to the next non-duplicate elem:
				while(j+1 < num.length && num[j] == num[j+1]) j++;
				
			}
			
			//moving the i pointer to the next non-duplicate elem:
			while(i+1 < num.length && num[i] == num[i+1]) i++;
			
		}
		
		return list;
	}
	
}
