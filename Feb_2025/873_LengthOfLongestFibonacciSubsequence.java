//recursion

class Solution {
    int n;
    Map<Integer,Integer> map;

    int solve(int first,int second,int arr[]){

        int temp=arr[first]+arr[second];
        
        int count=0;
        if(map.containsKey(temp)){
           return 1+ solve(second,map.get(temp),arr);
        }
        return 0;
    }

    public int lenLongestFibSubseq(int[] arr) {
        map=new HashMap<>();
        n=arr.length;

        for(int i=0;i<n;i++){
            map.put(arr[i],i);
        }

        int ans=0;

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int length=solve(i,j,arr);
                if(length+2>2){
                   ans=Math.max(ans,length+2);
                }
            }
        }
        return ans;
    }
}


// memorization
class Solution {
    int n;
    Map<Integer,Integer> map;

    int solve(int first,int second,int arr[],int dp[][]){

        if(dp[first][second]!=0)return dp[first][second];      
        int temp=arr[first]+arr[second];
         
        if(map.containsKey(temp)){
           return dp[first][second]=1+ solve(second,map.get(temp),arr,dp);
        }
        return dp[first][second]=0;
    }

    public int lenLongestFibSubseq(int[] arr) {
        map=new HashMap<>();
        n=arr.length;

        for(int i=0;i<n;i++){
            map.put(arr[i],i);
        }

        int dp[][]=new int[n][n];

        int ans=0;

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int length=solve(i,j,arr,dp);
                if(length+2>2){
                   ans=Math.max(ans,length+2);
                }
            }
        }
        return ans;
    }
}
