class Solution {
    // memorization
    boolean ss(int index,int nums[],int sum,int dp[][]){
        if(sum==0) return true;
        if(index==0) return nums[0]==sum;
        if(dp[index][sum]!=0){
            return (dp[index][sum]==1)?false:true;
        }

        if(nums[index]<=sum){ 
            if(ss(index-1,nums,sum-nums[index],dp)){
            dp[index][sum]=2;    
            return true;}
        }
        if(ss(index-1,nums,sum,dp)){
            dp[index][sum]=2;
            return true;
        }
        dp[index][sum]=1;
        return false;
    }

    public boolean canPartition(int[] nums) {
        int TotalSum=0;
        for(int i:nums)TotalSum+=i;
        if(TotalSum%2!=0)return false;
         int sum=TotalSum/2;
         int dp[][]=new int[nums.length][sum+1];  // 1 -> false  2-> true
        return ss(nums.length-1,nums,sum,dp);
    }
}


// Tabulation


class Solution {
    //tabulation
    public boolean canPartition(int[] nums) {
        int TotalSum=0;
        for(int i:nums)TotalSum+=i;
        if(TotalSum%2!=0)return false;
        int sum=TotalSum/2;
        boolean dp[][]=new boolean[nums.length][sum+1];  

        for(int i=0;i<nums.length;i++)dp[i][0]=true;
        if(nums[0]<=sum)dp[0][nums[0]]=true;
       
        for(int i=1;i<nums.length;i++){
         for(int j=1;j<=sum;j++){
            boolean take=false;
            if(nums[i]<=j)take=dp[i-1][j-nums[i]];
            boolean dontake=dp[i-1][j];
            dp[i][j]=take||dontake;
         }
        }

        return dp[nums.length-1][sum];
    }
}
