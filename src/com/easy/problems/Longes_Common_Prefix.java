// https://leetcode.com/problems/longest-common-prefix/

/*
	Write a function to find the longest common prefix string amongst an array of strings.
	If there is no common prefix, return an empty string "".
	 
	Example 1:
	
	Input: strs = ["flower","flow","flight"]
	Output: "fl"
	Example 2:
	
	Input: strs = ["dog","racecar","car"]
	Output: ""
	Explanation: There is no common prefix among the input strings.
	 
	Constraints:
	
	1 <= strs.length <= 200
	0 <= strs[i].length <= 200
	strs[i] consists of only lowercase English letters.
*/

package com.easy.problems;

public class Longes_Common_Prefix {
	public String longestCommonPrefix(String[] strs) {
        String str = strs[0];
        
        for(int i = 0; i < strs.length-1; i++){
            if(str.length() > strs[i+1].length()){
                str = strs[i+1];
            }
        }
        System.out.println(str);
        for(int i = 0; i < strs.length; i++){
            if(!str.equals(strs[i].substring(0, str.length()))){
                str = common(str, strs[i]);
                i = 0;
            }
        }
        
        return str;
    }
    
    public String common(String str, String word){
        int temp = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != word.charAt(i)){
                temp = i;
                break;
            }
        }
        return str.substring(0, temp);
    }
}
