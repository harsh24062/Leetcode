class Solution {
    
    int digits(int num){
        int count=0;
        while(num>0){
         count++;
         num/=10;
        }
        return count;
    }

    public int findNumbers(int[] nums) {
       int ans=0;
       
       for(int i:nums){
        if(digits(i)%2==0)ans++;
       }
        
       return ans; 
    }
}
