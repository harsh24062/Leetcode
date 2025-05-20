class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n =nums.length;
        int mark[]=new int [n+1];

        for(int q[]:queries){
         mark[q[0]]++;
         mark[q[1]+1]--;
        }
       
       int sum=0;
       for(int i=0;i<n;i++){
         sum+=mark[i];
         if(sum<nums[i])return false;
       }

     return true;
    }
}
