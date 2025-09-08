class Solution {
    boolean func(int num){
        while(num>0){
            if(num%10==0)return true;
            num/=10;
        }
        return false;
    }
    public int[] getNoZeroIntegers(int n) {
        for(int i=1;i<=n/2;i++){
            int a=i;
            int b=n-i;
            if(func(a)||func(b))continue;
            return new int[]{a,b};
        }
        return new int[]{};
    }
}
