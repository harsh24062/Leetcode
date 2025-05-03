class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int a = tops[0];
        int b = bottoms[0];
        int afreq=0,bfreq=0;
        int aTop=0,aBottom=0;
        int bTop=0,bBottom=0;

        for(int i=0;i<tops.length;i++){
            int t=tops[i];
            int bo=bottoms[i];
            
            if(a==t && a==bo){
                afreq++;
            }
            else if(b==t && b==bo){
                bfreq++;
            }

            else{
             if(a==t){
                afreq++;
                aBottom++;
               }
               else if(a==bo){
                afreq++;
                aTop++;
                }

              if(b==t){
                bfreq++;
                bBottom++;
                }
               else if(b==bo){
                bfreq++;
                bTop++;
               }
            }
        }
        
        if(afreq==tops.length) return Math.min(aTop,aBottom);
        if(bfreq==tops.length) return Math.min(bTop,bBottom);

        return -1;
    }
}
