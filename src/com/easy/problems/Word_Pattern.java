// https://leetcode.com/problems/word-pattern/

/*
	Given a pattern and a string s, find if s follows the same pattern.
	
	Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
	
	Example 1:
	
	Input: pattern = "abba", s = "dog cat cat dog"
	Output: true
	Example 2:
	
	Input: pattern = "abba", s = "dog cat cat fish"
	Output: false
	Example 3:
	
	Input: pattern = "aaaa", s = "dog cat cat dog"
	Output: false
	 
	Constraints:
	
	1 <= pattern.length <= 300
	pattern contains only lower-case English letters.
	1 <= s.length <= 3000
	s contains only lowercase English letters and spaces ' '.
	s does not contain any leading or trailing spaces.
	All the words in s are separated by a single space.
*/

package com.easy.problems;
import java.util.*;

public class Word_Pattern {
	public boolean wordPattern(String pattern, String s) {
        HashMap<String, String> hm = new HashMap<>();
        String[] str = s.split(" ");
        
        if(pattern.length() != str.length)
            return false;
        
        for(int i = 0; i < str.length; i++){
            if(hm.containsKey(Character.toString(pattern.charAt(i)))){
                if(!hm.get(Character.toString(pattern.charAt(i))).equals(str[i])){
                    return false;
                }
            }
            hm.put(Character.toString(pattern.charAt(i)), str[i]);
        }
        
        HashMap<String, String> hm2 = new HashMap<>();
        
        for(int i = 0; i < str.length; i++){
            if(hm2.containsKey(str[i])){
                if(!hm2.get(str[i]).equals(Character.toString(pattern.charAt(i)))){
                    return false;
                }
            }
            hm2.put(str[i], Character.toString(pattern.charAt(i)));
        }
        
        return true;
    }
}
