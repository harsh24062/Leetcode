class Solution {
    public int minDeletionSize(String[] strs) {
        
        int len = strs[0].length();

        int LIS[] = new int[len];
        int max=0;
        // LIS
        for(int i=0;i<len;i++){
          LIS[i]=1;
          for(int j=0;j<i;j++){
                boolean check=true;
                //chech all row, should be str[j]<=str[i]
                for(int k=0;k<strs.length;k++){
                    if(strs[k].charAt(i)<strs[k].charAt(j)){
                        check=false;
                        break;
                    }
                }
                if(check) LIS[i]=Math.max(LIS[i],LIS[j]+1);
          }
          max=Math.max(max,LIS[i]);
        }
      return len-max;
    }
}
