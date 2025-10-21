class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        // find max element
        int maxE=0;
        for(int i:nums){
            maxE=Math.max(maxE,i);
        }

        int freq[] = new int[maxE+k+1];
        for(int i:nums){
           freq[i]++;
        }
        
        //cumulative sum
        for(int i=1;i<maxE+k+1;i++){
            freq[i]+=freq[i-1];
        }

        int maxFreq=0;
        for(int i=0;i<freq.length;i++){
            // find range

            int leftNum = Math.max(0,i-k);
            int rightNum = Math.min(maxE+k,i+k);
            
            // total element in range
            int total = freq[rightNum] - (leftNum>0?freq[leftNum-1]:0);
            // freq of i (no need to perform on operation in this) 
            int iCount = freq[i] - (i>0?freq[i-1]:0);
            
            // perform operation on other than i (iCount)
            int performed = Math.min(numOperations,total-iCount);
            maxFreq = Math.max(maxFreq,iCount+performed);
        }

        return maxFreq;
    }
}
