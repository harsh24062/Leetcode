class Solution {
    public int maxFrequencyElements(int[] nums) {
        int arr[] = new int[101];
        int maxFreq=0;
        int count=0;
        
        for(int i:nums){
            arr[i]++;
            if(arr[i]>maxFreq){
                maxFreq=arr[i];
                count=1;
            }else if(arr[i]==maxFreq){
                count++;
            }
        }

        return maxFreq*count;
    }
}
