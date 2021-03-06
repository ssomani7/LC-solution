package com.v.blend.voonsite;

import java.util.*;
/**
 * @author :   Tianyi Tang
 * @date :   Created in 2019-11-14 15:40
 * @leetcode :  https://leetcode.com/problems/combination-sum-iv/
 * @timeComplexity :
 * @spaceComplexity :
 */


public class CombinationSumIV {
    private int[] dp;

    public int combinationSum4(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(nums, target);
    }

    private int helper(int[] nums, int target) {
        if (dp[target] != -1) {
            return dp[target];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += helper(nums, target - nums[i]);
            }
        }
        dp[target] = res;
        return res;
    }

    //recursive
    public int combinationSum42(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += combinationSum42(nums, target - nums[i]);
            }
        }
        return res;
    }
}
