import java.util.*;

public class day4 {

    //Problem No 01 => Trapping Rain Water
    //https://leetcode.com/problems/trapping-rain-water/
    public int trap(int[] height) {
        int n = height.length;

        //left max boundary
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for(int i = 1; i<n ; i++){
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }

        //right max boundary
        int[] rightMax = new int[n];
        rightMax[n-1] = height[n-1];
        for(int i = n-2; i >=0; i--){
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        //trapped rainwater
        int trappedRainwater = 0;
        for(int i = 0; i< n ; i++){
            int waterLevel = Math.min(leftMax[i] , rightMax[i]);
            trappedRainwater += waterLevel - height[i];
        }
        return trappedRainwater;
    }

    //Problem No 02 => Search a 2D Matrix
    //https://leetcode.com/problems/search-a-2d-matrix/
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m*n-1;

        while(low <= high) {
            int mid = low + (high-low)/2;

            if(matrix[mid/n][mid%n] == target) return true;
            else if(matrix[mid/n][mid%n] > target) high = mid-1;
            else low = mid+1;
        }

        return false;
    }
}
