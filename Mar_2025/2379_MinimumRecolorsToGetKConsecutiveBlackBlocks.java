class Solution {
    public int minimumRecolors(String blocks, int k) {
        
        int left=0,right=0;
        int whiteBall=0;
        while(right<k){
          if(blocks.charAt(right)=='W')whiteBall++;
          right++;
        }

        if(whiteBall==0)return 0;
        int curWhiteBall=whiteBall;

        while(right<blocks.length()){
            if(blocks.charAt(right)=='W')curWhiteBall++;
            if(blocks.charAt(left)=='W')curWhiteBall--;
            left++;
            whiteBall=Math.min(whiteBall,curWhiteBall);
            if(whiteBall==0)return 0;
            right++;
        }

        return whiteBall;
    }
}
