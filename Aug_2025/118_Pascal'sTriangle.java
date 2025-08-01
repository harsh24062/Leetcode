class Solution {
    int combination(int n,int r){
        int res=1; 
        for(int i=0;i<r;i++){
            res=res*(n-i);
            res=res/(i+1);
        }
        return res;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> a=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            for(int j=0;j<=i;j++){
              a.add(combination(i,j));
            }
            list.add(new ArrayList<>(a));
            a.clear();
        }
        return list;
    }
}
