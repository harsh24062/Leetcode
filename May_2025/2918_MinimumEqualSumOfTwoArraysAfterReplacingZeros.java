class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1=0;
        int zero1=0;

        long sum2=0;
        int zero2=0;

        for(int i:nums1){
            sum1+=i;
            if(i==0)zero1++;
        }

         for(int i:nums2){
            sum2+=i;
            if(i==0)zero2++;
        }

        if(zero1==0 && zero2==0) return (sum1==sum2)?sum1:-1;

        if(zero1>0 && zero2>0){
            return Math.max(sum1+zero1,sum2+zero2);
        }else if(zero2==0){
          sum1+=zero1;
          if(sum2<sum1)return -1;
          return sum2;
        }

         sum2+=zero2;
          if(sum1<sum2)return -1;
          return sum1;

    }
}
