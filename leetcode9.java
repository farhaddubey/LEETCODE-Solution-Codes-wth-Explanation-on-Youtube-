// 9. Palindrome Number
// Solved
// Easy
// Topics
// Companies
// Hint
// Given an integer x, return true if x is a 
// palindrome
// , and false otherwise.

 

// Example 1:

// Input: x = 121
// Output: true
// Explanation: 121 reads as 121 from left to right and from right to left.
// Example 2:

// Input: x = -121
// Output: false
// Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
// Example 3:

// Input: x = 10
// Output: false
// Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 

// Constraints:

// -231 <= x <= 231 - 1
 

// Follow up: Could you solve it without converting the integer to a string?
// ''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
// Method 1
class leetcode9 {
    public boolean isPalindrome(int x) {
        int sum=0; int rem, res=x;
        int count=0;
        do{
            rem = res%10;
            res = res/10;
            sum = sum*10 + rem;
        }while(res!=0);
        if(x<0){
            return false;
        }else if(x==sum){
            return true;
        }
        else 
            return false;        
    }
    public static void main(String[] args){
        int x=121;
        leetcode9 sol = new leetcode9();
        boolean pal=sol.isPalindrome(x);
    }
}
// Runtime
// 4
// ms
// Beats
// 100.00%
// of users with Java
// Memory
// 43.60
// MB
// Beats
// 90.18%
// of users with Java
// Method 2 the Optimized Version 
class Solution {
    public boolean isPalindrome(int x) {     
        if(x<0){
            return false;
        }  
        long reversed = 0;
        long temp =x;
        while(temp!=0){
            int rem =(int) temp%10;
            reversed = reversed*10 + rem;
            temp/=10;
        }
        return (x==reversed);
    }
    public static void main(String[] args){
        int x=121;
        Solution sol = new Solution();
        boolean pal=sol.isPalindrome(x);
    }
}
 
// Method 3 Reversing Half of the Number


class Solution {
    public boolean isPalindrome(int x) {
        // int sum=0; int rem, res=x;
        // int count=0;
        // do{
        //     rem = res%10;
        //     res = res/10;
        //     sum = sum*10 + rem;
        // }while(res!=0);
        // if(x<0){
        //     return false;
        // }else if(x==sum){
        //     return true;
        // }
        // else 
        //     return false;      

        // Method 2: the more concise & Optimized version 
        // if(x<0){
        //     return false;
        // }  
        // long reversed = 0;
        // long temp =x;
        // while(temp!=0){
        //     int rem =(int) temp%10;
        //     reversed = reversed*10 + rem;
        //     temp/=10;
        // }
        // return (x==reversed);

        // Method 3: Reversing only Half part 
        if(x<0 || (x!=0 && x%10==0)){
            return false;
        }
        int reversed = 0;
        int original = x;
        while(x>reversed){
            reversed = reversed*10+x%10;
            x/=10;
        }
        return (x==reversed) || (x==reversed/10);
    }
    public static void main(String[] args){
        int x=121;
        Solution sol = new Solution();
        boolean pal=sol.isPalindrome(x);
    }
}