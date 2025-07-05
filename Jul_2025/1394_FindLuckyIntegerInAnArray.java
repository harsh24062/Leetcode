class Solution {
    public int findLucky(int[] arr) {
        int freq[]=new int[501];
        for(int i:arr){
            freq[i]++;
        }

        for(int i=500;i>=0;i--){
          if(freq[i]>0 && i==freq[i])return i;
        }
        return -1;
    }
}
