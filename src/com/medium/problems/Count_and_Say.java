// https://leetcode.com/problems/count-and-say/

/*
	The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
	
	countAndSay(1) = "1"
	countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
	To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one 
	unique digit. Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.
	
	Given a positive integer n, return the nth term of the count-and-say sequence.
	
	Example 1:
	
	Input: n = 1
	Output: "1"
	Explanation: This is the base case.
	Example 2:
	
	Input: n = 4
	Output: "1211"
	Explanation:
	countAndSay(1) = "1"
	countAndSay(2) = say "1" = one 1 = "11"
	countAndSay(3) = say "11" = two 1's = "21"
	countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
	
	Constraints:
	
	1 <= n <= 30
*/

package com.medium.problems;

public class Count_and_Say {
	public String countAndSay(int n) {
        if(n == 1)
            return Integer.toString(1);
        String res = "";
        if(n > 0)
            res = number(n-2, "11");
        return res;
    }
    
    public String number(int n, String num){
        StringBuilder n1 = new StringBuilder("");
        if(n > 0){
            int count = 1;
            int temp = 1;
            for(int i = 0; i < num.length()-1;i++){
                int f = i;
                while(i < num.length()-1 && num.charAt(i) == num.charAt(i+1)){
                    if(f == 0)
                        f = i;
                    count++;
                    temp = count;
                    i++;
                }
                if(i != num.length()-1 && num.charAt(i) != num.charAt(i+1))
                    count = 1;
                n1.append(Integer.toString(temp));
                n1.append(Character.toString(num.charAt(f)));
                temp = 1;
            }
            
            if(num.charAt(num.length()-2) != num.charAt(num.length()-1)){
                n1.append(Integer.toString(1));
                n1.append(num.charAt(num.length()-1));
            }
            num = number(n-1, n1.toString());
        }
        return num;
    }
}