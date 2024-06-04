class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> m = new HashMap<>();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);

        int ans = 0;
        for(int i=0; i<s.length(); i++){
            if(i<s.length()-1 && m.get(s.charAt(i))<m.get(s.charAt(i+1))){
                // if not last index and lesser, then substracting
                ans -= m.get(s.charAt(i));
            }else{
                ans += m.get(s.charAt(i));
            }
        }
        return ans;

    }
    public static void main(String[] args){
        String s="III";
        Solution sol1=new Solution();
        int n=sol1.romanToInt(s);
    }
}
// Beats 30.32% user Runtime: 6ms & Memory 44.66MB  
class Solution {
    public int romanToInt(String s) {
        /**Map<Character, Integer> scoreMap = new HashMap();
        scoreMap.put('I', 1);
        scoreMap.put('V', 5);
        scoreMap.put('X', 10);
        scoreMap.put('L', 50);
        scoreMap.put('C', 100);
        scoreMap.put('D', 500);
        scoreMap.put('M', 1000);*/
        int prevCharValue = 0;
        int sum = 0;
        for(int i = 0;  i < s.length(); i++){
            int curCharValue = getCharValue(s.charAt(i));
            // could also use map to get the value
            if(prevCharValue < curCharValue)
                sum -= prevCharValue;
            else sum += prevCharValue;
            prevCharValue = curCharValue;
        }
        sum += prevCharValue;
        return sum;
    }
    
    private int getCharValue(char c){
        switch(c){
            case 'I': 
                return 1;
            case 'V': 
                return 5;
            case 'X': 
                return 10;
            case 'L': 
                return 50;
            case 'C': 
                return 100;
            case 'D': 
                return 500;
            case 'M': 
                return 1000;
            default:
                return 0;
        }
    }
       public static void main(String[] args){
        String s="III";
        Solution sol1=new Solution();
        int n=sol1.romanToInt(s);
    }
}
Runtime:  3 ms
Beats % of user:80.89
Memory:44.4 MB
Beats % of user:73.62


class Solution {
    public int romanToInt(String s){
        int num=0, prev=0;
                // Looping through the characters of the string from right to left.
        for(int i=s.length()-1; i>=0; i--){
            int c = getValue(s.charAt(i));
                        // If the current value is less than the previous value, subtracting it from 'num'.
            if(c<prev)
                num=num-c;
            else 
                        // Otherwise, adding the current value to 'num'.
                num=num+c;
                            // Updating 'prev' to the current value for the next iteration.
                prev =c;

        }
        return num;
    }
    private int getValue(char s){
        switch(s){
            case 'I': return 1;
            case 'V': return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

       public static void main(String[] args){
        String s="III";
        Solution sol1=new Solution();
        int n=sol1.romanToInt(s);
    }
}
Runtime:  2 ms
Beats % of user:100%
Memory:44.4 MB
Beats % of user:73.62