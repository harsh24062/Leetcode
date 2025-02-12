class Solution {

    int findDigitSum(int num){
        int ans=0;
        while(num>0){
            ans+=num%10;
            num = num/10;
        }
        return ans;
    }

    public int maximumSum(int[] nums) {

        // <digit sum,Max nums[i]>
        Map<Integer,Integer> map=new HashMap<>();
        int ans=-1;

       for(int i:nums){
         int digitSum = findDigitSum(i);

         if(map.containsKey(digitSum)){
            ans=Math.max(ans,i+map.get(digitSum));
         }

            if(!map.containsKey(digitSum) || map.get(digitSum)<i) map.put(digitSum,i);
           
       }

        return ans;
    }
}


//optimised
class Solution {

    int findDigitSum(int num){
        int ans=0;
        while(num>0){
            ans+=num%10;
            num = num/10;
        }
        return ans;
    }

    public int maximumSum(int[] nums) {

        int map[] = new int[100];
        int ans=-1;

       for(int i:nums){
         int digitSum = findDigitSum(i);

            if(map[digitSum]>0)
            ans=Math.max(ans,i+map[digitSum]);
         
            if(map[digitSum]<i) map[digitSum]=i;     
       }

        return ans;
    }
}
