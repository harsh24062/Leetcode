class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans[] = new int[2];
        int index=0;

        for(int i:nums){
            if(set.contains(i)){
                ans[index]=i;
                index++;
            }
            set.add(i);
        }
        return ans; 
    }
}
