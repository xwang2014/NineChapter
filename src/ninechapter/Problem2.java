package ninechapter;

/**
 * http://www.ninechapter.com/problem/2/
 * 
 * @author xin
 *
 */
public class Problem2 {

	/* Solution 1
	 * Think that we divide the array 'books' into k partition
	 * Find the division that the largest partition is smallest
	 * Use divide and conquer 
	 */
	public int solve(int[] books, int k) {
		
		
		
		return 0;
	}
	

	/* Solution 2 Dynamic Programming
	 * Initial k books for k people, then adding books to the lightest person
	 * 
	 * dp[i][j] = min(max(dp[t][j-1],sum(t+1,i))) (j<t<i)
	 */
	public int DP(int[] books, int k) {
		int n = books.length;
		int[][] DP = new int[n + 1][k + 1];
		
		for(int t = 0; t <= k; t++) {
			DP[0][t] = 0;
		}
		for(int t = 1; t <= n; t++) {
			DP[t][1] = DP[t - 1][1] + books[t - 1];
		}
		
		// j people, i books
		for(int j = 2; j <= k; j++)  {
			for(int i = j; i <= n; i++){
				
				int min = Integer.MAX_VALUE;
				for(int t = j - 1; t <= i; t++) {
					min = Math.min(min, Math.max(DP[t][j - 1] , sumBook(t + 1, i, books)));
				}
				
				DP[i][j] = min;
			}
		}

		return DP[n][k];
	}	
	
	private int sumBook(int start, int end, int[] books) {
		if(start > end) return 0;
		
		int sum = 0;
		for(int i = start; i <= end; i++) {
			sum += books[i - 1];
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		int[] books = { 1, 3, 10, 4, 9};
		int k = 4;
		
		Problem2 so = new Problem2();
		int ans = so.DP(books, k);
		System.out.println(ans);
	}

}
