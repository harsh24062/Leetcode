class Solution {
    public int numberOfBeams(String[] bank) {
        int ans=0;
        int device=0;

        for(String s:bank){
            // count 1
            int one=0;
            for(char c:s.toCharArray()){
                if(c=='1')one++;
            }
            ans+=one*device;
            if(one!=0)device=one;
        }

        return ans;
    }
}
