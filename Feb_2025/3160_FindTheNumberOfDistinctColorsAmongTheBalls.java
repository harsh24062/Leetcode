class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int ans[]=new int[queries.length];
        
        Map<Integer,Integer> map = new HashMap<>(); //ball - color
        Map<Integer,Integer> colorFreq = new HashMap<>();// color - freq

      for(int i=0;i<queries.length;i++){
        int arr[]=queries[i];

        int ball=arr[0];
        int color=arr[1];

        if(map.containsKey(ball)){
            int curColor=map.get(ball);
            colorFreq.put(curColor,colorFreq.get(curColor)-1);
            if(colorFreq.get(curColor)==0)  colorFreq.remove(curColor);
        }

        map.put(ball,color);
        colorFreq.put(color,colorFreq.getOrDefault(color,0)+1);

        ans[i]=colorFreq.size();
      }

        return ans;
    }
}
