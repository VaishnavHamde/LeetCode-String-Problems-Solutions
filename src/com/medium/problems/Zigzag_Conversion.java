// https://leetcode.com/problems/zigzag-conversion/

/*
	The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a 
	fixed font for better legibility)

	P   A   H   N
	A P L S I I G
	Y   I   R
	And then read line by line: "PAHNAPLSIIGYIR"
	
	Write the code that will take a string and make this conversion given a number of rows:
	
	string convert(string s, int numRows);
	 
	Example 1:
	
	Input: s = "PAYPALISHIRING", numRows = 3
	Output: "PAHNAPLSIIGYIR"
	Example 2:
	
	Input: s = "PAYPALISHIRING", numRows = 4
	Output: "PINALSIGYAHRPI"
	Explanation:
	P     I    N
	A   L S  I G
	Y A   H R
	P     I
	
	Example 3:
	
	Input: s = "A", numRows = 1
	Output: "A"
	 
	Constraints:
	
	1 <= s.length <= 1000
	s consists of English letters (lower-case and upper-case), ',' and '.'.
	1 <= numRows <= 1000
*/

package com.medium.problems;

public class Zigzag_Conversion {
	public String convert(String s, int numRows) {
        StringBuilder str = new StringBuilder();
        if(numRows == 1)
            return s;
        int x = numRows + (numRows - 2);
        int y = 0;
        for(int i = 0; i < numRows; i++){
            int temp = i;
            boolean bool = true;
            while(temp < s.length()){
                str.append(s.charAt(temp));
                if(i == 0)
                     temp += x;
                else if(i == numRows-1)
                    temp += y;
                else if(bool){
                    temp += x;
                    bool = false;
                }
                else{
                    temp += y;
                    bool = true;
                }
            }
            x-=2;
            y+=2;
        }
        return str.toString();
    }
}
