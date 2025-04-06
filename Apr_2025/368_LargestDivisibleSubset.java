class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {

        int n=nums.length;
        Arrays.sort(nums);

        int ans=1;
        int index=0;

        int longestSubSet[]=new int[n];
        int indexs[]=new int[n];
        for(int i=0;i<n;i++)indexs[i]=i;

        Arrays.fill(longestSubSet,1);

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
              if(nums[i]%nums[j]==0){
                int len_j=longestSubSet[j]+1;
                if(len_j>longestSubSet[i]){
                    indexs[i]=j;
                    longestSubSet[i]=len_j;
                }
                if(longestSubSet[i]>ans){
                    ans=longestSubSet[i];
                    index=i;
                }
              }
            }
        } 

        List<Integer> list=new ArrayList<>();

        while(index!=indexs[index]){
            list.add(nums[index]);
            index=indexs[index];
        }
        list.add(nums[index]);

       return list;

    }
}
