class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int maxVal = Arrays.stream(nums).max().getAsInt() + k;
        Map<Integer,Integer> freq = new HashMap<>();
        TreeMap<Integer,Integer> diffArr = new TreeMap<>();
        
        for(int num:nums){
            freq.put(num,freq.getOrDefault(num,0)+1);

            int leftNum = Math.max(0,num-k);
            int rightNum = Math.min(maxVal,num+k);

            diffArr.put(leftNum,diffArr.getOrDefault(leftNum,0)+1);
            diffArr.put(rightNum+1,diffArr.getOrDefault(rightNum+1,0)-1);

            diffArr.putIfAbsent(num,diffArr.getOrDefault(num,0));
        }

        int ans=0;
        int curSum=0;
        
        for(Map.Entry<Integer,Integer> v:diffArr.entrySet()){
            int key = v.getKey();
            int value = v.getValue();

            int targetFreq = freq.getOrDefault(key,0);
            curSum+=value;

            int convert = Math.min(numOperations,curSum-targetFreq);
            ans = Math.max(ans,targetFreq+convert);
        }

        return ans;
    }
}
