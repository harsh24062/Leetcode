class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;

        int ans[]=new int[n];

        // all child must have one candy
        Arrays.fill(ans,1);
        int candy=0;

        // left to right
        for(int i=1;i<n;i++){
          if(ratings[i]>ratings[i-1]) ans[i]=ans[i-1]+1;
        }

        // right to left
        for(int i=n-2;i>=0;i--){
           if(ratings[i]>ratings[i+1] && ans[i]<=ans[i+1]) ans[i]=ans[i+1]+1;
        }

        for(int i:ans)candy+=i;
       
       return candy;
    }
}
