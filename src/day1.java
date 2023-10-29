import java.util.*;

public class day1 {
    //Problem NO. 01 => 125. Valid Palindrome
    //https://leetcode.com/problems/valid-palindrome/
    public String removeNonAlphanumeric(String str)
    {
        str = str.replaceAll("[^a-zA-Z0-9]", "");
        return str;
    }
    public boolean isPalindrome(String s) {
        if(s.length() == 0){
            return true;
        }
        s = removeNonAlphanumeric(s);
        int n = s.length();
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i<n; i++){
            sb.append(Character.toLowerCase(s.charAt(i)));
        }
        int left = 0;
        // int right = n-1;
        int mid = s.length()/2;
        while(left != mid){
            if(sb.charAt(left) != sb.charAt(n-left-1)){
                return false;
            }
            left = left+1;
        }
        return true;
    }


    // Problem No. 02 => 67. Add Binary
    //https://leetcode.com/problems/add-binary/
    public static String addBinary(String a, String b) {
        int n1 = a.length();
        int n2 = b.length();
        int maxLength = Math.max(n1, n2);

        // Create StringBuilder objects for a and b with leading zeros.
        StringBuilder sba = new StringBuilder(a);
        while (sba.length() < maxLength) {
            sba.insert(0, '0');
        }

        StringBuilder sbb = new StringBuilder(b);
        while (sbb.length() < maxLength) {
            sbb.insert(0, '0');
        }

        StringBuilder sbc = new StringBuilder();
        int carry = 0;

        for (int i = maxLength - 1; i >= 0; i--) {
            int bitA = sba.charAt(i) - '0';
            int bitB = sbb.charAt(i) - '0';
            int sum = bitA + bitB + carry;
            sbc.insert(0, sum % 2);
            carry = sum / 2;
        }

        if (carry > 0) {
            sbc.insert(0, '1');
        }

        return sbc.toString();
    }



    //Problem No 03 => 14. Longest Common Prefix
    //https://leetcode.com/problems/longest-common-prefix/
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length-1];
        int idx = 0;
        while(idx < s1.length() && idx < s2.length()){
            if(s1.charAt(idx) == s2.charAt(idx)){
                idx++;
            } else {
                break;
            }
        }
        return s1.substring(0, idx);
    }
}