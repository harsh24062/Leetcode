class Solution {
    public int triangleNumber(int[] nums) {

       Arrays.sort(nums);
       int count=0;
       for(int i=0;i<nums.length;i++){
         for(int j=i+1;j<nums.length;j++){
            for(int k=j+1;k<nums.length;k++){
                if(nums[i]+nums[j]>nums[k])count++;
            }
         }
       }


       return count;
    }
}

// binay search
class Solution {
    public int triangleNumber(int[] nums) {
       if(nums.length<3)return 0;
       Arrays.sort(nums);
       int count=0;
       for(int i=0;i<nums.length-2;i++){
         for(int j=i+1;j<nums.length-1;j++){
           // binary search
           int  index = binarySearch(j+1,nums.length-1,nums,nums[i]+nums[j]);
           count+=(index-j);
         }
       }

       return count;
    }

    int binarySearch(int left, int right, int nums[],int target){
        int ans = left-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]<target){ans=mid; left=mid+1;}
            else right=mid-1; 
        }
        return ans;
    }
}




// optimal
class Solution {
    public int triangleNumber(int[] nums) {
        int count=0;
        Arrays.sort(nums);
        for(int k=nums.length-1;k>1;k--){
            int j=k-1;
            int i=0;
            while(i<j){
                if(nums[i]+nums[j]>nums[k]){
                   count+=(j-i);
                   j--;
                }else{
                    i++;
                 }
            }
        }
 
        return count;
    }
}
