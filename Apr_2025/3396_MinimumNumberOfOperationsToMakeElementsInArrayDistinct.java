class Solution {
    public int minimumOperations(int[] nums) {

       int n=nums.length;
       int i=n-1;
       HashSet<Integer> set=new HashSet<>();
       
       while(i>=0){
        set.add(nums[i]);
        if(set.size()!=n-i)break;
        i--;
       }

       int ans=(int)Math.ceil((double)(i+1)/3);

       return ans;
    }
}
