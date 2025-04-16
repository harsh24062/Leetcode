class Solution {
    public long countGood(int[] nums, int k) {
        long ans = 0;
        long pairs = 0; // current pairs

        // <num[i],freq>
        Map<Integer,Integer> map=new HashMap<>();
       
        // silinding window
        int left=0,right=0;
        
        while(right<nums.length){
           long oldValue = map.getOrDefault(nums[right],1);
           oldValue--;
           pairs = pairs - ((oldValue+1)*oldValue)/2;
           map.put(nums[right],map.getOrDefault(nums[right],0)+1);
           int newValue = map.get(nums[right]);
           newValue--;
           pairs = pairs + ((newValue+1)*newValue)/2;

            while(pairs>=k){
                ans+=nums.length-right;
                long oldVal = map.get(nums[left]);
                oldVal--;
                pairs = pairs - ((oldVal+1)*oldVal)/2;
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left])==0)map.remove(nums[left]);

                int newVal= map.getOrDefault(nums[left],1);
                newVal--;
                pairs = pairs + ((newVal+1)*newVal)/2;
                left++;
            }
           
           right++;
        }

        return ans;
    }
}


//faster


class Solution {
    public long countGood(int[] nums, int k) {
        long ans = 0;
        long pairs = 0; // current pairs

        // <num[i],freq>
        Map<Integer,Integer> map=new HashMap<>();

        int n= nums.length;
       
        // silinding window
        int left=0,right=0;
        
        while(right<n){
           pairs = pairs + map.getOrDefault(nums[right],0);
           map.put(nums[right],map.getOrDefault(nums[right],0)+1);

            while(pairs>=k){
                ans+=n-right;
               map.put(nums[left],map.get(nums[left])-1);
               pairs = pairs - map.get(nums[left]);
               left++;
            }
           
           right++;
        }

        return ans;
    }
}
