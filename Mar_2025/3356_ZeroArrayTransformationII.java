// giving TLE  on last test case

class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
     
     // using differencr Array Technique

     //edge case  -> check given array nums is already zero Array

     boolean isZero=true;
     for(int i:nums){
        if(i>0){
            isZero=false;
            break;
        }
     } 
     if(isZero)return 0;

       int n=nums.length;

       int arr[]=new int[n+1];

       for(int k=0;k<queries.length;k++){
         
        arr[queries[k][0]]+=queries[k][2];
        arr[queries[k][1]+1]-=queries[k][2];

        boolean zeroArray=true;  //  check nums is zero array or not using cummulative sum of arr
        
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(nums[i]>sum){
                zeroArray=false;
                break;
            }
        }
        if(zeroArray)return k+1;
       }
      return -1;
    }
}


// binary search
class Solution {
       boolean canMakeZeroArray(int k, int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        for (int i = 0; i < k; i++) {
            int left = queries[i][0], right = queries[i][1], val = queries[i][2];
            diff[left] += val;
            diff[right + 1] -= val;
        }
        int currVal = 0;
        for (int i = 0; i < n; i++) {
            currVal += diff[i];
            if (currVal < nums[i]) return false;
        }
        return true;
    }
    public int minZeroArray(int[] nums, int[][] queries) {
     
     // using differencr Array Technique + bimary search

     //edge case  -> check given array nums is already zero Array

     boolean isZero=true;
     for(int i:nums){
        if(i>0){
            isZero=false;
            break;
        }
     } 
     if(isZero)return 0;

     int left = 1, right = queries.length;
        if (!canMakeZeroArray(right, nums, queries)) return -1;

          while (left < right) {
            int mid = left + (right - left) / 2;
            if (canMakeZeroArray(mid, nums, queries)) right = mid;
            else left = mid + 1;
        }
        return left;

      
    }
}




