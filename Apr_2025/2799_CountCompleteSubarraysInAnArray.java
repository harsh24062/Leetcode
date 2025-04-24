class Solution {
    public int countCompleteSubarrays(int[] nums) {

        Set<Integer> set=new HashSet<>();
        for(int i:nums)set.add(i);

        int ans=0;
         Set<Integer> set1=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                set1.add(nums[j]);
                if(set1.size()==set.size()){
                    ans+=nums.length-j;
                    break;
                }
            }
            set1.clear();
        }

        return ans;
    }
}



//using hashmap

class Solution {
    public int countCompleteSubarrays(int[] nums) {

        Set<Integer> set=new HashSet<>();
        for(int i:nums)set.add(i);

        int ans=0;
        Map<Integer,Integer> map=new HashMap<>();
        int left=0,right=0;

        while(right<nums.length){
          map.put(nums[right],map.getOrDefault(nums[right],0)+1);
          
          while(map.size()==set.size()){
            ans+=nums.length-right;
            map.put(nums[left],map.get(nums[left])-1);
            if(map.get(nums[left])==0)map.remove(nums[left]);
            left++;
          }
          right++;
        }

        return ans;
    }
}
