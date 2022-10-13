// https://leetcode.com/problems/rotate-string/

/*
	Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
	A shift on s consists of moving the leftmost character of s to the rightmost position.
	For example, if s = "abcde", then it will be "bcdea" after one shift.
	
	Example 1:
	
	Input: s = "abcde", goal = "cdeab"
	Output: true
	Example 2:
	
	Input: s = "abcde", goal = "abced"
	Output: false
	 
	Constraints:
	
	1 <= s.length, goal.length <= 100
	s and goal consist of lowercase English letters.
*/

package com.easy.problems;

public class Rotate_String {
	public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length())
            return false;
        
        int x = s.length();
        
        for(int i = 0; i < x; i++){
            char temp = s.charAt(0);
            s = s.substring(1,x) + temp;
            System.out.println(s);
            if(s.equals(goal))
                return true;
        }
         return false;
    }
}
