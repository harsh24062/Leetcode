class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String,Integer> map=new HashMap<>();
        int ans=0;

       for(int i=dominoes.length-1;i>=0;i--){
        int a = dominoes[i][0];
        int b = dominoes[i][1];

        String s1= a+"."+b;
        String s2= b+"."+a;
        if(map.containsKey(s1)){
         ans+=map.get(s1);
        }

        map.put(s1,map.getOrDefault(s1,0)+1);
       if(!s1.equals(s2)) map.put(s2,map.getOrDefault(s2,0)+1);
       }

        return ans;
    }
}
