class Solution {
    public int possibleStringCount(String word) {
        int ans=1;

         char ch[]=word.toCharArray();

         int l=0,r=1;
         while(r<ch.length){
            if(ch[l]!=ch[r]){
             l=r;
            }else{
                ans++;
            }

            r++;
         }

        return ans;
    }
}
