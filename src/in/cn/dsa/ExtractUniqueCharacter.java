package in.cn.dsa;

import java.util.HashMap;

public class ExtractUniqueCharacter {
	
	public static String uniqueChar(String str){
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/

		HashMap<Character, Integer> map = new HashMap<>();

		String res = "";

		for(int i = 0; i < str.length(); i++){
			if(map.get(str.charAt(i)) != null){
				int value = map.get(str.charAt(i));
				map.put(str.charAt(i), value+1);
			}
			else{
				res = res + str.charAt(i);
				map.put(str.charAt(i), 1);
			}
		}

		return res;

	}
}
