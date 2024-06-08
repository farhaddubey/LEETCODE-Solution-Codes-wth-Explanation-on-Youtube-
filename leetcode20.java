class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack= new Stack<Character>();
        // Stack is a LIFO DSA that's helpful for matching pair of characters
        Map<Character, Character> mapping = new HashMap<>();
        // Hashmap  is used to store mapping of closing brackets to corresponding  opening brackets. Map is used here to provide a quick lookup.
        mapping.put(')', '(');
        mapping.put('}', '{');
        mapping.put(']', '[');
        // these lines populate the mathing with key value pair. closing-->key & opening-->value. this helps in chcking if an closing brackets is having an opening brackets.
        for(char c: s.toCharArray()){
            // toCharArray() method converts the string into iterable array 
            if(mapping.containsValue(c)){
                // it checks if the incoming is VALUE that is opening bracket then pushed
                stack.push(c);
            }else if(mapping.containsKey(c)){
                // checks if that's a incoming KEY
                if(stack.isEmpty() || mapping.get(c) !=stack.pop()){
                    // if corresponding VALUE is not present or stack is Empty that is Closing bracket si before Opening then that's not matching pair
                    return false;
                }
            }
        }
        // After popping if stack is Empty that returns true 
        return stack.isEmpty();
    }
    public static void main(String[] args){
        Solution sol1 = new Solution();
        String s="()";
        boolean result=sol1.isValid(s);
    }
}
// Runtime: 122MS, Beats : 5.18% 