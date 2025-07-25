class Solution {
    public int maxSum(int[] nums) {
      int max=Integer.MIN_VALUE;

      int sum=0;
      Set<Integer> set=new HashSet<>();
      for(int i:nums){
        if(i<0)max=Math.max(max,i);
        else if(!set.contains(i)){
            set.add(i);
            sum+=i;
        }
      }

      if(set.size()==0)return max;
      return sum;   
    }
}
