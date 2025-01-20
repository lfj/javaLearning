package leetcode;

class Solution {

    public static void main(String[] args) {

    }

    public static String longestPalindrome(String s) {
        if (null == s || s.isEmpty()) {
            return null;
        }
        int size = s.length();
        boolean[][] b = new boolean[size + 1][size + 1];
        b[0][0] = true;
        String maxStr = "";
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j < i; j++) {
                b[i][j] = b[i][j - 1] && s.charAt(i - j) == s.charAt(i + j);
                if (b[i][j] && (2 * j + 1) > maxStr.length()) {
                    maxStr = s.substring(i - j, i + j);
                }
            }
        }
        return maxStr;
    }
}

