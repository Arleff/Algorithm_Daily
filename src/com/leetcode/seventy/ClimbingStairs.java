package com.leetcode.seventy;
/**
 * 
 * @author Jenice
 * #70
 */
public class ClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(climbStairsWay2(45));
		System.out.println(climbStairsWay2(3));
	}
	
	/*
	 * way 1: Brute way
	 */
	private static int climbStairs(int n) {
		
		int[] memo = new int[n+1];
		return clime_stairs(0, n, memo);
	}
	
	private static int clime_stairs(int i, int n, int[] memo) {
		if(i==n) {
			return 1;
		}
		
		if(i>n) {
			return 0;
		}
		
		if(memo[i]>0) {
			return memo[i];
		}
		
		return clime_stairs(i+1, n, memo) +clime_stairs(i+2, n, memo);
	}
	
	/*
	 * way 2
	 */
	private static int climbStairsWay2(int n) {
		if (n == 1) {
			return 1;
		}
		
		int[] dp = new int[n+1];
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i=3; i<= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		return dp[n];
	}

}
