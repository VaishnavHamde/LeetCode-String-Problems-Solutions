// https://leetcode.com/problems/longest-palindrome/

/*
	Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome 
	that can be built with those letters.
	Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
	
	Example 1:
	
	Input: s = "abccccdd"
	Output: 7
	Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
	
	Example 2:
	
	Input: s = "a"
	Output: 1
	Explanation: The longest palindrome that can be built is "a", whose length is 1.
	 
	Constraints:
	
	1 <= s.length <= 2000
	s consists of lowercase and/or uppercase English letters only.
*/

package com.easy.problems;
import java.util.*;

public class Longest_Palindrome {
	class Solution {
	    public int longestPalindrome(String s) {
	        HashMap<Character, Integer> hm = new HashMap<>();
	        for(int i = 0; i < s.length(); i++)
	            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i),0)+1);
	        
	        int sum = 0;
	        boolean bool = false;
	        
	        for(Map.Entry entry : hm.entrySet()){
	                if((int)entry.getValue()%2 == 0)
	                    sum = (int)entry.getValue() + sum;
	                else
	                    sum = (int)entry.getValue() - 1 + sum;
	                
	            if((int)entry.getValue()%2 != 0)
	                bool = true;
	        }
	        
	        if(bool)
	            sum++;
	        return sum;
	    }
	}
}
