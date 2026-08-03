class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(s.charAt(0) == '0')
            return 0;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(s, 0, dp);
    }

    public int solve(String s, int i, int dp[]){
        if(i == s.length()){
            return 1;
        }
        if(dp[i] != -1)
            return dp[i];
        int valid = 0;
        if(s.charAt(i) != '0')
            valid += solve(s, i + 1, dp);
        if(i + 1 < s.length()){
            int one = s.charAt(i) - '0';
            int two = s.charAt(i + 1) - '0';
            int twoDigitNum = one * 10 + two;
            if(twoDigitNum >= 10 && twoDigitNum <= 26)
                valid += solve(s, i + 2, dp);
        }
        return dp[i] = valid;
    }
}
