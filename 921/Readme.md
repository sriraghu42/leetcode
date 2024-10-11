## **921. Minimum Add to Make Parentheses Valid**

**Medium**

A parentheses string is valid if and only if:<br>
It is the empty string, <br>
It can be written as AB (A concatenated with B), where A and B are valid strings, or <br>
It can be written as (A), where A is a valid string. <br>
You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string. <br>

For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))". <br>
Return the minimum number of moves required to make s valid.

Example 1:

Input: s = "())" <br>
Output: 1<br>
Example 2:

Input: s = "((("<br>
Output: 3
 
Constraints:

1 <= s.length <= 1000 <br>
s[i] is either '(' or ')'.
