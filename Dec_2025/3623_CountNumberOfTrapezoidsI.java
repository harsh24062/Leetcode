class Solution {
    int Mod = 1000000007;
    public int countTrapezoids(int[][] points) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int p[]:points){
          int axis = p[1];
          map.put(axis,map.getOrDefault(axis,0)+1);
        }

        long result = 0;
        long prev = 0;

        for(int i:map.values()){
          long cur = (long)i*(i-1)/2; // c(n,2) combination
          result = (result + cur*prev)%Mod;
          prev = (prev+cur)%Mod;
        }
       
       return (int)result%Mod;
    } 
}
