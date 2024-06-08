class Solution{
    public:
        bool isValid(string s){
            stack<char> stack;
            unordered_map<char, char> mapping = {{')', '('}, {']', '['}, {'}', '{'}};
            // unordered_map is initialized for finding opening brackets corresponding to  closing brackets
            for(char c:s){
                // this iterates over s for each char in c
                if(mapping.find(c)==mapping.end()){
                    // .find checks the c if it's from end value of mapping that means it's an 
                    // opening bracket. Push
                    stack.push(c);
                }
                else if(!stack.empty() && mapping[c]==stack.top()){
                    stack.pop();
                }else{
                    return false;
                }
            }
            return stack.empty();
        }
};
// Runtime: 0ms Beats: 100%