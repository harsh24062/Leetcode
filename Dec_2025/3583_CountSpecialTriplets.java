class Solution {
    int mod = 1000000007;
    public int specialTriplets(int[] nums) {
        Map<Integer,Integer> rightMap = new HashMap<>();

        for(int i:nums)rightMap.put(i,rightMap.getOrDefault(i,0)+1);

        int ans = 0;
        
        Map<Integer,Integer> leftMap = new HashMap<>();

        for(int i:nums){
            rightMap.put(i,rightMap.get(i)-1);
            //if(rightMap.get(i)==0)rightMap.remove(i);
            int ele = (i*2)  ;
            int right = rightMap.getOrDefault(ele,0);
            int left = leftMap.getOrDefault(ele,0);
            leftMap.put(i,leftMap.getOrDefault(i,0)+1);
            long product = ((long)right*left)%mod;
            ans = (int)(ans+product)%mod;
        }
       
        return ans%mod;
    }
}
