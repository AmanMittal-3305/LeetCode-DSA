import java.util.*;

public class day3 {

    //Probelem No 03 => Longest Valid Parentheses
    //https://leetcode.com/problems/longest-valid-parentheses/description/
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int maxValidLength = 0;
        st.push(-1);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                st.push(i);
            } else {
                st.pop();
                if (st.isEmpty()) {
                    st.push(i);
                } else {
                    maxValidLength = Math.max(maxValidLength, i - st.peek());
                }
            }
        }
        return maxValidLength;
    }

    //Problem No 02 => Product of Array Except Self
    //https://leetcode.com/problems/product-of-array-except-self/
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int pre[] = new int[n];
        int suff[] = new int[n];
        pre[0] = 1;
        suff[n - 1] = 1;

        for(int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        for(int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] * nums[i + 1];
        }

        int ans[] = new int[n];
        for(int i = 0; i < n; i++) {
            ans[i] = pre[i] * suff[i];
        }
        return ans;
    }
}
