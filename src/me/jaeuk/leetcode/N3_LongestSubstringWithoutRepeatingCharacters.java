package me.jaeuk.leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/add-two-numbers/
public class N3_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.lengthOfLongestSubstring("pwwkew");
        System.out.println("answer : " + answer);
    }


    public static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length();
            int ans = 0;
            for (int i = 0; i < n; i++)
                for (int j = i + 1; j <= n; j++)
                    if (allUnique(s, i, j)) {
                        System.out.println(" true : " + ans + " " + (j - i));
                        ans = Math.max(ans, j - i);
                        System.out.println("ans : " + ans);
                    }
            return ans;
        }

        public boolean allUnique(String s, int start, int end) {
            System.out.println("allUnique == " + s + " " + start + " " + end);
            Set<Character> set = new HashSet<>();
            for (int i = start; i < end; i++) {
                Character ch = s.charAt(i);
                System.out.print(ch + " ");
                if (set.contains(ch)) return false;
                set.add(ch);
            }
            System.out.println();
            System.out.println("======");
            return true;
        }
    }
}
