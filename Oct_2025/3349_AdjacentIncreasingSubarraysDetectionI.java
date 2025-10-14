
class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int prev = Integer.MIN_VALUE;
        int i=0,j=0;

        while(j<nums.size()){
          if(nums.get(j)<=prev){
            i=j;
          }
          prev=nums.get(j);
          if(j-i+1==k){
            if(j==nums.size()-1 || nums.size()-1-j<k)return false;
            
            boolean flag=true;
            for(int q=2;q<=k;q++){
              if(nums.get(q+j)<=nums.get(j+q-1)){
                flag=false;
                break;
              }
            }
            if(flag)return true;
            i++;
          }
          j++;
        }

        return false; 
    }
}
