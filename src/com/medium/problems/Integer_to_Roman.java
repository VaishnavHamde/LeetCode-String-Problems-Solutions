// https://leetcode.com/problems/integer-to-roman/

/*
	Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
	
	Symbol       Value
	I             1
	V             5
	X             10
	L             50
	C             100
	D             500
	M             1000
	
	For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. 
	The number 27 is written as XXVII, which is XX + V + II.
	
	Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. 
	Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle 
	applies to the number nine, which is written as IX. There are six instances where subtraction is used:
	
	I can be placed before V (5) and X (10) to make 4 and 9. 
	X can be placed before L (50) and C (100) to make 40 and 90. 
	C can be placed before D (500) and M (1000) to make 400 and 900.
	Given an integer, convert it to a roman numeral.
	 
	Example 1:
	
	Input: num = 3
	Output: "III"
	Explanation: 3 is represented as 3 ones.
	Example 2:
	
	Input: num = 58
	Output: "LVIII"
	Explanation: L = 50, V = 5, III = 3.
	Example 3:
	
	Input: num = 1994
	Output: "MCMXCIV"
	Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
	 
	Constraints:
	
	1 <= num <= 3999
*/

package com.medium.problems;

public class Integer_to_Roman {
	public String intToRoman(int num) {
        int temp = num;
        int len = 0;
        while(temp > 0){
            len++;
            temp/=10;
        }
        
        temp = num;
        StringBuilder ans = new StringBuilder();
        
        for(int i = 0; i < len; i++){
            int ger = temp%10;
            temp /= 10;
            
            if(i == 0){
                if(ger < 4){
                    while(ger != 0){
                        ans.append("I");
                        ger--;
                    }
                }
                else if(ger == 4){
                    ans.append("VI");
                }
                else if(ger == 5){
                    ans.append("V");
                }
                else if(ger > 5 && ger < 9){
                    while(ger != 5){
                        ans.append("I");
                        ger--;
                    }
                    ans.append("V");
                }
                else if(ger == 9){
                    ans.append("XI");
                }
                continue;
            }
            
            if(i == 1){
                if(ger < 4){
                    while(ger != 0){
                        ans.append("X");
                        ger--;
                    }
                }
                else if(ger == 4){
                    ans.append("LX");
                }
                else if(ger == 5){
                    ans.append("L");
                }
                else if(ger > 5 && ger < 9){
                    while(ger != 5){
                        ans.append("X");
                        ger--;
                    }
                    ans.append("L");
                }
                else if(ger == 9){
                    ans.append("CX");
                }
                continue;
            }
            
            if(i == 2){
                if(ger < 4){
                    while(ger != 0){
                        ans.append("C");
                        ger--;
                    }
                }
                else if(ger == 4){
                    ans.append("DC");
                }
                else if(ger == 5){
                    ans.append("D");
                }
                else if(ger > 5 && ger < 9){
                    while(ger != 5){
                        ans.append("C");
                        ger--;
                    }
                    ans.append("D");
                }
                else if(ger == 9){
                    ans.append("MC");
                }
                continue;
            }
            
            if(i == 3){
                if(ger < 4){
                    while(ger != 0){
                        ans.append("M");
                        ger--;
                    }
                }
            }
        }
        
        return ans.reverse().toString();
    }
}
