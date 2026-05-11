public class LCSRecursive {

    public static void main(String[] args) {

        String S = "WARISHA_SALMAN";
        String T = "ETAOINSHR";

        int n = S.length();
        int m = T.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        StringBuilder lcs = new StringBuilder();

        int i = n, j = m;

        while (i > 0 && j > 0) {

            if (S.charAt(i - 1) == T.charAt(j - 1)) {
                lcs.append(S.charAt(i - 1));
                i--;
                j--;
            }
            else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            }
            else {
                j--;
            }
        }

        System.out.println("LCS Length: " + dp[n][m]);
        System.out.println("LCS: " + lcs.reverse().toString());
    }
}