class Solution {

    boolean func(int index,int n, int arr[], boolean used[]){
    
       //edge cases
       if(index==arr.length) return true;

       if(arr[index]!=0) return func(index+1,n,arr,used);

       for(int i=n;i>=1;i--){
          if(used[i])continue;

          if(i==1){
            used[1]=true;
            arr[index]=1;
            if(func(index+1,n,arr,used))return true;
            used[1]=false;
            arr[index]=0;
          }

          else if(index+i<arr.length && arr[index+i]==0){
            used[i]=true;
            arr[index]=i;
            arr[i+index]=i;
            if(func(index+1,n,arr,used))return true;
            used[i]=false;
            arr[index]=0;
            arr[i+index]=0;
            
          }
       }

       return false;
    }

    public int[] constructDistancedSequence(int n) {
        
        int ans[]=new int[(n*2)-1];    
        boolean used[]=new boolean[n+1];
        
        func(0,n,ans,used);

        return ans;
    }
}
