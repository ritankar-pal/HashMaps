package in.cn.dsa;

import java.util.HashMap;

public class PrintIntersection {

	public static void printIntersection(int[] arr1,int[] arr2){

		HashMap<Integer, Integer> map = new HashMap<>();

		for(int i = 0; i < arr1.length; i++){
			if(map.containsKey(arr1[i])){
				int value = map.get(arr1[i]);
				map.put(arr1[i], value+1);
			}
			else map.put(arr1[i], 1);
		}

		for(int i = 0; i < arr2.length; i++){

			if(map.containsKey(arr2[i])){
				int value = map.get(arr2[i]);

				System.out.println(arr2[i]);

				value = value - 1;

				if(value == 0){
					map.remove(arr2[i]);
					continue;
				}
				map.put(arr2[i], value);
			}

		}

	}
}
