class Solution {
    public int minOperations(int[] nums) {
        // brute force

        Set<Integer> set = new HashSet<>();
        for(int i:nums)set.add(i);

        int count=0;

        for(int i:set){
            if(i==0)continue;

            boolean conti=false;
            for(int j=0;j<nums.length;j++){
              if(nums[j]==i){
                if(!conti){
                    count++;
                    conti=true;
                } 
                }else if(nums[j]<i){
                  conti=false;
                }
              }
            } 
        
 
        return count;
    }  
}



// optimal

class Solution {
    public int minOperations(int[] nums) {

        int count = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i:nums){
    
            while(!stack.isEmpty() && stack.peek()>i){
                stack.pop();
            }
            if(stack.isEmpty() || stack.peek()<i){
                if(i!=0){count++;
                stack.push(i);
                }
            }
        }

        return count;
    }
}
