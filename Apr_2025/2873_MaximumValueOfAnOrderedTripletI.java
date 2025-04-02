// O(n*n*n)

class Solution {
    public long maximumTripletValue(int[] nums) {

        int n=nums.length;
        long ans=0;
 
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    long diff=nums[i]-nums[j];
                    diff*=nums[k];
                    ans=Math.max(ans,diff);
                }
            }
        }

        return ans;
    }
}


// O(n)  linear time

class Solution {
    public long maximumTripletValue(int[] nums) {
        
       long ans=0,maxI=0,maxDiff=0;
       
       for(int i:nums){
        ans=Math.max(ans,maxDiff*i);
        maxDiff=Math.max(maxDiff,maxI-i);
        maxI=Math.max(maxI,i);
       }

       return ans;
    }
}


