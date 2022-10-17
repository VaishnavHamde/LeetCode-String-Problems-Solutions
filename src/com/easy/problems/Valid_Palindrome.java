// https://leetcode.com/problems/valid-palindrome/

/*
	A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, 
	it reads the same forward and backward. Alphanumeric characters include letters and numbers.
	Given a string s, return true if it is a palindrome, or false otherwise.
	
	Example 1:
	
	Input: s = "A man, a plan, a canal: Panama"
	Output: true
	Explanation: "amanaplanacanalpanama" is a palindrome.
	Example 2:
	
	Input: s = "race a car"
	Output: false
	Explanation: "raceacar" is not a palindrome.
	Example 3:
	
	Input: s = " "
	Output: true
	Explanation: s is an empty string "" after removing non-alphanumeric characters.
	Since an empty string reads the same forward and backward, it is a palindrome.
	
	Constraints:
	
	1 <= s.length <= 2 * 105
	s consists only of printable ASCII characters.
*/

package com.easy.problems;

public class Valid_Palindrome {
	public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++)
            if(64 < s.charAt(i) && s.charAt(i) < 91 || 96 < s.charAt(i) && s.charAt(i) < 123 || 47 < s.charAt(i) && s.charAt(i) < 58)
                str.append(s.charAt(i));
        
        String str2 = str.toString();
        str = new StringBuilder(str2.toLowerCase());
        
        int low = 0;
        int high = str.length()-1;
        
        while(high>low){
            if(str.charAt(low) != str.charAt(high))
            	return false;
            low++;
            high--;
        }
        
        return true;
	}
}
