class Solution {
    int n,m;
    int BS(int potions[], long success, int spell){

        int low=0,high=m-1;

        while(low<=high){
            int mid = low + (high-low)/2;
            long product = (long)spell*potions[mid];
            if(product>=success)high=mid-1;
            else low = mid+1;
        }
        return m-low; 
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        n = spells.length;
        m = potions.length;

        Arrays.sort(potions);

        int ans[]=new int[n];
        
        for(int i=0;i<n;i++){
            ans[i]=BS(potions,success,spells[i]);
        }

        return ans;
    }
}
