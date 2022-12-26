package com.test.SwagLabs;

import java.util.HashMap;

import org.apache.commons.lang.Validate;

public class SagarDsLearning {
	
	public boolean boolisUniqueCharInString(String strInput) {
		HashMap<Character, Integer> hashMap = new HashMap<>();
		for(Character c: strInput.toCharArray()) {
			if(hashMap.containsKey(c)) {
				Integer countInteger = hashMap.get(c).intValue();
				countInteger++;	
			} else {
				hashMap.put(c, 0);
			}
		}
		for(Integer count: hashMap.values()) {
			if(count > 1)return false;
		}
		return true;
	}

}
