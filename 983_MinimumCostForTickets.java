
class Solution {

    public int mincostTickets(int[] days, int[] costs) {

        Set<Integer> set=new HashSet<>();
        for(int i:days)set.add(i);

        int dp[]=new int[days[days.length-1]+31];

        for(int i=days[days.length-1];i>=0;i--){

           if(!set.contains(i)){
            dp[i]=dp[i+1];
            continue;
           }

           int oneDay=costs[0] + dp[i+1];
           int sevenDay=costs[1] + dp[i+7];;
           int thirtyDay=costs[2] + dp[i+30];
       
         dp[i]= Math.min(oneDay,Math.min(sevenDay,thirtyDay));
        }
        
       return dp[days[0]];
    }
}
