class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> list = new ArrayList<>();
        int value=0;
        for(int i:nums){
         value = (2*value + i)%5;
         list.add(value==0);
        }
        return list;
    }
}
