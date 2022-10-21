// https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/

/*
	You are given two strings of the same length s and t. In one step you can choose any character of t and replace it with another character.
	Return the minimum number of steps to make t an anagram of s.
	An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.
	
	Example 1:
	
	Input: s = "bab", t = "aba"
	Output: 1
	Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.
	Example 2:
	
	Input: s = "leetcode", t = "practice"
	Output: 5
	Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.
	Example 3:
	
	Input: s = "anagram", t = "mangaar"
	Output: 0
	Explanation: "anagram" and "mangaar" are anagrams. 
	
	Constraints:
	
	1 <= s.length <= 5 * 104
	s.length == t.length
	s and t consist of lowercase English letters only.
*/

package com.medium.problems;
import java.util.*;

public class Minimum_Number_of_Steps_to_Make_Two_Strings_Anagram {
	public int minSteps(String s, String t) {
        HashMap<Character, Integer> hms = new HashMap<>();
        HashMap<Character, Integer> hmt = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            hms.put(s.charAt(i), hms.getOrDefault(s.charAt(i), 0) + 1);
            hmt.put(t.charAt(i), hmt.getOrDefault(t.charAt(i), 0) + 1);
        }

        int count = 0;

        for(Map.Entry entry : hms.entrySet()){
            if(hmt.containsKey(entry.getKey())){
                if((int)entry.getValue() > (int)hmt.get(entry.getKey()))
                    count = count + (int)entry.getValue() - (int)hmt.get(entry.getKey());
            }
            else{
                count += (int)entry.getValue();
            }

        }

        return count;
    }
}
