class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int ans[]=new int[n];

        int index=0;
        int pivot_Count=0;

       // add less than pivot
        for(int i:nums){
            if(i<pivot){
                ans[index]=i;
                index++;
            }
            else if(i==pivot) pivot_Count++;
        }
        
        //add pivot
        while(pivot_Count>0){
            ans[index]=pivot;
            index++;
            pivot_Count--;
        }

        //add greater
        for(int i:nums){
              if(i>pivot){
                ans[index]=i;
                index++;
            }
        }

        return ans;
    }
}
