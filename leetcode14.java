import java.util.*;

class leetcode14 {
    public String longestCommonPrefix(String[] v) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(v);
        // While sorting the longest sequence basically comes aranged like fl igt, fl ow, fl ower  Sorting always provides longes sequnce.
        for(int i=0; i<v.length; i++){
            System.out.println(v[i]);
        }
        String first = v[0];
        String last = v[v.length - 1];
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String[] strs = { "flower", "flow", "flight" };
        leetcode14 sol1 = new leetcode14();
        String str_c = sol1.longestCommonPrefix(strs);
        System.out.println(str_c);
    }
}