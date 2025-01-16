class Solution {
    int xor(int nums[]){
        int x=0;

        for(int i:nums){
            x^=i;
        }
        return x;
    }
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;

        if(n1%2==0 && n2%2==0)return 0;

        if(n1%2==0) return xor(nums1);

        if(n2%2==0) return xor(nums2);

        return xor(nums1)^xor(nums2);
    }
}
