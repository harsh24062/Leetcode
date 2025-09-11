class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        List<Set<Integer>> list = new ArrayList<>();
        int m = languages.length;
        for(int i=0;i<m;i++){
            Set<Integer> set = new HashSet<>();
            for(int k:languages[i]){
                set.add(k);
            }
            list.add(set);
        }

        Set<Integer> sad = new HashSet<>();
        for(int f[]:friendships){
           int a = f[0]-1;
           int b = f[1]-1;
        
           boolean flag=false;
           Set<Integer> bset = list.get(b);
           for(int i:list.get(a)){
             if(bset.contains(i)){
               flag=true;
               break;
             }
           }
           if(flag)continue;
           sad.add(a);
           sad.add(b);
        }
      
        int lan[] = new int[n+1];
        int max=0;

        for(int i:sad){
            Set<Integer> set = list.get(i);
            for(int k:set){
                lan[k]++;
                max=Math.max(max,lan[k]);
            }
        }
      
      return sad.size()-max; 
    }
}
