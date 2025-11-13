class Solution {
    public int maxOperations(String s) {
        int count = 0;
        int ones = 0;
        boolean isZero = false;

        for(char ch:s.toCharArray()){
            if(ch=='0')isZero=true;
            else{
                if(isZero){
                    count+=ones;
                    isZero=false;
                }
                ones++;
            }
        }

        if(isZero){
            count+=ones;
        }

        return count;
    }
}
