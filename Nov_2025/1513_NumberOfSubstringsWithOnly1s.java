class Solution {
    public int numSub(String s) {
        int count = 0;
        
        int left=0,right=0;
        while(right<s.length()){
            char ch = s.charAt(right);
            if(ch=='0'){
                left=right+1;
            }else{
                count = (count+ (right-left+1))%1000000007;
            }
            right++;
        }

        return count;
    }
}
